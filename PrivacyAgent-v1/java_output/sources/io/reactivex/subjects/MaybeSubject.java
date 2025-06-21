package io.reactivex.subjects;

/* loaded from: classes14.dex */
public final class MaybeSubject<T> extends io.reactivex.Maybe<T> implements io.reactivex.MaybeObserver<T> {
    public static final io.reactivex.subjects.MaybeSubject.MaybeDisposable[] w = new io.reactivex.subjects.MaybeSubject.MaybeDisposable[0];
    public static final io.reactivex.subjects.MaybeSubject.MaybeDisposable[] x = new io.reactivex.subjects.MaybeSubject.MaybeDisposable[0];
    public T u;
    public java.lang.Throwable v;
    public final java.util.concurrent.atomic.AtomicBoolean t = new java.util.concurrent.atomic.AtomicBoolean();
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.MaybeSubject.MaybeDisposable<T>[]> n = new java.util.concurrent.atomic.AtomicReference<>(w);

    public static final class MaybeDisposable<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.MaybeSubject<T>> implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final io.reactivex.MaybeObserver<? super T> downstream;

        public MaybeDisposable(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.subjects.MaybeSubject<T> maybeSubject) {
            this.downstream = maybeObserver;
            lazySet(maybeSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.subjects.MaybeSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.MaybeSubject<T> create() {
        return new io.reactivex.subjects.MaybeSubject<>();
    }

    public boolean a(io.reactivex.subjects.MaybeSubject.MaybeDisposable<T> maybeDisposable) {
        io.reactivex.subjects.MaybeSubject.MaybeDisposable<T>[] maybeDisposableArr;
        io.reactivex.subjects.MaybeSubject.MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.n.get();
            if (maybeDisposableArr == x) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new io.reactivex.subjects.MaybeSubject.MaybeDisposable[length + 1];
            java.lang.System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!defpackage.xv0.a(this.n, maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    public void b(io.reactivex.subjects.MaybeSubject.MaybeDisposable<T> maybeDisposable) {
        io.reactivex.subjects.MaybeSubject.MaybeDisposable<T>[] maybeDisposableArr;
        io.reactivex.subjects.MaybeSubject.MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = this.n.get();
            int length = maybeDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (maybeDisposableArr[i] == maybeDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                maybeDisposableArr2 = w;
            } else {
                io.reactivex.subjects.MaybeSubject.MaybeDisposable[] maybeDisposableArr3 = new io.reactivex.subjects.MaybeSubject.MaybeDisposable[length - 1];
                java.lang.System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i);
                java.lang.System.arraycopy(maybeDisposableArr, i + 1, maybeDisposableArr3, i, (length - i) - 1);
                maybeDisposableArr2 = maybeDisposableArr3;
            }
        } while (!defpackage.xv0.a(this.n, maybeDisposableArr, maybeDisposableArr2));
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

    public boolean hasComplete() {
        return this.n.get() == x && this.u == null && this.v == null;
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

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        if (this.t.compareAndSet(false, true)) {
            for (io.reactivex.subjects.MaybeSubject.MaybeDisposable<T> maybeDisposable : this.n.getAndSet(x)) {
                maybeDisposable.downstream.onComplete();
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.t.compareAndSet(false, true)) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.v = th;
        for (io.reactivex.subjects.MaybeSubject.MaybeDisposable<T> maybeDisposable : this.n.getAndSet(x)) {
            maybeDisposable.downstream.onError(th);
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        if (this.n.get() == x) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.t.compareAndSet(false, true)) {
            this.u = t;
            for (io.reactivex.subjects.MaybeSubject.MaybeDisposable<T> maybeDisposable : this.n.getAndSet(x)) {
                maybeDisposable.downstream.onSuccess(t);
            }
        }
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        io.reactivex.subjects.MaybeSubject.MaybeDisposable<T> maybeDisposable = new io.reactivex.subjects.MaybeSubject.MaybeDisposable<>(maybeObserver, this);
        maybeObserver.onSubscribe(maybeDisposable);
        if (a(maybeDisposable)) {
            if (maybeDisposable.isDisposed()) {
                b(maybeDisposable);
                return;
            }
            return;
        }
        java.lang.Throwable th = this.v;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        T t = this.u;
        if (t == null) {
            maybeObserver.onComplete();
        } else {
            maybeObserver.onSuccess(t);
        }
    }
}
