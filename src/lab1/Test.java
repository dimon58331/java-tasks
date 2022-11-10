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

        TrianglesTypeTable.addTriangleByTypeToTable(firstTriangle);
        TrianglesTypeTable.addTriangleByTypeToTable(secondTriangle);
        TrianglesTypeTable.addTriangleByTypeToTable(thirdTriangle);

        System.out.println(TrianglesTypeTable.getTriangleTypesTable());


        Triangle triangleMaxPerimeterRectangularTypeTriangle = TrianglesTypeTable.findTriangleWithMaxPerimeter(TriangleTypes.RECTANGULAR);
        Triangle triangleWithMinPerimeterRectangularType = TrianglesTypeTable.findTriangleWithMinPerimeter(TriangleTypes.RECTANGULAR);

        Triangle triangleMaxSquareRectangularTypeTriangle = TrianglesTypeTable.findTriangleWithMaxSquare(TriangleTypes.RECTANGULAR);
        Triangle triangleMinSquareRectangularTypeTriangle = TrianglesTypeTable.findTriangleWithMinSquare(TriangleTypes.RECTANGULAR);

        Triangle triangleMaxPerimeterArbitraryTypeTriangle = TrianglesTypeTable.findTriangleWithMaxPerimeter(TriangleTypes.ARBITRARY);
        Triangle triangleWithMinPerimeterArbitraryType = TrianglesTypeTable.findTriangleWithMinPerimeter(TriangleTypes.ARBITRARY);

        Triangle maxSquareArbitraryTypeTriangle = TrianglesTypeTable.findTriangleWithMaxSquare(TriangleTypes.ARBITRARY);
        Triangle minSquareArbitraryTypeTriangle = TrianglesTypeTable.findTriangleWithMinSquare(TriangleTypes.ARBITRARY);


        System.out.println("Rectangular triangle with max perimeter -> " + triangleMaxPerimeterRectangularTypeTriangle.getPerimeter()
                + "; triangle -> " + triangleMaxPerimeterRectangularTypeTriangle);

        System.out.println("Arbitrary triangle with max perimeter -> " + triangleMaxPerimeterArbitraryTypeTriangle.getPerimeter()
                + "; triangle -> " + triangleMaxPerimeterArbitraryTypeTriangle);

    }
}
