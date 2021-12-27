package com.elwood.threadpool;

import com.elwood.threadpool.async.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadPoolApplicationTests {

    @Autowired
    private Task task;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() throws Exception {

        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();

        Thread.currentThread().join();
    }
}
