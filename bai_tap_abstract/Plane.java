package bai_tap_abstract;

public class Plane extends TransportationVehicles {
    private String fuel;

    public Plane(Manufacturer manufacturer, String fuel) {
        super("Máy Bay", manufacturer);
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
        return 450.6;
    }
    public void aircraftTakeoff() {
        System.out.println("Bay lên nào!");
    }
    public void aircraftLanding() {
        System.out.println("Hạ cánh thôi!");
    }
}
