package case_module2.service;


import case_module2.controller.LoginController;
import case_module2.dto.AccountDTO;

import case_module2.dto.HistoryDTO;
import case_module2.dto.ShoppingCartDTO;
import case_module2.model.bill.Bill;
import case_module2.model.shopping_cart.ShoppingCart;
import case_module2.model.user_account.CustomerAccount;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerService {

    private List<CustomerAccount> customerAccountList;

    public CustomerService() {
        customerAccountList = AccountDTO.readCustomerAccount();
    }

    public void addMoney(double amount) {
        String currentAccount = LoginController.currentAccount;
        if (currentAccount.isEmpty()) {
            System.out.println("Vui lòng đăng nhập trước khi nạp tiền");
            return;
        }

        for (CustomerAccount customerAccount : customerAccountList) {
            if (customerAccount.getUserName().equals(currentAccount)) {
                double currentWallet = customerAccount.getWallet();
                double newWallet = currentWallet + amount;
                customerAccount.setWallet(newWallet);
                AccountDTO.writeCustomerAccounts(customerAccountList);
                System.out.println("Nạp tiền thành công. Số dư mới: " + newWallet);
                return;
            }
        }
        System.out.println("Không tìm thấy tài khoản khách hàng");
    }

    public void showBill(Bill bill) {
        List<ShoppingCart> shoppingCartList = ShoppingCartService.getMyCart();
        double total = 0;

        System.out.println("___________________________________________________________________");
        System.out.printf("|%-36s |%-20s |%-10s |%-10s |%-10s |\n", "Thời Gian", "Tên Sản Phẩm", "Số Lượng", "Giá", "Tổng Tiền");
        for (ShoppingCart shoppingCart : shoppingCartList) {
            System.out.println("|-------------|---------------------|-----------|----------|----------|");
            double itemTotal = shoppingCart.getProductQuantity() * shoppingCart.getProductPrice();
            System.out.printf("|%-12s |%-20s |%-10d |%-10.2f |%-10.2f |\n", bill.getTimeTransaction(), shoppingCart.getProductName(), shoppingCart.getProductQuantity(), shoppingCart.getProductPrice(), itemTotal);
            total += itemTotal;
        }
        System.out.println("|___________________________________________________________________|");
        System.out.printf("|%-54s |%-10.2f |\n", "Total:", total);
        System.out.println("|___________________________________________________________________|");
    }

    public void buyProduct() {
        CustomerAccount currentAccount = null;
        Scanner scanner = new Scanner(System.in);
        List<CustomerAccount> customerAccountList1 = AccountDTO.readCustomerAccount();

        for (CustomerAccount customerAccount1 : customerAccountList1) {
            if (customerAccount1.getUserName().equals(LoginController.currentAccount)) {
                currentAccount = customerAccount1;
                break;
            }
        }

        boolean isExist = !ShoppingCartService.getMyCart().isEmpty();

        if (isExist) {
            int choice;
            System.out.println("-------Giỏ Hàng Của Bạn-------");
            ShoppingCartService.viewMyCart();
            System.out.println("Bạn có muốn mua tất cả sản phẩm trong giỏ hàng không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    double shoppingCartTotal = ShoppingCartService.getTotal();

                    if (shoppingCartTotal < currentAccount.getWallet()) {
                        LocalDateTime now = LocalDateTime.now();
                        String currentName = currentAccount.getUserName();
                        List<ShoppingCart> myShoppingCartList = ShoppingCartService.getMyCart();
                        List<Bill> billList = new ArrayList<>();

                        for (ShoppingCart cart : myShoppingCartList) {
                            Bill bill = new Bill(now, cart.getProductName(), cart.getProductPrice(), cart.getProductQuantity(), cart.getCustomerName(), cart.getTotalPrice());
                            billList.add(bill);
                        }

                        HistoryDTO.writeFile(billList);

                        ProductService productService = new ProductService();
                        productService.changeWhenBuy(myShoppingCartList);
                        System.out.println("Thanh toán thành công! Cảm ơn quý khách!");

                        for (Bill bill : billList) {
                            showBill(bill);
                        }

                        double newWalletBalance = currentAccount.getWallet() - shoppingCartTotal;
                        currentAccount.setWallet(newWalletBalance);
                        AccountDTO.writeCustomerAccounts(customerAccountList1);

                        myShoppingCartList.clear();
                        ShoppingCartDTO.writeFile(myShoppingCartList);

                        double totalCost = calculateTotalCost(billList);

                        for (Bill bill : billList) {
                            bill.setTotalCost(totalCost);
                        }
                    } else {
                        System.err.println("Số dư trong tài khoản không đủ để thanh toán. Vui lòng nạp thêm tiền");
                    }
                    break;

                case 2:
                    System.out.println("Giao dịch bị hủy");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Giao dịch bị hủy");
                    break;
            }
        } else {
            System.out.println("Không có sản phẩm nào trong giỏ hàng của bạn");
        }
    }

    private double calculateTotalCost(List<Bill> billList) {
        double totalCost = 0.0;

        for (Bill bill : billList) {
            totalCost += bill.getProductPrice() * bill.getProductQuantity();
        }
        return totalCost;
    }

    public void showWallet() {
        List<CustomerAccount> customerAccountList = AccountDTO.readCustomerAccount();
        CustomerAccount currentAccount = null;
        for (CustomerAccount customerAccount : customerAccountList) {
            if (customerAccount.getUserName().equals(LoginController.currentAccount)) {
                currentAccount = customerAccount;
                break;
            }
        }

        if (currentAccount != null) {
            System.out.println("Số dư tài khoản của bạn là: " + currentAccount.getWallet());
        } else {
            System.out.println("Không tìm thấy thông tin tài khoản");
        }
    }
}
