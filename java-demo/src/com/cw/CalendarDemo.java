package com.cw;

import com.sun.tools.javac.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author caowei
 * @create 2020/1/21
 */
public class CalendarDemo {

    /**
     * 现个时间相差的天数
     * 公式：(date2.getTime()-date1.getTime()) / (1000 * 60 * 60 * 24) + 1
     * @param args
     */
    public static void main(String[] args) throws ParseException {
        String str_date1 ="2019-05-07";
        String str_date2 ="2020-01-16";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(str_date1);
        Date date2 = format.parse(str_date2);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        System.out.println(calendar2.get(Calendar.DAY_OF_YEAR));

        long millisOfDay = (1000 * 60 * 60 * 24);
        long days = (calendar2.getTimeInMillis()-calendar.getTimeInMillis())/ millisOfDay +1;

        System.out.println("===========");
        System.out.println((date2.getTime()-date1.getTime()) / (1000 * 60 * 60 * 24) + 1);
        System.out.println(days);


//        long millisOfDay = 24 * 60 * 60 * 1000;
//        Calendar calendar = new GregorianCalendar(2015, 9, 1);
//        Calendar calendar1 = new GregorianCalendar(2016, 9, 1);
//        Calendar calendar2 = new GregorianCalendar(2017, 9, 1);
//// 2016年是闰年，得到366天
//        System.out.println((calendar1.getTimeInMillis() - calendar.getTimeInMillis()) / millisOfDay);
//// 2017年是平年，得到365天
//        System.out.println((calendar2.getTimeInMillis() - calendar1.getTimeInMillis()) / millisOfDay);
    }
}
