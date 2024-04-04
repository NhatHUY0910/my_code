package bai_tap_interface;

public class TestCalculator {
    public static void main(String[] args) {
        CalculatorCasioFX500 casioFX500 = new CalculatorCasioFX500();
        CalculatorVinacal500 vinacal500 = new CalculatorVinacal500();

        System.out.println("Test máy tính CasioFX500:");
        System.out.println("9 + 3 = " + casioFX500.addition(9, 3));
        System.out.println("9 - 3 = " + casioFX500.subtraction(9, 3));
        System.out.println("9 * 3 = " + casioFX500.multiplication(9, 3));
        System.out.println("9 / 3 = " + casioFX500.division(9, 3));

        System.out.println();
        System.out.println("Test máy tính Vinacal500:");
        System.out.println("9 + 3 = " + vinacal500.addition(9, 3));
        System.out.println("9 - 3 = " + vinacal500.subtraction(9, 3));
        System.out.println("9 * 3 = " + vinacal500.multiplication(9, 3));
        System.out.println("9 / 3 = " + vinacal500.division(9, 3));

        System.out.println();
        double[] arr1 = new double[]{7, 5, 2, 4, 12, 13, 9};
        double[] arr2 = new double[]{13, 11, 6, 8, 3, 9, 12};

        InsertionSort insertionSort = new InsertionSort();
        SelectionSort selectionSort = new SelectionSort();

        System.out.println("Test sắp xếp chèn:");
        System.out.println("Mảng arr1 sau khi sắp xếp theo thứ tự tăng dần: ");
        insertionSort.ascendingOrder(arr1);
        for (double v : arr1) {
            System.out.print( v + ", ");
        }

        System.out.println();
        System.out.println("Mảng arr1 sau khi sắp xếp theo thứ tự giảm dần: ");
        insertionSort.descendingOrder(arr1);
        for (double v : arr1) {
            System.out.print( v + ", ");
        }

        System.out.println();
        System.out.println();
        System.out.println("Test sắp xếp chọn:");
        System.out.println("Mảng arr2 sau khi sắp xếp theo thứ tự tăng dần: ");
        selectionSort.ascendingOrder(arr2);
        for (double v : arr2) {
            System.out.print( v + ", ");
        }

        System.out.println();
        System.out.println("Mảng arr2 sau khi sắp xếp theo thứ tự giảm dần: ");
        selectionSort.descendingOrder(arr2);
        for (double v : arr2) {
            System.out.print( v + ", ");
        }
        System.out.println();

        System.out.println();
        System.out.println("Test phần mềm máy tính: ");
        CalculatorSoftware calculatorSoftware = new CalculatorSoftware();

        System.out.println("9 + 3 = " + calculatorSoftware.addition(9, 3));
        System.out.println();

        calculatorSoftware.ascendingOrder(arr1);
        System.out.println("Mảng arr1 sau khi sắp xếp theo thứ tự tăng dần: ");
        for (double v : arr1) {
            System.out.print( v + ", ");
        }
    }
}
