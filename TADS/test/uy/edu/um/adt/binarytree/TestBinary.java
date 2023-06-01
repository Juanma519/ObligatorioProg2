package uy.edu.um.adt.binarytree;
import static org.junit.Assert.*;
import org.junit.Test;
import uy.edu.um.adt.BinaryTree.BinarySearchTreeImpl;
import uy.edu.um.adt.BinaryTree.BinarySearchTree;;
import uy.edu.um.adt.LinkedList.MyList;

import java.util.ArrayList;

public class TestBinary {

    @Test
    public void testAddFlujoNormal() {
        BinarySearchTree<Integer, Integer> oTree = new BinarySearchTreeImpl<>();

        oTree.add(3, 3);
        oTree.add(21, 21);
        oTree.add(11, 11);
        oTree.add(2, 2);
        oTree.add(4, 4);
        oTree.add(18, 18);

        ArrayList<Integer> colValues = oTree.inOrder();

        assertEquals(new Integer(2), colValues.get(0));
        assertEquals(new Integer(3), colValues.get(1));
        assertEquals(new Integer(4), colValues.get(2));
        assertEquals(new Integer(11), colValues.get(3));
        assertEquals(new Integer(18), colValues.get(4));
        assertEquals(new Integer(21), colValues.get(5));
    }

    @Test
    public void testRemoveFlujoNormal() {
        BinarySearchTree<Integer, Integer> oTree = new BinarySearchTreeImpl<>();

        oTree.add(3, 3);
        oTree.add(21, 21);
        oTree.add(11, 11);
        oTree.add(-1, -1);
        oTree.add(4, 4);
        oTree.add(18, 18);

        oTree.remove(3);
        oTree.remove(-1);
        oTree.remove(18);

        ArrayList<Integer> colValues = oTree.inOrder();

        assertEquals(new Integer(4), colValues.get(0));
        assertEquals(new Integer(11), colValues.get(1));
        assertEquals(new Integer(21), colValues.get(2));
    }

    @Test
    public void testRemoveFlujoParticular() {
        BinarySearchTree<Integer, Integer> oTree = new BinarySearchTreeImpl<>();

        oTree.add(3, 3);
        oTree.add(-1, -1);
        oTree.add(4, 4);
        oTree.add(18, 18);

        oTree.remove(3);
        oTree.remove(-1);
        oTree.remove(18);
        oTree.remove(4);

        ArrayList<Integer> colValues = oTree.inOrder();

        assertEquals(0, colValues.size());
    }

    @Test
    public void testFindFlujoNormal() {
        BinarySearchTree<Integer, Integer> oTree = new BinarySearchTreeImpl<>();

        oTree.add(3, 3);
        oTree.add(21, 21);
        oTree.add(11, 11);
        oTree.add(-1, -1);
        oTree.add(4, 4);
        oTree.add(18, 18);

        oTree.remove(3);
        oTree.remove(-1);
        oTree.remove(18);

        Integer oTemp = oTree.find(3);

        assertNull(oTemp);

        oTemp = oTree.find(21);

        assertEquals(new Integer(21), oTemp);

    }

    @Test
    public void testContainFlujoNormal() {
        BinarySearchTree<Integer, Integer> oTree = new BinarySearchTreeImpl<>();

        oTree.add(3, 3);
        oTree.add(21, 21);
        oTree.add(11, 11);
        oTree.add(-1, -1);
        oTree.add(4, 4);
        oTree.add(18, 18);

        assertFalse(oTree.contains(33));
        assertTrue(oTree.contains(-1));
    }

}

