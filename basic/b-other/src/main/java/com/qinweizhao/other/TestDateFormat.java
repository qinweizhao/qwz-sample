package com.qinweizhao.other;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间对象和字符串的互相转化
 * 使用：DateFormat、SimpleDateFormat
 */
public class TestDateFormat {

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat  df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");

        //将字符串转成Date对象
//        Date d1 = df.parse("1971-3-10 10:40:52");
        Date d1 = df.parse("1971年3月10日 10时40分52秒");
        System.out.println(d1.getTime());

        //将Date对象转成字符串
        Date d2 = new Date(1000L * 3600 * 23);
        String str = df.format(d2);
        System.out.println(str);

        DateFormat df2 = new SimpleDateFormat("今年第w周，今年的第D天");
        System.out.println(df2.format(d2));

    }
}
