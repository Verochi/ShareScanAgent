package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableOnErrorComplete extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;
    public final io.reactivex.functions.Predicate<? super java.lang.Throwable> t;

    public final class OnError implements io.reactivex.CompletableObserver {
        public final io.reactivex.CompletableObserver n;

        public OnError(io.reactivex.CompletableObserver completableObserver) {
            this.n = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            try {
                if (io.reactivex.internal.operators.completable.CompletableOnErrorComplete.this.t.test(th)) {
                    this.n.onComplete();
                } else {
                    this.n.onError(th);
                }
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                this.n.onError(new io.reactivex.exceptions.CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.onSubscribe(disposable);
        }
    }

    public CompletableOnErrorComplete(io.reactivex.CompletableSource completableSource, io.reactivex.functions.Predicate<? super java.lang.Throwable> predicate) {
        this.n = completableSource;
        this.t = predicate;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableOnErrorComplete.OnError(completableObserver));
    }
}
