package case_module2.main_case;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateAdminAccount {
    public static void main(String[] args) {
        String adminUserName = "Admin";
        String password = "MyPassword";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\CodeGym\\Module_2\\luyen_tap_code_java\\case_module2\\admin_account.csv"))) {
            String line = adminUserName + "," + password;
            writer.write(line);
            writer.newLine();
            System.out.println("Tạo tệp tin CSV thành công");
        } catch (IOException e) {
            System.err.println("Có lỗi khi tạo tệp tin CSV: " + e.getMessage());
        }
    }
}
