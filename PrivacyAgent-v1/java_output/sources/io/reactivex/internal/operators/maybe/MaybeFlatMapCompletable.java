package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeFlatMapCompletable<T> extends io.reactivex.Completable {
    public final io.reactivex.MaybeSource<T> n;
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> t;

    public static final class FlatMapCompletableObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<T>, io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -2177128922851101253L;
        final io.reactivex.CompletableObserver downstream;
        final io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> mapper;

        public FlatMapCompletableObserver(io.reactivex.CompletableObserver completableObserver, io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
            this.downstream = completableObserver;
            this.mapper = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            try {
                io.reactivex.CompletableSource completableSource = (io.reactivex.CompletableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                if (isDisposed()) {
                    return;
                }
                completableSource.subscribe(this);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                onError(th);
            }
        }
    }

    public MaybeFlatMapCompletable(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function) {
        this.n = maybeSource;
        this.t = function;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable.FlatMapCompletableObserver flatMapCompletableObserver = new io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable.FlatMapCompletableObserver(completableObserver, this.t);
        completableObserver.onSubscribe(flatMapCompletableObserver);
        this.n.subscribe(flatMapCompletableObserver);
    }
}
