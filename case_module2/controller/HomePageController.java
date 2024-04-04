package case_module2.controller;

import case_module2.service.AccountService;
import case_module2.view_display.HomePageView;

import java.util.Scanner;

public class HomePageController {
    public static void load() throws InterruptedException {
        AccountService accountService = new AccountService();
        LoginController loginController = new LoginController();
        boolean isValid = true;

        do {
            HomePageView.displayView();
            Scanner scanner = new Scanner(System.in);
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
                    System.out.println("--------Hẹn Gặp Lại Ở Tương Lai--------");
                    LoginController.currentAccount = null;
                    isValid = false;
                    System.exit(0);
            }
        } while (isValid);
    }
}
