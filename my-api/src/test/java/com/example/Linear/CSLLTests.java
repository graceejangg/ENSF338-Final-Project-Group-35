package com.example.Linear;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.example.myLib.datastructures.Linear.CSLL;
import com.example.myLib.datastructures.nodes.DNode;

public class CSLLTests {

    @Test
    public void testConstructors() {
        // Default Constructor
        CSLL defaultCsll = new CSLL();
        assertNotNull(defaultCsll);

        // Overloaded Constructor
        CSLL overloadCsll = new CSLL(new DNode(1));
        assertNotNull(overloadCsll);

    }

    @Test
    public void testInsertHead() {
        CSLL csll = new CSLL();
        csll.insertHead(new DNode(1));
        csll.insertHead(new DNode(2));
        csll.insertHead(new DNode(3));
        assertEquals(3, csll.getHead().getData());
        DNode next = csll.getHead().getNext();
        assertEquals(2, next.getData());
        next = next.getNext();
        assertEquals(1, next.getData());
    }

    @Test
    public void testInsertTail() {
        CSLL csll = new CSLL();
        csll.insertTail(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insertTail(new DNode(3));
        assertEquals(1, csll.getHead().getData());
        DNode next = csll.getHead().getNext();
        assertEquals(2, next.getData());
        next = next.getNext();
        assertEquals(3, next.getData());
    }

    @Test
    public void testInsert() {
        CSLL csll = new CSLL();
        csll.insertTail(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insertTail(new DNode(3));
        csll.insert(new DNode(4), 1);
        assertEquals(1, csll.getHead().getData());
        DNode next = csll.getHead().getNext();
        assertEquals(4, next.getData());
        next = next.getNext();
        assertEquals(2, next.getData());
        next = next.getNext();
        assertEquals(3, next.getData());
    }

    @Test
    public void testSortedInsert() {
        CSLL csll = new CSLL();
        csll.insertTail(new DNode(1));
        csll.insertTail(new DNode(3));
        csll.insertTail(new DNode(4));
        csll.sortedInsert(new DNode(2));
        assertEquals(2, csll.getHead().getNext().getData());
    }

    @Test
    public void testSize() {
        CSLL csll = new CSLL();
        assertEquals(0, csll.getSize());
        csll.insertTail(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insertTail(new DNode(3));
        assertEquals(3, csll.getSize());
    }

    @Test
    public void testSort() {
        CSLL csll = new CSLL();
        csll.insertTail(new DNode(3));
        csll.insertTail(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insert(new DNode(4), 1);
        csll.sort();
        assertEquals(1, csll.getHead().getData());
        assertEquals(4, csll.getTail().getData());

    }

    @Test
    public void testIsSorted() {
        CSLL csll = new CSLL();
        csll.insertTail(new DNode(3));
        csll.insertTail(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insert(new DNode(4), 1);
        assertFalse(csll.isSorted());
        csll.sort();
        assertTrue(csll.isSorted());
    }

    @Test
    public void testSearch() {
        CSLL csll = new CSLL();
        csll.insertHead(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insertTail(new DNode(3));
        assertTrue(csll.search(1) != null);
        assertTrue(csll.search(2) != null);
        assertTrue(csll.search(3) != null);
        assertFalse(csll.search(4) != null);
    }

    @Test
    public void testDeleteHead() {
        CSLL csll = new CSLL();
        csll.insertTail(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insertTail(new DNode(3));
        csll.deleteHead();
        assertEquals(2, csll.getHead().getData());
        DNode next = csll.getHead().getNext();
        assertEquals(3, next.getData());
    }

    @Test
    public void testDeleteTail() {
        CSLL csll = new CSLL();
        csll.insertTail(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insertTail(new DNode(3));
        csll.deleteTail();
        assertEquals(1, csll.getHead().getData());
        DNode next = csll.getHead().getNext();
        assertEquals(2, next.getData());
    }

    @Test
    public void testDelete() {
        CSLL csll = new CSLL();
        csll.insertTail(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insertTail(new DNode(3));
        assertEquals(1, csll.delete(1).getData());
        assertEquals(2, csll.getHead().getData());
        DNode next = csll.getHead().getNext();
        assertEquals(3, next.getData());
    }

    @Test
    public void testInvalidDelete() {
        CSLL csll = new CSLL();
        csll.insertTail(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insertTail(new DNode(3));
        assertEquals(null, csll.delete(9));
        assertEquals(1, csll.getHead().getData());
        DNode next = csll.getHead().getNext();
        assertEquals(2, next.getData());
    }

    @Test
    public void testClear() {
        CSLL csll = new CSLL();
        csll.insertHead(new DNode(1));
        csll.insertTail(new DNode(2));
        csll.insertTail(new DNode(3));
        assertEquals(3, csll.getSize());
        csll.clear();
        assertEquals(0, csll.getSize());
        assertFalse(csll.search(1) != null);
        assertFalse(csll.search(2) != null);
        assertFalse(csll.search(3) != null);
    }
}
