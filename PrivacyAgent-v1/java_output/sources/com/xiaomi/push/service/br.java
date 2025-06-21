package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class br implements java.lang.Runnable {
    final /* synthetic */ com.xiaomi.push.service.c a;

    public br(com.xiaomi.push.service.c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            android.content.pm.PackageManager packageManager = this.a.getApplicationContext().getPackageManager();
            android.content.ComponentName componentName = new android.content.ComponentName(this.a.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("[Alarm] disable ping receiver may be failure. ".concat(java.lang.String.valueOf(th)));
        }
    }
}
