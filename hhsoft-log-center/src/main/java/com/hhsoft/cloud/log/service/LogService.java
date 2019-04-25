package com.hhsoft.cloud.log.service;

import com.hhsoft.cloud.model.common.Page;
import com.hhsoft.cloud.model.log.Log;

import java.util.Map;

/**
 * @interface: LogService
 * @Description Log服务接口（日志存储到mysql服务接口）
 * @Author Jason Biao
 * @Date 2019/4/1 18:59
 * @Version 1.0
 **/
public interface LogService {

    /**
     * 保存(新增)日志
     *
     * @param log
     */
    void save(Log log);

    /**
     * 分页查询日志集合
     * @param params
     * @return
     */
    Page<Log> findLogs(Map<String, Object> params);
}
