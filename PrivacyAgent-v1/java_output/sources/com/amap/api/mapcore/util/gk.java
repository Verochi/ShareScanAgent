package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class gk extends android.database.sqlite.SQLiteOpenHelper {
    private static boolean b = true;
    private static boolean c;
    private com.amap.api.mapcore.util.gg a;

    public gk(android.content.Context context, java.lang.String str, com.amap.api.mapcore.util.gg ggVar) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 2);
        this.a = ggVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.a(sQLiteDatabase, i);
    }
}
