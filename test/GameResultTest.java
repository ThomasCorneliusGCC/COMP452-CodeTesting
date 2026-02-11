import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameResultTest {
    String personInOne = "You guessed it on the first try!";
    String computerInOne = "I guessed it on the first try!";

    @Test
    void personPlayInOneTest(){
        GameResult gr = new GameResult(true, 2,1);
        assertEquals(personInOne, gr.getGuessesText());
    }

    @Test
    void personPlayInMoreTest(){
        int numGuesses = 10;
        GameResult gr = new GameResult(true, 2,numGuesses);
        assertEquals("It took you " + numGuesses + " guesses.", gr.getGuessesText());

    }
    @Test
    void computerPlayInOneTest(){
        GameResult gr = new GameResult(false, 2,1);
        assertEquals(computerInOne, gr.getGuessesText());
    }
    @Test
    void computerPlayInMoreTest(){
        int numGuesses = 10;
        GameResult gr = new GameResult(false, 2,numGuesses);
        assertEquals("It took me " + numGuesses + " guesses.", gr.getGuessesText());

    }
}
