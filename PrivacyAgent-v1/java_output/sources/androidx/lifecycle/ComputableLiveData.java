package androidx.lifecycle;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class ComputableLiveData<T> {
    final java.util.concurrent.atomic.AtomicBoolean mComputing;
    final java.util.concurrent.Executor mExecutor;
    final java.util.concurrent.atomic.AtomicBoolean mInvalid;

    @androidx.annotation.VisibleForTesting
    final java.lang.Runnable mInvalidationRunnable;
    final androidx.lifecycle.LiveData<T> mLiveData;

    @androidx.annotation.VisibleForTesting
    final java.lang.Runnable mRefreshRunnable;

    /* renamed from: androidx.lifecycle.ComputableLiveData$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.lifecycle.LiveData<T> {
        public AnonymousClass1() {
        }

        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            androidx.lifecycle.ComputableLiveData computableLiveData = androidx.lifecycle.ComputableLiveData.this;
            computableLiveData.mExecutor.execute(computableLiveData.mRefreshRunnable);
        }
    }

    /* renamed from: androidx.lifecycle.ComputableLiveData$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        @androidx.annotation.WorkerThread
        public void run() {
            do {
                boolean z = false;
                if (androidx.lifecycle.ComputableLiveData.this.mComputing.compareAndSet(false, true)) {
                    java.lang.Object obj = null;
                    boolean z2 = false;
                    while (androidx.lifecycle.ComputableLiveData.this.mInvalid.compareAndSet(true, false)) {
                        try {
                            obj = androidx.lifecycle.ComputableLiveData.this.compute();
                            z2 = true;
                        } catch (java.lang.Throwable th) {
                            androidx.lifecycle.ComputableLiveData.this.mComputing.set(false);
                            throw th;
                        }
                    }
                    if (z2) {
                        androidx.lifecycle.ComputableLiveData.this.mLiveData.postValue(obj);
                    }
                    androidx.lifecycle.ComputableLiveData.this.mComputing.set(false);
                    z = z2;
                }
                if (!z) {
                    return;
                }
            } while (androidx.lifecycle.ComputableLiveData.this.mInvalid.get());
        }
    }

    /* renamed from: androidx.lifecycle.ComputableLiveData$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        @androidx.annotation.MainThread
        public void run() {
            boolean hasActiveObservers = androidx.lifecycle.ComputableLiveData.this.mLiveData.hasActiveObservers();
            if (androidx.lifecycle.ComputableLiveData.this.mInvalid.compareAndSet(false, true) && hasActiveObservers) {
                androidx.lifecycle.ComputableLiveData computableLiveData = androidx.lifecycle.ComputableLiveData.this;
                computableLiveData.mExecutor.execute(computableLiveData.mRefreshRunnable);
            }
        }
    }

    public ComputableLiveData() {
        this(androidx.arch.core.executor.ArchTaskExecutor.getIOThreadExecutor());
    }

    public ComputableLiveData(@androidx.annotation.NonNull java.util.concurrent.Executor executor) {
        this.mInvalid = new java.util.concurrent.atomic.AtomicBoolean(true);
        this.mComputing = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.mRefreshRunnable = new androidx.lifecycle.ComputableLiveData.AnonymousClass2();
        this.mInvalidationRunnable = new androidx.lifecycle.ComputableLiveData.AnonymousClass3();
        this.mExecutor = executor;
        this.mLiveData = new androidx.lifecycle.ComputableLiveData.AnonymousClass1();
    }

    @androidx.annotation.WorkerThread
    public abstract T compute();

    @androidx.annotation.NonNull
    public androidx.lifecycle.LiveData<T> getLiveData() {
        return this.mLiveData;
    }

    public void invalidate() {
        androidx.arch.core.executor.ArchTaskExecutor.getInstance().executeOnMainThread(this.mInvalidationRunnable);
    }
}
