package com.getui.gs.b;

/* loaded from: classes22.dex */
public class d extends com.getui.gtc.base.db.AbstractDb {
    public static void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str, java.lang.String str2) {
        sQLiteDatabase.execSQL("Alter table " + str + " add column " + str2);
    }

    public static void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str, java.util.List<java.lang.String> list) {
        if (list.size() == 0) {
            return;
        }
        for (java.lang.String str2 : list) {
            if (!android.text.TextUtils.isEmpty(str2)) {
                sQLiteDatabase.execSQL("Alter table " + str + " add column " + str2);
            }
        }
    }

    @Override // com.getui.gtc.base.db.AbstractDb
    public java.lang.String getDbName() {
        return "gs-ido.db";
    }

    @Override // com.getui.gtc.base.db.AbstractDb
    public int getVersion() {
        return 4;
    }
}
