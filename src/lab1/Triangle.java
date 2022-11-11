package lab1;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Figure{
    private List<Point> points;

    public Triangle() {
    }

    public Triangle(List<Point> points) throws Exception {
        if (points.size() > 3)
            throw new Exception("Invalid points count");
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }
    public void setPoints(List<Point> points) throws Exception {
        if (points.size() > 3)
            throw new Exception("Invalid points count");

        this.points = points;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + points +
                "hex=@" + Integer.toHexString(this.hashCode()) +
                '}' + '\n';
    }

    @Override
    public double getPerimeter() {

        double perimeter = 0;

        for (int i = 0; i < points.size() - 1; i++){
            perimeter += calculateLength(points.get(i).getCoordinateX(), points.get(i).getCoordinateY()
                    , points.get(i + 1).getCoordinateX(), points.get(i + 1).getCoordinateY());
        }

        perimeter += calculateLength(points.get(0).getCoordinateX(), points.get(0).getCoordinateY()
                , points.get(points.size() - 1).getCoordinateX(), points.get(points.size() - 1).getCoordinateY());

        return (double)Math.round(perimeter * 1000d) / 1000d;
    }

    @Override
    public double getSquare() {

        double semiPerimeter = getPerimeter() / 2;

        double expression = semiPerimeter;

        for (int i = 0; i < points.size() - 1; i++){
            expression *= semiPerimeter - calculateLength(points.get(i).getCoordinateX(), points.get(i).getCoordinateY()
                    , points.get(i + 1).getCoordinateX(), points.get(i + 1).getCoordinateY());
        }
        expression *= semiPerimeter - calculateLength(points.get(0).getCoordinateX(), points.get(0).getCoordinateY()
                , points.get(points.size() - 1).getCoordinateX(), points.get(points.size() - 1).getCoordinateY());

        return (double)Math.round(Math.sqrt(expression) * 100d) / 100d;
    }

    public List<Double> getLengths(){
        List<Double> lengthList = new ArrayList<>();

        for (int i = 0; i < points.size() - 1; i++){
            lengthList.add(calculateLength(points.get(i).getCoordinateX(), points.get(i).getCoordinateY()
                    , points.get(i + 1).getCoordinateX(), points.get(i + 1).getCoordinateY()));
        }
        lengthList.add(calculateLength(points.get(0).getCoordinateX(), points.get(0).getCoordinateY()
                , points.get(points.size() - 1).getCoordinateX(), points.get(points.size() - 1).getCoordinateY()));

        return lengthList;
    }

    private double calculateLength(double firstX, double firstY, double secondX, double secondY){
        return Math.sqrt(Math.pow(firstX - secondX, 2) + Math.pow(firstY - secondY, 2));
    }

}
