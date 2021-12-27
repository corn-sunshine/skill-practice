package com.example.security.design.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/12/1
 * @Version: 1.0
 */
public class MoneyCountInvocationHandler implements InvocationHandler {

    /**
     * 被代理的目标
     */
    private final Object target;

    /**
     * 内部存储钱的总数
     */
    private Double moneyCount;

    public MoneyCountInvocationHandler(Object target) {
        this.target = target;
        this.moneyCount = 0.0;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        moneyCount += 0.07;
        System.out.println("发送短信成功，共花了：" + moneyCount + "元");
        return result;
    }
}
