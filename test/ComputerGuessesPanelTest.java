import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerGuessesPanelTest {
    @Test
    void testStartValue(){
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();

        assertEquals(501, cgp.setStartValues());
    }
    @Test
    void testLowBtn() {
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();

        assertEquals(251, cgp.lowBtnPress());
    }
    @Test
    void testLowestPossible(){
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();

        for (int i = 0; i < 11; i++) {
            cgp.lowBtnPress();
        }
        assertEquals(1, cgp.lowBtnPress());
    }

    @Test
    void testHighBtn() {
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();

        assertEquals(751, cgp.highBtnPress());
    }

    @Test
    void testHighestPossible(){
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();

        for (int i = 0; i < 11; i++) {
            cgp.highBtnPress();
        }
        assertEquals(1000, cgp.highBtnPress());
    }

    @Test
    void testLowHigh() {
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();
        cgp.lowBtnPress();

        assertEquals(377, cgp.highBtnPress());
    }

    @Test
    void testHighLow() {
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();
        cgp.highBtnPress();

        assertEquals(627, cgp.lowBtnPress());
    }

    // all of these should be off my one
    @Test
    void testNumGuesses(){
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        // since set up makes a guess (501) it should tick up numGuess by 1
        assertEquals(1, cgp.getNumGuesses());
    }

    @Test
    void testNumGuessesLow(){
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.lowBtnPress();

        assertEquals(2, cgp.getNumGuesses());
    }

    @Test
    void testNumGuessesHigh(){
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.highBtnPress();

        assertEquals(2, cgp.getNumGuesses());
    }

    @Test
    void testNumGuessesManyLow(){
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();

        for (int i = 0; i < 10; i++) {
            cgp.lowBtnPress();
        }
        assertEquals(11, cgp.getNumGuesses());
    }

    @Test
    void testNumGuessesManyHigh(){
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();

        for (int i = 0; i < 10; i++) {
            cgp.highBtnPress();
        }
        assertEquals(11, cgp.getNumGuesses());
    }

    @Test
    void testNumGuessesHighLow(){
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();

        cgp.lowBtnPress();
        cgp.highBtnPress();

        assertEquals(3, cgp.getNumGuesses());
    }
}
