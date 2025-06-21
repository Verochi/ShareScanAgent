package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableTimeInterval<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, io.reactivex.schedulers.Timed<T>> {
    public final io.reactivex.Scheduler n;
    public final java.util.concurrent.TimeUnit t;

    public static final class TimeIntervalObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super io.reactivex.schedulers.Timed<T>> n;
        public final java.util.concurrent.TimeUnit t;
        public final io.reactivex.Scheduler u;
        public long v;
        public io.reactivex.disposables.Disposable w;

        public TimeIntervalObserver(io.reactivex.Observer<? super io.reactivex.schedulers.Timed<T>> observer, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
            this.n = observer;
            this.u = scheduler;
            this.t = timeUnit;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            long now = this.u.now(this.t);
            long j = this.v;
            this.v = now;
            this.n.onNext(new io.reactivex.schedulers.Timed(t, now - j, this.t));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.w, disposable)) {
                this.w = disposable;
                this.v = this.u.now(this.t);
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableTimeInterval(io.reactivex.ObservableSource<T> observableSource, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        super(observableSource);
        this.n = scheduler;
        this.t = timeUnit;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super io.reactivex.schedulers.Timed<T>> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableTimeInterval.TimeIntervalObserver(observer, this.t, this.n));
    }
}
