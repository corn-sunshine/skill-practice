package com.elwood.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/11/11
 * @Version: 1.0
 */
@Api(tags = {"Swagger测试接口"})
@RestController
@RequestMapping("/test")
public class SwaggerTestController {

    @ApiOperation("swagger测试控制器")
    @RequestMapping(value = "/swagger",method = RequestMethod.GET)
    public String dyTest(@RequestParam(name = "version") Integer version){
        return "Swagger Test " + version;
    }
}
