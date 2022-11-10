package lab1;

import java.util.*;


public class TrianglesTypeTable {
    private static Map<TriangleTypes, ArrayList<Object>> triangleTypesArrayListMap = new HashMap<>();

    public static void addTriangleByTypeToTable(Triangle triangle){

        List<Double> lengthOfSides = triangle.getLengths();

        double maxLength = Collections.max(lengthOfSides);
        lengthOfSides.remove(maxLength);

        double firstSin = (2 * triangle.getSquare()) / (lengthOfSides.get(0) * lengthOfSides.get(1));
        double secondSin = firstSin * lengthOfSides.get(0) / maxLength;

        double firstASIN = (Math.asin(firstSin) * 180) / Math.PI;
        double secondASIN = (Math.asin(secondSin) * 180) / Math.PI;
        double thirdASIN = 180 - firstASIN - secondASIN;

        boolean isRectangular = (thirdASIN == 90 || secondASIN == 90 || firstASIN == 90);

        if ((triangle.getLengths().get(0) == triangle.getLengths().get(1)) && (triangle.getLengths().get(0) == triangle.getLengths().get(2))){
           addTriangleToTable(TriangleTypes.EQUILATERAL, triangle);
        } else if ((triangle.getLengths().get(0) != triangle.getLengths().get(1)) && (triangle.getLengths().get(0) != triangle.getLengths().get(2))
                    && (triangle.getLengths().get(1) != triangle.getLengths().get(2)) && !isRectangular)  {
            addTriangleToTable(TriangleTypes.ARBITRARY, triangle);
        } else if (isRectangular) {
            addTriangleToTable(TriangleTypes.RECTANGULAR, triangle);
        }else{
            addTriangleToTable(TriangleTypes.ISOSCELES, triangle);
        }
    }

    private static void addTriangleToTable(TriangleTypes triangleType, Triangle triangle){

        triangleTypesArrayListMap.computeIfAbsent(triangleType, k -> new ArrayList<>());

        triangleTypesArrayListMap.get(triangleType).add(triangle);
    }

    public static Map<TriangleTypes, ArrayList<Object>> getTriangleTypesTable() {
        return triangleTypesArrayListMap;
    }

    public static Triangle findTriangleWithMaxPerimeter(TriangleTypes triangleType){
        Triangle triangleWithMaxPerimeter = null;
        double maxPerimeter = 0;
        for (Object obj : triangleTypesArrayListMap.get(triangleType)) {
            Triangle triangle = (Triangle) obj;

            if ((triangle.getPerimeter() > maxPerimeter)) {
                maxPerimeter = triangle.getPerimeter();
                triangleWithMaxPerimeter = triangle;
            }
        }

        return triangleWithMaxPerimeter;
    }

    public static Triangle findTriangleWithMaxSquare(TriangleTypes triangleType){
        Triangle triangleWithMaxSquare = null;
        double maxSquare = 0;
        for (Object obj : triangleTypesArrayListMap.get(triangleType)) {
            Triangle triangle = (Triangle) obj;

            if ((triangle.getSquare() > maxSquare)) {
                maxSquare = triangle.getSquare();
                triangleWithMaxSquare = triangle;
            }
        }

        return triangleWithMaxSquare;
    }

    public static Triangle findTriangleWithMinPerimeter(TriangleTypes triangleType){
        Triangle triangleWithMinPerimeter = null;
        double minPerimeter = 0;
        for (Object obj : triangleTypesArrayListMap.get(triangleType)) {
            Triangle triangle = (Triangle) obj;

            if ((triangle.getPerimeter() < minPerimeter) || minPerimeter == 0) {
                minPerimeter = triangle.getPerimeter();
                triangleWithMinPerimeter = triangle;
            }
        }

        return triangleWithMinPerimeter;
    }

    public static Triangle findTriangleWithMinSquare(TriangleTypes triangleType){
        Triangle triangleWithMinSquare = null;
        double minSquare = 0;
        for (Object obj : triangleTypesArrayListMap.get(triangleType)) {
            Triangle triangle = (Triangle) obj;

            if ((triangle.getSquare() < minSquare) || minSquare == 0) {
                minSquare = triangle.getSquare();
                triangleWithMinSquare = triangle;
            }
        }

        return triangleWithMinSquare;
    }
}
