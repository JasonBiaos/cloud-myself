package com.hhsoft.cloud.model.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: SysRole
 * @Description 角色实体类
 * @Author Jason Biao
 * @Date 2019/3/21 13:38
 * @Version 1.0
 **/
@Data
public class SysRole implements Serializable {

    private static final long serialVersionUID = -2054359538140713354L;

    /**
     *主键id
     */
    private Long id;

    /**
     *角色code
     */
    private String code;

    /**
     *角色名称
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
