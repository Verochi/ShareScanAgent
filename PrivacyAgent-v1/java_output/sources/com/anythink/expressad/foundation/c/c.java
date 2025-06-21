package com.anythink.expressad.foundation.c;

/* loaded from: classes12.dex */
public class c extends com.anythink.expressad.foundation.c.b {
    private static volatile com.anythink.expressad.foundation.c.c a;

    private c(android.content.Context context) {
        super(context);
    }

    public static com.anythink.expressad.foundation.c.c a(android.content.Context context) {
        if (a == null) {
            synchronized (com.anythink.expressad.foundation.c.c.class) {
                if (a == null) {
                    a = new com.anythink.expressad.foundation.c.c(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private static void c(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'campaign'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'frequence'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'campaignclick'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'click_time'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'load_stat'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'fq_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'dailyplaycap'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'display_resource_type'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'unit_id'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'c_replace_temp'");
        } catch (java.lang.Exception e) {
            if (com.anythink.expressad.a.a) {
                e.printStackTrace();
            }
        }
    }

    private static void f() {
    }

    @Override // com.anythink.expressad.foundation.c.b
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
    }

    @Override // com.anythink.expressad.foundation.c.b
    public final void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
    }

    @Override // com.anythink.expressad.foundation.c.b
    public final java.lang.String c() {
        return "anythink_expressad.db";
    }

    @Override // com.anythink.expressad.foundation.c.b
    public final int d() {
        return 67;
    }

    @Override // com.anythink.expressad.foundation.c.b
    public final void e() {
    }
}
