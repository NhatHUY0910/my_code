package case_module2.model.product;

import case_module2.model.enum_product.Fabric;

public class Clothes extends Product{
    private Fabric fabricType;

    public Clothes(String name, double price, int quantity, String manufacturer, String country, Fabric fabricType) {
        super(name, price, quantity, manufacturer, country);
        this.fabricType = fabricType;
    }

    public Fabric getFabricType() {
        return fabricType;
    }

    public void setFabricType(Fabric fabricType) {
        this.fabricType = fabricType;
    }
}
