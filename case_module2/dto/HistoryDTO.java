package case_module2.dto;

import case_module2.model.bill.Bill;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoryDTO {
    private static final File file = new File("history.csv");

    public static List<Bill> readFile() {
        List<Bill> historyList = new ArrayList<>();
        String line;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] billString = line.split(",");

                LocalDateTime timeTransaction = LocalDateTime.parse(billString[0]);
                String productName = billString[1];
                double productPrice = Double.parseDouble(billString[2]);
                int productQuantity = Integer.parseInt(billString[3]);
                String customerName = billString[4];
                double totalCost = Double.parseDouble(billString[5]);

                Bill bill = new Bill(timeTransaction, productName, productPrice, productQuantity, customerName, totalCost);
                historyList.add(bill);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return historyList;
    }

    public static void writeFile(List<Bill> historyList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Bill bill : historyList) {
                StringBuilder billString = new StringBuilder();
                billString.append(bill.getTimeTransaction()).
                        append(",").append(bill.getProductName()).
                        append(",").append(bill.getProductPrice()).
                        append(",").append(bill.getProductQuantity()).
                        append(",").append(bill.getCustomerName()).
                        append(",").append(bill.getTotalCost()).
                        append("\n");
                bufferedWriter.append(billString.toString());
            }

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
