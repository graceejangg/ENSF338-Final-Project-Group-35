package com.example.Linear;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.myLib.datastructures.Linear.SLL;
import com.example.myLib.datastructures.nodes.DNode;

public class SLLTests {
    @Test
    public void testOverloadConstructor() {
        SLL normalSll = new SLL();
        normalSll.insertHead(new DNode(1));

        SLL overloadedSll = new SLL(new DNode(1));

        assertTrue(normalSll.getHead().getData() == overloadedSll.getHead().getData());
    }

    @Test
    public void testInsertHead() {
        SLL sll = new SLL();
        sll.insertHead(new DNode(1));
        sll.insertHead(new DNode(2));
        sll.insertHead(new DNode(3));
        assertEquals(3, sll.getHead().getData());
        DNode next = sll.getHead().getNext();
        assertEquals(2, next.getData());
        next = next.getNext();
        assertEquals(1, next.getData());
    }

    @Test
    public void testInsertTail() {
        SLL sll = new SLL();
        sll.insertTail(new DNode(1));
        sll.insertTail(new DNode(2));
        sll.insertTail(new DNode(3));
        assertEquals(1, sll.getHead().getData());
        DNode next = sll.getHead().getNext();
        assertEquals(2, next.getData());
        next = next.getNext();
        assertEquals(3, next.getData());
    }

    @Test
    public void testInsert() {
        SLL sll = new SLL();
        sll.insertTail(new DNode(1));
        sll.insertTail(new DNode(2));
        sll.insertTail(new DNode(3));
        sll.insert(new DNode(4), 1);
        assertEquals(1, sll.getHead().getData());
        DNode next = sll.getHead().getNext();
        assertEquals(4, next.getData());
        next = next.getNext();
        assertEquals(2, next.getData());
        next = next.getNext();
        assertEquals(3, next.getData());
    }

    @Test
    public void testSortedInsert() {
        SLL sll = new SLL();
        sll.insertTail(new DNode(1));
        sll.insertTail(new DNode(2));
        sll.insertTail(new DNode(3));
        sll.sortedInsert(new DNode(4));
        assertEquals(1, sll.getHead().getData());
        DNode next = sll.getHead().getNext();
        assertEquals(2, next.getData());
        next = next.getNext();
        assertEquals(3, next.getData());
        next = next.getNext();
        assertEquals(4, next.getData());
    }

    @Test
    public void testDeleteHead() {
        SLL sll = new SLL();
        sll.insertTail(new DNode(1));
        sll.insertTail(new DNode(2));
        sll.insertTail(new DNode(3));
        sll.deleteHead();
        assertEquals(2, sll.getHead().getData());
        DNode next = sll.getHead().getNext();
        assertEquals(3, next.getData());
    }

    @Test
    public void testDeleteTail() {
        SLL sll = new SLL();
        sll.insertTail(new DNode(1));
        sll.insertTail(new DNode(2));
        sll.insertTail(new DNode(3));
        sll.deleteTail();
        assertEquals(1, sll.getHead().getData());
        DNode next = sll.getHead().getNext();
        assertEquals(2, next.getData());
    }

    @Test
    public void testDelete() {
        SLL sll = new SLL();
        sll.insertTail(new DNode(1));
        sll.insertTail(new DNode(2));
        sll.insertTail(new DNode(3));
        assertEquals(1, sll.delete(1).getData());
        assertEquals(2, sll.getHead().getData());
        DNode next = sll.getHead().getNext();
        assertEquals(3, next.getData());
    }

    @Test
    public void testInvalidDelete() {
        SLL sll = new SLL();
        sll.insertTail(new DNode(1));
        sll.insertTail(new DNode(2));
        sll.insertTail(new DNode(3));
        assertEquals(null, sll.delete(9));
        assertEquals(1, sll.getHead().getData());
        DNode next = sll.getHead().getNext();
        assertEquals(2, next.getData());
    }

    @Test
    public void testSize() {
        SLL sll = new SLL();
        assertEquals(0, sll.getSize());
        sll.insertHead(new DNode(1));
        assertEquals(1, sll.getSize());
        sll.insertTail(new DNode(2));
        assertEquals(2, sll.getSize());
        sll.insertTail(new DNode(3));
        assertEquals(3, sll.getSize());
        sll.delete(1);
        assertEquals(2, sll.getSize());
    }

    @Test
    public void testSearch() {
        SLL sll = new SLL();
        sll.insertHead(new DNode(1));
        sll.insertTail(new DNode(2));
        sll.insertTail(new DNode(3));
        assertTrue(sll.search(1) != null);
        assertTrue(sll.search(2) != null);
        assertTrue(sll.search(3) != null);
        assertFalse(sll.search(4) != null);
    }

    @Test
    public void testClear() {
        SLL sll = new SLL();
        sll.insertHead(new DNode(1));
        sll.insertTail(new DNode(2));
        sll.insertTail(new DNode(3));
        assertEquals(3, sll.getSize());
        sll.clear();
        assertEquals(0, sll.getSize());
        assertFalse(sll.search(1) != null);
        assertFalse(sll.search(2) != null);
        assertFalse(sll.search(3) != null);
    }

    @Test
    public void testSort() {
        SLL sll = new SLL(new DNode(1));
        sll.insertHead(new DNode(3));
        sll.insertTail(new DNode(2));
        sll.sort();
        assertTrue(sll.getHead().getData() == 1);
        DNode next = sll.getHead().getNext();
        assertTrue(next.getData() == 2);
        next = next.getNext();
        assertTrue(next.getData() == 3);
    }

    @Test
    public void testIsSorted() {
        SLL sll = new SLL(new DNode(1));
        sll.insertHead(new DNode(3));
        sll.insertTail(new DNode(2));
        assertFalse("isSorted returned true when false was expected", sll.isSorted());
        sll.sort();
        assertTrue("isSorted returned false when true was expected", sll.isSorted());
    }

}
