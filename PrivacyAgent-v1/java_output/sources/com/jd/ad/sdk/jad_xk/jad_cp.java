package com.jd.ad.sdk.jad_xk;

/* loaded from: classes23.dex */
public class jad_cp extends com.jd.ad.sdk.jad_sf.jad_an {
    public static com.jd.ad.sdk.jad_xk.jad_cp jad_bo;

    public jad_cp(android.content.Context context, java.lang.String str, int i) {
        super(context, str, i);
    }

    public synchronized android.database.Cursor jad_an(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            getReadableDatabase();
            if (!jad_bo()) {
                return null;
            }
            return this.jad_an.query("events", null, "process_name =?", new java.lang.String[]{str}, null, null, null);
        } catch (java.lang.Throwable th) {
            com.jd.ad.sdk.logger.Logger.w("Exception while loading events: ", th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003a -> B:19:0x0047). Please report as a decompilation issue!!! */
    public synchronized void jad_an(com.jd.ad.sdk.jad_xk.jad_dq jad_dqVar, java.lang.String str) {
        if (jad_dqVar != null) {
            boolean isEmpty = android.text.TextUtils.isEmpty(str);
            if (!isEmpty) {
                isEmpty = false;
                isEmpty = false;
                isEmpty = false;
                int i = 1;
                try {
                    getWritableDatabase();
                    if (!jad_bo()) {
                        return;
                    }
                    android.content.ContentValues jad_bo2 = jad_bo(jad_dqVar, str);
                    int i2 = jad_dqVar.jad_an;
                    if (i2 > 0) {
                        this.jad_an.update("events", jad_bo2, "_id=?", new java.lang.String[]{java.lang.String.valueOf(i2)});
                    } else {
                        this.jad_an.insert("events", null, jad_bo2);
                    }
                } catch (java.lang.Throwable th) {
                    java.lang.Object[] objArr = new java.lang.Object[i];
                    objArr[isEmpty ? 1 : 0] = th;
                    com.jd.ad.sdk.logger.Logger.w("Exception while saving events: ", objArr);
                }
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
                com.jd.ad.sdk.logger.Logger.w("Exception while clearing event: ", th.getMessage());
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
            this.jad_an.delete("events", str, strArr);
            this.jad_an.setTransactionSuccessful();
            android.database.sqlite.SQLiteDatabase sQLiteDatabase3 = this.jad_an;
            if (sQLiteDatabase3 != null) {
            }
        }
    }

    public final android.content.ContentValues jad_bo(com.jd.ad.sdk.jad_xk.jad_dq jad_dqVar, java.lang.String str) {
        android.content.ContentValues contentValues;
        byte[] bytes;
        try {
            contentValues = new android.content.ContentValues(4);
        } catch (java.lang.Exception e) {
            e = e;
            contentValues = null;
        }
        try {
            java.lang.String jSONObject = jad_dqVar.jad_an().toString();
            if (!android.text.TextUtils.isEmpty(jSONObject)) {
                java.lang.String ja = com.jd.ad.sdk.fdt.utils.ANEProxy.ja(jSONObject);
                if (!android.text.TextUtils.isEmpty(ja) && (bytes = ja.getBytes(java.nio.charset.StandardCharsets.UTF_8)) != null && bytes.length > 0) {
                    contentValues.put("event", new java.lang.String(bytes));
                    if (!android.text.TextUtils.isEmpty(str)) {
                        contentValues.put(com.bytedance.pangle.provider.ContentProviderManager.PLUGIN_PROCESS_NAME, str);
                    }
                }
                return contentValues;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            com.jd.ad.sdk.logger.Logger.w("Exception while add event: ", e.getMessage());
            return contentValues;
        }
        return contentValues;
    }

    public void jad_cp() {
        try {
            getWritableDatabase();
            if (jad_bo()) {
                this.jad_an.execSQL(java.lang.String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,%s ,%s)", "events", "event", com.bytedance.pangle.provider.ContentProviderManager.PLUGIN_PROCESS_NAME));
            }
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_CREATE_DB_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(java.lang.String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT,%s,%s)", "events", "event", com.bytedance.pangle.provider.ContentProviderManager.PLUGIN_PROCESS_NAME));
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.CACHE_CREATE_DB_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
        }
        this.jad_an = sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }
}
