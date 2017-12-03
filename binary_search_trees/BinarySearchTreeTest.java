package Homeworks.SD2x.binary_search_trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst_tens = new BinarySearchTree<>();
    private BinarySearchTree<Integer> bst_ones = new BinarySearchTree<>();
    private BinarySearchTree<Integer> bst_mixed = new BinarySearchTree<>();

    @Before
    public void setUp() {
        bst_tens.add(50);
        bst_tens.add(70);
        bst_tens.add(80);
        bst_tens.add(60);
        bst_tens.add(20);
        bst_tens.add(40);
        bst_tens.add(30);
        bst_tens.add(10);
        bst_tens.add(100);
        bst_tens.add(110);
        bst_tens.add(90);
    }

    @Test
    public void findNode() {
        assertEquals(10, bst_tens.findNode(10).value, 0);
        assertEquals(null, bst_tens.findNode(15));
    }

    @Test
    public void depth() {
        assertEquals(0, bst_tens.depth(50));
        assertEquals(2, bst_tens.depth(10));
        assertEquals(3, bst_tens.depth(30));
        assertEquals(-1, bst_tens.depth(45));
    }

    @Test
    public void height() {
        assertEquals(4, bst_tens.height(50));
        assertEquals(2, bst_tens.height(20));
        assertEquals(0, bst_tens.height(30));
        assertEquals(0, bst_tens.height(60));
        assertEquals(-1, bst_tens.height(200));
    }

    @Test
    public void isBalanced() {
        BinarySearchTree<Integer>.Node eighty = bst_tens.findNode(80);
        BinarySearchTree<Integer>.Node twenty = bst_tens.findNode(20);
        assertFalse(bst_tens.isBalanced(eighty));
        assertTrue(bst_tens.isBalanced(twenty));
    }

    @Test
    public void isBalanced1() {
        bst_ones.add(2);
        bst_ones.add(1);
        bst_ones.add(3);
        assertTrue(bst_ones.isBalanced());
        assertFalse(bst_tens.isBalanced());


        bst_mixed.add(5);
        bst_mixed.add(7);
        bst_mixed.add(8);
        bst_mixed.add(6);
        bst_mixed.add(3);
        bst_mixed.add(4);
        bst_mixed.add(1);
        assertTrue(bst_mixed.isBalanced());
    }
}