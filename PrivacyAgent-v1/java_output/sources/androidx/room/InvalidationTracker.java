package androidx.room;

/* loaded from: classes.dex */
public class InvalidationTracker {
    private static final java.lang.String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final java.lang.String INVALIDATED_COLUMN_NAME = "invalidated";

    @androidx.annotation.VisibleForTesting
    static final java.lang.String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";

    @androidx.annotation.VisibleForTesting
    static final java.lang.String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final java.lang.String TABLE_ID_COLUMN_NAME = "table_id";
    private static final java.lang.String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    private static final java.lang.String UPDATE_TABLE_NAME = "room_table_modification_log";

    @androidx.annotation.Nullable
    androidx.room.AutoCloser mAutoCloser;
    volatile androidx.sqlite.db.SupportSQLiteStatement mCleanupStatement;
    final androidx.room.RoomDatabase mDatabase;
    private volatile boolean mInitialized;
    private final androidx.room.InvalidationLiveDataContainer mInvalidationLiveDataContainer;
    private androidx.room.MultiInstanceInvalidationClient mMultiInstanceInvalidationClient;
    private androidx.room.InvalidationTracker.ObservedTableTracker mObservedTableTracker;

    @android.annotation.SuppressLint({"RestrictedApi"})
    @androidx.annotation.VisibleForTesting
    final androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker.Observer, androidx.room.InvalidationTracker.ObserverWrapper> mObserverMap;
    java.util.concurrent.atomic.AtomicBoolean mPendingRefresh;

    @androidx.annotation.VisibleForTesting
    java.lang.Runnable mRefreshRunnable;

    @androidx.annotation.NonNull
    final java.util.HashMap<java.lang.String, java.lang.Integer> mTableIdLookup;
    final java.lang.String[] mTableNames;

    @androidx.annotation.NonNull
    private java.util.Map<java.lang.String, java.util.Set<java.lang.String>> mViewTables;

