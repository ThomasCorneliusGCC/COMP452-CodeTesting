import com.opencsv.CSVReader;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StatsFileTest {
    @Test
    void testNumOfGamesNone(){
        String t = LocalDateTime.now().toString();
        String[][] data = {};
        CSVReaderForTest csvReaderTest = new CSVReaderForTest(data);
        StatsFile stats = new StatsFile(csvReaderTest);
        assertEquals(0, stats.numGames(5));
    }

    @Test
    void testNumOfGamesOne(){
        String t = LocalDateTime.now().toString();
        String[][] data = {
                {t,"1"},
                {t, "2"},
                {t, "3"},
                {t, "4"},
                {t, "5"},
                {t, "6"},
                {t, "7"},
                {t, "8"},
                {t, "9"},
                {t,"10"}};
        CSVReaderForTest csvReaderTest = new CSVReaderForTest(data);
        StatsFile stats = new StatsFile(csvReaderTest);
        for (int i = 0; i < 10; i++) {
            assertEquals(1, stats.numGames(i + 1));
        }
    }

    @Test
    void testNumOfGamesMany(){
        String t = LocalDateTime.now().toString();
        String[][] data = {
                {t,"1"},
                {t, "1"},
                {t, "1"},
                {t, "1"},
                {t, "1"},
                {t, "5"},
                {t, "5"},
                {t, "5"},
                {t, "5"},
                {t,"5"}};
        CSVReaderForTest csvReaderTest = new CSVReaderForTest(data);
        StatsFile stats = new StatsFile(csvReaderTest);
        assertEquals(5, stats.numGames(1));
        assertEquals(5, stats.numGames(5));
    }

    @Test
    void testNumOfGamesLarge(){
        String t = LocalDateTime.now().toString();

        String[][] data = {{t, Integer.toString(Integer.MAX_VALUE)}};

        CSVReaderForTest csvReaderTest = new CSVReaderForTest(data);
        StatsFile stats = new StatsFile(csvReaderTest);
        assertEquals(1, stats.numGames(Integer.MAX_VALUE));
    }

    @Test
    void testMaxGuessesNone(){
        String[][] data = {};
        CSVReaderForTest csvReaderTest = new CSVReaderForTest(data);
        StatsFile stats = new StatsFile(csvReaderTest);
        assertEquals(0, stats.maxNumGuesses());
    }

    @Test
    void testMaxGuessesOne(){
        String t = LocalDateTime.now().toString();

        String[][] data = {
                {t,"1"},
                {t, "2"},
                {t, "3"},
                {t, "4"},
                {t, "5"},
                {t, "6"},
                {t, "7"},
                {t, "8"},
                {t, "9"},
                {t,"10"}};
        CSVReaderForTest csvReaderTest = new CSVReaderForTest(data);
        StatsFile stats = new StatsFile(csvReaderTest);
        assertEquals(10, stats.maxNumGuesses());
    }

    @Test
    void testMaxGuessesStart(){
        String t = LocalDateTime.now().toString();

        String[][] data = {
                {t, "5"},
                {t,"1"},
                {t, "1"},
                {t, "1"},
                {t, "1"},
                {t, "1"},
                {t, "1"},
                {t, "1"},
                };

        CSVReaderForTest csvReaderTest = new CSVReaderForTest(data);
        StatsFile stats = new StatsFile(csvReaderTest);
        assertEquals(5, stats.maxNumGuesses());
    }

    @Test
    void testMaxGuessesLarge(){
        String t = LocalDateTime.now().toString();

        String[][] data = {{t, Integer.toString(Integer.MAX_VALUE)}};

        CSVReaderForTest csvReaderTest = new CSVReaderForTest(data);
        StatsFile stats = new StatsFile(csvReaderTest);
        assertEquals(Integer.MAX_VALUE, stats.maxNumGuesses());
    }
}

class CSVReaderForTest extends CSVReader {

    private final String[][] data;
    private int currentRow = 0;

    public CSVReaderForTest(String[][] data) {
        super(new java.io.StringReader("")); // we have to call super, but it won't be used
        this.data = data;
    }

    @Override
    public String[] readNext() throws IOException {
        if (currentRow >= data.length) return null;
        return data[currentRow++];
    }
}

