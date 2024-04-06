package case_module2.service;

import case_module2.read_write_file.ProductDTO;
import case_module2.model.product.Product;
import case_module2.model.shopping_cart.ShoppingCart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private ProductDTO productDTO;

    public ProductService() {
    }

    public ProductService(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }


    public List<Product> searchProductByName(String productName) {
        List<Product> productList = ProductDTO.readFile();
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(productName)) {
                matchingProducts.add(product);
            }
        }

        if (matchingProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm phù hợp");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (Product product : matchingProducts) {
                System.out.println("Tên Sản Phẩm: " + product.getName());
                System.out.println("Giá: " + product.getPrice());
                System.out.println("Số Lượng: " + product.getQuantity());
                System.out.println("Hãng Sản Xuất: " + product.getManufacturer());
                System.out.println("Sản Xuất Tại: " + product.getCountry());
                System.out.println("Đặc Điểm: " + product.getOtherElement());
                System.out.println("-------------------------------");
                System.out.println();
            }
        }
        return matchingProducts;
    }

    public List<Product> showAllProduct() {
        List<Product> productList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("product_list.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productListData = line.split(",");

                if (productListData.length >= 5) {
                    String name = productListData[0];
                    double price = Double.parseDouble(productListData[1]);
                    int quantity = Integer.parseInt(productListData[2]);
                    String manufacturer = productListData[3];
                    String country = productListData[4];

                    String otherElement = "";
                    if (productListData.length > 5) {
                         otherElement = productListData[5];
                    }

                    Product product = new Product(name, price, quantity, manufacturer, country, otherElement);

                    productList.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống");
            System.out.println();
        } else {
            System.out.println("Danh sách sản phẩm:");
            System.out.println("---------------------------------------");
            for (Product product : productList) {
                System.out.println("Tên sản phẩm: " + product.getName());
                System.out.println("Giá: " + product.getPrice());
                System.out.println("Số lượng: " + product.getQuantity());
                System.out.println("Hãng sản xuất: " + product.getManufacturer());
                System.out.println("Quốc gia: " + product.getCountry());
                System.out.println("Đặc Điểm: " + product.getOtherElement());
                System.out.println("---------------------------------------");
                System.out.println();
            }
        }
        return productList;
    }

    public void changeWhenBuy(List<ShoppingCart> shoppingCartList) {
        List<Product> productList = ProductDTO.readFile();

        for (ShoppingCart shoppingCart : shoppingCartList) {
            for (Product product : productList) {
                if (shoppingCart.getProductName().equals(product.getName())) {
                    product.setQuantity(product.getQuantity() - shoppingCart.getProductQuantity());
                }
            }
        }
        ProductDTO.writeFile(productList);
    }
}
