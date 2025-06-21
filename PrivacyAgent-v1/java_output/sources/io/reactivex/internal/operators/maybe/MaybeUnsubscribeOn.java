package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeUnsubscribeOn<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public final io.reactivex.Scheduler n;

    public static final class UnsubscribeOnMaybeObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final io.reactivex.MaybeObserver<? super T> downstream;
        io.reactivex.disposables.Disposable ds;
        final io.reactivex.Scheduler scheduler;

        public UnsubscribeOnMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.Scheduler scheduler) {
            this.downstream = maybeObserver;
            this.scheduler = scheduler;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            io.reactivex.disposables.Disposable andSet = getAndSet(disposableHelper);
            if (andSet != disposableHelper) {
                this.ds = andSet;
                this.scheduler.scheduleDirect(this);
            }
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
            if (io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
        }
    }

    public MaybeUnsubscribeOn(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.Scheduler scheduler) {
        super(maybeSource);
        this.n = scheduler;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn.UnsubscribeOnMaybeObserver(maybeObserver, this.n));
    }
}
