package com.example.myLib.datastructures.nodes;

import java.lang.reflect.Type;

public class TNode {

    private int data;
    private TNode left; // Left child node
    private TNode right; // Right child node
    private TNode parent;
    private int balance;

    /**
     * TNode Default Constructor
     */
    public TNode() {
        setData(0);
        setBalance(0);
        setParent(null);
        setLeft(null);
        setRight(null);
    }

    /**
     * TNode Overloaded Constructor
     * that takes in an integer data, an integer balance to initialize the
     * data and balance members.
     * 
     * @param data
     * @param balance
     * @param P       -> Parent node
     * @param L       -> Left child node
     * @param R       -> Right child node
     */
    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        setData(data);
        setBalance(balance);
        setParent(P);
        setLeft(L);
        setRight(R);
    }
    public TNode(int data){
        setData(data);
        setBalance(0);
        setParent(null);
        setLeft(null);
        setRight(null);
    }

    // SETTERS
    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // GETTERS
    public TNode getParent() {
        return this.parent;
    }

    public TNode getLeft() {
        return this.left;
    }

    public TNode getRight() {
        return this.right;
    }

    public int getData() {
        return this.data;
    }

    public int getBalance() {
        return this.balance;
    }

    // Converts TNode to string then prints it
    public void print() {
        System.out.println("Data: "+ getData());
        System.out.println("Balance: "+ getBalance());
        System.out.print("Left: ");
        if(getLeft() == null){
            System.out.println("Null");
        } else{
            System.out.println("Child");
            getLeft().print();
            System.out.println("End of child");
        }
        System.out.print("Right: ");
        if(getRight() == null){
            System.out.println("Null");
        } else{
            System.out.println("Child");
            getRight().print();
            System.out.println("End of child");
        } 
    }

    // Convert TNode to string for printing
    @Override
    public String toString() {
        return Integer.toString(getData());
    }

    // Decrement Balance by 1
    public void decrementBalance() {
        this.balance -= 1;
    }

    // Increment Balance by 1
    public void incrementBalance() {
        this.balance += 1;
    }
}