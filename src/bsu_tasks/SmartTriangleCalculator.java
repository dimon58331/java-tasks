package bsu_tasks;

import java.util.*;

public class SmartTriangleCalculator {

    private static ArrayList<Object> trianglesRectangularType;
    private static Map<TriangleTypes, ArrayList<Object>> triangleTypesArrayListMap = new HashMap<>();

    private static double sideLength(double firstX, double secondX, double firstY, double secondY){
        return Math.sqrt(Math.pow(firstX - secondX, 2) + Math.pow(firstY - secondY, 2));
    }

    private static void calculateLengths(Triangle triangle){

        triangle.setFirstLengthSide(sideLength(triangle.getFirstPoint().getCoordinateX(), triangle.getSecondPoint().getCoordinateX()
                , triangle.getFirstPoint().getCoordinateY(), triangle.getSecondPoint().getCoordinateY()));

        triangle.setSecondLengthSide(sideLength(triangle.getSecondPoint().getCoordinateX(), triangle.getThirdPoint().getCoordinateX()
                , triangle.getSecondPoint().getCoordinateY(), triangle.getThirdPoint().getCoordinateY()));

        triangle.setThirdLengthSide(sideLength(triangle.getFirstPoint().getCoordinateX(), triangle.getThirdPoint().getCoordinateX()
                , triangle.getFirstPoint().getCoordinateY(), triangle.getThirdPoint().getCoordinateY()));

    }

    private static double calculateLengthWithOutSqrt(double firstX, double secondX, double firstY, double secondY){
        return Math.pow(firstX - secondX, 2) + Math.pow(firstY - secondY, 2);
    }

    public static void calculatePerimeter(Triangle triangle){
        calculateLengths(triangle);
        triangle.setPerimeter(triangle.getFirstLengthSide() + triangle.getSecondLengthSide() + triangle.getThirdLengthSide());
    }

    public static void calculateSquare(Triangle triangle){

        calculateLengths(triangle);

        double semiPerimeterOfTriangle = (triangle.getFirstLengthSide() + triangle.getSecondLengthSide() + triangle.getThirdLengthSide()) / 2;

        double triangleSquare = Math.sqrt(semiPerimeterOfTriangle * (semiPerimeterOfTriangle - triangle.getFirstLengthSide())
                * (semiPerimeterOfTriangle - triangle.getSecondLengthSide())
                * (semiPerimeterOfTriangle - triangle.getThirdLengthSide()));

        triangle.setSquare(triangleSquare);
    }

    public static void addTriangleTypeToTable(Triangle triangle){
        double firstLengthSide = calculateLengthWithOutSqrt(triangle.getFirstPoint().getCoordinateX(), triangle.getSecondPoint().getCoordinateX()
                , triangle.getFirstPoint().getCoordinateY(), triangle.getSecondPoint().getCoordinateY());

        double secondLengthSide = calculateLengthWithOutSqrt(triangle.getSecondPoint().getCoordinateX(), triangle.getThirdPoint().getCoordinateX()
                , triangle.getSecondPoint().getCoordinateY(), triangle.getThirdPoint().getCoordinateY());

        double thirdLengthSide = calculateLengthWithOutSqrt(triangle.getFirstPoint().getCoordinateX(), triangle.getThirdPoint().getCoordinateX()
                , triangle.getFirstPoint().getCoordinateY(), triangle.getThirdPoint().getCoordinateY());

        List<Double> lengthOfSides = new ArrayList<>();

        lengthOfSides.add(firstLengthSide);
        lengthOfSides.add(secondLengthSide);
        lengthOfSides.add(thirdLengthSide);

        double maxLength = Collections.max(lengthOfSides);

        lengthOfSides.remove(maxLength);

        boolean isRectangular = (maxLength == (lengthOfSides.get(0) + lengthOfSides.get(1)));

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

        if (triangleTypesArrayListMap.get(triangleType) == null){
            triangleTypesArrayListMap.put(triangleType, new ArrayList<>());
        }

        switch (triangleType){
            case EQUILATERAL -> {
                triangleTypesArrayListMap.get(triangleType).add(triangle);
            }
            case ARBITRARY -> {
                triangleTypesArrayListMap.get(triangleType).add(triangle);
            }
            case ISOSCELES -> {
                triangleTypesArrayListMap.get(triangleType).add(triangle);
            }
            case RECTANGULAR -> {
                triangleTypesArrayListMap.get(triangleType).add(triangle);
            }
        }
    }

    public static Map<TriangleTypes, ArrayList<Object>> getTriangleTypesTable() {
        return triangleTypesArrayListMap;
    }

    public static double findMaxPerimeter(Map<TriangleTypes, ArrayList<Object>> triangleTypesTable, TriangleTypes triangleType){
        trianglesRectangularType = triangleTypesTable.get(triangleType);
        ArrayList<Double> trianglePerimeters = new ArrayList<>();
        for (Object obj : trianglesRectangularType) {
            Triangle triangle = (Triangle) obj;
            trianglePerimeters.add(triangle.getPerimeter());
        }
        double maxPerimeter = Collections.max(trianglePerimeters);
        System.out.println("Max perimeter of " + triangleType.name() + " type -> " + maxPerimeter);

        return maxPerimeter;
    }

    public static double findMaxSquare(Map<TriangleTypes, ArrayList<Object>> triangleTypesTable, TriangleTypes triangleType){
        trianglesRectangularType = triangleTypesTable.get(triangleType);
        ArrayList<Double> triangleSquares = new ArrayList<>();
        for (Object obj : trianglesRectangularType) {
            Triangle triangle = (Triangle) obj;
            triangleSquares.add(triangle.getSquare());
        }
        double maxSquare = Collections.max(triangleSquares);
        System.out.println("Max square of " + triangleType.name() + " type -> " + maxSquare);

        return maxSquare;
    }

    public static double findMinPerimeter(Map<TriangleTypes, ArrayList<Object>> triangleTypesTable, TriangleTypes triangleType){
        trianglesRectangularType = triangleTypesTable.get(triangleType);
        ArrayList<Double> trianglePerimeters = new ArrayList<>();
        for (Object obj : trianglesRectangularType) {
            Triangle triangle = (Triangle) obj;
            trianglePerimeters.add(triangle.getPerimeter());
        }
        double minPerimeter = Collections.min(trianglePerimeters);
        System.out.println("Min perimeter of " + triangleType.name() + " type -> " + minPerimeter);

        return minPerimeter;
    }

    public static double findMinSquare(Map<TriangleTypes, ArrayList<Object>> triangleTypesTable, TriangleTypes triangleType){
        trianglesRectangularType = triangleTypesTable.get(triangleType);
        ArrayList<Double> triangleSquares = new ArrayList<>();
        for (Object obj : trianglesRectangularType) {
            Triangle triangle = (Triangle) obj;
            triangleSquares.add(triangle.getSquare());
        }
        double minSquare = Collections.min(triangleSquares);
        System.out.println("Min square of " + triangleType.name() + " type -> " + minSquare);

        return minSquare;
    }
}
