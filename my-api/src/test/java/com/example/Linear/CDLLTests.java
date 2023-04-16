package com.example.Linear;

import org.junit.Test;

import com.example.myLib.datastructures.Linear.CDLL;
import com.example.myLib.datastructures.nodes.DNode;

import static org.junit.Assert.*;

public class CDLLTests {

    @Test
    public void testConstructors() {
        // Default constructor test
        CDLL defaultCdll = new CDLL();
        assertTrue(defaultCdll.getSize() == 0 && defaultCdll.getHead() == null);

        // Overloaded constructor test
        CDLL overloadCdll = new CDLL(new DNode(1));
        assertTrue(overloadCdll.getSize() == 1 && overloadCdll.getHead().getData() == 1);
    }

    @Test
    public void testGetAndSet() {

    }

    @Test
    public void testInsertHead() {
        CDLL cdll = new CDLL();
        cdll.insertHead(new DNode(1));
        cdll.insertHead(new DNode(2));
        cdll.insertHead(new DNode(3));
        assertEquals(3, cdll.getHead().getData());
        assertEquals(1, cdll.getTail().getData());
    }

    @Test
    public void testInsertTail() {
        CDLL cdll = new CDLL();
        cdll.insertTail(new DNode(1));
        cdll.insertTail(new DNode(2));
        cdll.insertTail(new DNode(3));
        assertEquals(1, cdll.getHead().getData());
        assertEquals(3, cdll.getTail().getData());
    }

    @Test
    public void testInsert() {
        CDLL cdll = new CDLL();
        cdll.insertTail(new DNode(1));
        cdll.insertTail(new DNode(2));
        cdll.insertTail(new DNode(3));
        cdll.insert(new DNode(4), 1);
        assertEquals(4, cdll.getHead().getNext().getData());
    }

    @Test
    public void testSortedInsert() {
        CDLL cdll = new CDLL();
        cdll.insertHead(new DNode(0));
        cdll.insertTail(new DNode(2));
        cdll.insertTail(new DNode(3));
        cdll.insertTail(new DNode(4));
        cdll.sort();
        assertEquals(3, cdll.getTail().getPrevious().getData());
    }

    @Test
    public void testDeleteHead() {
        CDLL cdll = new CDLL();
        cdll.insertHead(new DNode(1));
        cdll.insertHead(new DNode(2));
        cdll.insertHead(new DNode(3));
        assertEquals(3, cdll.deleteHead().getData());
        assertEquals(2, cdll.getHead().getData());
        assertEquals(1, cdll.getTail().getData());
    }

    @Test
    public void testDeleteTail() {
        CDLL cdll = new CDLL();
        cdll.insertHead(new DNode(1));
        cdll.insertHead(new DNode(2));
        cdll.insertHead(new DNode(3));
        assertEquals(3, cdll.getHead().getData());
        assertEquals(1, cdll.deleteTail().getData());
        assertEquals(2, cdll.getTail().getData());
    }

    @Test
    public void testDelete() {
        CDLL cdll = new CDLL();
        cdll.insertHead(new DNode(1));
        cdll.insertHead(new DNode(2));
        cdll.insertHead(new DNode(3));
        assertEquals(1, cdll.delete(1).getData());
        assertEquals(3, cdll.getHead().getData());
        assertEquals(2, cdll.getTail().getData());
    }

    @Test
    public void testInvalidDelete() {
        CDLL cdll = new CDLL();
        cdll.insertHead(new DNode(1));
        cdll.insertHead(new DNode(2));
        cdll.insertHead(new DNode(3));
        assertEquals(null, cdll.delete(9));
        assertEquals(3, cdll.getHead().getData());
        assertEquals(1, cdll.getTail().getData());
    }

    @Test
    public void testSize() {
        CDLL cdll = new CDLL();
        cdll.insertHead(new DNode(1));
        cdll.insertHead(new DNode(2));
        cdll.insertHead(new DNode(3));
        assertEquals(3, cdll.getSize());
    }

    @Test
    public void testClear() {
        CDLL cdll = new CDLL();
        cdll.insertTail(new DNode(1));
        cdll.insertTail(new DNode(2));
        cdll.insertTail(new DNode(3));
        cdll.clear();
        assertEquals(0, cdll.getSize());
        assertEquals(null, cdll.getHead());
    }

    @Test
    public void testSort() {
        CDLL cdll = new CDLL();
        cdll.insertTail(new DNode(3));
        cdll.insertTail(new DNode(1));
        cdll.insertTail(new DNode(2));
        cdll.insertTail(new DNode(5));
        cdll.insertTail(new DNode(0));
        cdll.sort();
        assertEquals(0, cdll.getHead().getData());
        assertEquals(5, cdll.getTail().getData());

    }

}
