package myLib.datastructures.nodes;

public class DNode {
    private DNode next;
    private DNode previous;
    private int data;

    // Constructor
    public DNode(int data) {
        setNext(null);
        setPrevious(null);
        setData(data);
    }

    public DNode getNext() {
        return this.next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(DNode previous) {
        this.previous = previous;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Value: " + getData();
    }
}