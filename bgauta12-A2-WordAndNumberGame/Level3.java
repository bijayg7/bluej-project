import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Level3 here.
 *
 * @author Bijay Gautam
 * @version 12/04/2022
 */
public class Level3 extends Game
{
    //instance variables
    private String selectedWord;
    private String encodedWord;

    /**
     * Constructor for objects of class Level3
     */
    public Level3()
    {
        dictionary();
        showWelcome();
        hasCode();
        userInput();
    }
    
    /**
     * extracting dictionary 
     */
    public boolean dictionary()
    {
        HashMap dictionary = getDictionary();
        return true;
    }
    
    /**
     * print welcome messages
     */
    public void showWelcome()
    {
        System.out.println("Welcome to \"The Word And Number Game\"");
        System.out.println();
        System.out.println("Level 1: Encoded Words");
        System.out.println();
        System.out.println("At this level, you are given a set of encoded words.\nYour task is to input the decoded version of the words that you can come up with.");
        System.out.println("You win if all words are correctly decoded.");
        System.out.println("***");
    }
    
    /**
     * getting 5 encoded words with comma between them
     */
    private void hasCode()
    {
        StringBuilder output = new StringBuilder();
        for(int i=0; i<5; i++)
        {
            String word = getRandomWord();
            String encodedWord = getEncodedWord();
            if (i==4)
            {
                output.append(encodedWord);
            }
            else
            {
                output.append(encodedWord + ",");
            }
        }
        System.out.println(output);
    }
    
    /**
     * get a random word from dictionary
     *
     */
    private String getRandomWord()
    {
        Random number = new Random();
        ArrayList<String> sourceWord = new ArrayList<String>(dictionary.keySet());
        selectedWord = sourceWord.get(number.nextInt(sourceWord.size()));
        return selectedWord;
    }
    
    /**
     * get a random character in form of String 
     * get a number between 0-97
     * replace the word with random characters and numbers 
     */
    private String getEncodedWord()
    {
        Random number = new Random();
        StringBuilder encodedWord = new StringBuilder();
        char[] special = {'!', '@', '#', '$', '%', '^', '&', '*', '+'};
        for(int i=0; i<selectedWord.length(); i++)
        {
            char c = selectedWord.charAt(i);
            byte code = (byte)(c-97); //reffered by tutor 
            encodedWord.append("" + code);
            int randIndex = number.nextInt(8);
            c = special[randIndex];
            encodedWord.append(c);
        }
        return encodedWord.toString();
    }
    
    /**
     * getting input from user 
     * match input with game data to dedcide result 
     */
    private String[] userInput()
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int matchCount = 0;
        String inputWords[] = input.split(" ");
        for (String word : inputWords) 
        {
            if (selectedWord.contains(word))
            {
                matchCount++;
            }
        }

        if (matchCount == input.length())
        {
            System.out.println("Congratulation! You won the game");
        }
        else
        {
            System.out.println("Fail! all inputted words must be valid ");
            System.out.println("***");
        }
        return inputWords;
    }
}
