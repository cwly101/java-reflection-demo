package com.cw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

class User {

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Date birthday = new Date(new java.util.Date().getTime());  // 缺省默认为当前时间

    /**
     * Date类型日期 格式化为字符串类型的日期
     * @return
     */
    public String getBirthday() {
        return dateFormat.format(birthday);
    }

    /**
     * 字符串日期格式解析成 Date类型日期格式
     * @param birthday
     * @throws ParseException
     */
    public void setBirthday(String birthday) throws ParseException {
        java.util.Date date = dateFormat.parse(birthday);
        // 将java.util.Date 转换成 java.sql.Date 类型
        this.birthday = new Date(date.getTime());
    }
}

/**
 * JDK 1.8（不包含） 以下的日期格式化示例
 * @author caowei
 * @create 2020/1/20
 */
public class DateFormatDemo {

    public static void main(String[] args) throws ParseException {

        User user = new User();
        System.out.println(user.getBirthday());
        user.setBirthday("1990-01-20");

        System.out.println(user.getBirthday());
    }
}
