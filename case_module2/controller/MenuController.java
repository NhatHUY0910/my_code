package case_module2.controller;

import case_module2.view.MenuStrategy;

public class MenuController {
    private MenuStrategy strategy;

    public void setStrategy(MenuStrategy strategy) {
        this.strategy = strategy;
    }

    public void displayMenu() throws InterruptedException {
        strategy.execute();
    }
}
