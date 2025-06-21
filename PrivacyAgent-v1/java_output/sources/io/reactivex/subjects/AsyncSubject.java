package io.reactivex.subjects;

/* loaded from: classes14.dex */
public final class AsyncSubject<T> extends io.reactivex.subjects.Subject<T> {
    public static final io.reactivex.subjects.AsyncSubject.AsyncDisposable[] v = new io.reactivex.subjects.AsyncSubject.AsyncDisposable[0];
    public static final io.reactivex.subjects.AsyncSubject.AsyncDisposable[] w = new io.reactivex.subjects.AsyncSubject.AsyncDisposable[0];
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.AsyncSubject.AsyncDisposable<T>[]> n = new java.util.concurrent.atomic.AtomicReference<>(v);
    public java.lang.Throwable t;
    public T u;

    public static final class AsyncDisposable<T> extends io.reactivex.internal.observers.DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final io.reactivex.subjects.AsyncSubject<T> parent;

        public AsyncDisposable(io.reactivex.Observer<? super T> observer, io.reactivex.subjects.AsyncSubject<T> asyncSubject) {
            super(observer);
            this.parent = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            if (super.tryDispose()) {
                this.parent.e(this);
            }
        }

        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.downstream.onComplete();
        }

        public void onError(java.lang.Throwable th) {
            if (isDisposed()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.AsyncSubject<T> create() {
        return new io.reactivex.subjects.AsyncSubject<>();
    }

    public boolean d(io.reactivex.subjects.AsyncSubject.AsyncDisposable<T> asyncDisposable) {
        io.reactivex.subjects.AsyncSubject.AsyncDisposable<T>[] asyncDisposableArr;
        io.reactivex.subjects.AsyncSubject.AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.n.get();
            if (asyncDisposableArr == w) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new io.reactivex.subjects.AsyncSubject.AsyncDisposable[length + 1];
            java.lang.System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!defpackage.xv0.a(this.n, asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    public void e(io.reactivex.subjects.AsyncSubject.AsyncDisposable<T> asyncDisposable) {
        io.reactivex.subjects.AsyncSubject.AsyncDisposable<T>[] asyncDisposableArr;
        io.reactivex.subjects.AsyncSubject.AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.n.get();
            int length = asyncDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (asyncDisposableArr[i] == asyncDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                asyncDisposableArr2 = v;
            } else {
                io.reactivex.subjects.AsyncSubject.AsyncDisposable[] asyncDisposableArr3 = new io.reactivex.subjects.AsyncSubject.AsyncDisposable[length - 1];
                java.lang.System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i);
                java.lang.System.arraycopy(asyncDisposableArr, i + 1, asyncDisposableArr3, i, (length - i) - 1);
                asyncDisposableArr2 = asyncDisposableArr3;
            }
        } while (!defpackage.xv0.a(this.n, asyncDisposableArr, asyncDisposableArr2));
    }

    @Override // io.reactivex.subjects.Subject
    public java.lang.Throwable getThrowable() {
        if (this.n.get() == w) {
            return this.t;
        }
        return null;
    }

    @io.reactivex.annotations.Nullable
    public T getValue() {
        if (this.n.get() == w) {
            return this.u;
        }
        return null;
    }

    @java.lang.Deprecated
    public java.lang.Object[] getValues() {
        T value = getValue();
        return value != null ? new java.lang.Object[]{value} : new java.lang.Object[0];
    }

    @java.lang.Deprecated
    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) java.util.Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.n.get() == w && this.t == null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.n.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.n.get() == w && this.t != null;
    }

    public boolean hasValue() {
        return this.n.get() == w && this.u != null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        io.reactivex.subjects.AsyncSubject.AsyncDisposable<T>[] asyncDisposableArr = this.n.get();
        io.reactivex.subjects.AsyncSubject.AsyncDisposable<T>[] asyncDisposableArr2 = w;
        if (asyncDisposableArr == asyncDisposableArr2) {
            return;
        }
        T t = this.u;
        io.reactivex.subjects.AsyncSubject.AsyncDisposable<T>[] andSet = this.n.getAndSet(asyncDisposableArr2);
        int i = 0;
        if (t == null) {
            int length = andSet.length;
            while (i < length) {
                andSet[i].onComplete();
                i++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i < length2) {
            andSet[i].complete(t);
            i++;
        }
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        io.reactivex.subjects.AsyncSubject.AsyncDisposable<T>[] asyncDisposableArr = this.n.get();
        io.reactivex.subjects.AsyncSubject.AsyncDisposable<T>[] asyncDisposableArr2 = w;
        if (asyncDisposableArr == asyncDisposableArr2) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.u = null;
        this.t = th;
        for (io.reactivex.subjects.AsyncSubject.AsyncDisposable<T> asyncDisposable : this.n.getAndSet(asyncDisposableArr2)) {
            asyncDisposable.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.n.get() == w) {
            return;
        }
        this.u = t;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        if (this.n.get() == w) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.subjects.AsyncSubject.AsyncDisposable<T> asyncDisposable = new io.reactivex.subjects.AsyncSubject.AsyncDisposable<>(observer, this);
        observer.onSubscribe(asyncDisposable);
        if (d(asyncDisposable)) {
            if (asyncDisposable.isDisposed()) {
                e(asyncDisposable);
                return;
            }
            return;
        }
        java.lang.Throwable th = this.t;
        if (th != null) {
            observer.onError(th);
            return;
        }
        T t = this.u;
        if (t != null) {
            asyncDisposable.complete(t);
        } else {
            asyncDisposable.onComplete();
        }
    }
}
