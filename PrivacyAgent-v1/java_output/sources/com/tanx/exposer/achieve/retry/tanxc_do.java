package com.tanx.exposer.achieve.retry;

/* loaded from: classes19.dex */
public class tanxc_do extends android.database.sqlite.SQLiteOpenHelper {
    public tanxc_do(android.content.Context context) {
        super(context, "tanx_ad_expose_sdk.db", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("RetryMonitorDbHelper", "onCreate: createRetryTableSql = CREATE TABLE IF NOT EXISTS retry_monitor_info ( id INTEGER PRIMARY KEY AUTOINCREMENT, monitor_type VARCHAR(10), monitor_url TEXT, monitor_original_url TEXT, monitor_url_hash TEXT, monitor_url_host TEXT, monitor_extra_params TEXT, retry_times INTEGER, max_retry_times INTEGER, date VARCHAR(12),expire_time INTEGER)");
        }
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS retry_monitor_info ( id INTEGER PRIMARY KEY AUTOINCREMENT, monitor_type VARCHAR(10), monitor_url TEXT, monitor_original_url TEXT, monitor_url_hash TEXT, monitor_url_host TEXT, monitor_extra_params TEXT, retry_times INTEGER, max_retry_times INTEGER, date VARCHAR(12),expire_time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("RetryMonitorDbHelper", "onUpgrade: oldVer = " + i + ", newVer = " + i2);
        }
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS retry_monitor_info");
        onCreate(sQLiteDatabase);
    }

    public synchronized java.util.List<com.tanx.exposer.achieve.tanxc_if> tanxc_do(java.lang.String str) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        android.database.Cursor query = getReadableDatabase().query("retry_monitor_info", null, "date = ?", new java.lang.String[]{str}, null, null, null, null);
        while (query != null) {
            try {
                try {
                    if (!query.moveToNext()) {
                        break;
                    }
                    com.tanx.exposer.achieve.tanxc_if tanxc_ifVar = new com.tanx.exposer.achieve.tanxc_if(query);
                    arrayList.add(tanxc_ifVar);
                    if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
                        com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("RetryMonitorDbHelper", "query: add retryMonitorInfo = " + tanxc_ifVar);
                    }
                } catch (java.lang.Exception e) {
                    com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("RetryMonitorDbHelper", "query exception, date = " + str, e);
                }
            } catch (java.lang.Throwable th) {
                query.close();
                throw th;
            }
        }
        if (query != null) {
            query.close();
        }
        if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("RetryMonitorDbHelper", "query: exposeDate = " + str + ", retryMonitorInfoList = " + arrayList);
        }
        return arrayList;
    }

    public synchronized void tanxc_do(long j) {
        if (j < 0) {
            return;
        }
        try {
            long delete = getWritableDatabase().delete("retry_monitor_info", "id = ?", new java.lang.String[]{java.lang.String.valueOf(j)});
            if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
                com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("RetryMonitorDbHelper", "delete: id = " + j + ", deleteRows = " + delete);
            }
        } finally {
        }
    }

    public synchronized void tanxc_do(com.tanx.exposer.achieve.tanxc_if tanxc_ifVar) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("monitor_type", tanxc_ifVar.tanxc_int().name());
        contentValues.put("monitor_url", tanxc_ifVar.tanxc_if());
        contentValues.put("monitor_original_url", tanxc_ifVar.tanxc_for());
        contentValues.put("monitor_url_host", tanxc_ifVar.tanxc_try());
        contentValues.put("monitor_url_hash", tanxc_ifVar.tanxc_new());
        if (tanxc_ifVar.tanxc_goto() != null) {
            contentValues.put("monitor_extra_params", tanxc_ifVar.tanxc_goto().toString());
        }
        contentValues.put("retry_times", java.lang.Integer.valueOf(tanxc_ifVar.tanxc_else().intValue()));
        contentValues.put("max_retry_times", java.lang.Integer.valueOf(tanxc_ifVar.tanxc_char()));
        contentValues.put("date", tanxc_ifVar.tanxc_case());
        contentValues.put("expire_time", java.lang.Long.valueOf(tanxc_ifVar.tanxc_byte()));
        long insert = writableDatabase.insert("retry_monitor_info", null, contentValues);
        tanxc_ifVar.tanxc_do(insert);
        if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("RetryMonitorDbHelper", "insert: index = " + insert + ", exposeDate = " + tanxc_ifVar.tanxc_case());
        }
    }

    public synchronized void tanxc_do(java.lang.String str, int i) {
        try {
            long delete = getWritableDatabase().delete("retry_monitor_info", "date != ? or retry_times >= ?", new java.lang.String[]{str, java.lang.String.valueOf(i)});
            if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
                com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("RetryMonitorDbHelper", "delete: deletedRows = " + delete + ", date = " + str + ", maxRetryTimes = " + i);
            }
        } catch (java.lang.Throwable th) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("RetryMonitorDbHelper", "delete by date exception.", th);
        }
    }
}
