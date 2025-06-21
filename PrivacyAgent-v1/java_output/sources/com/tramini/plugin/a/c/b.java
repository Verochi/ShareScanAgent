package com.tramini.plugin.a.c;

/* loaded from: classes19.dex */
public abstract class b {
    private com.tramini.plugin.a.c.b.a a;

    public class a extends android.database.sqlite.SQLiteOpenHelper {
        public a(android.content.Context context, java.lang.String str) {
            super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    public b(android.content.Context context) {
        this.a = new com.tramini.plugin.a.c.b.a(context, c());
    }

    public final android.database.sqlite.SQLiteDatabase a() {
        return this.a.getReadableDatabase();
    }

    public final synchronized android.database.sqlite.SQLiteDatabase b() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.a.getWritableDatabase();
        } catch (java.lang.Exception unused) {
            sQLiteDatabase = null;
        }
        return sQLiteDatabase;
    }

    public abstract java.lang.String c();

    public abstract int d();

    public abstract void e();

    public abstract void f();

    public abstract void g();
}
