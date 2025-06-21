package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class RunnableEnhance implements java.lang.Runnable {
    static final java.lang.String TRANCELOGO = " -->";
    private java.lang.String parentName = java.lang.Thread.currentThread().getName();
    private java.lang.Runnable proxy;

    public RunnableEnhance(java.lang.Runnable runnable) {
        this.proxy = runnable;
    }

    public java.lang.String getParentName() {
        return this.parentName;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.proxy.run();
    }
}
