package com.zzx.controller;

import com.zzx.entity.User;
import com.zzx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
* 供应者提供数据
* 让消费者消费数据
* */
@RestController
@RequestMapping("/user")
@EnableDiscoveryClient
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id){
        User user=userService.selectByPrimaryKey(id);
        return user;
    }
}
