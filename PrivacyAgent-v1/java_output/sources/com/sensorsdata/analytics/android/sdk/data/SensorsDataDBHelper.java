package com.sensorsdata.analytics.android.sdk.data;

/* loaded from: classes19.dex */
class SensorsDataDBHelper extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.String TAG = "SA.SQLiteOpenHelper";
    private static final java.lang.String CREATE_EVENTS_TABLE = java.lang.String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL DEFAULT 0);", "events", "data", com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CREATED_AT, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_IS_INSTANT_EVENT);
    private static final java.lang.String EVENTS_TIME_INDEX = java.lang.String.format("CREATE INDEX IF NOT EXISTS time_idx ON %s (%s);", "events", com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CREATED_AT);
    private static final java.lang.String CHANNEL_EVENT_PERSISTENT_TABLE = java.lang.String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT PRIMARY KEY, %s INTEGER)", com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_CHANNEL_PERSISTENT, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME, "result");

    public SensorsDataDBHelper(android.content.Context context) {
        super(context, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.DATABASE_NAME, (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 6);
    }

    private boolean checkColumnExist(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.lang.String str, java.lang.String str2) {
        boolean z = false;
        android.database.Cursor cursor = null;
        try {
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", null);
                    if (cursor != null) {
                        if (cursor.getColumnIndex(str2) != -1) {
                            z = true;
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    if (cursor != null) {
                        if (!cursor.isClosed()) {
                            cursor.close();
                        }
                    }
                }
                if (cursor != null) {
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } catch (java.lang.Throwable th) {
                if (cursor != null) {
                    try {
                        if (!cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (java.lang.Exception e2) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e3) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
        }
        return z;
    }

    private void createTable(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
        sQLiteDatabase.execSQL(EVENTS_TIME_INDEX);
        sQLiteDatabase.execSQL(CHANNEL_EVENT_PERSISTENT_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Creating a new Sensors Analytics DB");
        createTable(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Upgrading app, replacing Sensors Analytics DB, oldVersion:" + i + ", newVersion:" + i2);
        if (i < 4) {
            try {
                sQLiteDatabase.execSQL(java.lang.String.format("DROP TABLE IF EXISTS %s", "events"));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return;
            }
        }
        createTable(sQLiteDatabase);
        if (i < 4 || i > 5 || checkColumnExist(sQLiteDatabase, "events", com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_IS_INSTANT_EVENT)) {
            return;
        }
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN  is_instant_event INTEGER NOT NULL DEFAULT 0");
    }
}
