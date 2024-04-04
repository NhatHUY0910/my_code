package case_module2.service;

import case_module2.controller.LoginController;
import case_module2.dto.ProductDTO;
import case_module2.dto.ShoppingCartDTO;
import case_module2.model.product.Product;
import case_module2.model.shopping_cart.ShoppingCart;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCartService {
    public static void addToCart() throws InterruptedException {
        ProductService productService = new ProductService();
        productService.showAllProduct();
        List<ShoppingCart> shoppingCartList = ShoppingCartDTO.readFile();
        List<Product> productList = ProductDTO.readFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();

        boolean isExist = false;
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                isExist = true;

                boolean quantityCheck = false;
                do {
                    System.out.println("Nhập số lượng sản phẩm bạn muốn thêm vào giỏ hàng:");
                    String quantity = scanner.nextLine();
                    if (isPositiveInteger(quantity)) {
                        int quantityInt = Integer.parseInt(quantity);

                        if (quantityInt > 0 && quantityInt <= product.getQuantity()) {
                            quantityCheck = true;
                            ShoppingCart shoppingCart = new ShoppingCart(product.getName(), product.getPrice(), quantityInt, product.getManufacturer(), product.getCountry(), LoginController.getUserName());
                            shoppingCartList.add(shoppingCart);
                            System.out.println("Sản phẩm đã được thêm vào giỏ hàng");
                            ShoppingCartDTO.writeFile(shoppingCartList);
                            ShoppingCartService.viewMyCart();
                        } else {
                            System.out.println("Dữ liệu không hợp lệ, vui lòng hãy nhập đúng số lượng");
                        }
                    } else {
                            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập vào số nguyên dương");
                        }
                    } while (!quantityCheck);
                }
            }
            if (!isExist) {
                System.err.println("Không tìm thấy sản phẩm");
        }
    }

    public static void removeFromCart() {
        List<ShoppingCart> shoppingCartList = ShoppingCartDTO.readFile();
        List<ShoppingCart> myCartList = getMyCart();

        if (myCartList.isEmpty()) {
            System.out.println("Giỏ hàng của bạn đang trống");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thứ tự sản phẩm bạn muốn xóa khỏi giỏ hàng:");
        int index = scanner.nextInt();

        if (index < 1 || index > myCartList.size()) {
            System.out.println("Số thứ tự không hợp lệ");
            return;
        }

        ShoppingCart removedItem = myCartList.get(index - 1);
        shoppingCartList.remove(myCartList.indexOf(removedItem));
        ShoppingCartDTO.writeFile(shoppingCartList);

        System.out.println("Sản phẩm đã được xóa khỏi giỏ hàng");
        viewMyCart();
    }

        public static double getTotal() {
            double total = 0;
            List<ShoppingCart> shoppingCartList = ShoppingCartDTO.readFile();

            for (ShoppingCart shoppingCart : shoppingCartList) {
                if (shoppingCart.getCustomerName().equalsIgnoreCase(LoginController.currentAccount)) {
                    total += shoppingCart.getTotalPrice();
                }
            }
            return total;
        }

        public static List<ShoppingCart> getMyCart() {
            List<ShoppingCart> myCartList = new ArrayList<>();
            List<ShoppingCart> cartList = ShoppingCartDTO.readFile();
            String now = LocalTime.now().toString();

            for (ShoppingCart shoppingCart1 : cartList) {
                if (shoppingCart1.getCustomerName().equals(LoginController.currentAccount)) {
                    ShoppingCart shoppingCart2 = new ShoppingCart(now, shoppingCart1.getProductName(), shoppingCart1.getProductPrice(), shoppingCart1.getProductQuantity(), shoppingCart1.getProductManufacturer(), shoppingCart1.getProductCountry(), shoppingCart1.getCustomerName());
                    myCartList.add(shoppingCart2);
                }
            }
            return myCartList;
        }

        public static void viewMyCart() {
            double total = 0;
            int count = 1;
            List<ShoppingCart> shoppingCartList = ShoppingCartDTO.readFile();

            int space = 1;
            int idWidth = 10;
            int nameWidth = 30;
            int priceWidth = 12;
            int quantityWidth = 15;
            int manufacturerWidth = 20;
            int countryWidth = 15;
            int totalPriceWidth = 12;
            int totalWidth = idWidth + nameWidth + priceWidth + quantityWidth + manufacturerWidth + countryWidth + totalPriceWidth + 6;

            System.out.printf("%" + totalWidth + "s%n", "");
            System.out.printf("%" + (-idWidth) + "s %" + (-nameWidth) + "s %" + (-priceWidth) + "s %" + (-quantityWidth) + "s %" + (-manufacturerWidth) + "s %" + (-countryWidth) + "s %" + (-totalPriceWidth) + "s%n",
                    "STT", "Tên Sản Phẩm", "Giá", "Số Lượng", "Hãng Sản Xuất", "Quốc Gia", "Tổng Tiền");
            System.out.println("-".repeat(totalWidth));

            for (ShoppingCart shoppingCart : shoppingCartList) {
                if (shoppingCart.getCustomerName().equalsIgnoreCase(LoginController.currentAccount)) {
                    shoppingCart.setTotalPrice(shoppingCart.getProductPrice() * shoppingCart.getProductQuantity());

                    System.out.printf("%" + (-idWidth) + "d %" + (-nameWidth) + "s %" + (-priceWidth) + ".2f %" + (-quantityWidth) + "d %" + (-manufacturerWidth) + "s %" + (-countryWidth) + "s %" + (-totalPriceWidth) + ".2f%n",
                            count++,
                            shoppingCart.getProductName(),
                            shoppingCart.getProductPrice(),
                            shoppingCart.getProductQuantity(),
                            shoppingCart.getProductManufacturer(),
                            shoppingCart.getProductCountry(),
                            shoppingCart.getTotalPrice());

                    total += shoppingCart.getTotalPrice();
                }
            }

            System.out.println("-".repeat(totalWidth));
            System.out.printf("%" + space + "s %" + (totalWidth - totalPriceWidth - 20) + "s %.2f%n", "Tổng tiền hóa đơn:", "", total);
            System.out.println();
        }

        private static boolean isPositiveInteger(String input) {
            try {
                int number = Integer.parseInt(input);
                return number > 0;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }