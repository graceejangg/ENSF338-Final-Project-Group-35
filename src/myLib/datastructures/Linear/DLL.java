package myLib.datastructures.Linear;

import myLib.datastructures.nodes.DNode;

public class DLL extends SLL {
    private DNode head;
    private DNode tail;
    private int size;
    private DNode sorted;
    private DNode tailPointer;

    // CONSTRUCTORS
    public DLL() {
        setHead(null);
        setTail(null);
        setSorted(null);
        setTailPointer(null);
        setSize(0);
    }

    public DLL(DNode newNode) {
        setHead(newNode);
        setTail(newNode);
        setSorted(newNode);
        setTailPointer(newNode);
        setSize(1);
    }

    // GETTERS
    public DNode getHead() {
        return this.head;
    }

    public DNode getSorted() {
        return sorted;
    }

    public DNode getTailPointer() {
        return tailPointer;
    }

    public DNode getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.size;
    }

    // SETTERS
    public void setHead(DNode head) {
        this.head = head;
    }

    public void setSorted(DNode sorted) {
        this.sorted = sorted;
    }

    public void setTailPointer(DNode tailPointer) {
        this.tailPointer = tailPointer;
    }

    public void setTail(DNode tail) {
        this.tail = tail;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // INSERT METHODS
    @Override
    public void insertHead(DNode node) {
        DNode headnow = getHead();
        if (headnow != null) {
            node.setNext(headnow);
            headnow.setPrevious(node);
            this.head = node;

        } else {
            this.head = node;
            this.tail = node;
        }

        this.size = size + 1;
    }

    public void InsertHead(DNode node){
        this.insertHead(node);
    }

    @Override
    public void insertTail(DNode node) {
        if (getHead() != null) {
            tail.setNext(node);
            node.setPrevious(tail);
            this.tail = node;

        } else {
            setHead(node);
            node.setPrevious(null);
            this.tail = node;
        }
        this.size = size + 1;
    }

    public void InsertTail(DNode node){
        this.insertTail(node);
    }

    @Override
    public void insert(DNode node, int position) {
        if (position < 0 || position > getSize()) {
            throw new IndexOutOfBoundsException("Position is invalid at: " + position);
        }

        if (getHead() == null) {
            setHead(node);
            setTail(node);
        } else if (getDNode(position) == null || position == 0) {
            if (getDNode(position) == null) {
                insertTail(node);
                this.size = (size - 1);
            } else {
                insertHead(node);
                this.size = (size - 1);
            }
        } else {
            DNode nodeBefore = getDNode(position).getPrevious();
            DNode DnodeAfter = nodeAfter(position);
            node.setNext(DnodeAfter);
            nodeBefore.setNext(node);
            DnodeAfter.setPrevious(node);
            node.setPrevious(nodeBefore);

        }
        this.size = (size + 1);
    }

    public void Insert(DNode node, int position){
        this.insert(node, position);
    }

    @Override
    public void sortedInsert(DNode node) {
        DNode now = getHead();
        if (isSorted() == false || now == null || getHead().getData() >= node.getData() || now.getNext() == null) {
            if (isSorted() == false) {
                sort();
            } else if (now == null || getHead().getData() >= node.getData()) {
                insertHead(node);
                this.size = size - 1;
            } else if (now.getNext() == null) {
                insertTail(node);
                this.size = size - 1;
            }
        } else {
            DNode sortednow = getHead().getNext();
            while (sortednow != null && sortednow.getData() < node.getData()) {
                sortednow = sortednow.getNext();
            }
            node.setNext(now.getNext());
            node.setPrevious(now);
            if (sortednow != null) {
                sortednow.setPrevious(node);
            }
            now.setNext(node);
        }
        this.size = size + 1;
    }

    public void SortedInsert(DNode node) {
        this.sortedInsert(node);
    }

    // SORT METHOD
    @Override
    public void sort() {
        DNode now = getHead();
        DNode sorted = null;
        while (now != null) {
            DNode temporary = now.getNext();
            if (sorted == null || sorted.getData() > now.getData()) {
                now.setNext(sorted);
                if (sorted != null) {
                    sorted.setPrevious(now);
                }
                sorted = now;
                sorted.setPrevious(null);
            } else {
                DNode nodeNow = sorted;
                while (nodeNow.getNext() != null && nodeNow.getNext().getData() < now.getData()) {
                    nodeNow = nodeNow.getNext();
                }
                now.setNext(nodeNow.getNext());
                if (nodeNow.getNext() != null) {
                    nodeNow.getNext().setPrevious(now);
                }
                nodeNow.setNext(now);
                now.setPrevious(nodeNow);
            }
            now = temporary;
        }
        setHead(sorted);
        DNode last = sorted;
        while (last.getNext() != null) {
            last = last.getNext();
        }
        setTail(last);
    }

    public void Sort() {
        this.sort();
    }

    // DELETE METHODS
    @Override
    public DNode deleteHead() {
        // Check if the list is empty
        if (getHead() == null) {
            System.out.println("This list is empty... ");
            return null;
        }

        // Check if the list has only one node
        if (getHead() == getTail()) {
            setHead(null);
            setTail(null);
            setSize(0);
            return getHead();
        }

        // Delete the head node
        DNode tempoary = getHead();
        setHead(getHead().getNext());
        getHead().setPrevious(null);
        setSize(getSize() - 1);
        return tempoary;
    }

    public DNode DeleteHead() {
        return this.deleteHead();
    }

    @Override
    public DNode deleteTail() {
        // Check if the list is empty
        if (getTail() == null) {
            System.out.println("This list is empty... ");
            return null;
        }

        // Check if the list has only one node
        if (getHead() == getTail()) {
            return deleteHead();
        }

        // Delete the tail node
        DNode tempoary = getTail();
        DNode newTail = getTail().getPrevious();
        newTail.setNext(null);
        setTail(newTail);
        setSize(getSize() - 1);
        return tempoary;
    }

    public DNode DeleteTail() {
        return this.deleteTail();
    }

    @Override
    public DNode delete(int data) {
        DNode now = getHead();

        // Check if the list is empty
        if (now == null) {
            System.out.println("This list is empty... ");
            return null;
        }

        // Check if the node to delete is the head
        if (now.getData() == data) {
            return deleteHead();
        }

        // Traverse the list to find the node to delete
        while (now != null) {
            if (now.getData() == data) {
                break;
            }
            now = now.getNext();
        }
        // Check if the node was found
        if (now == null) {
            System.out.println("Value is not found in list");
            return null;
        }

        // Check if the node to delete is the tail
        if (now != null && now == getTail()) {
            return deleteTail();
        }

        // Delete the node
        DNode prev = now.getPrevious();
        DNode next = now.getNext();
        prev.setNext(next);
        next.setPrevious(prev);
        setSize(getSize() - 1);
        return now;
    }

    public DNode Delete(int data) {
        return this.delete(data);
    }

    // HELPER METHODS
    private DNode nodeAfter(int position) {
        DNode now = getHead();
        for (int i = 0; i < position - 1; i++) {
            now = now.getNext();
        }
        return now;
    }

    private DNode getDNode(int position) {
        DNode DNodenow = getHead();
        for (int i = 0; i < position; i++) {
            DNodenow = DNodenow.getNext();
        }

        return DNodenow;
    }

}