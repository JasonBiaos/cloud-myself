package com.hhsoft.cloud.model.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: SysPermission
 * @Description 权限标识实体类
 * @Author Jason Biao
 * @Date 2019/3/21 13:42
 * @Version 1.0
 **/
@Data
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 280565233032255804L;

    /**
     *主键id
     */
    private Long id;

    /**
     *权限标识
     */
    private String permission;

    /**
     *权限名称
     */
    private String name;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *更新时间
     */
    private Date updateTime;
}
