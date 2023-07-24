import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
/**
 * Write a description of class Level1 here.
 *
 * @author Bijay Gautam
 * @version 12/04/2022
 */
public class Level1 extends Game
{
    // instance variables 
    private String input;
    private String selectedAnagrams;
    private String selectedWord;

    /**
     * Constructor for objects of class Level1
     */
    public Level1()
    {
        dictionary();
        showWelcome();
        randomWord();
        letters();
        userInput();
        
    }
    
    /**
     * importing dictionary from Game class
     * return boolean true
     */
    public boolean dictionary()
    {
        HashMap dictionary = getDictionary();
        return true;
    }
    
    /**
     * displaying welcome text in level 1
     *
     */
    public void showWelcome()
    {
        System.out.println("Welcome to \"The Word And Number Game\"");
        System.out.println();
        System.out.println("Level 1: Anagram");
        System.out.println();
        System.out.println("At this level, you are given a set of letters.\nYour task is to input all valid words that you can come up from the letters separated by spaces.\nNote that each word must use all letters.");
        System.out.println("You win if there are at least two correct words.");
        System.out.println("***");
    }
    
    /**
     * selecting random word from the dictionary
     * returns String selectedWord
     */
    private String randomWord()
    {
        Random number = new Random();
        ArrayList<String> sourceWord = new ArrayList<String>(dictionary.keySet());
        selectedWord = sourceWord.get(number.nextInt(sourceWord.size()));
        selectedAnagrams = dictionary.get(selectedWord);
        return selectedWord;
    }
    
    /**
     * tokenizing the word 
     * returns char letters
     */
    private char[] letters()
    {
        System.out.print("Your letters: ");
        String word = this.selectedWord;
        char[] letters = word.toCharArray();
        for(int i=0; i<letters.length; i++)
        {
            System.out.print(letters[i] + " ");
        }
        return letters;
    }
    
    /**
     * getting input from user 
     * match input with game data to dedcide result 
     */
    private String[] userInput()
    {
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        int matchCount = 0;
        String inputWords[] = input.split(" ");
        for (String word : inputWords) 
        {
            if (selectedAnagrams.contains(word))
            {
                matchCount++;
            }
        }
        if (matchCount >= 2)
        {
            System.out.println("Congratulation! You completed level 1 successfully");
        }
        else
        {
            System.out.println("Fail! at least two inputted words must be valid ");
            System.out.println("***");
        }
        return inputWords;
    }
    
}
