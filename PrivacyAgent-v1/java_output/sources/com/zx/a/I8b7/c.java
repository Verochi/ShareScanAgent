package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public abstract class c {
    public com.zx.a.I8b7.b a;

    public abstract java.lang.String a();

    public void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public final android.database.sqlite.SQLiteDatabase b() {
        com.zx.a.I8b7.b bVar = this.a;
        if (bVar != null) {
            return bVar.b().getReadableDatabase();
        }
        java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("table ");
        a.append(c());
        a.append(" has not been added to a db");
        throw new java.lang.RuntimeException(a.toString());
    }

    public abstract java.lang.String c();

    public final android.database.sqlite.SQLiteDatabase d() {
        com.zx.a.I8b7.b bVar = this.a;
        if (bVar != null) {
            return bVar.b().getWritableDatabase();
        }
        throw new java.lang.RuntimeException("table zx_table has not been added to a db");
    }
}
