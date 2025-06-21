package com.aliyun.utils;

/* loaded from: classes12.dex */
public class g {
    public static java.util.concurrent.ExecutorService a = java.util.concurrent.Executors.newCachedThreadPool(new com.aliyun.utils.g.a());

    public class a implements java.util.concurrent.ThreadFactory {
        private int a = 0;

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            this.a++;
            return new java.lang.Thread(runnable, "ThreadManager#" + this.a);
        }
    }
}
