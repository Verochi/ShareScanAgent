package com.jd.ad.sdk.jad_ud;

/* loaded from: classes23.dex */
public class jad_fs {

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_ud.jad_er jad_an;

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_ud.jad_bo jad_bo;

    public jad_fs(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ud.jad_er jad_erVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ud.jad_bo jad_boVar) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_boVar;
    }

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_an(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3) {
        com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar;
        com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_an;
        if (str2 == null) {
            str2 = com.baidu.mobads.sdk.internal.am.d;
        }
        if (str2.contains("application/zip") || str.split("\\?")[0].endsWith(".lottie")) {
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
            jad_cpVar = com.jd.ad.sdk.jad_ud.jad_cp.ZIP;
            jad_an = str3 == null ? com.jd.ad.sdk.jad_lu.jad_hu.jad_an(new java.util.zip.ZipInputStream(inputStream), (java.lang.String) null) : com.jd.ad.sdk.jad_lu.jad_hu.jad_an(new java.util.zip.ZipInputStream(new java.io.FileInputStream(this.jad_an.jad_an(str, inputStream, jad_cpVar))), str);
        } else {
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
            jad_cpVar = com.jd.ad.sdk.jad_ud.jad_cp.JSON;
            jad_an = str3 == null ? com.jd.ad.sdk.jad_lu.jad_hu.jad_an(inputStream, (java.lang.String) null) : com.jd.ad.sdk.jad_lu.jad_hu.jad_an(new java.io.FileInputStream(this.jad_an.jad_an(str, inputStream, jad_cpVar).getAbsolutePath()), str);
        }
        if (str3 != null && jad_an.jad_an != null) {
            com.jd.ad.sdk.jad_ud.jad_er jad_erVar = this.jad_an;
            jad_erVar.getClass();
            java.io.File file = new java.io.File(jad_erVar.jad_an(), com.jd.ad.sdk.jad_ud.jad_er.jad_an(str, jad_cpVar, true));
            java.io.File file2 = new java.io.File(file.getAbsolutePath().replace(com.anythink.china.common.a.a.e, ""));
            boolean renameTo = file.renameTo(file2);
            file2.toString();
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
            if (!renameTo) {
                java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Unable to rename cache file ");
                jad_an2.append(file.getAbsolutePath());
                jad_an2.append(" to ");
                jad_an2.append(file2.getAbsolutePath());
                jad_an2.append(".");
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an(jad_an2.toString());
            }
        }
        return jad_an;
    }
}
