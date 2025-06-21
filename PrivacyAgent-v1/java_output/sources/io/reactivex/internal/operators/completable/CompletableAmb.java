package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableAmb extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource[] n;
    public final java.lang.Iterable<? extends io.reactivex.CompletableSource> t;

    public static final class Amb implements io.reactivex.CompletableObserver {
        public final java.util.concurrent.atomic.AtomicBoolean n;
        public final io.reactivex.disposables.CompositeDisposable t;
        public final io.reactivex.CompletableObserver u;
        public io.reactivex.disposables.Disposable v;

        public Amb(java.util.concurrent.atomic.AtomicBoolean atomicBoolean, io.reactivex.disposables.CompositeDisposable compositeDisposable, io.reactivex.CompletableObserver completableObserver) {
            this.n = atomicBoolean;
            this.t = compositeDisposable;
            this.u = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.n.compareAndSet(false, true)) {
                this.t.delete(this.v);
                this.t.dispose();
                this.u.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            if (!this.n.compareAndSet(false, true)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.t.delete(this.v);
            this.t.dispose();
            this.u.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.v = disposable;
            this.t.add(disposable);
        }
    }

    public CompletableAmb(io.reactivex.CompletableSource[] completableSourceArr, java.lang.Iterable<? extends io.reactivex.CompletableSource> iterable) {
        this.n = completableSourceArr;
        this.t = iterable;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        int length;
        io.reactivex.CompletableSource[] completableSourceArr = this.n;
        if (completableSourceArr == null) {
            completableSourceArr = new io.reactivex.CompletableSource[8];
            try {
                length = 0;
                for (io.reactivex.CompletableSource completableSource : this.t) {
                    if (completableSource == null) {
                        io.reactivex.internal.disposables.EmptyDisposable.error(new java.lang.NullPointerException("One of the sources is null"), completableObserver);
                        return;
                    }
                    if (length == completableSourceArr.length) {
                        io.reactivex.CompletableSource[] completableSourceArr2 = new io.reactivex.CompletableSource[(length >> 2) + length];
                        java.lang.System.arraycopy(completableSourceArr, 0, completableSourceArr2, 0, length);
                        completableSourceArr = completableSourceArr2;
                    }
                    int i = length + 1;
                    completableSourceArr[length] = completableSource;
                    length = i;
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.disposables.EmptyDisposable.error(th, completableObserver);
                return;
            }
        } else {
            length = completableSourceArr.length;
        }
        io.reactivex.disposables.CompositeDisposable compositeDisposable = new io.reactivex.disposables.CompositeDisposable();
        completableObserver.onSubscribe(compositeDisposable);
        java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean();
        for (int i2 = 0; i2 < length; i2++) {
            io.reactivex.CompletableSource completableSource2 = completableSourceArr[i2];
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (completableSource2 == null) {
                java.lang.Throwable nullPointerException = new java.lang.NullPointerException("One of the sources is null");
                if (!atomicBoolean.compareAndSet(false, true)) {
                    io.reactivex.plugins.RxJavaPlugins.onError(nullPointerException);
                    return;
                } else {
                    compositeDisposable.dispose();
                    completableObserver.onError(nullPointerException);
                    return;
                }
            }
            completableSource2.subscribe(new io.reactivex.internal.operators.completable.CompletableAmb.Amb(atomicBoolean, compositeDisposable, completableObserver));
        }
        if (length == 0) {
            completableObserver.onComplete();
        }
    }
}
