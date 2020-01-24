package com.cw;

import java.util.Arrays;

/**
 * Java枚举示例
 * 1. 不允修改枚举对象的属性，构造初始化时就需要固定。
 * 2. 不允许实例化，所有私有构造函数。
 * 3. 枚举仅提供Getter()方法
 * 4. 枚举只存在静态枚举对象，在枚举类内部自行实例化。
 * @author caowei
 * @create 2020/1/23
 */
public enum SeasonEnum {

    SPRING("spring","春"),
    SUMMER("summer","夏"),
    AUTUMN("autumn","秋"),
    WINTER("winter","冬")
    ;
    // 注：枚举也可以实现接口。不同实例可以实现不同的方法体，也可以定义在枚举中，所有实体共同调用这一个。
    // 逗号前加一个大括号，里边重写实现。

    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    private SeasonEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    // 默认输出该枚举对象的原名称，如：定义为SPRING，即输出SPRING
//    @Override
//    public String toString() {
//        return "SeasonEnum{" +
//                "name='" + name + '\'' +
//                ", desc='" + desc + '\'' +
//                '}';
//    }
}

class EnumTest{
    public static void main(String[] args) {
        SeasonEnum season = SeasonEnum.SPRING;
        System.out.println(season);  // 默认输出该枚举对象的原名称，如：定义为SPRING，即输出SPRING
        System.out.println(season.toString());
        System.out.println(season.getName()+","+season.getDesc());

        // 枚举中的常用方法
        // SeasonEnum.values() 获取枚举中定义的所有枚举对象
        System.out.println(Arrays.toString(SeasonEnum.values()));
        // SeasonEnum.valueOf(key) 通常指定key,查询对应的枚举对象。如果查不到，抛：IllegalArgumentException
        SeasonEnum spring = SeasonEnum.valueOf("SPRING");
        System.out.println(spring);
    }
}
