package com.elwood.mapstruct.struct;

import com.elwood.mapstruct.dto.UserShowDTO;
import com.elwood.mapstruct.entity.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapStructManager {

    MapStructManager INSTANCE = Mappers.getMapper(MapStructManager.class);

    @Mapping(source = "birthday", target = "birthday", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "regDate", expression = "java(org.apache.commons.lang3.time.DateFormatUtils.format(userDO.getRegDate(),\"yyyy-MM-dd HH:mm:ss\"))")
    @Mapping(source = "userExtDO.regSource", target = "registerSource")
    @Mapping(source = "userExtDO.favorite", target = "favorite")
    @Mapping(target = "memo", ignore = true)
    UserShowDTO toUserShowDTO(UserDO userDO);

    List<UserShowDTO> toUserShowDTOs(List<UserDO> userDOs);

}
