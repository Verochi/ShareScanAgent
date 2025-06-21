package com.jd.ad.sdk.jad_hu;

/* loaded from: classes23.dex */
public class jad_bo extends com.jd.ad.sdk.jad_sf.jad_an {
    public static com.jd.ad.sdk.jad_hu.jad_bo jad_bo;

    public class jad_an implements java.lang.Runnable {
        public final /* synthetic */ java.util.List jad_an;

        public jad_an(java.util.List list) {
            this.jad_an = list;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
        
            if (r1.inTransaction() != false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007a, code lost:
        
            r1 = r0.jad_an;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
        
            if (r1.inTransaction() != false) goto L33;
         */
        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            com.jd.ad.sdk.jad_hu.jad_bo jad_boVar = com.jd.ad.sdk.jad_hu.jad_bo.this;
            java.util.List list = this.jad_an;
            synchronized (jad_boVar) {
                if (list != null) {
                    try {
                        if (list.size() != 0) {
                            try {
                                jad_boVar.getWritableDatabase();
                            } catch (java.lang.Throwable th) {
                                try {
                                    com.jd.ad.sdk.logger.Logger.w("Exception while clearing templates:", th.getMessage());
                                    android.database.sqlite.SQLiteDatabase sQLiteDatabase = jad_boVar.jad_an;
                                    if (sQLiteDatabase != null) {
                                    }
                                } catch (java.lang.Throwable th2) {
                                    android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = jad_boVar.jad_an;
                                    if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                                        jad_boVar.jad_an.endTransaction();
                                    }
                                    throw th2;
                                }
                            }
                            if (jad_boVar.jad_bo()) {
                                jad_boVar.jad_an.beginTransaction();
                                java.util.Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    jad_boVar.jad_an.delete("lottieTemplate", "_id=?", new java.lang.String[]{java.lang.String.valueOf(((java.lang.Integer) it.next()).intValue())});
                                }
                                jad_boVar.jad_an.setTransactionSuccessful();
                                android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = jad_boVar.jad_an;
                                if (sQLiteDatabase3 != null) {
                                }
                            } else {
                                android.database.sqlite.SQLiteDatabase sQLiteDatabase4 = jad_boVar.jad_an;
                                if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                                    android.database.sqlite.SQLiteDatabase sQLiteDatabase5 = jad_boVar.jad_an;
                                    sQLiteDatabase5.endTransaction();
                                }
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public jad_bo(android.content.Context context, java.lang.String str, int i) {
        super(context, str, i);
    }

    public static synchronized com.jd.ad.sdk.jad_hu.jad_bo jad_an(android.content.Context context, java.lang.String str, int i) {
        com.jd.ad.sdk.jad_hu.jad_bo jad_boVar;
        synchronized (com.jd.ad.sdk.jad_hu.jad_bo.class) {
            if (jad_bo == null) {
                jad_bo = new com.jd.ad.sdk.jad_hu.jad_bo(context, str, i);
            }
            jad_boVar = jad_bo;
        }
        return jad_boVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
    
        if (r5.isClosed() == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized java.util.List<com.jd.ad.sdk.jad_hu.jad_cp> jad_an(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return arrayList;
            }
            cursor = this.jad_an.query("lottieTemplate", null, "appIdPid =?", new java.lang.String[]{java.lang.String.valueOf(str)}, null, null, "timeStampInterval DESC");
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                long currentTimeMillis = java.lang.System.currentTimeMillis() - com.sensorsdata.sf.core.SFContextManger.LOCAL_PLAN_OUT_TIME;
                while (!cursor.isAfterLast()) {
                    int i = cursor.getInt(cursor.getColumnIndex("_id"));
                    int i2 = cursor.getInt(cursor.getColumnIndex("templateID"));
                    java.lang.String string = cursor.getString(cursor.getColumnIndex("templateUpdateTimeStamp"));
                    java.lang.String jb = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(cursor.getString(cursor.getColumnIndex("templateJSON")));
                    java.lang.String string2 = cursor.getString(cursor.getColumnIndex("timeStampInterval"));
                    if (!android.text.TextUtils.isEmpty(jb) && (arrayList.size() <= 1 || java.lang.Long.parseLong(string2) >= currentTimeMillis)) {
                        arrayList.add(new com.jd.ad.sdk.jad_hu.jad_cp(i, str, i2, string, jb, string2));
                        cursor.moveToNext();
                    }
                    arrayList2.add(java.lang.Integer.valueOf(i));
                    cursor.moveToNext();
                }
                cursor.close();
                com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_hu.jad_bo.jad_an(arrayList2));
            }
        } catch (java.lang.Throwable th) {
            try {
                com.jd.ad.sdk.logger.Logger.w("Exception while query templates: " + th.getMessage(), new java.lang.Object[0]);
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_QUERY_TEMPLATE_DB_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
                return arrayList;
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar) {
        if (jad_cpVar != null) {
            try {
                getWritableDatabase();
                if (!jad_bo()) {
                    return;
                }
                android.content.ContentValues jad_bo2 = jad_bo(jad_cpVar);
                int i = jad_cpVar.jad_an;
                if (i > 0) {
                    this.jad_an.update("lottieTemplate", jad_bo2, "_id=?", new java.lang.String[]{java.lang.String.valueOf(i)});
                } else {
                    this.jad_an.insert("lottieTemplate", null, jad_bo2);
                }
            } finally {
            }
        }
    }

    public final android.content.ContentValues jad_bo(com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar) {
        android.content.ContentValues contentValues;
        try {
            contentValues = new android.content.ContentValues();
        } catch (java.lang.Exception e) {
            e = e;
            contentValues = null;
        }
        try {
            contentValues.put("appIdPid", jad_cpVar.jad_bo);
            contentValues.put("templateID", java.lang.Integer.valueOf(jad_cpVar.jad_cp));
            contentValues.put("templateJSON", com.jd.ad.sdk.fdt.utils.ANEProxy.ja(jad_cpVar.jad_er));
            contentValues.put("templateUpdateTimeStamp", jad_cpVar.jad_dq);
            contentValues.put("timeStampInterval", jad_cpVar.jad_fs);
        } catch (java.lang.Exception e2) {
            e = e2;
            com.jd.ad.sdk.logger.Logger.w("Exception while add templates:", e.getMessage());
            return contentValues;
        }
        return contentValues;
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (jad_bo()) {
                this.jad_an.execSQL(java.lang.String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,  %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "lottieTemplate", "appIdPid", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"));
            }
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("dynamic render template sql create error:");
            jad_an2.append(android.util.Log.getStackTraceString(e));
            com.jd.ad.sdk.logger.Logger.d(jad_an2.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(java.lang.String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s TEXT, %s TEXT, %s TEXT)", "lottieTemplate", "appIdPid", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"));
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("dynamic render template sql create error:");
            jad_an2.append(android.util.Log.getStackTraceString(e));
            com.jd.ad.sdk.logger.Logger.d(jad_an2.toString());
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_DYNAMIC_RENDER_CREATE_TEMPLATE_DB_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS lottieTemplate");
        onCreate(sQLiteDatabase);
    }
}
