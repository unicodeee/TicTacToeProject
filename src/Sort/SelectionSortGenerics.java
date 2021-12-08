package src.Sort;
import src.Player;

import java.util.*;


public class SelectionSortGenerics {
    public static  <E> void swap(E[] a, int i, int j) {
        if (i != j) {
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static <E extends Comparable<E>> void selectionSort(E[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // find index of smallest element
            int smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[smallest])<=0) {
                    smallest = j;
                }
            }
            swap(a, i, smallest);  // swap smallest to front
        }
    }

    public static void main(String[] args){
        SelectionSortGenerics firstsort = new SelectionSortGenerics();
        Player p1 = new Player(12, "Basdas");
        Player p2 = new Player(132, "Aasdasdsa");
        Player p3 = new Player(4, "Casdas");
        Player p4 = new Player(1, "Casdas");
        Player p5 = new Player(4, "Aasdasdsa");

       Player[] players= {p1, p2, p3, p4, p5};


        Deque<Player> stackWinners = new LinkedList<Player>();
        for (Player x : players){
            stackWinners.add(x);
        }

        System.out.println("Stack winners: " + stackWinners);

        Player[] arrayOfWinners = new Player[stackWinners.size()];
        arrayOfWinners = stackWinners.toArray(arrayOfWinners);

        for (int j = 0; j < arrayOfWinners.length; j++){     // print array
            System.out.println(arrayOfWinners[j].toString());
        }

        System.out.println();
        firstsort.selectionSort(arrayOfWinners); // print Sorted array
        for (Player x : arrayOfWinners){
            System.out.println(x.toString());
        }
    }



    }

