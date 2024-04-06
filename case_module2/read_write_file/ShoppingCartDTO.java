package case_module2.read_write_file;

import case_module2.model.shopping_cart.ShoppingCart;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDTO {
    private static final String FILE_PATH = "shopping_cart.csv";

    public static  List<ShoppingCart> readFile() {
        List<ShoppingCart> shoppingCartList = new ArrayList<>();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {

            while ((line = bufferedReader.readLine()) != null) {
                String[] productString = line.split(",");

                if (productString.length < 6) {
                    continue;
                }

                String productName = productString[0];
                double productPrice = Double.parseDouble(productString[1]);
                int productQuantity = Integer.parseInt(productString[2]);
                String productManufactuner = productString[3];
                String productCountry = productString[4];
                String customerName = productString[5];

                ShoppingCart shoppingCart = new ShoppingCart(productName, productPrice, productQuantity, productManufactuner, productCountry, customerName);
                shoppingCartList.add(shoppingCart);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Không tìm thấy file: " + FILE_PATH, e);
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi đọc dữ liệu file: " + FILE_PATH,e);
        }
        return shoppingCartList;
    }

    public static void writeFile(List<ShoppingCart> shoppingCartList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bufferedWriter.write("");

            for (ShoppingCart shoppingCart : shoppingCartList) {
                String productString = shoppingCart.getProductName() + ","
                        + shoppingCart.getProductPrice() + ","
                        + shoppingCart.getProductQuantity() + ","
                        + shoppingCart.getProductManufacturer() + ","
                        + shoppingCart.getProductCountry() + ","
                        + shoppingCart.getCustomerName() + "\n";
                bufferedWriter.write(productString);
            }
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi ghi dữ liệu vào file: " + FILE_PATH, e);
        }
    }
}
