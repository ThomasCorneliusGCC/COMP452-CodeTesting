import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatsPanelTest {
    @Test
    void CountGamesZero() {
        try {
            String t = LocalDateTime.now().toString();
            String[][] data = {};
            CSVReaderForTest reader = new CSVReaderForTest(data);
            StatsPanel stats = new StatsPanel(new JPanel());
            assertEquals(0, stats.countGames(0, new StatsFile(reader)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void CountGamesMany() {
        try {
            String t = LocalDateTime.now().toString();
            String[][] data = {{t,"1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "5"},
                    {t, "5"},
                    {t, "5"},
                    {t, "5"},
                    {t,"5"}};
            CSVReaderForTest reader = new CSVReaderForTest(data);
            StatsPanel stats = new StatsPanel(new JPanel());
            assertEquals(0, stats.countGames(1, new StatsFile(reader)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void CreateBoundsOne() {
        try {
            String t = LocalDateTime.now().toString();
            String[][] data = {{t,"1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "5"},
                    {t, "5"},
                    {t, "5"},
                    {t, "5"},
                    {t,"5"}};
            CSVReaderForTest reader = new CSVReaderForTest(data);
            StatsPanel stats = new StatsPanel(new JPanel());
            assertEquals("1", stats.createBounds(0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void CreateBoundsMultiple() {
        try {
            String t = LocalDateTime.now().toString();
            String[][] data = {{t,"1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "5"},
                    {t, "5"},
                    {t, "5"},
                    {t, "5"},
                    {t,"5"}};
            CSVReaderForTest reader = new CSVReaderForTest(data);
            StatsPanel stats = new StatsPanel(new JPanel());
            assertEquals("2-3", stats.createBounds(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void CreateBoundsLast() {
        try {
            String t = LocalDateTime.now().toString();
            String[][] data = {{t,"1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "1"},
                    {t, "5"},
                    {t, "5"},
                    {t, "5"},
                    {t, "5"},
                    {t,"5"}};
            CSVReaderForTest reader = new CSVReaderForTest(data);
            StatsPanel stats = new StatsPanel(new JPanel());
            assertEquals("14 or more", stats.createBounds(7));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}