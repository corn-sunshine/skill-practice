package com.elwood.scheduled.config;

import java.util.concurrent.ScheduledFuture;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/10/22
 * @Version: 1.0
 */
public final class ScheduledTask {

    volatile ScheduledFuture<?> future;

    /**
     * 取消定时任务
     */
    public void cancel() {
        ScheduledFuture<?> future = this.future;
        if (future != null) {
            future.cancel(true);
        }
    }
}
