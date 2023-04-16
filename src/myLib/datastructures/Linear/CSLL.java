package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

public class CSLL extends SLL {
    private DNode head;
    private DNode tail;
    private int size;
    private DNode tailPointer;

    // GETTERS & SETTERS
    public DNode getHead() {
        return head;
    }

    public void setHead(DNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DNode getTail() {
        return tail;
    }

    public void setTail(DNode tail) {
        this.tail = tail;
    }

    public DNode getTailPointer() {
        return getHead();
    }

    public void setTailPointer(DNode tailPointer) {
        this.tailPointer = tailPointer;
    }

    public CSLL() {
        setHead(null);
        setTail(getHead());
        setSize(0);
    }

    public CSLL(DNode head) {
        setHead(head);
        setTail(getHead());
        getHead().setNext(getTail());
        getTail().setNext(getHead());
        setSize(0);
    }

    @Override
    public void insertHead(DNode node) {
        super.insertHead(node);
        if (getTail() == null) {
            setTail(head);
        } else {
            DNode tail = getTail();
            tail.setNext(head);
        }
    }
    public void InsertHead(DNode node){
        this.insertHead(node);
    }

    @Override
    public void insertTail(DNode node) {
        if (getSize() == 0) {
            insertHead(node);
        } else {
            node.setNext(getHead());
            getTail().setNext(node);
            setTail(node);
            setSize(getSize() + 1);
            setTailPointer(getTail());
        }
    }
    public void InsertTail(DNode node){
        this.insertTail(node);
    }

    @Override
    public void insert(DNode node, int position) {
        super.insert(node, position);
        DNode now = getHead();
        while (now.getNext() != getTailPointer()) {
            now = now.getNext();
        }
        setTail(now);
        getTail().setNext(getHead());
    }
    public void Insert(DNode node, int position){
        this.insert(node, position);
    }

    @Override
    public void sort() {
        DNode now = getHead();
        setSorted(null);

        for (int i = 0; i < getSize(); i++) {
            DNode tempoary = now.getNext();
            if (getSorted() == null || getSorted().getData() >= now.getData()) {
                now.setNext(getSorted());
                setSorted(now);
            } else {
                DNode sortnow = getSorted();
                while (sortnow.getNext() != null && sortnow.getNext().getData() < now.getData()) {
                    sortnow = sortnow.getNext();
                }
                now.setNext(sortnow.getNext());
                sortnow.setNext(now);
            }
            now = tempoary;
        }
        setHead(getSorted());

        DNode tempoary2 = getHead();
        for (int i = 1; i < getSize(); i++) {
            tempoary2 = tempoary2.getNext();

        }
        setTail(tempoary2);
        getTail().setNext(getHead());

    }
    public void Sort() {
        this.sort();
    }

    @Override
    public DNode search(int data) {
        DNode now = getHead();
        DNode found = null;
        int i = 0;
        while (now != null && i < getSize()) {
            if (now.getData() == data) {
                found = now;
                i++;
            } else {
                now = now.getNext();
                i++;
            }

        }
        if (now == null && i > getSize()) {
            return found;
        }
        return found;
    }
    public DNode Search(int data) {
        return this.search(data);
    }

    @Override
    public DNode deleteHead() {
        DNode tempoary = head;
        setHead(head.getNext());
        getTail().setNext(head);
        setSize(size - 1);
        return tempoary;
    }
    public DNode DeleteHead() {
        return this.deleteHead();
    }

    @Override
    public DNode deleteTail() {
        if (getSize() == 0) {
            return null;
        } else if (getSize() == 1) {
            return deleteHead();
        } else {
            DNode now = getHead();
            while (now.getNext() != getTail()) {
                now = now.getNext();
            }
            DNode tempoary = getTail();
            setTail(now);
            getTail().setNext(getHead());
            setSize(getSize() - 1);
            return tempoary;
        }
    }
    public DNode DeleteTail() {
        return this.deleteTail();
    }

    @Override
    public DNode delete(int data) {
        DNode now = getHead();
        DNode tempoarynow = null;
        DNode nullDNode = null;
        setSize(getSize() - 1);

        if (now.getData() == data) {
            setSize(size + 1);
            if (now.getNext() == getHead()) {
                return deleteTail();
            } else if (now != null) {
                return deleteHead();
            }

        }
        while (now.getNext() != getHead() && now.getData() != data) {
            tempoarynow = now;
            now = now.getNext();
        }

        if (now.getNext() == getHead()) {
            setSize(size + 1);
            System.out.println("Value not found in list \n");
            return nullDNode;
        }
        tempoarynow.setNext(now.getNext());
        return now;
    }
    public DNode Delete(int data) {
        return this.delete(data);
    }
}
