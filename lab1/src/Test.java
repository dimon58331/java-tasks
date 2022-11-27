import Point.Point;
import Triangle.Triangle;
import TriangleType.TriangleType;
import TriangleTypeTable.TriangleTypeTable;

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
        Collections.addAll(firstPointList, new Point(0, 0), new Point(5, 5 * Math.sqrt(3))
                , new Point(10, 0));

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

        System.out.println(firstTriangle.calculateLengths());

        TriangleTypeTable.addTriangleByTypeToTable(firstTriangle);
        TriangleTypeTable.addTriangleByTypeToTable(secondTriangle);
        TriangleTypeTable.addTriangleByTypeToTable(thirdTriangle);

        System.out.println(TriangleTypeTable.getTriangleTypesTable());


        Triangle triangleMaxPerimeterRectangularTypeTriangle = TriangleTypeTable.findTriangleWithMaxPerimeter(TriangleType.RECTANGULAR);
        Triangle triangleWithMinPerimeterRectangularType = TriangleTypeTable.findTriangleWithMinPerimeter(TriangleType.RECTANGULAR);

        Triangle triangleMaxSquareRectangularTypeTriangle = TriangleTypeTable.findTriangleWithMaxSquare(TriangleType.RECTANGULAR);
        Triangle triangleMinSquareRectangularTypeTriangle = TriangleTypeTable.findTriangleWithMinSquare(TriangleType.RECTANGULAR);

        Triangle triangleMaxPerimeterArbitraryTypeTriangle = TriangleTypeTable.findTriangleWithMaxPerimeter(TriangleType.ARBITRARY);
        Triangle triangleWithMinPerimeterArbitraryType = TriangleTypeTable.findTriangleWithMinPerimeter(TriangleType.ARBITRARY);

        Triangle maxSquareArbitraryTypeTriangle = TriangleTypeTable.findTriangleWithMaxSquare(TriangleType.ARBITRARY);
        Triangle minSquareArbitraryTypeTriangle = TriangleTypeTable.findTriangleWithMinSquare(TriangleType.ARBITRARY);


        System.out.println("Rectangular triangle with max perimeter -> " + triangleMaxPerimeterRectangularTypeTriangle.calculatePerimeter()
                + "; triangle -> " + triangleMaxPerimeterRectangularTypeTriangle);

        System.out.println("Arbitrary triangle with max perimeter -> " + triangleMaxPerimeterArbitraryTypeTriangle.calculatePerimeter()
                + "; triangle -> " + triangleMaxPerimeterArbitraryTypeTriangle);

    }
}
