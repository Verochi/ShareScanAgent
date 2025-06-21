package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeAmb<T> extends io.reactivex.Maybe<T> {
    public final io.reactivex.MaybeSource<? extends T>[] n;
    public final java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> t;

    public static final class AmbMaybeObserver<T> implements io.reactivex.MaybeObserver<T> {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final java.util.concurrent.atomic.AtomicBoolean t;
        public final io.reactivex.disposables.CompositeDisposable u;
        public io.reactivex.disposables.Disposable v;

        public AmbMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.disposables.CompositeDisposable compositeDisposable, java.util.concurrent.atomic.AtomicBoolean atomicBoolean) {
            this.n = maybeObserver;
            this.u = compositeDisposable;
            this.t = atomicBoolean;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.t.compareAndSet(false, true)) {
                this.u.delete(this.v);
                this.u.dispose();
                this.n.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            if (!this.t.compareAndSet(false, true)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.u.delete(this.v);
            this.u.dispose();
            this.n.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.v = disposable;
            this.u.add(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            if (this.t.compareAndSet(false, true)) {
                this.u.delete(this.v);
                this.u.dispose();
                this.n.onSuccess(t);
            }
        }
    }

    public MaybeAmb(io.reactivex.MaybeSource<? extends T>[] maybeSourceArr, java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> iterable) {
        this.n = maybeSourceArr;
        this.t = iterable;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        int length;
        io.reactivex.MaybeSource<? extends T>[] maybeSourceArr = this.n;
        if (maybeSourceArr == null) {
            maybeSourceArr = new io.reactivex.MaybeSource[8];
            try {
                length = 0;
                for (io.reactivex.MaybeSource<? extends T> maybeSource : this.t) {
                    if (maybeSource == null) {
                        io.reactivex.internal.disposables.EmptyDisposable.error(new java.lang.NullPointerException("One of the sources is null"), maybeObserver);
                        return;
                    }
                    if (length == maybeSourceArr.length) {
                        io.reactivex.MaybeSource<? extends T>[] maybeSourceArr2 = new io.reactivex.MaybeSource[(length >> 2) + length];
                        java.lang.System.arraycopy(maybeSourceArr, 0, maybeSourceArr2, 0, length);
                        maybeSourceArr = maybeSourceArr2;
                    }
                    int i = length + 1;
                    maybeSourceArr[length] = maybeSource;
                    length = i;
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.disposables.EmptyDisposable.error(th, maybeObserver);
                return;
            }
        } else {
            length = maybeSourceArr.length;
        }
        io.reactivex.disposables.CompositeDisposable compositeDisposable = new io.reactivex.disposables.CompositeDisposable();
        maybeObserver.onSubscribe(compositeDisposable);
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean();
        for (int i2 = 0; i2 < length; i2++) {
            io.reactivex.MaybeSource<? extends T> maybeSource2 = maybeSourceArr[i2];
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (maybeSource2 == null) {
                compositeDisposable.dispose();
                java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("One of the MaybeSources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    maybeObserver.onError(nullPointerException);
                    return;
                } else {
                    io.reactivex.plugins.RxJavaPlugins.onError(nullPointerException);
                    return;
                }
            }
            maybeSource2.subscribe(new io.reactivex.internal.operators.maybe.MaybeAmb.AmbMaybeObserver(maybeObserver, compositeDisposable, atomicBoolean));
        }
        if (length == 0) {
            maybeObserver.onComplete();
        }
    }
}
