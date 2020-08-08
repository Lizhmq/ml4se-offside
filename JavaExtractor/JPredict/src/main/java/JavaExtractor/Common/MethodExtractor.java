package JavaExtractor.Common;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseProblemException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;

import JavaExtractor.FeatureExtractor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MethodExtractor {

    public MethodExtractor() {}

    private CompilationUnit parseCode(String code) {
        final String classPrefix = "public class Test {";
        final String classSuffix = "}";
        final String methodPrefix = "SomeUnknownReturnType f() {";
        final String methodSuffix = "return noSuchReturnValue; }";

        String originalContent = code;
        String content = originalContent;
        CompilationUnit parsedClass = null;
        try {
            parsedClass = JavaParser.parse(content);
        } catch (ParseProblemException e1) {
            // Wrap with a class and method
            try {
                content = classPrefix + methodPrefix + originalContent + methodSuffix + classSuffix;
                parsedClass = JavaParser.parse(content);
            } catch (ParseProblemException e2) {
                // Wrap with a class only
                content = classPrefix + originalContent + classSuffix;
                parsedClass = JavaParser.parse(content);
            }
        }
        return parsedClass;
    }

    public List<MethodDeclaration> extractMethodsFromCode(String code) {
        List<MethodDeclaration> methodDeclarations = new ArrayList<>();

        CompilationUnit compilationUnit = parseCode(code);
        List<MethodDeclaration> extractedMethods = extractMethodsFromClass(compilationUnit);

        // split class methods to class with only one method
        for (MethodDeclaration method: extractedMethods) {
            CompilationUnit unit = parseCode(method.toString());
            methodDeclarations.addAll(extractMethodsFromClass(unit));
        }

        return methodDeclarations;
    }

    private List<MethodDeclaration> extractMethodsFromClass(CompilationUnit parsedClass) {
        return parsedClass.getNodesByType(MethodDeclaration.class).stream()
                .filter(SearchUtils::containsBinaryWithOffByOne)
                .collect(Collectors.toList());
    }
}