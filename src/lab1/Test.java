package lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        /*
            Добавить проверку на:
            1) одинаковые координаты
            2) лежат на одной прямой
         */


        List<Point> firstPointList = new ArrayList<>();
        Collections.addAll(firstPointList, new Point(0, 3), new Point(4, 0), new Point(0, 0));

        List<Point> secondPointList = new ArrayList<>();
        Collections.addAll(secondPointList ,new Point(0, 2), new Point(2, 0), new Point(0, 0));

        List<Point> thirdPointList = new ArrayList<>();
        Collections.addAll(thirdPointList, new Point(-3, 1), new Point(3, 5), new Point(0, -4));

        Triangle firstTriangle = null, secondTriangle = null, thirdTriangle = null;
        try {
            firstTriangle = new Triangle(firstPointList);
            secondTriangle = new Triangle(secondPointList);
            thirdTriangle = new Triangle(thirdPointList);
        }catch (Exception e){
            System.out.println(e);
        }

        TrianglesTypeTable.addTriangleTypeToTable(firstTriangle);
        TrianglesTypeTable.addTriangleTypeToTable(secondTriangle);
        TrianglesTypeTable.addTriangleTypeToTable(thirdTriangle);

        System.out.println(TrianglesTypeTable.getTriangleTypesTable());


        System.out.println("Perimeter of triangle -> " + firstTriangle.getPerimeter() + "; information about" + firstTriangle.toString());

        System.out.println("Square of triangle -> " + firstTriangle.getSquare() + "; information about" + firstTriangle.toString());


        double maxPerimeterRectangularTypeTriangle = TrianglesTypeTable.findMaxPerimeter(TrianglesTypeTable.getTriangleTypesTable()
                , TriangleTypes.RECTANGULAR);
        double minPerimeterRectangularTypeTriangle = TrianglesTypeTable.findMinPerimeter(TrianglesTypeTable.getTriangleTypesTable()
                , TriangleTypes.RECTANGULAR);

        double maxSquareRectangularTypeTriangle = TrianglesTypeTable.findMaxSquare(TrianglesTypeTable.getTriangleTypesTable()
                , TriangleTypes.RECTANGULAR);
        double minSquareRectangularTypeTriangle = TrianglesTypeTable.findMinSquare(TrianglesTypeTable.getTriangleTypesTable()
                , TriangleTypes.RECTANGULAR);

        double maxPerimeterArbitraryTypeTriangle = TrianglesTypeTable.findMaxPerimeter(TrianglesTypeTable.getTriangleTypesTable()
                , TriangleTypes.ARBITRARY);
        double minPerimeterArbitraryTypeTriangle = TrianglesTypeTable.findMinPerimeter(TrianglesTypeTable.getTriangleTypesTable()
                , TriangleTypes.ARBITRARY);

        double maxSquareArbitraryTypeTriangle = TrianglesTypeTable.findMaxSquare(TrianglesTypeTable.getTriangleTypesTable()
                , TriangleTypes.ARBITRARY);
        double minSquareArbitraryTypeTriangle = TrianglesTypeTable.findMinSquare(TrianglesTypeTable.getTriangleTypesTable()
                , TriangleTypes.ARBITRARY);

    }
}
