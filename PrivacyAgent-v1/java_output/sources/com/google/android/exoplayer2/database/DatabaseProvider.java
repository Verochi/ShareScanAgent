package com.google.android.exoplayer2.database;

/* loaded from: classes22.dex */
public interface DatabaseProvider {
    public static final java.lang.String TABLE_PREFIX = "ExoPlayer";

    android.database.sqlite.SQLiteDatabase getReadableDatabase();

    android.database.sqlite.SQLiteDatabase getWritableDatabase();
}
