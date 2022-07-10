package com.yuansong.dailyHelper.config;

import com.yuansong.dailyHelper.global.DHConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


@Configuration //声明配置类
@EnableAsync //开启异步任务支持
public class TaskExecutorConfig {

    @Bean(DHConstant.TASK_EXECUTOR)
    public ThreadPoolTaskExecutor taskExecutor() {
        int maxThreads = Runtime.getRuntime().availableProcessors() * 2 + 1;
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(maxThreads);
        threadPoolTaskExecutor.setMaxPoolSize(maxThreads);
        threadPoolTaskExecutor.setQueueCapacity(200);
        threadPoolTaskExecutor.setThreadNamePrefix(DHConstant.TASK_EXECUTOR+"-");
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        threadPoolTaskExecutor.initialize();
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        threadPoolTaskExecutor.setKeepAliveSeconds(60);
        return threadPoolTaskExecutor;
    }
}
