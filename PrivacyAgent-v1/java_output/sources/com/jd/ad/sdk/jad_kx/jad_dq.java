package com.jd.ad.sdk.jad_kx;

/* loaded from: classes23.dex */
public class jad_dq implements java.lang.Runnable {
    public final /* synthetic */ android.content.Context jad_an;
    public final /* synthetic */ com.jd.ad.sdk.jad_kx.jad_er jad_bo;

    public jad_dq(com.jd.ad.sdk.jad_kx.jad_er jad_erVar, android.content.Context context) {
        this.jad_bo = jad_erVar;
        this.jad_an = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x01d6, code lost:
    
        if (r10.isClosed() == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
    
        if (r9.isClosed() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d8, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d6, code lost:
    
        if (r9.isClosed() == false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0204 A[Catch: all -> 0x024a, TRY_ENTER, TryCatch #6 {, blocks: (B:83:0x0133, B:84:0x013c, B:88:0x01fb, B:89:0x01fc, B:100:0x0204, B:101:0x0208, B:103:0x020e, B:105:0x021e, B:107:0x0223, B:146:0x0248, B:147:0x0249, B:86:0x013d, B:116:0x01d2, B:118:0x01f8, B:133:0x01f2, B:138:0x023d, B:140:0x0243, B:141:0x0246, B:131:0x01db), top: B:82:0x0133, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e2 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4 A[Catch: all -> 0x012b, TRY_ENTER, TryCatch #8 {, blocks: (B:12:0x0036, B:13:0x003b, B:20:0x00db, B:21:0x00dc, B:33:0x00e4, B:34:0x00e8, B:36:0x00ee, B:38:0x00fe, B:40:0x0103, B:76:0x0129, B:77:0x012a, B:15:0x003c, B:56:0x00b0, B:58:0x00d8, B:63:0x00d2, B:68:0x011e, B:70:0x0124, B:71:0x0127, B:61:0x00bb), top: B:11:0x0036, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0202 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        java.util.LinkedHashMap linkedHashMap;
        java.util.ArrayList arrayList;
        android.database.Cursor cursor;
        android.database.Cursor cursor2;
        java.util.LinkedHashMap linkedHashMap2;
        java.util.ArrayList arrayList2;
        this.jad_bo.jad_jt = com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(this.jad_an);
        com.jd.ad.sdk.jad_kx.jad_er jad_erVar = this.jad_bo;
        if (jad_erVar.jad_bo == null) {
            jad_erVar.jad_bo = com.jd.ad.sdk.jad_kx.jad_fs.jad_an.jad_an;
        }
        java.util.LinkedHashMap linkedHashMap3 = null;
        if (jad_erVar.jad_jt) {
            if (jad_erVar.jad_an == null) {
                jad_erVar.jad_an = com.jd.ad.sdk.jad_kx.jad_an.jad_dq();
                this.jad_bo.jad_an.jad_cp();
            }
            com.jd.ad.sdk.jad_kx.jad_er jad_erVar2 = this.jad_bo;
            com.jd.ad.sdk.jad_kx.jad_fs jad_fsVar = jad_erVar2.jad_bo;
            com.jd.ad.sdk.jad_kx.jad_an jad_anVar = jad_erVar2.jad_an;
            synchronized (jad_anVar) {
                linkedHashMap2 = new java.util.LinkedHashMap();
                synchronized (jad_anVar) {
                    arrayList2 = new java.util.ArrayList();
                    try {
                        jad_anVar.getReadableDatabase();
                        if (jad_anVar.jad_bo()) {
                            cursor2 = jad_anVar.jad_an.query("preloadAd", null, null, null, null, null, "preloadAdCacheTimeStamp ASC");
                            try {
                                if (cursor2.getCount() > 0) {
                                    cursor2.moveToFirst();
                                    while (!cursor2.isAfterLast()) {
                                        arrayList2.add(new com.jd.ad.sdk.jad_kx.jad_cp(cursor2.getInt(cursor2.getColumnIndex("_id")), cursor2.getString(cursor2.getColumnIndex("appIdSlotId")), cursor2.getString(cursor2.getColumnIndex("rId")), com.jd.ad.sdk.fdt.utils.ANEProxy.jb(cursor2.getString(cursor2.getColumnIndex("preloadAdJson"))), cursor2.getString(cursor2.getColumnIndex("preloadAdCacheTimeStamp"))));
                                        cursor2.moveToNext();
                                    }
                                    cursor2.close();
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                try {
                                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(th.getMessage()));
                                    if (cursor2 != null) {
                                    }
                                    if (arrayList2.size() <= 0) {
                                    }
                                    jad_fsVar.getClass();
                                    if (linkedHashMap3 == null) {
                                    }
                                } finally {
                                    if (cursor2 != null && !cursor2.isClosed()) {
                                        cursor2.close();
                                    }
                                }
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        cursor2 = null;
                    }
                }
                jad_fsVar.getClass();
                if (linkedHashMap3 == null || linkedHashMap3.size() <= 0) {
                    return;
                }
                jad_fsVar.jad_an = linkedHashMap3;
                return;
            }
            if (arrayList2.size() <= 0) {
                java.util.Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_kx.jad_cp) it.next();
                    java.lang.String str = jad_cpVar.jad_cp;
                    java.util.ArrayList arrayList3 = (java.util.ArrayList) linkedHashMap2.get(str);
                    if (arrayList3 == null) {
                        arrayList3 = new java.util.ArrayList();
                    }
                    arrayList3.add(jad_cpVar);
                    linkedHashMap2.put(str, arrayList3);
                }
                linkedHashMap3 = linkedHashMap2;
            }
            jad_fsVar.getClass();
            if (linkedHashMap3 == null) {
                return;
            } else {
                return;
            }
        }
        com.jd.ad.sdk.jad_kx.jad_fs jad_fsVar2 = jad_erVar.jad_bo;
        synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
            java.util.List<java.lang.String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
            linkedHashMap = new java.util.LinkedHashMap();
            synchronized (com.jd.ad.sdk.jad_tg.jad_an.class) {
                java.lang.String str2 = com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_preload_ad" + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + "query";
                arrayList = new java.util.ArrayList();
                android.content.ContentResolver jad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                if (jad_an != null) {
                    try {
                        cursor = jad_an.query(android.net.Uri.parse(str2), null, null, null, "preloadAdCacheTimeStamp ASC");
                        if (cursor != null) {
                            try {
                                if (cursor.getCount() > 0) {
                                    cursor.moveToFirst();
                                    while (!cursor.isAfterLast()) {
                                        arrayList.add(new com.jd.ad.sdk.jad_kx.jad_cp(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("appIdSlotId")), cursor.getString(cursor.getColumnIndex("rId")), com.jd.ad.sdk.fdt.utils.ANEProxy.jb(cursor.getString(cursor.getColumnIndex("preloadAdJson"))), cursor.getString(cursor.getColumnIndex("preloadAdCacheTimeStamp"))));
                                        cursor.moveToNext();
                                    }
                                    cursor.close();
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                try {
                                    com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                                    com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(th.getMessage()));
                                    if (arrayList.size() <= 0) {
                                    }
                                    jad_fsVar2.getClass();
                                    if (linkedHashMap3 == null) {
                                    }
                                } finally {
                                    if (cursor2 != null && !cursor2.isClosed()) {
                                        cursor2.close();
                                    }
                                }
                            }
                        }
                        if (cursor != null) {
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        cursor = null;
                    }
                }
            }
            jad_fsVar2.getClass();
            if (linkedHashMap3 == null || linkedHashMap3.size() <= 0) {
            }
            jad_fsVar2.jad_an = linkedHashMap3;
            return;
        }
        if (arrayList.size() <= 0) {
            java.util.Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar2 = (com.jd.ad.sdk.jad_kx.jad_cp) it2.next();
                java.lang.String str3 = jad_cpVar2.jad_cp;
                java.util.ArrayList arrayList4 = (java.util.ArrayList) linkedHashMap.get(str3);
                if (arrayList4 == null) {
                    arrayList4 = new java.util.ArrayList();
                }
                arrayList4.add(jad_cpVar2);
                linkedHashMap.put(str3, arrayList4);
            }
            linkedHashMap3 = linkedHashMap;
        }
        jad_fsVar2.getClass();
        if (linkedHashMap3 == null) {
        }
    }
}
