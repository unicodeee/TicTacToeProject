package src;

import src.LinkedQueue.LinkedQueue;

public class Manage {

    private Player[] T = new Player[2];
    int indexPlayerX =0;
    int indexPlayerO =1;

    LinkedQueue queueX; // queue player1 / who play X
    LinkedQueue queueO;  //  queue player2 / who play O

    public Manage(LinkedQueue x, LinkedQueue o) {
        this.queueX = x;
        this.queueX = o;
    }

    public void addQueueX (Player a){
        queueX.enqueue(a);
        queueX.display();
    }


}

