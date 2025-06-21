package com.loc;

/* loaded from: classes23.dex */
public final class bd extends android.database.sqlite.SQLiteOpenHelper {
    private static boolean b = true;
    private static boolean c;
    private com.loc.az a;

    public bd(android.content.Context context, java.lang.String str, com.loc.az azVar) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
        this.a = azVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
