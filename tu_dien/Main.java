package tu_dien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TuDien tuDien = new TuDien();

        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-------------------------");
            System.out.println("Menu ");
            System.out.println("1. Thêm từ và ý nghĩa của từ \n"
                                + "2. Xóa từ \n"
                                + "3. Tìm ý nghĩa của từ \n"
                                + "4. In danh sách từ \n"
                                + "5. In số lượng từ \n"
                                + "6. Xóa tất cả từ \n"
                                + "0. Thoát khỏi chương trình" );

            choice = sc.nextInt(); sc.nextLine();
            if (choice == 1) {
                    System.out.println("Nhập từ khóa: ");
                    String tuKhoa = sc.nextLine();
                    System.out.println("Nhập ý nghĩa: ");
                    String yNghia = sc.nextLine();
                    tuDien.addWord(tuKhoa, yNghia);
            } else if (choice == 2 || choice == 3) {
                    System.out.println("Nhập từ khóa: ");
                    String tuKhoa = sc.nextLine();
                    if (choice == 2) {
                        tuDien.removeWord(tuKhoa);
                    } else {
                        System.out.println("Ý nghĩa của từ khóa là: " + tuDien.meaningOfWord(tuKhoa));
                    }
            } else if (choice == 4) {
                tuDien.getWord();
            } else if (choice == 5) {
                tuDien.amountWord();
            } else if (choice == 6) {
                tuDien.deleteAllWord();
            }

        } while (choice != 0);

    }
}
