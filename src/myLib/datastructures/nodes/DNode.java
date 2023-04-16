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
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPrevious() {
        return previous;
    }

    public void setPrevious(DNode previous) {
        this.previous = previous;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if (getNext() == null) {
            return getData() + "";
        }
        return getData() + ", ";
    }
    
}