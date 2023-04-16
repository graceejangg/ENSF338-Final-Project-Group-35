package com.example.nodes;

import com.example.myLib.datastructures.nodes.DNode;

import static org.junit.Assert.*;
import org.junit.*;

public class DNodeTest {
  DNode node;

  @Before
  public void setUp() {
    node = new DNode(10);
  }

  @Test
  public void testGetValue() {
    assertEquals(10, node.getData());
  }

  @Test
  public void testSetValue() {
    node.setData(15);
    assertEquals(15, node.getData());
  }

  @Test
  public void testGetPrev() {
    assertNull(node.getPrevious());
  }

  @Test
  public void testSetPrev() {
    DNode prevNode = new DNode(20);
    node.setPrevious(prevNode);
    assertEquals(prevNode, node.getPrevious());
  }

  @Test
  public void testGetNext() {
    assertNull(node.getNext());
  }

  @Test
  public void testSetNext() {
    DNode nextNode = new DNode(25);
    node.setNext(nextNode);
    assertEquals(nextNode, node.getNext());
  }

  // public static void main(String[] args) {
  // DNode node1 = new DNode(1);
  // DNode node2 = new DNode(2);

  // node1.setNext(node2);
  // node2.setPrevious(node1);

  // System.out.println("Node 1 value: " + node1.getData());
  // System.out.println("Node 2 value: " + node2.getData());
  // System.out.println("Node 1 next value: " + node1.getNext().getData());
  // System.out.println("Node 2 previous value: " +
  // node2.getPrevious().getData());

  // node2.setData(3);

  // System.out.println("Updated node 2 value: " + node2.getData());

  // System.out.println("****TEST PRINT****");
  // System.out.println("node1: "+node1);
  // System.out.println("node2:"+ node1);

  // }
}
