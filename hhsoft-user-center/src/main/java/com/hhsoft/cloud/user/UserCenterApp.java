package com.hhsoft.cloud.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName: UserCenterApp
 * @Description 用户服务中心
 * @Author Jason Biao
 * @Date 2019/3/21 10:08
 * @Version 1.0
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UserCenterApp {

    private static Logger log = LoggerFactory.getLogger(UserCenterApp.class);

    private static final String SERVER_NAME = "基础服务User-Center";

    public static ConfigurableApplicationContext context = null;

    /**
     * 服务启动事件
     * @param args
     */
    public static void main(String[] args) {
        try {
            log.info(SERVER_NAME + "开始启动...");
            SpringApplication app = new SpringApplication(UserCenterApp.class);
            context = app.run(args);
            shutdownHook();
            log.info(SERVER_NAME + "完成启动...");
            while (true) {
                Thread.sleep(60 * 1000);
                log.info(SERVER_NAME + "......运行中...");
            }
        } catch (Throwable e) {
            log.error(SERVER_NAME + "启动失败", e);
        }
    }

    /**
     * 增加服务关闭事件
     */
    private static void shutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                log.info(SERVER_NAME + "......停止中...");

                context.close(); // 关闭spring容器
                log.info(SERVER_NAME + "......已停止...");
            }
        }));
    }

}
