package case_module2.model.product;

public class Book extends Product{
    private String paperAmount;

    public Book(String name, double price, int quantity, String manufacturer, String country, String paperAmount) {
        super(name, price, quantity, manufacturer, country);
        this.paperAmount = paperAmount;
    }

    public String getPaperAmount() {
        return paperAmount;
    }

    public void setPaperAmount(String paperAmount) {
        this.paperAmount = paperAmount;
    }
}
