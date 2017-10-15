/**
 * Point
 * <p>
 * Point entity class
 *
 * @author Arthur Myalikov;
 */
package gov.myalikov.kickstart.entitie;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point() {

    }

    public Point(double newX, double newY, double newZ) {
        x = newX;
        y = newY;
        z = newZ;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (Double.compare(point.getX(), getX()) != 0) {
            return false;
        }
        if (Double.compare(point.getY(), getY()) != 0) {
            return false;
        }
        return Double.compare(point.getZ(), getZ()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getX());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getZ());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
