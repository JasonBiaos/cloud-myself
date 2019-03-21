package com.hhsoft.cloud.model.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: AppUser
 * @Description 用户实体类
 * @Author Jason Biao
 * @Date 2019/3/21 13:34
 * @Version 1.0
 **/
@Data
public class AppUser implements Serializable {

    private static final long serialVersionUID = 611197991672067628L;

    /**
     *主键id
     */
    private Long id;

    /**
     *用户名
     */
    private String username;

    /**
     *密码
     */
    private String password;

    /**
     *昵称
     */
    private String nickname;

    /**
     *头像url
     */
    private String headImgUrl;

    /**
     *手机号
     */
    private String phone;

    /**
     *性别
     */
    private Integer sex;

    /**
     * 状态（1有效,0无效）
     */
    private Boolean enabled;

    /**
     *类型（暂未用）
     */
    private String type;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *修改时间
     */
    private Date updateTime;

}
