package case_module2.service;

import case_module2.dto.HistoryDTO;
import case_module2.dto.ProductDTO;
import case_module2.model.bill.Bill;
import case_module2.model.product.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    Scanner scanner = new Scanner(System.in);
    List<Product> productList = ProductDTO.readFile();
    private ProductDTO productDTO;

    public AdminService() {
    }

    public AdminService(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public void createNewProduct() {
        System.out.println("=====Tạo Sản Phẩm Mới=====");
        System.out.println("Nhập tên sản phẩm:");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm:");
        double price = scanner.nextDouble();
        System.out.println("Nhập số lượng sản phẩm:");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập hãng sản xuất:");
        String manufacturer = scanner.nextLine();
        System.out.println("Nhập quốc gia sản xuất:");
        String country = scanner.nextLine();
        System.out.println("Nhập đặc điểm sản phẩm:");
        String otherElement = scanner.nextLine();

        Product newProduct = new Product(name, price, quantity, manufacturer, country, otherElement);
        productList.add(newProduct);
        ProductDTO.writeFile(productList);

        System.out.println("Đã tạo sản phẩm mới thành công!");
    }

    public void editProduct() {
        ProductService productService = new ProductService();
        productService.showAllProduct();

        System.out.println("Nhập tên sản phẩm bạn muốn chỉnh sửa:");
        String editByName = scanner.nextLine();
        boolean isMatch = false;

        for (Product product : productList) {
            if (editByName.equalsIgnoreCase(product.getName())) {
                isMatch = true;
                System.out.println("Lựa chọn thông tin của sản phẩm mà bạn muốn thay đổi: ");
                System.out.println("1. Tên sản phầm");
                System.out.println("2. Giá sản phầm");
                System.out.println("3. Số lượng sản phầm");
                System.out.println("4. Hãng sản xuất");
                System.out.println("5. Xuất xứ");
                String choiceString = scanner.nextLine();

                try {
                    int choice = Integer.parseInt(choiceString);
                    switch (choice) {
                        case 1:
                            System.out.println("Nhập tên mới cho sản phẩm:");
                            String newName = scanner.nextLine();
                            product.setName(newName);
                            ProductDTO.writeFile(productList);
                            System.out.println("Tên sản phẩm đã được thay đổi");
                            break;
                        case 2:
                            System.out.println("Nhập đơn giá mới cho sản phẩm:");
                            double newPrice = scanner.nextDouble();
                            product.setPrice(newPrice);
                            ProductDTO.writeFile(productList);
                            System.out.println("Đã cập nhật giá mới cho sản phẩm");
                            break;
                        case 3:
                            System.out.println("Nhập số lượng mới của sản phẩm:");
                            int newQuantity = scanner.nextInt();
                            product.setQuantity(newQuantity);
                            ProductDTO.writeFile(productList);
                            System.out.println("Đã cập nhật số lượng mới cho sản phẩm");
                            break;
                        case 4:
                            System.out.println("Nhập hãng sản xuất mới của sản phẩm:");
                            String newManufacturer = scanner.nextLine();
                            product.setManufacturer(newManufacturer);
                            ProductDTO.writeFile(productList);
                            System.out.println("Sản phẩm đã được thay đổi hãng sản xuất");
                            break;
                        case 5:
                            System.out.println("Nhập quốc gia xuất xứ mới của sản phẩm:");
                            String newCountry = scanner.nextLine();
                            product.setCountry(newCountry);
                            ProductDTO.writeFile(productList);
                            System.out.println("Quốc gia xuất xứ của sản phẩm đã được thay đổi");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ! Hãy chọn lại");
                            break;
                    }
                }catch (NumberFormatException e) {
                    System.out.println("Lựa chọn không hợp lệ! Hãy chọn lại");
                }
            }
        }
        if (!isMatch) {
            System.out.println("Không tìm thấy sản phẩm " + editByName);
        }
    }

    public void deleteProduct() {
        System.out.println("Nhập tên sản phẩm bạn muốn xóa:");
        String productName = scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (product.getName().equalsIgnoreCase(productName)) {
                productList.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            ProductDTO.writeFile(productList);
            System.out.println("Sản phẩm đã được xóa thành công");
        } else {
            System.out.println("Không tìm thấy sản phẩm có tên: " + productName);
        }
    }

    public void showTurnover() {
        List<Bill> billList = HistoryDTO.readFile();
        double totalTurnover = 0;

        for (Bill bill : billList) {
            totalTurnover += bill.getTotalCost();
        }
        System.out.println("Tổng doanh thu là: " + totalTurnover);
    }
}
