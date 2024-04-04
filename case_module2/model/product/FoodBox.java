package case_module2.model.product;

import case_module2.model.enum_product.Size;

public class FoodBox extends Product {
    private Size sizeBox;


    public FoodBox(String name, double price, int quantity, String manufacturer, String country, Size sizeBox) {
        super(name, price, quantity, manufacturer, country);
        this.sizeBox = sizeBox;
    }

    public Size getSizeBox() {
        return sizeBox;
    }

    public void setSizeBox(Size sizeBox) {
        this.sizeBox = sizeBox;
    }
}
