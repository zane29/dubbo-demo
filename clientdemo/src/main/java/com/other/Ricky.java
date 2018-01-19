package com.other;

/**
 * @author zhouhaiming  Email: dg_chow@163.com
 * @date 2017/12/28 15:23
 */
public class Ricky implements Student {
    @Override
    public void resolveQuestion(Callback callback) {
        // 模拟解决问题
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        // 回调，告诉老师作业写了多久
        callback.tellAnswer(3);
    }

}
