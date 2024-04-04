package demo.ViDu;

import java.util.Scanner;

public class ViDuTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        try {
            System.out.println("Nhap vao 1 so nguyen bat ki:");
            number = scanner.nextInt();
        }catch (Exception e) {
            System.out.println("Nhap sai du lieu!");
        }
        

        System.out.println("So nguyen ban vua nhap la: " + number);
        System.out.println("Ket thuc chuong trinh");
    }
}
