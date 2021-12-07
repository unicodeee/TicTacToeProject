package src.LinkedQueue;

// Java program to demonstrate the working
// of a Deque in Java

import java.util.*;

public class DequeExample {
    public static void main(String[] args)
    {
        Deque<String> deque
                = new LinkedList<String>();

        deque.push("A");
        deque.push("B");

        System.out.println(deque + "\n");


    }
}