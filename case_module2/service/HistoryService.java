package case_module2.service;

import case_module2.read_write_file.HistoryDTO;
import case_module2.model.bill.Bill;

import java.util.List;
import java.util.stream.Collectors;

public class HistoryService {
    private static HistoryService instance;
    private static List<Bill> historyList;

    public HistoryService() {
        historyList = HistoryDTO.readFile();
    }

    public static HistoryService getInstance() {
        if (instance == null) {
            instance = new HistoryService();
        }
        return instance;
    }

    public void showAllHistory() {
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

