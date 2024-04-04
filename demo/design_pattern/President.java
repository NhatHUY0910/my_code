package demo.design_pattern;

public class President {
    private String name;
    private static President instance;

    private President() {}

    public President(String name) {
        this.name = name;
    }

    public static President getInstance() {
        if (instance == null) {
            synchronized ((President.class)) {
                if (instance == null)
                    instance = new President();
            }

        }
        return instance;
    }
    public void showMessage() {
        System.out.println("Chào các đồng chí");
    }


}
