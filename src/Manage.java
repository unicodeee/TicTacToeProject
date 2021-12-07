package src;
import java.util.*;

import src.LinkedQueue.EmptyQueueException;
import src.LinkedQueue.LinkedQueue;

public class Manage {

    Deque<Player> stackWinners = new LinkedList<Player>();
    Deque<Player> stackLosers = new LinkedList<Player>();

    private Player[] pairPlayers = new Player[2];
    private Player[] playingXO = new Player[2]; // we put the top item of 2 queue to this 2-items array to know who is playing to each other.

    int indexPlayerX =0;
    int indexPlayerO =1;

    LinkedQueue queueX; // queue player1 / who play X
    LinkedQueue queueO;  //  queue player2 / who play O

    public Manage(LinkedQueue x, LinkedQueue o) {
        this.queueX = x;
        this.queueO = o;
    }

    public void addQueueX (Player X){
        queueX.enqueue(X);
    }
    public void addQueueO (Player O){
        queueO.enqueue(O);
    }
    public void addQueue (Player X, Player O){
        pairPlayers[0] = X;
        pairPlayers[1] = O;
        addQueueX(pairPlayers[0]);
        addQueueO(pairPlayers[1]);
    }

    public void displayQueueX (){
        queueX.display();
    }
    public void displayQueueO (){
        queueO.display();
    }

    public void whoIsPlaying (){
        System.out.println( playingXO[indexPlayerX].getName() + " is playing X \t\t\tVS\t\t\t " + playingXO[indexPlayerO].getName()  + " is playing O");
    }

    public void getPlayersReady () throws EmptyQueueException {
        playingXO[indexPlayerX] = (Player) queueX.dequeue();
        playingXO[indexPlayerO] = (Player) queueO.dequeue();
        whoIsPlaying();
    }

    public void setStackWinners(){          // X: win O: lose
        stackWinners.push(playingXO[indexPlayerX]);    // store player X
        stackLosers.push(playingXO[indexPlayerO]);  // store player O in lose stack
    }
    public void setStackLosers(){           // X: lose O: win
        stackWinners.push(playingXO[indexPlayerO]);    // store player O in win stack
        stackLosers.push(playingXO[indexPlayerX]);      // store player X in lose stack
    }
    /*
    if Player1 is winner than stackWinners add player[indexPlayerX] player1, stackLosers add playerO player[indexPlayer0],
    else  player[indexPlayer0] player1, player[indexPlayerX] stackLosers add player1,
    */

}

