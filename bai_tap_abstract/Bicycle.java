package bai_tap_abstract;

public class Bicycle extends TransportationVehicles{

    public Bicycle(Manufacturer manufacturer) {
        super("Xe Đạp", manufacturer);
    }

    @Override
    public double speedOfVehicles() {
        return 20.5;
    }
}
