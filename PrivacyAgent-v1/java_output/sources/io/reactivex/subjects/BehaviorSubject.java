package io.reactivex.subjects;

/* loaded from: classes14.dex */
public final class BehaviorSubject<T> extends io.reactivex.subjects.Subject<T> {
    public final java.util.concurrent.atomic.AtomicReference<java.lang.Object> n;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T>[]> t;
    public final java.util.concurrent.locks.ReadWriteLock u;
    public final java.util.concurrent.locks.Lock v;
    public final java.util.concurrent.locks.Lock w;
    public final java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> x;
    public long y;
    public static final java.lang.Object[] z = new java.lang.Object[0];
    public static final io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[] A = new io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[0];
    public static final io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[] B = new io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[0];

    public static final class BehaviorDisposable<T> implements io.reactivex.disposables.Disposable, io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate<java.lang.Object> {
        public final io.reactivex.Observer<? super T> n;
        public final io.reactivex.subjects.BehaviorSubject<T> t;
        public boolean u;
        public boolean v;
        public io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> w;
        public boolean x;
        public volatile boolean y;
        public long z;

        public BehaviorDisposable(io.reactivex.Observer<? super T> observer, io.reactivex.subjects.BehaviorSubject<T> behaviorSubject) {
            this.n = observer;
            this.t = behaviorSubject;
        }

        public void a() {
            if (this.y) {
                return;
            }
            synchronized (this) {
                if (this.y) {
                    return;
                }
                if (this.u) {
                    return;
                }
                io.reactivex.subjects.BehaviorSubject<T> behaviorSubject = this.t;
                java.util.concurrent.locks.Lock lock = behaviorSubject.v;
                lock.lock();
                this.z = behaviorSubject.y;
                java.lang.Object obj = behaviorSubject.n.get();
                lock.unlock();
                this.v = obj != null;
                this.u = true;
                if (obj == null || test(obj)) {
                    return;
                }
                b();
            }
        }

        public void b() {
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList;
            while (!this.y) {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.w;
                    if (appendOnlyLinkedArrayList == null) {
                        this.v = false;
                        return;
                    }
                    this.w = null;
                }
                appendOnlyLinkedArrayList.forEachWhile(this);
            }
        }

        public void c(java.lang.Object obj, long j) {
            if (this.y) {
                return;
            }
            if (!this.x) {
                synchronized (this) {
                    if (this.y) {
                        return;
                    }
                    if (this.z == j) {
                        return;
                    }
                    if (this.v) {
                        io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.w;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                            this.w = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(obj);
                        return;
                    }
                    this.u = true;
                    this.x = true;
                }
            }
            test(obj);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.y) {
                return;
            }
            this.y = true;
            this.t.e(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.y;
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(java.lang.Object obj) {
            return this.y || io.reactivex.internal.util.NotificationLite.accept(obj, this.n);
        }
    }

    public BehaviorSubject() {
        java.util.concurrent.locks.ReentrantReadWriteLock reentrantReadWriteLock = new java.util.concurrent.locks.ReentrantReadWriteLock();
        this.u = reentrantReadWriteLock;
        this.v = reentrantReadWriteLock.readLock();
        this.w = reentrantReadWriteLock.writeLock();
        this.t = new java.util.concurrent.atomic.AtomicReference<>(A);
        this.n = new java.util.concurrent.atomic.AtomicReference<>();
        this.x = new java.util.concurrent.atomic.AtomicReference<>();
    }

