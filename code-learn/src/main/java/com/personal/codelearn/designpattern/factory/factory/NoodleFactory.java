package com.personal.codelearn.designpattern.factory.factory;

public class NoodleFactory implements FoodFactory {

    @Override
    public String makeFood(String name) {
        return "NoodleFactory make noodles...";
    }
}
