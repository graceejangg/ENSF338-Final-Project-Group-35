package com.example.Linear;

import org.junit.Test;

import com.example.myLib.datastructures.Linear.DLL;
import com.example.myLib.datastructures.nodes.DNode;

import static org.junit.Assert.*;

public class DLLTests {
    @Test
    public void testConstructors() {
        // Default constructor test
        DLL defaultDll = new DLL();
        assertTrue(defaultDll.getSize() == 0 && defaultDll.getHead() == null);

        // Overloaded constructor test
        DLL overloadDll = new DLL(new DNode(1));
        assertTrue(overloadDll.getSize() == 1 && overloadDll.getHead().getData() == 1);
    }

    @Test
    public void testGetAndSet() {

    }

    @Test
    public void testInsertHead() {
        DLL dll = new DLL();
        dll.insertHead(new DNode(1));
        dll.insertHead(new DNode(2));
        dll.insertHead(new DNode(3));
        assertEquals(3, dll.getHead().getData());
        assertEquals(1, dll.getTail().getData());
    }

    @Test
    public void testInsertTail() {
        DLL dll = new DLL();
        dll.insertTail(new DNode(1));
        dll.insertTail(new DNode(2));
        dll.insertTail(new DNode(3));
        assertEquals(1, dll.getHead().getData());
        assertEquals(3, dll.getTail().getData());
    }

    @Test
    public void testInsert() {
        DLL dll = new DLL();
        dll.insertTail(new DNode(1));
        dll.insertTail(new DNode(2));
        dll.insertTail(new DNode(3));
        dll.insert(new DNode(4), 1);
        assertEquals(4, dll.getHead().getNext().getData());
    }

    @Test
    public void testSortedInsert() {
        DLL dll = new DLL();
        dll.insertHead(new DNode(0));
        dll.insertTail(new DNode(2));
        dll.insertTail(new DNode(4));
        dll.sortedInsert(new DNode(3));

        assertTrue(dll.getTail().getPrevious().getData() == 3);
    }

    @Test
    public void testDeleteHead() {
        DLL dll = new DLL();
        dll.insertHead(new DNode(1));
        dll.insertHead(new DNode(2));
        dll.insertHead(new DNode(3));
        assertEquals(3, dll.deleteHead().getData());
        assertEquals(2, dll.getHead().getData());
        assertEquals(1, dll.getTail().getData());
    }

    @Test
    public void testDeleteTail() {
        DLL dll = new DLL();
        dll.insertHead(new DNode(1));
        dll.insertHead(new DNode(2));
        dll.insertHead(new DNode(3));
        assertEquals(3, dll.getHead().getData());
        assertEquals(1, dll.deleteTail().getData());
        assertEquals(2, dll.getTail().getData());
    }

    @Test
    public void testDelete() {
        DLL dll = new DLL();
        dll.insertHead(new DNode(1));
        dll.insertHead(new DNode(2));
        dll.insertHead(new DNode(3));
        assertEquals(1, dll.delete(1).getData());
        assertEquals(3, dll.getHead().getData());
        assertEquals(2, dll.getTail().getData());
    }

    @Test
    public void testInvalidDelete() {
        DLL dll = new DLL();
        dll.insertHead(new DNode(1));
        dll.insertHead(new DNode(2));
        dll.insertHead(new DNode(3));
        assertEquals(null, dll.delete(9));
        assertEquals(3, dll.getHead().getData());
        assertEquals(1, dll.getTail().getData());
    }

    @Test
    public void testSize() {
        DLL dll = new DLL();
        dll.insertHead(new DNode(1));
        dll.insertHead(new DNode(2));
        dll.insertHead(new DNode(3));
        assertEquals(3, dll.getSize());
    }

    @Test
    public void testClear() {
        DLL dll = new DLL();
        dll.insertTail(new DNode(1));
        dll.insertTail(new DNode(2));
        dll.insertTail(new DNode(3));
        dll.clear();
        assertEquals(0, dll.getSize());
        assertEquals(null, dll.getHead());
    }

    @Test
    public void testSort() {
        DLL dll = new DLL();
        dll.insertTail(new DNode(3));
        dll.insertTail(new DNode(1));
        dll.insertTail(new DNode(2));
        dll.insertTail(new DNode(5));
        dll.insertTail(new DNode(0));
        dll.sort();
        assertEquals(0, dll.getHead().getData());
        assertEquals(5, dll.getTail().getData());

    }

}
