package com.example.myLib.datastructures.Trees;

import com.example.myLib.datastructures.nodes.TNode;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

    TNode root; // TNode root: references the root of the tree

    /**
     * Default Constructor
     */
    public BST() {
        this.root = null;
    }

    /**
     * Overload constructor BST(int val) which takes in an integer value,
     * and creates a TNode and use it as root
     * 
     * @param data -> an integer which holds the value for data for root
     */
    public BST(int data) {
        this.root = new TNode(data, 0, null, null, null);
    }

    /**
     * Overload constructor BST(TNode obj) which takes a TNode as an argument and
     * use it as the root of the tree. The TNode obj can have children which would
     * make this tree object reference a sub-tree structure
     * 
     * @param root -> a TNode object which is the root node
     */
    public BST(TNode root) {
        if (root == null) {
            return;
        }
        this.root = root;
    }

    /**
     * Root Getter
     * 
     * @return root -> TNode object of root node
     */
    public TNode getRoot() {
        return this.root;
    }

    /**
     * Root Setter
     * 
     * @param root -> a TNode that holds the new root node
     */
    public void setRoot(TNode root) {
        this.root = root;
    }

    /**
     * Insert(int data): creates a new node with data to be inserted into the tree
     * 
     * @param data -> an integer that holds the data for the new node
     */
    public void insert(int data) {
        TNode newNode = new TNode(data, 0, null, null, null);
        insert(newNode);
    }

    /**
     * Insert(TNode node) : inserts the node passed as argument into the tree
     * 
     * @param node
     */
    public void insert(TNode node) {
        TNode current = getRoot();
        TNode parent = null;

        while (current != null) {
            parent = current;
            if (current.getData() > node.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        if (this.root == null) {
            this.root = node;
        } else if (parent.getData() > node.getData()) {
            parent.setLeft(node);
            node.setParent(parent);
        } else {
            parent.setRight(node);
            node.setParent(parent);
        }
    }

    // Finds the node equivalent to the node_to_delete in the tree and removes it.
    // If an object of that value is not found then it prints to the user that the
    // object was not found
    public void delete(int val) {
        TNode current = this.root;

        if (this.root == null) {
            System.out.println("Tree is empty, " + val + " not found");
            return;
        }

        while (current != null) {

            if (current.getData() == val) {
                break;
            } else if (current.getData() > val) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

            if (current == null) {
                System.out.println("Object to delete not found.");
                return;
            }
        }

        if (current.getLeft() == null && current.getRight() == null) {

            if (current != this.root)
                if (current.getParent().getLeft() != null
                        && current.getParent().getLeft().getData() == val) {
                    current.getParent().setLeft(null);
                } else {
                    current.getParent().setRight(null);
                }
            else {
                this.root = null;
            }
        }

        else if (current.getLeft() != null && current.getRight() != null) {
            TNode smallest = current.getRight();
            while (smallest.getLeft() != null) {
                smallest = smallest.getLeft();
            }

            if (smallest.getParent().getRight() != null
                    && smallest.getParent().getRight().getData() == smallest.getData()) {

                smallest.getParent().setRight(smallest.getRight());

            } else {
                smallest.getParent().setLeft(smallest.getRight());
            }
            current.setData(smallest.getData());

            if (smallest.getRight() != null) {
                smallest.getRight().setParent(smallest.getParent());
            }
        }

        else {
            TNode child;

            if (current.getLeft() != null) {
                child = current.getLeft();
            } else {
                child = current.getRight();
            }

            if (current != getRoot()) {
                if (current.getLeft() != null) {
                    child.setParent(current.getParent());
                    current.getParent().setLeft(child);
                } else {
                    child.setParent(current.getParent());
                    current.getParent().setRight(child);
                }
            } else {
                setRoot(child);
            }
        }
    }

    public void printInOrder() {
        printInOrder(this.root);
    }

    public void printInOrder(TNode current) {
        if (current != null) {
            printInOrder(current.getLeft());
            current.print();
            printInOrder(current.getRight());
        }
    }

    // prints the content of the tree in Breadth-First order, each level of the
    // tree will be printed on a separate line
    public void printBF() {
        // If tree is empty return
        if (this.root == null) {
            return;
        }

        // Create a queue and add root to it
        Queue<TNode> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TNode curr = queue.poll();
                System.out.print(curr.getData() + " ");
                if (curr.getLeft() != null) {
                    queue.add(curr.getLeft());
                }
                if (curr.getRight() != null) {
                    queue.add(curr.getRight());
                }

            }
            System.out.println();
        }
    }

    public TNode search(int val) {

        TNode current = getRoot();

        if (getRoot() == null) {
            System.out.println("Value " + val + " not found, since tree is empty.");
            return null;
        }

        while (current != null) {

            if (current.getData() == val) {
                return current;
            } else if (current.getData() > val) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        System.out.println("Value " + val + " not found.");
        return null;
    }
}
