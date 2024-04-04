package case_module2.model.product;

import case_module2.model.enum_product.Fragrance;

public class Shampoo extends Product{
    private Fragrance fragranceType;


    public Shampoo(String name, double price, int quantity, String manufacturer, String country, Fragrance fragranceType) {
        super(name, price, quantity, manufacturer, country);
        this.fragranceType = fragranceType;
    }

    public Fragrance getFragranceType() {
        return fragranceType;
    }

    public void setFragranceType(Fragrance fragranceType) {
        this.fragranceType = fragranceType;
    }
}
