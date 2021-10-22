package com.elwood.mapstruct.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserNestedDO {

    private String name;

    private int sex;

    private int age;

    private Date birthday;

    private String phone;

    private boolean married;

    private Date regDate;

    private Date loginDate;

    private String memo;

    private UserExtDO userExtDO;

    private UserAddressDO userAddressDO;
    
}
