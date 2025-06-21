package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

/* loaded from: classes.dex */
class DatabaseSourceInfoStorage extends android.database.sqlite.SQLiteOpenHelper implements com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage {
    private static final java.lang.String COLUMN_ID = "_id";
    private static final java.lang.String COLUMN_MIME = "mime";
    private static final java.lang.String COLUMN_URL = "url";
    private static final java.lang.String CREATE_SQL = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";
    private static final java.lang.String TABLE = "SourceInfo";
    private static final java.lang.String COLUMN_LENGTH = "length";
    private static final java.lang.String[] ALL_COLUMNS = {"_id", "url", COLUMN_LENGTH, "mime"};

    public DatabaseSourceInfoStorage(android.content.Context context) {
        super(context, "AndroidVideoCache.db", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(context);
    }

    private android.content.ContentValues convert(com.alimm.tanx.core.view.player.cache.videocache.SourceInfo sourceInfo) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("url", sourceInfo.url);
        contentValues.put(COLUMN_LENGTH, java.lang.Long.valueOf(sourceInfo.length));
        contentValues.put("mime", sourceInfo.mime);
        return contentValues;
    }

    private com.alimm.tanx.core.view.player.cache.videocache.SourceInfo convert(android.database.Cursor cursor) {
        return new com.alimm.tanx.core.view.player.cache.videocache.SourceInfo(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_LENGTH)), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public com.alimm.tanx.core.view.player.cache.videocache.SourceInfo get(java.lang.String str) {
        java.lang.Throwable th;
        android.database.Cursor cursor;
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(str);
        com.alimm.tanx.core.view.player.cache.videocache.SourceInfo sourceInfo = null;
        try {
            cursor = getReadableDatabase().query(TABLE, ALL_COLUMNS, "url=?", new java.lang.String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        sourceInfo = convert(cursor);
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return sourceInfo;
        } catch (java.lang.Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL(CREATE_SQL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new java.lang.IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public void put(java.lang.String str, com.alimm.tanx.core.view.player.cache.videocache.SourceInfo sourceInfo) {
        com.alimm.tanx.core.view.player.cache.videocache.Preconditions.checkAllNotNull(str, sourceInfo);
        boolean z = get(str) != null;
        android.content.ContentValues convert = convert(sourceInfo);
        if (z) {
            getWritableDatabase().update(TABLE, convert, "url=?", new java.lang.String[]{str});
        } else {
            getWritableDatabase().insert(TABLE, null, convert);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public void release() {
        close();
    }
}
