package bai_tap_abstract;

public class DemoVehicle {
    public static void main(String[] args) {
        Manufacturer manufacturer1 = new Manufacturer("Honda", "Japan");
        Manufacturer manufacturer2 = new Manufacturer("Huawei", "China");
        Manufacturer manufacturer3 = new Manufacturer("Pepsi", "America");

        TransportationVehicles vehicles1 = new Bicycle(manufacturer1);
        Plane vehicles2 = new Plane(manufacturer2, "Năng lượng của gió");
        TransportationVehicles vehicles3 = new Car(manufacturer3, "Năng lượng mặt trời");

        System.out.println("Hãng sản xuất của: ");
        System.out.println("Xe đạp: " + vehicles1.nameOfProducer());
        System.out.println("Máy bay: " + vehicles2.nameOfProducer());
        System.out.println("Xe ô-tô: " + vehicles3.nameOfProducer());

        System.out.println("Khi bắt đầu: ");
        vehicles1.startIgnite();
        vehicles2.startIgnite();
        vehicles3.startIgnite();

        System.out.println("Bắt đầu tăng tốc: ");
        vehicles1.speedUp();
        vehicles2.speedUp();
        vehicles3.speedUp();

        System.out.println("Khí tới nơi: ");
        vehicles1.stop();
        vehicles2.stop();
        vehicles3.stop();

        System.out.println("Vận tốc đo được của từng phương tiện là: ");
        System.out.println("Xe đạp: " + vehicles1.speedOfVehicles());
        System.out.println("Máy bay: " + vehicles2.speedOfVehicles());
        System.out.println("Xe ô-tô: " + vehicles3.speedOfVehicles());

        System.out.println("Máy bay khi bắt đầu và kết thúc chuyến bay: ");
        vehicles2.aircraftTakeoff();
        vehicles2.aircraftLanding();
    }
}
