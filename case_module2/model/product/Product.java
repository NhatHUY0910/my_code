package case_module2.model.product;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private String manufacturer;
    private String country;
    private String otherElement;

    public Product(String name, double price, int quantity, String manufacturer, String country, String otherElement) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
        this.country = country;
        this.otherElement = otherElement;
    }

    public Product(String name, double price, int quantity, String manufacturer, String country) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOtherElement() {
        return otherElement;
    }

    public void setOtherElement(String otherElement) {
        this.otherElement = otherElement;
    }
}
