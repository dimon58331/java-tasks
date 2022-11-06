package bsu_tasks;

public class Triangle {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    private double perimeter;
    private double square;

    private double firstLengthSide;
    private double secondLengthSide;
    private double thirdLengthSide;

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }

    public double getFirstLengthSide() {
        return firstLengthSide;
    }

    public void setFirstLengthSide(double firstLengthSide) {
        this.firstLengthSide = firstLengthSide;
    }

    public double getSecondLengthSide() {
        return secondLengthSide;
    }

    public void setSecondLengthSide(double secondLengthSide) {
        this.secondLengthSide = secondLengthSide;
    }

    public double getThirdLengthSide() {
        return thirdLengthSide;
    }

    public void setThirdLengthSide(double thirdLengthSide) {
        this.thirdLengthSide = thirdLengthSide;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "firstPoint=" + firstPoint +
                ", secondPoint=" + secondPoint +
                ", thirdPoint=" + thirdPoint +
                ", perimeter=" + perimeter +
                ", square=" + square +
                ", firstLengthSide=" + firstLengthSide +
                ", secondLengthSide=" + secondLengthSide +
                ", thirdLengthSide=" + thirdLengthSide +
                "} hashcode=" + this.hashCode() + "\n";
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }
}
