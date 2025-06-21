package androidx.room.paging;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class LimitOffsetDataSource<T> extends androidx.paging.PositionalDataSource<T> {
    private final java.lang.String mCountQuery;
    private final androidx.room.RoomDatabase mDb;
    private final boolean mInTransaction;
    private final java.lang.String mLimitOffsetQuery;
    private final androidx.room.InvalidationTracker.Observer mObserver;
    private final java.util.concurrent.atomic.AtomicBoolean mRegisteredObserver;
    private final androidx.room.RoomSQLiteQuery mSourceQuery;

    /* renamed from: androidx.room.paging.LimitOffsetDataSource$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.room.InvalidationTracker.Observer {
        public AnonymousClass1(java.lang.String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@androidx.annotation.NonNull java.util.Set<java.lang.String> set) {
            androidx.room.paging.LimitOffsetDataSource.this.invalidate();
        }
    }

    public LimitOffsetDataSource(@androidx.annotation.NonNull androidx.room.RoomDatabase roomDatabase, @androidx.annotation.NonNull androidx.room.RoomSQLiteQuery roomSQLiteQuery, boolean z, boolean z2, @androidx.annotation.NonNull java.lang.String... strArr) {
        this.mRegisteredObserver = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.mDb = roomDatabase;
        this.mSourceQuery = roomSQLiteQuery;
        this.mInTransaction = z;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + roomSQLiteQuery.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + roomSQLiteQuery.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new androidx.room.paging.LimitOffsetDataSource.AnonymousClass1(strArr);
        if (z2) {
            registerObserverIfNecessary();
        }
    }

    public LimitOffsetDataSource(@androidx.annotation.NonNull androidx.room.RoomDatabase roomDatabase, @androidx.annotation.NonNull androidx.room.RoomSQLiteQuery roomSQLiteQuery, boolean z, @androidx.annotation.NonNull java.lang.String... strArr) {
        this(roomDatabase, roomSQLiteQuery, z, true, strArr);
    }

    public LimitOffsetDataSource(@androidx.annotation.NonNull androidx.room.RoomDatabase roomDatabase, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery, boolean z, boolean z2, @androidx.annotation.NonNull java.lang.String... strArr) {
        this(roomDatabase, androidx.room.RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z, z2, strArr);
    }

    public LimitOffsetDataSource(@androidx.annotation.NonNull androidx.room.RoomDatabase roomDatabase, @androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteQuery supportSQLiteQuery, boolean z, @androidx.annotation.NonNull java.lang.String... strArr) {
        this(roomDatabase, androidx.room.RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z, strArr);
    }

    private androidx.room.RoomSQLiteQuery getSQLiteQuery(int i, int i2) {
        androidx.room.RoomSQLiteQuery acquire = androidx.room.RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        acquire.copyArgumentsFrom(this.mSourceQuery);
        acquire.bindLong(acquire.getArgCount() - 1, i2);
        acquire.bindLong(acquire.getArgCount(), i);
        return acquire;
    }

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true)) {
            this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        }
    }

    @androidx.annotation.NonNull
    public abstract java.util.List<T> convertRows(@androidx.annotation.NonNull android.database.Cursor cursor);

    public int countItems() {
        registerObserverIfNecessary();
        androidx.room.RoomSQLiteQuery acquire = androidx.room.RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        acquire.copyArgumentsFrom(this.mSourceQuery);
        android.database.Cursor query = this.mDb.query(acquire);
        try {
            if (query.moveToFirst()) {
                return query.getInt(0);
            }
            return 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(@androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialParams loadInitialParams, @androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialCallback<T> loadInitialCallback) {
        androidx.room.RoomSQLiteQuery roomSQLiteQuery;
        int i;
        androidx.room.RoomSQLiteQuery roomSQLiteQuery2;
        registerObserverIfNecessary();
        java.util.List<T> emptyList = java.util.Collections.emptyList();
        this.mDb.beginTransaction();
        android.database.Cursor cursor = null;
        try {
            int countItems = countItems();
            if (countItems != 0) {
                int computeInitialLoadPosition = computeInitialLoadPosition(loadInitialParams, countItems);
                roomSQLiteQuery = getSQLiteQuery(computeInitialLoadPosition, computeInitialLoadSize(loadInitialParams, computeInitialLoadPosition, countItems));
                try {
                    cursor = this.mDb.query(roomSQLiteQuery);
                    java.util.List<T> convertRows = convertRows(cursor);
                    this.mDb.setTransactionSuccessful();
                    roomSQLiteQuery2 = roomSQLiteQuery;
                    i = computeInitialLoadPosition;
                    emptyList = convertRows;
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    this.mDb.endTransaction();
                    if (roomSQLiteQuery != null) {
                        roomSQLiteQuery.release();
                    }
                    throw th;
                }
            } else {
                i = 0;
                roomSQLiteQuery2 = null;
            }
            if (cursor != null) {
                cursor.close();
            }
            this.mDb.endTransaction();
            if (roomSQLiteQuery2 != null) {
                roomSQLiteQuery2.release();
            }
            loadInitialCallback.onResult(emptyList, i, countItems);
        } catch (java.lang.Throwable th2) {
            th = th2;
            roomSQLiteQuery = null;
        }
    }

    @androidx.annotation.NonNull
    public java.util.List<T> loadRange(int i, int i2) {
        androidx.room.RoomSQLiteQuery sQLiteQuery = getSQLiteQuery(i, i2);
        if (!this.mInTransaction) {
            android.database.Cursor query = this.mDb.query(sQLiteQuery);
            try {
                return convertRows(query);
            } finally {
                query.close();
                sQLiteQuery.release();
            }
        }
        this.mDb.beginTransaction();
        android.database.Cursor cursor = null;
        try {
            cursor = this.mDb.query(sQLiteQuery);
            java.util.List<T> convertRows = convertRows(cursor);
            this.mDb.setTransactionSuccessful();
            return convertRows;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            this.mDb.endTransaction();
            sQLiteQuery.release();
        }
    }

    public void loadRange(@androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadRangeParams loadRangeParams, @androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }
}
