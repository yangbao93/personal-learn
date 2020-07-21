package com.personal.codelearn.designpattern.factory.factory;

public class RiceFactory implements FoodFactory {

    @Override
    public String makeFood(String name) {
        return "RiceFactory make rice...";
    }
}
