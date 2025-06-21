package com.huawei.hms.push.task;

/* loaded from: classes22.dex */
public class IntentCallable implements java.util.concurrent.Callable<java.lang.Void> {
    public android.content.Context a;
    public android.content.Intent b;
    public java.lang.String c;

    public IntentCallable(android.content.Context context, android.content.Intent intent, java.lang.String str) {
        this.a = context;
        this.b = intent;
        this.c = str;
    }

    @Override // java.util.concurrent.Callable
    public java.lang.Void call() throws java.lang.Exception {
        this.a.sendBroadcast(this.b);
        com.huawei.hms.push.utils.PushBiUtil.reportExit(this.a, com.huawei.hms.support.api.entity.push.PushNaming.SET_NOTIFY_FLAG, this.c, com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS);
        return null;
    }
}
