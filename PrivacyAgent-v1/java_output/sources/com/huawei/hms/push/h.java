package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class h {
    public android.content.ServiceConnection a;
    public android.os.Messenger b = null;

    public boolean a(android.content.Context context, android.os.Bundle bundle, android.content.Intent intent) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.a = new com.huawei.hms.push.g(this, bundle, applicationContext);
        com.huawei.hms.support.log.HMSLog.i("RemoteService", "remote service bind service start");
        return applicationContext.bindService(intent, this.a, 1);
    }
}
