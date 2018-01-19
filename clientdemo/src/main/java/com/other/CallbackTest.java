package com.other;

/**
 * @author zhouhaiming  Email: dg_chow@163.com
 * @date 2017/12/28 15:24
 */
public class CallbackTest {
    public static void main(String[] args) {
        CallbackTest callbackTest = new CallbackTest();
        callbackTest.testCallback();

    }
    public void testCallback() {
        Student student = new Ricky();
        Teacher teacher = new Teacher(student);
        teacher.askQuestion();
    }
}
