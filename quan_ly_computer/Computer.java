package quan_ly_computer;

public class Computer {
    private Manufacturer manufacturer;
    private Date productionDate;
    private Double price;
    private Double warrantyPeriod;

    public Computer(Manufacturer manufacturer, Date productionDate, Double price, Double warrantyPeriod) {
        this.manufacturer = manufacturer;
        this.productionDate = productionDate;
        this.price = price;
        this.warrantyPeriod = warrantyPeriod;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Double warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public boolean checkLowerPrice(Computer anotherComputer) {
        return this.price < anotherComputer.price;
    }

    public String nameOfNation() {
        return this.manufacturer.nameOfNation();
    }
}
