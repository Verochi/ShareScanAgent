package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableSubscribeOn<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.Scheduler n;

    public static final class SubscribeOnObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 8094547886072529208L;
        final io.reactivex.Observer<? super T> downstream;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> upstream = new java.util.concurrent.atomic.AtomicReference<>();

        public SubscribeOnObserver(io.reactivex.Observer<? super T> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void setDisposable(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
        }
    }

    public final class SubscribeTask implements java.lang.Runnable {
        public final io.reactivex.internal.operators.observable.ObservableSubscribeOn.SubscribeOnObserver<T> n;

        public SubscribeTask(io.reactivex.internal.operators.observable.ObservableSubscribeOn.SubscribeOnObserver<T> subscribeOnObserver) {
            this.n = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.internal.operators.observable.ObservableSubscribeOn.this.source.subscribe(this.n);
        }
    }

    public ObservableSubscribeOn(io.reactivex.ObservableSource<T> observableSource, io.reactivex.Scheduler scheduler) {
        super(observableSource);
        this.n = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservableSubscribeOn.SubscribeOnObserver subscribeOnObserver = new io.reactivex.internal.operators.observable.ObservableSubscribeOn.SubscribeOnObserver(observer);
        observer.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.n.scheduleDirect(new io.reactivex.internal.operators.observable.ObservableSubscribeOn.SubscribeTask(subscribeOnObserver)));
    }
}
