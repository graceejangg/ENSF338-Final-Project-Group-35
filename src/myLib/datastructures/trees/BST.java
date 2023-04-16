package myLib.datastructures.Trees;

import java.util.LinkedList;
import java.util.Queue;

import myLib.datastructures.nodes.TNode;

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
    public void Insert(int data) {
        this.insert(data);
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
    public void Insert(TNode node) {
        this.insert(node);
    }

    // Finds the node equivalent to the node_to_delete in the tree and removes it.
    // If an object of that value is not found then it prints to the user that the
    // object was not found
    public void delete(int val) {
        root = delete(root, val);
    }
    public void Delete(int val) {
        this.delete(val);
    }

    // Delete helper function
    private TNode delete(TNode node, int val){
        if (node == null) {
            System.out.println("Value not found in the tree");
            return null;
        }

        if (val < node.getData()) {
            node.setLeft(delete(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(delete(node.getRight(), val));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setData(minimumValue(node.getRight()));
            node.setRight(delete(node.getRight(), node.getData()));
        }

        return node;
    }

    private int minimumValue(TNode node){
        int minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }

    public void printInOrder() {
        printInOrder(this.root);
    }
    public void PrintInOrder() {
        printInOrder();
    }

    public void printInOrder(TNode current) {
        if (current != null) {
            printInOrder(current.getLeft());
            System.out.println(current.getData());
            printInOrder(current.getRight());
        }
    }
    public void PrintInOrder(TNode current) {
        this.PrintInOrder(current);
    }

    // prints the content of the tree in Breadth-First order, each level of the
    // tree will be printed on a separate line
    public void printBF() {
        // If tree is empty return
        if (this.root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        // Create a queue and add root to it
        Queue<TNode> queue = new LinkedList<>();
        queue.add(this.root);

        while (!queue.isEmpty()) {
            for (int levelSize = queue.size(); levelSize > 0; levelSize--) {
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
    public void PrintBF() {
        this.printBF();
    }

    public TNode search(int val) {

        TNode current = this.root;

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
    public TNode Search(int val) {
        return this.search(val);
    }
}