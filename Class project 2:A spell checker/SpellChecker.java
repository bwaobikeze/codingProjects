import java.util.Hashtable;
import java.util.*;
import java.util.Scanner;

public class SpellChecker {
    // the array that stores my words in
    // as well as suggestions in results
    static Hashtable<Integer, String> tableOfWords = new Hashtable<Integer, String>();
    String[] myWords = { "dad", "sad", "green", "brian", "eye", "geen" };
    static ArrayList<String> result = new ArrayList<String>();

    // A constructer for my hashing function
    SpellChecker() {
        for (int i = 0; i < myWords.length; i++) {
            tableOfWords.put(i, myWords[i]);
        }
    }

    /*
     * This method takes in the input of the user and compares it to the words in
     * the Hashtable and if the word they typed is in the hashtable it prints out
     * the word if not it goes through a series of methods that fix an error
     * possiable made by the user such as a mispelling.
     */
    public static void spellCheck(String input) {
        if (tableOfWords.contains(input)) {
            System.out.println("Good Job " + input + " Is in the Hashtable");
        } else {
            System.out.println(" I Dont Know what this word is: " + input);
            System.out.println(" Did You mean ? : ");
            StringBuilder getWord = new StringBuilder(input);
            // differnt methods that fix errors
            deleteChar(getWord);
            swapChar(getWord);
            insertChar(getWord);
            replaceChar(getWord);
            // if word cannot be fixed through all of the methods
            // the word is not a word and and prints out "cant be found".
            if (result.size() == 0) {
                System.out.println(" The word you entered cant be found");

            } else {
                System.out.println(result);
            }
        }

    }
    // this method deletes a character using stringbuilder
    // each time it takes out a character it compares it to the hashtabel to check
    // if it is an actual word in the table if it matches
    // it adds it to the arrayList result,
    // for the word that is the user mispelled it stores a suggestion

    public static void deleteChar(StringBuilder getWord) {

        for (int i = 0; i < getWord.length(); i++) {
            if (i == 0) {
                String myString = getWord.substring(i + 1, getWord.length());
                if (tableOfWords.contains(myString) && !result.contains(myString.toString())) {
                    result.add(myString);
                }

            } else if (i == getWord.length() - 1) {
                String myString = getWord.substring(0, getWord.length() - 1);
                if (tableOfWords.contains(myString) && !result.contains(myString.toString())) {
                    result.add(myString);
                }

            } else {
                String myString = getWord.substring(0, i) + getWord.substring(i + 1, getWord.length());
                if (tableOfWords.contains(myString) && !result.contains(myString.toString())) {
                    result.add(myString);
                }

            }

        }

    }

    // using stringbuilder swap the two adjacent char at different indexes in the
    // string.
    public static void swapChar(StringBuilder data) {

        for (int i = 0; i < data.length() - 1; i++) {
            StringBuilder newData = new StringBuilder(data);

            char num1 = newData.charAt(i), num2 = newData.charAt(i + 1);
            newData.setCharAt(i, num2);
            newData.setCharAt(i + 1, num1);
            if (tableOfWords.contains(newData.toString()) && !result.contains(newData.toString())) {
                result.add(newData.toString());
            }

        }

    }

    // this function using the letters in the word insersts letters
    // in the word and or string
    public static void insertChar(StringBuilder letter) {

        for (int i = 0; i < letter.length(); i++) {

            char currentLetter = letter.charAt(i);

            for (int j = 1; j < letter.length(); j++) {
                StringBuilder newLetter = new StringBuilder(letter);
                newLetter.insert(j, currentLetter);

                if (tableOfWords.contains(newLetter.toString()) && !result.contains(newLetter.toString())) {
                    result.add(newLetter.toString());
                }

            }

        }

    }
    // replaceChar method replaces a charcter using StringBuilder

    public static void replaceChar(StringBuilder anotherWord) {

        for (int i = 0; i < anotherWord.length(); i++) {
            // takes the chararacter at that index and stores it in currentletter
            char currentLetter = anotherWord.charAt(i);

            for (int j = 0; j < anotherWord.length(); j++) {
                if (i == j) {
                    continue;
                }
                // and goes through the word replacing each letter with that selected letter
                // and repeats with differnt letters in the String
                StringBuilder newAnotherword = new StringBuilder(anotherWord);
                newAnotherword.setCharAt(j, currentLetter);
                if (tableOfWords.contains(newAnotherword.toString()) && !result.contains(newAnotherword.toString())) {
                    result.add(newAnotherword.toString());
                }

            }

        }

    }
}
