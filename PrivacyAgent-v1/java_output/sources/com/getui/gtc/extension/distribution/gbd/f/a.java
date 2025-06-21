package com.getui.gtc.extension.distribution.gbd.f;

/* loaded from: classes22.dex */
public final class a extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.String b = "GBD_DBHelper";
    private static final java.lang.String c = "pushg3.db";
    private static final int d = 7;
    private static final java.lang.String e = "create table if not exists runtime(key integer primary key, value text)";
    private static final java.lang.String f = "create table if not exists ral (id integer primary key  , key integer, value blob,  t integer)";
    private static final java.lang.String g = "create table if not exists ral (id integer primary key  , key integer, value blob,  t integer,  num integer default 0)";
    private static final java.lang.String h = "alter table ral rename to temp_ral";
    private static final java.lang.String i = "insert into ral select * from temp_ral";
    private static final java.lang.String j = "drop table temp_ral";
    private static final java.lang.String k = "alter table ral add column num integer default 0";
    private static final java.lang.String l = "create table if not exists config (key integer primary key, value text)";
    private static final java.lang.String m = "create table if not exists look (id integer primary key  , value text,  t datetime,type integer,status integer, stage integer)";
    private static final java.lang.String n = "drop table if exists runtime";
    private static final java.lang.String o = "drop table if exists ral";
    private static final java.lang.String p = "drop table if exists config";
    private static final java.lang.String q = "drop table if exists look";
    public android.database.sqlite.SQLiteDatabase a;

    public a(android.content.Context context) {
        super(context, "pushg3.db", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 7);
        this.a = null;
    }

    private android.database.Cursor a(java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
        android.database.sqlite.SQLiteDatabase readableDatabase = getReadableDatabase();
        this.a = readableDatabase;
        return readableDatabase.query(str, strArr, str2, null, null, null, null);
    }

    private android.database.Cursor a(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String[] strArr3, java.lang.String str2) {
        android.database.Cursor query;
        android.database.sqlite.SQLiteDatabase readableDatabase = getReadableDatabase();
        this.a = readableDatabase;
        readableDatabase.beginTransaction();
        android.database.Cursor cursor = null;
        try {
            if (strArr == null) {
                query = this.a.query(str, strArr3, null, null, null, null, str2);
            } else if (strArr.length != 1) {
                query = this.a.query(str, strArr3, a(strArr, strArr2, strArr.length), null, null, null, str2);
            } else if (strArr2.length == 1) {
                query = this.a.query(str, strArr3, strArr[0] + " = ? ", strArr2, null, null, str2);
            } else {
                query = this.a.query(str, strArr3, a(strArr, strArr2, strArr2.length), null, null, null, str2);
            }
            cursor = query;
            this.a.setTransactionSuccessful();
        } finally {
            try {
                return cursor;
            } finally {
            }
        }
        return cursor;
    }

    public static java.lang.String a(java.lang.String[] strArr, java.lang.String[] strArr2, int i2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(" ");
        if (strArr.length == 1) {
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(strArr[0]);
                sb.append(" = '");
                sb.append(strArr2[i3]);
                sb.append("'");
                if (i3 < i2 - 1) {
                    sb.append(" or ");
                }
            }
        } else {
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(strArr[i4]);
                sb.append(" = '");
                sb.append(strArr2[i4]);
                sb.append("'");
                if (i4 < i2 - 1) {
                    sb.append(" and ");
                }
            }
        }
        return sb.toString();
    }

    private static void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            } catch (java.lang.Throwable unused) {
                com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_DBHelper==================", "closecurrentDatabase fail");
            }
        }
    }

    private void a(java.lang.String str, android.content.ContentValues contentValues, java.lang.String[] strArr, java.lang.String[] strArr2) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                this.a.update(str, contentValues, strArr[0] + "='" + strArr2[0] + "'", null);
                this.a.setTransactionSuccessful();
            } finally {
                this.a.endTransaction();
            }
        } catch (java.lang.Throwable unused) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(b, "=================" + str + "Query Error!");
        }
    }

    private void a(java.lang.String str, java.lang.String str2) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.delete(str, str2, null);
    }

    private void a(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                this.a.delete(str, strArr[0] + " <= ?", strArr2);
                this.a.setTransactionSuccessful();
            } finally {
                this.a.endTransaction();
            }
        } catch (java.lang.Throwable unused) {
            com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_DBHelper=================".concat(java.lang.String.valueOf(str)), "Delete Error!");
        }
    }

    private static java.lang.String b(java.lang.String str, java.lang.String str2) {
        return "delete from " + str + " where " + str2;
    }

    private void b(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                if (strArr2.length == 1) {
                    this.a.delete(str, strArr[0] + " = ?", strArr2);
                } else {
                    this.a.execSQL("delete from " + str + " where " + a(strArr, strArr2, strArr2.length));
                }
                this.a.setTransactionSuccessful();
            } finally {
                this.a.endTransaction();
            }
        } catch (java.lang.Throwable unused) {
            com.getui.gtc.extension.distribution.gbd.n.j.a("GBD_DBHelper=================".concat(java.lang.String.valueOf(str)), "Delete Error!");
        }
    }

    public final long a(java.lang.String str, android.content.ContentValues contentValues) {
        long j2;
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            j2 = this.a.insert(str, null, contentValues);
        } catch (java.lang.Throwable unused) {
            j2 = -1;
        }
        try {
            this.a.setTransactionSuccessful();
            com.getui.gtc.extension.distribution.gbd.n.j.a(b, "Insert sucess! table:".concat(java.lang.String.valueOf(str)));
        } catch (java.lang.Throwable unused2) {
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.a(b, "Insert Error! table:".concat(java.lang.String.valueOf(str)));
                return j2;
            } finally {
                this.a.endTransaction();
            }
        }
        return j2;
    }

    public final android.database.Cursor a(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase readableDatabase = getReadableDatabase();
        this.a = readableDatabase;
        try {
            return readableDatabase.rawQuery(str, null);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    public final void b(java.lang.String str, android.content.ContentValues contentValues) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.a = writableDatabase;
        try {
            writableDatabase.replace(str, null, contentValues);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final void close() {
        try {
            this.a.close();
        } catch (java.lang.Throwable unused) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(b, "================== closeDatabase fail");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            try {
                sQLiteDatabase.execSQL(e);
                sQLiteDatabase.execSQL(g);
                sQLiteDatabase.execSQL(l);
                sQLiteDatabase.execSQL(m);
                com.getui.gtc.extension.distribution.gbd.n.j.a(b, "DBHelper create tables success!");
                sQLiteDatabase.setTransactionSuccessful();
            } catch (java.lang.Throwable unused) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(b, "DBHelper create tables failed!");
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        onUpgrade(sQLiteDatabase, i3, i2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:23|(2:24|25)|26|27|28|29|31|32|33|34|35) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005a, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005b, code lost:
    
        com.getui.gtc.extension.distribution.gbd.n.j.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0050, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0051, code lost:
    
        com.getui.gtc.extension.distribution.gbd.n.j.a(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0046, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0047, code lost:
    
        com.getui.gtc.extension.distribution.gbd.n.j.a(r5);
     */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(b, "DBHelper upgrade.");
        if (sQLiteDatabase != null) {
            if (i2 == 6 && i3 == 7) {
                sQLiteDatabase.beginTransaction();
                try {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(b, "DBHelper upgrade v=7.");
                    sQLiteDatabase.execSQL(o);
                    sQLiteDatabase.execSQL(g);
                    sQLiteDatabase.setTransactionSuccessful();
                    return;
                } catch (java.lang.Throwable th) {
                    try {
                        return;
                    } finally {
                    }
                }
            }
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    sQLiteDatabase.execSQL(n);
                } finally {
                    try {
                    } finally {
                    }
                }
            } finally {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                sQLiteDatabase.execSQL(o);
                sQLiteDatabase.execSQL(p);
                sQLiteDatabase.execSQL(q);
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                onCreate(sQLiteDatabase);
            }
            sQLiteDatabase.execSQL(o);
            sQLiteDatabase.execSQL(p);
            sQLiteDatabase.execSQL(q);
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            onCreate(sQLiteDatabase);
        }
    }
}
