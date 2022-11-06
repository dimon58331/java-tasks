package bsu_tasks;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Triangle firstTriangle = new Triangle(new Point(0, -2), new Point(2, 0)
                , new Point(0, 0));
        Triangle secondTriangle = new Triangle(new Point(0, 2), new Point(2, 0)
                , new Point(0, 0));

        TriangleCalculator.calculatePerimeter(firstTriangle);
        System.out.println("Perimeter of triangle -> " + firstTriangle.getPerimeter());

        TriangleCalculator.calculateSquare(firstTriangle);
        System.out.println("Square of triangle -> " + firstTriangle.getSquare());

        TriangleCalculator.addTypeOfTriangleToTable(firstTriangle);
        TriangleCalculator.addTypeOfTriangleToTable(secondTriangle);

        System.out.println(TriangleCalculator.getTableOfTrianglesTypes());

        /*
            Определить наибольший/наименьший периметр,площадь для каждого типа
         */

    }
}
