package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public abstract class g {
    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(com.huawei.hms.hatool.a.a(str, str2))) {
            return com.huawei.hms.hatool.a.a(str, str2);
        }
        com.huawei.hms.hatool.y.c("hmsSdk", "getAndroidId(): to getConfigByType()");
        return c(context, str, str2);
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!str2.equals("oper") && !str2.equals("maint") && !str2.equals("diffprivacy") && !str2.equals("preins")) {
            com.huawei.hms.hatool.y.f("hmsSdk", "getChannel(): Invalid type: " + str2);
            return "";
        }
        return d(context, str, str2);
    }

    public static java.lang.String c(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!com.huawei.hms.hatool.a.b(str, str2)) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(com.huawei.hms.hatool.b.d())) {
            com.huawei.hms.hatool.i.c().b().b(com.huawei.hms.hatool.f.a(context));
        }
        return com.huawei.hms.hatool.b.d();
    }

    public static java.lang.String d(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (!android.text.TextUtils.isEmpty(com.huawei.hms.hatool.c.d(str, str2))) {
            return com.huawei.hms.hatool.c.d(str, str2);
        }
        com.huawei.hms.hatool.l b = com.huawei.hms.hatool.i.c().b();
        if (android.text.TextUtils.isEmpty(b.h())) {
            java.lang.String b2 = com.huawei.hms.hatool.f.b(context);
            if (!com.huawei.hms.hatool.s0.a("channel", b2, 256)) {
                b2 = "";
            }
            b.f(b2);
        }
        return b.h();
    }
}
