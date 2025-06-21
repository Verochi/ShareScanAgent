package androidx.room;

/* loaded from: classes.dex */
public abstract class RoomDatabase {
    private static final java.lang.String DB_IMPL_SUFFIX = "_Impl";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;

    @androidx.annotation.Nullable
    private androidx.room.AutoCloser mAutoCloser;

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    protected java.util.List<androidx.room.RoomDatabase.Callback> mCallbacks;

    @java.lang.Deprecated
    protected volatile androidx.sqlite.db.SupportSQLiteDatabase mDatabase;
    private androidx.sqlite.db.SupportSQLiteOpenHelper mOpenHelper;
    private java.util.concurrent.Executor mQueryExecutor;
    private java.util.concurrent.Executor mTransactionExecutor;
    boolean mWriteAheadLoggingEnabled;
    private final java.util.concurrent.locks.ReentrantReadWriteLock mCloseLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
    private final java.lang.ThreadLocal<java.lang.Integer> mSuspendingTransactionId = new java.lang.ThreadLocal<>();
    private final java.util.Map<java.lang.String, java.lang.Object> mBackingFieldMap = java.util.Collections.synchronizedMap(new java.util.HashMap());
    private final androidx.room.InvalidationTracker mInvalidationTracker = createInvalidationTracker();
    private final java.util.Map<java.lang.Class<?>, java.lang.Object> mTypeConverters = new java.util.HashMap();

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    protected java.util.Map<java.lang.Class<? extends androidx.room.migration.AutoMigrationSpec>, androidx.room.migration.AutoMigrationSpec> mAutoMigrationSpecs = new java.util.HashMap();

    public static class Builder<T extends androidx.room.RoomDatabase> {
        private boolean mAllowDestructiveMigrationOnDowngrade;
        private boolean mAllowMainThreadQueries;
        private java.util.concurrent.TimeUnit mAutoCloseTimeUnit;
        private java.util.List<androidx.room.migration.AutoMigrationSpec> mAutoMigrationSpecs;
        private java.util.ArrayList<androidx.room.RoomDatabase.Callback> mCallbacks;
        private final android.content.Context mContext;
        private java.lang.String mCopyFromAssetPath;
        private java.io.File mCopyFromFile;
        private java.util.concurrent.Callable<java.io.InputStream> mCopyFromInputStream;
        private final java.lang.Class<T> mDatabaseClass;
        private androidx.sqlite.db.SupportSQLiteOpenHelper.Factory mFactory;
        private java.util.Set<java.lang.Integer> mMigrationStartAndEndVersions;
        private java.util.Set<java.lang.Integer> mMigrationsNotRequiredFrom;
        private boolean mMultiInstanceInvalidation;
        private final java.lang.String mName;
        private androidx.room.RoomDatabase.PrepackagedDatabaseCallback mPrepackagedDatabaseCallback;
        private androidx.room.RoomDatabase.QueryCallback mQueryCallback;
        private java.util.concurrent.Executor mQueryCallbackExecutor;
        private java.util.concurrent.Executor mQueryExecutor;
        private java.util.concurrent.Executor mTransactionExecutor;
        private java.util.List<java.lang.Object> mTypeConverters;
        private long mAutoCloseTimeout = -1;
        private androidx.room.RoomDatabase.JournalMode mJournalMode = androidx.room.RoomDatabase.JournalMode.AUTOMATIC;
        private boolean mRequireMigration = true;
        private final androidx.room.RoomDatabase.MigrationContainer mMigrationContainer = new androidx.room.RoomDatabase.MigrationContainer();