    /* renamed from: androidx.room.InvalidationTracker$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        private java.util.Set<java.lang.Integer> checkUpdatedTable() {
            java.util.HashSet hashSet = new java.util.HashSet();
            android.database.Cursor query = androidx.room.InvalidationTracker.this.mDatabase.query(new androidx.sqlite.db.SimpleSQLiteQuery(androidx.room.InvalidationTracker.SELECT_UPDATED_TABLES_SQL));
            while (query.moveToNext()) {
                try {
                    hashSet.add(java.lang.Integer.valueOf(query.getInt(0)));
                } catch (java.lang.Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
            if (!hashSet.isEmpty()) {
                androidx.room.InvalidationTracker.this.mCleanupStatement.executeUpdateDelete();
            }
            return hashSet;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
        
            if (r0 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
        
            r0.decrementCountAndScheduleClose();
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0094, code lost:
        
            if (r1 == null) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x009a, code lost:
        
            if (r1.isEmpty() != false) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x009c, code lost:
        
            r0 = r5.this$0.mObserverMap;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00a0, code lost:
        
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
        
            r2 = r5.this$0.mObserverMap.iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00ad, code lost:
        
            if (r2.hasNext() == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00af, code lost:
        
            r2.next().getValue().notifyByTableInvalidStatus(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00bf, code lost:
        
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00c4, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
        
            if (r0 == null) goto L38;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            androidx.room.AutoCloser autoCloser;
            androidx.room.AutoCloser autoCloser2;
            java.util.concurrent.locks.Lock closeLock = androidx.room.InvalidationTracker.this.mDatabase.getCloseLock();
            closeLock.lock();
            java.util.Set<java.lang.Integer> set = null;
            try {
                try {
                    if (!androidx.room.InvalidationTracker.this.ensureInitialization()) {
                        if (autoCloser != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (!androidx.room.InvalidationTracker.this.mPendingRefresh.compareAndSet(true, false)) {
                        closeLock.unlock();
                        androidx.room.AutoCloser autoCloser3 = androidx.room.InvalidationTracker.this.mAutoCloser;
                        if (autoCloser3 != null) {
                            autoCloser3.decrementCountAndScheduleClose();
                            return;
                        }
                        return;
                    }
                    if (androidx.room.InvalidationTracker.this.mDatabase.inTransaction()) {
                        closeLock.unlock();
                        androidx.room.AutoCloser autoCloser4 = androidx.room.InvalidationTracker.this.mAutoCloser;
                        if (autoCloser4 != null) {
                            autoCloser4.decrementCountAndScheduleClose();
                            return;
                        }
                        return;
                    }
                    androidx.sqlite.db.SupportSQLiteDatabase writableDatabase = androidx.room.InvalidationTracker.this.mDatabase.getOpenHelper().getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        set = checkUpdatedTable();
                        writableDatabase.setTransactionSuccessful();
                        closeLock.unlock();
                        autoCloser2 = androidx.room.InvalidationTracker.this.mAutoCloser;
                    } finally {
                        writableDatabase.endTransaction();
                    }
                } catch (android.database.sqlite.SQLiteException | java.lang.IllegalStateException unused) {
                    closeLock.unlock();
                    autoCloser2 = androidx.room.InvalidationTracker.this.mAutoCloser;
                }
            } finally {
                closeLock.unlock();
                autoCloser = androidx.room.InvalidationTracker.this.mAutoCloser;
                if (autoCloser != null) {
                    autoCloser.decrementCountAndScheduleClose();
                }
            }
        }
    }

    public static class ObservedTableTracker {
        static final int ADD = 1;
        static final int NO_OP = 0;
        static final int REMOVE = 2;
        boolean mNeedsSync;
        boolean mPendingSync;
        final long[] mTableObservers;
        final int[] mTriggerStateChanges;
        final boolean[] mTriggerStates;

        public ObservedTableTracker(int i) {
            long[] jArr = new long[i];
            this.mTableObservers = jArr;
            boolean[] zArr = new boolean[i];
            this.mTriggerStates = zArr;
            this.mTriggerStateChanges = new int[i];
            java.util.Arrays.fill(jArr, 0L);
            java.util.Arrays.fill(zArr, false);
        }

        @androidx.annotation.Nullable
        public int[] getTablesToSync() {
            synchronized (this) {
                if (this.mNeedsSync && !this.mPendingSync) {
                    int length = this.mTableObservers.length;
                    int i = 0;
                    while (true) {
                        int i2 = 1;
                        if (i >= length) {
                            this.mPendingSync = true;
                            this.mNeedsSync = false;
                            return this.mTriggerStateChanges;
                        }
                        boolean z = this.mTableObservers[i] > 0;
                        boolean[] zArr = this.mTriggerStates;
                        if (z != zArr[i]) {
                            int[] iArr = this.mTriggerStateChanges;
                            if (!z) {
                                i2 = 2;
                            }
                            iArr[i] = i2;
                        } else {
                            this.mTriggerStateChanges[i] = 0;
                        }
                        zArr[i] = z;
                        i++;
                    }
                }
                return null;
            }
        }

        public boolean onAdded(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long[] jArr = this.mTableObservers;
                    long j = jArr[i];
                    jArr[i] = 1 + j;
                    if (j == 0) {
                        z = true;
                        this.mNeedsSync = true;
                    }
                }
            }
            return z;
        }

        public boolean onRemoved(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int i : iArr) {
                    long[] jArr = this.mTableObservers;
                    long j = jArr[i];
                    jArr[i] = j - 1;
                    if (j == 1) {
                        z = true;
                        this.mNeedsSync = true;
                    }
                }
            }
            return z;
        }

        public void onSyncCompleted() {
            synchronized (this) {
                this.mPendingSync = false;
            }
        }

        public void resetTriggerState() {
            synchronized (this) {
                java.util.Arrays.fill(this.mTriggerStates, false);
                this.mNeedsSync = true;
            }
        }
    }

    public static abstract class Observer {
        final java.lang.String[] mTables;

        public Observer(@androidx.annotation.NonNull java.lang.String str, java.lang.String... strArr) {
            java.lang.String[] strArr2 = (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length + 1);
            this.mTables = strArr2;
            strArr2[strArr.length] = str;
        }

        public Observer(@androidx.annotation.NonNull java.lang.String[] strArr) {
            this.mTables = (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
        }

        public boolean isRemote() {
            return false;
        }

        public abstract void onInvalidated(@androidx.annotation.NonNull java.util.Set<java.lang.String> set);
    }

    public static class ObserverWrapper {
        final androidx.room.InvalidationTracker.Observer mObserver;
        private final java.util.Set<java.lang.String> mSingleTableSet;
        final int[] mTableIds;
        private final java.lang.String[] mTableNames;

        public ObserverWrapper(androidx.room.InvalidationTracker.Observer observer, int[] iArr, java.lang.String[] strArr) {
            this.mObserver = observer;
            this.mTableIds = iArr;
            this.mTableNames = strArr;
            if (iArr.length != 1) {
                this.mSingleTableSet = null;
                return;
            }
            java.util.HashSet hashSet = new java.util.HashSet();
            hashSet.add(strArr[0]);
            this.mSingleTableSet = java.util.Collections.unmodifiableSet(hashSet);
        }

        public void notifyByTableInvalidStatus(java.util.Set<java.lang.Integer> set) {
            int length = this.mTableIds.length;
            java.util.Set<java.lang.String> set2 = null;
            for (int i = 0; i < length; i++) {
                if (set.contains(java.lang.Integer.valueOf(this.mTableIds[i]))) {
                    if (length == 1) {
                        set2 = this.mSingleTableSet;
                    } else {
                        if (set2 == null) {
                            set2 = new java.util.HashSet<>(length);
                        }
                        set2.add(this.mTableNames[i]);
                    }
                }
            }
            if (set2 != null) {
                this.mObserver.onInvalidated(set2);
            }
        }

        public void notifyByTableNames(java.lang.String[] strArr) {
            java.util.Set<java.lang.String> set = null;
            if (this.mTableNames.length == 1) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (strArr[i].equalsIgnoreCase(this.mTableNames[0])) {
                        set = this.mSingleTableSet;
                        break;
                    }
                    i++;
                }
            } else {
                java.util.HashSet hashSet = new java.util.HashSet();
                for (java.lang.String str : strArr) {
                    java.lang.String[] strArr2 = this.mTableNames;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length2) {
                            java.lang.String str2 = strArr2[i2];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i2++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.mObserver.onInvalidated(set);
            }
        }
    }

    public static class WeakObserver extends androidx.room.InvalidationTracker.Observer {
        final java.lang.ref.WeakReference<androidx.room.InvalidationTracker.Observer> mDelegateRef;
        final androidx.room.InvalidationTracker mTracker;

        public WeakObserver(androidx.room.InvalidationTracker invalidationTracker, androidx.room.InvalidationTracker.Observer observer) {
            super(observer.mTables);
            this.mTracker = invalidationTracker;
            this.mDelegateRef = new java.lang.ref.WeakReference<>(observer);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@androidx.annotation.NonNull java.util.Set<java.lang.String> set) {
            androidx.room.InvalidationTracker.Observer observer = this.mDelegateRef.get();
            if (observer == null) {
                this.mTracker.removeObserver(this);
            } else {
                observer.onInvalidated(set);
            }
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(androidx.room.RoomDatabase roomDatabase, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.util.Set<java.lang.String>> map2, java.lang.String... strArr) {
        this.mAutoCloser = null;
        this.mPendingRefresh = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.mInitialized = false;
        this.mObserverMap = new androidx.arch.core.internal.SafeIterableMap<>();
        this.mRefreshRunnable = new androidx.room.InvalidationTracker.AnonymousClass1();
        this.mDatabase = roomDatabase;
        this.mObservedTableTracker = new androidx.room.InvalidationTracker.ObservedTableTracker(strArr.length);
        this.mTableIdLookup = new java.util.HashMap<>();
        this.mViewTables = map2;
        this.mInvalidationLiveDataContainer = new androidx.room.InvalidationLiveDataContainer(roomDatabase);
        int length = strArr.length;
        this.mTableNames = new java.lang.String[length];
        for (int i = 0; i < length; i++) {
            java.lang.String str = strArr[i];
            java.util.Locale locale = java.util.Locale.US;
            java.lang.String lowerCase = str.toLowerCase(locale);
            this.mTableIdLookup.put(lowerCase, java.lang.Integer.valueOf(i));
            java.lang.String str2 = map.get(strArr[i]);
            if (str2 != null) {
                this.mTableNames[i] = str2.toLowerCase(locale);
            } else {
                this.mTableNames[i] = lowerCase;
            }
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String value = entry.getValue();
            java.util.Locale locale2 = java.util.Locale.US;
            java.lang.String lowerCase2 = value.toLowerCase(locale2);
            if (this.mTableIdLookup.containsKey(lowerCase2)) {
                java.lang.String lowerCase3 = entry.getKey().toLowerCase(locale2);
                java.util.HashMap<java.lang.String, java.lang.Integer> hashMap = this.mTableIdLookup;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(androidx.room.RoomDatabase roomDatabase, java.lang.String... strArr) {
        this(roomDatabase, new java.util.HashMap(), java.util.Collections.emptyMap(), strArr);
    }

    private static void appendTriggerName(java.lang.StringBuilder sb, java.lang.String str, java.lang.String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private static void beginTransactionInternal(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.isWriteAheadLoggingEnabled()) {
            supportSQLiteDatabase.beginTransactionNonExclusive();
        } else {
            supportSQLiteDatabase.beginTransaction();
        }
    }

    private java.lang.String[] resolveViews(java.lang.String[] strArr) {
        java.util.HashSet hashSet = new java.util.HashSet();
        for (java.lang.String str : strArr) {
            java.lang.String lowerCase = str.toLowerCase(java.util.Locale.US);
            if (this.mViewTables.containsKey(lowerCase)) {
                hashSet.addAll(this.mViewTables.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (java.lang.String[]) hashSet.toArray(new java.lang.String[hashSet.size()]);
    }

    private void startTrackingTable(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i + ", 0)");
        java.lang.String str = this.mTableNames[i];
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : TRIGGERS) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            appendTriggerName(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append(UPDATE_TABLE_NAME);
            sb.append(" SET ");
            sb.append(INVALIDATED_COLUMN_NAME);
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append(TABLE_ID_COLUMN_NAME);
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append(INVALIDATED_COLUMN_NAME);
            sb.append(" = 0");
            sb.append("; END");
            supportSQLiteDatabase.execSQL(sb.toString());
        }
    }

    private void stopTrackingTable(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        java.lang.String str = this.mTableNames[i];
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : TRIGGERS) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            appendTriggerName(sb, str, str2);
            supportSQLiteDatabase.execSQL(sb.toString());
        }
    }

    private java.lang.String[] validateAndResolveTableNames(java.lang.String[] strArr) {
        java.lang.String[] resolveViews = resolveViews(strArr);
        for (java.lang.String str : resolveViews) {
            if (!this.mTableIdLookup.containsKey(str.toLowerCase(java.util.Locale.US))) {
                throw new java.lang.IllegalArgumentException("There is no table with name " + str);
            }
        }
        return resolveViews;
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    @androidx.annotation.WorkerThread
    public void addObserver(@androidx.annotation.NonNull androidx.room.InvalidationTracker.Observer observer) {
        androidx.room.InvalidationTracker.ObserverWrapper putIfAbsent;
        java.lang.String[] resolveViews = resolveViews(observer.mTables);
        int[] iArr = new int[resolveViews.length];
        int length = resolveViews.length;
        for (int i = 0; i < length; i++) {
            java.lang.Integer num = this.mTableIdLookup.get(resolveViews[i].toLowerCase(java.util.Locale.US));
            if (num == null) {
                throw new java.lang.IllegalArgumentException("There is no table with name " + resolveViews[i]);
            }
            iArr[i] = num.intValue();
        }
        androidx.room.InvalidationTracker.ObserverWrapper observerWrapper = new androidx.room.InvalidationTracker.ObserverWrapper(observer, iArr, resolveViews);
        synchronized (this.mObserverMap) {
            putIfAbsent = this.mObserverMap.putIfAbsent(observer, observerWrapper);
        }
        if (putIfAbsent == null && this.mObservedTableTracker.onAdded(iArr)) {
            syncTriggers();
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(androidx.room.InvalidationTracker.Observer observer) {
        addObserver(new androidx.room.InvalidationTracker.WeakObserver(this, observer));
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @java.lang.Deprecated
    public <T> androidx.lifecycle.LiveData<T> createLiveData(java.lang.String[] strArr, java.util.concurrent.Callable<T> callable) {
        return createLiveData(strArr, false, callable);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> androidx.lifecycle.LiveData<T> createLiveData(java.lang.String[] strArr, boolean z, java.util.concurrent.Callable<T> callable) {
        return this.mInvalidationLiveDataContainer.create(validateAndResolveTableNames(strArr), z, callable);
    }

    public boolean ensureInitialization() {
        if (!this.mDatabase.isOpen()) {
            return false;
        }
        if (!this.mInitialized) {
            this.mDatabase.getOpenHelper().getWritableDatabase();
        }
        return this.mInitialized;
    }

    public void internalInit(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        synchronized (this) {
            if (this.mInitialized) {
                return;
            }
            supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers(supportSQLiteDatabase);
            this.mCleanupStatement = supportSQLiteDatabase.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.mInitialized = true;
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    @androidx.annotation.VisibleForTesting(otherwise = 3)
    public void notifyObserversByTableNames(java.lang.String... strArr) {
        synchronized (this.mObserverMap) {
            java.util.Iterator<java.util.Map.Entry<androidx.room.InvalidationTracker.Observer, androidx.room.InvalidationTracker.ObserverWrapper>> it = this.mObserverMap.iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<androidx.room.InvalidationTracker.Observer, androidx.room.InvalidationTracker.ObserverWrapper> next = it.next();
                if (!next.getKey().isRemote()) {
                    next.getValue().notifyByTableNames(strArr);
                }
            }
        }
    }

    public void onAutoCloseCallback() {
        synchronized (this) {
            this.mInitialized = false;
            this.mObservedTableTracker.resetTriggerState();
        }
    }

    public void refreshVersionsAsync() {
        if (this.mPendingRefresh.compareAndSet(false, true)) {
            androidx.room.AutoCloser autoCloser = this.mAutoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @androidx.annotation.WorkerThread
    public void refreshVersionsSync() {
        androidx.room.AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers();
        this.mRefreshRunnable.run();
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    @androidx.annotation.WorkerThread
    public void removeObserver(@androidx.annotation.NonNull androidx.room.InvalidationTracker.Observer observer) {
        androidx.room.InvalidationTracker.ObserverWrapper remove;
        synchronized (this.mObserverMap) {
            remove = this.mObserverMap.remove(observer);
        }
        if (remove == null || !this.mObservedTableTracker.onRemoved(remove.mTableIds)) {
            return;
        }
        syncTriggers();
    }

    public void setAutoCloser(androidx.room.AutoCloser autoCloser) {
        this.mAutoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new defpackage.rs0(this));
    }

    public void startMultiInstanceInvalidation(android.content.Context context, java.lang.String str) {
        this.mMultiInstanceInvalidationClient = new androidx.room.MultiInstanceInvalidationClient(context, str, this, this.mDatabase.getQueryExecutor());
    }

    public void stopMultiInstanceInvalidation() {
        androidx.room.MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.mMultiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
            this.mMultiInstanceInvalidationClient = null;
        }
    }

    public void syncTriggers() {
        if (this.mDatabase.isOpen()) {
            syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
        }
    }

    public void syncTriggers(androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.inTransaction()) {
            return;
        }
        while (true) {
            try {
                java.util.concurrent.locks.Lock closeLock = this.mDatabase.getCloseLock();
                closeLock.lock();
                try {
                    int[] tablesToSync = this.mObservedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    int length = tablesToSync.length;
                    beginTransactionInternal(supportSQLiteDatabase);
                    for (int i = 0; i < length; i++) {
                        try {
                            int i2 = tablesToSync[i];
                            if (i2 == 1) {
                                startTrackingTable(supportSQLiteDatabase, i);
                            } else if (i2 == 2) {
                                stopTrackingTable(supportSQLiteDatabase, i);
                            }
                        } finally {
                        }
                    }
                    supportSQLiteDatabase.setTransactionSuccessful();
                    supportSQLiteDatabase.endTransaction();
                    this.mObservedTableTracker.onSyncCompleted();
                } finally {
                    closeLock.unlock();
                }
            } catch (android.database.sqlite.SQLiteException | java.lang.IllegalStateException unused) {
                return;
            }
        }
    }
}
