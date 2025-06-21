package androidx.sqlite.db.framework;

/* loaded from: classes.dex */
class FrameworkSQLiteOpenHelper implements androidx.sqlite.db.SupportSQLiteOpenHelper {
    private final androidx.sqlite.db.SupportSQLiteOpenHelper.Callback mCallback;
    private final android.content.Context mContext;
    private androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper mDelegate;
    private final java.lang.Object mLock;
    private final java.lang.String mName;
    private final boolean mUseNoBackupDirectory;
    private boolean mWriteAheadLoggingEnabled;

    public static class OpenHelper extends android.database.sqlite.SQLiteOpenHelper {
        final androidx.sqlite.db.SupportSQLiteOpenHelper.Callback mCallback;
        final androidx.sqlite.db.framework.FrameworkSQLiteDatabase[] mDbRef;
        private boolean mMigrated;

        /* renamed from: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$1, reason: invalid class name */
        public class AnonymousClass1 implements android.database.DatabaseErrorHandler {
            final /* synthetic */ androidx.sqlite.db.SupportSQLiteOpenHelper.Callback val$callback;
            final /* synthetic */ androidx.sqlite.db.framework.FrameworkSQLiteDatabase[] val$dbRef;

            public AnonymousClass1(androidx.sqlite.db.SupportSQLiteOpenHelper.Callback callback, androidx.sqlite.db.framework.FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr) {
                this.val$callback = callback;
                this.val$dbRef = frameworkSQLiteDatabaseArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
                this.val$callback.onCorruption(androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.getWrappedDb(this.val$dbRef, sQLiteDatabase));
            }
        }

        public OpenHelper(android.content.Context context, java.lang.String str, androidx.sqlite.db.framework.FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, androidx.sqlite.db.SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, null, callback.version, new androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.AnonymousClass1(callback, frameworkSQLiteDatabaseArr));
            this.mCallback = callback;
            this.mDbRef = frameworkSQLiteDatabaseArr;
        }

        public static androidx.sqlite.db.framework.FrameworkSQLiteDatabase getWrappedDb(androidx.sqlite.db.framework.FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            androidx.sqlite.db.framework.FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
            if (frameworkSQLiteDatabase == null || !frameworkSQLiteDatabase.isDelegate(sQLiteDatabase)) {
                frameworkSQLiteDatabaseArr[0] = new androidx.sqlite.db.framework.FrameworkSQLiteDatabase(sQLiteDatabase);
            }
            return frameworkSQLiteDatabaseArr[0];
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.mDbRef[0] = null;
        }

        public synchronized androidx.sqlite.db.SupportSQLiteDatabase getReadableSupportDatabase() {
            this.mMigrated = false;
            android.database.sqlite.SQLiteDatabase readableDatabase = super.getReadableDatabase();
            if (!this.mMigrated) {
                return getWrappedDb(readableDatabase);
            }
            close();
            return getReadableSupportDatabase();
        }

        public androidx.sqlite.db.framework.FrameworkSQLiteDatabase getWrappedDb(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            return getWrappedDb(this.mDbRef, sQLiteDatabase);
        }

        public synchronized androidx.sqlite.db.SupportSQLiteDatabase getWritableSupportDatabase() {
            this.mMigrated = false;
            android.database.sqlite.SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (!this.mMigrated) {
                return getWrappedDb(writableDatabase);
            }
            close();
            return getWritableSupportDatabase();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            this.mCallback.onConfigure(getWrappedDb(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            this.mCallback.onCreate(getWrappedDb(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.mMigrated = true;
            this.mCallback.onDowngrade(getWrappedDb(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            if (this.mMigrated) {
                return;
            }
            this.mCallback.onOpen(getWrappedDb(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.mMigrated = true;
            this.mCallback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
        }
    }

    public FrameworkSQLiteOpenHelper(android.content.Context context, java.lang.String str, androidx.sqlite.db.SupportSQLiteOpenHelper.Callback callback) {
        this(context, str, callback, false);
    }

    public FrameworkSQLiteOpenHelper(android.content.Context context, java.lang.String str, androidx.sqlite.db.SupportSQLiteOpenHelper.Callback callback, boolean z) {
        this.mContext = context;
        this.mName = str;
        this.mCallback = callback;
        this.mUseNoBackupDirectory = z;
        this.mLock = new java.lang.Object();
    }

    private androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper getDelegate() {
        androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper openHelper;
        synchronized (this.mLock) {
            if (this.mDelegate == null) {
                androidx.sqlite.db.framework.FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr = new androidx.sqlite.db.framework.FrameworkSQLiteDatabase[1];
                if (android.os.Build.VERSION.SDK_INT < 23 || this.mName == null || !this.mUseNoBackupDirectory) {
                    this.mDelegate = new androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper(this.mContext, this.mName, frameworkSQLiteDatabaseArr, this.mCallback);
                } else {
                    this.mDelegate = new androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper(this.mContext, new java.io.File(androidx.sqlite.db.SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(this.mContext), this.mName).getAbsolutePath(), frameworkSQLiteDatabaseArr, this.mCallback);
                }
                androidx.sqlite.db.SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(this.mDelegate, this.mWriteAheadLoggingEnabled);
            }
            openHelper = this.mDelegate;
        }
        return openHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        getDelegate().close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public java.lang.String getDatabaseName() {
        return this.mName;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public androidx.sqlite.db.SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getReadableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public androidx.sqlite.db.SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getWritableSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @androidx.annotation.RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.mLock) {
            androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper openHelper = this.mDelegate;
            if (openHelper != null) {
                androidx.sqlite.db.SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(openHelper, z);
            }
            this.mWriteAheadLoggingEnabled = z;
        }
    }
}
