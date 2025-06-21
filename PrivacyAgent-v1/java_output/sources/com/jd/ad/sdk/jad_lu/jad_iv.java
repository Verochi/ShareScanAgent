package com.jd.ad.sdk.jad_lu;

/* loaded from: classes23.dex */
public class jad_iv implements java.util.concurrent.Callable<com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt>> {
    public final /* synthetic */ android.content.Context jad_an;
    public final /* synthetic */ java.lang.String jad_bo;
    public final /* synthetic */ java.lang.String jad_cp;

    public jad_iv(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.jad_an = context;
        this.jad_bo = str;
        this.jad_cp = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ce  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> call() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar;
        com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_sfVar;
        java.lang.String str;
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar2;
        android.util.Pair pair;
        java.io.File file;
        com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar;
        com.jd.ad.sdk.jad_ud.jad_er jad_erVar;
        android.content.Context context = this.jad_an;
        com.jd.ad.sdk.jad_ud.jad_fs jad_fsVar = com.jd.ad.sdk.jad_lu.jad_dq.jad_bo;
        if (jad_fsVar == null) {
            synchronized (com.jd.ad.sdk.jad_ud.jad_fs.class) {
                jad_fsVar = com.jd.ad.sdk.jad_lu.jad_dq.jad_bo;
                if (jad_fsVar == null) {
                    android.content.Context applicationContext = context.getApplicationContext();
                    com.jd.ad.sdk.jad_ud.jad_er jad_erVar2 = com.jd.ad.sdk.jad_lu.jad_dq.jad_cp;
                    if (jad_erVar2 == null) {
                        synchronized (com.jd.ad.sdk.jad_ud.jad_er.class) {
                            jad_erVar = com.jd.ad.sdk.jad_lu.jad_dq.jad_cp;
                            if (jad_erVar == null) {
                                jad_erVar = new com.jd.ad.sdk.jad_ud.jad_er(new com.jd.ad.sdk.jad_lu.jad_cp(applicationContext));
                                com.jd.ad.sdk.jad_lu.jad_dq.jad_cp = jad_erVar;
                            }
                        }
                        jad_erVar2 = jad_erVar;
                    }
                    jad_fsVar = new com.jd.ad.sdk.jad_ud.jad_fs(jad_erVar2, new com.jd.ad.sdk.jad_ud.jad_bo());
                    com.jd.ad.sdk.jad_lu.jad_dq.jad_bo = jad_fsVar;
                }
            }
        }
        java.lang.String str2 = this.jad_bo;
        java.lang.String str3 = this.jad_cp;
        com.jd.ad.sdk.jad_ud.jad_an jad_anVar = null;
        if (str3 != null) {
            com.jd.ad.sdk.jad_ud.jad_er jad_erVar3 = jad_fsVar.jad_an;
            jad_erVar3.getClass();
            try {
                java.io.File jad_an = jad_erVar3.jad_an();
                jad_cpVar = com.jd.ad.sdk.jad_ud.jad_cp.JSON;
                file = new java.io.File(jad_an, com.jd.ad.sdk.jad_ud.jad_er.jad_an(str2, jad_cpVar, false));
                if (!file.exists()) {
                    file = new java.io.File(jad_erVar3.jad_an(), com.jd.ad.sdk.jad_ud.jad_er.jad_an(str2, com.jd.ad.sdk.jad_ud.jad_cp.ZIP, false));
                    if (!file.exists()) {
                        file = null;
                    }
                }
            } catch (java.io.FileNotFoundException unused) {
            }
            if (file == null) {
                pair = null;
                if (pair != null) {
                    com.jd.ad.sdk.jad_ud.jad_cp jad_cpVar2 = (com.jd.ad.sdk.jad_ud.jad_cp) pair.first;
                    java.io.InputStream inputStream = (java.io.InputStream) pair.second;
                    com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar3 = (jad_cpVar2 == com.jd.ad.sdk.jad_ud.jad_cp.ZIP ? com.jd.ad.sdk.jad_lu.jad_hu.jad_an(new java.util.zip.ZipInputStream(inputStream), str2) : com.jd.ad.sdk.jad_lu.jad_hu.jad_an(inputStream, str2)).jad_an;
                    if (jad_jtVar3 != null) {
                        jad_jtVar = jad_jtVar3;
                        if (jad_jtVar == null) {
                            jad_sfVar = new com.jd.ad.sdk.jad_lu.jad_sf<>(jad_jtVar);
                        } else {
                            com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
                            com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
                            try {
                                try {
                                    com.jd.ad.sdk.jad_ud.jad_an jad_an2 = jad_fsVar.jad_bo.jad_an(str2);
                                    if (jad_an2.jad_cp()) {
                                        jad_sfVar = jad_fsVar.jad_an(str2, jad_an2.jad_an.getInputStream(), jad_an2.jad_an.getContentType(), str3);
                                        com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
                                    } else {
                                        jad_sfVar = new com.jd.ad.sdk.jad_lu.jad_sf<>(new java.lang.IllegalArgumentException(jad_an2.jad_bo()));
                                    }
                                    try {
                                        jad_an2.jad_an.disconnect();
                                    } catch (java.io.IOException e) {
                                        com.jd.ad.sdk.jad_xg.jad_dq.jad_an("LottieFetchResult close failed ", e);
                                    }
                                } catch (java.lang.Throwable th) {
                                    if (0 != 0) {
                                        try {
                                            jad_anVar.jad_an.disconnect();
                                        } catch (java.io.IOException e2) {
                                            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("LottieFetchResult close failed ", e2);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (java.lang.Exception e3) {
                                com.jd.ad.sdk.jad_lu.jad_sf<com.jd.ad.sdk.jad_lu.jad_jt> jad_sfVar2 = new com.jd.ad.sdk.jad_lu.jad_sf<>(e3);
                                if (0 != 0) {
                                    try {
                                        jad_anVar.jad_an.disconnect();
                                    } catch (java.io.IOException e4) {
                                        com.jd.ad.sdk.jad_xg.jad_dq.jad_an("LottieFetchResult close failed ", e4);
                                    }
                                }
                                jad_sfVar = jad_sfVar2;
                            }
                        }
                        str = this.jad_cp;
                        if (str != null && (jad_jtVar2 = jad_sfVar.jad_an) != null) {
                            com.jd.ad.sdk.jad_qz.jad_jt.jad_bo.jad_an(str, jad_jtVar2);
                        }
                        return jad_sfVar;
                    }
                }
            } else {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                if (file.getAbsolutePath().endsWith(".zip")) {
                    jad_cpVar = com.jd.ad.sdk.jad_ud.jad_cp.ZIP;
                }
                file.getAbsolutePath();
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an.getClass();
                pair = new android.util.Pair(jad_cpVar, fileInputStream);
                if (pair != null) {
                }
            }
        }
        jad_jtVar = null;
        if (jad_jtVar == null) {
        }
        str = this.jad_cp;
        if (str != null) {
            com.jd.ad.sdk.jad_qz.jad_jt.jad_bo.jad_an(str, jad_jtVar2);
        }
        return jad_sfVar;
    }
}
