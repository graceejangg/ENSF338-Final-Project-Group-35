package myLib.datastructures.Linear;
import myLib.datastructures.nodes.DNode;

public class QueueLL {
  protected DNode head;
  protected DNode tail;
  protected int size;
  

  public DNode getHead() {
    return head;
  }

  public void setHead(DNode head) {
    this.head = head;
  }

  public DNode getTail() {
    return tail;
  }

  public void setTail(DNode tail) {
    this.tail = tail;
  }

  public QueueLL() {
    setHead(null);
    setTail(null);
    size = 0;
  }

  public QueueLL(DNode head, DNode tail) {
    setHead(head);
    setTail(tail);
    size = 0;
  }

  public void enqueue(DNode node) {
    if (head == null) {
      head = tail = node;
    } else {
      tail.setNext(node);
      tail = node;
    }
    size++;
  }

  public void dequeue() {
    if (head == null) {
      System.out.println("The queue is empty");
      return;
    }
    head = head.getNext();
    if (head == null) {
      tail = null;
    }
    size--;
  }

  public DNode peek() {
    if (head == null) {
      System.out.println("The Queue is empty");
      return null;
    }
    return head;
  }


  public int searchQueue(int data) {
    DNode current = head;
    int count = 0;
    while (current != null && current.getData() != data) {
      current = current.getNext();
      count++;
    }
    if (current != null && current.getData() == data) {
      return count;
    } else {
      return -1;
    }
  }

  public void print() {
    if (head == null) {
      System.out.println("The queue is empty");
    } else {
      DNode current = head;
      int count = 0;
      System.out.print("Queue: ");
      while (current != null) {
        System.out.print(current.getData() + " ");
        current = current.getNext();
        count++;
      }
      System.out.println();
      System.out.println("Size: " + count);
    }
  }

  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }
}
