package src;
import java.util.*;

import src.Sort.SelectionSortGenerics;
import src.TestListener.Observer;

public class Manage implements Observer {

    Deque<Player> stackWinners = new LinkedList<Player>();
    Deque<Player> stackLosers = new LinkedList<Player>();

    private Player[] pairPlayers = new Player[2]; // when submitting the name and age for 2 peoplers, they got loaded in hear first
    private Player[] playingXO = new Player[2]; // we put the top item of 2 queue to this 2-items array to know who is playing to each other.

    private Player[] arrayOfWinners;  // reserved for sorting

    int indexPlayerX =0;
    int indexPlayerO =1;

    private TreeSet<Player> tree =new TreeSet<>();
    public void addToTree(Player x, Player o){
        tree.add(x);
        tree.add(o);
    }
    public void searchTree(String name){
        String message = "NO PLAYER WITH NAME: " + name;
        for(Player player: tree){
            if(player.getName().equals(name)){
                message = name + "is in the database. Age: " + player.getAge();
            }
        }
        System.out.println(message);
    }

    private Map<Integer, Player> hashMap = new HashMap();
    public void addToHashMap(Player x, Player o){
        hashMap.put(x.getAge(), x);
        hashMap.put(o.getAge(), o);
    }
    public void searchHashMap(Integer age){
        String message = "NO PLAYER WITH AGE: " + age;
        for(Integer key: hashMap.keySet()){
            if (key.equals(age)){
                message = "Player with age: " + age + " is in the database. Name: " + hashMap.get(key).getName();
            }
        }
        System.out.println(message);
    }
    public void add(Player x, Player o){
        addToTree( x,  o);
        addToHashMap( x,  o);
        addQueue(x, o);
    }

    Queue<Player> queueX = new LinkedList<>();
    Queue<Player> queueO = new LinkedList<>();


    public void sortArrayPlayer(){  // this method convert the stackWinners to an array -> so that we can sort with our generic sort method
        arrayOfWinners = new Player[stackWinners.size()];
        arrayOfWinners = stackWinners.toArray(arrayOfWinners);
        printSortedArrayWinners();
    }
    public void printSortedArrayWinners(){
        System.out.println("Stack winners before Sorting: ");
        for (int j = 0; j < arrayOfWinners.length; j++){     // print array
            System.out.println( arrayOfWinners[j].toString());
        }
        System.out.println();
        SelectionSortGenerics.selectionSort(arrayOfWinners); //sort  print Sorted array
        System.out.println("After Sorting: ");
        for (Player player : arrayOfWinners){
            System.out.println(player.toString());
        }
    }

    public Manage() {
    }

    public void addQueueX (Player X){
        queueX.add(X);
    }
    public void addQueueO (Player O){
        queueO.add(O);
    }
    public void addQueue (Player X, Player O){
        pairPlayers[0] = X;
        pairPlayers[1] = O;
        addQueueX(pairPlayers[0]);
        addQueueO(pairPlayers[1]);
    }
    public void displayQueueX (){
        System.out.println(queueX);}
    public void displayQueueO (){
        System.out.println(queueO);}
    public void whoIsPlaying (){
        System.out.println( queueX.peek().getName() + " is playing X \t\t\tVS\t\t\t " + queueO.peek().getName()   + " is playing O");
    }

    public void setXwin(){          // X: win O: lose
        stackWinners.push(queueX.remove());    // store player X
        stackLosers.push(queueO.remove());  // store player O in lose stack
        System.out.println("Stack winners: " + stackWinners);
        System.out.println("Stack losers: " + stackLosers);
    }
    public void setOwin(){           // X: lose O: win
        stackWinners.push(queueO.remove());    // store player O in win stack
        stackLosers.push(queueX.remove());      // store player X in lose stack
        System.out.println("Stack winners: " + stackWinners);
        System.out.println("Stack losers: " + stackLosers);
    }

    @Override
    public void update(boolean xwin, boolean owin, String command) {
        if (xwin){
            setXwin();
            System.out.println("X win: " + xwin + "   O win: " + owin);
        }
        if (owin){
            setOwin();
            System.out.println("X win: " + xwin + "   O win: " + owin);
        }
        if (command.equals("newgame") && queueO!= null && queueO!= null){
            whoIsPlaying();
        }
    }
    /*
    if Player1 is winner than stackWinners add player[indexPlayerX] player1, stackLosers add playerO player[indexPlayer0],
    else  player[indexPlayer0] player1, player[indexPlayerX] stackLosers add player1,
    */

}

