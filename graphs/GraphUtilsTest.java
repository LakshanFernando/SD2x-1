package Homeworks.SD2x.graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GraphUtilsTest {
    BreadthFirstSearch BFS;
    DirectedGraph dg;
    UndirectedGraph ug;
    String filename;

    @Before
    public void setUp() {
        filename = "submissions/Homeworks/SD2x/graphs/test_files/graph_builder_test.txt";
        dg = GraphBuilder.buildDirectedGraph(filename);
        ug = GraphBuilder.buildUndirectedGraph(filename);
    }

    @Test
    public void minDistance() {
        int actualDistance = GraphUtils.minDistance(dg, "0", "6");
        assertEquals(3, actualDistance);

        actualDistance = GraphUtils.minDistance(ug, "0", "6");
        assertEquals(3, actualDistance);

        actualDistance = GraphUtils.minDistance(null, "0", "6");
        assertEquals(-1, actualDistance);

        actualDistance = GraphUtils.minDistance(dg, "null", "6");
        assertEquals(-1, actualDistance);

        actualDistance = GraphUtils.minDistance(dg, "0", "null");
        assertEquals(-1, actualDistance);

        actualDistance = GraphUtils.minDistance(dg, " ", "6");
        assertEquals(-1, actualDistance);

        actualDistance = GraphUtils.minDistance(dg, "0", " ");
        assertEquals(-1, actualDistance);

        actualDistance = GraphUtils.minDistance(dg, "12", "6");
        assertEquals(-1, actualDistance);

        actualDistance = GraphUtils.minDistance(ug, "0", "13");
        assertEquals(-1, actualDistance);

        actualDistance = GraphUtils.minDistance(ug, "0", "8");
        assertEquals(-1, actualDistance);
    }

    @Test
    public void nodesWithinDistance() {
        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("1");
        expectedSet.add("2");
        expectedSet.add("3");
        expectedSet.add("5");
        Set<String> actualSet = GraphUtils.nodesWithinDistance(ug, "0", 1);
        assertEquals(expectedSet, actualSet);

        actualSet = GraphUtils.nodesWithinDistance(dg, "0", 1);
        assertEquals(expectedSet, actualSet);

        actualSet = GraphUtils.nodesWithinDistance(dg, "0", 0);
        assertEquals(null, actualSet);
    }

    @Test
    public void isHamiltonianPath() {
        List<String> path_1 = new ArrayList<>(Arrays.asList("0", "1", "5", "0"));
        assertTrue(GraphUtils.isHamiltonianPath(ug, path_1));
        assertFalse(GraphUtils.isHamiltonianPath(dg, path_1));

        List<String> path_2 = new ArrayList<>(Arrays.asList("0", "5", "7"));
        assertFalse(GraphUtils.isHamiltonianPath(ug, path_2));

        List<String> path_3 = new ArrayList<>(Arrays.asList("1", "2", "4", "5", "1"));
        assertTrue(GraphUtils.isHamiltonianPath(ug, path_3));

        List<String> path_4 = new ArrayList<>(Arrays.asList("1", "2", "4", "5", "2", "1"));
        assertFalse(GraphUtils.isHamiltonianPath(ug, path_4));

        List<String> path_5 = new ArrayList<>(Arrays.asList("1", "2", "4", "5", "2", "10", "1"));
        assertFalse(GraphUtils.isHamiltonianPath(ug, path_5));

        List<String> path_6 = new ArrayList<>(Arrays.asList("1", "2", "4", "5", "2", "1"));
        assertFalse(GraphUtils.isHamiltonianPath(null, path_6));

        assertFalse(GraphUtils.isHamiltonianPath(dg, null));

        List<String> path_7 = new ArrayList<>();
        assertFalse(GraphUtils.isHamiltonianPath(ug, path_7));

    }
}