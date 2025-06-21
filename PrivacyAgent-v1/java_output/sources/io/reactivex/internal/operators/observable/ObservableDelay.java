package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDelay<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final long n;
    public final java.util.concurrent.TimeUnit t;
    public final io.reactivex.Scheduler u;
    public final boolean v;

    public static final class DelayObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public final long t;
        public final java.util.concurrent.TimeUnit u;
        public final io.reactivex.Scheduler.Worker v;
        public final boolean w;
        public io.reactivex.disposables.Disposable x;

        public final class OnComplete implements java.lang.Runnable {
            public OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.this.n.onComplete();
                } finally {
                    io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.this.v.dispose();
                }
            }
        }

        public final class OnError implements java.lang.Runnable {
            public final java.lang.Throwable n;

            public OnError(java.lang.Throwable th) {
                this.n = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.this.n.onError(this.n);
                } finally {
                    io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.this.v.dispose();
                }
            }
        }

        public final class OnNext implements java.lang.Runnable {
            public final T n;

            public OnNext(T t) {
                this.n = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.this.n.onNext(this.n);
            }
        }

        public DelayObserver(io.reactivex.Observer<? super T> observer, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler.Worker worker, boolean z) {
            this.n = observer;
            this.t = j;
            this.u = timeUnit;
            this.v = worker;
            this.w = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.x.dispose();
            this.v.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.v.schedule(new io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.OnComplete(), this.t, this.u);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.v.schedule(new io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.OnError(th), this.w ? this.t : 0L, this.u);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.v.schedule(new io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver.OnNext(t), this.t, this.u);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.x, disposable)) {
                this.x = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(io.reactivex.ObservableSource<T> observableSource, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        super(observableSource);
        this.n = j;
        this.t = timeUnit;
        this.u = scheduler;
        this.v = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableDelay.DelayObserver(this.v ? observer : new io.reactivex.observers.SerializedObserver(observer), this.n, this.t, this.u.createWorker(), this.v));
    }
}
