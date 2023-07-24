import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Write a description of class Game here.
 *
 * @author Bijay Gautam
 * @version 12/04/2022
 */
public abstract class Game
{
    // instance variables 
    public HashMap<String, String> dictionary;
    private byte level;
    private byte round;
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        level = 1;
        round = 1;
        dictionaryWords();
        
    }
    
    /**
     * creating dictionary 
     */
    private void dictionaryWords()
    {
        dictionary = new HashMap();
        dictionary.put("late", "tale, teal");
        dictionary.put("pate", "peat, tape");
        dictionary.put("pare", "pear, reap");
        dictionary.put("parse", "asper, pares, pears, prase");
        dictionary.put("rate", "tare, tear");
        dictionary.put("tales", "stale, slate, tesla, steal, least");
        dictionary.put("east", "eats, sate, seat, seta, teas");
        dictionary.put("alerts", "alters, artels, estral, laster, ratels, salter, slater, staler");
        dictionary.put("post", "pots, spot, stop, tops");
        dictionary.put("alerting", "altering, integral, relating, triangle");
        dictionary.put("steak", "skate, stake, takes");
        dictionary.put("live", "evil, veil, vile");
        dictionary.put("meat", "mate, team, tame");
        dictionary.put("insert", "estrin, inerts, inters, niters, nitres, sinter, triens, trines");
        dictionary.put("laser", "earls, reals, rales, lares");
        dictionary.put("lapse", "peals, pleas, pales, sepal");
        dictionary.put("angle", "angel, glean, genal");
        dictionary.put("super", "purse, sprue");
        dictionary.put("scrape", "capers, crapes, spacer, pacers");
        dictionary.put("retains", "stainer, starnie, resiant, nastier, retinas");
    }
    
    /**
     * accessor method for dictionary
     * returns dictionary
     */
    public HashMap getDictionary()
    {
        return dictionary;
    }
    
    /**
     * accessor method for level
     * returns level
     */
    public byte getLevel()
    {
        return level;
    }
    
    /**
     * increase the level by 1
     */
    public void nextLevel()
    {
        level++;
    }
    
    /**
     * accessor method for round
     * returns round
     */
    public byte getRound() {
        return round;
    }
    
    /**
     * increase the round by 1
     */
    public void nextRound() {
           round++;
    }
    
    /**
     * ending the game
     */
    public void end() 
    {
        if (level > 3) 
        {
            System.out.println("You are the winner");
        } 
        else if (round > 2)
        {
            System.out.println("You are the looser");
        }
    }
    public abstract boolean dictionary(); //abstract method
    public abstract void showWelcome(); //abstract method
    
}
