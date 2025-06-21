package androidx.lifecycle;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    static final java.lang.Object NOT_SET = new java.lang.Object();
    static final int START_VERSION = -1;
    int mActiveCount;
    private boolean mChangingActiveState;
    private volatile java.lang.Object mData;
    final java.lang.Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private androidx.arch.core.internal.SafeIterableMap<androidx.lifecycle.Observer<? super T>, androidx.lifecycle.LiveData<T>.ObserverWrapper> mObservers;
    volatile java.lang.Object mPendingData;
    private final java.lang.Runnable mPostValueRunnable;
    private int mVersion;

    /* renamed from: androidx.lifecycle.LiveData$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            java.lang.Object obj;
            synchronized (androidx.lifecycle.LiveData.this.mDataLock) {
                obj = androidx.lifecycle.LiveData.this.mPendingData;
                androidx.lifecycle.LiveData.this.mPendingData = androidx.lifecycle.LiveData.NOT_SET;
            }
            androidx.lifecycle.LiveData.this.setValue(obj);
        }
    }

    public class AlwaysActiveObserver extends androidx.lifecycle.LiveData<T>.ObserverWrapper {
        public AlwaysActiveObserver(androidx.lifecycle.Observer<? super T> observer) {
            super(observer);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return true;
        }
    }

    public class LifecycleBoundObserver extends androidx.lifecycle.LiveData<T>.ObserverWrapper implements androidx.lifecycle.LifecycleEventObserver {

        @androidx.annotation.NonNull
        final androidx.lifecycle.LifecycleOwner mOwner;

        public LifecycleBoundObserver(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, androidx.lifecycle.Observer<? super T> observer) {
            super(observer);
            this.mOwner = lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public void detachObserver() {
            this.mOwner.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean isAttachedTo(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
            return this.mOwner == lifecycleOwner;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
            androidx.lifecycle.Lifecycle.State currentState = this.mOwner.getLifecycle().getCurrentState();
            if (currentState == androidx.lifecycle.Lifecycle.State.DESTROYED) {
                androidx.lifecycle.LiveData.this.removeObserver(this.mObserver);
                return;
            }
            androidx.lifecycle.Lifecycle.State state = null;
            while (state != currentState) {
                activeStateChanged(shouldBeActive());
                state = currentState;
                currentState = this.mOwner.getLifecycle().getCurrentState();
            }
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public boolean shouldBeActive() {
            return this.mOwner.getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED);
        }
    }

    public abstract class ObserverWrapper {
        boolean mActive;
        int mLastVersion = -1;
        final androidx.lifecycle.Observer<? super T> mObserver;

        public ObserverWrapper(androidx.lifecycle.Observer<? super T> observer) {
            this.mObserver = observer;
        }

        public void activeStateChanged(boolean z) {
            if (z == this.mActive) {
                return;
            }
            this.mActive = z;
            androidx.lifecycle.LiveData.this.changeActiveCounter(z ? 1 : -1);
            if (this.mActive) {
                androidx.lifecycle.LiveData.this.dispatchingValue(this);
            }
        }

        public void detachObserver() {
        }

        public boolean isAttachedTo(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
            return false;
        }

        public abstract boolean shouldBeActive();
    }

    public LiveData() {
        this.mDataLock = new java.lang.Object();
        this.mObservers = new androidx.arch.core.internal.SafeIterableMap<>();
        this.mActiveCount = 0;
        java.lang.Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new androidx.lifecycle.LiveData.AnonymousClass1();
        this.mData = obj;
        this.mVersion = -1;
    }

    public LiveData(T t) {
        this.mDataLock = new java.lang.Object();
        this.mObservers = new androidx.arch.core.internal.SafeIterableMap<>();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new androidx.lifecycle.LiveData.AnonymousClass1();
        this.mData = t;
        this.mVersion = 0;
    }

    public static void assertMainThread(java.lang.String str) {
        if (androidx.arch.core.executor.ArchTaskExecutor.getInstance().isMainThread()) {
            return;
        }
        throw new java.lang.IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void considerNotify(androidx.lifecycle.LiveData<T>.ObserverWrapper observerWrapper) {
        if (observerWrapper.mActive) {
            if (!observerWrapper.shouldBeActive()) {
                observerWrapper.activeStateChanged(false);
                return;
            }
            int i = observerWrapper.mLastVersion;
            int i2 = this.mVersion;
            if (i >= i2) {
                return;
            }
            observerWrapper.mLastVersion = i2;
            observerWrapper.mObserver.onChanged((java.lang.Object) this.mData);
        }
    }

    @androidx.annotation.MainThread
    public void changeActiveCounter(int i) {
        int i2 = this.mActiveCount;
        this.mActiveCount = i + i2;
        if (this.mChangingActiveState) {
            return;
        }
        this.mChangingActiveState = true;
        while (true) {
            try {
                int i3 = this.mActiveCount;
                if (i2 == i3) {
                    return;
                }
                boolean z = i2 == 0 && i3 > 0;
                boolean z2 = i2 > 0 && i3 == 0;
                if (z) {
                    onActive();
                } else if (z2) {
                    onInactive();
                }
                i2 = i3;
            } finally {
                this.mChangingActiveState = false;
            }
        }
    }

    public void dispatchingValue(@androidx.annotation.Nullable androidx.lifecycle.LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (observerWrapper != null) {
                considerNotify(observerWrapper);
                observerWrapper = null;
            } else {
                androidx.arch.core.internal.SafeIterableMap<androidx.lifecycle.Observer<? super T>, androidx.lifecycle.LiveData<T>.ObserverWrapper>.IteratorWithAdditions iteratorWithAdditions = this.mObservers.iteratorWithAdditions();
                while (iteratorWithAdditions.hasNext()) {
                    considerNotify((androidx.lifecycle.LiveData.ObserverWrapper) iteratorWithAdditions.next().getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    @androidx.annotation.Nullable
    public T getValue() {
        T t = (T) this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }

    @androidx.annotation.MainThread
    public void observe(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Observer<? super T> observer) {
        assertMainThread("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() == androidx.lifecycle.Lifecycle.State.DESTROYED) {
            return;
        }
        androidx.lifecycle.LiveData.LifecycleBoundObserver lifecycleBoundObserver = new androidx.lifecycle.LiveData.LifecycleBoundObserver(lifecycleOwner, observer);
        androidx.lifecycle.LiveData<T>.ObserverWrapper putIfAbsent = this.mObservers.putIfAbsent(observer, lifecycleBoundObserver);
        if (putIfAbsent != null && !putIfAbsent.isAttachedTo(lifecycleOwner)) {
            throw new java.lang.IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (putIfAbsent != null) {
            return;
        }
        lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
    }

    @androidx.annotation.MainThread
    public void observeForever(@androidx.annotation.NonNull androidx.lifecycle.Observer<? super T> observer) {
        assertMainThread("observeForever");
        androidx.lifecycle.LiveData.AlwaysActiveObserver alwaysActiveObserver = new androidx.lifecycle.LiveData.AlwaysActiveObserver(observer);
        androidx.lifecycle.LiveData<T>.ObserverWrapper putIfAbsent = this.mObservers.putIfAbsent(observer, alwaysActiveObserver);
        if (putIfAbsent instanceof androidx.lifecycle.LiveData.LifecycleBoundObserver) {
            throw new java.lang.IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (putIfAbsent != null) {
            return;
        }
        alwaysActiveObserver.activeStateChanged(true);
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(T t) {
        boolean z;
        synchronized (this.mDataLock) {
            z = this.mPendingData == NOT_SET;
            this.mPendingData = t;
        }
        if (z) {
            androidx.arch.core.executor.ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
        }
    }

    @androidx.annotation.MainThread
    public void removeObserver(@androidx.annotation.NonNull androidx.lifecycle.Observer<? super T> observer) {
        assertMainThread("removeObserver");
        androidx.lifecycle.LiveData<T>.ObserverWrapper remove = this.mObservers.remove(observer);
        if (remove == null) {
            return;
        }
        remove.detachObserver();
        remove.activeStateChanged(false);
    }

    @androidx.annotation.MainThread
    public void removeObservers(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        assertMainThread("removeObservers");
        java.util.Iterator<java.util.Map.Entry<androidx.lifecycle.Observer<? super T>, androidx.lifecycle.LiveData<T>.ObserverWrapper>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            java.util.Map.Entry<androidx.lifecycle.Observer<? super T>, androidx.lifecycle.LiveData<T>.ObserverWrapper> next = it.next();
            if (next.getValue().isAttachedTo(lifecycleOwner)) {
                removeObserver(next.getKey());
            }
        }
    }

    @androidx.annotation.MainThread
    public void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue(null);
    }
}
