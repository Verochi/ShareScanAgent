package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bq extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.Object b = new java.lang.Object();
    private static com.umeng.analytics.pro.bq c = null;
    private static final java.lang.String d = "CREATE TABLE IF NOT EXISTS stf(_id INTEGER PRIMARY KEY AUTOINCREMENT, _tp TEXT, _hd TEXT, _bd TEXT, _ts TEXT, _uuid TEXT, _re1 TEXT, _re2 TEXT)";
    private static final java.lang.String e = "DROP TABLE IF EXISTS stf";
    private static final java.lang.String f = "DELETE FROM stf WHERE _id IN( SELECT _id FROM stf ORDER BY _id LIMIT 1)";
    private final android.content.Context a;

    private bq(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
        this.a = context;
    }

    public static final int a() {
        return 1;
    }

    public static com.umeng.analytics.pro.bq a(android.content.Context context) {
        com.umeng.analytics.pro.bq bqVar;
        synchronized (b) {
            if (c == null) {
                c = new com.umeng.analytics.pro.bq(context, com.umeng.analytics.pro.bs.b, null, 1);
            }
            bqVar = c;
        }
        return bqVar;
    }

    private void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(e);
            sQLiteDatabase.execSQL(d);
        } catch (android.database.SQLException unused) {
        }
    }

    private void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(d);
        } catch (android.database.sqlite.SQLiteDatabaseCorruptException unused) {
            a(sQLiteDatabase);
        } catch (java.lang.Throwable th) {
            com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]创建二级缓存数据库失败: " + th.getMessage());
        }
    }

    private void d() {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.execSQL(f);
            } catch (java.lang.Throwable unused) {
            }
            writableDatabase.close();
        } catch (java.lang.Throwable unused2) {
        }
    }

    public android.database.Cursor a(java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return null;
            }
            return writableDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0077, code lost:
    
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x006d, code lost:
    
        if (r1 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x006f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x007a, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.umeng.analytics.pro.br a(java.lang.String str) {
        android.database.Cursor cursor;
        com.umeng.analytics.pro.br brVar = null;
        try {
            cursor = a(str, new java.lang.String[]{com.umeng.analytics.pro.bs.i, com.umeng.analytics.pro.bs.e, com.umeng.analytics.pro.bs.f, com.umeng.analytics.pro.bs.g, com.umeng.analytics.pro.bs.j, com.umeng.analytics.pro.bs.k}, null, null, null, null, null, "1");
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        com.umeng.analytics.pro.br brVar2 = new com.umeng.analytics.pro.br();
                        try {
                            brVar2.a = cursor.getString(0);
                            brVar2.b = cursor.getString(1);
                            java.lang.String string = cursor.getString(2);
                            java.lang.String string2 = cursor.getString(3);
                            brVar2.c = com.umeng.analytics.pro.k.a(this.a).d(string);
                            brVar2.d = com.umeng.analytics.pro.k.a(this.a).d(string2);
                            brVar2.e = cursor.getString(4);
                            brVar2.f = cursor.getString(5);
                            brVar = brVar2;
                        } catch (java.lang.Throwable unused) {
                            brVar = brVar2;
                            try {
                                d();
                            } finally {
                            }
                        }
                    }
                } catch (java.lang.Throwable unused2) {
                }
            }
        } catch (java.lang.Throwable unused3) {
            cursor = null;
        }
    }

    public void a(java.lang.String str, android.content.ContentValues contentValues) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.insert(str, null, contentValues);
                writableDatabase.setTransactionSuccessful();
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> [有状态]插入二级缓存数据记录 成功。");
            } catch (java.lang.Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (java.lang.Throwable unused2) {
        }
    }

    public void a(java.lang.String str, java.lang.String str2) {
        a(str, "_uuid=?", new java.lang.String[]{str2});
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String[] strArr) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            try {
                writableDatabase.beginTransaction();
                writableDatabase.delete(str, str2, strArr);
                writableDatabase.setTransactionSuccessful();
            } catch (java.lang.Throwable unused) {
            }
            writableDatabase.endTransaction();
            writableDatabase.close();
        } catch (java.lang.Throwable unused2) {
        }
    }

    public void b() {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null || !writableDatabase.isOpen()) {
                return;
            }
            writableDatabase.close();
        } catch (java.lang.Throwable unused) {
        }
    }

    public boolean b(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        android.database.Cursor cursor = null;
        try {
            sQLiteDatabase = getWritableDatabase();
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.isOpen()) {
                        cursor = sQLiteDatabase.query(str, null, null, null, null, null, null, null);
                    }
                } catch (java.lang.Throwable unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase == null) {
                        return false;
                    }
                    sQLiteDatabase.close();
                    return false;
                }
            }
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    cursor.close();
                    if (sQLiteDatabase == null) {
                        return true;
                    }
                    sQLiteDatabase.close();
                    return true;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (sQLiteDatabase == null) {
                return false;
            }
        } catch (java.lang.Throwable unused2) {
            sQLiteDatabase = null;
        }
        sQLiteDatabase.close();
        return false;
    }

    public boolean c() {
        return !b(com.umeng.analytics.pro.bs.c);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
