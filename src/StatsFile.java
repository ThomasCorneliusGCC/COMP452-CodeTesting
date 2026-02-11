import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * File-backed implementation of GameStats
 *
 * Returns the number of games *within the last 30 days* where the person took a given number of guesses
 */
public class StatsFile extends GameStats {
    public static final String FILENAME = "guess-the-number-stats.csv";


    // maps the number of guesses required to the number of games within
    // the past 30 days where the person took that many guesses
    private SortedMap<Integer, Integer> statsMap;

    public StatsFile() {
        statsMap = new TreeMap<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(FILENAME))) {
            StatsFileInit(csvReader);
        } catch(NumberFormatException nfe){
            // NOTE: In a full implementation, we would log this error and possibly alert the user
            throw nfe;
        }
        catch(DateTimeParseException dtpe){
            // NOTE: In a full implementation, we would log this error and possibly alert the user
            throw dtpe;
        } catch (CsvValidationException e) {
        // NOTE: In a full implementation, we would log this error and alert the user
        // NOTE: For this project, you do not need unit tests for handling this exception.
        } catch (IOException e) {
        // NOTE: In a full implementation, we would log this error and alert the user
        // NOTE: For this project, you do not need unit tests for handling this exception.
        }
    }

    public StatsFile(CSVReader reader) {
        statsMap = new TreeMap<>();
        try {
            StatsFileInit(reader);
        } catch(NumberFormatException nfe){
            // NOTE: In a full implementation, we would log this error and possibly alert the user
            throw nfe;
        }
        catch(DateTimeParseException dtpe){
            // NOTE: In a full implementation, we would log this error and possibly alert the user
            throw dtpe;
        } catch (CsvValidationException e) {
            // NOTE: In a full implementation, we would log this error and alert the user
            // NOTE: For this project, you do not need unit tests for handling this exception.
        } catch (IOException e) {
            // NOTE: In a full implementation, we would log this error and alert the user
            // NOTE: For this project, you do not need unit tests for handling this exception.
        }
    }

    public void StatsFileInit(CSVReader reader) throws DateTimeParseException, NumberFormatException, CsvValidationException, IOException {
        LocalDateTime limit = LocalDateTime.now().minusDays(30);
        String[] values = null;
        while ((values = reader.readNext()) != null) {
            // values should have the date and the number of guesses as the two fields
            LocalDateTime timestamp = LocalDateTime.parse(values[0]);
            int numGuesses = Integer.parseInt(values[1]);

            if (timestamp.isAfter(limit)) {
                statsMap.put(numGuesses, 1 + statsMap.getOrDefault(numGuesses, 0));
            }
        }
    }

    @Override
    public int numGames(int numGuesses) {
        return statsMap.getOrDefault(numGuesses, 0);
    }

    @Override
    public int maxNumGuesses(){
        return (statsMap.isEmpty() ? 0 : statsMap.lastKey());
    }

    public String sendToFile(GameResult result, String filename){
        if(result.humanWasPlaying) {
            // write stats to file
            try (CSVWriter writer = new CSVWriter(new FileWriter(filename, true))) {

                String[] record = new String[2];
                record[0] = LocalDateTime.now().toString();
                record[1] = Integer.toString(result.numGuesses);

                writer.writeNext(record);

                return "Success";
            } catch (IOException e) {
                return e.toString();
                // NOTE: In a full implementation, we would log this error and possibly alert the user
                // NOTE: For this project, you do not need unit tests for handling this exception.
            }
        }
        return "notHuman";
    }
}
