import java.util.*;
/**
 * Write a description of class Level2 here.
 *
 * @author Bijay Gautam
 * @version 12/04/2022
 */
public class Level2 extends Game
{
    private String scrambledWord;
    private String selectedWord;
    private String sourceWord;

    /**
     * Constructor for objects of class Level2
     */
    public Level2()
    {
        dictionary();
        showWelcome();
        //getRandomWord();
        //getScrambledWords();
        scrambledWord();
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
        System.out.println("Level 2: Scrambled Words");
        System.out.println();
        System.out.println("At this level, you are given a set of scrambled words.\nYour task is to input a non-scrambled version of the words that you can come up with, separated by spaces.");
        System.out.println("You win if there are at least three correct words.");
        System.out.println("***");
    }
    
    /**
     * getting 5 scrambled random word with spaces in between them
     */
    private void scrambledWord()
    {
        StringBuilder output = new StringBuilder();
        for(int i=0; i<5; i++)
        {
            String random = getRandomWord();
            String scramble = getScrambledWords();
            output.append(scramble + " ");
        }
        System.out.print("Your scrambled words: " + output);
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
     * scrambling the word 
     */
    private String getScrambledWords()
    {
        String word = this.selectedWord;
        char[] letters = word.toCharArray();
        int i=1;
        while(i<letters.length-1)
        {
            char let = letters[i];
            letters[i] = letters[i+1];
            letters[i+1] = let;
            i=i+2;
        }
        String newWord = String.valueOf(letters);
        return newWord;
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

        if (matchCount >= 3)
        {
            System.out.println("Congratulation! You completed level 2 successfully");
        }
        else
        {
            System.out.println("Fail! at least three inputted words must be valid ");
            System.out.println("***");
        }
        return inputWords;
    }
}
