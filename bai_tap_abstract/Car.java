package bai_tap_abstract;

public class Car extends TransportationVehicles{
    private String fuel;

    public Car(Manufacturer manufacturer, String fuel) {
        super("Xe Ô Tô", manufacturer);
        this.fuel = fuel;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    @Override
    public double speedOfVehicles() {
        return 80.5;
    }
}
