package com.google.android.exoplayer2.upstream.cache;

/* loaded from: classes22.dex */
final class CacheFileMetadataIndex {
    public static final java.lang.String[] c = {"name", "length", "last_touch_timestamp"};
    public final com.google.android.exoplayer2.database.DatabaseProvider a;
    public java.lang.String b;

    public CacheFileMetadataIndex(com.google.android.exoplayer2.database.DatabaseProvider databaseProvider) {
        this.a = databaseProvider;
    }

    public static void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str) {
        java.lang.String valueOf = java.lang.String.valueOf(str);
        sQLiteDatabase.execSQL(valueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(valueOf) : new java.lang.String("DROP TABLE IF EXISTS "));
    }

    public static java.lang.String d(java.lang.String str) {
        java.lang.String valueOf = java.lang.String.valueOf(str);
        return valueOf.length() != 0 ? "ExoPlayerCacheFileMetadata".concat(valueOf) : new java.lang.String("ExoPlayerCacheFileMetadata");
    }

    @androidx.annotation.WorkerThread
    public static void delete(com.google.android.exoplayer2.database.DatabaseProvider databaseProvider, long j) throws com.google.android.exoplayer2.database.DatabaseIOException {
        java.lang.String hexString = java.lang.Long.toHexString(j);
        try {
            java.lang.String d = d(hexString);
            android.database.sqlite.SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                com.google.android.exoplayer2.database.VersionTable.removeVersion(writableDatabase, 2, hexString);
                a(writableDatabase, d);
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (android.database.SQLException e) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e);
        }
    }

    @androidx.annotation.WorkerThread
    public java.util.Map<java.lang.String, com.google.android.exoplayer2.upstream.cache.CacheFileMetadata> b() throws com.google.android.exoplayer2.database.DatabaseIOException {
        try {
            android.database.Cursor c2 = c();
            try {
                java.util.HashMap hashMap = new java.util.HashMap(c2.getCount());
                while (c2.moveToNext()) {
                    hashMap.put(c2.getString(0), new com.google.android.exoplayer2.upstream.cache.CacheFileMetadata(c2.getLong(1), c2.getLong(2)));
                }
                c2.close();
                return hashMap;
            } finally {
            }
        } catch (android.database.SQLException e) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e);
        }
    }

    public final android.database.Cursor c() {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b);
        return this.a.getReadableDatabase().query(this.b, c, null, null, null, null, null);
    }

    @androidx.annotation.WorkerThread
    public void e(long j) throws com.google.android.exoplayer2.database.DatabaseIOException {
        try {
            java.lang.String hexString = java.lang.Long.toHexString(j);
            this.b = d(hexString);
            if (com.google.android.exoplayer2.database.VersionTable.getVersion(this.a.getReadableDatabase(), 2, hexString) != 1) {
                android.database.sqlite.SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    com.google.android.exoplayer2.database.VersionTable.setVersion(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.b);
                    java.lang.String str = this.b;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 108);
                    sb.append("CREATE TABLE ");
                    sb.append(str);
                    sb.append(" ");
                    sb.append("(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.execSQL(sb.toString());
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (java.lang.Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        } catch (android.database.SQLException e) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e);
        }
    }

    @androidx.annotation.WorkerThread
    public void f(java.lang.String str) throws com.google.android.exoplayer2.database.DatabaseIOException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b);
        try {
            this.a.getWritableDatabase().delete(this.b, "name = ?", new java.lang.String[]{str});
        } catch (android.database.SQLException e) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e);
        }
    }

    @androidx.annotation.WorkerThread
    public void g(java.util.Set<java.lang.String> set) throws com.google.android.exoplayer2.database.DatabaseIOException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b);
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                java.util.Iterator<java.lang.String> it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.b, "name = ?", new java.lang.String[]{it.next()});
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (android.database.SQLException e) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e);
        }
    }

    @androidx.annotation.WorkerThread
    public void h(java.lang.String str, long j, long j2) throws com.google.android.exoplayer2.database.DatabaseIOException {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(this.b);
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", java.lang.Long.valueOf(j));
            contentValues.put("last_touch_timestamp", java.lang.Long.valueOf(j2));
            writableDatabase.replaceOrThrow(this.b, null, contentValues);
        } catch (android.database.SQLException e) {
            throw new com.google.android.exoplayer2.database.DatabaseIOException(e);
        }
    }
}
