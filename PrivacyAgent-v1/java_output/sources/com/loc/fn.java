package com.loc;

/* loaded from: classes23.dex */
public class fn implements com.loc.az {
    @Override // com.loc.az
    public final java.lang.String a() {
        return "alsn20170807.db";
    }

    @Override // com.loc.az
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS c (_id integer primary key autoincrement, a2 varchar(100), a4 varchar(2000), a3 LONG );");
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "SdCardDbCreator", "onCreate");
        }
    }
}
