package com.hhsoft.cloud.model.log.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LogModule
 * @Description 日志模块常量定义抽象类
 * @Author Jason Biao
 * @Date 2019/4/1 18:27
 * @Version 1.0
 *
 * @Deprecated: 若某类或某方法加上该注解之后，表示此方法或类不再建议使用，调用时也会出现删除线，
 *                但并不代表不能用，只是说，不推荐使用，因为还有更好的方法可以调用。
 **/
//@Deprecated

public abstract class LogModule {

    /**
     * 模块集合
     */
    public static final Map<String, String> MODULES = new HashMap<>();

    /**
     * 登录
     */
    public static final String LOGIN = "LOGIN";

    /**
     * 注销
     */
    public static final String LOGOUT = "LOGOUT";

    /**
     * 添加权限
     */
    public static final String ADD_PERMISSION = "ADD_PERMISSION";

    /**
     * 更新权限
     */
    public static final String UPDATE_PERMISSION = "UPDATE_PERMISSION";

    /**
     * 删除权限
     */
    public static final String DELETE_PERMISSION = "DELETE_PERMISSION";

    /**
     * 添加角色
     */
    public static final String ADD_ROLE = "ADD_ROLE";

    /**
     *更新角色
     */
    public static final String UPDATE_ROLE = "UPDATE_ROLE";

    /**
     *删除角色
     */
    public static final String DELETE_ROLE = "DELETE_ROLE";

    /**
     *分配权限
     */
    public static final String SET_PERMISSION = "SET_PERMISSION";

    /**
     *分配(设置)角色
     */
    public static final String SET_ROLE = "SET_ROLE";

    /**
     *更新用户
     */
    public static final String UPDATE_USER = "UPDATE_USER";

    /**
     *修改个人信息
     */
    public static final String UPDATE_ME = "UPDATE_ME";

    /**
     * 修改密码
     */
    public static final String UPDATE_PASSWORD = "UPDATE_PASSWORD";

    /**
     * 重置密码
     */
    public static final String RESET_PASSWORD = "RESET_PASSWORD";

    /**
     * 添加菜单
     */
    public static final String ADD_MENU = "ADD_MENU";

    /**
     * 修改菜单
     */
    public static final String UPDATE_MENU = "UPDATE_MENU";

    /**
     * 删除菜单
     */
    public static final String DELETE_MENU = "DELETE_MENU";

    /**
     * (给角色)分配菜单
     */
    public static final String SET_MENU_ROLE = "SET_MENU_ROLE";

    /**
     * 添加黑名单
     */
    public static final String ADD_BLACK_IP = "ADD_BLACK_IP";

    /**
     * 删除黑名单
     */
    public static final String DELETE_BLACK_IP = "DELETE_BLACK_IP";

    /**
     * 文件上传
     */
    public static final String FILE_UPLOAD = "FILE_UPLOAD";

    /**
     * 文件删除
     */
    public static final String FILE_DELETE = "FILE_DELETE";

    /**
     * 保存(新增)邮件
     */
    public static final String ADD_MAIL = "ADD_MAIL";

    /**
     * 修改邮件
     */
    public static final String UPDATE_MAIL = "UPDATE_MAIL";

    /**
     * 保存client
     */
    public static final String ADD_CLIENT = "ADD_CLIENT";

    /**
     * 修改client
     */
    public static final String UPDATE_CLIENT = "UPDATE_CLIENT";

    /**
     * 删除client
     */
    public static final String DELETE_CLIENT = "DELETE_CLIENT";

    /**
     * 修改client密码
     */
    public static final String RESET_PASSWORD_CLIENT = "RESET_PASSWORD_CLIENT";

    static {
        MODULES.put(LOGIN, "登陆");
        MODULES.put(LOGOUT, "退出");

        MODULES.put(ADD_PERMISSION, "添加权限");
        MODULES.put(UPDATE_PERMISSION, "修改权限");
        MODULES.put(DELETE_PERMISSION, "删除权限");

        MODULES.put(ADD_ROLE, "添加角色");
        MODULES.put(UPDATE_ROLE, "修改角色");
        MODULES.put(DELETE_ROLE, "删除角色");
        MODULES.put(SET_PERMISSION, "分配权限");
        MODULES.put(SET_ROLE, "分配角色");

        MODULES.put(UPDATE_USER, "修改用户");
        MODULES.put(UPDATE_ME, "修改个人信息");
        MODULES.put(UPDATE_PASSWORD, "修改密码");
        MODULES.put(RESET_PASSWORD, "重置密码");

        MODULES.put(ADD_MENU, "添加菜单");
        MODULES.put(UPDATE_MENU, "修改菜单");
        MODULES.put(DELETE_MENU, "删除菜单");
        MODULES.put(SET_MENU_ROLE, "分配菜单");

        MODULES.put(ADD_BLACK_IP, "添加黑名单");
        MODULES.put(DELETE_BLACK_IP, "删除黑名单");

        MODULES.put(FILE_UPLOAD, "文件上传");
        MODULES.put(FILE_DELETE, "文件删除");

        MODULES.put(ADD_MAIL, "保存邮件");
        MODULES.put(UPDATE_MAIL, "修改邮件");

        MODULES.put(ADD_CLIENT, "保存client");
        MODULES.put(UPDATE_CLIENT, "修改client");
        MODULES.put(DELETE_CLIENT, "删除client");
        MODULES.put(RESET_PASSWORD_CLIENT, "修改client密码");
    }
}
