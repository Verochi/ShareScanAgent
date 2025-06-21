package androidx.room;

/* loaded from: classes.dex */
final class AutoCloser {
    final long mAutoCloseTimeoutInMs;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("mLock")
    androidx.sqlite.db.SupportSQLiteDatabase mDelegateDatabase;

    @androidx.annotation.NonNull
    final java.util.concurrent.Executor mExecutor;

    @androidx.annotation.Nullable
    private androidx.sqlite.db.SupportSQLiteOpenHelper mDelegateOpenHelper = null;

    @androidx.annotation.NonNull
    private final android.os.Handler mHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    @androidx.annotation.Nullable
    java.lang.Runnable mOnAutoCloseCallback = null;

    @androidx.annotation.NonNull
    final java.lang.Object mLock = new java.lang.Object();

    @androidx.annotation.GuardedBy("mLock")
    int mRefCount = 0;

    @androidx.annotation.GuardedBy("mLock")
    long mLastDecrementRefCountTimeStamp = android.os.SystemClock.uptimeMillis();
    private boolean mManuallyClosed = false;
    private final java.lang.Runnable mExecuteAutoCloser = new androidx.room.AutoCloser.AnonymousClass1();

    @androidx.annotation.NonNull
    final java.lang.Runnable mAutoCloser = new androidx.room.AutoCloser.AnonymousClass2();

    /* renamed from: androidx.room.AutoCloser$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.room.AutoCloser autoCloser = androidx.room.AutoCloser.this;
            autoCloser.mExecutor.execute(autoCloser.mAutoCloser);
        }
    }

    /* renamed from: androidx.room.AutoCloser$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (androidx.room.AutoCloser.this.mLock) {
                long uptimeMillis = android.os.SystemClock.uptimeMillis();
                androidx.room.AutoCloser autoCloser = androidx.room.AutoCloser.this;
                if (uptimeMillis - autoCloser.mLastDecrementRefCountTimeStamp < autoCloser.mAutoCloseTimeoutInMs) {
                    return;
                }
                if (autoCloser.mRefCount != 0) {
                    return;
                }
                java.lang.Runnable runnable = autoCloser.mOnAutoCloseCallback;
                if (runnable == null) {
                    throw new java.lang.IllegalStateException("mOnAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
                }
                runnable.run();
                androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase = androidx.room.AutoCloser.this.mDelegateDatabase;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    try {
                        androidx.room.AutoCloser.this.mDelegateDatabase.close();
                    } catch (java.io.IOException e) {
                        androidx.room.util.SneakyThrow.reThrow(e);
                    }
                    androidx.room.AutoCloser.this.mDelegateDatabase = null;
                }
            }
        }
    }

    public AutoCloser(long j, @androidx.annotation.NonNull java.util.concurrent.TimeUnit timeUnit, @androidx.annotation.NonNull java.util.concurrent.Executor executor) {
        this.mAutoCloseTimeoutInMs = timeUnit.toMillis(j);
        this.mExecutor = executor;
    }

    public void closeDatabaseIfOpen() throws java.io.IOException {
        synchronized (this.mLock) {
            this.mManuallyClosed = true;
            androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegateDatabase;
            if (supportSQLiteDatabase != null) {
                supportSQLiteDatabase.close();
            }
            this.mDelegateDatabase = null;
        }
    }

    public void decrementCountAndScheduleClose() {
        synchronized (this.mLock) {
            int i = this.mRefCount;
            if (i <= 0) {
                throw new java.lang.IllegalStateException("ref count is 0 or lower but we're supposed to decrement");
            }
            int i2 = i - 1;
            this.mRefCount = i2;
            if (i2 == 0) {
                if (this.mDelegateDatabase == null) {
                } else {
                    this.mHandler.postDelayed(this.mExecuteAutoCloser, this.mAutoCloseTimeoutInMs);
                }
            }
        }
    }

    @androidx.annotation.Nullable
    public <V> V executeRefCountingFunction(@androidx.annotation.NonNull androidx.arch.core.util.Function<androidx.sqlite.db.SupportSQLiteDatabase, V> function) {
        try {
            return function.apply(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    @androidx.annotation.Nullable
    public androidx.sqlite.db.SupportSQLiteDatabase getDelegateDatabase() {
        androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase;
        synchronized (this.mLock) {
            supportSQLiteDatabase = this.mDelegateDatabase;
        }
        return supportSQLiteDatabase;
    }

    @androidx.annotation.VisibleForTesting
    public int getRefCountForTest() {
        int i;
        synchronized (this.mLock) {
            i = this.mRefCount;
        }
        return i;
    }

    @androidx.annotation.NonNull
    public androidx.sqlite.db.SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        synchronized (this.mLock) {
            this.mHandler.removeCallbacks(this.mExecuteAutoCloser);
            this.mRefCount++;
            if (this.mManuallyClosed) {
                throw new java.lang.IllegalStateException("Attempting to open already closed database.");
            }
            androidx.sqlite.db.SupportSQLiteDatabase supportSQLiteDatabase = this.mDelegateDatabase;
            if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                return this.mDelegateDatabase;
            }
            androidx.sqlite.db.SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.mDelegateOpenHelper;
            if (supportSQLiteOpenHelper == null) {
                throw new java.lang.IllegalStateException("AutoCloser has not been initialized. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568");
            }
            androidx.sqlite.db.SupportSQLiteDatabase writableDatabase = supportSQLiteOpenHelper.getWritableDatabase();
            this.mDelegateDatabase = writableDatabase;
            return writableDatabase;
        }
    }

    public void init(@androidx.annotation.NonNull androidx.sqlite.db.SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (this.mDelegateOpenHelper != null) {
            return;
        }
        this.mDelegateOpenHelper = supportSQLiteOpenHelper;
    }

    public boolean isActive() {
        return !this.mManuallyClosed;
    }

    public void setAutoCloseCallback(java.lang.Runnable runnable) {
        this.mOnAutoCloseCallback = runnable;
    }
}
