package case_module2.model.Code;

public class Code {
    private String code;
    private double cost;
    private boolean available;

    public Code(String code, double cost, boolean available) {
        this.code = code;
        this.cost = cost;
        this.available = available;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
