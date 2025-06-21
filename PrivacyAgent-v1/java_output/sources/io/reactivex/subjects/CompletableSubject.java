package io.reactivex.subjects;

/* loaded from: classes14.dex */
public final class CompletableSubject extends io.reactivex.Completable implements io.reactivex.CompletableObserver {
    public static final io.reactivex.subjects.CompletableSubject.CompletableDisposable[] v = new io.reactivex.subjects.CompletableSubject.CompletableDisposable[0];
    public static final io.reactivex.subjects.CompletableSubject.CompletableDisposable[] w = new io.reactivex.subjects.CompletableSubject.CompletableDisposable[0];
    public java.lang.Throwable u;
    public final java.util.concurrent.atomic.AtomicBoolean t = new java.util.concurrent.atomic.AtomicBoolean();
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.CompletableSubject.CompletableDisposable[]> n = new java.util.concurrent.atomic.AtomicReference<>(v);

    public static final class CompletableDisposable extends java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.CompletableSubject> implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final io.reactivex.CompletableObserver downstream;

        public CompletableDisposable(io.reactivex.CompletableObserver completableObserver, io.reactivex.subjects.CompletableSubject completableSubject) {
            this.downstream = completableObserver;
            lazySet(completableSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.subjects.CompletableSubject andSet = getAndSet(null);
            if (andSet != null) {
                andSet.f(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static io.reactivex.subjects.CompletableSubject create() {
        return new io.reactivex.subjects.CompletableSubject();
    }

    public boolean e(io.reactivex.subjects.CompletableSubject.CompletableDisposable completableDisposable) {
        io.reactivex.subjects.CompletableSubject.CompletableDisposable[] completableDisposableArr;
        io.reactivex.subjects.CompletableSubject.CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.n.get();
            if (completableDisposableArr == w) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new io.reactivex.subjects.CompletableSubject.CompletableDisposable[length + 1];
            java.lang.System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!defpackage.xv0.a(this.n, completableDisposableArr, completableDisposableArr2));
        return true;
    }

    public void f(io.reactivex.subjects.CompletableSubject.CompletableDisposable completableDisposable) {
        io.reactivex.subjects.CompletableSubject.CompletableDisposable[] completableDisposableArr;
        io.reactivex.subjects.CompletableSubject.CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.n.get();
            int length = completableDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (completableDisposableArr[i] == completableDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                completableDisposableArr2 = v;
            } else {
                io.reactivex.subjects.CompletableSubject.CompletableDisposable[] completableDisposableArr3 = new io.reactivex.subjects.CompletableSubject.CompletableDisposable[length - 1];
                java.lang.System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i);
                java.lang.System.arraycopy(completableDisposableArr, i + 1, completableDisposableArr3, i, (length - i) - 1);
                completableDisposableArr2 = completableDisposableArr3;
            }
        } while (!defpackage.xv0.a(this.n, completableDisposableArr, completableDisposableArr2));
    }

    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        if (this.n.get() == w) {
            return this.u;
        }
        return null;
    }

    public boolean hasComplete() {
        return this.n.get() == w && this.u == null;
    }

    public boolean hasObservers() {
        return this.n.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.n.get() == w && this.u != null;
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        if (this.t.compareAndSet(false, true)) {
            for (io.reactivex.subjects.CompletableSubject.CompletableDisposable completableDisposable : this.n.getAndSet(w)) {
                completableDisposable.downstream.onComplete();
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.t.compareAndSet(false, true)) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.u = th;
        for (io.reactivex.subjects.CompletableSubject.CompletableDisposable completableDisposable : this.n.getAndSet(w)) {
            completableDisposable.downstream.onError(th);
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        if (this.n.get() == w) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.subjects.CompletableSubject.CompletableDisposable completableDisposable = new io.reactivex.subjects.CompletableSubject.CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe(completableDisposable);
        if (e(completableDisposable)) {
            if (completableDisposable.isDisposed()) {
                f(completableDisposable);
            }
        } else {
            java.lang.Throwable th = this.u;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        }
    }
}
