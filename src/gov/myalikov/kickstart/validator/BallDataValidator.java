/**
 * BallDataValidator
 * <p>
 * Validates Ball data
 *
 * @author Arthur Myalikov;
 */
package gov.myalikov.kickstart.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class BallDataValidator {

    private static final int AMOUNT_OF_PARAMETERS = 4;

    private static Logger logger = LogManager.getLogger("BallDataValidator");

    public static int getAmountOfParameters() {
        return AMOUNT_OF_PARAMETERS;
    }

    public boolean radiusValidator(double radius) {
        if (radius > 0) {
            logger.log(Level.INFO, "Radius (" + radius + ") is valid.");
            return true;
        } else {
            logger.log(Level.DEBUG, "Invalid radius (" + radius + ").");
            return false;
        }
    }

    public boolean delimiterValidator(String delimiter) {
        if (delimiter.length() > 0) {
            logger.log(Level.INFO, "Delimiter \"" + delimiter + "\" is valid.");
            return true;
        } else {
            logger.log(Level.DEBUG, "Invalid delimiter string size (" + delimiter.length() + ").");
            return false;
        }
    }

    private boolean amountOfParametersValidator(int amountOfParameters) {
        if (amountOfParameters >= AMOUNT_OF_PARAMETERS) {
            logger.log(Level.INFO, "Amount of parameters (" + amountOfParameters + ") is valid.");
            return true;
        } else {
            logger.log(Level.DEBUG, "Invalid amount of parameters (" + amountOfParameters + ").");
            return false;
        }
    }


    private boolean doubleInStringValidator(String string) {
        String DOUBLE_PATTERN_REGEX = "(-*\\d+\\.\\d+)";
        Pattern pattern = Pattern.compile(DOUBLE_PATTERN_REGEX);
        if (pattern.matcher(string).matches()) {
            logger.log(Level.INFO, "String is valid, " + string + " is double.");
            return true;
        } else {
            logger.log(Level.DEBUG, "String is invalid. \"" + string + "\" is not a double.");
            return false;
        }
    }



    /**
     * validator
     * <p>
     * Validates all data in string.
     * Uses all validator methods
     * except delimiter validator.
     *
     * @param strings
     * @return
     */
    public boolean validator(String[] strings) {
        boolean valid = true;
        if (!amountOfParametersValidator(strings.length)) {
            valid = false;
        } else if (!doubleInStringValidator(strings[0])) {
            valid = false;
        } else if (!radiusValidator(Double.parseDouble(strings[0]))) {
            valid = false;
        } else {
            for (int i = 1; i < strings.length; i++) {
                if (!doubleInStringValidator(strings[i])) {
                    valid = false;
                }
            }
        }
        return valid;
    }

}
