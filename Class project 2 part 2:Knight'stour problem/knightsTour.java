import java.util.*;

import javax.lang.model.util.ElementScanner6;

import java.io.*;

public class knightsTour {
    // The Data structures that I used
    StringBuilder output = new StringBuilder();
    int count = 0;
    public static int[] poppedItem;
    int vertex = 5;
    public int[] position = { 0, 0 };
    public int[][] bored = new int[vertex][vertex];
    Stack<int[]> knights = new Stack<int[]>();

    // The main method where i call my algorithim
    public static void main(String[] args) {
        knightsTour graph = new knightsTour();

        graph.walkBored();

    }

    // my constuctor that determins size of the bored and sets all spaces to 0
    public knightsTour() {

        int i, j;
        for (i = 0; i < vertex; i++) {
            for (j = 0; j < vertex; j++) {
                bored[i][j] = 0;

            }
        }

    }
    // This function/method just simply prints out the 2D Array/ adjecency matrix

    public void displayBored() {

        for (int i = 0; i < vertex; i++) {
            System.out.println();

            for (int j = 0; j < vertex; j++) {
                System.out.print(" " + bored[i][j]);

            }
            System.out.println();

        }
        System.out.println("----------");
    }

    /*
     * This method is the knight. in this method the knight checkes for all
     * possiable moves while still maintaining the ability to make legal knight
     * moves. ----------- once visted it changes its cuurent position to 1 and then
     * pushes that cordinate to the stack also with this method the knight checks
     * for all possiable directions from the point it is already at. the new
     * position is also assigned to the current position so it does not constantally
     * restart at the starting position.
     * 
     */
    public int searchKnight() {
        if (count == 0) {
            bored[position[0]][position[1]] = 1;
            knights.push(new int[] { position[0], position[1] });

        }
        count++;
        if (position[0] + 2 > -1 && position[0] + 2 < vertex && position[1] + 1 > -1 && position[1] + 1 < vertex
                && bored[position[0] + 2][position[1] + 1] != 1) {

            // Current Spot => To Next spot
            // push it in stack and mark it ask 1
            bored[position[0] + 2][position[1] + 1] = 1;
            position[0] = position[0] + 2;
            position[1] = position[1] + 1;
            knights.push(new int[] { position[0], position[1] });

            System.out.println(Integer.toString(knights.peek()[0]) + "," + Integer.toString(knights.peek()[1]));

            this.displayBored();
            return 1;

        } else if (position[0] + 2 > -1 && position[0] + 2 < vertex && position[1] - 1 > -1 && position[1] - 1 < vertex
                && bored[position[0] + 2][position[1] - 1] != 1) {
            // Current Spot => To Next spot
            // push it in stack and mark it ask 1
            bored[position[0] + 2][position[1] - 1] = 1;
            position[0] = position[0] + 2;
            position[1] = position[1] - 1;
            knights.push(new int[] { position[0], position[1] });
            System.out.println(Integer.toString(knights.peek()[0]) + "," + Integer.toString(knights.peek()[1]));

            this.displayBored();
            return 1;

        } else if (position[0] - 2 > -1 && position[0] - 2 < vertex && position[1] + 1 > -1 && position[1] + 1 < vertex
                && bored[position[0] - 2][position[1] + 1] != 1) {
            // Current Spot => To Next spot
            // push it in stack and mark it ask 1

            bored[position[0] - 2][position[1] + 1] = 1;
            position[0] = position[0] - 2;
            position[1] = position[1] + 1;
            knights.push(new int[] { position[0], position[1] });
            System.out.println(Integer.toString(knights.peek()[0]) + "," + Integer.toString(knights.peek()[1]));

            this.displayBored();

            return 1;

        } else if (position[0] - 2 > -1 && position[0] - 2 < vertex && position[1] - 1 > -1 && position[1] - 1 < vertex
                && bored[position[0] - 2][position[1] - 1] != 1) {
            // Current Spot => To Next spot
            // push it in stack and mark it ask 1

            bored[position[0] - 2][position[1] - 1] = 1;
            position[0] = position[0] - 2;
            position[1] = position[1] - 1;
            knights.push(new int[] { position[0], position[1] });
            System.out.println(Integer.toString(knights.peek()[0]) + "," + Integer.toString(knights.peek()[1]));

            this.displayBored();
            return 1;

        } else if (position[0] + 1 > -1 && position[0] + 1 < vertex && position[1] + 2 > -1 && position[1] + 2 < vertex
                && bored[position[0] + 1][position[1] + 2] != 1) {
            // push it in stack and mark it ask 1
            bored[position[0] + 1][position[1] + 2] = 1;
            position[0] = position[0] + 1;
            position[1] = position[1] + 2;
            knights.push(new int[] { position[0], position[1] });
            System.out.println(Integer.toString(knights.peek()[0]) + "," + Integer.toString(knights.peek()[1]));

            this.displayBored();
            return 1;

        } else if (position[0] - 1 > -1 && position[0] - 1 < vertex && position[1] + 2 > -1 && position[1] + 2 < vertex
                && bored[position[0] - 1][position[1] + 2] != 1) {
            // Current Spot => To Next spot
            // push it in stack and mark it ask 1

            bored[position[0] - 1][position[1] + 2] = 1;
            position[0] = position[0] - 1;
            position[1] = position[1] + 2;
            knights.push(new int[] { position[0], position[1] });
            System.out.println(Integer.toString(knights.peek()[0]) + "," + Integer.toString(knights.peek()[1]));

            this.displayBored();
            return 1;

        } else if (position[0] + 1 > -1 && position[0] + 1 < vertex && position[1] - 2 > -1 && position[1] - 2 < vertex
                && bored[position[0] + 1][position[1] - 2] != 1) {
            // Current Spot => To Next spot
            // push it in stack and mark it ask 1

            bored[position[0] + 1][position[1] - 2] = 1;
            position[0] = position[0] + 1;
            position[1] = position[1] - 2;
            knights.push(new int[] { position[0], position[1] });
            System.out.println(Integer.toString(knights.peek()[0]) + "," + Integer.toString(knights.peek()[1]));

            this.displayBored();
            return 1;

        } else if (position[0] - 1 > -1 && position[0] - 1 < vertex && position[1] - 2 > -1 && position[1] - 2 < vertex
                && bored[position[0] - 1][position[1] - 2] != 1) {
            // Current Spot => To Next spot
            // push it in stack and mark it ask 1

            bored[position[0] - 1][position[1] - 2] = 1;
            position[0] = position[0] - 1;
            position[1] = position[1] - 2;
            knights.push(new int[] { position[0], position[1] });
            System.out.println(Integer.toString(knights.peek()[0]) + "," + Integer.toString(knights.peek()[1]));

            displayBored();
            return 1;

        } else {
            /*
             * when the knight is here it has reached the end where it cant move so it pops
             * out the stack and goes back to the last known postion before pushing into the
             * stack and assigns that coordinate to the current position.
             * 
             */
            poppedItem = knights.pop();
            output.append("popping stack: " + poppedItem[0] + "," + poppedItem[1] + " => ");

            if (!knights.empty()) {

                position[0] = knights.peek()[0];
                position[1] = knights.peek()[1];
                return 1;
            }

            displayBored();
            return 0;
        }

    }
    /*
     * each time in searchKnight when it goes through each condition it returns a 1
     * and once it hits the end of the mentod it return 0 walkbored is a method that
     * when searchknight returns a 1 searchknight has not visted all the spots in
     * the array so it calls the function again but if it returns a 0 the bored is
     * complete and prints out done.
     * 
     */

    public void walkBored() {

        int found = searchKnight();
        while (found != 0) {
            found = searchKnight();

        }

        System.out.println(output + "Done.");

    }

}