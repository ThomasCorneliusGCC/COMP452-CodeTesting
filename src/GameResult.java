/**
 * Data class to hold the result of a game
 * NOTE: You can refactor and edit this file if needed
 */
public class GameResult {
    public final boolean humanWasPlaying;
    public final int correctValue;
    public final int numGuesses;

    public GameResult(boolean humanWasPlaying, int correctValue, int numGuesses){
        this.humanWasPlaying = humanWasPlaying;
        this.correctValue = correctValue;
        this.numGuesses = numGuesses;
    }

    public String getGuessesText() {
        if(numGuesses == 1)
            return (humanWasPlaying ? "You" : "I") + " guessed it on the first try!";
        return "It took " + (humanWasPlaying ? "you" : "me") + " " + numGuesses + " guesses.";
    }

}
