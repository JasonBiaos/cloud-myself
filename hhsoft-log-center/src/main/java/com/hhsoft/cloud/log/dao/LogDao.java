package com.hhsoft.cloud.log.dao;

import com.hhsoft.cloud.model.log.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @interface: LogDao
 * @Description Log数据接口（日志存储到mysql）
 * @Author Jason Biao
 * @Date 2019/4/1 18:53
 * @Version 1.0
 **/
@Mapper
public interface LogDao {

    /**
     * 保存(新增)日志
     * @param log
     * @return
     */
    @Insert("insert into t_log(username, module, params, remark, flag, createTime) values(#{username}, #{module}, #{params}, #{remark}, #{flag}, #{createTime})")
    int save(Log log);

    /**
     * 查询日志条数
     * @param params
     * @return
     */
    int count(Map<String, Object> params);

    /**
     * 分页查询日志集合
     * @param params
     * @return
     */
    List<Log> findData(Map<String, Object> params);
}
