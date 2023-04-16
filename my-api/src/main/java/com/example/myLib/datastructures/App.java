package com.example.myLib.datastructures;

import com.example.myLib.datastructures.Linear.QueueLL;
import com.example.myLib.datastructures.Linear.StackLL;
import com.example.myLib.datastructures.nodes.DNode;

public class App {
    public static void main(String[] args) {
        System.out.println("\n****** STACKS ****** \n");
        StackLL stack = new StackLL();
        StackLL stackOverload = new StackLL(new DNode(3));

        System.out.println("Push");
        stack.push(new DNode(2));
        stack.push(new DNode(5));
        stack.push(new DNode(15));
        stack.push(new DNode(91));
        stack.print();

        System.out.println("\nPop");
        stack.pop();
        stack.print();
        System.out.println();
        stack.pop();
        stack.print();

        System.out.println("\nPeek");
        System.out.println(stack.peek());

        System.out.println("\nSearch for Value: 2s position");
        System.out.println(stack.searchStack(2));

        System.out.println("\nCheck if stack is empty");
        System.out.println(stack.isEmpty());

        System.out.println("\nClear");
        stack.clear();
        stack.print();

        System.out.println("\nRecheck if stack is empty");
        System.out.println(stack.isEmpty());

        System.out.println("\n****** QUEUES ******\n");
        QueueLL queue = new QueueLL();
        // QueueLL queueOverload = new QueueLL(new DNode(11), new DNode(2));

        System.out.println("Enqueue");
        queue.enqueue(new DNode(3));
        queue.enqueue(new DNode(11));
        queue.enqueue(new DNode(7));
        queue.enqueue(new DNode(64));
        queue.enqueue(new DNode(1));
        queue.print();

        System.out.println("\nDequeue");
        queue.dequeue();
        queue.print();

        System.out.println("\nPeek");
        System.out.println(queue.peek());

        System.out.println("\nSearch for Value: 7s position");
        System.out.println(queue.searchQueue(7));



        System.out.println("\nClear");
        queue.clear();
        queue.print();

    }
}
