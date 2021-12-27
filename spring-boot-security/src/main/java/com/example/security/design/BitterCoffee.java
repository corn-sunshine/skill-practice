package com.example.security.design;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/12/1
 * @Version: 1.0
 */
public class BitterCoffee implements Coffee{

    @Override
    public void printMaterial() {
        System.out.println("咖啡");
    }
}
