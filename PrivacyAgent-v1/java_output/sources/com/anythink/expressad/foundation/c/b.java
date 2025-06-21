package com.anythink.expressad.foundation.c;

/* loaded from: classes12.dex */
public abstract class b {
    private com.anythink.expressad.foundation.c.b.a a;

    public class a extends android.database.sqlite.SQLiteOpenHelper {
        public a(android.content.Context context, java.lang.String str) {
            super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 67);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
            com.anythink.expressad.foundation.c.b.this.b(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
            com.anythink.expressad.foundation.c.b.this.a(sQLiteDatabase);
        }
    }

    public b(android.content.Context context) {
        this.a = new com.anythink.expressad.foundation.c.b.a(context, c());
    }

    public final android.database.sqlite.SQLiteDatabase a() {
        return this.a.getReadableDatabase();
    }

    public abstract void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase);

    public final synchronized android.database.sqlite.SQLiteDatabase b() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.a.getWritableDatabase();
        } catch (java.lang.Exception unused) {
            sQLiteDatabase = null;
        }
        return sQLiteDatabase;
    }

    public abstract void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase);

    public abstract java.lang.String c();

    public abstract int d();

    public abstract void e();
}
