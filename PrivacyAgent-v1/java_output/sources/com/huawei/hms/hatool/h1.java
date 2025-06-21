package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public final class h1 {
    public static com.huawei.hms.hatool.h1 b;
    public static final java.lang.Object c = new java.lang.Object();
    public android.content.Context a;

    public static com.huawei.hms.hatool.h1 a() {
        if (b == null) {
            b();
        }
        return b;
    }

    public static synchronized void b() {
        synchronized (com.huawei.hms.hatool.h1.class) {
            if (b == null) {
                b = new com.huawei.hms.hatool.h1();
            }
        }
    }

    public void a(android.content.Context context) {
        synchronized (c) {
            if (this.a != null) {
                com.huawei.hms.hatool.y.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.a = context;
            com.huawei.hms.hatool.i.c().b().a(this.a);
            com.huawei.hms.hatool.i.c().b().j(context.getPackageName());
            com.huawei.hms.hatool.z0.a().a(context);
        }
    }

    public void a(java.lang.String str) {
        com.huawei.hms.hatool.y.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        android.content.Context context = this.a;
        if (context == null) {
            com.huawei.hms.hatool.y.e("hmsSdk", "sdk is not init");
        } else {
            com.huawei.hms.hatool.i.c().b().i(com.huawei.hms.hatool.s0.a(com.heytap.mcssdk.constant.b.u, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
