package com.alipay.sdk.m.c;

/* loaded from: classes.dex */
public class a {
    public static final java.lang.String a = "ro.build.version.emui";
    public static final java.lang.String b = "hw_sc.build.platform.version";

    public static com.alipay.sdk.m.b.b a(android.content.Context context) {
        java.lang.String str = android.os.Build.BRAND;
        com.alipay.sdk.m.d.a.b("Device", "Brand", str);
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HW) || str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HON) || str.equalsIgnoreCase("华为")) {
            return new com.alipay.sdk.m.c.b();
        }
        if (str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new com.alipay.sdk.m.c.i();
        }
        if (str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_VIVO)) {
            return new com.alipay.sdk.m.c.h();
        }
        if (str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_OPPO) || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new com.alipay.sdk.m.c.f();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new com.alipay.sdk.m.c.c();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new com.alipay.sdk.m.c.e();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new com.alipay.sdk.m.c.g();
        }
        if (a()) {
            return new com.alipay.sdk.m.c.b();
        }
        if (str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_MZ) || str.equalsIgnoreCase("mblu")) {
            return new com.alipay.sdk.m.c.d();
        }
        return null;
    }

    public static java.lang.String a(java.lang.String str) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(null, str);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        return (android.text.TextUtils.isEmpty(a(a)) && android.text.TextUtils.isEmpty(a(b))) ? false : true;
    }
}
