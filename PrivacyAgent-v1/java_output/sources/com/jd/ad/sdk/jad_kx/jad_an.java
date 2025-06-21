package com.jd.ad.sdk.jad_kx;

/* loaded from: classes23.dex */
public class jad_an extends com.jd.ad.sdk.jad_sf.jad_an {
    public static com.jd.ad.sdk.jad_kx.jad_an jad_cp;
    public static final java.util.List<java.lang.String> jad_dq = new java.util.ArrayList();
    public final java.util.List<java.lang.String> jad_bo;

    /* renamed from: com.jd.ad.sdk.jad_kx.jad_an$jad_an, reason: collision with other inner class name */
    public class RunnableC0388jad_an implements java.lang.Runnable {
        public RunnableC0388jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.jd.ad.sdk.jad_kx.jad_an jad_anVar = com.jd.ad.sdk.jad_kx.jad_an.this;
            java.util.List<java.lang.String> list = com.jd.ad.sdk.jad_kx.jad_an.jad_dq;
            synchronized (jad_anVar) {
                jad_anVar.jad_an(list);
            }
        }
    }

    public jad_an(android.content.Context context, java.lang.String str, int i) {
        super(context, str, i);
        this.jad_bo = new java.util.ArrayList();
    }

    public static synchronized com.jd.ad.sdk.jad_kx.jad_an jad_dq() {
        com.jd.ad.sdk.jad_kx.jad_an jad_anVar;
        synchronized (com.jd.ad.sdk.jad_kx.jad_an.class) {
            if (jad_cp == null) {
                jad_cp = new com.jd.ad.sdk.jad_kx.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), "jaddb.db", 2);
            }
            jad_anVar = jad_cp;
        }
        return jad_anVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00aa, code lost:
    
        if (r3.isClosed() == false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized java.util.List<com.jd.ad.sdk.jad_kx.jad_cp> jad_an(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursor = null;
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return arrayList;
            }
            cursor = this.jad_an.query("preloadAd", null, "appIdSlotId =?", new java.lang.String[]{java.lang.String.valueOf(str)}, null, null, "preloadAdCacheTimeStamp ASC");
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                long currentTimeMillis = java.lang.System.currentTimeMillis() - (com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_bo() * 1000);
                while (!cursor.isAfterLast()) {
                    int i = cursor.getInt(cursor.getColumnIndex("_id"));
                    java.lang.String string = cursor.getString(cursor.getColumnIndex("preloadAdCacheTimeStamp"));
                    java.lang.String string2 = cursor.getString(cursor.getColumnIndex("rId"));
                    java.lang.String jb = com.jd.ad.sdk.fdt.utils.ANEProxy.jb(cursor.getString(cursor.getColumnIndex("preloadAdJson")));
                    if (!android.text.TextUtils.isEmpty(jb) && java.lang.Long.parseLong(string) >= currentTimeMillis) {
                        arrayList.add(new com.jd.ad.sdk.jad_kx.jad_cp(i, str, string2, jb, string));
                        cursor.moveToNext();
                    }
                    ((java.util.ArrayList) jad_dq).add(string2);
                    cursor.moveToNext();
                }
                cursor.close();
                com.jd.ad.sdk.fdt.thread.WorkExecutor.execute(new com.jd.ad.sdk.jad_kx.jad_an.RunnableC0388jad_an());
            }
        } catch (java.lang.Throwable th) {
            try {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
                return arrayList;
            } finally {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
    }

    public synchronized void jad_an(com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar) {
        try {
            getWritableDatabase();
        } finally {
        }
        if (jad_bo()) {
            android.content.ContentValues jad_bo = jad_bo(jad_cpVar);
            int i = jad_cpVar.jad_an;
            if (i > 0) {
                this.jad_an.update("preloadAd", jad_bo, "_id=?", new java.lang.String[]{java.lang.String.valueOf(i)});
            } else {
                this.jad_an.insert("preloadAd", null, jad_bo);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r3.inTransaction() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        r2.jad_an.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        if (r3.inTransaction() != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void jad_an(java.lang.String str, java.lang.String[] strArr) {
        try {
            try {
                getWritableDatabase();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.jd.ad.sdk.logger.Logger.w("Exception while clearing events: ", th.getMessage());
                android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.jad_an;
                if (sQLiteDatabase != null) {
                }
            } finally {
                android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = this.jad_an;
                if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                    this.jad_an.endTransaction();
                }
            }
        }
        if (jad_bo()) {
            this.jad_an.beginTransaction();
            this.jad_an.delete("preloadAd", str, strArr);
            this.jad_an.setTransactionSuccessful();
            android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = this.jad_an;
            if (sQLiteDatabase3 != null) {
            }
        }
    }

    public synchronized void jad_an(java.util.List<java.lang.String> list) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        if (list != null) {
            try {
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            if (list.size() != 0) {
                try {
                    getWritableDatabase();
                } catch (java.lang.Throwable th) {
                    try {
                        com.jd.ad.sdk.logger.Logger.w("Exception while clearing preload ad data:", th.getMessage());
                        android.database.sqlite.SQLiteDatabase sQLiteDatabase2 = this.jad_an;
                        if (sQLiteDatabase2 != null && sQLiteDatabase2.inTransaction()) {
                            sQLiteDatabase = this.jad_an;
                        }
                    } finally {
                        android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = this.jad_an;
                        if (sQLiteDatabase3 != null && sQLiteDatabase3.inTransaction()) {
                            this.jad_an.endTransaction();
                        }
                    }
                }
                if (jad_bo()) {
                    this.jad_an.beginTransaction();
                    java.util.Iterator<java.lang.String> it = list.iterator();
                    while (it.hasNext()) {
                        this.jad_an.delete("preloadAd", "rId=?", new java.lang.String[]{it.next()});
                    }
                    this.jad_an.setTransactionSuccessful();
                    android.database.sqlite.SQLiteDatabase sQLiteDatabase4 = this.jad_an;
                    if (sQLiteDatabase4 != null && sQLiteDatabase4.inTransaction()) {
                        sQLiteDatabase = this.jad_an;
                        sQLiteDatabase.endTransaction();
                    }
                }
            }
        }
    }

    public final android.content.ContentValues jad_bo(com.jd.ad.sdk.jad_kx.jad_cp jad_cpVar) {
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
            com.jd.ad.sdk.logger.Logger.w("Exception while add preload ad data: ", e.getMessage());
            return contentValues;
        }
        return contentValues;
    }

    public synchronized android.database.Cursor jad_bo(java.lang.String str) {
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("preloadAd", null, "appIdSlotId =?", new java.lang.String[]{java.lang.String.valueOf(str)}, null, null, "preloadAdCacheTimeStamp ASC");
        } catch (java.lang.Throwable th) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
            return null;
        }
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (jad_bo()) {
                this.jad_an.execSQL(java.lang.String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", "preloadAd", "appIdSlotId", "rId", "preloadAdJson", "preloadAdCacheTimeStamp"));
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    public synchronized android.database.Cursor jad_er() {
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("preloadAd", null, null, null, null, null, "preloadAdCacheTimeStamp ASC");
        } catch (java.lang.Throwable th) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_QUERY_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(th.getMessage()));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        this.jad_an = sQLiteDatabase;
        try {
            sQLiteDatabase.execSQL(java.lang.String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT,%s TEXT, %s TEXT)", "preloadAd", "appIdSlotId", "rId", "preloadAdJson", "preloadAdCacheTimeStamp"));
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_PRELOAD_AD_CREATE_DB_TABLE_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preloadAd");
        onCreate(sQLiteDatabase);
    }
}
