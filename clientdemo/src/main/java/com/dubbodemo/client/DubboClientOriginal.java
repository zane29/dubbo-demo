package com.dubbodemo.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.dubbodemo.common.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: 周海明
 * Date: 2017/3/2
 * Time: 11:50
 * 通过Dubbo调用DubboServer提供的服务（不使用Spring框架）
 */
public class DubboClientOriginal {
    public static void main(String[] args) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("userServiceClient");
        String zkAddress = "127.0.0.1:2181";
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(String.format("zookeeper://%s?client=zkclient", zkAddress));
        ReferenceConfig<UserService> reference = new ReferenceConfig<UserService>();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setCheck(false);
        reference.setInterface(UserService.class);
        reference.setVersion("1.0");
        UserService userService = reference.get();
        System.out.println(userService.getUserInfo().getName());
    }
}
