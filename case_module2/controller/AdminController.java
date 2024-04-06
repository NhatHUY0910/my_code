package case_module2.controller;

import case_module2.service.AdminService;
import case_module2.service.HistoryService;
import case_module2.service.ProductService;
import case_module2.view.AdminMenuStrategy;
import case_module2.view.PrintNewPage;

import java.util.Scanner;

public class AdminController {
    private final ProductService productService;
    private final AdminService adminService;
    private final HistoryService historyService;

    public AdminController() {
        productService = new ProductService();
        adminService = new AdminService();
        historyService = HistoryService.getInstance();
    }

        public void controller() throws InterruptedException {
            Scanner scanner = new Scanner(System.in);
            AdminController adminController = new AdminController();
            AdminMenuStrategy adminMenuStrategy = new AdminMenuStrategy();

            while (true) {
                System.out.println("Lựa chọn chức năng:");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        adminController.adminService.createNewProduct();
                        break;
                    case 2:
                        adminController.adminService.editProduct();
                        break;
                    case 3:
                        adminController.adminService.deleteProduct();
                        break;
                    case 4:
                        System.out.println("Nhập tên sản phẩm bạn muốn tìm:");
                        scanner.nextLine();
                        String productName = scanner.nextLine();

                        adminController.productService.searchProductByName(productName);
                        break;
                    case 5:
                        adminController.productService.showAllProduct();
                        break;
                    case 6:
                        adminController.historyService.showAllHistory();
                        break;
                    case 7:
                        adminController.historyService.showTurnover();
                        break;
                    case 0:
                        System.out.println("------Chào Ngài Chủ Tịch------");
                        Thread.sleep(1000);
                        PrintNewPage.newPage();
                        HomePageController.load();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
                adminMenuStrategy.showMenu();
        }
    }
}
