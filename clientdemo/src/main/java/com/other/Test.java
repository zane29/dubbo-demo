package com.other;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhouhaiming  Email: dg_chow@163.com
 * @date 2018/01/08 15:52
 */
public class Test {
    public static void main(String args[]) throws ParseException, InterruptedException {

        System.out.println(new Date(new Long("1514739661")).getTime());
        System.out.println(new Date(new Long("1514739661000")).getTime());

        Date dateStart = new Date(new Long("1515945600000"));
        Date dateEnd = new Date(new Long("1516550399000"));

        System.out.println("1\t1");
//        System.out.println(differentDays(dateStart,dateEnd));
//        printNum();

        Date aw = Calendar.getInstance().getTime();//获得时间的另一种方式，测试效果一样
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format0.format(aw);//这个就是把时间戳经过处理得到期望格式的时间
        System.out.println("格式化结果0：" + time);

//        System.out.println(secondToTime(0));


    }



    /**
     * 将秒数转换为时分秒，
     * 格式：00:00:00
     *
     * @param second
     * @return
     */
    public static String secondToTime(long second) {
        long hours = second / 3600;            //转换小时
        second = second % 3600;                //剩余秒数
        long minutes = second / 60;            //转换分钟
        second = second % 60;                //剩余秒数
        return format(hours) + ":" + format(minutes) + ":" + format(second);
    }

    public static String format(long num) {
        return String.format("%02d", num);
    }

    public static long differentDays(Date date1, Date date2) {

        System.out.println((long) Math.ceil((double) (date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
        return (long) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));

    }

    public static void printNum() {
        double i = 3.856;

        // 舍掉小数取整
        System.out.println("舍掉小数取整:Math.floor(3.856)=" + (int) Math.floor(i));

        // 四舍五入取整
        System.out.println("四舍五入取整:(3.856)="
                + new BigDecimal(i).setScale(0, BigDecimal.ROUND_HALF_UP));

        // 四舍五入保留两位小数
        System.out.println("四舍五入取整:(3.856)="
                + new BigDecimal(i).setScale(2, BigDecimal.ROUND_HALF_UP));

        // 凑整，取上限
        System.out.println("凑整:Math.ceil(3.856)=" + (int) Math.ceil(i));

        // 舍掉小数取整
        System.out.println("舍掉小数取整:Math.floor(-3.856)=" + (int) Math.floor(-i));
        // 四舍五入取整
        System.out.println("四舍五入取整:(-3.856)="
                + new BigDecimal(-i).setScale(0, BigDecimal.ROUND_HALF_UP));

        // 四舍五入保留两位小数
        System.out.println("四舍五入取整:(-3.856)="
                + new BigDecimal(-i).setScale(2, BigDecimal.ROUND_HALF_UP));

        // 凑整，取上限
        System.out.println("凑整(-3.856)=" + (int) Math.ceil(-i));
    }
}
