package com.medisupply.platform.u202421823.shared.infrastructure.concurrency.loom.configuration;

import org.jspecify.annotations.NullMarked;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Loom Concurrency Configuration.
 * <p>
 * Configures asynchronous task execution using OpenJDK Project Loom virtual threads.
 * </p>
 */

@Configuration
@EnableAsync
@NullMarked
public class VirtualThreadsConfiguration {


    @Bean(name = "applicationTaskExecutor")
    public TaskExecutor applicationTaskExecutor() {
        var executor = new SimpleAsyncTaskExecutor("loom-exec-");
        executor.setVirtualThreads(true);
        return executor;
    }
}
