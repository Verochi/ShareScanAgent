package com.jd.ad.sdk.dl.cache.multiprocess;

/* loaded from: classes23.dex */
public class JADMultiProvider extends android.content.ContentProvider {
    public static com.jd.ad.sdk.jad_hu.jad_bo jad_an;
    public static com.jd.ad.sdk.jad_xk.jad_cp jad_bo;
    public static com.jd.ad.sdk.jad_kx.jad_an jad_cp;
    public static com.jd.ad.sdk.jad_mz.jad_an jad_dq;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public int delete(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        java.lang.String[] split;
        if (uri != null) {
            java.lang.String jad_an2 = com.jd.ad.sdk.jad_tg.jad_an.jad_an(uri);
            if (!android.text.TextUtils.isEmpty(jad_an2)) {
                jad_an2.getClass();
                switch (jad_an2) {
                    case "db_preload_ad":
                        try {
                            if (!android.text.TextUtils.isEmpty(str) && strArr != null) {
                                jad_bo();
                                jad_cp.jad_an(str, strArr);
                                break;
                            }
                        } catch (java.lang.Exception e) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_DELETE_ERROR;
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                            break;
                        }
                        break;
                    case "db_event":
                        try {
                            if (!android.text.TextUtils.isEmpty(str) && strArr != null) {
                                jad_an();
                                jad_bo.jad_an(str, strArr);
                                break;
                            }
                        } catch (java.lang.Exception e2) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_DELETE_EVENT_ERROR;
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
                            break;
                        }
                        break;
                    case "sp_jadyunsdk":
                        try {
                            if (!android.text.TextUtils.isEmpty(uri.getPath()) && (split = uri.getPath().split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) != null && split.length > 4) {
                                com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(split[3]);
                                break;
                            }
                        } catch (java.lang.Exception e3) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_DELETE_SP_ERROR;
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
                            break;
                        }
                        break;
                }
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public java.lang.String getType(@androidx.annotation.NonNull android.net.Uri uri) {
        java.lang.String[] split;
        try {
            if (!android.text.TextUtils.isEmpty(uri.getPath()) && (split = uri.getPath().split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) != null) {
                java.lang.String str = split.length >= 2 ? split[1] : "";
                java.lang.String str2 = split.length >= 3 ? split[2] : "";
                if (!android.text.TextUtils.isEmpty(str) && str.equals("sp_jadyunsdk")) {
                    if (str2.equals(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET)) {
                        if (split.length >= 5) {
                            return (java.lang.String) com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(split[4], java.lang.String.class);
                        }
                    } else if (str2.equals("contain") && split.length >= 4) {
                        return java.lang.String.valueOf(com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an(split[3], false));
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_GET_TYPE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        return "";
    }

    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.net.Uri insert(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues) {
        java.lang.String jad_an2 = com.jd.ad.sdk.jad_tg.jad_an.jad_an(uri);
        if (android.text.TextUtils.isEmpty(jad_an2) || !jad_an2.equals("sp_jadyunsdk") || contentValues == null) {
            return null;
        }
        try {
            com.jd.ad.sdk.jad_uh.jad_bo.jad_an.jad_an.jad_an((java.lang.String) contentValues.get("key"), contentValues.get("value"));
            return null;
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_INSERT_SP_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            return null;
        }
    }

    public final void jad_an() {
        com.jd.ad.sdk.jad_xk.jad_cp jad_cpVar;
        if (jad_bo == null) {
            android.app.Application jad_an2 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
            synchronized (com.jd.ad.sdk.jad_xk.jad_cp.class) {
                if (com.jd.ad.sdk.jad_xk.jad_cp.jad_bo == null) {
                    com.jd.ad.sdk.jad_xk.jad_cp.jad_bo = new com.jd.ad.sdk.jad_xk.jad_cp(jad_an2, "jaddb.db", 2);
                }
                jad_cpVar = com.jd.ad.sdk.jad_xk.jad_cp.jad_bo;
            }
            jad_bo = jad_cpVar;
            jad_cpVar.jad_cp();
        }
    }

    public final void jad_bo() {
        if (jad_cp == null) {
            com.jd.ad.sdk.jad_kx.jad_an jad_dq2 = com.jd.ad.sdk.jad_kx.jad_an.jad_dq();
            jad_cp = jad_dq2;
            jad_dq2.jad_cp();
        }
    }

    public final void jad_cp() {
        if (jad_an == null) {
            com.jd.ad.sdk.jad_hu.jad_bo jad_an2 = com.jd.ad.sdk.jad_hu.jad_bo.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), "jaddb.db", 2);
            jad_an = jad_an2;
            jad_an2.jad_cp();
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    @androidx.annotation.Nullable
    public android.database.Cursor query(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable java.lang.String[] strArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr2, @androidx.annotation.Nullable java.lang.String str2) {
        java.lang.String[] split = uri.getPath().split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        if (split != null) {
            java.lang.String str3 = split.length >= 2 ? split[1] : "";
            java.lang.String str4 = split.length >= 3 ? split[2] : "";
            if (!android.text.TextUtils.isEmpty(str3)) {
                str3.getClass();
                switch (str3) {
                    case "db_video_render":
                        if (!android.text.TextUtils.isEmpty(str4) && str4.equals("query")) {
                            try {
                                if (jad_dq == null) {
                                    com.jd.ad.sdk.jad_mz.jad_an jad_an2 = com.jd.ad.sdk.jad_mz.jad_an.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), "jaddb.db", 2);
                                    jad_dq = jad_an2;
                                    jad_an2.jad_cp();
                                }
                                java.lang.String str5 = split.length >= 4 ? split[3] : "";
                                jad_cp();
                                java.util.List<com.jd.ad.sdk.jad_ly.jad_cp> jad_bo2 = jad_dq.jad_bo(str5);
                                android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(new java.lang.String[]{"_id", "videoUrl", "videoLocalPath", "timeStampInterval"});
                                java.util.ArrayList arrayList = (java.util.ArrayList) jad_bo2;
                                if (arrayList.size() > 0) {
                                    java.util.Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        com.jd.ad.sdk.jad_ly.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_ly.jad_cp) it.next();
                                        if (jad_cpVar != null) {
                                            matrixCursor.addRow(new java.lang.Object[]{java.lang.Integer.valueOf(jad_cpVar.jad_an), jad_cpVar.jad_cp, jad_cpVar.jad_dq, jad_cpVar.jad_er});
                                        }
                                    }
                                }
                                return matrixCursor;
                            } catch (java.lang.Exception e) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_TEMPLATE_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                                break;
                            }
                        }
                        break;
                    case "db_dynamic_render":
                        if (!android.text.TextUtils.isEmpty(str4) && str4.equals("query")) {
                            try {
                                java.lang.String str6 = split.length >= 4 ? split[3] : "";
                                jad_cp();
                                java.util.List<com.jd.ad.sdk.jad_hu.jad_cp> jad_an3 = jad_an.jad_an(str6);
                                android.database.MatrixCursor matrixCursor2 = new android.database.MatrixCursor(new java.lang.String[]{"_id", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"});
                                java.util.ArrayList arrayList2 = (java.util.ArrayList) jad_an3;
                                if (arrayList2.size() > 0) {
                                    java.util.Iterator it2 = arrayList2.iterator();
                                    while (it2.hasNext()) {
                                        com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar2 = (com.jd.ad.sdk.jad_hu.jad_cp) it2.next();
                                        if (jad_cpVar2 != null) {
                                            matrixCursor2.addRow(new java.lang.Object[]{java.lang.Integer.valueOf(jad_cpVar2.jad_an), java.lang.Integer.valueOf(jad_cpVar2.jad_cp), jad_cpVar2.jad_dq, jad_cpVar2.jad_er, jad_cpVar2.jad_fs});
                                        }
                                    }
                                }
                                return matrixCursor2;
                            } catch (java.lang.Exception e2) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_TEMPLATE_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
                                return null;
                            }
                        }
                        break;
                    case "db_preload_ad":
                        if (!android.text.TextUtils.isEmpty(str4) && str4.equals("query")) {
                            try {
                                jad_bo();
                                java.lang.String str7 = split.length >= 4 ? split[3] : "";
                                return !android.text.TextUtils.isEmpty(str7) ? jad_cp.jad_bo(str7) : jad_cp.jad_er();
                            } catch (java.lang.Exception e3) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_QUERY_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
                                return null;
                            }
                        }
                        break;
                    case "db_event":
                        if (!android.text.TextUtils.isEmpty(str4) && "query".equals(str4)) {
                            try {
                                java.lang.String str8 = split.length >= 4 ? split[3] : "";
                                jad_an();
                                return jad_bo.jad_an(str8);
                            } catch (java.lang.Exception e4) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_EVENT_ERROR;
                                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar4.jad_an, jad_anVar4.jad_an(e4.getMessage()));
                                return null;
                            }
                        }
                        break;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public int update(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.Nullable android.content.ContentValues contentValues, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String[] strArr) {
        java.lang.String jad_an2 = com.jd.ad.sdk.jad_tg.jad_an.jad_an(uri);
        if (!android.text.TextUtils.isEmpty(jad_an2)) {
            jad_an2.getClass();
            switch (jad_an2) {
                case "db_dynamic_render":
                    if (contentValues != null) {
                        try {
                            com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_hu.jad_cp(contentValues.getAsInteger("_id").intValue(), contentValues.getAsString("appIdPid"), contentValues.getAsInteger("templateID").intValue(), contentValues.getAsString("templateUpdateTimeStamp"), contentValues.getAsString("templateJSON"), contentValues.getAsString("timeStampInterval"));
                            jad_cp();
                            com.jd.ad.sdk.jad_hu.jad_bo jad_boVar = jad_an;
                            if (jad_boVar != null) {
                                jad_boVar.jad_an(jad_cpVar);
                                break;
                            }
                        } catch (java.lang.Exception e) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_UPDATE_TEMPLATE_ERROR;
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                            break;
                        }
                    }
                    break;
                case "db_preload_ad":
                    if (contentValues != null) {
                        try {
                            jad_bo();
                            if (jad_cp != null) {
                                jad_cp.jad_an(new com.jd.ad.sdk.jad_kx.jad_cp(contentValues.containsKey("_id") ? contentValues.getAsInteger("_id").intValue() : 0, contentValues.getAsString("appIdSlotId"), contentValues.getAsString("rId"), com.jd.ad.sdk.fdt.utils.ANEProxy.jb(contentValues.getAsString("preloadAdJson")), contentValues.getAsString("preloadAdCacheTimeStamp")));
                                break;
                            }
                        } catch (java.lang.Exception e2) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_UPDATE_ERROR;
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e2.getMessage()));
                            break;
                        }
                    }
                    break;
                case "db_event":
                    if (contentValues != null) {
                        try {
                            java.lang.String asString = contentValues.getAsString("event");
                            java.lang.String asString2 = contentValues.getAsString(com.bytedance.pangle.provider.ContentProviderManager.PLUGIN_PROCESS_NAME);
                            int intValue = contentValues.getAsInteger("key").intValue();
                            if (!android.text.TextUtils.isEmpty(asString2) && !android.text.TextUtils.isEmpty(asString)) {
                                new org.json.JSONObject(asString);
                                com.jd.ad.sdk.jad_xk.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_xk.jad_dq(intValue, asString);
                                jad_an();
                                jad_bo.jad_an(jad_dqVar, asString2);
                                break;
                            }
                        } catch (java.lang.Exception e3) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_UPDATE_EVENT_ERROR;
                            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e3.getMessage()));
                            break;
                        }
                    }
                    break;
                case "sp_jadyunsdk":
                    insert(uri, contentValues);
                    break;
            }
        }
        return 0;
    }
}
