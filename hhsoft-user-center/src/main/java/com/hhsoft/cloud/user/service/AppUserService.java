package com.hhsoft.cloud.user.service;

import com.hhsoft.cloud.model.user.AppUser;
import com.hhsoft.cloud.model.user.SysRole;
import org.springframework.data.domain.Page;

import java.util.Map;
import java.util.Set;

/**
 * @InterfaceName: AppUserService
 * @Description AppUser服务层
 * @Author Jason Biao
 * @Date 2019/3/21 17:27
 * @Version 1.0
 **/
public interface AppUserService {

    /**
     * 新增用户
     * @param appUser
     */
    public void addAppUser(AppUser appUser);

    /**
     * 更新用户
     * @param appUser
     */
    public void updateAppUser(AppUser appUser);

    //LoginAppUser findByUsername(String username);

    /**
     * 根据用户主键查询用户信息
     * @param id
     * @return
     */
    AppUser findById(Long id);

    /**
     * 管理后台给用户分配角色
     * @param id
     * @param roleIds
     */
    void setRoleToUser(Long id, Set<Long> roleIds);

    /**
     * 修改密码
     * @param id
     * @param oldPassword
     * @param newPassword
     */
    void updatePassword(Long id, String oldPassword, String newPassword);

    Page<AppUser> findUsers(Map<String, Object> params);

    Set<SysRole> findRolesByUserId(Long userId);

    /**
     * 把userId和手机号进行绑定
     * @param userId
     * @param phone
     */
    void bindingPhone(Long userId, String phone);
}
