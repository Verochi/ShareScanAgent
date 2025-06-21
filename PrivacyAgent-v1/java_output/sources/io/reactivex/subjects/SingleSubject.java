package io.reactivex.subjects;

/* loaded from: classes14.dex */
public final class SingleSubject<T> extends io.reactivex.Single<T> implements io.reactivex.SingleObserver<T> {
    public static final io.reactivex.subjects.SingleSubject.SingleDisposable[] w = new io.reactivex.subjects.SingleSubject.SingleDisposable[0];
    public static final io.reactivex.subjects.SingleSubject.SingleDisposable[] x = new io.reactivex.subjects.SingleSubject.SingleDisposable[0];
    public T u;
    public java.lang.Throwable v;
    public final java.util.concurrent.atomic.AtomicBoolean t = new java.util.concurrent.atomic.AtomicBoolean();
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.SingleSubject.SingleDisposable<T>[]> n = new java.util.concurrent.atomic.AtomicReference<>(w);

    public static final class SingleDisposable<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.SingleSubject<T>> implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final io.reactivex.SingleObserver<? super T> downstream;

        public SingleDisposable(io.reactivex.SingleObserver<? super T> singleObserver, io.reactivex.subjects.SingleSubject<T> singleSubject) {
            this.downstream = singleObserver;
            lazySet(singleSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.subjects.SingleSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.d(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.SingleSubject<T> create() {
        return new io.reactivex.subjects.SingleSubject<>();
    }

    public boolean c(@io.reactivex.annotations.NonNull io.reactivex.subjects.SingleSubject.SingleDisposable<T> singleDisposable) {
        io.reactivex.subjects.SingleSubject.SingleDisposable<T>[] singleDisposableArr;
        io.reactivex.subjects.SingleSubject.SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = this.n.get();
            if (singleDisposableArr == x) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new io.reactivex.subjects.SingleSubject.SingleDisposable[length + 1];
            java.lang.System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!defpackage.xv0.a(this.n, singleDisposableArr, singleDisposableArr2));
        return true;
    }

    public void d(@io.reactivex.annotations.NonNull io.reactivex.subjects.SingleSubject.SingleDisposable<T> singleDisposable) {
        io.reactivex.subjects.SingleSubject.SingleDisposable<T>[] singleDisposableArr;
        io.reactivex.subjects.SingleSubject.SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = this.n.get();
            int length = singleDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (singleDisposableArr[i] == singleDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                singleDisposableArr2 = w;
            } else {
                io.reactivex.subjects.SingleSubject.SingleDisposable[] singleDisposableArr3 = new io.reactivex.subjects.SingleSubject.SingleDisposable[length - 1];
                java.lang.System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i);
                java.lang.System.arraycopy(singleDisposableArr, i + 1, singleDisposableArr3, i, (length - i) - 1);
                singleDisposableArr2 = singleDisposableArr3;
            }
        } while (!defpackage.xv0.a(this.n, singleDisposableArr, singleDisposableArr2));
    }

    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        if (this.n.get() == x) {
            return this.v;
        }
        return null;
    }

    @io.reactivex.annotations.Nullable
    public T getValue() {
        if (this.n.get() == x) {
            return this.u;
        }
        return null;
    }

    public boolean hasObservers() {
        return this.n.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.n.get() == x && this.v != null;
    }

    public boolean hasValue() {
        return this.n.get() == x && this.u != null;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(@io.reactivex.annotations.NonNull java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.t.compareAndSet(false, true)) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.v = th;
        for (io.reactivex.subjects.SingleSubject.SingleDisposable<T> singleDisposable : this.n.getAndSet(x)) {
            singleDisposable.downstream.onError(th);
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable disposable) {
        if (this.n.get() == x) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(@io.reactivex.annotations.NonNull T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.t.compareAndSet(false, true)) {
            this.u = t;
            for (io.reactivex.subjects.SingleSubject.SingleDisposable<T> singleDisposable : this.n.getAndSet(x)) {
                singleDisposable.downstream.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.Single
    public void subscribeActual(@io.reactivex.annotations.NonNull io.reactivex.SingleObserver<? super T> singleObserver) {
        io.reactivex.subjects.SingleSubject.SingleDisposable<T> singleDisposable = new io.reactivex.subjects.SingleSubject.SingleDisposable<>(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        if (c(singleDisposable)) {
            if (singleDisposable.isDisposed()) {
                d(singleDisposable);
            }
        } else {
            java.lang.Throwable th = this.v;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess(this.u);
            }
        }
    }
}
