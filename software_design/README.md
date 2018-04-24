# Homework 8 - Software Design

In this assignment, you are asked to implement a program that allows a user to search through a collection of books and find books written by a specific author or the number of books written in a specified year. You will implement this program using the three-tier architecture discussed in recent lessons.

In completing this assignment, you will:

- Apply what you have learned about software architecture, software design, and internal quality
- Consider the tradeoffs of software design, especially the input and output of methods, as it relates to software quality

## Getting Started

Download the following files:

- [PresentationTier.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/b3bdb95be609f5c1678d8363b2b3c4c3/asset-v1:PennX+SD2x+2T2017+type@asset+block/PresentationTier.java): the class that represents the “presentation tier,” which handles interaction with the user
- [LogicTier.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/b25a2e36fd2515dc9f55ad4f5e13c42b/asset-v1:PennX+SD2x+2T2017+type@asset+block/LogicTier.java): the class that represents the “logic tier,” which includes processing and performing computations on data
- [DataTier.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/48b3ae1488d657452b72c391aed4e1b4/asset-v1:PennX+SD2x+2T2017+type@asset+block/DataTier.java): the class that represents the “data tier,” which handles reading data from some source and making it available to the rest of the program
- [Book.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/6b20ddfb2f185b8cf7853ccd2eaa8136/asset-v1:PennX+SD2x+2T2017+type@asset+block/Book.java): represents a single book in our program
- [Main.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/9a318177978962d3fbf9e4e6e2ad0b94/asset-v1:PennX+SD2x+2T2017+type@asset+block/Main.java): responsible for instantiating the objects and setting up their relations

Also download [books.txt](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/3571071f5880d95a9e4dc8fb2263cd25/asset-v1:PennX+SD2x+2T2017+type@asset+block/books.txt), which contains a list of popular books in tab-separated format. Each row represents one book and has the following format:

```
[title][tab][author][tab][year]
```

You may use your own list of books for testing your application as you implement it, but the correctness of your solution will be determined using the file we provide.

## Activity

This program is perhaps not difficult to implement but the challenge here is applying good software design principles (modularity, functional independence, and abstraction) in order to create code that has high internal quality: changeability, stability, understandability, and testability. 

In particular, you need to apply the three-tier architecture, which we will simplify by saying that each tier only has one class. Your goal is to put the right functionality into the right tiers/classes, decide on method inputs and outputs, and then implement the code.

In practice, there may be some flexibility as to whether certain functionality goes into a single method or multiple methods, what the names of the methods would be, etc. And you generally would have multiple classes per tier, and not just a single class.

In order to simplify the automatic grading of this assignment, in this case the application you implement must have the following methods:
- **findBookTitlesByAuthor:** for a given name, search through all of the books and return the titles of those books whose author name includes the input name.
- **findNumberOfBooksInYear:** for a given year, search through all of the books and return the number of books published in that year
- **getAllBooks:** read the data file containing information about the books, create Book objects for each, and then return the Book objects.
- **showBookTitlesByAuthor:** using the command-line (i.e., reading from System.in), ask the user to enter part or all of an author’s name, then display (using System.out) the titles of those books whose author name includes the input name.
- **showNumberOfBooksInYear:** using the command-line (i.e., reading from System.in), ask the user to enter a year, then display (using System.out) the number of books published in that year

Both _findBookTitlesByAuthor_ and _showBookTitlesByAuthor_ should look for partial matches and should ignore case, i.e. be case-insensitive. The titles of the books that are returned/displayed should be sorted based on the year they were published in non-descending order; if two or more books have the same publication year, those books should be sorted alphabetically.

For each of the five methods, you need to decide:

- In which class (_PresentationTier_, _LogicTier_, or _DataTier_) should it be implemented?
- What should its input parameter(s) be?
- What should its return type be?

In addition to considering modularity and functional independence in applying the three-tier architecture, be sure to also consider abstraction when designing each method: the caller of a method should be able to use it knowing only what it does, and not the details of how it works.

Once you have completed your design, implement each of the five methods according to the specifications above.

In all cases, you can handle error conditions in any way you choose, e.g. if the user enters a year that is non-numeric in _showBookTitlesByAuthor_, if the name specified in _findBookTitlesByAuthor_ is null, etc. Just be sure your code works correctly for “normal” inputs.

Likewise, it is okay for _getAllBooks_ to assume that the input file exists and is well-formatted.

You can use any prompt you choose for asking for input in _showBookTitlesByAuthor_ and _showNumberOfBooksInYear_, and can likewise choose any output formatting you like.

Finally, implement _PresentationTier_.start so that it asks the user which feature they would like to use and invokes the appropriate methods in the appropriate classes. Once the output has been displayed, the program should terminate. As above, you can handle error cases in any way that you deem appropriate.

Please be sure that your code adheres to the following guidelines and restrictions:

- Each method listed above must go into exactly one of the three classes (_PresentationTier_, _LogicTier_, or _DataTier_).
- Do not add any other classes, though you may add additional fields and methods as necessary.
- Do not change the _Book_ class or _Main_ class.
- All methods must be public.
- All code should be in the default package, i.e. there should be no “package” declaration at the top of the source code.
