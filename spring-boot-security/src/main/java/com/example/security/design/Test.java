package com.example.security.design;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/12/1
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Coffee coffee = new BitterCoffee();
        SugarDecorator sugarDecorator = new SugarDecorator(coffee);
        sugarDecorator.printMaterial();
        coffee.printMaterial();
    }
}
