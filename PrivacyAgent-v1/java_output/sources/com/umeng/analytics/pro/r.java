package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class r implements java.lang.Thread.UncaughtExceptionHandler {
    private java.lang.Thread.UncaughtExceptionHandler a;
    private com.umeng.analytics.pro.v b;

    public r() {
        if (java.lang.Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.a = java.lang.Thread.getDefaultUncaughtExceptionHandler();
        java.lang.Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private void a(java.lang.Throwable th) {
        if (com.umeng.analytics.AnalyticsConfig.CATCH_EXCEPTION) {
            this.b.a(th);
        } else {
            this.b.a(null);
        }
    }

    public void a(com.umeng.analytics.pro.v vVar) {
        this.b = vVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        a(th);
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == java.lang.Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.a.uncaughtException(thread, th);
    }
}
