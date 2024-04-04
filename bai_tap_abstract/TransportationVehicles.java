package bai_tap_abstract;

public abstract class TransportationVehicles {
        protected String nameOfVehicle;
        protected Manufacturer manufacturer;

        public TransportationVehicles(String nameOfVehicle, Manufacturer manufacturer) {
        this.nameOfVehicle = nameOfVehicle;
        this.manufacturer = manufacturer;
    }

    public String getNameOfVehicle() {
        return nameOfVehicle;
    }

    public void setNameOfVehicle(String nameOfVehicle) {
        this.nameOfVehicle = nameOfVehicle;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String nameOfProducer() {
            return this.manufacturer.getProducerName();
    }
    public void startIgnite() {
            System.out.println("Khởi động động cơ .brr.brr.brr.!");
    }
    public void speedUp() {
            System.out.println("Bắt đầu tăng tốc BRRRRRR!!!");
    }
    public void stop() {
            System.out.println("Dừng ngay còn kịp Krrrrr!!!!");
    }

    public abstract double speedOfVehicles();
}
