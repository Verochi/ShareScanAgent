package com.meizu.cloud.pushsdk.c.h;

/* loaded from: classes23.dex */
public final class a {
    public static void a(com.meizu.cloud.pushsdk.c.c.k kVar, com.meizu.cloud.pushsdk.c.a.b bVar) {
        if (bVar.f() == com.meizu.cloud.pushsdk.c.a.e.OK_HTTP_RESPONSE || kVar == null || kVar.b() == null || kVar.b().a() == null) {
            return;
        }
        try {
            try {
                kVar.b().a().close();
                if (!com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationChannel()) {
                    return;
                }
            } catch (java.lang.Exception unused) {
                com.meizu.cloud.pushsdk.c.a.a.a("Unable to close source data");
                if (!com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationChannel()) {
                    return;
                }
            }
            android.net.TrafficStats.clearThreadStatsTag();
        } catch (java.lang.Throwable th) {
            if (com.meizu.cloud.pushsdk.util.MinSdkChecker.isSupportNotificationChannel()) {
                android.net.TrafficStats.clearThreadStatsTag();
            }
            throw th;
        }
    }
}
