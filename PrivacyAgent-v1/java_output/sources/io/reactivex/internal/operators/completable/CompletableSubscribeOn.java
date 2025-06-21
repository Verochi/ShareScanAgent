package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableSubscribeOn extends io.reactivex.Completable {
    public final io.reactivex.CompletableSource n;
    public final io.reactivex.Scheduler t;

    public static final class SubscribeOnObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver, io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final io.reactivex.CompletableObserver downstream;
        final io.reactivex.CompletableSource source;
        final io.reactivex.internal.disposables.SequentialDisposable task = new io.reactivex.internal.disposables.SequentialDisposable();

        public SubscribeOnObserver(io.reactivex.CompletableObserver completableObserver, io.reactivex.CompletableSource completableSource) {
            this.downstream = completableObserver;
            this.source = completableSource;
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

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.subscribe(this);
        }
    }

    public CompletableSubscribeOn(io.reactivex.CompletableSource completableSource, io.reactivex.Scheduler scheduler) {
        this.n = completableSource;
        this.t = scheduler;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        io.reactivex.internal.operators.completable.CompletableSubscribeOn.SubscribeOnObserver subscribeOnObserver = new io.reactivex.internal.operators.completable.CompletableSubscribeOn.SubscribeOnObserver(completableObserver, this.n);
        completableObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.replace(this.t.scheduleDirect(subscribeOnObserver));
    }
}
