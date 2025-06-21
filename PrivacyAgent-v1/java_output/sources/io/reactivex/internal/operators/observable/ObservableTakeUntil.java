package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableTakeUntil<T, U> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.ObservableSource<? extends U> n;

    public static final class TakeUntilMainObserver<T, U> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 1418547743690811973L;
        final io.reactivex.Observer<? super T> downstream;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> upstream = new java.util.concurrent.atomic.AtomicReference<>();
        final io.reactivex.internal.operators.observable.ObservableTakeUntil.TakeUntilMainObserver<T, U>.OtherObserver otherObserver = new io.reactivex.internal.operators.observable.ObservableTakeUntil.TakeUntilMainObserver.OtherObserver();
        final io.reactivex.internal.util.AtomicThrowable error = new io.reactivex.internal.util.AtomicThrowable();

        public final class OtherObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            public OtherObserver() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                io.reactivex.internal.operators.observable.ObservableTakeUntil.TakeUntilMainObserver.this.otherComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(java.lang.Throwable th) {
                io.reactivex.internal.operators.observable.ObservableTakeUntil.TakeUntilMainObserver.this.otherError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(U u) {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this);
                io.reactivex.internal.operators.observable.ObservableTakeUntil.TakeUntilMainObserver.this.otherComplete();
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
            }
        }

        public TakeUntilMainObserver(io.reactivex.Observer<? super T> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            io.reactivex.internal.util.HalfSerializer.onNext(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void otherComplete() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        public void otherError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }
    }

    public ObservableTakeUntil(io.reactivex.ObservableSource<T> observableSource, io.reactivex.ObservableSource<? extends U> observableSource2) {
        super(observableSource);
        this.n = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservableTakeUntil.TakeUntilMainObserver takeUntilMainObserver = new io.reactivex.internal.operators.observable.ObservableTakeUntil.TakeUntilMainObserver(observer);
        observer.onSubscribe(takeUntilMainObserver);
        this.n.subscribe(takeUntilMainObserver.otherObserver);
        this.source.subscribe(takeUntilMainObserver);
    }
}
