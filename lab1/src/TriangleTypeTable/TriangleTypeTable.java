package TriangleTypeTable;

import Figure.Figure;
import TriangleType.TriangleType;

import java.util.*;


public class TriangleTypeTable {
    private static Map<TriangleType, ArrayList<Figure>> triangleTypesArrayListMap = new HashMap<>();

    public static void addTriangleByTypeToTable(Figure figure){

        List<Double> lengthOfSides = figure.calculateLengths();

        double maxLength = Collections.max(lengthOfSides);
        lengthOfSides.remove(maxLength);

        double firstSin = (2 * figure.calculateSquare()) / (lengthOfSides.get(0) * lengthOfSides.get(1));
        double secondSin = firstSin * lengthOfSides.get(0) / maxLength;

        double firstASIN = (Math.asin(firstSin) * 180) / Math.PI;
        double secondASIN = (Math.asin(secondSin) * 180) / Math.PI;
        double thirdASIN = 180 - firstASIN - secondASIN;

        boolean isRectangular = (thirdASIN == 90 || secondASIN == 90 || firstASIN == 90);


        if ((Objects.equals(figure.calculateLengths().get(0), figure.calculateLengths().get(1)))
                && (Objects.equals(figure.calculateLengths().get(0), figure.calculateLengths().get(2)))){
           addTriangleToTable(TriangleType.EQUILATERAL, figure);
        } else if ((!Objects.equals(figure.calculateLengths().get(0), figure.calculateLengths().get(1)))
                && (!Objects.equals(figure.calculateLengths().get(0), figure.calculateLengths().get(2)))
                && (!Objects.equals(figure.calculateLengths().get(1), figure.calculateLengths().get(2))) && !isRectangular)  {
            addTriangleToTable(TriangleType.ARBITRARY, figure);
        } else if (isRectangular) {
            addTriangleToTable(TriangleType.RECTANGULAR, figure);
        }else{
            addTriangleToTable(TriangleType.ISOSCELES, figure);
        }
    }

    private static void addTriangleToTable(TriangleType triangleType, Figure figure){

        triangleTypesArrayListMap.computeIfAbsent(triangleType, k -> new ArrayList<>());

        triangleTypesArrayListMap.get(triangleType).add(figure);
    }

    public static Map<TriangleType, ArrayList<Figure>> getTriangleTypesTable() {
        return triangleTypesArrayListMap;
    }

    public static Figure findTriangleWithMaxPerimeter(TriangleType triangleType){
        Figure triangleWithMaxPerimeter = null;
        double maxPerimeter = 0;
        for (Figure triangle : triangleTypesArrayListMap.get(triangleType)) {
            if ((triangle.calculatePerimeter() > maxPerimeter)) {
                maxPerimeter = triangle.calculatePerimeter();
                triangleWithMaxPerimeter = triangle;
            }
        }

        return triangleWithMaxPerimeter;
    }

    public static Figure findTriangleWithMaxSquare(TriangleType triangleType){
        Figure triangleWithMaxSquare = null;
        double maxSquare = 0;
        for (Figure triangle : triangleTypesArrayListMap.get(triangleType)) {
            if ((triangle.calculateSquare() > maxSquare)) {
                maxSquare = triangle.calculateSquare();
                triangleWithMaxSquare = triangle;
            }
        }

        return triangleWithMaxSquare;
    }

    public static Figure findTriangleWithMinPerimeter(TriangleType triangleType){
        Figure triangleWithMinPerimeter = null;
        double minPerimeter = 0;
        for (Figure triangle : triangleTypesArrayListMap.get(triangleType)) {
            if ((triangle.calculatePerimeter() < minPerimeter) || minPerimeter == 0) {
                minPerimeter = triangle.calculatePerimeter();
                triangleWithMinPerimeter = triangle;
            }
        }

        return triangleWithMinPerimeter;
    }

    public static Figure findTriangleWithMinSquare(TriangleType triangleType){
        Figure triangleWithMinSquare = null;
        double minSquare = 0;
        for (Figure triangle : triangleTypesArrayListMap.get(triangleType)) {
            if ((triangle.calculateSquare() < minSquare) || minSquare == 0) {
                minSquare = triangle.calculateSquare();
                triangleWithMinSquare = triangle;
            }
        }

        return triangleWithMinSquare;
    }
}
