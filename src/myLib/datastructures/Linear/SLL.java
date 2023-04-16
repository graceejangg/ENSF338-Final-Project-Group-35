package myLib.datastructures.Linear;

import myLib.datastructures.nodes.*;


public class SLL {
    private DNode head;
    private int size;
    private DNode sorted;

    public void setHead(DNode head) {
        this.head = head;
    }

    public DNode getHead() {
        return head;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public DNode getSorted() {
        return sorted;
    }

    public void setSorted(DNode sorted) {
        this.sorted = sorted;
    }

    public DNode getTailPointer() {
        return null;
    }
    
    public SLL() {
        setHead(null);
        setSize(0);
    }

    public SLL(DNode head) {
        setHead(head);
        setSize(0);
    }

    
    public void insertHead(DNode node) {
        if (getHead() != null) {
            node.setNext(getHead());
            setHead(node);
        } else {
            setHead(node);
        }
        setSize(getSize() + 1);

    }

    
    public void insertTail(DNode node) {
        if (getHead() != null) {
            DNode now = getHead();
            while (now.getNext() != getTailPointer()) {
                now = now.getNext();
            }
            now.setNext(node);
        } else {
            setHead(node);
            
        }
        setSize(getSize() + 1);
    }

    public void sort() {

        DNode now = getHead();
        setSorted(null);
        while (now != null) {
            DNode tempoary = now.getNext();
            if (getSorted() == null || getSorted().getData() >= now.getData()) {
                now.setNext(getSorted());
                setSorted(now);
            } else {
                DNode sortednow = getSorted();
                while (sortednow.getNext() != null && sortednow.getNext().getData() < now.getData()) {
                    sortednow = sortednow.getNext();
                }
                now.setNext(sortednow.getNext());
                sortednow.setNext(now);
            }
            now = tempoary;
        }
        setHead(getSorted());
        
    }
    

    
    public void insert(DNode node, int position) {
        if (position < 0 || position > getSize()) {
            throw new IndexOutOfBoundsException("Position is invalid at: " + position);
        }
        
        DNode now = getHead();
        int count = 0;
        setSize(getSize() + 1);
        
        if (now == null || position == 0) {
            insertHead(node);
            setSize(getSize() - 1);
            return;
        }
        
        while (now.getNext() != null && count < position - 1) {
            now = now.getNext();
            count++;
        }
        
        if (now.getNext() == null) {
            insertTail(node);
            setSize(getSize() - 1);
        } else {
            node.setNext(now.getNext());
            now.getNext().setPrevious(node);
            node.setPrevious(now);
            now.setNext(node);
        }
    }
    
    

   
    public void sortedInsert(DNode node) {

        DNode now = getHead();
        if (isSorted() == false) {
            sort();
        }

        if (now == null) {
            insertHead(node);
            setSize(getSize() - 1);
        }

        else if (getHead().getData() >= node.getData()) {
            insertHead(node);
            setSize(getSize() - 1);
        }

        else if (getterLastNodes().getData() < node.getData()) {
            insertTail(node);
            setSize(getSize() - 1);
        } else {
            now = getHead();
            while (now.getNext() != getTailPointer() && now.getData() != node.getData()
                    && now.getNext().getData() < node.getData()) {
                now = now.getNext();
            }
            node.setNext(now.getNext());
            now.setNext(node);
        }
        setSize(getSize() + 1);
    }

    
    
    public boolean isSorted() {
        DNode now = getHead();
        while (now != null && now.getNext() != getTailPointer()) {
            if (now.getData() > now.getNext().getData()) {
                return false;
            }
            now = now.getNext();
        }
        return true;
    }
    
    public DNode search(int data) {
        DNode now = getHead();
        while (now != null) {
            if (now.getData() == data) {
                return now;
            }
            now = now.getNext();
        }
        return null;
    }
    
    public DNode deleteHead() {
        if (getHead() == null) {
            System.out.println("List is empty, cannot delete");
            return null;
        }
        DNode deletedNode = getHead();
        if (getSize() == 1) {
            setHead(null);
        } else {
            setHead(deletedNode.getNext());
            deletedNode.getNext().setPrevious(null);
        }
        setSize(getSize() - 1);
        deletedNode.setNext(null);
        return deletedNode;
    }
    

    
    public DNode deleteTail() {
        if (getHead() == null) {
            System.out.println("List is empty, cannot delete");
            return null;
        }
        DNode now = getHead();
        DNode previous = null;
        setSize(getSize() - 1);
        while (now.getNext() != null) {
            previous = now;
            now = now.getNext();
        }
        if (previous == null) {
            setHead(null);
        } else {
            previous.setNext(null);
        }
        return now;
    }
    

    
    public DNode delete(int data) {
        DNode now = getHead();
        DNode previous = null;
        setSize(getSize() - 1);
        if (now != null && now.getData() == data) {
            setSize(getSize() + 1);
            return deleteHead();
        }
        while (now != null && now.getData() != data) {
            previous = now;
            now = now.getNext();
        }
        if (now == null) {
            setSize(getSize() + 1);
            System.out.println("Value not found in list");
            return null;
        }
        previous.setNext(now.getNext());
        return now;
    }
    

    
    public void clear() {
        setHead(null);
        setSize(0);
    }
    public void print() {
        DNode now = getHead();
        System.out.println("Is list sorted: " + isSorted());
        System.out.println("Size of List: " + getSize());

        for (int i = 0; i < getSize(); i++) {
            System.out.print(now);
            now = now.getNext();
        }
    }

    public DNode getterLastNodes() {
        for (DNode now = getHead(); now != null; now = now.getNext()) {
            if (now.getNext() == getTailPointer()) {
                return now;
            }
        }
        return null;
    }
    
}