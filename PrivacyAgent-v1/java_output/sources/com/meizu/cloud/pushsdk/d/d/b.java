package com.meizu.cloud.pushsdk.d.d;

/* loaded from: classes23.dex */
public class b extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.String a = "com.meizu.cloud.pushsdk.d.d.b";
    private static com.meizu.cloud.pushsdk.d.d.b b;

    private b(android.content.Context context, java.lang.String str) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
    }

    public static com.meizu.cloud.pushsdk.d.d.b a(android.content.Context context, java.lang.String str) {
        if (b == null) {
            b = new com.meizu.cloud.pushsdk.d.d.b(context.getApplicationContext(), str);
        }
        return b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS 'events' (id INTEGER PRIMARY KEY, eventData BLOB, dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.meizu.cloud.pushsdk.d.f.c.b(a, "Upgrading database from version " + i + " to " + i2 + ". Destroying old data now..", new java.lang.Object[0]);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'events'");
        onCreate(sQLiteDatabase);
    }
}
