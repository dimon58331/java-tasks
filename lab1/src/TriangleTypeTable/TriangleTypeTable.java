package TriangleTypeTable;

import Triangle.Triangle;
import TriangleType.TriangleType;

import java.util.*;


public class TriangleTypeTable {
    private static Map<TriangleType, ArrayList<Object>> triangleTypesArrayListMap = new HashMap<>();

    public static void addTriangleByTypeToTable(Triangle triangle){

        List<Double> lengthOfSides = triangle.calculateLengths();

        double maxLength = Collections.max(lengthOfSides);
        lengthOfSides.remove(maxLength);

        double firstSin = (2 * triangle.calculateSquare()) / (lengthOfSides.get(0) * lengthOfSides.get(1));
        double secondSin = firstSin * lengthOfSides.get(0) / maxLength;

        double firstASIN = (Math.asin(firstSin) * 180) / Math.PI;
        double secondASIN = (Math.asin(secondSin) * 180) / Math.PI;
        double thirdASIN = 180 - firstASIN - secondASIN;

        boolean isRectangular = (thirdASIN == 90 || secondASIN == 90 || firstASIN == 90);


        if ((Objects.equals(triangle.calculateLengths().get(0), triangle.calculateLengths().get(1)))
                && (Objects.equals(triangle.calculateLengths().get(0), triangle.calculateLengths().get(2)))){
           addTriangleToTable(TriangleType.EQUILATERAL, triangle);
        } else if ((!Objects.equals(triangle.calculateLengths().get(0), triangle.calculateLengths().get(1)))
                && (!Objects.equals(triangle.calculateLengths().get(0), triangle.calculateLengths().get(2)))
                && (!Objects.equals(triangle.calculateLengths().get(1), triangle.calculateLengths().get(2))) && !isRectangular)  {
            addTriangleToTable(TriangleType.ARBITRARY, triangle);
        } else if (isRectangular) {
            addTriangleToTable(TriangleType.RECTANGULAR, triangle);
        }else{
            addTriangleToTable(TriangleType.ISOSCELES, triangle);
        }
    }

    private static void addTriangleToTable(TriangleType triangleType, Triangle triangle){

        triangleTypesArrayListMap.computeIfAbsent(triangleType, k -> new ArrayList<>());

        triangleTypesArrayListMap.get(triangleType).add(triangle);
    }

    public static Map<TriangleType, ArrayList<Object>> getTriangleTypesTable() {
        return triangleTypesArrayListMap;
    }

    public static Triangle findTriangleWithMaxPerimeter(TriangleType triangleType){
        Triangle triangleWithMaxPerimeter = null;
        double maxPerimeter = 0;
        for (Object obj : triangleTypesArrayListMap.get(triangleType)) {
            Triangle triangle = (Triangle) obj;

            if ((triangle.calculatePerimeter() > maxPerimeter)) {
                maxPerimeter = triangle.calculatePerimeter();
                triangleWithMaxPerimeter = triangle;
            }
        }

        return triangleWithMaxPerimeter;
    }

    public static Triangle findTriangleWithMaxSquare(TriangleType triangleType){
        Triangle triangleWithMaxSquare = null;
        double maxSquare = 0;
        for (Object obj : triangleTypesArrayListMap.get(triangleType)) {
            Triangle triangle = (Triangle) obj;

            if ((triangle.calculateSquare() > maxSquare)) {
                maxSquare = triangle.calculateSquare();
                triangleWithMaxSquare = triangle;
            }
        }

        return triangleWithMaxSquare;
    }

    public static Triangle findTriangleWithMinPerimeter(TriangleType triangleType){
        Triangle triangleWithMinPerimeter = null;
        double minPerimeter = 0;
        for (Object obj : triangleTypesArrayListMap.get(triangleType)) {
            Triangle triangle = (Triangle) obj;

            if ((triangle.calculatePerimeter() < minPerimeter) || minPerimeter == 0) {
                minPerimeter = triangle.calculatePerimeter();
                triangleWithMinPerimeter = triangle;
            }
        }

        return triangleWithMinPerimeter;
    }

    public static Triangle findTriangleWithMinSquare(TriangleType triangleType){
        Triangle triangleWithMinSquare = null;
        double minSquare = 0;
        for (Object obj : triangleTypesArrayListMap.get(triangleType)) {
            Triangle triangle = (Triangle) obj;

            if ((triangle.calculateSquare() < minSquare) || minSquare == 0) {
                minSquare = triangle.calculateSquare();
                triangleWithMinSquare = triangle;
            }
        }

        return triangleWithMinSquare;
    }
}
