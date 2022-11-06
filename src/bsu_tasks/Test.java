package bsu_tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        Triangle firstTriangle = new Triangle(new Point(0, -2), new Point(2, 0)
                , new Point(0, 0));
        Triangle secondTriangle = new Triangle(new Point(0, 2), new Point(2, 0)
                , new Point(0, 0));

        Triangle thirdTriangle = new Triangle(new Point(-3, 1), new Point(3, 5)
                , new Point(0, -4));

        SmartTriangleCalculator.calculatePerimeter(firstTriangle);
 //       System.out.println("Perimeter of triangle -> " + firstTriangle.getPerimeter() + ", hashcode -> " + firstTriangle.hashCode());

        SmartTriangleCalculator.calculateSquare(firstTriangle);
//        System.out.println("Square of triangle -> " + firstTriangle.getSquare() + ", hashcode -> " + firstTriangle.hashCode());

        SmartTriangleCalculator.calculatePerimeter(secondTriangle);
        SmartTriangleCalculator.calculatePerimeter(thirdTriangle);

        SmartTriangleCalculator.calculateSquare(secondTriangle);
        SmartTriangleCalculator.calculateSquare(thirdTriangle);


        SmartTriangleCalculator.addTriangleTypeToTable(firstTriangle);
        SmartTriangleCalculator.addTriangleTypeToTable(secondTriangle);
        SmartTriangleCalculator.addTriangleTypeToTable(thirdTriangle);

        System.out.println(SmartTriangleCalculator.getTriangleTypesTable());

        double maxPerimeterRectangularTypeTriangle = SmartTriangleCalculator.findMaxPerimeter(SmartTriangleCalculator.getTriangleTypesTable()
                                                    , TriangleTypes.RECTANGULAR);
        double minPerimeterRectangularTypeTriangle = SmartTriangleCalculator.findMinPerimeter(SmartTriangleCalculator.getTriangleTypesTable()
                , TriangleTypes.RECTANGULAR);

        double maxSquareRectangularTypeTriangle = SmartTriangleCalculator.findMaxSquare(SmartTriangleCalculator.getTriangleTypesTable()
                , TriangleTypes.RECTANGULAR);
        double minSquareRectangularTypeTriangle = SmartTriangleCalculator.findMinSquare(SmartTriangleCalculator.getTriangleTypesTable()
                , TriangleTypes.RECTANGULAR);




        /*
            Добавить проверку на:
            1) одинаковые координаты
            2) лежат на одной прямой
         */

    }
}
