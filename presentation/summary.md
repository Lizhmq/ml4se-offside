# Paper discussion: Structured Neural Summarization

#### Paper

* Appeared in _(name of conf/journ)_
* Cited _citation cound_
* Why is it important?

#### People
_A brief profile of the main authors_

#### Motivation
_Why do this research?_

#### Research method
_What does the paper do?_

#### ML4SE techniques used
_How does the paper use ML techniques_

#### Results
_What does the paper find?_

#### Implications
_Why are the results important?_

#### Techincal questions
How are the nodes of the graph embedded?
Why can this encoder be used with any decoder?
What does the coverage mechanism do?

#### Discussion points
Why didn't the authors also try a decoder with coverage? Is it too hard to implement? Would the results improve a lot?
How would this approach perform compared to code2vec or code2seq?
Why is there such a big difference between Java and C# (Statistical values are much higher for the C# dataset)?
Are structural annotations worth it or are they over-engineering?
Could a ConvNet-Sequence hybrid model work as an alternative to Graph-Sequence?
Would the removal of coreferencing make the results much worse?


#### Summary of the discussion
Mostly technical details of the paper with Miltiadis. We discussed how GNNs work, the effect of using coverage mechanisms and finally how the structure of the graph is used to generate an input for the RNN.
We also discussed that the reason for the difference in results for Java and C# was that the C# dataset was originally generated by another research group who put considerable effort into generating more informative graphs whereas the graph for the Java dataset were generating by the authors who did not focus as much on generating as detailed graphs.
Using coverage will considerably slow down the training of the model since it complicates the output generation. When used it is often only used in the later stages of training, for fine-tuning of the model. This would've complicated the training process and was therefore skipped.
Embeddings would probably improve the results, however that raises the question of "which embedding to use?" There are no widely accepted embeddings for code and different embeddings will have slightly different effects on the final outcome. Researching different embeddings was mentioned as a possible future (or current) research area.




# Paper discussion: Summarizing Source Code using a Neural Attention Model

#### Paper

* Appeared in _(name of conf/journ)_
* Cited _citation cound_
* Why is it important?

#### People
_A brief profile of the main authors_

#### Motivation
_Why do this research?_

#### Research method
_What does the paper do?_

#### ML4SE techniques used
_How does the paper use ML techniques_

#### Results
_What does the paper find?_

#### Implications
_Why are the results important?_

#### Techincal questions
_3-4 questions to gauge the audience's understanding of the paper_

#### Discussion points
_3-4 questions to trigger general discussions about the paper_

#### Summary of the discussion
A short summary of Beam search. A specific note from Miltiadis that using log-probabilities is preferred to using normal probabilities since with normal probabilities you have a higher risk of at some point reaching a probability of 0 and then you are stuck.
A discussion about the size/complexity of the model. Generally having a smaller/simpler model is better, especially if the model is able to acheive comparable results to a more complicated one. However, the size of the dataset must also be taken into account, applying a complicated model to a small dataset will lead the model to simply memorizing the features of that dataset.
We also discussed the concept of "size" of a Machine Learning model, the concept of parameters and how many parameters there are in a model. A parameter is essentially anything that changes as the model learns.
The reason for discarding rare tokens was discussed, this was probably done to avoid overfitting on the rare tokens. The exact threshold value of 3 was not really addressed.
Their comparison to Allamanis's model was discussed, and that model was focused on the Code to Language problem which explains why the results for that problem were within the margin of error whereas the scores for the Language to Code problem were vastly different.
We discussed the problem of data collection. In this paper the approach used is quite restrictive, only using the title of the question and accepted answers with a single code tag. There were no definitive answers, this is a difficult problem. One mention was made that the type of problems on StackOverflow tend to be simple to medium complexity and the more complex problems are usually answered with multiple code tags and so the dataset probably only contains simple problems.
One downside of using StackOverflow is that duplicate questions are not allowed/closed and so there is usually not more than one example of each question which may have some impact on learning.
This paper was at its time a leading paper in the field but today it would be considered a bachelor thesis. The field is moving very quickly and we need to move quickly as well.