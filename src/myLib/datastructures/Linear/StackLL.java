package myLib.datastructures.Linear;
import myLib.datastructures.nodes.*;

public class StackLL extends SLL {
    private DNode head;
    private int size;

    public int getSize(){
        return this.size;
    }

    public DNode getHead() {
        return head;
    }

    public void setHead(DNode head) {
        this.head = head;
    }

    public StackLL() {
        setHead(null);
        size = 0;
    }

    public StackLL(DNode head) {
        setHead(head);
        size = 0;
    }

    public void push(DNode node) {
        super.insertHead(node);
        size++;
    }

    public DNode pop() {
        if (!isEmpty()) {
            size--;
            DNode returnNode = head;
            super.deleteHead();
            return returnNode;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return getHead() == null;
    }

    public int peek() {
        if (getHead() == null) {
            System.out.println("The stack is empty");
            return -1;
        }
        return getHead().getData();
    }

    @Override
    public void insertTail(DNode node) {
    }

    @Override
    public void insert(DNode node, int position) {
    }

    @Override
    public void sortedInsert(DNode node) {
    }

    @Override
    public void sort() {
    }

    @Override
    public DNode deleteTail() {
        return null;
    }

    @Override
    public DNode delete(int data) {
        return null;
    }

    public int searchStack(int data) {
        DNode current = getHead();
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
}
