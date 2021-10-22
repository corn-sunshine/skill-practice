package com.elwood.mapstruct;

import com.elwood.mapstruct.dto.UserShowDTO;
import com.elwood.mapstruct.entity.UserDO;
import com.elwood.mapstruct.entity.UserExtDO;
import com.elwood.mapstruct.struct.MapStructManager;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapStructManagerTest {

    @Test
    public void test1() {
        UserExtDO userExtDO = new UserExtDO();
        userExtDO.setRegSource("公众号：Java技术栈");
        userExtDO.setFavorite("写代码");
        userExtDO.setSchool("社会大学");

        UserDO userDO = new UserDO();
        userDO.setName("栈长");
        userDO.setSex(1);
        userDO.setAge(18);
        userDO.setBirthday(new Date());
        userDO.setPhone("18888888888");
        userDO.setMarried(true);
        userDO.setRegDate(new Date());
        userDO.setMemo("666");
        userDO.setUserExtDO(userExtDO);

        UserShowDTO userShowDTO = MapStructManager.INSTANCE.toUserShowDTO(userDO);
        System.out.println("=====单个对象映射=====");
        System.out.println(userShowDTO);

        List<UserDO> userDOs = new ArrayList<>();
        UserDO userDO2 = new UserDO();
        BeanUtils.copyProperties(userDO, userDO2);
        userDO2.setName("栈长2");
        userDOs.add(userDO);
        userDOs.add(userDO2);
        List<UserShowDTO> userShowDTOs = MapStructManager.INSTANCE.toUserShowDTOs(userDOs);
        System.out.println("=====对象列表映射=====");
        userShowDTOs.forEach(System.out::println);
    }
}