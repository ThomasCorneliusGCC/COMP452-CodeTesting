import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HumanGuessesGameTest {
    @Test
    void GetNumGuessesZero() {
        HumanGuessesGame hGG = new HumanGuessesGame(new Random());
        assertEquals(0, hGG.getNumGuesses());
    }

    @Test
    void GetNumGuessesOne() {
        HumanGuessesGame hGG = new HumanGuessesGame(new Random());
        hGG.makeGuess(1);
        assertEquals(1, hGG.getNumGuesses());
    }

    @Test
    void GetNumGuessesMany() {
        HumanGuessesGame hGG = new HumanGuessesGame(new Random());
        for (int i = 0; i < 10; i++) {
            hGG.makeGuess(1);
        }
        assertEquals(10, hGG.getNumGuesses());
    }

    @Test
    void MakeGuessNegative() {
        HumanGuessesGame hGG = new HumanGuessesGame(new Random());
        GuessResult result = hGG.makeGuess(Integer.MIN_VALUE);
        assertEquals(GuessResult.LOW, result);
    }

    @Test
    void MakeGuessTooHigh() {
        HumanGuessesGame hGG = new HumanGuessesGame(new Random());
        GuessResult result = hGG.makeGuess(Integer.MAX_VALUE);
        assertEquals(GuessResult.HIGH, result);
    }

    @Test
    void MakeGuessCorrect() {
        HumanGuessesGame hGG = new HumanGuessesGame(new RandomForTest());
        GuessResult result = hGG.makeGuess(1000);
        assertEquals(GuessResult.CORRECT, result);
    }

    @Test
    void IsDoneFalse() {
        HumanGuessesGame hGG = new HumanGuessesGame(new Random());
        hGG.makeGuess(Integer.MIN_VALUE);
        assertFalse(hGG.isDone());
    }

    @Test
    void IsDoneTrue() {
        HumanGuessesGame hGG = new HumanGuessesGame(new RandomForTest());
        GuessResult result = hGG.makeGuess(1000);
        assertFalse(hGG.isDone());
    }
}

class RandomForTest extends Random {
    public RandomForTest() {
        super();
    }
    @Override
    public int nextInt(int maxExclusive) {
        return maxExclusive - 1;
    }
}
