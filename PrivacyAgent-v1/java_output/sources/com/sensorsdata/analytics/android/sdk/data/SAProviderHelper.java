package com.sensorsdata.analytics.android.sdk.data;

/* loaded from: classes19.dex */
public class SAProviderHelper {
    private static com.sensorsdata.analytics.android.sdk.data.SAProviderHelper INSTANCE = null;
    private static final java.lang.String TAG = "SA.ProviderHelper";
    private android.content.ContentResolver contentResolver;
    private android.content.Context mContext;
    private android.database.sqlite.SQLiteOpenHelper mDbHelper;
    private boolean isDbWritable = true;
    private boolean mIsFlushDataState = false;
    private int startActivityCount = 0;
    private long mAppStartTime = 0;
    private int mSessionTime = 30000;

    /* renamed from: com.sensorsdata.analytics.android.sdk.data.SAProviderHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context val$context;

        /* renamed from: com.sensorsdata.analytics.android.sdk.data.SAProviderHelper$1$1, reason: invalid class name and collision with other inner class name */
        public class C04391 implements com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.QueryEventsListener {
            final /* synthetic */ android.content.ContentValues val$cv;
            final /* synthetic */ android.database.sqlite.SQLiteDatabase val$database;

            public C04391(android.content.ContentValues contentValues, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
                this.val$cv = contentValues;
                this.val$database = sQLiteDatabase;
            }

