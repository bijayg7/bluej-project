
/**
 * Write a description of class PlayGame here.
 *
 * @author Bijay Gautam
 * @version 12/04/2022
 */
public class PlayGame
{

    /**
     * Constructor for objects of class PlayGame
     */
    public PlayGame()
    {
      
    }
    
    /**
     * main method
     */
    public static void main(String[] args)
    {
        byte round;
        byte level;
        boolean userWin;
        Game game;
        Level1 level1 = new Level1();
        Level2 level2 = new Level2();
        Level3 level3 = new Level3();
        level = 1;
        round = 1;
        game = level1;
        userWin = true;
        do{
            switch(level)
            {
                case 1:
                    game = level1;
                    userWin = game.dictionary();
                    break;
                case 2:
                    game = level2;
                    userWin = game.dictionary();
                    break;
                case 3:
                    game = level3;
                    userWin = game.dictionary();
                    break;
            }
            if (userWin)
            {
                game.nextLevel();
                level = game.getLevel();
            }
            else
            {
                game.nextRound();
            }
        } while ((round < 2) && (level <= 3));
        game.end();
    }

}
