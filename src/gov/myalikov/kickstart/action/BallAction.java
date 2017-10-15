/**
 * BallAction
 * <p>
 * Provides some action
 * methods for Ball Class
 *
 * @version 6
 * @author Arthur Myalikov;
 */
package gov.myalikov.kickstart.action;

import gov.myalikov.kickstart.entitie.Ball;
import gov.myalikov.kickstart.exception.ParameterTechnicalException;
import gov.myalikov.kickstart.validator.BallDataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallAction {

    private static BallDataValidator validator = new BallDataValidator();

    private static Logger logger = LogManager.getLogger("BallAction");

    public double calculateBallSurfaceArea(Ball ball) {
        double ballSurfaceArea = 4.0 *
                Math.PI *
                ball.getRadius() *
                ball.getRadius();
        logger.log(Level.INFO, ball.toString() + " surface area is " + ballSurfaceArea);
        return ballSurfaceArea;
    }

    public double calculateBallVolume(Ball ball) {
        double ballVolume = 4.0 / 3 *
                Math.PI *
                ball.getRadius() *
                ball.getRadius() *
                ball.getRadius();
        logger.log(Level.INFO, ball.toString() + " volume is " + ballVolume);
        return ballVolume;
    }

    public double calculateBallDividedByPlaneRatio(Ball ball, String plane) {
        double h;
        double ballDividedByAxisRatio = 0;
        try {
            switch (plane) {
                case "yz":
                    h = ball.getRadius() - Math.abs(ball.getCentre().getX());
                    break;
                case "zy":
                    h = ball.getRadius() - Math.abs(ball.getCentre().getX());
                    break;
                case "xz":
                    h = ball.getRadius() - Math.abs(ball.getCentre().getY());
                    break;
                case "zx":
                    h = ball.getRadius() - Math.abs(ball.getCentre().getY());
                    break;
                case "xy":
                    h = ball.getRadius() - Math.abs(ball.getCentre().getZ());
                    break;
                case "yx":
                    h = ball.getRadius() - Math.abs(ball.getCentre().getZ());
                    break;
                default:
                    throw new ParameterTechnicalException("Plane \"" + plane + "\" doesn't exist.");
            }
        } catch (ParameterTechnicalException e) {
            logger.log(Level.ERROR, e.getMessage());
            return 0;
        }
        if (h < 0){
            ballDividedByAxisRatio = 0;
        } else if (ball.getRadius() >= h){
            double ballSegmentVolume = Math.PI*h*h*(ball.getRadius()-h/3);
            ballDividedByAxisRatio = ballSegmentVolume/(calculateBallVolume(ball) - ballSegmentVolume);
        } else if (ball.getRadius() * 2 > h){
            double ballSegmentVolume = Math.PI*h*h*(ball.getRadius()-h/3);
            ballDividedByAxisRatio = (calculateBallVolume(ball) - ballSegmentVolume)/ ballSegmentVolume;
        } else {
            ballDividedByAxisRatio = 0;
        }
        logger.log(Level.INFO, ball.toString() + " is divided by a plane \"" +
                plane + "\" at the point 0 in the ratio: " + ballDividedByAxisRatio);
        return ballDividedByAxisRatio;
    }

    public boolean isBall(Ball ball) {
        return validator.radiusValidator(ball.getRadius());
    }

    public boolean isTouchingPlane(Ball ball) {
        boolean touchingPlane = (Math.abs(ball.getCentre().getX()) == ball.getRadius() ||
                Math.abs(ball.getCentre().getY()) == ball.getRadius() ||
                Math.abs(ball.getCentre().getZ()) == ball.getRadius());
        logger.log(Level.INFO, touchingPlane ? ball + " touches the plane." :
                ball + " doesn't touch any plane.");
        return touchingPlane;
    }
}
