package com.xiaomi.push;

/* loaded from: classes19.dex */
final class ix implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;
    final /* synthetic */ android.content.ComponentName b;

    public ix(android.content.Context context, android.content.ComponentName componentName) {
        this.a = context;
        this.b = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            android.content.pm.PackageManager packageManager = this.a.getPackageManager();
            if (packageManager.getComponentEnabledSetting(this.b) != 2) {
                packageManager.setComponentEnabledSetting(this.b, 2, 1);
            }
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a("close static register of network status receiver failed:".concat(java.lang.String.valueOf(th)));
        }
    }
}
