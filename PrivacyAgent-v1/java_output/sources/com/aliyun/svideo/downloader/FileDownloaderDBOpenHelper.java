package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
class FileDownloaderDBOpenHelper extends android.database.sqlite.SQLiteOpenHelper {
    static final java.lang.String DATABASE_NAME = "filedownloaderfinal.db";
    final java.util.Map<java.lang.String, java.lang.String> mDbExtFieldMap;
    private com.aliyun.svideo.downloader.DbUpgradeListener mDbUpgradeListener;

    public FileDownloaderDBOpenHelper(android.content.Context context, int i, java.util.Map<java.lang.String, java.lang.String> map, com.aliyun.svideo.downloader.DbUpgradeListener dbUpgradeListener) {
        super(context, DATABASE_NAME, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, i);
        this.mDbExtFieldMap = map;
        this.mDbUpgradeListener = dbUpgradeListener;
    }

    private void upgrade2(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter table FileDownloader add nameEn VARCHAR");
        sQLiteDatabase.execSQL("alter table FileDownloader add descriptionEn VARCHAR");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("task_id", "INTEGER PRIMARY KEY");
        hashMap.put("id", "INTEGER");
        hashMap.put("name", "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.NAME_EN, "VARCHAR");
        hashMap.put("url", "VARCHAR");
        hashMap.put("path", "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.ISUNZIP, "INTEGER");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.EFFECTTYPE, "INTEGER");
        hashMap.put("key", "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.LEVEL, "INTEGER");
        hashMap.put("tag", "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.CAT, "INTEGER");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWPIC, "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEWMP4, "VARCHAR");
        hashMap.put("duration", "INTEGER");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.SORT, "INTEGER");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.ASPECT, "INTEGER");
        hashMap.put("download", "VARCHAR");
        hashMap.put("md5", "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.CNNAME, "VARCHAR");
        hashMap.put("category", "INTEGER");
        hashMap.put("banner", "VARCHAR");
        hashMap.put("icon", "VARCHAR");
        hashMap.put("description", "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.DESCRIPTION_EN, "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.ISNEW, "INTEGER");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.PREVIEW, "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.SUBID, "INTEGER");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.FONTID, "INTEGER");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.SUBICON, "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.SUBNAME, "VARCHAR");
        hashMap.put("priority", "INTEGER");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.SUBPREVIEW, "VARCHAR");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.SUBSORT, "INTEGER");
        hashMap.put(com.aliyun.svideo.downloader.FileDownloaderModel.SUBTYPE, "INTEGER");
        java.util.Map<java.lang.String, java.lang.String> map = this.mDbExtFieldMap;
        if (map != null) {
            hashMap.putAll(map);
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS FileDownloader");
        stringBuffer.append("(");
        int size = hashMap.size();
        int i = 0;
        for (java.util.Map.Entry entry : hashMap.entrySet()) {
            java.lang.String str = (java.lang.String) entry.getKey();
            java.lang.String str2 = (java.lang.String) entry.getValue();
            i++;
            if (!com.aliyun.common.utils.StringUtils.isEmpty(str) && !com.aliyun.common.utils.StringUtils.isEmpty(str2)) {
                stringBuffer.append(str);
                stringBuffer.append(" ");
                stringBuffer.append(str2);
                if (i != size) {
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.append(")");
        sQLiteDatabase.execSQL(stringBuffer.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            upgrade2(sQLiteDatabase);
        }
        com.aliyun.svideo.downloader.DbUpgradeListener dbUpgradeListener = this.mDbUpgradeListener;
        if (dbUpgradeListener != null) {
            dbUpgradeListener.onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
