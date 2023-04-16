package com.example.Linear;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.myLib.datastructures.Linear.QueueLL;
import com.example.myLib.datastructures.nodes.DNode;

public class QueueLLTests {
    private QueueLL queue;

    @Before
    public void setUp() {
        queue = new QueueLL();
    }


    @Test
    public void testEnqueue() {
        queue.enqueue(new DNode(1));
        queue.enqueue(new DNode(2));
        queue.enqueue(new DNode(3));
        assertEquals(1, queue.peek().getData());
        
    }

    @Test
    public void testDequeue() {
        queue.enqueue(new DNode(1));
        queue.enqueue(new DNode(2));
        queue.enqueue(new DNode(3));
        queue.dequeue();
        assertEquals(2, queue.peek().getData());
        assertEquals(2, queue.getSize());
    }

    @Test
    public void testFront() {
        queue.enqueue(new DNode(1));
        queue.enqueue(new DNode(2));
        queue.enqueue(new DNode(3));
        assertEquals(1, queue.peek().getData());
    }

    @Test
    public void testFrontOnEmptyQueue() {
        assertEquals(null,queue.peek());
    } 
}
