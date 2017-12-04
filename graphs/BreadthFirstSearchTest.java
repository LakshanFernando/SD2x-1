package Homeworks.SD2x.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BreadthFirstSearchTest {
    BreadthFirstSearch BFS;
    DirectedGraph dg;
    UndirectedGraph ug;
    String filename;

    @Before
    public void setUp() throws Exception {
        filename = "submissions/Homeworks/SD2x/graphs/test_files/graph_builder_test.txt";
        dg = GraphBuilder.buildDirectedGraph(filename);
        ug = GraphBuilder.buildUndirectedGraph(filename);
    }

    @Test
    public void bfs() {
        BFS = new BreadthFirstSearch(dg);
        assertTrue(BFS.bfs(dg.getNode("0"), "4"));
        BFS = new BreadthFirstSearch(dg);
        assertTrue(BFS.bfs(dg.getNode("0"), "5"));
        BFS = new BreadthFirstSearch(dg);
        assertTrue(BFS.bfs(dg.getNode("0"), "6"));
        BFS = new BreadthFirstSearch(dg);
        assertFalse(BFS.bfs(dg.getNode("0"), "8"));

        BFS = new BreadthFirstSearch(ug);
        assertTrue(BFS.bfs(ug.getNode("0"), "4"));
        BFS = new BreadthFirstSearch(ug);
        assertTrue(BFS.bfs(ug.getNode("0"), "5"));
        BFS = new BreadthFirstSearch(ug);
        assertTrue(BFS.bfs(ug.getNode("0"), "6"));
        BFS = new BreadthFirstSearch(ug);
        assertFalse(BFS.bfs(ug.getNode("0"), "8"));
    }

    @Test
    public void getDistance() {
        BFS = new BreadthFirstSearch(ug);
        BFS.bfs(ug.getNode("2"), "5");
        assertEquals(1, BFS.getDistance());

        BFS = new BreadthFirstSearch(ug);
        BFS.bfs(ug.getNode("0"), "6");
        assertEquals(3, BFS.getDistance());
    }
}