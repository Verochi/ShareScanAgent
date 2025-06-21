package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class ba implements com.amap.api.mapcore.util.gg {
    private static volatile com.amap.api.mapcore.util.ba a;

    private ba() {
    }

    public static com.amap.api.mapcore.util.ba a() {
        if (a == null) {
            synchronized (com.amap.api.mapcore.util.ba.class) {
                if (a == null) {
                    a = new com.amap.api.mapcore.util.ba();
                }
            }
        }
        return a;
    }

    @Override // com.amap.api.mapcore.util.gg
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "DB", "onCreate");
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.gg
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i) {
        if (sQLiteDatabase != null && i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
            android.database.Cursor query = sQLiteDatabase.query("update_item", null, null, null, null, null, null);
            if (query == null) {
                sQLiteDatabase.close();
                sQLiteDatabase = null;
            }
            if (query != null) {
                while (query.moveToNext()) {
                    java.lang.String string = query.getString(query.getColumnIndex("url"));
                    java.lang.String substring = string.substring(string.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1);
                    sQLiteDatabase.execSQL("update update_item set mPinyin=? where url =?", new java.lang.String[]{substring.substring(0, substring.lastIndexOf(".")), string});
                }
                query.close();
            }
        }
    }

    @Override // com.amap.api.mapcore.util.gg
    public final java.lang.String b() {
        return "offlineDbV4.db";
    }
}
