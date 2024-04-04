package case_module2.service;


import case_module2.controller.LoginController;
import case_module2.read_write_file.AccountDTO;

import case_module2.read_write_file.HistoryDTO;
import case_module2.read_write_file.ShoppingCartDTO;
import case_module2.model.bill.Bill;
import case_module2.model.shopping_cart.ShoppingCart;
import case_module2.model.user_account.CustomerAccount;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CustomerService {
    private List<CustomerAccount> customerAccountList;
    private boolean isBillPrinted;

    public CustomerService() {
        customerAccountList = AccountDTO.readCustomerAccount();
        isBillPrinted = false;
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
                System.out.println();
                return;
            }
        }
        System.out.println("Không tìm thấy tài khoản khách hàng");
    }

    public void showBill(Bill bill) {
        int maxProductNameLength = 30;
        int maxQuantityLength = 20;
        int maxPriceLength = 20;
        int maxTotalLength = 20;

        if (isBillPrinted) {
            return;
        }
        List<ShoppingCart> shoppingCartList = ShoppingCartService.getMyCart();
        double total = 0;

        System.out.println("______________________________________________________________________________________________________________");
        System.out.printf("|%-33s |%-25s |%-15s |%-13s |%-20s |\n", "Thời Gian", "Tên Sản Phẩm", "Số Lượng", "Giá", "Tổng Tiền");
        for (ShoppingCart shoppingCart : shoppingCartList) {
            System.out.println("|----------------------------------|--------------------------|----------------|--------------|---------------|");
            double itemTotal = shoppingCart.getProductQuantity() * shoppingCart.getProductPrice();

            String productName = shoppingCart.getProductName();
            if (productName.length() > maxProductNameLength) {
                productName = productName.substring(0, maxProductNameLength - 3) + "...";
            }

            String quantity = String.valueOf(shoppingCart.getProductQuantity());
            if (quantity.length() > maxQuantityLength) {
                quantity = quantity.substring(0, maxQuantityLength - 3) + "...";
            }

            String price = String.valueOf(shoppingCart.getProductPrice());
            if (price.length() > maxPriceLength) {
                price = price.substring(0, maxPriceLength - 3) + "...";
            }

            String itemTotalString = String.valueOf(itemTotal);
            if (itemTotalString.length() > maxTotalLength) {
                itemTotalString = itemTotalString.substring(0, maxTotalLength - 3) + "...";
            }

            System.out.printf("|%-33s |%-25s |%-15s |%-13s |%-20s |\n", bill.getTimeTransaction(), productName, quantity, price, itemTotalString);
            total += itemTotal;
        }
        System.out.println("|_____________________________________________________________________________________________________________|");
        System.out.printf("|%-92s |%-20.2f |\n", "Total:", total);
        System.out.println("|_____________________________________________________________________________________________________________|");
        System.out.println();

        isBillPrinted = true;
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
                    List<ShoppingCart> myShoppingCartList = ShoppingCartService.getMyCart();
                    List<Bill> billList = new ArrayList<>();

                    for (ShoppingCart shoppingCart : myShoppingCartList) {
                        Bill bill = new Bill(LocalDateTime.now(), shoppingCart.getProductName(), shoppingCart.getProductPrice(), shoppingCart.getProductQuantity(), shoppingCart.getCustomerName(), shoppingCart.getTotalPrice());
                        billList.add(bill);
                    }

                    double totalCost = new Bill().calculateTotalCost(myShoppingCartList);

                    if (totalCost < currentAccount.getWallet()) {
                        HistoryDTO.writeFile(billList);

                        ProductService productService = new ProductService();
                        productService.changeWhenBuy(myShoppingCartList);
                        System.out.println("Thanh toán thành công! Cảm ơn quý khách!");

                        for (Bill bill : billList) {
                            showBill(bill);
                        }

                        double newWalletBalance = currentAccount.getWallet() - totalCost;
                        currentAccount.setWallet(newWalletBalance);
                        AccountDTO.writeCustomerAccounts(customerAccountList);

                        myShoppingCartList.clear();
                        ShoppingCartDTO.writeFile(myShoppingCartList);
                        } else {
                        System.err.println("Số dư trong tài khoản không đủ để thanh toán. Vui lòng nạp thêm tiền");
                    }
                    break;

                case 2:
                    System.out.println("Giao dịch bị hủy");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ! Giao dịch bị hủy");
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
            System.out.println();
        } else {
            System.out.println("Không tìm thấy thông tin tài khoản");
            System.out.println();
        }
    }
}
