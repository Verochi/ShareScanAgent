package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class bg implements java.lang.Thread.UncaughtExceptionHandler {
    final /* synthetic */ com.baidu.mobads.sdk.internal.bf a;

    public bg(com.baidu.mobads.sdk.internal.bf bfVar) {
        this.a = bfVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        com.baidu.mobads.sdk.internal.ay.h("ThreadPoolFactory").c("线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
