package case_module2.controller;

import case_module2.read_write_file.AccountDTO;
import case_module2.model.user_account.AdminAccount;
import case_module2.model.user_account.CustomerAccount;
import case_module2.view.AdminMenuStrategy;
import case_module2.view.CustomerMenuStrategy;

import java.util.List;
import java.util.Scanner;

public class LoginController {
    private Scanner scanner;
    private List<CustomerAccount> customerAccountList;
    private AdminAccount adminAccount;

    public static String currentAccount;

    public LoginController() {
        scanner = new Scanner(System.in);
        customerAccountList = AccountDTO.readCustomerAccount();
        adminAccount = AccountDTO.readAdminAccount();
    }

    public void login() throws InterruptedException {
        boolean isSucceeded = false;
        boolean isLoggedIn = false;
        AdminMenuStrategy adminMenuStrategy = new AdminMenuStrategy();
        CustomerMenuStrategy customerMenuStrategy = new CustomerMenuStrategy(new CustomerController());

        while (!isLoggedIn) {
            System.out.println("-----------Đăng Nhập-----------");
            System.out.println("Tên Đăng Nhập: ");
            String inputUserName = scanner.nextLine();
            System.out.println("Mật Khẩu: ");
            String inputPassword = scanner.nextLine();

            CustomerAccount customerAccount = findCustomerAccount(inputUserName);
                if (customerAccount != null && customerAccount.getPassWord().equals(inputPassword)) {
//                    isSucceeded = true;
                    currentAccount = inputUserName;
                    System.out.println("Đăng nhập thành công!");
                    Thread.sleep(1000);
                    System.out.println();

                    AccountDTO.writeCustomerAccounts(customerAccountList);
                    customerMenuStrategy.showMenu();
//                    isLoggedIn = true;
                    break;
                }

            if (!isSucceeded && adminAccount != null && adminAccount.getUserName().equals(inputUserName) && adminAccount.getPassWord().equals(inputPassword)) {
//                isSucceeded = true;
                currentAccount = inputUserName;
                System.out.println("Đăng nhập thành công!");

                Thread.sleep(1000);
                adminMenuStrategy.showMenu();
//                isLoggedIn = true;
                break;
            }

            if (!isSucceeded) {
                System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác");
                System.out.println();
                login();
            }
        }

    }

    public static String getUserName() {
        List<CustomerAccount> customerAccountList = AccountDTO.readCustomerAccount();
        StringBuilder outputName = new StringBuilder();

        for (CustomerAccount customerAccount : customerAccountList) {
            outputName.append(customerAccount.getUserName()).append(",");
        }
        if (currentAccount.isEmpty()) {
            outputName.setLength(outputName.length() - 2);
        }
        return outputName.toString();
    }

    private CustomerAccount findCustomerAccount(String userName) {
        for (CustomerAccount customerAccount : customerAccountList) {
            if (customerAccount.getUserName().equals(userName)) {
                return customerAccount;
            }
        }
        return null;
    }
}
