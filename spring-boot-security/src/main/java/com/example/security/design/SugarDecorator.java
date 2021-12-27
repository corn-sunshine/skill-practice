package com.example.security.design;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/12/1
 * @Version: 1.0
 */
public class SugarDecorator implements Coffee {

    /**
     * 持有的咖啡对象
     */
    private final Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void printMaterial() {
        System.out.println("糖");
        this.coffee.printMaterial();
    }
}
