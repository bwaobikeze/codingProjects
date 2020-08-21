import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class readFile {

    /****************************************
     * This Method Creats an ArrayList and makes a file as well as uses a scanner to
     * read through the content of the file "number.txt" I set x = to 0 becasue that
     * will be my counter set my variable for total to 1 so i can multply all my
     * elements in my ArrayList
     ****************************************/
    public static void fileR() throws FileNotFoundException {
        ArrayList<Integer> number_File = new ArrayList<Integer>();
        File file = new File("number.txt");
        Scanner scan = new Scanner(file);
        int x = 0;
        long total = 1;
        /*************************************
         * I check whether the contents of the file is an integer. if they are 20
         * numbers from the file will be added to the Arraylist
         * 
         ****************************************/
        if (scan.hasNextInt()) {

            while (scan.hasNextLine() && x < 20) {
                number_File.add(scan.nextInt());
                x++;
            }

        }

        /*****************************************
         * I check whether the contents of the file is an integer. if they are NOT the
         * line Prints out There is a Unwanted type in your file try changing it
         *************************************************/
        if (!scan.hasNextInt()) {

            System.out.println(" There is a Unwanted type in your file Try Changing it");
            scan.next();
        }

        // A Loop that multiplies each number to each other

        for (int i = 0; i < number_File.size(); i++) {

            total *= number_File.get(i);

        }
        scan.close();

        // sorts the contents of the ArrayList
        Collections.sort(number_File);

        // Prints out the numbers in the ArrayList in assending order as well as the
        // maximume value and the
        // Minimum value and prints out the product of all the numbers
        System.out.println(number_File);
        System.out.println("The Maximum Number Is:" + Collections.max(number_File));
        System.out.println("The Minimum Number Is:" + Collections.min(number_File));
        System.out.println("The total is: " + total);

    }

}
