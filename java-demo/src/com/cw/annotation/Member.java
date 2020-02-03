package com.cw.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author caowei
 * @create 2020/1/24
 */
@MyBehavior("login")
public class Member {
}

/**
 * 自定义的 @interface 注解 通过反射获取注解类型及属性值的示例
 * 为自己写框架提供一个技术参考
 */
class AnnotationTest{
    public static void main(String[] args) throws Exception {
        Class<Member> memberClass = Member.class;
        /*Annotation[] annotations = memberClass.getAnnotations();
        Arrays.stream(annotations).forEach(item -> {
            System.out.println(item);
            System.out.println(item.annotationType().getName()); // 字符串形式获取注解的类型
            // 自己编写的框架肯定知道都定义了什么类型的注解，一一比对即可。
            if(item.annotationType().getName() == "com.cw.annotation.MyBehavior") {
                System.out.println("启用com.cw.annotation.MyBehavior注解表示的行为逻辑...");
                MyBehavior annotation1 = (MyBehavior) memberClass.getAnnotation(item.annotationType());
                System.out.println("注解value属性值："+annotation1.value());

                // 动态代理上场，实现真正的业务逻辑。就算不自己写框架，也助于理解其它框架反射和注解的关系。
            }
        });*/

        Class<?> clazz = Class.forName("com.cw.annotation.Member");
        // 指定类型的注解是否存在于memberClass实例对象类上
        boolean present = clazz.isAnnotationPresent(MyBehavior.class);
        System.out.println(present);
        if(present){
            // 存在注解时，执行注解表示的功能和逻辑 ...
            MyBehavior annotation = clazz.getAnnotation(MyBehavior.class);
            System.out.println(annotation);
            System.out.println(annotation.value());
        }


    }
}
