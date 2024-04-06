package case_module2.controller;

import case_module2.service.AccountService;
import case_module2.service.CustomerService;
import case_module2.service.ProductService;
import case_module2.service.ShoppingCartService;

import case_module2.view.CustomerMenuStrategy;
import case_module2.view.PrintNewPage;

import java.util.Scanner;

public class CustomerController {
    private final ProductService productService;
    private final CustomerService customerService;
    private final AccountService accountService;
    private final ShoppingCartService shoppingCartService;
    private final CustomerMenuStrategy customerMenuStrategy;

    public CustomerController() {
        this.productService = new ProductService();
        this.customerService = new CustomerService();
        this.accountService = new AccountService();
        this.shoppingCartService = new ShoppingCartService();
        this.customerMenuStrategy = new CustomerMenuStrategy(this);
    }

    public void controller() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
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
                    customerMenuStrategy.showMenu();
                    break;

                case 2:
                    productService.showAllProduct();
                    customerMenuStrategy.showMenu();
                    break;

                case 3:
//                    isExcept = true;
                    System.out.println("Nhập tên sản phẩm bạn muốn tìm:");
                    String productName = scanner.nextLine();

                    productService.searchProductByName(productName);
                    customerMenuStrategy.showMenu();
                    break;

                case 4:
                    ShoppingCartService.addToCart();
                    customerMenuStrategy.showMenu();
                    break;
                case 5:
                    ShoppingCartService.removeFromCart();
                    customerMenuStrategy.showMenu();
                    break;
                case 6:
                    ShoppingCartService.viewMyCart();
                    customerMenuStrategy.showMenu();
                    break;
                case 7:
                    customerService.buyProduct();
                    customerMenuStrategy.showMenu();
                    break;
                case 8:
                    customerService.showWallet();
                    customerMenuStrategy.showMenu();
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

    public void showMenu() throws InterruptedException {
        customerMenuStrategy.showMenu();
    }
}
