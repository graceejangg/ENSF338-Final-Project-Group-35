package myLib.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

import myLib.datastructures.nodes.TNode;

public class AVL extends BST {
    // Default constructor initializing root to null
    public AVL() {
        super();
    }

    // Overload constructor AVL(int val) which takes in an integer value, and
    // creates a TNode and use it as root
    public AVL(int data) {
        super(data);

    }

    public AVL(TNode newNode) {
        if (newNode == null) {
            return;
        }
        setRoot(newNode);
        if (newNode.getLeft() != null || newNode.getRight() != null) {
            rebalance(getRoot());
        }

    }

    private TNode insert(TNode node, int data) {
        if (node == null) {
            return new TNode(data, 0, null, null, null);
        }

        if (data < node.getData()) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(insert(node.getRight(), data));
        } else {
            return node;
        }

        node.setBalance(height(node.getLeft())-height(node.getRight()));

        int balance = getBalance(node);

        if (balance > 1 && data < node.getLeft().getData()) {
            return rightRotate(node);
        }

        if (balance < -1 && data > node.getRight().getData()) {
            return leftRotate(node);
        }

        if (balance > 1 && data > node.getLeft().getData()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if (balance < -1 && data < node.getRight().getData()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    private TNode leftRotate(TNode node) {
        TNode right = node.getRight();
        TNode left = right.getLeft();

        right.setLeft(node);
        node.setRight(left);

        node.setBalance(height(node.getLeft()) - height(node.getRight()));
        right.setBalance(height(right.getLeft()) - height(right.getRight()));

        return right;
    }

    private TNode rightRotate(TNode node) {
        TNode left = node.getLeft();
        TNode right = left.getRight();

        left.setRight(node);
        node.setLeft(right);

        node.setBalance(height(node.getLeft()) - height(node.getRight()));
        left.setBalance(height(left.getLeft()) - height(left.getRight()));

        return left;
    }

    private int height(TNode node) {
        if (node == null) {
            return 0;
        }
        return node.getBalance();
    }

    private int getBalance(TNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public void delete(int val){
        super.delete(val);
    }
    
    public void insert(int data) {
        super.setRoot(insert(super.getRoot(), data));
    }

    public void insert(TNode node){
        setRoot(insert(getRoot(), node));
    }

    // Insert helper function
    private TNode insert(TNode root, TNode node) {
        if (root == null) {
            return node;
        }
    
        if (node.getData() < root.getData()) {
            root.setLeft(insert(root.getLeft(), node));
        } else if (node.getData() > root.getData()) {
            root.setRight(insert(root.getRight(), node));
        } else {
            return root;
        }
    
        // Update the balance factor of the current node
        root.setBalance(height(root.getLeft()) - height(root.getRight()));
    
        
        if (root.getBalance() > 1) { // Left heavy case
            if (node.getData() > root.getLeft().getData()) {
                root.setLeft(leftRotate(root.getLeft()));
            }
            return rightRotate(root);
        }
    
       
        if (root.getBalance() < -1) { // Right heavy case
            if (node.getData() < root.getRight().getData()) {
                root.setRight(rightRotate(root.getRight()));
            }
            return leftRotate(root);
        }
    
        return root;
    }
    private void rebalance(TNode node) {
        if (node == null) {
            return;
        }

        int balance = getBalance(node);

        if (balance > 1) {
            // left subtree is taller than the right subtree
            if (getBalance(node.getLeft()) < 0) {
                // left-right case: rotate left child to the left
                node.setLeft(leftRotate(node.getLeft()));
            }
            // left-left case: rotate current node to the right
            node = rightRotate(node);
        } else if (balance < -1) {
            // right subtree is taller than the left subtree
            if (getBalance(node.getRight()) > 0) {
                // right-left case: rotate right child to the right
                node.setRight(rightRotate(node.getRight()));
            }
            // right-right case: rotate current node to the left
            node = leftRotate(node);
        }

        // recursively rebalance the parent nodes
        rebalance(node.getParent());
    }
}