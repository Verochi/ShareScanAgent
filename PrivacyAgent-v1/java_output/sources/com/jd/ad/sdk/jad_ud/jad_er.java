package com.jd.ad.sdk.jad_ud;

/* loaded from: classes23.dex */
public class jad_er {

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_ud.jad_dq jad_an;

    public jad_er(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ud.jad_dq jad_dqVar) {
        this.jad_an = jad_dqVar;
    }

    public static java.lang.String jad_an(java.lang.String str, com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar, boolean z) {
        java.lang.String str2;
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("lottie_cache_");
        jad_an.append(str.replaceAll("\\W+", ""));
        if (z) {
            jad_cpVar.getClass();
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_lu.jad_zm.jad_an(com.anythink.china.common.a.a.e);
            jad_an2.append(jad_cpVar.jad_an);
            str2 = jad_an2.toString();
        } else {
            str2 = jad_cpVar.jad_an;
        }
        jad_an.append(str2);
        return jad_an.toString();
    }

    public final java.io.File jad_an() {
        com.jd.ad.sdk.jad_lu.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_lu.jad_cp) this.jad_an;
        jad_cpVar.getClass();
        java.io.File file = new java.io.File(jad_cpVar.jad_an.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public java.io.File jad_an(java.lang.String str, java.io.InputStream inputStream, com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar) {
        java.io.File file = new java.io.File(jad_an(), jad_an(str, jad_cpVar, true));
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        fileOutputStream.flush();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }
}
