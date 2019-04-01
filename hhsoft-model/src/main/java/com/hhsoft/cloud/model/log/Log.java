package com.hhsoft.cloud.model.log;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Log
 * @Description 日志实体类
 * @Author Jason Biao
 * @Date 2019/4/1 17:29
 * @Version 1.0
 *
 * @NoArgsConstructor: 生成一个无参数的构造方法
 * @AllArgsConstructor: 会生成一个包含所有变量的构造方法
 * @Builder： 声明实体，表示可以进行Builder方式初始化
 **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log implements Serializable {

    private static final long serialVersionUID = -5398795297842978376L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 模块
     */
    private String module;

    /**
     *  参数值
     */
    private String params;

    /**
     *备注
     */
    private String remark;

    /**
     * 是否执行成功(1成功，0失败)
     */
    private Boolean flag;

    /**
     * 创建时间
     */
    private Date createTime;
}
