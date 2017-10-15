package test.gov.myalikov.kickstart.action;

import gov.myalikov.kickstart.action.BallAction;
import gov.myalikov.kickstart.entitie.Ball;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BallActionTest {

    private static final double DEFAULT_DELTA = 0.0000001;
    private static final Ball BASIC_BALL_RADIUS_5 =
            new Ball(5.0, 0.0, 0.0, 0.0);
    private static final Ball BASIC_BALL_RADIUS_10_Z_10 =
            new Ball(10.0, 0.0, 0.0, 10.0);
    private BallAction ballAction;

    @BeforeMethod
    public void initBallAction() {
        ballAction = new BallAction();
    }

    @AfterMethod
    public void clearBallAction() {
        ballAction = null;
    }

    @Test
    public void calculateBallSurfaceAreaTest() {
        double calculatedArea = ballAction.calculateBallSurfaceArea(BASIC_BALL_RADIUS_5);
        double expectedArea = 314.1592653589793;
        Assert.assertEquals(calculatedArea, expectedArea, DEFAULT_DELTA);
    }

    @Test
    public void calculateWrongBallSurfaceAreaTest() {
        double calculatedArea = ballAction.calculateBallSurfaceArea(BASIC_BALL_RADIUS_10_Z_10);
        double expectedArea = 314.1592653589793;
        Assert.assertNotEquals(calculatedArea, expectedArea, DEFAULT_DELTA);
    }

    @Test
    public void calculateBallVolumeTest() {
        double calculatedVolume = ballAction.calculateBallVolume(BASIC_BALL_RADIUS_5);
        double expectedVolume = 523.598775598298;
        Assert.assertEquals(calculatedVolume, expectedVolume, DEFAULT_DELTA);
    }

    @Test
    public void calculateWrongBallVolumeTest() {
        double calculatedVolume = ballAction.calculateBallVolume(BASIC_BALL_RADIUS_10_Z_10);
        double expectedVolume = 523.598775598298;
        Assert.assertNotEquals(calculatedVolume, expectedVolume, DEFAULT_DELTA);
    }

    @Test
    public void calculateBallDividedByPlaneRatioTest() {
        double calculatedRatio = ballAction.calculateBallDividedByPlaneRatio(BASIC_BALL_RADIUS_5, "xy");
        double expectedRatio = 1;
        Assert.assertEquals(calculatedRatio, expectedRatio, DEFAULT_DELTA);
    }

    @Test
    public void calculateWrongBallDividedByPlaneRatioTest() {
        double calculatedRatio = ballAction.calculateBallDividedByPlaneRatio(BASIC_BALL_RADIUS_10_Z_10, "xy");
        double expectedRatio = 1;
        Assert.assertNotEquals(calculatedRatio, expectedRatio, DEFAULT_DELTA);
    }

    @Test
    public void isBallTest() {
        boolean calculatedResult = ballAction.isBall(BASIC_BALL_RADIUS_5);
        boolean expectedResult = true;
        Assert.assertEquals(calculatedResult, expectedResult);
    }

    @Test
    public void isTouchingPlaneTest() {
        boolean calculatedTouchingPlaneResult = ballAction.isTouchingPlane(BASIC_BALL_RADIUS_10_Z_10);
        boolean expectedTouchingPlaneResult = true;
        Assert.assertEquals(calculatedTouchingPlaneResult, expectedTouchingPlaneResult);
    }

    @Test
    public void isNotTouchingPlaneTest() {
        boolean calculatedTouchingPlaneResult = ballAction.isTouchingPlane(BASIC_BALL_RADIUS_5);
        boolean expectedTouchingPlaneResult = true;
        Assert.assertNotEquals(calculatedTouchingPlaneResult, expectedTouchingPlaneResult);
    }
}