        public Builder(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.Nullable java.lang.String str) {
            this.mContext = context;
            this.mDatabaseClass = cls;
            this.mName = str;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> addAutoMigrationSpec(@androidx.annotation.NonNull androidx.room.migration.AutoMigrationSpec autoMigrationSpec) {
            if (this.mAutoMigrationSpecs == null) {
                this.mAutoMigrationSpecs = new java.util.ArrayList();
            }
            this.mAutoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> addCallback(@androidx.annotation.NonNull androidx.room.RoomDatabase.Callback callback) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new java.util.ArrayList<>();
            }
            this.mCallbacks.add(callback);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> addMigrations(@androidx.annotation.NonNull androidx.room.migration.Migration... migrationArr) {
            if (this.mMigrationStartAndEndVersions == null) {
                this.mMigrationStartAndEndVersions = new java.util.HashSet();
            }
            for (androidx.room.migration.Migration migration : migrationArr) {
                this.mMigrationStartAndEndVersions.add(java.lang.Integer.valueOf(migration.startVersion));
                this.mMigrationStartAndEndVersions.add(java.lang.Integer.valueOf(migration.endVersion));
            }
            this.mMigrationContainer.addMigrations(migrationArr);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> addTypeConverter(@androidx.annotation.NonNull java.lang.Object obj) {
            if (this.mTypeConverters == null) {
                this.mTypeConverters = new java.util.ArrayList();
            }
            this.mTypeConverters.add(obj);
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> allowMainThreadQueries() {
            this.mAllowMainThreadQueries = true;
            return this;
        }

        @androidx.annotation.NonNull
        @android.annotation.SuppressLint({"RestrictedApi"})
        public T build() {
            java.util.concurrent.Executor executor;
            if (this.mContext == null) {
                throw new java.lang.IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.mDatabaseClass == null) {
                throw new java.lang.IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            java.util.concurrent.Executor executor2 = this.mQueryExecutor;
            if (executor2 == null && this.mTransactionExecutor == null) {
                java.util.concurrent.Executor iOThreadExecutor = androidx.arch.core.executor.ArchTaskExecutor.getIOThreadExecutor();
                this.mTransactionExecutor = iOThreadExecutor;
                this.mQueryExecutor = iOThreadExecutor;
            } else if (executor2 != null && this.mTransactionExecutor == null) {
                this.mTransactionExecutor = executor2;
            } else if (executor2 == null && (executor = this.mTransactionExecutor) != null) {
                this.mQueryExecutor = executor;
            }
            java.util.Set<java.lang.Integer> set = this.mMigrationStartAndEndVersions;
            if (set != null && this.mMigrationsNotRequiredFrom != null) {
                for (java.lang.Integer num : set) {
                    if (this.mMigrationsNotRequiredFrom.contains(num)) {
                        throw new java.lang.IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                    }
                }
            }
            androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory = this.mFactory;
            if (factory == null) {
                factory = new androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory();
            }
            long j = this.mAutoCloseTimeout;
            if (j > 0) {
                if (this.mName == null) {
                    throw new java.lang.IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                }
                factory = new androidx.room.AutoClosingRoomOpenHelperFactory(factory, new androidx.room.AutoCloser(j, this.mAutoCloseTimeUnit, this.mTransactionExecutor));
            }
            java.lang.String str = this.mCopyFromAssetPath;
            if (str != null || this.mCopyFromFile != null || this.mCopyFromInputStream != null) {
                if (this.mName == null) {
                    throw new java.lang.IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                }
                int i = str == null ? 0 : 1;
                java.io.File file = this.mCopyFromFile;
                int i2 = i + (file == null ? 0 : 1);
                java.util.concurrent.Callable<java.io.InputStream> callable = this.mCopyFromInputStream;
                if (i2 + (callable != null ? 1 : 0) != 1) {
                    throw new java.lang.IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                }
                factory = new androidx.room.SQLiteCopyOpenHelperFactory(str, file, callable, factory);
            }
            androidx.room.RoomDatabase.QueryCallback queryCallback = this.mQueryCallback;
            androidx.sqlite.db.SupportSQLiteOpenHelper.Factory queryInterceptorOpenHelperFactory = queryCallback != null ? new androidx.room.QueryInterceptorOpenHelperFactory(factory, queryCallback, this.mQueryCallbackExecutor) : factory;
            android.content.Context context = this.mContext;
            androidx.room.DatabaseConfiguration databaseConfiguration = new androidx.room.DatabaseConfiguration(context, this.mName, queryInterceptorOpenHelperFactory, this.mMigrationContainer, this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.resolve(context), this.mQueryExecutor, this.mTransactionExecutor, this.mMultiInstanceInvalidation, this.mRequireMigration, this.mAllowDestructiveMigrationOnDowngrade, this.mMigrationsNotRequiredFrom, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, this.mPrepackagedDatabaseCallback, this.mTypeConverters, this.mAutoMigrationSpecs);
            T t = (T) androidx.room.Room.getGeneratedImplementation(this.mDatabaseClass, androidx.room.RoomDatabase.DB_IMPL_SUFFIX);
            t.init(databaseConfiguration);
            return t;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> createFromAsset(@androidx.annotation.NonNull java.lang.String str) {
            this.mCopyFromAssetPath = str;
            return this;
        }

        @androidx.annotation.NonNull
        @android.annotation.SuppressLint({"BuilderSetStyle"})
        public androidx.room.RoomDatabase.Builder<T> createFromAsset(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.room.RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.mCopyFromAssetPath = str;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> createFromFile(@androidx.annotation.NonNull java.io.File file) {
            this.mCopyFromFile = file;
            return this;
        }

        @androidx.annotation.NonNull
        @android.annotation.SuppressLint({"BuilderSetStyle", "StreamFiles"})
        public androidx.room.RoomDatabase.Builder<T> createFromFile(@androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull androidx.room.RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.mCopyFromFile = file;
            return this;
        }

        @androidx.annotation.NonNull
        @android.annotation.SuppressLint({"BuilderSetStyle"})
        public androidx.room.RoomDatabase.Builder<T> createFromInputStream(@androidx.annotation.NonNull java.util.concurrent.Callable<java.io.InputStream> callable) {
            this.mCopyFromInputStream = callable;
            return this;
        }

        @androidx.annotation.NonNull
        @android.annotation.SuppressLint({"BuilderSetStyle", "LambdaLast"})
        public androidx.room.RoomDatabase.Builder<T> createFromInputStream(@androidx.annotation.NonNull java.util.concurrent.Callable<java.io.InputStream> callable, @androidx.annotation.NonNull androidx.room.RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.mCopyFromInputStream = callable;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> enableMultiInstanceInvalidation() {
            this.mMultiInstanceInvalidation = this.mName != null;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> fallbackToDestructiveMigration() {
            this.mRequireMigration = false;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
            if (this.mMigrationsNotRequiredFrom == null) {
                this.mMigrationsNotRequiredFrom = new java.util.HashSet(iArr.length);
            }
            for (int i : iArr) {
                this.mMigrationsNotRequiredFrom.add(java.lang.Integer.valueOf(i));
            }
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.mRequireMigration = true;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> openHelperFactory(@androidx.annotation.Nullable androidx.sqlite.db.SupportSQLiteOpenHelper.Factory factory) {
            this.mFactory = factory;
            return this;
        }

        @androidx.annotation.NonNull
        @androidx.room.ExperimentalRoomApi
        public androidx.room.RoomDatabase.Builder<T> setAutoCloseTimeout(@androidx.annotation.IntRange(from = 0) long j, @androidx.annotation.NonNull java.util.concurrent.TimeUnit timeUnit) {
            if (j < 0) {
                throw new java.lang.IllegalArgumentException("autoCloseTimeout must be >= 0");
            }
            this.mAutoCloseTimeout = j;
            this.mAutoCloseTimeUnit = timeUnit;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> setJournalMode(@androidx.annotation.NonNull androidx.room.RoomDatabase.JournalMode journalMode) {
            this.mJournalMode = journalMode;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> setQueryCallback(@androidx.annotation.NonNull androidx.room.RoomDatabase.QueryCallback queryCallback, @androidx.annotation.NonNull java.util.concurrent.Executor executor) {
            this.mQueryCallback = queryCallback;
            this.mQueryCallbackExecutor = executor;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> setQueryExecutor(@androidx.annotation.NonNull java.util.concurrent.Executor executor) {
            this.mQueryExecutor = executor;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.room.RoomDatabase.Builder<T> setTransactionExecutor(@androidx.annotation.NonNull java.util.concurrent.Executor executor) {
            this.mTransactionExecutor = executor;
            return this;
        }
    }

    public static abstract class Callback {
        public void onCreate(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onDestructiveMigration(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onOpen(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean isLowRamDevice(@androidx.annotation.NonNull android.app.ActivityManager activityManager) {
            return androidx.sqlite.db.SupportSQLiteCompat.Api19Impl.isLowRamDevice(activityManager);
        }

        public androidx.room.RoomDatabase.JournalMode resolve(android.content.Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            android.app.ActivityManager activityManager = (android.app.ActivityManager) context.getSystemService("activity");
            return (activityManager == null || isLowRamDevice(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    public static class MigrationContainer {
        private java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, androidx.room.migration.Migration>> mMigrations = new java.util.HashMap<>();

        private void addMigration(androidx.room.migration.Migration migration) {
            int i = migration.startVersion;
            int i2 = migration.endVersion;
            java.util.TreeMap<java.lang.Integer, androidx.room.migration.Migration> treeMap = this.mMigrations.get(java.lang.Integer.valueOf(i));
            if (treeMap == null) {
                treeMap = new java.util.TreeMap<>();
                this.mMigrations.put(java.lang.Integer.valueOf(i), treeMap);
            }
            androidx.room.migration.Migration migration2 = treeMap.get(java.lang.Integer.valueOf(i2));
            if (migration2 != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Overriding migration ");
                sb.append(migration2);
                sb.append(" with ");
                sb.append(migration);
            }
            treeMap.put(java.lang.Integer.valueOf(i2), migration);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private java.util.List<androidx.room.migration.Migration> findUpMigrationPath(java.util.List<androidx.room.migration.Migration> list, boolean z, int i, int i2) {
            java.util.TreeMap<java.lang.Integer, androidx.room.migration.Migration> treeMap;
            boolean z2;
            do {
                if (z) {
                    if (i >= i2) {
                        return list;
                    }
                    treeMap = this.mMigrations.get(java.lang.Integer.valueOf(i));
                    if (treeMap == null) {
                        java.util.Iterator<java.lang.Integer> it = (z ? treeMap.descendingKeySet() : treeMap.keySet()).iterator();
                        while (true) {
                            z2 = false;
                            if (!it.hasNext()) {
                                break;
                            }
                            int intValue = it.next().intValue();
                            if (!z ? !(intValue < i2 || intValue >= i) : !(intValue > i2 || intValue <= i)) {
                                z2 = true;
                            }
                            if (z2) {
                                list.add(treeMap.get(java.lang.Integer.valueOf(intValue)));
                                i = intValue;
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (i <= i2) {
                        return list;
                    }
                    treeMap = this.mMigrations.get(java.lang.Integer.valueOf(i));
                    if (treeMap == null) {
                    }
                }
            } while (z2);
            return null;
        }

        public void addMigrations(@androidx.annotation.NonNull java.util.List<androidx.room.migration.Migration> list) {
            java.util.Iterator<androidx.room.migration.Migration> it = list.iterator();
            while (it.hasNext()) {
                addMigration(it.next());
            }
        }

        public void addMigrations(@androidx.annotation.NonNull androidx.room.migration.Migration... migrationArr) {
            for (androidx.room.migration.Migration migration : migrationArr) {
                addMigration(migration);
            }
        }

        @androidx.annotation.Nullable
        public java.util.List<androidx.room.migration.Migration> findMigrationPath(int i, int i2) {
            if (i == i2) {
                return java.util.Collections.emptyList();
            }
            return findUpMigrationPath(new java.util.ArrayList(), i2 > i, i, i2);
        }

        @androidx.annotation.NonNull
        public java.util.Map<java.lang.Integer, java.util.Map<java.lang.Integer, androidx.room.migration.Migration>> getMigrations() {
            return java.util.Collections.unmodifiableMap(this.mMigrations);
        }
    }

    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    public interface QueryCallback {
        void onQuery(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.util.List<java.lang.Object> list);
    }

    private void internalBeginTransaction() {
        assertNotMainThread();
        androidx.sqlite.db.SupportSQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    private void internalEndTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (inTransaction()) {
            return;
        }
        this.mInvalidationTracker.refreshVersionsAsync();
    }

    private static boolean isMainThread() {
        return android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$beginTransaction$0(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        internalBeginTransaction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.Object lambda$endTransaction$1(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        internalEndTransaction();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.Nullable
    private <T> T unwrapOpenHelper(java.lang.Class<T> cls, androidx.sqlite.db.SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof androidx.room.DelegatingOpenHelper) {
            return (T) unwrapOpenHelper(cls, ((androidx.room.DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate());
        }
        return null;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && isMainThread()) {
            throw new java.lang.IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new java.lang.IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @java.lang.Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        androidx.room.AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            internalBeginTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new defpackage.kc2(this));
        }
    }

    @androidx.annotation.WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            writeLock.lock();
            try {
                this.mInvalidationTracker.stopMultiInstanceInvalidation();
                this.mOpenHelper.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public androidx.sqlite.db.SupportSQLiteStatement compileStatement(@androidx.annotation.NonNull java.lang.String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().compileStatement(str);
    }

    @androidx.annotation.NonNull
    public abstract androidx.room.InvalidationTracker createInvalidationTracker();

    @androidx.annotation.NonNull
    public abstract androidx.sqlite.db.SupportSQLiteOpenHelper createOpenHelper(androidx.room.DatabaseConfiguration databaseConfiguration);

    @java.lang.Deprecated
    public void endTransaction() {
        androidx.room.AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            internalEndTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new defpackage.lc2(this));
        }
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public java.util.List<androidx.room.migration.Migration> getAutoMigrations(@androidx.annotation.NonNull java.util.Map<java.lang.Class<? extends androidx.room.migration.AutoMigrationSpec>, androidx.room.migration.AutoMigrationSpec> map) {
        return java.util.Collections.emptyList();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public java.util.Map<java.lang.String, java.lang.Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    public java.util.concurrent.locks.Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    @androidx.annotation.NonNull
    public androidx.room.InvalidationTracker getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    @androidx.annotation.NonNull
    public androidx.sqlite.db.SupportSQLiteOpenHelper getOpenHelper() {
        return this.mOpenHelper;
    }

    @androidx.annotation.NonNull
    public java.util.concurrent.Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public java.util.Set<java.lang.Class<? extends androidx.room.migration.AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return java.util.Collections.emptySet();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public java.util.Map<java.lang.Class<?>, java.util.List<java.lang.Class<?>>> getRequiredTypeConverters() {
        return java.util.Collections.emptyMap();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public java.lang.ThreadLocal<java.lang.Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    @androidx.annotation.NonNull
    public java.util.concurrent.Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    @androidx.annotation.Nullable
    public <T> T getTypeConverter(@androidx.annotation.NonNull java.lang.Class<T> cls) {
        return (T) this.mTypeConverters.get(cls);
    }

    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().inTransaction();
    }

    @androidx.annotation.CallSuper
    public void init(@androidx.annotation.NonNull androidx.room.DatabaseConfiguration databaseConfiguration) {
        this.mOpenHelper = createOpenHelper(databaseConfiguration);
        java.util.Set<java.lang.Class<? extends androidx.room.migration.AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        java.util.BitSet bitSet = new java.util.BitSet();
        java.util.Iterator<java.lang.Class<? extends androidx.room.migration.AutoMigrationSpec>> it = requiredAutoMigrationSpecs.iterator();
        while (true) {
            int i = -1;
            if (!it.hasNext()) {
                for (int size = databaseConfiguration.autoMigrationSpecs.size() - 1; size >= 0; size--) {
                    if (!bitSet.get(size)) {
                        throw new java.lang.IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                    }
                }
                java.util.Iterator<androidx.room.migration.Migration> it2 = getAutoMigrations(this.mAutoMigrationSpecs).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    androidx.room.migration.Migration next = it2.next();
                    if (!databaseConfiguration.migrationContainer.getMigrations().containsKey(java.lang.Integer.valueOf(next.startVersion))) {
                        databaseConfiguration.migrationContainer.addMigrations(next);
                    }
                }
                androidx.room.SQLiteCopyOpenHelper sQLiteCopyOpenHelper = (androidx.room.SQLiteCopyOpenHelper) unwrapOpenHelper(androidx.room.SQLiteCopyOpenHelper.class, this.mOpenHelper);
                if (sQLiteCopyOpenHelper != null) {
                    sQLiteCopyOpenHelper.setDatabaseConfiguration(databaseConfiguration);
                }
                androidx.room.AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (androidx.room.AutoClosingRoomOpenHelper) unwrapOpenHelper(androidx.room.AutoClosingRoomOpenHelper.class, this.mOpenHelper);
                if (autoClosingRoomOpenHelper != null) {
                    androidx.room.AutoCloser autoCloser = autoClosingRoomOpenHelper.getAutoCloser();
                    this.mAutoCloser = autoCloser;
                    this.mInvalidationTracker.setAutoCloser(autoCloser);
                }
                boolean z = databaseConfiguration.journalMode == androidx.room.RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING;
                this.mOpenHelper.setWriteAheadLoggingEnabled(z);
                this.mCallbacks = databaseConfiguration.callbacks;
                this.mQueryExecutor = databaseConfiguration.queryExecutor;
                this.mTransactionExecutor = new androidx.room.TransactionExecutor(databaseConfiguration.transactionExecutor);
                this.mAllowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
                this.mWriteAheadLoggingEnabled = z;
                if (databaseConfiguration.multiInstanceInvalidation) {
                    this.mInvalidationTracker.startMultiInstanceInvalidation(databaseConfiguration.context, databaseConfiguration.name);
                }
                java.util.Map<java.lang.Class<?>, java.util.List<java.lang.Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
                java.util.BitSet bitSet2 = new java.util.BitSet();
                for (java.util.Map.Entry<java.lang.Class<?>, java.util.List<java.lang.Class<?>>> entry : requiredTypeConverters.entrySet()) {
                    java.lang.Class<?> key = entry.getKey();
                    for (java.lang.Class<?> cls : entry.getValue()) {
                        int size2 = databaseConfiguration.typeConverters.size() - 1;
                        while (true) {
                            if (size2 < 0) {
                                size2 = -1;
                                break;
                            } else {
                                if (cls.isAssignableFrom(databaseConfiguration.typeConverters.get(size2).getClass())) {
                                    bitSet2.set(size2);
                                    break;
                                }
                                size2--;
                            }
                        }
                        if (size2 < 0) {
                            throw new java.lang.IllegalArgumentException("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.");
                        }
                        this.mTypeConverters.put(cls, databaseConfiguration.typeConverters.get(size2));
                    }
                }
                for (int size3 = databaseConfiguration.typeConverters.size() - 1; size3 >= 0; size3--) {
                    if (!bitSet2.get(size3)) {
                        throw new java.lang.IllegalArgumentException("Unexpected type converter " + databaseConfiguration.typeConverters.get(size3) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                    }
                }
                return;
            }
            java.lang.Class<? extends androidx.room.migration.AutoMigrationSpec> next2 = it.next();
            int size4 = databaseConfiguration.autoMigrationSpecs.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (next2.isAssignableFrom(databaseConfiguration.autoMigrationSpecs.get(size4).getClass())) {
                    bitSet.set(size4);
                    i = size4;
                    break;
                }
                size4--;
            }
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("A required auto migration spec (" + next2.getCanonicalName() + ") is missing in the database configuration.");
            }
            this.mAutoMigrationSpecs.put(next2, databaseConfiguration.autoMigrationSpecs.get(i));
        }
    }

    public void internalInitInvalidationTracker(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        this.mInvalidationTracker.internalInit(supportSQLiteDatabase);
    }

    public boolean isOpen() {
        androidx.room.AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser != null) {
            return autoCloser.isActive();
        }
        androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
        return supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen();
    }

    @androidx.annotation.NonNull
    public android.database.Cursor query(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery) {
        return query(supportSQLiteQuery, (android.os.CancellationSignal) null);
    }

    @androidx.annotation.NonNull
    public android.database.Cursor query(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery, @androidx.annotation.Nullable android.os.CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return cancellationSignal != null ? this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery, cancellationSignal) : this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
    }

    @androidx.annotation.NonNull
    public android.database.Cursor query(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object[] objArr) {
        return this.mOpenHelper.getWritableDatabase().query(new androidx.sqlite.db.SimpleSQLiteQuery(str, objArr));
    }

    public <V> V runInTransaction(@androidx.annotation.NonNull java.util.concurrent.Callable<V> callable) {
        beginTransaction();
        try {
            try {
                V call = callable.call();
                setTransactionSuccessful();
                return call;
            } catch (java.lang.RuntimeException e) {
                throw e;
            } catch (java.lang.Exception e2) {
                androidx.room.util.SneakyThrow.reThrow(e2);
                endTransaction();
                return null;
            }
        } finally {
            endTransaction();
        }
    }

    public void runInTransaction(@androidx.annotation.NonNull java.lang.Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @java.lang.Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }
}
