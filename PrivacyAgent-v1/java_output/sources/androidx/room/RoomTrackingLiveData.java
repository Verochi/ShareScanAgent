package androidx.room;

/* loaded from: classes.dex */
class RoomTrackingLiveData<T> extends androidx.lifecycle.LiveData<T> {
    final java.util.concurrent.Callable<T> mComputeFunction;
    private final androidx.room.InvalidationLiveDataContainer mContainer;
    final androidx.room.RoomDatabase mDatabase;
    final boolean mInTransaction;
    final androidx.room.InvalidationTracker.Observer mObserver;
    final java.util.concurrent.atomic.AtomicBoolean mInvalid = new java.util.concurrent.atomic.AtomicBoolean(true);
    final java.util.concurrent.atomic.AtomicBoolean mComputing = new java.util.concurrent.atomic.AtomicBoolean(false);
    final java.util.concurrent.atomic.AtomicBoolean mRegisteredObserver = new java.util.concurrent.atomic.AtomicBoolean(false);
    final java.lang.Runnable mRefreshRunnable = new androidx.room.RoomTrackingLiveData.AnonymousClass1();
    final java.lang.Runnable mInvalidationRunnable = new androidx.room.RoomTrackingLiveData.AnonymousClass2();

    /* renamed from: androidx.room.RoomTrackingLiveData$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        @androidx.annotation.WorkerThread
        public void run() {
            boolean z;
            if (androidx.room.RoomTrackingLiveData.this.mRegisteredObserver.compareAndSet(false, true)) {
                androidx.room.RoomTrackingLiveData.this.mDatabase.getInvalidationTracker().addWeakObserver(androidx.room.RoomTrackingLiveData.this.mObserver);
            }
            do {
                if (androidx.room.RoomTrackingLiveData.this.mComputing.compareAndSet(false, true)) {
                    T t = null;
                    z = false;
                    while (androidx.room.RoomTrackingLiveData.this.mInvalid.compareAndSet(true, false)) {
                        try {
                            try {
                                t = androidx.room.RoomTrackingLiveData.this.mComputeFunction.call();
                                z = true;
                            } catch (java.lang.Exception e) {
                                throw new java.lang.RuntimeException("Exception while computing database live data.", e);
                            }
                        } finally {
                            androidx.room.RoomTrackingLiveData.this.mComputing.set(false);
                        }
                    }
                    if (z) {
                        androidx.room.RoomTrackingLiveData.this.postValue(t);
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    return;
                }
            } while (androidx.room.RoomTrackingLiveData.this.mInvalid.get());
        }
    }

    /* renamed from: androidx.room.RoomTrackingLiveData$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        @androidx.annotation.MainThread
        public void run() {
            boolean hasActiveObservers = androidx.room.RoomTrackingLiveData.this.hasActiveObservers();
            if (androidx.room.RoomTrackingLiveData.this.mInvalid.compareAndSet(false, true) && hasActiveObservers) {
                androidx.room.RoomTrackingLiveData.this.getQueryExecutor().execute(androidx.room.RoomTrackingLiveData.this.mRefreshRunnable);
            }
        }
    }

    /* renamed from: androidx.room.RoomTrackingLiveData$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.room.InvalidationTracker.Observer {
        public AnonymousClass3(java.lang.String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@androidx.annotation.NonNull java.util.Set<java.lang.String> set) {
            androidx.arch.core.executor.ArchTaskExecutor.getInstance().executeOnMainThread(androidx.room.RoomTrackingLiveData.this.mInvalidationRunnable);
        }
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public RoomTrackingLiveData(androidx.room.RoomDatabase roomDatabase, androidx.room.InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z, java.util.concurrent.Callable<T> callable, java.lang.String[] strArr) {
        this.mDatabase = roomDatabase;
        this.mInTransaction = z;
        this.mComputeFunction = callable;
        this.mContainer = invalidationLiveDataContainer;
        this.mObserver = new androidx.room.RoomTrackingLiveData.AnonymousClass3(strArr);
    }

    public java.util.concurrent.Executor getQueryExecutor() {
        return this.mInTransaction ? this.mDatabase.getTransactionExecutor() : this.mDatabase.getQueryExecutor();
    }

    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        getQueryExecutor().execute(this.mRefreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }
}
