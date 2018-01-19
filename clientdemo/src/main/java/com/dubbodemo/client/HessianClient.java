package com.dubbodemo.client;

import com.caucho.hessian.client.HessianProxyFactory;
import com.dubbodemo.common.UserService;

import java.net.MalformedURLException;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 16-12-20
 * Time: 下午4:15
 * 不通过Dubbo，直接通过Hessian API访问DubboServer提供的服务
 */
public class HessianClient {
    public static void main(String[] args) throws MalformedURLException {
        String url = "http://127.0.0.1:20811/com.dubbodemo.common.UserService";
        HessianProxyFactory hessianProxyFactory = new HessianProxyFactory();
        hessianProxyFactory.setOverloadEnabled(true);
        UserService userService = (UserService) hessianProxyFactory.create(UserService.class, url);
        System.out.println(userService.getUserInfo().getName());
    }
}
