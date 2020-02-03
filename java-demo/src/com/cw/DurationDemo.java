package com.cw;

import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;

/**
 * @author caowei
 * @create 2020/1/21
 */
public class DurationDemo {

    /**
     * JDK8 时间计算API
     * @param args
     */
    public static void main(String[] args) {
//        getDurationBetween();
//        getPeriodBetween();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化（为字符串）
        String format = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println("LocalDateTime时间格式为字符串："+format);

        // （字符串）解析为 LocalDate或LocalDateTime
        String dateTime ="2019-05-01 11:01:32";  // 时间为12小时制，切记。24小时不认，抛异常。
        LocalDateTime dateTime1 = LocalDateTime.parse(dateTime, dateTimeFormatter);
        System.out.println("字符串时间值解析为LocalDateTime:"+dateTime1);

        // 以下是建立在 DateTimeFormatter格式为：yyyy-mm-dd HH:mm:ss 的基础上进行操作。正确应为：yyyy-MM-dd HH:mm:ss
//        TemporalAccessor parse = dateTimeFormatter.parse(dateTime);
//        System.out.println(parse);
//
//        // TemporalField 接口的实现类 ChronoField
//        int hour = parse.get(ChronoField.HOUR_OF_AMPM);
//        int minute = parse.get(ChronoField.MINUTE_OF_HOUR);
//        int second = parse.get(ChronoField.SECOND_OF_MINUTE);
//        LocalDate dt = LocalDate.parse(dateTime, dateTimeFormatter);
//        System.out.println(dt + " "+hour+":"+(minute<10?"0"+minute:minute)+":"+second);
//
//        System.out.println(dt.getYear()+","+dt.getMonthValue()+","+dt.getDayOfMonth());
//        LocalDateTime localDateTime = LocalDateTime.of(dt.getYear(), dt.getMonthValue(), dt.getDayOfMonth(), hour, minute, second);
//        System.out.println(localDateTime);
//
//        java.sql.Date date = Date.valueOf(dt);
//        System.out.println(date);

    }

    private static void getPeriodBetween() {
        System.out.println("====== Period ======");

        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2029, 1, 21);
        // Period 类表示一段时间的年、月、日，开使用between()方法获取两个日期之间的差作为Period 对象返回：
        Period between1 = Period.between(localDate, localDate1);
        System.out.println("相差时间:"+between1.getYears()+"年"+between1.getMonths()+"月"+between1.getDays()+"天");
    }

    private static void getDurationBetween() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, 5, 5, 7, 30);

        // Duration类表示秒或纳秒时间间隔，适合处理较短的时间，需要更高的精确性。
        Duration between = Duration.between(localDateTime1, localDateTime);
        // 时间差值，按天计算
        System.out.println(between.toDays());
        // 小时计算
        System.out.println(between.toHours());
    }
}
