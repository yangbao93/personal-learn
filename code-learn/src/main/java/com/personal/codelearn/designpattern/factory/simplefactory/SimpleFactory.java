package com.personal.codelearn.designpattern.factory.simplefactory;

public class SimpleFactory {

    public static String makeFood(String name) {
        if (name.equals("noodle")) {
            return "make noodles...";
        } else if (name.equals("rice")) {
            return "make rice...";
        } else {
            return "i can't do it";
        }
    }
}
