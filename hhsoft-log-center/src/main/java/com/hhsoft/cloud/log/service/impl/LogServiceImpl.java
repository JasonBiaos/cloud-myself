package com.hhsoft.cloud.log.service.impl;

import com.hhsoft.cloud.log.dao.LogDao;
import com.hhsoft.cloud.log.service.LogService;
import com.hhsoft.cloud.model.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: LogServiceImpl
 * @Description 日志存储到mysql实现类
 * @Author Jason Biao
 * @Date 2019/4/1 19:01
 * @Version 1.0
 **/
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    /**
     * 将日志保存到数据库<br>
     * 注解@Async是开启异步执行
     *
     * @param log
     */
    @Async
    @Override
    public void save(Log log) {
        if (log.getCreateTime() == null) {
            log.setCreateTime(new Date());
        }
        if (log.getFlag() == null) {
            log.setFlag(Boolean.TRUE);
        }

        logDao.save(log);
    }

    @Override
    public Page<Log> findLogs(Map<String, Object> params) {
        //查询日志总条数
        int total = logDao.count(params);
        List<Log> list = Collections.emptyList();
        if (total > 0){

        }
        return null;
    }
}
