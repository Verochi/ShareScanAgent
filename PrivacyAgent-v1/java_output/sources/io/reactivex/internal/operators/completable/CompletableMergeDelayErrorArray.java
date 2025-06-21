package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableMergeDelayErrorArray extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource[] n;

    public static final class MergeInnerCompletableObserver implements io.reactivex.CompletableObserver {
        public final io.reactivex.CompletableObserver n;
        public final io.reactivex.disposables.CompositeDisposable t;
        public final io.reactivex.internal.util.AtomicThrowable u;
        public final java.util.concurrent.atomic.AtomicInteger v;

        public MergeInnerCompletableObserver(io.reactivex.CompletableObserver completableObserver, io.reactivex.disposables.CompositeDisposable compositeDisposable, io.reactivex.internal.util.AtomicThrowable atomicThrowable, java.util.concurrent.atomic.AtomicInteger atomicInteger) {
            this.n = completableObserver;
            this.t = compositeDisposable;
            this.u = atomicThrowable;
            this.v = atomicInteger;
        }

        public void a() {
            if (this.v.decrementAndGet() == 0) {
                java.lang.Throwable terminate = this.u.terminate();
                if (terminate == null) {
                    this.n.onComplete();
                } else {
                    this.n.onError(terminate);
                }
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            if (this.u.addThrowable(th)) {
                a();
            } else {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.t.add(disposable);
        }
    }

    public CompletableMergeDelayErrorArray(io.reactivex.CompletableSource[] completableSourceArr) {
        this.n = completableSourceArr;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.disposables.CompositeDisposable compositeDisposable = new io.reactivex.disposables.CompositeDisposable();
        java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(this.n.length + 1);
        io.reactivex.internal.util.AtomicThrowable atomicThrowable = new io.reactivex.internal.util.AtomicThrowable();
        completableObserver.onSubscribe(compositeDisposable);
        for (io.reactivex.CompletableSource completableSource : this.n) {
            if (compositeDisposable.isDisposed()) {
                return;
            }
            if (completableSource == null) {
                atomicThrowable.addThrowable(new java.lang.NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                completableSource.subscribe(new io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray.MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            java.lang.Throwable terminate = atomicThrowable.terminate();
            if (terminate == null) {
                completableObserver.onComplete();
            } else {
                completableObserver.onError(terminate);
            }
        }
    }
}
