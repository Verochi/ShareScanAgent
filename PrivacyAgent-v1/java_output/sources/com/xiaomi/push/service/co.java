package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class co {
    public final java.lang.String a;
    public final java.lang.String b;
    public final java.lang.String c;
    public final java.lang.String d;
    public final java.lang.String e;
    public final java.lang.String f;
    public final int g;

    public co(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = i;
    }

    private com.xiaomi.push.service.aj.b a(com.xiaomi.push.service.aj.b bVar, android.content.Context context, com.xiaomi.push.service.cf cfVar, java.lang.String str) {
        bVar.a = context.getPackageName();
        bVar.b = this.a;
        bVar.i = this.c;
        bVar.c = this.b;
        bVar.h = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.e = false;
        com.xiaomi.push.jd.a aVar = new com.xiaomi.push.jd.a();
        aVar.a("sdk_ver", 48).a("cpvn", "4_9_0").a("cpvc", 40090).a(com.anythink.expressad.foundation.g.a.bD, com.xiaomi.push.service.d.a(context).b()).a("region", com.xiaomi.push.service.d.a(context).a()).a("miui_vn", com.xiaomi.push.iu.h()).a("miui_vc", java.lang.Integer.valueOf(com.xiaomi.push.iu.g())).a("xmsf_vc", java.lang.Integer.valueOf(com.xiaomi.push.ga.b(context, "com.xiaomi.xmsf"))).a("android_ver", java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT)).a("n_belong_to_app", java.lang.Boolean.valueOf(com.xiaomi.push.service.aa.a(context))).a("systemui_vc", java.lang.Integer.valueOf(com.xiaomi.push.ga.a(context)));
        java.lang.String c = c(context);
        if (!android.text.TextUtils.isEmpty(c)) {
            aVar.a("latest_country_code", c);
        }
        java.lang.String i = com.xiaomi.push.iu.i();
        if (!android.text.TextUtils.isEmpty(i)) {
            aVar.a("device_ch", i);
        }
        java.lang.String j = com.xiaomi.push.iu.j();
        if (!android.text.TextUtils.isEmpty(j)) {
            aVar.a("device_mfr", j);
        }
        bVar.f = aVar.toString();
        java.lang.String str2 = a(context) ? "1000271" : this.d;
        com.xiaomi.push.jd.a aVar2 = new com.xiaomi.push.jd.a();
        aVar2.a("appid", str2).a("locale", java.util.Locale.getDefault().toString()).a("sync", 1);
        if (b(context)) {
            aVar2.a("ab", str);
        }
        bVar.g = aVar2.toString();
        bVar.k = cfVar;
        return bVar;
    }

    private static boolean a() {
        try {
            return com.xiaomi.push.jc.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static boolean a(android.content.Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static boolean b(android.content.Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    private static java.lang.String c(android.content.Context context) {
        if (!"com.xiaomi.xmsf".equals(context)) {
            return com.xiaomi.push.iu.e();
        }
        if (!android.text.TextUtils.isEmpty(null)) {
            return null;
        }
        java.lang.String a = com.xiaomi.push.iu.a("ro.miui.region");
        return android.text.TextUtils.isEmpty(a) ? com.xiaomi.push.iu.a("ro.product.locale.region") : a;
    }

    public final com.xiaomi.push.service.aj.b a(com.xiaomi.push.service.c cVar) {
        com.xiaomi.push.service.aj.b bVar = new com.xiaomi.push.service.aj.b(cVar);
        a(bVar, cVar, cVar.d, "c");
        return bVar;
    }
}
