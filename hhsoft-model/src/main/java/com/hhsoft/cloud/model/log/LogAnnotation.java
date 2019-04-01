package com.hhsoft.cloud.model.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @interface: LogAnnotation
 * @Description 自定义日志注解
 * @Author Jason Biao
 * @Date 2019/4/1 18:39
 * @Version 1.0
 *
 * @Target: 用于描述注解的使用范围（即：被描述的注解可以用在什么地方）--ElementType.METHOD:用于描述方法
 * @Retention: 表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）--RUNTIME:在运行时有效（即运行时保留）
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

    /**
     * 日志模块
     *
     * @return
     * @see com.hhsoft.cloud.model.log.constants.LogModule
     */
    String module();

    /**
     * 记录参数<br>
     * 尽量记录普通参数类型的方法，和能序列化的对象
     *
     * @return
     */
    boolean recordParam() default true;
}
