package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bc {
    @android.annotation.SuppressLint({"SuspiciousIndentation"})
    public static com.umeng.analytics.pro.az a() {
        java.lang.String str = android.os.Build.BRAND;
        com.umeng.analytics.pro.bn.a("Device", "Brand", str);
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.umeng.analytics.pro.bm.b()) {
            return new com.umeng.analytics.pro.bd();
        }
        if (com.umeng.analytics.pro.bm.d()) {
            return new com.umeng.analytics.pro.be();
        }
        if (str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new com.umeng.analytics.pro.bl();
        }
        if (str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_VIVO)) {
            return new com.umeng.analytics.pro.bk();
        }
        if (str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_OPPO) || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new com.umeng.analytics.pro.bi();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new com.umeng.analytics.pro.bf();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new com.umeng.analytics.pro.bh();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new com.umeng.analytics.pro.bj();
        }
        if (str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_MZ) || str.equalsIgnoreCase("mblu") || com.umeng.analytics.pro.bm.a()) {
            return new com.umeng.analytics.pro.bg();
        }
        if (com.umeng.analytics.pro.bm.e()) {
            return new com.umeng.analytics.pro.bb();
        }
        return null;
    }

    public static com.umeng.analytics.pro.az b() {
        return new com.umeng.analytics.pro.bd();
    }
}
