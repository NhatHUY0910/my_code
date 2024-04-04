package case_module2.controller;

import case_module2.service.AdminService;
import case_module2.service.HistoryService;
import case_module2.service.ProductService;
import case_module2.view_display.AdminMenu;

import java.util.Scanner;

public class AdminController {
        public static void controller() throws InterruptedException {
            Scanner scanner = new Scanner(System.in);
            ProductService productService = new ProductService();
            AdminService adminService = new AdminService();
            System.out.println("Lựa chọn chức năng:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    adminService.createNewProduct();
                    AdminMenu.showMenu();
                    break;
                case 2:
                    adminService.editProduct();
                    AdminMenu.showMenu();
                    break;
                case 3:
                    adminService.deleteProduct();
                    AdminMenu.showMenu();
                    break;
                case 4:
                    System.out.println("Nhập tên sản phẩm bạn muốn tìm:");
                    scanner.nextLine();
                    String productName = scanner.nextLine();

                    productService.searchProductByName(productName);
                    AdminMenu.showMenu();
                    break;
                case 5:
                    productService.showAllProduct();
                    AdminMenu.showMenu();
                    break;
                case 6:
                    HistoryService.showAllHistory();
                    AdminMenu.showMenu();
                    break;
                case 7:
                    adminService.showTurnover();
                    AdminMenu.showMenu();
                    break;
                case 0:
                    System.out.println("------Chào Ngài Chủ Tịch------");
                    Thread.sleep(1000);
                    HomePageController.load();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
}
