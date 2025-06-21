package com.sensorsdata.analytics.android.sdk.data;

/* loaded from: classes19.dex */
public class OldBDatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    public OldBDatabaseHelper(android.content.Context context, java.lang.String str) {
        super(context, str, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 4);
    }

    public void getAllEvents(android.database.sqlite.SQLiteDatabase sQLiteDatabase, com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.QueryEventsListener queryEventsListener) {
        android.database.Cursor cursor = null;
        try {
            try {
                cursor = getReadableDatabase().rawQuery(java.lang.String.format("SELECT * FROM %s ORDER BY %s", "events", com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CREATED_AT), null);
                sQLiteDatabase.beginTransaction();
                while (cursor.moveToNext()) {
                    queryEventsListener.insert(cursor.getString(cursor.getColumnIndex("data")), cursor.getString(cursor.getColumnIndex(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CREATED_AT)));
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                close();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                sQLiteDatabase.endTransaction();
                close();
                if (cursor == null) {
                    return;
                }
            }
            cursor.close();
        } catch (java.lang.Throwable th) {
            sQLiteDatabase.endTransaction();
            close();
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
