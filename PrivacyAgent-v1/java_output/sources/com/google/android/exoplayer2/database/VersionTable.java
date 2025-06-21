package com.google.android.exoplayer2.database;

/* loaded from: classes22.dex */
public final class VersionTable {
    public static final int FEATURE_CACHE_CONTENT_METADATA = 1;
    public static final int FEATURE_CACHE_FILE_METADATA = 2;
    public static final int FEATURE_EXTERNAL = 1000;
    public static final int FEATURE_OFFLINE = 0;
    public static final int VERSION_UNSET = -1;

    public static java.lang.String[] a(int i, java.lang.String str) {
        return new java.lang.String[]{java.lang.Integer.toString(i), str};
    }

    public static int getVersion(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, java.lang.String str) throws com.google.android.exoplayer2.database.DatabaseIOException {
        try {
            if (!com.google.android.exoplayer2.util.Util.tableExists(sQLiteDatabase, "ExoPlayerVersions")) {
                return -1;
            }
            android.database.Cursor query = sQLiteDatabase.query("ExoPlayerVersions", new java.lang.String[]{"version"}, "feature = ? AND instance_uid = ?", a(i, str), null, null, null);
            try {
                if (query.getCount() == 0) {
                    query.close();
                    return -1;
                }
                query.moveToNext();
                int i2 = query.getInt(0);
                query.close();
                return i2;
            } finally {
            }
        } catch (android.database.SQLException e) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e);
        }
    }

    public static void removeVersion(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, java.lang.String str) throws com.google.android.exoplayer2.database.DatabaseIOException {
        try {
            if (com.google.android.exoplayer2.util.Util.tableExists(sQLiteDatabase, "ExoPlayerVersions")) {
                sQLiteDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", a(i, str));
            }
        } catch (android.database.SQLException e) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e);
        }
    }

    public static void setVersion(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, java.lang.String str, int i2) throws com.google.android.exoplayer2.database.DatabaseIOException {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(org.apache.tools.ant.taskdefs.condition.ParserSupports.FEATURE, java.lang.Integer.valueOf(i));
            contentValues.put("instance_uid", str);
            contentValues.put("version", java.lang.Integer.valueOf(i2));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", null, contentValues);
        } catch (android.database.SQLException e) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e);
        }
    }
}
