package lab;

import java.util.function.DoubleBinaryOperator;

public class MyLambdaToMethod {
    //Статический метод, считающий площадь прямоугольника
    private static DoubleBinaryOperator calculateRectangleAreaLambda = (a, b) -> a * b;
    //Нестатический метод, считающий площадь треугольника
    private DoubleBinaryOperator calculateTriangleArea = (a, b) -> a * b / 2;
    //Лямбда-выражение, возвращающее наибольшее из двух чисел
    private DoubleBinaryOperator getMaxOfTwoNumbers = Math::max;
    private DoubleBinaryOperator getMaxOfTwoNumbersVariantTwo = (a, b) -> a > b ? a : b;
    //
    public static void main(String[] args) {
        MyLambdaToMethod myLambdaToMethod = new MyLambdaToMethod();
        double rectangleArea = myLambdaToMethod.manipulateData(new double[]{1.1, 2.2}, calculateRectangleAreaLambda);
        double triangleArea = myLambdaToMethod.manipulateData(new double[]{1.1, 2.2}, myLambdaToMethod.calculateTriangleArea);
        double maxOfTwo = myLambdaToMethod.manipulateData(new double[]{1.1, 2.2}, myLambdaToMethod.getMaxOfTwoNumbers);
    }

    public static double calculateRectangleArea(double a, double b) {
        return a * b;
    }

    public double manipulateData(double[] arr, DoubleBinaryOperator doubleBinaryOperator) {
        if (arr == null || arr.length != 2 || doubleBinaryOperator == null) {
            throw new IllegalArgumentException();
        }
        return doubleBinaryOperator.applyAsDouble(arr[0], arr[1]);
    }

    public double calculateTriangleArea(double a, double h) {
        return calculateRectangleArea(a, h) / 2;
    }
}