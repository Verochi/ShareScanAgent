package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public abstract class b {
    public android.database.sqlite.SQLiteOpenHelper b;
    public java.util.Map<java.lang.Class<? extends com.zx.a.I8b7.c>, com.zx.a.I8b7.c> a = new java.util.HashMap();
    public java.util.concurrent.atomic.AtomicBoolean c = new java.util.concurrent.atomic.AtomicBoolean(false);

    public abstract java.lang.String a();

    public final android.database.sqlite.SQLiteOpenHelper b() {
        android.database.sqlite.SQLiteOpenHelper sQLiteOpenHelper = this.b;
        if (sQLiteOpenHelper != null) {
            return sQLiteOpenHelper;
        }
        java.lang.StringBuilder a = com.zx.a.I8b7.f3.a("db ");
        a.append(a());
        a.append(" has not been initialized");
        throw new java.lang.RuntimeException(a.toString());
    }

    public abstract int c();
}
