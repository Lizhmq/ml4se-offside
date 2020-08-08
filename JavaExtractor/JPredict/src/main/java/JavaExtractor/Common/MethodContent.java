package JavaExtractor.Common;

import java.util.ArrayList;
import com.github.javaparser.ast.Node;

public class MethodContent {
	private ArrayList<Node> leaves;
	private String name;
	private String range;
	private long length;

	public MethodContent(ArrayList<Node> leaves, String name, String range, long length) {
		this.leaves = leaves;
		this.name = name;
		this.range = range;
		this.length = length;
	}

	public ArrayList<Node> getLeaves() {
		return leaves;
	}

	public String getName() {
		return name;
	}

	public String getRange() {
		return range;
	}

	public long getLength() {
		return length;
	}

}
