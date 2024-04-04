package case_module2.view;

import case_module2.controller.CustomerController;

public class CustomerMenu {
    public static void showMenu() throws InterruptedException {
        System.out.println("----------------Menu----------------");
        System.out.println("Chọn chức năng bạn muốn: ");
        System.out.println("1. Nạp tiền vào ví");
        System.out.println("2. Hiển thị danh sách sản phẩm");
        System.out.println("3. Tìm kiếm sản phẩm theo tên");
        System.out.println("4. Thêm sản phẩm vào giỏ hàng");
        System.out.println("5. Bỏ sản phẩm khỏi giỏ hàng");
        System.out.println("6. Hiển thị giỏ hàng");
        System.out.println("7. Mua");
        System.out.println("8. Hiển thị số dư trong ví");
        System.out.println("9. Đổi mật khẩu");
        System.out.println("0. Thoát");
        CustomerController.controller();
    }
}
