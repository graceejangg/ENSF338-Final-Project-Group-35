package myLib.datastructures.Linear;
import myLib.datastructures.nodes.*;

public class CDLL extends DLL
{
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
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public DNode getTailPointer() {
        return tailPointer;
    }
    
    public void setTailPointer(DNode tailPointer) {
        this.tailPointer = tailPointer;
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
        setSize(0);
    }

    //INSERTION METHODS
    //O(1)
    @Override
    public void insertHead(DNode node) {
        super.insertHead(node);
        getHead().setPrevious(getTail());
        getTail().setNext(getHead());
    }

    //O(1)
    @Override
    public void insertTail(DNode node) {
        super.insertTail(node);
        super.getTail().setNext(getHead());
        this.getHead().setPrevious(getTail());
    }

    //O(n)
    @Override
    public void insert(DNode node, int position) {
        super.insert(node, position);
        super.getTail().setNext(getHead());
        this. getHead().setPrevious(getTail());
    }

    //need fixing
    @Override
    public void sort() {
        DNode now = getHead();

        if(now == null || now.getNext() == null) {
            return;
        }
        
        super.getTail().setNext(null);
        setSorted(null);
        
        while(now != null) {
            DNode tempoary = now.getNext();
            now.setPrevious(null);
            now.setNext(null);
            
            if(getSorted() == null) {
                setSorted(now);
            } else if(getSorted().getData() > now.getData() || getSorted().getData() == now.getData()) {
                now.setNext(getSorted());
                getSorted().setPrevious(now);
                setSorted(now);
            } else {
                DNode currSorted = getSorted();
                while(currSorted.getNext() != null && currSorted.getNext().getData() < now.getData()) {
                    currSorted = currSorted.getNext();
                }
                now.setNext(currSorted.getNext());
                if(currSorted.getNext() != null) {
                    currSorted.getNext().setPrevious(now);
                }
                currSorted.setNext(now);
                now.setPrevious(currSorted);
            }
            now = tempoary;
        }
        setHead(getSorted());
        DNode tail = getHead();
        while(tail.getNext() != null) {
            tail = tail.getNext();
        }
        super.setTail(tail);
        
        super.getTail().setNext(getHead());
        super.getHead().setPrevious(getTail());
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
    
    
    @Override
    public DNode search(int data) {
        DNode now = getHead();
        DNode found = null;
        int i = 0;
        while( i < getSize() && now != null) {
            if(now.getData() == data) {
                found = now;
            }
            now = now.getNext();
            i++;
        }
        return found;
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
    

    @Override
    public DNode deleteTail() {
        DNode tempoary = getTail();
        setTail(tempoary.getPrevious());
        getTail().setNext(getHead());
        getHead().setPrevious(getTail());
        setSize(getSize() - 1);
        return tempoary;
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
    

    public void print() {
        DNode now = getHead();
        System.out.println("Is list sorted: " + isSorted());
        System.out.println("Size of List: " + getSize());

        for (int i = 0; i < getSize(); i++) {
            System.out.print(now);
            now = now.getNext();
        }
    }

    public void clear() {
        setHead(null);
        setSize(0);
    }
}
