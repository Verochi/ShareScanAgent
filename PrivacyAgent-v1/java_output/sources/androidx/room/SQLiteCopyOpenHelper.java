package androidx.room;

/* loaded from: classes.dex */
class SQLiteCopyOpenHelper implements androidx.sqlite.db.SupportSQLiteOpenHelper, androidx.room.DelegatingOpenHelper {

    @androidx.annotation.NonNull
    private final android.content.Context mContext;

    @androidx.annotation.Nullable
    private final java.lang.String mCopyFromAssetPath;

    @androidx.annotation.Nullable
    private final java.io.File mCopyFromFile;

    @androidx.annotation.Nullable
    private final java.util.concurrent.Callable<java.io.InputStream> mCopyFromInputStream;

    @androidx.annotation.Nullable
    private androidx.room.DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;

    @androidx.annotation.NonNull
    private final androidx.sqlite.db.SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

    /* renamed from: androidx.room.SQLiteCopyOpenHelper$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.sqlite.db.SupportSQLiteOpenHelper.Callback {
        public AnonymousClass1(int i) {
            super(i);
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onCreate(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public void onUpgrade(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        }
    }

    public SQLiteCopyOpenHelper(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.io.File file, @androidx.annotation.Nullable java.util.concurrent.Callable<java.io.InputStream> callable, int i, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.mContext = context;
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDatabaseVersion = i;
        this.mDelegate = supportSQLiteOpenHelper;
    }

    private void copyDatabaseFile(java.io.File file, boolean z) throws java.io.IOException {
        java.nio.channels.ReadableByteChannel newChannel;
        if (this.mCopyFromAssetPath != null) {
            newChannel = java.nio.channels.Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
        } else if (this.mCopyFromFile != null) {
            newChannel = new java.io.FileInputStream(this.mCopyFromFile).getChannel();
        } else {
            java.util.concurrent.Callable<java.io.InputStream> callable = this.mCopyFromInputStream;
            if (callable == null) {
                throw new java.lang.IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                newChannel = java.nio.channels.Channels.newChannel(callable.call());
            } catch (java.lang.Exception e) {
                throw new java.io.IOException("inputStreamCallable exception on call", e);
            }
        }
        java.io.File createTempFile = java.io.File.createTempFile("room-copy-helper", com.baidu.mobads.sdk.internal.al.k, this.mContext.getCacheDir());
        createTempFile.deleteOnExit();
        androidx.room.util.FileUtil.copy(newChannel, new java.io.FileOutputStream(createTempFile).getChannel());
        java.io.File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new java.io.IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        dispatchOnOpenPrepackagedDatabase(createTempFile, z);
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new java.io.IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private androidx.sqlite.db.SupportSQLiteOpenHelper createFrameworkOpenHelper(java.io.File file) {
        try {
            return new androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory().create(androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.builder(this.mContext).name(file.getName()).callback(new androidx.room.SQLiteCopyOpenHelper.AnonymousClass1(androidx.room.util.DBUtil.readVersion(file))).build());
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException("Malformed database file, unable to read version.", e);
        }
    }

    private void dispatchOnOpenPrepackagedDatabase(java.io.File file, boolean z) {
        androidx.room.DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        if (databaseConfiguration == null || databaseConfiguration.prepackagedDatabaseCallback == null) {
            return;
        }
        androidx.sqlite.db.SupportSQLiteOpenHelper createFrameworkOpenHelper = createFrameworkOpenHelper(file);
        try {
            this.mDatabaseConfiguration.prepackagedDatabaseCallback.onOpenPrepackagedDatabase(z ? createFrameworkOpenHelper.getWritableDatabase() : createFrameworkOpenHelper.getReadableDatabase());
        } finally {
            createFrameworkOpenHelper.close();
        }
    }

    private void verifyDatabaseFile(boolean z) {
        java.lang.String databaseName = getDatabaseName();
        java.io.File databasePath = this.mContext.getDatabasePath(databaseName);
        androidx.room.DatabaseConfiguration databaseConfiguration = this.mDatabaseConfiguration;
        androidx.room.util.CopyLock copyLock = new androidx.room.util.CopyLock(databaseName, this.mContext.getFilesDir(), databaseConfiguration == null || databaseConfiguration.multiInstanceInvalidation);
        try {
            copyLock.lock();
            if (!databasePath.exists()) {
                try {
                    copyDatabaseFile(databasePath, z);
                    return;
                } catch (java.io.IOException e) {
                    throw new java.lang.RuntimeException("Unable to copy database file.", e);
                }
            }
            if (this.mDatabaseConfiguration == null) {
                return;
            }
            try {
                int readVersion = androidx.room.util.DBUtil.readVersion(databasePath);
                int i = this.mDatabaseVersion;
                if (readVersion == i) {
                    return;
                }
                if (this.mDatabaseConfiguration.isMigrationRequired(readVersion, i)) {
                    return;
                }
                if (this.mContext.deleteDatabase(databaseName)) {
                    try {
                        copyDatabaseFile(databasePath, z);
                    } catch (java.io.IOException unused) {
                    }
                } else {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Failed to delete database file (");
                    sb.append(databaseName);
                    sb.append(") for a copy destructive migration.");
                }
            } catch (java.io.IOException unused2) {
            }
        } finally {
            copyLock.unlock();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.mDelegate.close();
        this.mVerified = false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public java.lang.String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @androidx.annotation.NonNull
    public androidx.sqlite.db.SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized androidx.sqlite.db.SupportSQLiteDatabase getReadableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile(false);
            this.mVerified = true;
        }
        return this.mDelegate.getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized androidx.sqlite.db.SupportSQLiteDatabase getWritableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile(true);
            this.mVerified = true;
        }
        return this.mDelegate.getWritableDatabase();
    }

    public void setDatabaseConfiguration(@androidx.annotation.Nullable androidx.room.DatabaseConfiguration databaseConfiguration) {
        this.mDatabaseConfiguration = databaseConfiguration;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @androidx.annotation.RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.mDelegate.setWriteAheadLoggingEnabled(z);
    }
}
