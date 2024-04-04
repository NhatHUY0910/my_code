package case_module2.controller;

import case_module2.service.AccountService;
import case_module2.view.HomePageView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomePageController {
    public static void load() throws InterruptedException {
        AccountService accountService = new AccountService();
        LoginController loginController = new LoginController();
        boolean isValid = true;

        do {
            HomePageView.displayView();
            Scanner scanner = new Scanner(System.in);
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        loginController.login();
                        isValid = false;
                        break;
                    case 2:
                        accountService.createCustomerAccount();
                        isValid = false;
                        break;
                    case 0:
                        System.out.println("--------Hẹn Tương Lai Gặp Lại--------");
                        LoginController.currentAccount = null;
                        isValid = false;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại");
                        System.out.println();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại");
                System.out.println();
                scanner.nextLine();
            }
        } while (isValid);
    }
}
