package case_module2.view;

import case_module2.controller.AdminController;

import java.awt.*;

public class AdminMenuStrategy implements MenuStrategy{
    public void showMenu() throws InterruptedException {
        System.out.println("----------------Menu----------------");
        System.out.println("Chọn chức năng bạn muốn: ");
        System.out.println("1. Tạo mới một sản phẩm");
        System.out.println("2. Chỉnh sửa thông tin sản phẩm");
        System.out.println("3. Xóa bỏ một sản phẩm");
        System.out.println("4. Tìm kiếm sản phẩm dựa theo tên");
        System.out.println("5. Hiển thị danh sách tất cả sản phẩm");
        System.out.println("6. Hiển thị lịch sử giao dịch");
        System.out.println("7. Hiển thị doanh thu bán hàng");
        System.out.println("0. Thoát");

        AdminController adminController = new AdminController();
        adminController.controller();
    }

    @Override
    public void execute() throws InterruptedException {
        showMenu();
    }
}
