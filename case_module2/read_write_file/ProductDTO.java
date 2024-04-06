package case_module2.read_write_file;

import case_module2.model.product.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private static File file = new File("product_list.csv");

    public static List<Product> readFile() {
        List<Product> productList = new ArrayList<>();
        String line;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] productString = line.split(",");
                String name = productString[0];
                double price = Double.parseDouble(productString[1]);
                int quantity = Integer.parseInt(productString[2]);
                String manufactuner = productString[3];
                String country = productString[4];
                String otherElement = productString[5];

                Product product = new Product(name, price, quantity, manufactuner, country, otherElement);
                productList.add(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    public static void writeFile(List<Product> productList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Product product : productList) {
                bufferedWriter.write(product.getName() + "," +
                        product.getPrice() + "," +
                        product.getQuantity() + "," +
                        product.getManufacturer() + "," +
                        product.getCountry() + "," +
                        product.getOtherElement());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
