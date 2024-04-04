package bai_tap_abstract;

public class Manufacturer {
    private String producerName, nationName;

    public Manufacturer(String producerName, String nationName) {
        this.producerName = producerName;
        this.nationName = nationName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }
}
