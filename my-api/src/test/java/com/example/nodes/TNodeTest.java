package com.example.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.example.myLib.datastructures.nodes.TNode;

public class TNodeTest {
  private TNode node;

  @Before
  public void setUp() {
    node = new TNode(5);
  }

  @Test
  public void testGetValue() {
    assertEquals(5, node.getData());
  }

  @Test
  public void testSetValue() {
    node.setData(10);
    assertEquals(10, node.getData());
  }

  @Test
  public void testGetLeftChild() {
    assertNull(node.getLeft());
  }

  @Test
  public void testSetLeftChild() {
    TNode leftChild = new TNode(3);
    node.setLeft(leftChild);
    assertEquals(leftChild, node.getLeft());
  }

  @Test
  public void testGetRightChild() {
    assertNull(node.getRight());
  }

  @Test
  public void testSetRightChild() {
    TNode rightChild = new TNode(7);
    node.setRight(rightChild);
    assertEquals(rightChild, node.getRight());
  }

  // Test main function for other tests
 
  // public static void main(String[] args) {
  //   TNode node = new TNode(5);

  //   System.out.println("Initial node value: " + node.getData());

  //   node.setLeft(new TNode(3));
  //   node.setRight(new TNode(7));

  //   System.out.println("Node left child value: " + node.getLeft().getData());
  //   System.out.println("Node right child value: " + node.getRight().getData());

  //   node.setData(10);

  //   System.out.println("Updated node value: " + node.getData());

  //   System.out.println("Original node balance: "+node.getBalance());
  //   node.setBalance(5);
  //   System.out.println("Updated node balance: "+node.getBalance());

  //   System.out.println("****TEST PRINT****");
  //   node.print();

  // }

}
