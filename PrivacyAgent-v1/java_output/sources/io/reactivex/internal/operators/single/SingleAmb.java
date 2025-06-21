package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleAmb<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<? extends T>[] n;
    public final java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> t;

    public static final class AmbSingleObserver<T> implements io.reactivex.SingleObserver<T> {
        public final io.reactivex.disposables.CompositeDisposable n;
        public final io.reactivex.SingleObserver<? super T> t;
        public final java.util.concurrent.atomic.AtomicBoolean u;
        public io.reactivex.disposables.Disposable v;

        public AmbSingleObserver(io.reactivex.SingleObserver<? super T> singleObserver, io.reactivex.disposables.CompositeDisposable compositeDisposable, java.util.concurrent.atomic.AtomicBoolean atomicBoolean) {
            this.t = singleObserver;
            this.n = compositeDisposable;
            this.u = atomicBoolean;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            if (!this.u.compareAndSet(false, true)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.n.delete(this.v);
            this.n.dispose();
            this.t.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.v = disposable;
            this.n.add(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            if (this.u.compareAndSet(false, true)) {
                this.n.delete(this.v);
                this.n.dispose();
                this.t.onSuccess(t);
            }
        }
    }

    public SingleAmb(io.reactivex.SingleSource<? extends T>[] singleSourceArr, java.lang.Iterable<? extends io.reactivex.SingleSource<? extends T>> iterable) {
        this.n = singleSourceArr;
        this.t = iterable;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        int length;
        io.reactivex.SingleSource<? extends T>[] singleSourceArr = this.n;
        if (singleSourceArr == null) {
            singleSourceArr = new io.reactivex.SingleSource[8];
            try {
                length = 0;
                for (io.reactivex.SingleSource<? extends T> singleSource : this.t) {
                    if (singleSource == null) {
                        io.reactivex.internal.disposables.EmptyDisposable.error(new java.lang.NullPointerException("One of the sources is null"), singleObserver);
                        return;
                    }
                    if (length == singleSourceArr.length) {
                        io.reactivex.SingleSource<? extends T>[] singleSourceArr2 = new io.reactivex.SingleSource[(length >> 2) + length];
                        java.lang.System.arraycopy(singleSourceArr, 0, singleSourceArr2, 0, length);
                        singleSourceArr = singleSourceArr2;
                    }
                    int i = length + 1;
                    singleSourceArr[length] = singleSource;
                    length = i;
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.disposables.EmptyDisposable.error(th, singleObserver);
                return;
            }
        } else {
            length = singleSourceArr.length;
        }
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean();
        io.reactivex.disposables.CompositeDisposable compositeDisposable = new io.reactivex.disposables.CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        for (int i2 = 0; i2 < length; i2++) {
            io.reactivex.SingleSource<? extends T> singleSource2 = singleSourceArr[i2];
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (singleSource2 == null) {
                compositeDisposable.dispose();
                java.lang.NullPointerException nullPointerException = new java.lang.NullPointerException("One of the sources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    singleObserver.onError(nullPointerException);
                    return;
                } else {
                    io.reactivex.plugins.RxJavaPlugins.onError(nullPointerException);
                    return;
                }
            }
            singleSource2.subscribe(new io.reactivex.internal.operators.single.SingleAmb.AmbSingleObserver(singleObserver, compositeDisposable, atomicBoolean));
        }
    }
}
