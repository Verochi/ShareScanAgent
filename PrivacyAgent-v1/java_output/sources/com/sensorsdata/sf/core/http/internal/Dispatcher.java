package com.sensorsdata.sf.core.http.internal;

/* loaded from: classes19.dex */
class Dispatcher {
    private static final java.lang.String TAG = "Dispatcher";
    private java.util.concurrent.ExecutorService executorService;

    /* renamed from: com.sensorsdata.sf.core.http.internal.Dispatcher$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        final /* synthetic */ boolean val$daemon;
        final /* synthetic */ java.lang.String val$name;

        public AnonymousClass1(java.lang.String str, boolean z) {
            this.val$name = str;
            this.val$daemon = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            java.lang.Thread thread = new java.lang.Thread(runnable, this.val$name);
            thread.setDaemon(this.val$daemon);
            return thread;
        }
    }

    public Dispatcher() {
        if (this.executorService == null) {
            this.executorService = new java.util.concurrent.ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.SynchronousQueue(), threadFactory("Http Dispatcher", false));
        }
    }

    private static java.util.concurrent.ThreadFactory threadFactory(java.lang.String str, boolean z) {
        return new com.sensorsdata.sf.core.http.internal.Dispatcher.AnonymousClass1(str, z);
    }

    public synchronized void enqueue(java.lang.Runnable runnable) {
        this.executorService.execute(runnable);
    }

    public synchronized com.sensorsdata.sf.core.http.internal.ResponseBody submit(java.util.concurrent.Callable<com.sensorsdata.sf.core.http.internal.ResponseBody> callable) {
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
        return (com.sensorsdata.sf.core.http.internal.ResponseBody) this.executorService.submit(callable).get();
    }
}
