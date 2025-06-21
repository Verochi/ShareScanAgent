package com.getui.gtc.extension.distribution.gbd.g;

/* loaded from: classes22.dex */
public final class b {
    private static final java.lang.String a = "GBDGBDUrl";
    private static final java.lang.String b = "getConfigServiceUrl";
    private static final java.lang.String c = "getBiUploadServiceUrl";
    private static final java.lang.String d = "com.igexin.push.config.SDKUrlConfig";

    public static java.lang.String a() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.ay)) {
            com.getui.gtc.extension.distribution.gbd.d.h.ay = com.getui.gtc.extension.distribution.gbd.d.i.b() + "&d=" + com.getui.gtc.extension.distribution.gbd.n.y.e(com.getui.gtc.extension.distribution.gbd.d.c.e) + "&k=" + (android.os.Build.VERSION.SDK_INT < 28 ? 2 : 3);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, " bi new url: " + com.getui.gtc.extension.distribution.gbd.d.h.ay);
        return com.getui.gtc.extension.distribution.gbd.d.h.ay;
    }

    private static java.lang.String b() {
        return com.getui.gtc.extension.distribution.gbd.d.i.b();
    }

    private static java.lang.String c() {
        return com.getui.gtc.extension.distribution.gbd.d.i.a();
    }
}
