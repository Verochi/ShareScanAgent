package com.google.android.exoplayer2.database;

/* loaded from: classes22.dex */
public final class DefaultDatabaseProvider implements com.google.android.exoplayer2.database.DatabaseProvider {
    public final android.database.sqlite.SQLiteOpenHelper n;

    public DefaultDatabaseProvider(android.database.sqlite.SQLiteOpenHelper sQLiteOpenHelper) {
        this.n = sQLiteOpenHelper;
    }

    @Override // com.google.android.exoplayer2.database.DatabaseProvider
    public android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        return this.n.getReadableDatabase();
    }

    @Override // com.google.android.exoplayer2.database.DatabaseProvider
    public android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        return this.n.getWritableDatabase();
    }
}
