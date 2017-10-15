package test.gov.myalikov.kickstart.validator;

import gov.myalikov.kickstart.validator.BallDataValidator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BallDataValidatorTest {
    private final double VALID_RADIUS = 42.0;
    private final double INVALID_RADIUS = 0.0;
    private final int VALID_AMOUNT_OF_PARAMETERS = 42;
    private final int INVALID_AMOUNT_OF_PARAMETERS = 2;
    private final String VALID_DELIMITER = "\\s";
    private final String INVALID_DELIMITER = "";
    private final String VALID_DOUBLE_IN_STRING = "-0.42";
    private final String INVALID_DOUBLE_IN_STRING = "42z";

    private BallDataValidator ballDataValidator;

    @BeforeMethod
    public void initBallDataValidator() {
        ballDataValidator = new BallDataValidator();
    }

    @AfterMethod
    public void clearBallDataValidator() {
        ballDataValidator = null;
    }

    @Test
    public void radiusValidatorTest() {
        Assert.assertEquals(ballDataValidator.radiusValidator(VALID_RADIUS),
                true);
    }

    @Test
    public void radiusValidatorAlternativeTest() {
        Assert.assertEquals(ballDataValidator.radiusValidator(INVALID_RADIUS),
                false);
    }

    @Test
    public void amountOfParametersValidatorTest() {
        Assert.assertEquals(ballDataValidator.amountOfParametersValidator(VALID_AMOUNT_OF_PARAMETERS),
                true);
    }

    @Test
    public void amountOfParametersValidatorAlternativeTest() {
        Assert.assertEquals(ballDataValidator.amountOfParametersValidator(INVALID_AMOUNT_OF_PARAMETERS),
                false);
    }

    @Test
    public void delimiterValidatorTest() {
        Assert.assertEquals(ballDataValidator.delimiterValidator(VALID_DELIMITER),
                true);
    }

    @Test
    public void delimiterValidatorAlternativeTest() {
        Assert.assertEquals(ballDataValidator.delimiterValidator(INVALID_DELIMITER),
                false);
    }

    @Test
    public void doubleInStringValidatorTest() {
        Assert.assertEquals(ballDataValidator.doubleInStringValidator(VALID_DOUBLE_IN_STRING),
                true);
    }

    @Test
    public void doubleInStringValidatorAlternativeTest() {
        Assert.assertEquals(ballDataValidator.doubleInStringValidator(INVALID_DOUBLE_IN_STRING),
                false);
    }
}
