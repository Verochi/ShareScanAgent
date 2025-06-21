package com.getui.gtc.base.db;

/* loaded from: classes22.dex */
public abstract class AbstractTable {
    private com.getui.gtc.base.db.AbstractDb db;

    public abstract java.lang.String createSql();

    public int delete(java.lang.String str, java.lang.String[] strArr) {
        return getWritableDatabase().delete(getTableName(), str, strArr);
    }

    public void execSql(java.lang.String str) {
        getWritableDatabase().execSQL(str);
    }

    public final android.database.sqlite.SQLiteDatabase getReadableDatabase() {
        com.getui.gtc.base.db.AbstractDb abstractDb = this.db;
        if (abstractDb != null) {
            return abstractDb.getHelper().getReadableDatabase();
        }
        throw new java.lang.RuntimeException("table " + getTableName() + " has not been added to a db");
    }

    public abstract java.lang.String getTableName();

    public final android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        com.getui.gtc.base.db.AbstractDb abstractDb = this.db;
        if (abstractDb != null) {
            return abstractDb.getHelper().getWritableDatabase();
        }
        throw new java.lang.RuntimeException("table " + getTableName() + " has not been added to a db");
    }

    public void initCache() {
    }

    public long insert(android.content.ContentValues contentValues) {
        return getWritableDatabase().insert(getTableName(), null, contentValues);
    }

    public void onDowngradle(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public android.database.Cursor query(java.lang.String str) {
        return getReadableDatabase().rawQuery(str, null);
    }

    public android.database.Cursor query(java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2) {
        return getReadableDatabase().query(getTableName(), strArr, str, strArr2, null, null, null);
    }

    public android.database.Cursor query(java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return getReadableDatabase().query(getTableName(), strArr, str, strArr2, str2, str3, str4);
    }

    public long replace(java.lang.String str, android.content.ContentValues contentValues) {
        return getWritableDatabase().replace(getTableName(), str, contentValues);
    }

    public final void setDb(com.getui.gtc.base.db.AbstractDb abstractDb) {
        this.db = abstractDb;
    }

    public int update(android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        return getWritableDatabase().update(getTableName(), contentValues, str, strArr);
    }
}
