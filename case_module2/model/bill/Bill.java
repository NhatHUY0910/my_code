package case_module2.model.bill;

import case_module2.model.shopping_cart.ShoppingCart;

import java.time.LocalDateTime;
import java.util.List;

public class Bill {
    private LocalDateTime timeTransaction;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String customerName;
    private double totalCost;
    List<ShoppingCart> boughtList;

    public Bill(LocalDateTime timeTransaction, String customerName, List<ShoppingCart> boughtList) {
        this.timeTransaction = timeTransaction;
        this.customerName = customerName;
        this.boughtList = boughtList;
    }

    public Bill(LocalDateTime timeTransaction, String productName, double productPrice, int productQuantity, String customerName, double totalCost) {
        this.timeTransaction = timeTransaction;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.customerName = customerName;
        this.totalCost = totalCost;
    }

    public LocalDateTime getTimeTransaction() {
        return timeTransaction;
    }

    public void setTimeTransaction(LocalDateTime timeTransaction) {
        this.timeTransaction = timeTransaction;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double calculateTotalCost() {
        return productPrice * productQuantity;
    }
}
