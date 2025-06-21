package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleSubscribeOn<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<? extends T> n;
    public final io.reactivex.Scheduler t;

    public static final class SubscribeOnObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable, java.lang.Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final io.reactivex.SingleObserver<? super T> downstream;
        final io.reactivex.SingleSource<? extends T> source;
        final io.reactivex.internal.disposables.SequentialDisposable task = new io.reactivex.internal.disposables.SequentialDisposable();

        public SubscribeOnObserver(io.reactivex.SingleObserver<? super T> singleObserver, io.reactivex.SingleSource<? extends T> singleSource) {
            this.downstream = singleObserver;
            this.source = singleSource;
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

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.subscribe(this);
        }
    }

    public SingleSubscribeOn(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.Scheduler scheduler) {
        this.n = singleSource;
        this.t = scheduler;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        io.reactivex.internal.operators.single.SingleSubscribeOn.SubscribeOnObserver subscribeOnObserver = new io.reactivex.internal.operators.single.SingleSubscribeOn.SubscribeOnObserver(singleObserver, this.n);
        singleObserver.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.task.replace(this.t.scheduleDirect(subscribeOnObserver));
    }
}
