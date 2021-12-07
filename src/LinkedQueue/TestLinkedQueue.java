package src.LinkedQueue;

import src.Player;

public class TestLinkedQueue {

    public static void main(String[] args) throws EmptyQueueException {
        // Empty queue
        System.out.println("Create a queue: ");
        QueueInterface<Player> sampleQueue = new LinkedQueue<>();
        System.out.println("\nisEmpty() returns " + sampleQueue.isEmpty() + "\n");

        System.out.print("\nAdd items to the empty queue.\n");
        sampleQueue.enqueue(new Player(18, "Thang"));
        sampleQueue.enqueue(new Player(21, "Xizhu"));
        sampleQueue.enqueue(new Player(54, "John"));
        sampleQueue.enqueue(new Player(75, "Kyvu"));


//        while (!sampleQueue.isEmpty()){
//            System.out.println(sampleQueue.dequeue());
//        }

        sampleQueue.display();
    }
}
