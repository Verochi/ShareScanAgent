package com.umeng.analytics.process;

/* loaded from: classes19.dex */
class b extends android.database.sqlite.SQLiteOpenHelper {
    public b(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    public static com.umeng.analytics.process.b a(android.content.Context context, java.lang.String str) {
        java.lang.String b = b(context, str);
        com.umeng.analytics.process.a.h.equals(str);
        return new com.umeng.analytics.process.b(context, b, null, 1);
    }

    public static java.lang.String a(android.content.Context context) {
        return com.umeng.analytics.pro.j.b(context) + com.umeng.analytics.process.a.a;
    }

    private void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("create table if not exists __et_p(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __pn TEXT, __av TEXT, __vc TEXT)");
        } catch (android.database.SQLException unused) {
        }
    }

    public static java.lang.String b(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.umeng.analytics.process.a.h;
        }
        java.lang.String str2 = com.umeng.analytics.pro.j.b(context) + com.umeng.analytics.process.a.a;
        if (com.umeng.analytics.process.a.h.equals(str)) {
            str2 = com.umeng.analytics.pro.j.b(context);
        }
        java.io.File file = new java.io.File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return java.lang.String.format(str2 + com.umeng.analytics.process.a.e, str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
