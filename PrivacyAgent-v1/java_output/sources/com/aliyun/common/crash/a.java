package com.aliyun.common.crash;

/* loaded from: classes.dex */
public class a implements java.lang.Thread.UncaughtExceptionHandler {
    private java.util.Stack<java.lang.Thread.UncaughtExceptionHandler> a = new java.util.Stack<>();
    private volatile int b = -1;
    private volatile int c = -1;
    private java.util.concurrent.atomic.AtomicLong d = new java.util.concurrent.atomic.AtomicLong(0);

    private java.lang.String a(java.lang.Throwable th) {
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
        do {
            th.printStackTrace(printWriter);
            th = th.getCause();
        } while (th != null);
        printWriter.close();
        return stringWriter.toString();
    }

    public void a() {
        if (this.d.get() > 0) {
            return;
        }
        this.b = 1;
        java.lang.Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = java.lang.Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            return;
        }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
        this.a.push(defaultUncaughtExceptionHandler);
    }

    public void b() {
        this.b = 0;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        java.lang.Thread.UncaughtExceptionHandler pop;
        long id = thread.getId();
        if (this.d.compareAndSet(0L, id)) {
            this.c = this.b;
        } else if (this.d.get() != id) {
            return;
        }
        if (this.c > 0 || (this.c == 0 && this.a.size() <= 1)) {
            try {
                com.aliyun.common.crash.AlivcJavaCrash.nativeOnCrashCallback(android.os.Process.myPid(), thread.getId(), thread.getName(), a(th));
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
            this.c = -1;
        }
        if (this.a.isEmpty() || (pop = this.a.pop()) == null) {
            android.os.Process.killProcess(android.os.Process.myPid());
        } else {
            pop.uncaughtException(thread, th);
        }
    }
}
