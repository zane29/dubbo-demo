package com.dubbodemo.server;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.dubbodemo.common.UserService;
import com.dubbodemo.server.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 周海明
 * Date: 2017/3/17
 * Time: 16:48
 *
 * 原始的方法注册服务
 */

public class DubboServerOriginal {
    public static void main(String[] args) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("UserService");

        String zkHosts = "127.0.0.1:2181";
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(String.format("zookeeper://%s?client=zkclient", zkHosts));

        int servicePort = 20050;
        List<ProtocolConfig>configs = new ArrayList<>();
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("hessian");
        protocol.setServer("jetty");
        protocol.setPort(servicePort);

        UserServiceImpl userServiceImp = new UserServiceImpl();
        ServiceConfig<UserServiceImpl> serviceConfig = new ServiceConfig<UserServiceImpl>();
        serviceConfig.setApplication(application);
        serviceConfig.setRegistry(registry);
        serviceConfig.setProtocol(protocol);
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userServiceImp);
        serviceConfig.setVersion("1.0");

        serviceConfig.export();

        try {
            Object lock = new Object();
            synchronized (lock) {
                while (true) {
                    lock.wait();
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
