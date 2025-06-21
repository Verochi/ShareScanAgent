package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableDoOnEvent extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;
    public final io.reactivex.functions.Consumer<? super java.lang.Throwable> t;

    public final class DoOnEvent implements io.reactivex.CompletableObserver {
        public final io.reactivex.CompletableObserver n;

        public DoOnEvent(io.reactivex.CompletableObserver completableObserver) {
            this.n = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            try {
                io.reactivex.internal.operators.completable.CompletableDoOnEvent.this.t.accept(null);
                this.n.onComplete();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            try {
                io.reactivex.internal.operators.completable.CompletableDoOnEvent.this.t.accept(th);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                th = new io.reactivex.exceptions.CompositeException(th, th2);
            }
            this.n.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.onSubscribe(disposable);
        }
    }

    public CompletableDoOnEvent(io.reactivex.CompletableSource completableSource, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer) {
        this.n = completableSource;
        this.t = consumer;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableDoOnEvent.DoOnEvent(completableObserver));
    }
}
