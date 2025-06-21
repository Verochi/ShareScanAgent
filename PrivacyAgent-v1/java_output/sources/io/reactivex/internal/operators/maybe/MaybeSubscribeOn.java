package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeSubscribeOn<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public final io.reactivex.Scheduler n;

    public static final class SubscribeOnMaybeObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 8571289934935992137L;
        final io.reactivex.MaybeObserver<? super T> downstream;
        final io.reactivex.internal.disposables.SequentialDisposable task = new io.reactivex.internal.disposables.SequentialDisposable();

        public SubscribeOnMaybeObserver(io.reactivex.MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            this.task.dispose();
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
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public static final class SubscribeTask<T> implements java.lang.Runnable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final io.reactivex.MaybeSource<T> t;

        public SubscribeTask(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.MaybeSource<T> maybeSource) {
            this.n = maybeObserver;
            this.t = maybeSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.t.subscribe(this.n);
        }
    }

    public MaybeSubscribeOn(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.Scheduler scheduler) {
        super(maybeSource);
        this.n = scheduler;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        io.reactivex.internal.operators.maybe.MaybeSubscribeOn.SubscribeOnMaybeObserver subscribeOnMaybeObserver = new io.reactivex.internal.operators.maybe.MaybeSubscribeOn.SubscribeOnMaybeObserver(maybeObserver);
        maybeObserver.onSubscribe(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.task.replace(this.n.scheduleDirect(new io.reactivex.internal.operators.maybe.MaybeSubscribeOn.SubscribeTask(subscribeOnMaybeObserver, this.source)));
    }
}
