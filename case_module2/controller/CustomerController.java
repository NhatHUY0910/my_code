package case_module2.controller;

import case_module2.model.shopping_cart.ShoppingCart;
import case_module2.service.AccountService;
import case_module2.service.CustomerService;
import case_module2.service.ProductService;
import case_module2.service.ShoppingCartService;
import case_module2.view.CustomerMenu;
import case_module2.view.PrintNewPage;

import java.util.Scanner;

public class CustomerController {
    public static void controller() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();
        boolean isExcept = false;

        do {
            System.out.println("Vui lòng chọn chức năng bạn muốn:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhập số tiền bạn cần nạp:");
                    double inputMoney = scanner.nextDouble();
                    scanner.nextLine();

                    customerService.addMoney(inputMoney);
                    CustomerMenu.showMenu();
                    break;

                case 2:
                    productService.showAllProduct();
                    CustomerMenu.showMenu();
                    break;

                case 3:
//                    isExcept = true;
                    System.out.println("Nhập tên sản phẩm bạn muốn tìm:");
                    String productName = scanner.nextLine();

                    productService.searchProductByName(productName);
                    CustomerMenu.showMenu();
                    break;

                case 4:
                    ShoppingCartService.addToCart();
                    CustomerMenu.showMenu();
                    break;
                case 5:
                    ShoppingCartService.removeFromCart();
                    CustomerMenu.showMenu();
                    break;
                case 6:
                    ShoppingCartService.viewMyCart();
                    CustomerMenu.showMenu();
                    break;
                case 7:
                    customerService.buyProduct();
                    CustomerMenu.showMenu();
                    break;
                case 8:
                    customerService.showWallet();
                    CustomerMenu.showMenu();
                    break;
                case 9:
                    System.out.println("Nhập tên đăng nhập:");
                    String userName = scanner.nextLine();
                    accountService.changePassword(userName);
                    break;
                case 0:
                    System.out.println("-------Hẹn Tương Lai Gặp Lại-------");
                    Thread.sleep(1000);
                    LoginController.currentAccount = null;
                    PrintNewPage.newPage();
                    HomePageController.load();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại");
            }
        } while (!isExcept);
    }
}
