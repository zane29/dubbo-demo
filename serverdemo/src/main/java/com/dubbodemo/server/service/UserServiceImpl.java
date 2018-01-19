package com.dubbodemo.server.service;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbodemo.common.UserInfo;
import com.dubbodemo.common.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 16-12-20
 * Time: 下午3:55
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService {
    @Override
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("周海明");
        userInfo.setValue("123456");
        // 获取客户端隐式传入的参数，用于框架集成，不建议常规业务使用
        String index = RpcContext.getContext().getAttachment("index");
        System.out.println(index);
        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        // 获取调用方IP地址
        String clientIP = RpcContext.getContext().getRemoteHost();
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        return userInfo;
    }
}
