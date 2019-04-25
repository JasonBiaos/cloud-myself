package com.hhsoft.cloud.log.controller;

import com.hhsoft.cloud.log.service.LogService;
import com.hhsoft.cloud.model.common.Page;
import com.hhsoft.cloud.model.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName: LogController
 * @Description 日志接口
 * @Author Jason Biao
 * @Date 2019/4/25 14:40
 * @Version 1.0
 **/
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 保存(新增)日志
     * @param log
     */
    @PostMapping("/logs-anon/internal")
    public void save(@RequestBody Log log){
        logService.save(log);
    }

    /**
     * 日志查询
     * @param params
     * @return
     */
    @GetMapping("/logs")
    public Page<Log> findLogs(@RequestParam Map<String,Object> params){
        return logService.findLogs(params);
    }
}
