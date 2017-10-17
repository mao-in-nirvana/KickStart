/**
 * Ball
 * <p>
 * Ball entity class
 *
 * @author Arthur Myalikov;
 */
package gov.myalikov.kickstart.entitie;

import gov.myalikov.kickstart.exception.ParameterTechnicalException;
import gov.myalikov.kickstart.validator.BallDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball {
    private static Logger logger = LogManager.getLogger(Ball.class);
    private double radius;
    private Point point;
    private BallDataValidator validator = new BallDataValidator();

    public Ball(double newRadius, double newX, double newY, double newZ) {
        this.point = new Point(newX, newY, newZ);
        try {
            if (validator.radiusValidator(newRadius)) {
                this.radius = newRadius;
            } else {
                throw new ParameterTechnicalException();
            }
        } catch (ParameterTechnicalException e) {
            logger.error("Wrong parameter for constructor.");
        }
    }

    public Ball(double newRadius, Point newPoint) {
        this.point = newPoint;
        try {
            if (validator.radiusValidator(newRadius)) {
                this.radius = newRadius;
            } else {
                throw new ParameterTechnicalException();
            }
        } catch (ParameterTechnicalException e) {
            logger.error("Wrong parameter for constructor.");
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) {
        try {
            if (validator.radiusValidator(newRadius)) {
                this.radius = newRadius;
            } else {
                throw new ParameterTechnicalException();
            }
        } catch (ParameterTechnicalException e) {
            logger.error("Wrong parameter for radius setter.");
        }
    }

    public Point getCentre() {
        return point;
    }

    public void setCentre(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Ball[" +
                "radius=" + radius +
                ", centre" + point +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ball ball = (Ball) o;

        return Double.compare(ball.getRadius(), getRadius()) == 0 && (point != null ? point.equals(ball.point) : ball.point == null);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getRadius());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (point != null ? point.hashCode() : 0);
        return result;
    }
}
