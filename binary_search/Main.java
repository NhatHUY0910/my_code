package binary_search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arrRecursive = {2, 3, 4, 5, 7, 9, 12, 13, 14, 16, 17, 19};
        int[] arrIterative = {1, 4, 5, 6, 9, 10, 12, 13, 15, 17, 19};

        System.out.println("Nhập vào 1 số nguyên trong khoảng từ 1 đến 19:");
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();

        int resultRecursive = BinarySearchRecursive.calculateRecursive(arrRecursive, 0, arrRecursive.length -1, inputNumber);

        int resultIterative = BinarySearchIterative.calculateIterative(arrIterative, inputNumber);

        // Sử dụng đệ quy:
        if (resultRecursive != -1) {
            System.out.println("Giá trị bạn nhập được tìm thấy tại vị trí thứ " + resultRecursive + " trong mảng (đệ quy)");
        } else {
            System.out.println("Giá trị bạn nhập không được tìm thấy trong mảng (đệ quy)");
        }

        // Không sử dụng đệ quy (lặp):
        if (resultIterative != -1) {
            System.out.println("Giá trị bạn nhập được tìm thấy tại vị trí " + resultIterative + " trong mảng (lặp)");
        } else {
            System.out.println("Giá trị bạn nhập không có trong mảng (lặp)");
        }

    }
}
