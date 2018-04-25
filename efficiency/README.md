# Homework 11 - Efficiency

In this assignment, you are asked to improve the execution time of a Java program that attempts to detect plagiarism in a corpus of documents.

In completing this assignment, you will:

- Apply the techniques discussed in the lessons to improve the efficiency of code
- Get more experience understanding and modifying existing code
- Enhance your understanding of the behavior and efficiency of various data structures

## Background

Plagiarism detection is a very difficult problem to solve, but a simple approach is to just look for common words and phrases between documents. If two (or more) documents contain many of the same phrases, then there is a good possibility that one author copied from the other.

The program you will improve detects common phrases of size `windowSize `in a corpus of documents, and then report pairs of documents for which the number of common phrases is greater than some `threshold`, sorted by the number of common phrases.

## Getting Started

Download the [PlagiarismDetector.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/ccc00ac39a42a47c6b62c66331d12139/asset-v1:PennX+SD2x+2T2017+type@asset+block/PlagiarismDetector.java) source code.

The `detectPlagiarism`method takes the name of the directory containing the corpus of documents, as well as the `windowSize` and `threshold` parameters, and returns a Map that lists the pairs of documents, with the Map keys sorted by the number of matches. If two or more pairs have the same number of matches, the order in which they are stored is not specified.

Aside from the `detectPlagiarism` method, the `PlagiarismDetector` also has helper methods to:

- Read a file and store its contents in a List of Strings
- Create the distinct phrases, each of which is of size `windowSize`
- Find the common phrases between two documents
- Sort the results
There is also a `main` method that you can use to run the `detectPlagiarism` method (be sure to specify the directory containing the corpus), which then reports the execution time in seconds. Note that this measures the “wall clock” or actual elapsed time, and not the time that the program is actually running on the CPU, but assuming you are the only person using the computer, and there are not too many other processes running in the background, it should give you a good idea of the execution time of the code.

You can, of course, create your own corpus as you modify this program, but we will evaluate the performance of your program using the corpus we provided in [corpus.zip](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/d25bdf1bf147f97722800ae3e617913e/asset-v1:PennX+SD2x+2T2017+type@asset+block/corpus.zip) with `windowSize` of 4 and `threshold` of 5.

A modified version of this problem (and the corpus of documents) was originally used at the University of Chicago and presented as a Nifty Assignment at SIGCSE 2008 [(http://nifty.stanford.edu/2008/franke-catch-plagiarists/)](http://nifty.stanford.edu/2008/franke-catch-plagiarists/), and the implementation was modified by the PennX instruction staff. We will assume that this implementation is correct for our purposes.

## Activity

Your goal in this assignment is to improve the execution time of the `detectPlagiarism` method and the methods it uses, using the various techniques seen in the lessons.

In particular, you should consider:

- Does the code use the correct data structures? If it’s using a List, maybe it should use a Set, or the other way around
- Does the code use efficient algorithms? Perhaps there are quicker ways to accomplish the same things
- Does the code do unnecessary work? Perhaps some code can be rewritten or even removed if it is doing work that’s already been done

Keep in mind that you are asked to focus only on improving the execution time of the code. It is okay if your changes have a negative effect on things like memory usage or other aspects of quality, _except_ for correctness, of course: your changes must not change the output of the code!

Please do not change the signature of the `detectPlagiarism` method. You may, however, modify or even remove any of the other methods as you see fit, as long as the code still works correctly. Likewise, you may add new methods or classes, though if you add new classes, please add them to `PlagiarismDetector.java` and do not create new .java files. Please be sure that your `PlagiarismDetector` class is in the default package (i.e., that there is no "package" declaration at the top), and -- perhaps this goes without saying -- please implement all code in Java. :-)

In making changes to the code, you may **not** assume that:

- The program will always use the same set of documents that was provided to you, so you cannot pre-compute results
- The number and size of documents in the corpus will always be the same as the one that was provided to you, so you cannot hardcode values
- The `windowSize` and `threshold` will always have the values specified above
- The code is always executed on a multi-core/multi-processor machine, so you can’t know for certain that using threads will help

In some cases, you may need to make a decision that is somewhat dictated by the input, e.g. it may be better to use one data structure for small window sizes and a different one for large ones. In such cases, choose the one that works best for the input values specified above since that is what we will use to measure the execution time of your code.