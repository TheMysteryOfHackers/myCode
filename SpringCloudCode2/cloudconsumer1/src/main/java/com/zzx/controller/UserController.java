package com.zzx.controller;

import com.zzx.config.RestTemplateConfig;
import com.zzx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/*
* 消费者消费数据
* 将另一个模块获取来的数据传递到页面上
* */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    //远程调用修改 DiscoveryClient 来发现服务
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/get")
    public Object get(){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("cloudprvide1");
        String url="http://"+serviceInstanceList.get(0).getHost()+":"+serviceInstanceList.get(0).getPort();
        String uri="/user/get/1";
        User user = restTemplate.getForObject(url+uri, User.class);
        return user;
    }
}
