# Homework 5 - TreeMaps and PriorityQueues
In this assignment you will implement methods that process movie ratings, using the java.util.TreeMap and java.util.PriorityQueue classes from the Java Collections API.

In completing this assignment, you will:

- Become familiar with the methods in the java.util.TreeMap and java.util.PriorityQueue classes
- Apply what you have learned about how trees and heaps store data
- Demonstrate that you can use trees and heaps to solve data-related problems

## Getting Started
Download [UserMovieRating.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/d80cae28282f07654bee2fa3f6cc4371/asset-v1:PennX+SD2x+2T2017+type@asset+block/UserMovieRating.java), which defines a class representing a single rating of a movie and contains two attributes: movie (the title of the movie) and userRating (an anonymous user rating of the movie). You should not change this implementation for your solution.

Also download the [MovieRatingsParser.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/6a1765d33d191737d964dc2d8593fc2d/asset-v1:PennX+SD2x+2T2017+type@asset+block/MovieRatingsParser.java) and [MovieRatingsProcessor.java](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/b5f45b2b486cae4be9eea058c3c6754f/asset-v1:PennX+SD2x+2T2017+type@asset+block/MovieRatingsProcessor.java) files, which contain the unimplemented methods for the code that you will write in this assignment.

## Activity
### Part 1: Converting List to Map
In **MovieRatingsParser.java**, implement the **parseMovieRatings** method, which takes a List of UserMovieRatings as input and creates a TreeMap data structure from it. The TreeMap is a mapping from the movie’s title to a PriorityQueue of all its associated ratings.

Keep in mind that the same movie title may appear numerous times in the input List, and multiple instances may even have the same rating.

A distinct movie title should only appear once as a key in the TreeMap, however, and be mapped to a PriorityQueue (min-heap) of all the ratings for that movie.

Your implementation of _parseMovieRatings_ should also adhere to the following:

- If the input List is null or empty, _parseMovieRatings_ should return an empty TreeMap
- If the input List contains any null _UserMovieRatings_ object, or a _UserMovieRatings_ object whose movie title is null or an empty string, or a UserMovieRatings object whose rating is negative, _parseMovieRatings_ should ignore that UserMovieRatings object
- The movie titles should be considered case-insensitive, i.e. if two _UserMovieRatings_ objects have the same title that differ only in case (upper or lower), they should be considered the same movie. The movie titles stored in the TreeMap must use lowercase letters.

Please do not change the signature of the _parseMovieRatings_ method and please do not modify _UserMovieRatings.java_. Also, please do not create any additional .java files for your solution. If you need additional classes, you can define them in _MovieRatingsParser.java_. Last, please be sure that your _MovieRatingsParser_ class is in the default package, i.e. there is no “package” declaration at the top of the source code.

### Part 2: Using the Map
Now implement the following methods in **MovieRatingsProcessor.java**. All methods take as input a TreeMap that maps movie titles to a PriorityQueue of their ratings, in addition to any inputs specified:

- **getAlphabeticalMovies:** return a List of movie titles in alphabetical order
- **getAlphabeticalMoviesAboveRating:** given an input int **rating**, return a List of movie titles in alphabetical order, where all movies in the List do not have any ratings less than or equal to **rating** (hint: the PriorityQueue is a min-heap, meaning that the smallest rating is at the front of the queue!)
- **removeAllRatingsBelow:** given an input int **rating**, modify the TreeMap object that was passed as an argument so that you remove all ratings in the PriorityQueue that are below (but not equal to) **rating** for every movie in the Map. If all ratings are removed from a movie’s PriorityQueue, then remove the mapping from the TreeMap. Additionally, this method should return a new TreeMap that maps a movie title to the number of ratings that were removed from its corresponding PriorityQueue; the TreeMap that is returned should only contain movies that had ratings removed from its PriorityQueue.

In all cases, the methods should also adhere to the following:

- If the input is null or an empty TreeMap, the data structure returned by the method should be empty
You can assume that all movie titles in the input TreeMap consist of lowercase letters.