package com.elwood.scheduled;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

//@SpringBootTest
class ScheduledApplicationTests {

    @Test
    void contextLoads() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int hour = now.getHour();
        System.out.println(hour);
        LocalDateTime localDateTime = now.plusDays(-2);
        System.out.println(localDateTime);
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek);
        int value = dayOfWeek.getValue();
        System.out.println(value);
    }

}
