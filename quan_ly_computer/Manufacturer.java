package quan_ly_computer;

public class Manufacturer {
    private String producerName;
    private Nation nation;

    public Manufacturer(String producerName, Nation nation) {
        this.producerName = producerName;
        this.nation = nation;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public String nameOfNation() {
        return this.nation.getNationName();
    }
}
