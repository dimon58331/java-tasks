import bsu.task.figure.Figure;
import bsu.task.point.Point;
import bsu.task.triangle.Triangle;
import bsu.task.triangletype.TriangleType;
import bsu.task.triangletypetable.TriangleTypeTable;

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

        Figure firstTriangle = null, secondTriangle = null, thirdTriangle = null;
        try {
            firstTriangle = new Triangle(firstPointList);
            secondTriangle = new Triangle(secondPointList);
            thirdTriangle = new Triangle(thirdPointList);
        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("Length of first triangle: " + firstTriangle.calculateLengths());

        TriangleTypeTable.addTriangleByTypeToTable(firstTriangle);
        TriangleTypeTable.addTriangleByTypeToTable(secondTriangle);
        TriangleTypeTable.addTriangleByTypeToTable(thirdTriangle);

        System.out.println(TriangleTypeTable.getTriangleTypesTable());


        Figure triangleMaxPerimeterRectangularTypeTriangle = TriangleTypeTable.findTriangleWithMaxPerimeter(TriangleType.RECTANGULAR);
        Figure triangleWithMinPerimeterRectangularType = TriangleTypeTable.findTriangleWithMinPerimeter(TriangleType.RECTANGULAR);

        Figure triangleMaxSquareRectangularTypeTriangle = TriangleTypeTable.findTriangleWithMaxSquare(TriangleType.RECTANGULAR);
        Figure triangleMinSquareRectangularTypeTriangle = TriangleTypeTable.findTriangleWithMinSquare(TriangleType.RECTANGULAR);

        Figure triangleMaxPerimeterArbitraryTypeTriangle = TriangleTypeTable.findTriangleWithMaxPerimeter(TriangleType.ARBITRARY);
        Figure triangleWithMinPerimeterArbitraryType = TriangleTypeTable.findTriangleWithMinPerimeter(TriangleType.ARBITRARY);

        Figure maxSquareArbitraryTypeTriangle = TriangleTypeTable.findTriangleWithMaxSquare(TriangleType.ARBITRARY);
        Figure minSquareArbitraryTypeTriangle = TriangleTypeTable.findTriangleWithMinSquare(TriangleType.ARBITRARY);


        System.out.println("Rectangular triangle with max perimeter -> " + triangleMaxPerimeterRectangularTypeTriangle.calculatePerimeter()
                + "; triangle -> " + triangleMaxPerimeterRectangularTypeTriangle);

        System.out.println("Arbitrary triangle with max perimeter -> " + triangleMaxPerimeterArbitraryTypeTriangle.calculatePerimeter()
                + "; triangle -> " + triangleMaxPerimeterArbitraryTypeTriangle);

    }
}
