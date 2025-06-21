package com.jd.ad.sdk.jad_sf;

/* loaded from: classes23.dex */
public class jad_an extends android.database.sqlite.SQLiteOpenHelper {
    public android.database.sqlite.SQLiteDatabase jad_an;

    public jad_an(android.content.Context context, java.lang.String str, int i) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        if (jad_bo()) {
            this.jad_an.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        android.database.sqlite.SQLiteDatabase readableDatabase = super.getReadableDatabase();
        this.jad_an = readableDatabase;
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        android.database.sqlite.SQLiteDatabase writableDatabase = super.getWritableDatabase();
        this.jad_an = writableDatabase;
        return writableDatabase;
    }

    public boolean jad_bo() {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = this.jad_an;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }
}
