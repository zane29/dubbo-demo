package com.dubbodemo.client;

import com.alibaba.dubbo.rpc.RpcContext;
import com.dubbodemo.common.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 16-12-20
 * Time: 下午3:53
 * 通过Dubbo调用DubboServer提供的服务（使用Spring框架）
 */
public class DubboClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.getUserInfo().getName());

        RpcContext.getContext().setAttachment("index", "隐式传参");// 隐式传参，后面的远程调用都会隐式将这些参数发送到服务器端，类似cookie，用于框架集成，不建议常规业务使用
        boolean isConsumerSide = RpcContext.getContext().isConsumerSide(); // 本端是否为消费端，这里会返回true
        String serverIP = RpcContext.getContext().getRemoteHost(); // 获取最后一次调用的提供方IP地址
        System.out.println(userService.getUserInfo().getName());
        boolean isConsumerSide2 = RpcContext.getContext().isConsumerSide(); // 本端是否为消费端，这里会返回true
        String serverIP2 = RpcContext.getContext().getRemoteHost(); // 获取最后一次调用的提供方IP地址
    }
}
