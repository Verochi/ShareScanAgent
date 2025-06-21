package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class h0 {
    public static com.huawei.hms.hatool.h0 b;
    public android.content.Context a;

    static {
        new java.util.HashMap();
    }

    public static com.huawei.hms.hatool.h0 a() {
        return b();
    }

    public static synchronized com.huawei.hms.hatool.h0 b() {
        com.huawei.hms.hatool.h0 h0Var;
        synchronized (com.huawei.hms.hatool.h0.class) {
            if (b == null) {
                b = new com.huawei.hms.hatool.h0();
            }
            h0Var = b;
        }
        return h0Var;
    }

    public void a(android.content.Context context) {
        this.a = context;
        b(context);
        com.huawei.hms.hatool.i.c().b().h(com.huawei.hms.hatool.f.a());
    }

    public void a(java.lang.String str, int i) {
        if (this.a == null) {
            com.huawei.hms.hatool.y.e("hmsSdk", "onReport() null context or SDK was not init.");
        } else {
            com.huawei.hms.hatool.y.c("hmsSdk", "onReport: Before calling runtaskhandler()");
            a(str, com.huawei.hms.hatool.u0.a(i), com.huawei.hms.hatool.b.g());
        }
    }

    public void a(java.lang.String str, int i, java.lang.String str2, org.json.JSONObject jSONObject) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (2 == i) {
            currentTimeMillis = com.huawei.hms.hatool.u0.a("yyyy-MM-dd", currentTimeMillis);
        }
        com.huawei.hms.hatool.o0.c().a(new com.huawei.hms.hatool.j0(str2, jSONObject, str, com.huawei.hms.hatool.u0.a(i), currentTimeMillis));
    }

    public void a(java.lang.String str, java.lang.String str2) {
        if (!com.huawei.hms.hatool.c.a(str, str2)) {
            com.huawei.hms.hatool.y.c("hmsSdk", "auto report is closed tag:" + str);
            return;
        }
        long j = com.huawei.hms.hatool.c.j(str, str2);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - j <= 30000) {
            com.huawei.hms.hatool.y.f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        com.huawei.hms.hatool.y.a("hmsSdk", "begin to call onReport!");
        com.huawei.hms.hatool.c.a(str, str2, currentTimeMillis);
        a(str, str2, com.huawei.hms.hatool.b.g());
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.Context context = this.a;
        if (context == null) {
            com.huawei.hms.hatool.y.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        java.lang.String a = com.huawei.hms.hatool.h.a(context);
        if (com.huawei.hms.hatool.c.e(str, str2) && !"WIFI".equals(a)) {
            com.huawei.hms.hatool.y.c("hmsSdk", "strNetworkType is :" + a);
            return;
        }
        if (android.text.TextUtils.isEmpty(a) || "2G".equals(a)) {
            com.huawei.hms.hatool.y.e("hmsSdk", "The network is bad.");
        } else {
            com.huawei.hms.hatool.o0.c().a(new com.huawei.hms.hatool.k0(str, str2, str3));
        }
    }

    public final void b(android.content.Context context) {
        java.lang.String str;
        java.lang.String d = com.huawei.hms.hatool.f.d(context);
        com.huawei.hms.hatool.b.a(d);
        if (com.huawei.hms.hatool.w0.b().a()) {
            java.lang.String a = com.huawei.hms.hatool.g0.a(context, "global_v2", "app_ver", "");
            com.huawei.hms.hatool.g0.b(context, "global_v2", "app_ver", d);
            com.huawei.hms.hatool.b.b(a);
            if (!android.text.TextUtils.isEmpty(a)) {
                if (a.equals(d)) {
                    return;
                }
                com.huawei.hms.hatool.y.c("hmsSdk", "the appVers are different!");
                a().a("", "alltype", a);
                return;
            }
            str = "app ver is first save!";
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        com.huawei.hms.hatool.y.c("hmsSdk", str);
    }
}
