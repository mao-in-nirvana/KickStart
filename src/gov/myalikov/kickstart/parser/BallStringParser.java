/**
 * BallStringParser
 * <p>
 * Parse data
 *
 * @author Arthur Myalikov;
 */
package gov.myalikov.kickstart.parser;

import gov.myalikov.kickstart.entitie.Point;
import gov.myalikov.kickstart.exception.DataTechnicalException;
import gov.myalikov.kickstart.validator.BallDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallStringParser {

    private static Logger logger = LogManager.getLogger("BallStringParser");
    private static BallDataValidator validator;
    private final String DEFAULT_DELIMITER = "\\s";

    public Point extractPointFromString(String string)
            throws DataTechnicalException {
        String[] strings = string.split(DEFAULT_DELIMITER, BallDataValidator.getAmountOfParameters());
        if (!validator.validator(strings, DEFAULT_DELIMITER)) {
            throw new DataTechnicalException("Invalid input data. The line was skipped.");
        } else {
            return new Point(Double.parseDouble(strings[1]),
                    Double.parseDouble(strings[2]),
                    Double.parseDouble(strings[3]));
        }
    }

    public double extractRadiusFromString(String string)
            throws DataTechnicalException {
        String[] strings = string.split(DEFAULT_DELIMITER, BallDataValidator.getAmountOfParameters());
        if (!validator.validator(strings, DEFAULT_DELIMITER)) {
            throw new DataTechnicalException("Invalid input data. The line was skipped.");
        } else {
            return Double.parseDouble(strings[0]);
        }
    }

}
