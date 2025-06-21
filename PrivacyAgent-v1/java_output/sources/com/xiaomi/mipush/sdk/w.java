package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
final class w implements java.lang.Runnable {
    final /* synthetic */ android.content.Context a;

    public w(android.content.Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            android.content.pm.PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 4612);
            com.xiaomi.mipush.sdk.v.c(this.a);
            com.xiaomi.mipush.sdk.v.d(this.a, packageInfo);
            com.xiaomi.mipush.sdk.v.c(this.a, packageInfo);
        } catch (java.lang.Throwable unused) {
        }
    }
}
