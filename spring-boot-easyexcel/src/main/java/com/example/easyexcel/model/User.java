package com.example.easyexcel.model;

import java.util.Date;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/12/9
 * @Version: 1.0
 */
public class User {

    private String uid;
    private String name;
    private Integer age;
    private Date birthday;

    public User() {
    }

    public User(String uid, String name, Integer age, Date birthday) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
