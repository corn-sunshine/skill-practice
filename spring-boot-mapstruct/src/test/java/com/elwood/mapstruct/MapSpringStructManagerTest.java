package com.elwood.mapstruct;

import com.elwood.mapstruct.dto.UserCustomDTO;
import com.elwood.mapstruct.dto.UserMultiDTO;
import com.elwood.mapstruct.dto.UserNestedDTO;
import com.elwood.mapstruct.dto.UserShowDTO;
import com.elwood.mapstruct.entity.UserAddressDO;
import com.elwood.mapstruct.entity.UserDO;
import com.elwood.mapstruct.entity.UserExtDO;
import com.elwood.mapstruct.entity.UserNestedDO;
import com.elwood.mapstruct.struct.MapSpringStructManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapSpringStructManagerTest {

    @Autowired
    private MapSpringStructManager mapSpringStructManager;

    @Test
    public void test1() {
        UserExtDO userExtDO = new UserExtDO();
        userExtDO.setRegSource("Java技术栈");
        userExtDO.setFavorite("写代码");
        userExtDO.setSchool("社会大学");

        UserDO userDO = new UserDO();
        userDO.setName("Spring");
        userDO.setSex(1);
        userDO.setAge(18);
        userDO.setBirthday(new Date());
        userDO.setPhone("18888888888");
        userDO.setMarried(true);
        userDO.setRegDate(new Date());
        userDO.setMemo("666");
        userDO.setUserExtDO(userExtDO);

        UserShowDTO userShowDTO = mapSpringStructManager.toUserShowDTO(userDO);
        System.out.println("=====单个对象映射=====");
        System.out.println(userShowDTO);

        List<UserDO> userDOs = new ArrayList<>();
        UserDO userDO2 = new UserDO();
        BeanUtils.copyProperties(userDO, userDO2);
        userDO2.setName("Spring2");
        userDOs.add(userDO);
        userDOs.add(userDO2);
        List<UserShowDTO> userShowDTOs = mapSpringStructManager.toUserShowDTOs(userDOs);
        System.out.println("=====对象列表映射=====");
        userShowDTOs.forEach(System.out::println);
    }

    @Test
    public void test2() {
        UserExtDO userExtDO = new UserExtDO();
        userExtDO.setRegSource("Java技术栈");
        userExtDO.setFavorite("写代码");
        userExtDO.setSchool("社会大学");
        userExtDO.setKids(1);

        UserDO userDO = new UserDO();
        userDO.setName("自定义方法");
        userDO.setSex(1);
        userDO.setAge(18);
        userDO.setBirthday(new Date());
        userDO.setPhone("18888888888");
        userDO.setMarried(true);
        userDO.setRegDate(new Date());
        userDO.setMemo("666");
        userDO.setUserExtDO(userExtDO);

        UserCustomDTO userCustomDTO = mapSpringStructManager.toUserCustomDTO(userDO);
        System.out.println("=====自定义方法=====");
        System.out.println(userCustomDTO);
    }

    @Test
    public void test3() {
        UserExtDO userExtDO = new UserExtDO();
        userExtDO.setRegSource("Java技术栈");
        userExtDO.setFavorite("写代码");
        userExtDO.setSchool("社会大学");

        UserDO userDO = new UserDO();
        userDO.setName("corn");
        userDO.setSex(1);
        userDO.setAge(18);
        userDO.setBirthday(new Date());
        userDO.setPhone("18888888888");
        userDO.setMarried(true);
        userDO.setRegDate(new Date());
        userDO.setMemo("666");
        userDO.setUserExtDO(userExtDO);

        System.out.println("=====映射现有实例前=====");
        UserShowDTO userShowDTO = new UserShowDTO();
        userShowDTO.setName("cornNAME");
        userShowDTO.setMemo("cornMEMO");
        System.out.println(userShowDTO);

        System.out.println("=====映射现有实例后=====");
        mapSpringStructManager.toUserShowDTO(userShowDTO, userDO);
        System.out.println(userShowDTO);
    }

    @Test
    public void test4() {
        UserDO userDO = new UserDO();
        userDO.setName("多参数映射");
        userDO.setSex(1);
        userDO.setAge(18);
        userDO.setBirthday(new Date());
        userDO.setPhone("18888888888");
        userDO.setMarried(true);
        userDO.setRegDate(new Date());
        userDO.setMemo("666");

        UserAddressDO userAddressDO = new UserAddressDO();
        userAddressDO.setProvince("四川省");
        userAddressDO.setCity("成都市");
        userAddressDO.setPostcode("666666");
        userAddressDO.setAddress("001号成华大道");
        userAddressDO.setMemo("地址信息");

        UserMultiDTO userMultiDTO = mapSpringStructManager.toUserMultiDTO(userDO, userAddressDO);
        System.out.println("=====多参数映射=====");
        System.out.println(userMultiDTO);
    }

    @Test
    public void test5() {
        UserExtDO userExtDO = new UserExtDO();
        userExtDO.setRegSource("Java技术栈");
        userExtDO.setFavorite("写代码");
        userExtDO.setSchool("社会大学");
        userExtDO.setKids(1);
        userExtDO.setMemo("扩展信息");

        UserAddressDO userAddressDO = new UserAddressDO();
        userAddressDO.setProvince("四川省");
        userAddressDO.setCity("成都市");
        userAddressDO.setPostcode("666666");
        userAddressDO.setAddress("001号成华大道");
        userAddressDO.setMemo("地址信息");

        UserNestedDO userNestedDO = new UserNestedDO();
        userNestedDO.setName("嵌套映射");
        userNestedDO.setSex(1);
        userNestedDO.setAge(18);
        userNestedDO.setBirthday(new Date());
        userNestedDO.setPhone("18888888888");
        userNestedDO.setMarried(true);
        userNestedDO.setRegDate(new Date());
        userNestedDO.setMemo("666");
        userNestedDO.setUserExtDO(userExtDO);
        userNestedDO.setUserAddressDO(userAddressDO);

        UserNestedDTO userNestedDTO = mapSpringStructManager.toUserNestedDTO(userNestedDO);
        System.out.println("=====嵌套映射=====");
        System.out.println(userNestedDTO);
    }
}