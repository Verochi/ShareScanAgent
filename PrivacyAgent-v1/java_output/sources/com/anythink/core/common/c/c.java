package com.anythink.core.common.c;

/* loaded from: classes12.dex */
public class c extends com.anythink.core.common.c.b {
    private static com.anythink.core.common.c.c a;

    private c(android.content.Context context) {
        super(context);
    }

    public static com.anythink.core.common.c.c a(android.content.Context context) {
        if (a == null) {
            synchronized (com.anythink.core.common.c.c.class) {
                if (a == null) {
                    a = new com.anythink.core.common.c.c(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private void c(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(com.anythink.core.common.c.d.a.f);
            sQLiteDatabase.execSQL(com.anythink.core.common.c.g.a.i);
            a(sQLiteDatabase, 3, 11);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private static void d(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'sdkconfig'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'request_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'placement_ad_impression'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_action_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_data_cache'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'dsp_offer_show_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'dsp_offer_install_record'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'inspect_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'video_res_cache_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'notice_url_fail_info'");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'user_value_placement'");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    private void e(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    @Override // com.anythink.core.common.c.b
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
    }

    @Override // com.anythink.core.common.c.b
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 1:
                case 2:
                    d(sQLiteDatabase);
                    c(sQLiteDatabase);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(com.anythink.core.common.c.l.a.j);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.anythink.core.common.c.j.a.h);
                    sQLiteDatabase.execSQL(com.anythink.core.common.c.k.a.i);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.anythink.core.common.c.f.a.h);
                    sQLiteDatabase.execSQL(com.anythink.core.common.c.e.a.f);
                    break;
                case 6:
                    sQLiteDatabase.execSQL(com.anythink.core.common.c.h.a.d);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(com.anythink.core.common.c.m.a.h);
                    break;
                case 8:
                    sQLiteDatabase.execSQL(com.anythink.core.common.c.i.b.i);
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'request_info'");
                    sQLiteDatabase.execSQL(com.anythink.core.common.c.g.a.i);
                    break;
                case 9:
                    sQLiteDatabase.execSQL(com.anythink.core.c.b.d.a.k);
                    break;
                case 10:
                    try {
                        sQLiteDatabase.execSQL(com.anythink.core.c.b.d.a.k);
                    } catch (java.lang.Throwable unused) {
                    }
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'offer_data_cache'");
                    sQLiteDatabase.execSQL(com.anythink.core.common.c.k.a.i);
                    break;
            }
            i++;
        }
    }

    @Override // com.anythink.core.common.c.b
    public final void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        c(sQLiteDatabase);
    }

    @Override // com.anythink.core.common.c.b
    public final java.lang.String c() {
        return "anythink.db";
    }

    @Override // com.anythink.core.common.c.b
    public final int d() {
        return 11;
    }
}
