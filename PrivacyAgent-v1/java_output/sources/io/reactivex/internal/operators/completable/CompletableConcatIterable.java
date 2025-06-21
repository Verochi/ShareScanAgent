package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableConcatIterable extends io.reactivex.Completable {
    public final java.lang.Iterable<? extends io.reactivex.CompletableSource> n;

    public static final class ConcatInnerObserver extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;
        final io.reactivex.CompletableObserver downstream;
        final io.reactivex.internal.disposables.SequentialDisposable sd = new io.reactivex.internal.disposables.SequentialDisposable();
        final java.util.Iterator<? extends io.reactivex.CompletableSource> sources;

        public ConcatInnerObserver(io.reactivex.CompletableObserver completableObserver, java.util.Iterator<? extends io.reactivex.CompletableSource> it) {
            this.downstream = completableObserver;
            this.sources = it;
        }

        public void next() {
            if (!this.sd.isDisposed() && getAndIncrement() == 0) {
                java.util.Iterator<? extends io.reactivex.CompletableSource> it = this.sources;
                while (!this.sd.isDisposed()) {
                    try {
                        if (!it.hasNext()) {
                            this.downstream.onComplete();
                            return;
                        }
                        try {
                            ((io.reactivex.CompletableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(it.next(), "The CompletableSource returned is null")).subscribe(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (java.lang.Throwable th) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            this.downstream.onError(th);
                            return;
                        }
                    } catch (java.lang.Throwable th2) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                        this.downstream.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            next();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.sd.replace(disposable);
        }
    }

    public CompletableConcatIterable(java.lang.Iterable<? extends io.reactivex.CompletableSource> iterable) {
        this.n = iterable;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        try {
            io.reactivex.internal.operators.completable.CompletableConcatIterable.ConcatInnerObserver concatInnerObserver = new io.reactivex.internal.operators.completable.CompletableConcatIterable.ConcatInnerObserver(completableObserver, (java.util.Iterator) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.iterator(), "The iterator returned is null"));
            completableObserver.onSubscribe(concatInnerObserver.sd);
            concatInnerObserver.next();
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, completableObserver);
        }
    }
}
