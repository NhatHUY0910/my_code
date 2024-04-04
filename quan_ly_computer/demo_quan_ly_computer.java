package quan_ly_computer;

public class demo_quan_ly_computer {
    public static void main(String[] args) {
        Date date1 = new Date(7, 3, 2024);
        Date date2 = new Date(19, 2, 2023);
        Date date3 = new Date(9, 3, 2025);

        Nation nation1 = new Nation("AMC", "America");
        Nation nation2 = new Nation("CN", "China");
        Nation nation3 = new Nation("IDA", "India");

        Manufacturer manufacturer1 = new Manufacturer("Dell", nation1);
        Manufacturer manufacturer2 = new Manufacturer("Lenovo", nation2);
        Manufacturer manufacturer3 = new Manufacturer("HP", nation3);

        Computer computer1 = new Computer(manufacturer1, date1, 10.500, 9.5);
        Computer computer2 = new Computer(manufacturer2, date2, 20.500, 7.5);
        Computer computer3 = new Computer(manufacturer3, date3, 15.500, 5.5);

        System.out.println("So sánh giá máy nào rẻ hơn: ");
        System.out.println("Máy Dell có rẻ hơn máy Lenovo: " + computer1.checkLowerPrice(computer2));
        System.out.println("Máy Lenovo có rẻ hơn máy HP: " + computer2.checkLowerPrice(computer3));
        System.out.println();
        System.out.println("Sản xuất tại: ");
        System.out.println("Máy Dell sản xuất tại: " + computer1.nameOfNation());
        System.out.println("Máy Lenovo sản xuất tại: " + computer2.nameOfNation());
        System.out.println("Máy HP sản xuất tại: " + computer3.nameOfNation());
    }
}
