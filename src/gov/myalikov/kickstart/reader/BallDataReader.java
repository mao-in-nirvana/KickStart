/**
 * BallDataReader
 * <p>
 * Reads data form file
 *
 * @author Arthur Myalikov;
 */
package gov.myalikov.kickstart.reader;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BallDataReader {
    private static Logger logger = LogManager.getLogger("BallDataReader");
    private final String FILENAME = "input/input.txt";

    public ArrayList<String> readDataFromDefaultFile() {
        ArrayList<String> strings = new ArrayList<>();
        if (new File(FILENAME).exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(FILENAME));
                String bufferString = br.readLine();
                while (bufferString != null) {
                    strings.add(bufferString);
                    bufferString = br.readLine();
                }
            } catch (IOException e) {
                logger.log(Level.FATAL, "File \"" + FILENAME + "\" is empty.");
                throw new RuntimeException();
            }
        } else {
            logger.log(Level.FATAL, "File \"" + FILENAME + "\" not found.");
            throw new RuntimeException();
        }
        return strings;
    }
}