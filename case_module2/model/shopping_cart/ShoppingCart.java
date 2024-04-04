package case_module2.model.shopping_cart;

public class ShoppingCart {

    private String now;
    private String productName;
    private double productPrice;
    private int productQuantity;
    private double totalPrice;
    private String productManufacturer;
    private String productCountry;
    private String customerName;

    public ShoppingCart() {
    }

    public ShoppingCart(String now, String productName, double productPrice, int productQuantity, String productManufacturer, String productCountry, String customerName) {
        this.now = now;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.totalPrice = this.productPrice * this.productQuantity ;
        this.productManufacturer = productManufacturer;
        this.productCountry = productCountry;
        this.customerName = customerName;
    }

    public ShoppingCart(String productName, double productPrice, int productQuantity, String productManufacturer, String productCountry, String customerName) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.totalPrice = this.productQuantity * this.productPrice;
        this.productManufacturer = productManufacturer;
        this.productCountry = productCountry;
        this.customerName = customerName;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductCountry() {
        return productCountry;
    }

    public void setProductCountry(String productCountry) {
        this.productCountry = productCountry;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
