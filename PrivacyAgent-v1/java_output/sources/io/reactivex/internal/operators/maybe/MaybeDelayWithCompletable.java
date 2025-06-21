package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeDelayWithCompletable<T> extends io.reactivex.Maybe<T> {
    public final io.reactivex.MaybeSource<T> n;
    public final io.reactivex.CompletableSource t;

    public static final class DelayWithMainObserver<T> implements io.reactivex.MaybeObserver<T> {
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> n;
        public final io.reactivex.MaybeObserver<? super T> t;

        public DelayWithMainObserver(java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference, io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.n = atomicReference;
            this.t = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.t.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.t.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.replace(this.n, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.t.onSuccess(t);
        }
    }

    public static final class OtherObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 703409937383992161L;
        final io.reactivex.MaybeObserver<? super T> downstream;
        final io.reactivex.MaybeSource<T> source;

        public OtherObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.MaybeSource<T> maybeSource) {
            this.downstream = maybeObserver;
            this.source = maybeSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable.DelayWithMainObserver(this, this.downstream));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }
    }

    public MaybeDelayWithCompletable(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.CompletableSource completableSource) {
        this.n = maybeSource;
        this.t = completableSource;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.t.subscribe(new io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable.OtherObserver(maybeObserver, this.n));
    }
}
