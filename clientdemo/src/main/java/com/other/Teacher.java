package com.other;


/**
 * @author zhouhaiming  Email: dg_chow@163.com
 * @date 2017/12/28 15:19
 */
public class Teacher implements Callback {
    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        student.resolveQuestion(this);
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println("知道了，你的答案是" + answer);
    }

}
