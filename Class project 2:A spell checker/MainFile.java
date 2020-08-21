import java.util.Scanner;
import java.util.Hashtable;
import java.util.*;

public class MainFile {
    // main method that gets the users input.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter a Word: ");
        String word = scan.nextLine();

        SpellChecker f = new SpellChecker();
        f.spellCheck(word);

    }

}