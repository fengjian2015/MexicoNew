package com.fly.ayudaconfiable.task;


import com.fly.ayudaconfiable.utils.LogUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * lucksoft
 * Created by AndroidDevelop on 2020/6/14.
 * 158045632@qq.com
 */
public final class ScheduledTask {

    private static final AtomicInteger mCount = new AtomicInteger(1);
    private static ScheduledTask instance;
    private static final int KEEP_ALIVE_SECONDS = 30;
    //private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<Runnable>(128);
    private ScheduledExecutorService scheduledExecutorService = null;

    protected ScheduledTask()
    {
        ThreadFactory local1 = new ThreadFactory(){
            /*
            Thread t = new Thread(r) ;
            t.setName("ThreadPool Thread[" + a.getAndIncrement() + "]");
            //t.setUncaughtExceptionHandler(new UEHLogger());
            return t;
            */

            @Override
            public Thread newThread(Runnable var1){
                Thread taskthread = new Thread(var1);//
                taskthread.setName("PayThread-" + mCount.getAndIncrement());
                taskthread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        //LoggerFactory.getLogger(t.getName()).error(e.getMessage(), e);
                    }
                });
                return taskthread;
            }
        };

        this.scheduledExecutorService = Executors.newScheduledThreadPool(4, local1);
        if ((this.scheduledExecutorService == null) || (this.scheduledExecutorService.isShutdown())) {
            LogUtils.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!");
        }
    }

    public static synchronized ScheduledTask getInstance()
    {
        if (instance == null) {
            instance = new ScheduledTask();
        }
        return instance;
    }

    public final synchronized boolean runTask(Runnable paramRunnable, long paramLong)
    {
        if (!isClose())
        {
            LogUtils.d("[AsyncTaskHandler] Async handler was closed, should not post task.");
            return false;
        }
        if (paramRunnable == null)
        {
            LogUtils.d("[AsyncTaskHandler] Task input is null.");
            return false;
        }
        paramLong = paramLong > 0L ? paramLong : 0L;
        LogUtils.v(" task: " + paramRunnable.getClass().getName());
        LogUtils.v(" Post a delay(time: " + Long.valueOf(paramLong) + " ms" );
        try
        {
            this.scheduledExecutorService.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
            return true;
        }
        catch (Throwable param)
        {
            //if (b.c) {
                param.printStackTrace();
            //}
        }
        return false;
    }

    public final synchronized boolean runTask(Runnable paramRunnable)
    {
        if (!isClose())
        {
            LogUtils.d("[AsyncTaskHandler] Async handler was closed, should not post task.");
            return false;
        }
        if (paramRunnable == null)
        {
            LogUtils.d("[AsyncTaskHandler] Task input is null.");
            return false;
        }
        LogUtils.d("[AsyncTaskHandler] Post a normal task: " + paramRunnable.getClass().getName());
        try
        {
            this.scheduledExecutorService.execute(paramRunnable);
            return true;
        }
        catch (Throwable param)
        {
            //if (b.c) {
                param.printStackTrace();
           // }
        }
        return false;
    }

    public final synchronized void shutdowon()
    {
        if ((this.scheduledExecutorService != null) && (!this.scheduledExecutorService.isShutdown()))
        {
            LogUtils.v("[AsyncTaskHandler] Close async handler.");
            this.scheduledExecutorService.shutdownNow();
        }
    }

    public final synchronized boolean isClose()
    {
        return (this.scheduledExecutorService != null) && (!this.scheduledExecutorService.isShutdown());
    }
}
