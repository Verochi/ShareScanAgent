package com.sensorsdata.sf.core.data;

/* loaded from: classes19.dex */
class SFProviderHelper {
    private final android.database.sqlite.SQLiteOpenHelper mDbHelper;
    private final android.content.SharedPreferences mSP;

    public interface URI_CODE {
        public static final int PLAN = 1;
        public static final int SP = 3;
        public static final int USER = 2;
    }

    public SFProviderHelper(android.database.sqlite.SQLiteOpenHelper sQLiteOpenHelper, android.content.Context context) {
        this.mSP = context.getSharedPreferences("com.sensorsdata.sf.cache", 0);
        this.mDbHelper = sQLiteOpenHelper;
    }

    public int deletePlan(java.lang.String str, java.lang.String str2, java.lang.String[] strArr) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = this.mDbHelper.getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.delete(str, str2, strArr);
            }
            return 0;
        } catch (android.database.sqlite.SQLiteException e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return 0;
        }
    }

    public android.database.Cursor getSPValue(java.lang.String str) {
        java.lang.String string = this.mSP.getString(str, "");
        android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(new java.lang.String[]{string});
        matrixCursor.addRow(new java.lang.String[]{string});
        return matrixCursor;
    }

    public android.net.Uri insert(java.lang.String str, android.net.Uri uri, android.content.ContentValues contentValues) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = this.mDbHelper.getWritableDatabase();
            return writableDatabase == null ? uri : android.content.ContentUris.withAppendedId(uri, writableDatabase.insert(str, null, contentValues));
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return uri;
        }
    }

    public void migrationData() {
        java.lang.String str;
        java.lang.String str2;
        android.database.Cursor queryByTable = queryByTable("plans", new java.lang.String[]{"user_id", "remote_plan", "local_plan", "update_time"}, null, null, null);
        android.database.sqlite.SQLiteDatabase writableDatabase = this.mDbHelper.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.beginTransaction();
            try {
                try {
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    if (queryByTable == null || !queryByTable.moveToFirst()) {
                        str = "users";
                        str2 = "distinct_id";
                    } else {
                        java.lang.String string = queryByTable.getString(queryByTable.getColumnIndex("user_id"));
                        java.lang.String string2 = queryByTable.getString(queryByTable.getColumnIndex("remote_plan"));
                        java.lang.String string3 = queryByTable.getString(queryByTable.getColumnIndex("local_plan"));
                        str = "users";
                        str2 = "distinct_id";
                        long j = queryByTable.getInt(queryByTable.getColumnIndex("update_time"));
                        contentValues.clear();
                        contentValues.put("user_id", com.sensorsdata.sf.core.data.SecretUtil.encryptAES(string));
                        contentValues.put("remote_plan", com.sensorsdata.sf.core.data.SecretUtil.encryptAES(string2));
                        contentValues.put("local_plan", com.sensorsdata.sf.core.data.SecretUtil.encryptAES(string3));
                        contentValues.put("update_time", java.lang.Long.valueOf(j));
                        writableDatabase.insert("plans", null, contentValues);
                        writableDatabase.delete("plans", "user_id =? ", new java.lang.String[]{string});
                    }
                    if (queryByTable != null) {
                        queryByTable.close();
                    }
                    java.lang.String str3 = str2;
                    android.database.Cursor queryByTable2 = queryByTable("users", new java.lang.String[]{str3, "user_id"}, null, null, null);
                    if (queryByTable2 != null && queryByTable2.moveToFirst()) {
                        java.lang.String string4 = queryByTable2.getString(queryByTable2.getColumnIndex("user_id"));
                        java.lang.String string5 = queryByTable2.getString(queryByTable2.getColumnIndex(str3));
                        contentValues.clear();
                        contentValues.put("user_id", com.sensorsdata.sf.core.data.SecretUtil.encryptAES(string4));
                        contentValues.put(str3, com.sensorsdata.sf.core.data.SecretUtil.encryptAES(string5));
                        java.lang.String str4 = str;
                        writableDatabase.insert(str4, null, contentValues);
                        writableDatabase.delete(str4, "distinct_id =? ", new java.lang.String[]{string5});
                    }
                    if (queryByTable2 != null) {
                        queryByTable2.close();
                    }
                    writableDatabase.setTransactionSuccessful();
                } catch (java.lang.Exception e) {
                    com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
                }
            } finally {
                writableDatabase.endTransaction();
            }
        }
    }

    public android.database.Cursor queryByTable(java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, java.lang.String str3) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = this.mDbHelper.getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.query(str, strArr, str2, strArr2, null, null, str3);
            }
            return null;
        } catch (android.database.sqlite.SQLiteException e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return null;
        }
    }

    public void setSPValue(java.lang.String str, java.lang.String str2) {
        this.mSP.edit().putString(str, str2).apply();
    }

    public int update(java.lang.String str, android.content.ContentValues contentValues, java.lang.String str2, java.lang.String[] strArr) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = this.mDbHelper.getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.update(str, contentValues, str2, strArr);
            }
            return -1;
        } catch (android.database.sqlite.SQLiteException e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
            return -1;
        }
    }
}
