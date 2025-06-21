package com.jd.ad.sdk.jad_fq;

/* loaded from: classes23.dex */
public final class jad_kx {
    public static final java.lang.String[] jad_an = {com.igexin.assist.util.AssistUtils.BRAND_HW};
    public static final java.lang.String[] jad_bo = {com.igexin.assist.util.AssistUtils.BRAND_XIAOMI};
    public static final java.lang.String[] jad_cp = {com.igexin.assist.util.AssistUtils.BRAND_OPPO};
    public static final java.lang.String[] jad_dq = {"oneplus"};
    public static final java.lang.String[] jad_er = {com.igexin.assist.util.AssistUtils.BRAND_MZ};

    public static boolean jad_an() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            return "harmony".equals(cls.getMethod("getOsBrand", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0]));
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
