package com.sensorsdata.sf.core.data;

/* loaded from: classes19.dex */
class SensorsFocusDBHelper extends android.database.sqlite.SQLiteOpenHelper {
    private static final java.lang.String CREATE_PLAN_TABLE = java.lang.String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s TEXT,%s TEXT, %s INTEGER NOT NULL);", "plans", "user_id", "remote_plan", "local_plan", "update_time");
    private static final java.lang.String CREATE_USER_TABLE = java.lang.String.format("CREATE TABLE %s (%s TEXT PRIMARY KEY, %s TEXT);", "users", "distinct_id", "user_id");

    public SensorsFocusDBHelper(android.content.Context context) {
        super(context, "sensorsfocus", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_USER_TABLE);
        sQLiteDatabase.execSQL(CREATE_PLAN_TABLE);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
