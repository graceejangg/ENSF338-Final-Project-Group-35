package com.example.Trees;

import com.example.myLib.datastructures.Trees.AVL;
import com.example.myLib.datastructures.Trees.BST;
import com.example.myLib.datastructures.nodes.TNode;

public class TreeTest {
    public static void main(String[] args) {
        System.out.println("****** BST ******");
        int[] arr = { 21,5,1,15,12,42,39,2,43,26 };

        TNode nodeTest = new TNode(0, 0, null, null, null);

        
        // BST CONSTRUCTORS
        BST bst = new BST();
        BST bstOverload1 = new BST(5);
        BST bstOverload2 = new BST(nodeTest);

        // Insert array into BST
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }

        System.out.println("\nTEST BST SEARCH");
        TNode searchValue = bst.search(5);
        System.out.println("Returned BST search value: " + searchValue.getData());

        System.out.println("TEST BST PRINTS");

        System.out.println("BST tree in order: ");
        bst.printInOrder();

        System.out.println("\nBST tree in breadth-first:");
        bst.printBF();

        System.out.println("\nInsert 25 into BST:");
        bst.insert(25);
        bst.printBF();

        System.out.println("\nInsert by overload method into BST:");
        bst.insert(nodeTest);

        System.out.println("\nDelete 26 from BST:");
        bst.delete(26);
        bst.printBF();

        System.out.println("\n****** AVL ******");
        
        // AVL CONSTRUCTORS
        AVL avlDefault = new AVL();
        AVL avlOverload1 = new AVL(5);
        AVL avl = new AVL(bst.getRoot());

        System.out.println("\nAVL tree in order: ");
        avl.printInOrder();

        System.out.println("\nAVL tree in breadth-first:");
        avl.printBF();

        searchValue = avl.search(5);
        System.out.println("\nReturned AVL search value: " + searchValue.getData());

        System.out.println("\nInsert value 14 into AVL Tree: ");
        avl.insert(14);
        avl.printBF();
    }
}
