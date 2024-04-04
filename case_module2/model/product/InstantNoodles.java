package case_module2.model.product;

import case_module2.model.enum_product.Level;

public class InstantNoodles extends Product {
    private Level spicy;

    public InstantNoodles(String name, double price, int quantity, String manufacturer, String country, Level spicy) {
        super(name, price, quantity, manufacturer, country);
        this.spicy = spicy;
    }

    public Level getSpicy() {
        return spicy;
    }

    public void setSpicy(Level spicy) {
        this.spicy = spicy;
    }
}
