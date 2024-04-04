package case_module2.service;

import case_module2.dto.HistoryDTO;
import case_module2.model.bill.Bill;

import java.util.List;
import java.util.stream.Collectors;

public class HistoryService {
    private static List<Bill> historyList = HistoryDTO.readFile();

    public HistoryService() {
        this.historyList = HistoryDTO.readFile();
    }

    public static void showAllHistory() {
        for (Bill bill : historyList) {
            System.out.println("Thời gian giao dịch: " + bill.getTimeTransaction());
            System.out.println("Tên sản phẩm: " + bill.getProductName());
            System.out.println("Giá tiền: " + bill.getProductPrice());
            System.out.println("Số lượng sản phẩm: " + bill.getProductQuantity());
            System.out.println("Tên khách hàng: " + bill.getCustomerName());
            System.out.println("Tổng tiền: " + bill.getTotalCost());
            System.out.println("------------------------");
        }
    }

    public void filterByProductName(String productName) {
        List<Bill> filteredList = historyList.stream().filter(bill -> bill.getProductName().equalsIgnoreCase(productName)).collect(Collectors.toList());

        for (Bill bill : filteredList) {
            System.out.println("Thời gian giao dịch: " + bill.getTimeTransaction());
            System.out.println("Tên sản phẩm: " + bill.getProductName());
            System.out.println("Giá tiền: " + bill.getProductPrice());
            System.out.println("Số lượng sản phẩm: " + bill.getProductQuantity());
            System.out.println("Tên khách hàng: " + bill.getCustomerName());
            System.out.println("Tổng tiền: " + bill.getTotalCost());
            System.out.println("------------------------");
        }
    }

    public void showTurnover() {
        double totalTurnover = historyList.stream().mapToDouble(Bill::getTotalCost).sum();

        System.out.println("Tổng doanh thu: " + totalTurnover);
    }

}

