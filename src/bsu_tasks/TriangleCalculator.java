package bsu_tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleCalculator {

    private static ArrayList<ArrayList<Object>> tableOfTrianglesTypes = new ArrayList<>();

    private static double firstLengthSide;
    private static double secondLengthSide;
    private static double thirdLengthSide;

    private static double calculateLength(double firstX, double secondX, double firstY, double secondY){
        return Math.sqrt(Math.pow(firstX - secondX, 2) + Math.pow(firstY - secondY, 2));
    }

    private static double calculateLengthWithOutSqrt(double firstX, double secondX, double firstY, double secondY){
        return Math.pow(firstX - secondX, 2) + Math.pow(firstY - secondY, 2);
    }

    public static void calculatePerimeter(Triangle triangle){

        double firstLengthSide = calculateLength(triangle.getFirstPoint().getCoordinateX(), triangle.getSecondPoint().getCoordinateX()
                , triangle.getFirstPoint().getCoordinateY(), triangle.getSecondPoint().getCoordinateY());

        double secondLengthSide = calculateLength(triangle.getSecondPoint().getCoordinateX(), triangle.getThirdPoint().getCoordinateX()
                , triangle.getSecondPoint().getCoordinateY(), triangle.getThirdPoint().getCoordinateY());

        double thirdLengthSide = calculateLength(triangle.getFirstPoint().getCoordinateX(), triangle.getThirdPoint().getCoordinateX()
                , triangle.getFirstPoint().getCoordinateY(), triangle.getThirdPoint().getCoordinateY());

        double perimeterOfTriangle = firstLengthSide + secondLengthSide + thirdLengthSide;

//        System.out.println("================================================\n"
//                + "Details of the method 'calculatePerimeter':" + '\n'
//                + "First length side: " + firstLengthSide + '\n'
//                + "Second length side: " + secondLengthSide + '\n'
//                + "Third length side: " + thirdLengthSide + '\n'
//                + "Perimeter of this triangle: " + perimeterOfTriangle + '\n'
//                + "================================================");
        triangle.setPerimeter(perimeterOfTriangle);
    }

    public static void calculateSquare(Triangle triangle){

        firstLengthSide = calculateLength(triangle.getFirstPoint().getCoordinateX(), triangle.getSecondPoint().getCoordinateX()
                , triangle.getFirstPoint().getCoordinateY(), triangle.getSecondPoint().getCoordinateY());

        secondLengthSide = calculateLength(triangle.getSecondPoint().getCoordinateX(), triangle.getThirdPoint().getCoordinateX()
                , triangle.getSecondPoint().getCoordinateY(), triangle.getThirdPoint().getCoordinateY());

        thirdLengthSide = calculateLength(triangle.getFirstPoint().getCoordinateX(), triangle.getThirdPoint().getCoordinateX()
                , triangle.getFirstPoint().getCoordinateY(), triangle.getThirdPoint().getCoordinateY());

        double semiPerimeterOfTriangle = (firstLengthSide + secondLengthSide + thirdLengthSide) / 2;

        double triangleSquare = Math.sqrt(semiPerimeterOfTriangle * (semiPerimeterOfTriangle - firstLengthSide)
                * (semiPerimeterOfTriangle - secondLengthSide)
                * (semiPerimeterOfTriangle - thirdLengthSide));

//        System.out.println("================================================\n"
//                + "Details of the method 'calculateSquare':" + '\n'
//                + "First length side: " + firstLengthSide + '\n'
//                + "Second length side: " + secondLengthSide + '\n'
//                + "Third length side: " + thirdLengthSide + '\n'
//                + "SemiPerimeter of this triangle: " + semiPerimeterOfTriangle + '\n'
//                + "Square of this triangle: " + triangleSquare + '\n'
//                + "================================================");
        triangle.setSquare(triangleSquare);
    }

    public static void addTypeOfTriangleToTable(Triangle triangle){
        firstLengthSide = calculateLengthWithOutSqrt(triangle.getFirstPoint().getCoordinateX(), triangle.getSecondPoint().getCoordinateX()
                , triangle.getFirstPoint().getCoordinateY(), triangle.getSecondPoint().getCoordinateY());

        secondLengthSide = calculateLengthWithOutSqrt(triangle.getSecondPoint().getCoordinateX(), triangle.getThirdPoint().getCoordinateX()
                , triangle.getSecondPoint().getCoordinateY(), triangle.getThirdPoint().getCoordinateY());

        thirdLengthSide = calculateLengthWithOutSqrt(triangle.getFirstPoint().getCoordinateX(), triangle.getThirdPoint().getCoordinateX()
                , triangle.getFirstPoint().getCoordinateY(), triangle.getThirdPoint().getCoordinateY());

        List<Double> lengthOfSides = new ArrayList<>();

        lengthOfSides.add(firstLengthSide);
        lengthOfSides.add(secondLengthSide);
        lengthOfSides.add(thirdLengthSide);

        double maxLength = Collections.max(lengthOfSides);

        lengthOfSides.remove(maxLength);

//        System.out.println("Max length side without sqrt -> " + maxLength + ", with sqrt -> " + Math.sqrt(maxLength));

        boolean isRectangular = (maxLength == (lengthOfSides.get(0) + lengthOfSides.get(1)));

//        TriangleTypes[] types = TriangleTypes.values();

        if ((firstLengthSide == secondLengthSide) && (firstLengthSide == thirdLengthSide)){
           tableOfTriangles(TriangleTypes.EQUILATERAL, triangle);
        } else if ((firstLengthSide != secondLengthSide) && (firstLengthSide != thirdLengthSide)
                    && (secondLengthSide != thirdLengthSide) && !isRectangular)  {
            tableOfTriangles(TriangleTypes.ARBITRARY, triangle);
        } else if (isRectangular) {
            tableOfTriangles(TriangleTypes.RECTANGULAR, triangle);
        }else{
            tableOfTriangles(TriangleTypes.ISOSCELES, triangle);
        }
    }

    private static void tableOfTriangles(TriangleTypes triangleType, Triangle triangle){
        if (tableOfTrianglesTypes.isEmpty()){
            for (int i = 0; i < TriangleTypes.values().length; i++){
                tableOfTrianglesTypes.add(new ArrayList<>());
            }
        }

        switch (triangleType){
            case EQUILATERAL -> {
                tableOfTrianglesTypes.get(0).add(triangle);
            }
            case ARBITRARY -> {
                tableOfTrianglesTypes.get(1).add(triangle);
            }
            case ISOSCELES -> {
                tableOfTrianglesTypes.get(2).add(triangle);
            }
            case RECTANGULAR -> {
                tableOfTrianglesTypes.get(3).add(triangle);
            }
        }
    }

    public static ArrayList<ArrayList<Object>> getTableOfTrianglesTypes() {
        return tableOfTrianglesTypes;
    }
}
