package bai_tap_interface;

public class CalculatorVinacal500 implements Calculator {
    @Override
    public double addition(double a, double b) {
        return a + b;
    }

    @Override
    public double subtraction(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplication(double a, double b) {
        return a * b;
    }

    @Override
    public double division(double a, double b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0");
            int j = 0;
            return j;
        }
    }
}
