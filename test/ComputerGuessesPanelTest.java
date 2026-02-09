import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerGuessesPanelTest {
    @Test
    void testStartValue(){
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();

        assertEquals(cgp.setStartValues(), 501);
    }
    @Test
    void testLowBtn() {
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();

        assertEquals(cgp.lowBtnPress(), 251);
    }

    @Test
    void testHighBtn() {
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();

        assertEquals(cgp.highBtnPress(), 751);
    }

    @Test
    void testLowHigh() {
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();
        cgp.lowBtnPress();

        assertEquals(cgp.highBtnPress(), 377);
    }
    @Test
    void testHighLow() {
        ComputerGuessesPanel cgp = new ComputerGuessesPanel();
        cgp.setStartValues();
        cgp.highBtnPress();

        assertEquals(cgp.lowBtnPress(), 627);
    }
}
