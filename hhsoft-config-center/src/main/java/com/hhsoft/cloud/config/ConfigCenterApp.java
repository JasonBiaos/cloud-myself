package com.hhsoft.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ClassName: ConfigCenterApp
 * @Description: SpringCloud配置中心服务
 * @Author Jason Biao
 * @Date 2019/3/20 16:50
 * @Version 1.0
 *
 * @EnableConfigServer: 具备Config Server(配置中心服务端) 功能
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigCenterApp {
    private static Logger log = LoggerFactory.getLogger(ConfigCenterApp.class);

    private static final String SERVER_NAME = "基础服务SpringCloud-Config";

    public static ConfigurableApplicationContext context = null;

    /**
     * 服务启动事件
     * @param args
     */
    public static void main(String[] args) {
        try {
            log.info(SERVER_NAME + "开始启动...");
            SpringApplication app = new SpringApplication(ConfigCenterApp.class);
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
