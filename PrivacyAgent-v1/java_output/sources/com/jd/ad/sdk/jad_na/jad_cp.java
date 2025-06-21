package com.jd.ad.sdk.jad_na;

/* loaded from: classes23.dex */
public class jad_cp {
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> jad_an = new java.util.concurrent.ConcurrentHashMap<>();
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.jd.ad.sdk.dl.model.IJADExtra> jad_bo = new java.util.concurrent.ConcurrentHashMap<>();

    public static class jad_an {
        public static final com.jd.ad.sdk.jad_na.jad_cp jad_an = new com.jd.ad.sdk.jad_na.jad_cp();
    }

    public java.lang.String jad_an(java.lang.String str) {
        java.lang.String str2 = this.jad_an.get(str);
        return android.text.TextUtils.isEmpty(str2) ? "" : str2;
    }
}
