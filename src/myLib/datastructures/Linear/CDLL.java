package myLib.datastructures.Linear;
import myLib.datastructures.nodes.*;

public class CDLL extends DLL
{
    public DNode getHead() {
        return super.getHead();
    }

    public void setHead(DNode head) {
        super.setHead(head);
    }

    public DNode getTail() {
        return super.getTail();
    }

    public void setTail(DNode tail) {
        super.setTail(tail);
    }

    public int getSize() {
        return super.getSize();
    }

    public void setSize(int size) {
        super.setSize(size);
    }

    public DNode getTailPointer() {
        return super.getTailPointer();
    }

    public void setTailPointer(DNode tailPointer) {
        super.setTailPointer(tailPointer);
    }

    public CDLL() {
        setHead(null);
        setTail(getHead());
        setSize(0);
    }

    public CDLL(DNode head) {
        setHead(head);
        setTail(head);
        getHead().setNext(getTail());
        getTail().setNext(getHead());
        getHead().setPrevious(getTail());
        getTail().setPrevious(getHead());
        setSize(1);
    }

    // INSERTION METHODS
    @Override
    public void insertHead(DNode node) {
        super.insertHead(node);
        getHead().setPrevious(getTail());
        getTail().setNext(getHead());
    }

    public void InsertHead(DNode node){
        this.insertHead(node);
    }

    @Override
    public void insertTail(DNode node) {
        super.insertTail(node);
        super.getTail().setNext(getHead());
        this.getHead().setPrevious(getTail());
    }
    public void InsertTail(DNode node){
        this.insertTail(node);
    }

    @Override
    public void insert(DNode node, int position) {
        super.insert(node, position);
        super.getTail().setNext(getHead());
        this.getHead().setPrevious(getTail());
    }
    public void Insert(DNode node, int position){
        this.insert(node, position);
    }

    // need fixing
    @Override
    public void sort() {
        DNode now = getHead();

        if (now == null || now.getNext() == null) {
            return;
        }

        super.getTail().setNext(null);
        setSorted(null);

        while (now != null) {
            DNode tempoary = now.getNext();
            now.setPrevious(null);
            now.setNext(null);

            if (getSorted() == null) {
                setSorted(now);
            } else if (getSorted().getData() > now.getData() || getSorted().getData() == now.getData()) {
                now.setNext(getSorted());
                getSorted().setPrevious(now);
                setSorted(now);
            } else {
                DNode currSorted = getSorted();
                while (currSorted.getNext() != null && currSorted.getNext().getData() < now.getData()) {
                    currSorted = currSorted.getNext();
                }
                now.setNext(currSorted.getNext());
                if (currSorted.getNext() != null) {
                    currSorted.getNext().setPrevious(now);
                }
                currSorted.setNext(now);
                now.setPrevious(currSorted);
            }
            now = tempoary;
        }
        setHead(getSorted());
        DNode tail = getHead();
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        super.setTail(tail);

        super.getTail().setNext(getHead());
        super.getHead().setPrevious(getTail());
    }
    public void Sort() {
        this.sort();
    }
    
    public void sortedInsert(DNode node) {
        if (!isSorted()) {
            sort();
        }

        else if (getHead() == null || getHead().getData() >= node.getData()) {
            insertHead(node);
        } else {
            DNode now = getHead();
            while (now.getNext() != null && now.getNext().getData() < node.getData()) {
                now = now.getNext();
            }
            node.setNext(now.getNext());
            if (now.getNext() != null) {
                now.getNext().setPrevious(node);
            }
            node.setPrevious(now);
            now.setNext(node);
        }

        setSize(getSize() + 1);
    }
    public void SortedInsert(DNode node) {
        this.sortedInsert(node);
    }

    @Override
    public DNode search(int data) {
        DNode now = getHead();
        DNode found = null;
        int i = 0;
        while (i < getSize() && now != null) {
            if (now.getData() == data) {
                found = now;
            }
            now = now.getNext();
            i++;
        }
        return found;
    }
    public DNode Search(int data) {
        return this.search(data);
    }

    @Override
    public DNode deleteHead() {
        DNode tempoary = getHead();
        setHead(getHead().getNext());
        getTail().setNext(getHead());
        getHead().setPrevious(getTail());
        setSize(getSize() - 1);
        return tempoary;
    }
    public DNode DeleteHead() {
        return this.deleteHead();
    }

    @Override
    public DNode deleteTail() {
        DNode tempoary = getTail();
        setTail(tempoary.getPrevious());
        getTail().setNext(getHead());
        getHead().setPrevious(getTail());
        setSize(getSize() - 1);
        return tempoary;
    }
    public DNode DeleteTail() {
        return this.deleteTail();
    }

    @Override
    public DNode delete(int data) {
        DNode now = getHead();
        setSize(getSize() - 1);

        if (now != null && now.getData() == data) {
            setSize(getSize() + 1);
            return deleteHead();
        }

        while (now != null && now.getNext() != getHead() && now.getData() != data) {
            now = now.getNext();
        }

        if (now != null && now.getNext() == getHead() && now.getData() == data) {
            setSize(getSize() + 1);
            return deleteTail();
        }

        if (now == null || now.getNext() == getHead()) {
            setSize(getSize() + 1);
            System.out.println("Value not found in list.");
            return null;
        }

        now.getPrevious().setNext(now.getNext());
        now.getNext().setPrevious(now.getPrevious());
        return now;
    }
    public DNode Delete(int data) {
        return this.delete(data);
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
    public void Print() {
        this.print();
    }

    public void clear() {
        setHead(null);
        setSize(0);
    }
    public void Clear(){
        this.clear();
    }
}
