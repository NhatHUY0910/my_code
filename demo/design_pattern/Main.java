package demo.design_pattern;

public class Main {
    public static void main(String[] args) {
        President president = President.getInstance();
        president.showMessage();
    }
}
