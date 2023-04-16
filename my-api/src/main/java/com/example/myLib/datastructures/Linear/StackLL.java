package com.example.myLib.datastructures.Linear;

import com.example.myLib.datastructures.nodes.DNode;

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

    public void Push(DNode node) {
        this.push(node);
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

    public DNode Pop() {
        return this.pop();
    }
    

    public boolean isEmpty() {
        return getHead() == null;
    }

    public boolean IsEmpty() {
        return this.isEmpty();
    }

    public int peek() {
        if (getHead() == null) {
            System.out.println("The stack is empty");
            return -1;
        }
        return getHead().getData();
    }

    public int Peek() {
        return peek();
    }
    

    @Override
    public void insertTail(DNode node) {
    }

    public void InsertTail(DNode node) {
        this.insertTail(node);
    }

    @Override
    public void insert(DNode node, int position) {
    }

    public void Insert(DNode node, int position) {
        this.Insert(node, position);
    }

    @Override
    public void sortedInsert(DNode node) {
    }

    public void SortedInsert(DNode node) {
        this.sortedInsert(node);
    }

    @Override
    public void sort() {
    }

    public void Sort() {
        this.sort();
    }

    @Override
    public DNode deleteTail() {
        return null;
    }

    public DNode DeleteTail() {
        return deleteTail();
    }

    @Override
    public DNode delete(int data) {
        return null;
    }

    public DNode Delete(int data) {
        return delete(data);
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

    public int SearchStack(int data) {
        return this.searchStack(data);
    }
}
