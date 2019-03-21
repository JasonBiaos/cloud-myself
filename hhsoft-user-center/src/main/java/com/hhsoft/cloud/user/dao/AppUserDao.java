package com.hhsoft.cloud.user.dao;

import com.hhsoft.cloud.model.user.AppUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: AppUserDao
 * @Description 用户Dao层
 * @Author Jason Biao
 * @Date 2019/3/21 15:58
 * @Version 1.0
 **/
@Mapper
public interface AppUserDao {

    /**
     * 新增(注册)用户
     * @param appUser
     * @return
     */
    int save(AppUser appUser);

    /**
     * 更新用户
     * @param appUser
     * @return
     */
    int update(AppUser appUser);
}
