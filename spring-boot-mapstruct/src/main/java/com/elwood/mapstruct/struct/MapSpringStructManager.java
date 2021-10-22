package com.elwood.mapstruct.struct;

import com.elwood.mapstruct.dto.*;
import com.elwood.mapstruct.entity.UserAddressDO;
import com.elwood.mapstruct.entity.UserDO;
import com.elwood.mapstruct.entity.UserExtDO;
import com.elwood.mapstruct.entity.UserNestedDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapSpringStructManager {

    /**
     * 单个对象映射
     */
    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "regDate", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(userDO.getRegDate(),\"yyyy-MM-dd HH:mm:ss\"))")
    @Mapping(source = "userExtDO.regSource", target = "registerSource")
    @Mapping(source = "userExtDO.favorite", target = "favorite")
    @Mapping(target = "memo", ignore = true)
    UserShowDTO toUserShowDTO(UserDO userDO);
    // 已有转换方式，无需再写@Mapping
    List<UserShowDTO> toUserShowDTOs(List<UserDO> userDOs);


    /**
     * 自定义方法
     */
    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "regDate", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(userDO.getRegDate(),\"yyyy-MM-dd HH:mm:ss\"))")
    @Mapping(source = "userExtDO", target = "userExtDTO")
    @Mapping(target = "memo", ignore = true)
    UserCustomDTO toUserCustomDTO(UserDO userDO);

    default UserExtDTO toUserExtDTO(UserExtDO userExtDO) {
        UserExtDTO userExtDTO = new UserExtDTO();
        userExtDTO.setKids(userExtDO.getKids());
        userExtDTO.setFavorite(userExtDO.getFavorite());

        // 覆盖这两个值
        userExtDTO.setRegSource("默认来源");
        userExtDTO.setSchool("默认学校");

        return userExtDTO;
    }


    /**
     * 映射现有实例
     */
    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "regDate", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(userDO.getRegDate(),\"yyyy-MM-dd HH:mm:ss\"))")
    @Mapping(source = "userExtDO.regSource", target = "registerSource")
    @Mapping(source = "userExtDO.favorite", target = "favorite")
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "memo", ignore = true)
    void toUserShowDTO(@MappingTarget UserShowDTO userShowDTO, UserDO userDO);


    /**
     * 多参数映射
     */
    @Mapping(source = "userDO.birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "userDO.regDate", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(userDO.getRegDate(),\"yyyy-MM-dd HH:mm:ss\"))")
    @Mapping(source = "userAddressDO.postcode", target = "postcode")
    @Mapping(source = "userAddressDO.address", target = "address")
    @Mapping(target = "memo", ignore = true)
    UserMultiDTO toUserMultiDTO(UserDO userDO, UserAddressDO userAddressDO);


    /**
     * 嵌套映射
     */
    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "regDate", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(userNestedDO.getRegDate(),\"yyyy-MM-dd HH:mm:ss\"))")
    @Mapping(source = "userAddressDO", target = ".")
    @Mapping(source = "userExtDO", target = ".")
    @Mapping(source = "userExtDO.memo", target = "memo")
    UserNestedDTO toUserNestedDTO(UserNestedDO userNestedDO);
}
