package com.example.Linear;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.example.myLib.datastructures.Linear.StackLL;
import com.example.myLib.datastructures.nodes.DNode;

public class StackLLTests {
    @Test
    public void testOverloadConstructor() {
        StackLL normalSll = new StackLL();
        normalSll.insertHead(new DNode(1));

        StackLL overloadedSll = new StackLL(new DNode(1));

        assertTrue(normalSll.getHead().getData() == overloadedSll.getHead().getData());
    }

    @Test
    public void testInsertHead() {
        StackLL sll = new StackLL();
        sll.insertHead(new DNode(1));
        sll.insertHead(new DNode(2));
        sll.insertHead(new DNode(3));
        assertEquals(3, sll.getHead().getData());
        DNode next = sll.getHead().getNext();
        assertEquals(2, next.getData());
        next = next.getNext();
        assertEquals(1, next.getData());
    }

    private StackLL stack;

    @Before
    public void setUp() {
        stack = new StackLL();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(new DNode(1));
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.getSize());
        stack.push(new DNode(1));
        stack.push(new DNode(2));
        stack.push(new DNode(3));
        assertEquals(3, stack.getSize());
        stack.pop();
        assertEquals(2, stack.getSize());
    }

    @Test
    public void testPushAndPeek() {
        stack.push(new DNode(1));
        stack.push(new DNode(2));
        stack.push(new DNode(3));
        assertEquals(3, stack.peek());
        stack.push(new DNode(4));
        assertEquals(4, stack.peek());
    }

    @Test
    public void testPop() {
        stack.push(new DNode(1));
        stack.push(new DNode(2));
        stack.push(new DNode(3));
        assertEquals(3, stack.pop().getData());
        assertEquals(2, stack.pop().getData());
        assertTrue(stack.isEmpty());
        assertEquals(null, stack.pop());
    }


}
