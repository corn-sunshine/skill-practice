package com.elwood.scheduled;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/10/22
 * @Version: 1.0
 */
@Component
public class DemoTask {

    public void taskWithParams(String params) {
        System.out.println("执行有参示例任务：" + params);
    }

    public void taskNoParams() {
        System.out.println("执行无参示例任务");
    }
}
