package Homeworks.SD2x.TreeMaps_and_PriorityQueues;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.List;

import static org.junit.Assert.*;

public class MovieRatingsProcessorTest {
    private UserMovieRating aaa = new UserMovieRating("aaa", 1);
    private UserMovieRating aaa_2 = new UserMovieRating("aaa", 2);
    private UserMovieRating aaa_3 = new UserMovieRating("aaa", 3);
    private UserMovieRating bbb = new UserMovieRating("bbb", 2);
    private UserMovieRating bbb_3 = new UserMovieRating("bbb", 3);
    private UserMovieRating ccc = new UserMovieRating("ccc", 3);
    private UserMovieRating ddd = new UserMovieRating("ddd", 4);
    private UserMovieRating eee = new UserMovieRating("eee", 5);
    private ArrayList<UserMovieRating> allRatings = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        allRatings.add(aaa);
        allRatings.add(aaa_2);
        allRatings.add(aaa_3);
        allRatings.add(ccc);
        allRatings.add(bbb);
        allRatings.add(bbb_3);
        allRatings.add(eee);
        allRatings.add(ddd);
    }

    @Test
    public void getAlphabeticalMovies() {
        ArrayList<String> actualList = new ArrayList<>(MovieRatingsProcessor.getAlphabeticalMovies(null));
        assertEquals(new ArrayList<>(), actualList);

        actualList = new ArrayList<>(MovieRatingsProcessor.getAlphabeticalMovies(new TreeMap<>()));
        assertEquals(new ArrayList<>(), actualList);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("aaa");
        expectedList.add("bbb");
        expectedList.add("ccc");
        expectedList.add("ddd");
        expectedList.add("eee");

        TreeMap<String, PriorityQueue<Integer>> actualRatingsMap = MovieRatingsParser.parseMovieRatings(allRatings);
        actualList = new ArrayList<>(MovieRatingsProcessor.getAlphabeticalMovies(actualRatingsMap));
        assertEquals(expectedList, actualList);
    }

    @Test
    public void getAlphabeticalMoviesAboveRating() {
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("ddd");
        expectedList.add("eee");
        TreeMap<String, PriorityQueue<Integer>> actualRatingsMap = MovieRatingsParser.parseMovieRatings(allRatings);
        ArrayList<String> actualList = new ArrayList<>(MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(actualRatingsMap, 3));
        assertEquals(expectedList, actualList);
    }

    @Test
    public void removeAllRatingsBelow() {
        TreeMap<String, Integer> expectedMap = new TreeMap<>();
        expectedMap.put("aaa", 3);
        expectedMap.put("bbb", 2);
        expectedMap.put("ccc", 1);
        TreeMap<String, PriorityQueue<Integer>> actualRatingsMap = MovieRatingsParser.parseMovieRatings(allRatings);
        TreeMap<String, Integer> actualMap = new TreeMap<>(MovieRatingsProcessor.removeAllRatingsBelow(actualRatingsMap, 4));
        assertEquals(expectedMap, actualMap);

    }
}