            @Override // com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.QueryEventsListener
            public void insert(java.lang.String str, java.lang.String str2) {
                this.val$cv.put("data", str);
                this.val$cv.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CREATED_AT, str2);
                this.val$database.insert("events", "_id", this.val$cv);
                this.val$cv.clear();
            }
        }

        public AnonymousClass1(android.content.Context context) {
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.String packageName = this.val$context.getPackageName();
                if (this.val$context.getDatabasePath(packageName).exists()) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.TAG, "start migratingDB");
                    com.sensorsdata.analytics.android.sdk.data.OldBDatabaseHelper oldBDatabaseHelper = new com.sensorsdata.analytics.android.sdk.data.OldBDatabaseHelper(this.val$context, packageName);
                    android.database.sqlite.SQLiteDatabase writableDatabase = com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.this.getWritableDatabase();
                    if (writableDatabase != null) {
                        oldBDatabaseHelper.getAllEvents(writableDatabase, new com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.AnonymousClass1.C04391(new android.content.ContentValues(), writableDatabase));
                    }
                }
                if (com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.this.isDbWritable) {
                    this.val$context.deleteDatabase(packageName);
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public interface QueryEventsListener {
        void insert(java.lang.String str, java.lang.String str2);
    }

    public interface URI_CODE {
        public static final int ACTIVITY_START_COUNT = 2;
        public static final int APP_EXIT_DATA = 4;
        public static final int APP_PAUSED_TIME = 5;
        public static final int APP_START_TIME = 3;
        public static final int CHANNEL_PERSISTENT = 8;
        public static final int DISABLE_SDK = 11;
        public static final int EVENTS = 1;
        public static final int FIRST_PROCESS_START = 10;
        public static final int FLUSH_DATA = 9;
        public static final int LOGIN_ID = 7;
        public static final int LOGIN_ID_KEY = 14;
        public static final int PUSH_ID_KEY = 15;
        public static final int REMOTE_CONFIG = 12;
        public static final int SESSION_INTERVAL_TIME = 6;
        public static final int USER_IDENTITY_ID = 13;
    }

    private SAProviderHelper(android.content.Context context) {
        try {
            this.mDbHelper = new com.sensorsdata.analytics.android.sdk.data.SensorsDataDBHelper(context);
            this.mContext = context.getApplicationContext();
            this.contentResolver = context.getContentResolver();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static synchronized com.sensorsdata.analytics.android.sdk.data.SAProviderHelper getInstance(android.content.Context context) {
        com.sensorsdata.analytics.android.sdk.data.SAProviderHelper sAProviderHelper;
        synchronized (com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.class) {
            if (INSTANCE == null) {
                INSTANCE = new com.sensorsdata.analytics.android.sdk.data.SAProviderHelper(context);
            }
            sAProviderHelper = INSTANCE;
        }
        return sAProviderHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        try {
            if (!isDBExist()) {
                this.mDbHelper.close();
                this.isDbWritable = true;
            }
            return this.mDbHelper.getWritableDatabase();
        } catch (android.database.sqlite.SQLiteException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            this.isDbWritable = false;
            return null;
        }
    }

    private boolean isDBExist() {
        return this.mContext.getDatabasePath(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.DATABASE_NAME).exists();
    }

    public void appendUri(android.content.UriMatcher uriMatcher, java.lang.String str) {
        try {
            uriMatcher.addURI(str, "events", 1);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_ACTIVITY_START_COUNT, 2);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME, 3);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_EXIT_DATA, 4);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_SESSION_INTERVAL_TIME, 6);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.LOGIN_ID, 7);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_CHANNEL_PERSISTENT, 8);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA, 9);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_FIRST_PROCESS_START, 10);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_DATA_DISABLE_SDK, 11);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REMOTE_CONFIG, 12);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_USER_ID, 13);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY, 14);
            uriMatcher.addURI(str, com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY, 15);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public int bulkInsert(android.net.Uri uri, android.content.ContentValues[] contentValuesArr) {
        android.database.sqlite.SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                android.database.sqlite.SQLiteDatabase writableDatabase = this.mDbHelper.getWritableDatabase();
                writableDatabase.beginTransaction();
                int length = contentValuesArr.length;
                for (android.content.ContentValues contentValues : contentValuesArr) {
                    insertEvent(uri, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return length;
            } catch (android.database.sqlite.SQLiteException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return 0;
            }
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
    }

    public int deleteEvents(java.lang.String str, java.lang.String[] strArr) {
        if (!this.isDbWritable) {
            return 0;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.delete("events", str, strArr);
            }
        } catch (android.database.sqlite.SQLiteException e) {
            this.isDbWritable = false;
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return 0;
    }

    public android.net.Uri insertChannelPersistent(android.net.Uri uri, android.content.ContentValues contentValues) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null && contentValues.containsKey(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME)) {
                return android.content.ContentUris.withAppendedId(uri, writableDatabase.insertWithOnConflict(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_CHANNEL_PERSISTENT, null, contentValues, 5));
            }
            return uri;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return uri;
        }
    }

    public android.net.Uri insertEvent(android.net.Uri uri, android.content.ContentValues contentValues) {
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null && contentValues.containsKey("data") && contentValues.containsKey(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CREATED_AT)) {
                return android.content.ContentUris.withAppendedId(uri, writableDatabase.insert("events", "_id", contentValues));
            }
            return uri;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return uri;
        }
    }

    public void insertPersistent(int i, android.net.Uri uri, android.content.ContentValues contentValues) {
        try {
            switch (i) {
                case 2:
                    this.startActivityCount = contentValues.getAsInteger(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_ACTIVITY_START_COUNT).intValue();
                    break;
                case 3:
                    this.mAppStartTime = contentValues.getAsLong(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME).longValue();
                    break;
                case 4:
                    com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getAppExitDataPst().commit(contentValues.getAsString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_EXIT_DATA));
                    break;
                case 5:
                case 8:
                case 10:
                case 11:
                default:
                    return;
                case 6:
                    this.mSessionTime = contentValues.getAsInteger(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_SESSION_INTERVAL_TIME).intValue();
                    this.contentResolver.notifyChange(uri, null);
                    break;
                case 7:
                    com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getLoginIdPst().commit(contentValues.getAsString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.LOGIN_ID));
                    this.contentResolver.notifyChange(uri, null);
                    break;
                case 9:
                    this.mIsFlushDataState = contentValues.getAsBoolean(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA).booleanValue();
                    break;
                case 12:
                    com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getRemoteSDKConfig().commit(contentValues.getAsString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REMOTE_CONFIG));
                    break;
                case 13:
                    com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getUserIdsPst().commit(contentValues.getAsString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_USER_ID));
                    this.contentResolver.notifyChange(uri, null);
                    break;
                case 14:
                    com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getLoginIdKeyPst().commit(contentValues.getAsString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY));
                    break;
                case 15:
                    com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setString(contentValues.getAsString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY), contentValues.getAsString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_VALUE));
                    break;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void migratingDB(android.content.Context context) {
        try {
            if (com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getAppInfoBundle(context).getBoolean("com.sensorsdata.analytics.android.EnableMigratingDB", true)) {
                new java.lang.Thread(new com.sensorsdata.analytics.android.sdk.data.SAProviderHelper.AnonymousClass1(context)).start();
            } else {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "The migrating DB operation is false");
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public android.database.Cursor queryByTable(java.lang.String str, java.lang.String[] strArr, java.lang.String str2, java.lang.String[] strArr2, java.lang.String str3) {
        if (!this.isDbWritable) {
            return null;
        }
        try {
            android.database.sqlite.SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.query(str, strArr, str2, strArr2, null, null, str3);
            }
            return null;
        } catch (android.database.sqlite.SQLiteException e) {
            this.isDbWritable = false;
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public android.database.Cursor queryPersistent(int i, android.net.Uri uri) {
        java.lang.Object obj;
        java.lang.String str = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY;
        try {
            switch (i) {
                case 2:
                    java.lang.Object valueOf = java.lang.Integer.valueOf(this.startActivityCount);
                    str = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_ACTIVITY_START_COUNT;
                    obj = valueOf;
                    break;
                case 3:
                    java.lang.Object valueOf2 = java.lang.Long.valueOf(this.mAppStartTime);
                    str = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME;
                    obj = valueOf2;
                    break;
                case 4:
                    java.lang.String str2 = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getAppExitDataPst().get();
                    boolean isEmpty = android.text.TextUtils.isEmpty(str2);
                    java.lang.String str3 = str2;
                    if (isEmpty) {
                        java.lang.String str4 = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getAppEndDataPst().get();
                        com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getAppEndDataPst().remove();
                        str3 = str4;
                    }
                    str = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_EXIT_DATA;
                    obj = str3;
                    break;
                case 5:
                case 8:
                case 10:
                case 11:
                default:
                    obj = null;
                    str = null;
                    break;
                case 6:
                    java.lang.Object valueOf3 = java.lang.Integer.valueOf(this.mSessionTime);
                    str = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_SESSION_INTERVAL_TIME;
                    obj = valueOf3;
                    break;
                case 7:
                    java.lang.Object obj2 = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getLoginIdPst().get();
                    str = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.LOGIN_ID;
                    obj = obj2;
                    break;
                case 9:
                    java.lang.Object valueOf4 = java.lang.Integer.valueOf(this.mIsFlushDataState ? 1 : 0);
                    str = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA;
                    obj = valueOf4;
                    break;
                case 12:
                    str = null;
                    obj = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getRemoteSDKConfig().get();
                    break;
                case 13:
                    java.lang.Object obj3 = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getUserIdsPst().get();
                    str = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_USER_ID;
                    obj = obj3;
                    break;
                case 14:
                    java.lang.Object obj4 = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getLoginIdKeyPst().get();
                    str = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY;
                    obj = obj4;
                    break;
                case 15:
                    obj = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().getString(uri.getQueryParameter(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY), "");
                    break;
            }
            android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(new java.lang.String[]{str});
            matrixCursor.addRow(new java.lang.Object[]{obj});
            return matrixCursor;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public int removeSP(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().remove(str);
        return 1;
    }
}
