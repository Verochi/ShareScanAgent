package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class ThreadUtil {
    public static <T> T exchange(java.util.concurrent.Exchanger<T> exchanger) {
        return (T) exchange(exchanger, null);
    }

    public static <T> T exchange(java.util.concurrent.Exchanger<T> exchanger, T t) {
        try {
            return exchanger.exchange(t);
        } catch (java.lang.InterruptedException e) {
            return (T) com.aliyun.vod.common.utils.Assert.fail(e);
        }
    }

    public static <T> T get(java.util.concurrent.Future<T> future) {
        try {
            return future.get();
        } catch (java.lang.InterruptedException e) {
            return (T) com.aliyun.vod.common.utils.Assert.fail(e);
        } catch (java.util.concurrent.ExecutionException e2) {
            return (T) com.aliyun.vod.common.utils.Assert.fail(e2);
        }
    }

    public static void join(java.lang.Thread thread) {
        try {
            thread.join();
        } catch (java.lang.InterruptedException unused) {
            com.aliyun.vod.common.utils.Assert.fail();
        }
    }

    public static boolean join(java.lang.Thread thread, int i) {
        try {
            thread.join(i);
        } catch (java.lang.InterruptedException unused) {
            com.aliyun.vod.common.utils.Assert.fail();
        }
        return !thread.isAlive();
    }

    public static <T> T take(java.util.concurrent.BlockingQueue<T> blockingQueue) {
        try {
            return blockingQueue.take();
        } catch (java.lang.InterruptedException e) {
            return (T) com.aliyun.vod.common.utils.Assert.fail(e);
        }
    }

    public static void wait(java.lang.Object obj) {
        try {
            obj.wait();
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void wait(java.lang.Object obj, long j) {
        try {
            obj.wait(j);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static java.util.concurrent.ExecutionException waitForCompletion(java.util.concurrent.Future<?> future) {
        try {
            future.get();
            return null;
        } catch (java.lang.InterruptedException unused) {
            com.aliyun.vod.common.utils.Assert.fail();
            return null;
        } catch (java.util.concurrent.ExecutionException e) {
            return e;
        }
    }
}
