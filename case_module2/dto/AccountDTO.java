package case_module2.dto;

import case_module2.model.enum_user.GenderCustomer;
import case_module2.model.user_account.AdminAccount;
import case_module2.model.user_account.CustomerAccount;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDTO {
    private static final File CUSTOMER_FILE = new File("customer_accounts.csv") ;

    private static final File ADMIN_FILE_PATH = new File("D:\\CodeGym\\Module_2\\luyen_tap_code_java\\case_module2\\admin_account.csv") ;

    public static List<CustomerAccount> readCustomerAccount() {
        List<CustomerAccount> customerAccountList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader( new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] accountData = line.split(",");
                if (accountData.length == 8) {
                    CustomerAccount customerAccount = new CustomerAccount(
                            accountData[0],
                            accountData[1],
                            accountData[2],
                            Integer.parseInt(accountData[3]),
                            GenderCustomer.valueOf(accountData[4].toUpperCase()) ,
                            Integer.parseInt(accountData[5]),
                            accountData[6],
                            Double.parseDouble(accountData[7])
                    );
                    customerAccountList.add(customerAccount);
                    }
                }
            } catch (IOException e) {
                System.err.println("Có lỗi khi đọc file dữ liệu khách hàng: " + e.getMessage());
        }
        return customerAccountList;
        }

    public static AdminAccount readAdminAccount() {
        AdminAccount adminAccount = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(ADMIN_FILE_PATH))) {
            String line = reader.readLine();
            if (line != null) {
                String[] accountData = line.split(",");
                if (accountData.length == 2) {
                    adminAccount = new AdminAccount(
                            accountData[0],
                            accountData[1]
                    );
                }
            }
        } catch (IOException e) {
            System.err.println("Có lỗi khi đọc file dữ liệu của admin: " + e.getMessage());
        }
        return adminAccount;
    }
        public static void writeCustomerAccounts(List<CustomerAccount> customerAccountList) {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(CUSTOMER_FILE))) {
                for (CustomerAccount customerAccount : customerAccountList) {
                    String line = customerAccount.getUserName() + "," +
                            customerAccount.getPassWord() + "," +
                            customerAccount.getFullName() + "," +
                            customerAccount.getAge() + "," +
                            customerAccount.getGender() + "," +
                            customerAccount.getPhoneNumber() + "," +
                            customerAccount.getCountry() + "," +
                            customerAccount.getWallet();
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                System.err.println("Có lỗi khi ghi file của tài khoản khách hàng: " + e.getMessage());
            }
        }

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
