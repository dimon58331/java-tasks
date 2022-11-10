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

    public static double findMaxPerimeter(Map<TriangleTypes, ArrayList<Object>> triangleTypesTable, TriangleTypes triangleType){
        ArrayList<Double> trianglePerimeters = new ArrayList<>();
        Triangle triangle = null;
        for (Object obj : triangleTypesTable.get(triangleType)) {
            triangle = (Triangle) obj;
            trianglePerimeters.add(triangle.getPerimeter());
        }
        double maxPerimeter = Collections.max(trianglePerimeters);
        System.out.println("Max perimeter of " + triangleType.name() + " type -> " + maxPerimeter + " information about object -> " + triangle);

        return maxPerimeter;
    }

    public static double findMaxSquare(Map<TriangleTypes, ArrayList<Object>> triangleTypesTable, TriangleTypes triangleType){
        ArrayList<Double> triangleSquares = new ArrayList<>();
        Triangle triangle = null;
        for (Object obj : triangleTypesTable.get(triangleType)) {
            triangle = (Triangle) obj;
            triangleSquares.add(triangle.getSquare());
        }
        double maxSquare = Collections.max(triangleSquares);
        System.out.println("Max square of " + triangleType.name() + " type -> " + maxSquare + " information about object -> " + triangle);

        return maxSquare;
    }

    public static double findMinPerimeter(Map<TriangleTypes, ArrayList<Object>> triangleTypesTable, TriangleTypes triangleType){
        ArrayList<Double> trianglePerimeters = new ArrayList<>();
        Triangle triangle = null;
        for (Object obj : triangleTypesTable.get(triangleType)) {
            triangle = (Triangle) obj;
            trianglePerimeters.add(triangle.getPerimeter());
        }
        double minPerimeter = Collections.min(trianglePerimeters);
        System.out.println("Min perimeter of " + triangleType.name() + " type -> " + minPerimeter + " information about object -> " + triangle);

        return minPerimeter;
    }

    public static double findMinSquare(Map<TriangleTypes, ArrayList<Object>> triangleTypesTable, TriangleTypes triangleType){
        ArrayList<Double> triangleSquares = new ArrayList<>();
        Triangle triangle = null;
        for (Object obj : triangleTypesTable.get(triangleType)) {
            triangle = (Triangle) obj;
            triangleSquares.add(triangle.getSquare());
        }
        double minSquare = Collections.min(triangleSquares);
        System.out.println("Min square of " + triangleType.name() + " type -> " + minSquare + " information about object -> " + triangle);

        return minSquare;
    }
}
