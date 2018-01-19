package com.dubbodemo.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 16-12-20
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */
public class DubboServer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-dubbo-provider.xml");
        applicationContext.start();

//        try {
//            System.out.println("按任意键退出服务");
//            System.in.read(); // 按任意键退出
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
