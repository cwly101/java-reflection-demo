package com.cw.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解示例。描述该注解的作用。
 * @author caowei
 * @create 2020/1/24
 */
@Documented // 使用该标识，会在生成API文档时保留该注解标注的其它类对该注解的引用，有助于阅读。
@Retention(RetentionPolicy.RUNTIME)  // 生命周期。Source、Class(默认值)、Runtime
@Target(ElementType.TYPE) // 注解可在哪些地方声明，参见ElementType枚举
@Inherited // 表示被该注解标识类的子类将自动继承该注解。否则子类不会继承。
public @interface MyBehavior {

    String value() default "test";
}
