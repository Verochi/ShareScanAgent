package com.jd.ad.sdk.bl.video.db;

/* loaded from: classes23.dex */
public class SplashRenderVideoHelper {
    private static com.jd.ad.sdk.jad_mz.jad_an sDataBaseVideoStorage;
    private final java.lang.String mAppIdPid;
    private java.util.List<com.jd.ad.sdk.jad_ly.jad_cp> mRenderVideoList;

    public class jad_an implements java.lang.Runnable {
        public final /* synthetic */ android.content.Context jad_an;

        public jad_an(android.content.Context context) {
            this.jad_an = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper.isFbdr() && com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(this.jad_an) && com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper.sDataBaseVideoStorage == null) {
                com.jd.ad.sdk.jad_mz.jad_an unused = com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper.sDataBaseVideoStorage = com.jd.ad.sdk.jad_mz.jad_an.jad_an(this.jad_an, "jaddb.db", 2);
                com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper.sDataBaseVideoStorage.jad_cp();
            }
        }
    }

    public class jad_bo implements java.lang.Runnable {
        public final /* synthetic */ com.jd.ad.sdk.jad_ly.jad_cp jad_an;

        public jad_bo(com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper splashRenderVideoHelper, com.jd.ad.sdk.jad_ly.jad_cp jad_cpVar) {
            this.jad_an = jad_cpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                com.jd.ad.sdk.jad_mz.jad_an jad_anVar = com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper.sDataBaseVideoStorage;
                com.jd.ad.sdk.jad_ly.jad_cp jad_cpVar = this.jad_an;
                synchronized (jad_anVar) {
                    if (jad_cpVar != null) {
                        try {
                            jad_anVar.getWritableDatabase();
                            if (jad_anVar.jad_bo()) {
                                android.content.ContentValues jad_an = jad_anVar.jad_an(jad_cpVar);
                                if (jad_cpVar.jad_an > 0) {
                                    jad_anVar.jad_an.update("splashVideo", jad_an, "_id=?", new java.lang.String[]{java.lang.String.valueOf(jad_cpVar)});
                                } else {
                                    jad_anVar.jad_an.insert("splashVideo", null, jad_an);
                                }
                                jad_anVar.jad_an(jad_cpVar.jad_bo);
                            }
                        } finally {
                        }
                    }
                }
                return;
            }
            com.jd.ad.sdk.jad_ly.jad_cp jad_cpVar2 = this.jad_an;
            java.util.List<java.lang.String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
            if (jad_cpVar2 == null) {
                return;
            }
            try {
                android.content.ContentResolver jad_an2 = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                if (jad_an2 == null) {
                    return;
                }
                android.net.Uri parse = android.net.Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_video_render" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "update");
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("_id", java.lang.Integer.valueOf(jad_cpVar2.jad_an));
                contentValues.put("appIdPid", jad_cpVar2.jad_bo);
                java.lang.String ja = com.jd.ad.sdk.fdt.utils.ANEProxy.ja(jad_cpVar2.jad_cp);
                java.lang.String ja2 = com.jd.ad.sdk.fdt.utils.ANEProxy.ja(jad_cpVar2.jad_dq);
                contentValues.put("videoUrl", ja);
                contentValues.put("videoLocalPath", ja2);
                jad_an2.update(parse, contentValues, null, null);
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.logger.Logger.w("Exception while multi process update template: ", e.getMessage());
            }
        }
    }

    public SplashRenderVideoHelper(android.content.Context context, java.lang.String str) {
        this.mAppIdPid = str;
        if (!com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(context)) {
            this.mRenderVideoList = com.jd.ad.sdk.jad_tg.jad_an.jad_bo(str);
            return;
        }
        if (sDataBaseVideoStorage == null) {
            com.jd.ad.sdk.jad_mz.jad_an jad_an2 = com.jd.ad.sdk.jad_mz.jad_an.jad_an(context, "jaddb.db", 2);
            sDataBaseVideoStorage = jad_an2;
            jad_an2.jad_cp();
        }
        this.mRenderVideoList = sDataBaseVideoStorage.jad_bo(str);
    }

    public static void init(android.content.Context context) {
        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper.jad_an(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isFbdr() {
        com.jd.ad.sdk.jad_pc.jad_an jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        return jad_an2 != null && "1".equals(jad_an2.jad_tg);
    }

    public com.jd.ad.sdk.jad_ly.jad_cp getStorageVideoByUrl(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.RENDER_SPLASH_VIDEO_GW_RESPONSE_URL_NULL_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", 10, jad_anVar.jad_an, jad_anVar.jad_an(new java.lang.String[0]), 0);
            return null;
        }
        android.app.Application jad_an2 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        if (jad_an2 != null) {
            if (com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(jad_an2)) {
                if (sDataBaseVideoStorage == null) {
                    com.jd.ad.sdk.jad_mz.jad_an jad_an3 = com.jd.ad.sdk.jad_mz.jad_an.jad_an(jad_an2, "jaddb.db", 2);
                    sDataBaseVideoStorage = jad_an3;
                    jad_an3.jad_cp();
                }
                this.mRenderVideoList = sDataBaseVideoStorage.jad_bo(this.mAppIdPid);
            } else {
                this.mRenderVideoList = com.jd.ad.sdk.jad_tg.jad_an.jad_bo(this.mAppIdPid);
            }
        }
        java.util.List<com.jd.ad.sdk.jad_ly.jad_cp> list = this.mRenderVideoList;
        if (list != null && list.size() != 0) {
            for (com.jd.ad.sdk.jad_ly.jad_cp jad_cpVar : this.mRenderVideoList) {
                if (jad_cpVar != null && jad_cpVar.jad_cp.equals(str)) {
                    return jad_cpVar;
                }
            }
        }
        return null;
    }

    public void updateVideoData(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (android.text.TextUtils.isEmpty(str3) || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper.jad_bo(this, new com.jd.ad.sdk.jad_ly.jad_cp(0, str, str2, str3, java.lang.System.currentTimeMillis() + "")));
    }
}
