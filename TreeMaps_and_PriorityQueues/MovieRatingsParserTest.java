package Homeworks.SD2x.TreeMaps_and_PriorityQueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;

public class MovieRatingsParserTest {
    private UserMovieRating umr_1 = new UserMovieRating("umr_1", 1);
    private UserMovieRating umr_2 = new UserMovieRating("umr_2", 2);
    private UserMovieRating umr_2_a = new UserMovieRating("UMR_2", 2);
    private UserMovieRating umr_3 = new UserMovieRating("Umr_3", 3);
    private UserMovieRating umr_empty_name = new UserMovieRating("", 4);
    private UserMovieRating umr_null = null;
    private ArrayList<UserMovieRating> allRatings = new ArrayList<>();

    @Before
    public void setUp() {
        allRatings.add(umr_1);
        allRatings.add(umr_2);
        allRatings.add(umr_3);
        allRatings.add(umr_2_a);
        allRatings.add(umr_empty_name);
        allRatings.add(umr_null);
    }

    @Test
    public void parseMovieRatings() {
        TreeMap<String, PriorityQueue<Integer>> expectedRatingsMap = new TreeMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(umr_1.getUserRating());
        expectedRatingsMap.put(umr_1.getMovie().toLowerCase(), new PriorityQueue<>(pq));
        pq.clear();
        pq.add(umr_2.getUserRating());
        pq.add(umr_2.getUserRating());
        expectedRatingsMap.put(umr_2.getMovie().toLowerCase(), new PriorityQueue<>(pq));
        pq.clear();
        pq.add(umr_3.getUserRating());
        expectedRatingsMap.put(umr_3.getMovie().toLowerCase(), new PriorityQueue<>(pq));

        TreeMap<String, PriorityQueue<Integer>> actualRatingsMap = MovieRatingsParser.parseMovieRatings(allRatings);

        assertEquals(expectedRatingsMap.toString(), actualRatingsMap.toString());
    }
}