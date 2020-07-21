package com.personal.codelearn.designpattern.factory.factory;

public class Restaurant {

    private FoodFactory getFoodFactory(String name) {
        if (name.equals("A")) {
            return new NoodleFactory();
        } else if (name.equals("B")) {
            return new RiceFactory();
        }
        return null;
    }

    public void order(String name) {
        FoodFactory factory = this.getFoodFactory(name);
        factory.makeFood(name);
    }
}
