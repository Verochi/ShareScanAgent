package com.jd.ad.sdk.jad_tg;

/* loaded from: classes23.dex */
public class jad_an {
    public static final java.util.List<java.lang.String> jad_an = new java.util.ArrayList();
    public static final java.util.List<java.lang.String> jad_bo = new java.util.ArrayList();

    /* renamed from: com.jd.ad.sdk.jad_tg.jad_an$jad_an, reason: collision with other inner class name */
    public class RunnableC0410jad_an implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                com.jd.ad.sdk.jad_tg.jad_an.jad_an(com.jd.ad.sdk.jad_tg.jad_an.jad_an);
            }
        }
    }

    public static android.content.ContentResolver jad_an() {
        try {
            android.app.Application jad_an2 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
            if (jad_an2 != null) {
                return jad_an2.getContentResolver();
            }
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static android.content.ContentValues jad_an(com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar) {
        android.content.ContentValues contentValues;
        try {
            contentValues = new android.content.ContentValues();
        } catch (java.lang.Exception e) {
            e = e;
            contentValues = null;
        }
        try {
            contentValues.put("appIdSlotId", jad_cpVar.jad_cp);
            contentValues.put("rId", jad_cpVar.jad_bo);
            contentValues.put("preloadAdJson", com.jd.ad.sdk.fdt.utils.ANEProxy.ja(jad_cpVar.jad_dq));
            contentValues.put("preloadAdCacheTimeStamp", jad_cpVar.jad_er);
        } catch (java.lang.Exception e2) {
            e = e2;
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while add preload data:");
            jad_an2.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.w(jad_an2.toString(), new java.lang.Object[0]);
            return contentValues;
        }
        return contentValues;
    }

    public static java.lang.String jad_an(android.net.Uri uri) {
        java.lang.String[] split;
        if (uri == null) {
            return "";
        }
        try {
            return (android.text.TextUtils.isEmpty(uri.getPath()) || (split = uri.getPath().split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) == null || split.length < 2) ? "" : split[1];
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d8, code lost:
    
        if (r2.isClosed() == false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized java.util.List<com.jd.ad.sdk.jad_kx.jad_cp> jad_an(java.lang.String str) {
        android.content.ContentResolver jad_an2;
        synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
            java.lang.String str2 = jad_bo() + "db_preload_ad" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "query" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            ((java.util.ArrayList) jad_an).clear();
            android.database.Cursor cursor = null;
            try {
                jad_an2 = jad_an();
            } catch (java.lang.Throwable th) {
                try {
                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            }
            if (jad_an2 == null) {
                return arrayList;
            }
            cursor = jad_an2.query(android.net.Uri.parse(str2), null, null, null, "preloadAdCacheTimeStamp ASC");
            if (cursor != null && cursor.getCount() > 0) {
                long currentTimeMillis = java.lang.System.currentTimeMillis() - (com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_bo() * 1000);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    int i = cursor.getInt(cursor.getColumnIndex("_id"));
                    java.lang.String string = cursor.getString(cursor.getColumnIndex("appIdSlotId"));
                    java.lang.String string2 = cursor.getString(cursor.getColumnIndex("rId"));
                    java.lang.String string3 = cursor.getString(cursor.getColumnIndex("preloadAdCacheTimeStamp"));
                    java.lang.String jb = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(cursor.getString(cursor.getColumnIndex("preloadAdJson")));
                    if (!android.text.TextUtils.isEmpty(jb) && java.lang.Long.parseLong(string3) >= currentTimeMillis) {
                        arrayList.add(new com.jd.ad.sdk.jad_kx.jad_cp(i, string, string2, jb, string3));
                        cursor.moveToNext();
                    }
                    ((java.util.ArrayList) jad_an).add(string2);
                    cursor.moveToNext();
                }
                cursor.close();
            }
            com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_tg.jad_an.RunnableC0410jad_an());
            if (cursor != null) {
            }
            return arrayList;
        }
    }

    public static synchronized void jad_an(java.util.List<java.lang.String> list) {
        android.content.ContentResolver jad_an2;
        synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
            java.lang.String str = jad_bo() + "db_preload_ad" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "remove";
            if (list == null || list.size() == 0) {
                return;
            }
            try {
                jad_an2 = jad_an();
            } catch (java.lang.Throwable th) {
                com.jd.ad.sdk.logger.Logger.w("Exception while clearing preload ad data list:", th.getMessage());
            }
            if (jad_an2 == null) {
                return;
            }
            android.net.Uri parse = android.net.Uri.parse(str);
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                jad_an2.delete(parse, "rId=?", new java.lang.String[]{it.next()});
            }
        }
    }

    public static java.lang.String jad_bo() {
        java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("content://");
        jad_an2.append(com.jd.ad.sdk.jad_qd.jad_jw.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
        jad_an2.append(".JADMultiProvider");
        jad_an2.append(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        return jad_an2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b1, code lost:
    
        if (r9.isClosed() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d5, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d3, code lost:
    
        if (r9.isClosed() == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<com.jd.ad.sdk.jad_ly.jad_cp> jad_bo(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.ContentResolver jad_an2 = jad_an();
        if (jad_an2 == null) {
            return arrayList;
        }
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = jad_an2.query(android.net.Uri.parse(jad_bo() + "db_video_render" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "query" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str), null, null, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    long currentTimeMillis = java.lang.System.currentTimeMillis() - com.sensorsdata.sf.core.SFContextManger.LOCAL_PLAN_OUT_TIME;
                    while (!cursor.isAfterLast()) {
                        int i = cursor.getInt(cursor.getColumnIndex("_id"));
                        java.lang.String string = cursor.getString(cursor.getColumnIndex("videoUrl"));
                        java.lang.String string2 = cursor.getString(cursor.getColumnIndex("videoLocalPath"));
                        java.lang.String string3 = cursor.getString(cursor.getColumnIndex("timeStampInterval"));
                        if (!android.text.TextUtils.isEmpty(string2) && (arrayList.size() <= 1 || java.lang.Long.parseLong(string3) >= currentTimeMillis)) {
                            arrayList.add(new com.jd.ad.sdk.jad_ly.jad_cp(i, str, string, string2, string3));
                        }
                        cursor.moveToNext();
                    }
                    cursor.close();
                }
                if (cursor != null) {
                }
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_TEMPLATE_QUERY_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                if (cursor != null) {
                }
            }
            return arrayList;
        } catch (java.lang.Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bb, code lost:
    
        if (r9.isClosed() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00df, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00dd, code lost:
    
        if (r9.isClosed() == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<com.jd.ad.sdk.jad_hu.jad_cp> jad_cp(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.content.ContentResolver jad_an2 = jad_an();
        if (jad_an2 == null) {
            return arrayList;
        }
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = jad_an2.query(android.net.Uri.parse(jad_bo() + "db_dynamic_render" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "query" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + str), null, null, null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    long currentTimeMillis = java.lang.System.currentTimeMillis() - com.sensorsdata.sf.core.SFContextManger.LOCAL_PLAN_OUT_TIME;
                    while (!cursor.isAfterLast()) {
                        int i = cursor.getInt(cursor.getColumnIndex("_id"));
                        int i2 = cursor.getInt(cursor.getColumnIndex("templateID"));
                        java.lang.String string = cursor.getString(cursor.getColumnIndex("templateUpdateTimeStamp"));
                        java.lang.String string2 = cursor.getString(cursor.getColumnIndex("templateJSON"));
                        java.lang.String string3 = cursor.getString(cursor.getColumnIndex("timeStampInterval"));
                        if (!android.text.TextUtils.isEmpty(string2) && (arrayList.size() <= 1 || java.lang.Long.parseLong(string3) >= currentTimeMillis)) {
                            arrayList.add(new com.jd.ad.sdk.jad_hu.jad_cp(i, str, i2, string, string2, string3));
                        }
                        cursor.moveToNext();
                    }
                    cursor.close();
                }
                if (cursor != null) {
                }
            } catch (java.lang.Exception e) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_TEMPLATE_QUERY_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
                if (cursor != null) {
                }
            }
            return arrayList;
        } catch (java.lang.Throwable th) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
    }
}
