package com.igexin.push.b;

/* loaded from: classes.dex */
public final class b extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.String a = "DownDBHelper";
    private static final java.lang.String b = "pushsdk.db";
    private static final int c = 7;
    private static final java.lang.String d = "create table if not exists config (id integer primary key,value text)";
    private static final java.lang.String e = "create table if not exists runtime (id integer primary key,value text)";
    private static final java.lang.String f = "create table if not exists ral (id integer primary key,data text,type integer,time integer,send_times integer)";
    private static final java.lang.String g = "create table if not exists message (id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,status integer,createtime integer,expect_redisplay_time integer, redisplay_freq integer,redisplay_duration integer ,redisplay_num integer,notify_status integer ) ";
    private static final java.lang.String h = "create table if not exists bidata (id integer primary key,data text,type integer,time integer)";
    private static final java.lang.String i = "drop table if exists config";
    private static final java.lang.String j = "drop table if exists runtime";
    private static final java.lang.String k = "drop table if exists ral";
    private static final java.lang.String l = "drop table if exists ca";
    private static final java.lang.String m = "drop table if exists bi";
    private static final java.lang.String n = "drop table if exists message";
    private static final java.lang.String o = "drop table if exists st";
    private static final java.lang.String p = "drop table if exists bidata";
    private android.database.sqlite.SQLiteDatabase q;

    public b(android.content.Context context) {
        super(context, "pushsdk.db", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 7);
        this.q = null;
    }

    private b(android.content.Context context, java.lang.String str, int i2) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, i2);
        this.q = null;
    }

    private android.database.Cursor a(java.lang.String str, java.lang.String[] strArr) {
        android.database.sqlite.SQLiteDatabase readableDatabase = getReadableDatabase();
        this.q = readableDatabase;
        try {
            return readableDatabase.rawQuery(str, strArr);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    private static java.lang.String a(java.lang.String[] strArr, java.lang.String[] strArr2, int i2) {
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
            } catch (java.lang.Exception unused) {
                com.igexin.c.a.c.a.a(a, "closecurrentDatabase fail");
            }
        }
    }

    private void a(java.lang.String str, java.lang.String str2, android.content.ContentValues contentValues) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        try {
            writableDatabase.replace(str, str2, contentValues);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private boolean a(java.lang.String str) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                this.q.execSQL(str);
                this.q.setTransactionSuccessful();
                b(this.q);
                return true;
            } catch (java.lang.Exception e2) {
                com.igexin.c.a.c.a.a(e2);
                b(this.q);
                return false;
            }
        } catch (java.lang.Throwable th) {
            b(this.q);
            throw th;
        }
    }

    private static java.lang.String b(java.lang.String str, java.lang.String str2) {
        return "delete from " + str + " where " + str2;
    }

    private static void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.endTransaction();
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final int a(java.lang.String str, java.lang.String str2) {
        int i2;
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        int i3 = 0;
        try {
            try {
                i2 = this.q.delete(str, str2, null);
            } catch (java.lang.Exception e2) {
                e = e2;
            }
            try {
                com.igexin.c.a.c.a.a("DownDBHelper|del " + i2 + " msg", new java.lang.Object[0]);
                this.q.setTransactionSuccessful();
            } catch (java.lang.Exception e3) {
                e = e3;
                i3 = i2;
                com.igexin.c.a.c.a.a(e);
                b(this.q);
                i2 = i3;
                return i2;
            }
            return i2;
        } finally {
            b(this.q);
        }
    }

    public final long a(java.lang.String str, android.content.ContentValues contentValues) {
        long j2;
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                j2 = this.q.insert(str, null, contentValues);
                try {
                    this.q.setTransactionSuccessful();
                } catch (java.lang.Exception unused) {
                }
            } catch (java.lang.Exception unused2) {
                j2 = -1;
            }
            return j2;
        } finally {
            b(this.q);
        }
    }

    public final android.database.Cursor a(java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
        try {
            android.database.sqlite.SQLiteDatabase readableDatabase = getReadableDatabase();
            this.q = readableDatabase;
            return readableDatabase.query(str, strArr, str2, null, null, null, null);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    public final android.database.Cursor a(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String[] strArr3, java.lang.String str2) {
        android.database.Cursor cursor;
        android.database.sqlite.SQLiteDatabase readableDatabase = getReadableDatabase();
        this.q = readableDatabase;
        readableDatabase.beginTransaction();
        try {
            try {
                if (strArr == null) {
                    cursor = this.q.query(str, strArr3, null, null, null, null, str2);
                } else if (strArr.length != 1) {
                    cursor = this.q.query(str, strArr3, a(strArr, strArr2, strArr.length), null, null, null, str2);
                } else if (strArr2.length == 1) {
                    cursor = this.q.query(str, strArr3, strArr[0] + "= ?", strArr2, null, null, str2);
                } else {
                    cursor = this.q.query(str, strArr3, a(strArr, strArr2, strArr2.length), null, null, null, str2);
                }
                try {
                    this.q.setTransactionSuccessful();
                } catch (java.lang.Exception unused) {
                }
            } finally {
                b(this.q);
            }
        } catch (java.lang.Exception unused2) {
            cursor = null;
        }
        return cursor;
    }

    public final void a(java.lang.String str, android.content.ContentValues contentValues, java.lang.String[] strArr, java.lang.String[] strArr2) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                this.q.update(str, contentValues, strArr[0] + "='" + strArr2[0] + "'", null);
                this.q.setTransactionSuccessful();
            } catch (java.lang.Exception unused) {
                com.igexin.c.a.c.a.a(a, str + "_Update Error!");
            }
        } finally {
            b(this.q);
        }
    }

    public final void a(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) {
        android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
        this.q = writableDatabase;
        writableDatabase.beginTransaction();
        try {
            try {
                if (strArr2.length == 1) {
                    com.igexin.c.a.c.a.a("DownDBHelper|del " + str + " cnt = " + this.q.delete(str, strArr[0] + " = ?", strArr2), new java.lang.Object[0]);
                } else {
                    this.q.execSQL(b(str, a(strArr, strArr2, strArr2.length)));
                }
                this.q.setTransactionSuccessful();
            } catch (java.lang.Exception unused) {
                com.igexin.c.a.c.a.a(a, str + "_Delete Error!");
            }
        } finally {
            b(this.q);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL(d);
            sQLiteDatabase.execSQL(e);
            sQLiteDatabase.execSQL(g);
            sQLiteDatabase.execSQL(f);
            sQLiteDatabase.execSQL(h);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (java.lang.Exception unused) {
        } finally {
            b(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        onUpgrade(sQLiteDatabase, i3, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        com.igexin.push.core.e.f.a().b = true;
        com.igexin.push.core.e.f.d(sQLiteDatabase);
        byte[] a2 = com.igexin.push.core.e.f.a(sQLiteDatabase, 1);
        if (a2 != null) {
            try {
                java.lang.String str = new java.lang.String(a2);
                com.igexin.push.core.e.z = str.equals(com.igexin.push.core.b.m) ? 0L : java.lang.Long.parseLong(str);
            } catch (java.lang.Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
            com.igexin.c.a.c.a.a(com.igexin.push.core.e.f.a + "|db version changed, save session = " + com.igexin.push.core.e.z, new java.lang.Object[0]);
        }
        byte[] a3 = com.igexin.push.core.e.f.a(sQLiteDatabase, 20);
        if (a3 != null) {
            java.lang.String str2 = new java.lang.String(a3);
            if (str2.equals(com.igexin.push.core.b.m)) {
                str2 = null;
            }
            com.igexin.push.core.e.B = str2;
            com.igexin.push.core.e.A = str2;
            com.igexin.c.a.c.a.a(com.igexin.push.core.e.f.a + "|db version changed, save cid = " + str2, new java.lang.Object[0]);
        }
        java.lang.String b2 = com.igexin.push.core.e.f.b(sQLiteDatabase, 3);
        if (!android.text.TextUtils.isEmpty(b2)) {
            if (b2.equals(com.igexin.push.core.b.m)) {
                b2 = null;
            }
            com.igexin.push.core.e.L = b2;
        }
        java.lang.String str3 = com.igexin.push.core.e.a;
        java.lang.String b3 = com.igexin.push.core.e.f.b(sQLiteDatabase, 2);
        if (!android.text.TextUtils.isEmpty(b3)) {
            if (b3.equals(com.igexin.push.core.b.m)) {
                b3 = null;
            }
            com.igexin.push.core.e.H = b3;
        }
        java.lang.String b4 = com.igexin.push.core.e.f.b(sQLiteDatabase, 46);
        if (!android.text.TextUtils.isEmpty(b4)) {
            if (b4.equals(com.igexin.push.core.b.m)) {
                b4 = null;
            }
            com.igexin.push.core.e.I = b4;
        }
        java.lang.String b5 = com.igexin.push.core.e.f.b(sQLiteDatabase, 48);
        if (!android.text.TextUtils.isEmpty(b5)) {
            if (b5.equals(com.igexin.push.core.b.m)) {
                b5 = null;
            }
            com.igexin.push.core.e.K = b5;
        }
        java.lang.String b6 = com.igexin.push.core.e.f.b(sQLiteDatabase, 51);
        if (!android.text.TextUtils.isEmpty(b6) && b6.length() != 13) {
            com.igexin.push.core.e.C = b6.equals(com.igexin.push.core.b.m) ? null : b6;
        }
        com.igexin.push.core.e.c.a().d(sQLiteDatabase);
        try {
            sQLiteDatabase.execSQL(i);
        } catch (java.lang.Exception e3) {
            com.igexin.c.a.c.a.a(e3);
        }
        try {
            sQLiteDatabase.execSQL(j);
        } catch (java.lang.Exception e4) {
            com.igexin.c.a.c.a.a(e4);
        }
        try {
            sQLiteDatabase.execSQL(n);
        } catch (java.lang.Exception e5) {
            com.igexin.c.a.c.a.a(e5);
        }
        try {
            sQLiteDatabase.execSQL(k);
        } catch (java.lang.Exception e6) {
            com.igexin.c.a.c.a.a(e6);
        }
        try {
            sQLiteDatabase.execSQL(l);
        } catch (java.lang.Exception e7) {
            com.igexin.c.a.c.a.a(e7);
        }
        try {
            sQLiteDatabase.execSQL(m);
        } catch (java.lang.Exception e8) {
            com.igexin.c.a.c.a.a(e8);
        }
        try {
            sQLiteDatabase.execSQL(o);
        } catch (java.lang.Exception e9) {
            com.igexin.c.a.c.a.a(e9);
        }
        try {
            sQLiteDatabase.execSQL(p);
        } catch (java.lang.Exception e10) {
            com.igexin.c.a.c.a.a(e10);
        }
        onCreate(sQLiteDatabase);
    }
}
