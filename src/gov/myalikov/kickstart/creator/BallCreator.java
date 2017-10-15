/**
 * BallCreator
 * <p>
 * Creates ball entity objects
 *
 * @author Arthur Myalikov;
 */
package gov.myalikov.kickstart.creator;

import gov.myalikov.kickstart.entitie.Ball;
import gov.myalikov.kickstart.exception.DataTechnicalException;
import gov.myalikov.kickstart.parser.BallStringParser;
import gov.myalikov.kickstart.reader.BallDataReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class BallCreator {
    private static Logger logger = LogManager.getLogger("BallCreator");
    private BallDataReader ballDataReader = new BallDataReader();
    private BallStringParser ballStringParser = new BallStringParser();

    public ArrayList<Ball> createBallsFromFile(String delimiters) {
        ArrayList<Ball> balls = new ArrayList<>();
        ArrayList<String> stringsFromFile = ballDataReader.readDataFromDefaultFile();
        for (String string : stringsFromFile) {
            try {
                Ball newBall = new Ball(ballStringParser.extractRadiusFromString(string),
                        ballStringParser.extractPointFromString(string));
                balls.add(newBall);
            } catch (DataTechnicalException e) {
                logger.log(Level.DEBUG, e.getMessage());
            }
        }
        return balls;
    }
}