    public BehaviorSubject(T t) {
        this();
        this.n.lazySet(io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "defaultValue is null"));
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.BehaviorSubject<T> create() {
        return new io.reactivex.subjects.BehaviorSubject<>();
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.BehaviorSubject<T> createDefault(T t) {
        return new io.reactivex.subjects.BehaviorSubject<>(t);
    }

    public boolean d(io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T> behaviorDisposable) {
        io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T>[] behaviorDisposableArr;
        io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.t.get();
            if (behaviorDisposableArr == B) {
                return false;
            }
            int length = behaviorDisposableArr.length;
            behaviorDisposableArr2 = new io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[length + 1];
            java.lang.System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr2, 0, length);
            behaviorDisposableArr2[length] = behaviorDisposable;
        } while (!defpackage.xv0.a(this.t, behaviorDisposableArr, behaviorDisposableArr2));
        return true;
    }

    public void e(io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T> behaviorDisposable) {
        io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T>[] behaviorDisposableArr;
        io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[] behaviorDisposableArr2;
        do {
            behaviorDisposableArr = this.t.get();
            int length = behaviorDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (behaviorDisposableArr[i] == behaviorDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                behaviorDisposableArr2 = A;
            } else {
                io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[] behaviorDisposableArr3 = new io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[length - 1];
                java.lang.System.arraycopy(behaviorDisposableArr, 0, behaviorDisposableArr3, 0, i);
                java.lang.System.arraycopy(behaviorDisposableArr, i + 1, behaviorDisposableArr3, i, (length - i) - 1);
                behaviorDisposableArr2 = behaviorDisposableArr3;
            }
        } while (!defpackage.xv0.a(this.t, behaviorDisposableArr, behaviorDisposableArr2));
    }

    public void f(java.lang.Object obj) {
        this.w.lock();
        this.y++;
        this.n.lazySet(obj);
        this.w.unlock();
    }

    public io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T>[] g(java.lang.Object obj) {
        java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T>[]> atomicReference = this.t;
        io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T>[] behaviorDisposableArr = B;
        io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T>[] andSet = atomicReference.getAndSet(behaviorDisposableArr);
        if (andSet != behaviorDisposableArr) {
            f(obj);
        }
        return andSet;
    }

    @Override // io.reactivex.subjects.Subject
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        java.lang.Object obj = this.n.get();
        if (io.reactivex.internal.util.NotificationLite.isError(obj)) {
            return io.reactivex.internal.util.NotificationLite.getError(obj);
        }
        return null;
    }

    @io.reactivex.annotations.Nullable
    public T getValue() {
        java.lang.Object obj = this.n.get();
        if (io.reactivex.internal.util.NotificationLite.isComplete(obj) || io.reactivex.internal.util.NotificationLite.isError(obj)) {
            return null;
        }
        return (T) io.reactivex.internal.util.NotificationLite.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    public java.lang.Object[] getValues() {
        java.lang.Object[] objArr = z;
        java.lang.Object[] values = getValues(objArr);
        return values == objArr ? new java.lang.Object[0] : values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    public T[] getValues(T[] tArr) {
        java.lang.Object obj = this.n.get();
        if (obj == null || io.reactivex.internal.util.NotificationLite.isComplete(obj) || io.reactivex.internal.util.NotificationLite.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = 0;
            }
            return tArr;
        }
        java.lang.Object value = io.reactivex.internal.util.NotificationLite.getValue(obj);
        if (tArr.length == 0) {
            T[] tArr2 = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), 1));
            tArr2[0] = value;
            return tArr2;
        }
        tArr[0] = value;
        if (tArr.length == 1) {
            return tArr;
        }
        tArr[1] = 0;
        return tArr;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return io.reactivex.internal.util.NotificationLite.isComplete(this.n.get());
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.t.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return io.reactivex.internal.util.NotificationLite.isError(this.n.get());
    }

    public boolean hasValue() {
        java.lang.Object obj = this.n.get();
        return (obj == null || io.reactivex.internal.util.NotificationLite.isComplete(obj) || io.reactivex.internal.util.NotificationLite.isError(obj)) ? false : true;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (defpackage.xv0.a(this.x, null, io.reactivex.internal.util.ExceptionHelper.TERMINATED)) {
            java.lang.Object complete = io.reactivex.internal.util.NotificationLite.complete();
            for (io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T> behaviorDisposable : g(complete)) {
                behaviorDisposable.c(complete, this.y);
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!defpackage.xv0.a(this.x, null, th)) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        java.lang.Object error = io.reactivex.internal.util.NotificationLite.error(th);
        for (io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T> behaviorDisposable : g(error)) {
            behaviorDisposable.c(error, this.y);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.x.get() != null) {
            return;
        }
        java.lang.Object next = io.reactivex.internal.util.NotificationLite.next(t);
        f(next);
        for (io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T> behaviorDisposable : this.t.get()) {
            behaviorDisposable.c(next, this.y);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        if (this.x.get() != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<T> behaviorDisposable = new io.reactivex.subjects.BehaviorSubject.BehaviorDisposable<>(observer, this);
        observer.onSubscribe(behaviorDisposable);
        if (d(behaviorDisposable)) {
            if (behaviorDisposable.y) {
                e(behaviorDisposable);
                return;
            } else {
                behaviorDisposable.a();
                return;
            }
        }
        java.lang.Throwable th = this.x.get();
        if (th == io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
            observer.onComplete();
        } else {
            observer.onError(th);
        }
    }
}
