package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class a extends android.database.sqlite.SQLiteOpenHelper {
    public final /* synthetic */ com.zx.a.I8b7.b a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(com.zx.a.I8b7.b bVar, android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, i);
        this.a = bVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            java.util.Iterator<java.lang.Class<? extends com.zx.a.I8b7.c>> it = this.a.a.keySet().iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(this.a.a.get(it.next()).a());
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.beginTransaction();
        try {
            java.util.Iterator<java.lang.Class<? extends com.zx.a.I8b7.c>> it = this.a.a.keySet().iterator();
            while (it.hasNext()) {
                this.a.a.get(it.next()).getClass();
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.beginTransaction();
        try {
            java.util.Iterator<java.lang.Class<? extends com.zx.a.I8b7.c>> it = this.a.a.keySet().iterator();
            while (it.hasNext()) {
                this.a.a.get(it.next()).a(sQLiteDatabase, i, i2);
            }
            sQLiteDatabase.setTransactionSuccessful();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
