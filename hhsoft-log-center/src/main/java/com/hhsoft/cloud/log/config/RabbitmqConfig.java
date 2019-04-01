package com.hhsoft.cloud.log.config;

import com.hhsoft.cloud.model.log.constants.LogQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RabbitmqConfig
 * @Description Rabbitmq配置
 * @Author Jason Biao
 * @Date 2019/4/1 16:57
 * @Version 1.0
 **/
@Configuration
public class RabbitmqConfig {

    /**
     * 声明队列
     *
     * @return
     */
    @Bean
    public Queue logQueue() {
        Queue queue = new Queue(LogQueue.LOG_QUEUE);

        return queue;
    }
}
