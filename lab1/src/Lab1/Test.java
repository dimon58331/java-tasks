package Lab1;

import Lab1.Point.Point;
import Lab1.Triangle.Triangle;
import Lab1.TriangleType.TriangleType;
import Lab1.TrianglesTypeTable.TrianglesTypeTable;

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

        TrianglesTypeTable.addTriangleByTypeToTable(firstTriangle);
        TrianglesTypeTable.addTriangleByTypeToTable(secondTriangle);
        TrianglesTypeTable.addTriangleByTypeToTable(thirdTriangle);

        System.out.println(TrianglesTypeTable.getTriangleTypesTable());


        Triangle triangleMaxPerimeterRectangularTypeTriangle = TrianglesTypeTable.findTriangleWithMaxPerimeter(TriangleType.RECTANGULAR);
        Triangle triangleWithMinPerimeterRectangularType = TrianglesTypeTable.findTriangleWithMinPerimeter(TriangleType.RECTANGULAR);

        Triangle triangleMaxSquareRectangularTypeTriangle = TrianglesTypeTable.findTriangleWithMaxSquare(TriangleType.RECTANGULAR);
        Triangle triangleMinSquareRectangularTypeTriangle = TrianglesTypeTable.findTriangleWithMinSquare(TriangleType.RECTANGULAR);

        Triangle triangleMaxPerimeterArbitraryTypeTriangle = TrianglesTypeTable.findTriangleWithMaxPerimeter(TriangleType.ARBITRARY);
        Triangle triangleWithMinPerimeterArbitraryType = TrianglesTypeTable.findTriangleWithMinPerimeter(TriangleType.ARBITRARY);

        Triangle maxSquareArbitraryTypeTriangle = TrianglesTypeTable.findTriangleWithMaxSquare(TriangleType.ARBITRARY);
        Triangle minSquareArbitraryTypeTriangle = TrianglesTypeTable.findTriangleWithMinSquare(TriangleType.ARBITRARY);


        System.out.println("Rectangular triangle with max perimeter -> " + triangleMaxPerimeterRectangularTypeTriangle.calculatePerimeter()
                + "; triangle -> " + triangleMaxPerimeterRectangularTypeTriangle);

        System.out.println("Arbitrary triangle with max perimeter -> " + triangleMaxPerimeterArbitraryTypeTriangle.calculatePerimeter()
                + "; triangle -> " + triangleMaxPerimeterArbitraryTypeTriangle);

    }
}
