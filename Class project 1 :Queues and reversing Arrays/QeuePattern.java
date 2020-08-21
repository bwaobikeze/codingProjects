import java.util.*;

public class QeuePattern {
    /**********************************
     * This method Makes a queue and adds a number to the queue (enqueue) and poll
     * an number from the queue(Dequeue) and prints out the final number that is
     * left.
     ***********************************/
    public static void Queue() {
        Queue<Integer> number = new LinkedList<Integer>();
        number.add(5);
        number.add(3);
        number.poll();
        number.add(2);
        number.add(8);
        number.poll();
        number.poll();
        number.add(9);
        number.add(1);
        number.poll();
        number.add(7);
        number.add(6);
        number.poll();
        number.poll();
        number.add(4);
        number.poll();
        number.poll();
        System.out.println(" The last number in the Queue is: " + number);
    }

}