package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDelay<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<? extends T> n;
    public final long t;
    public final java.util.concurrent.TimeUnit u;
    public final io.reactivex.Scheduler v;
    public final boolean w;

    public final class Delay implements io.reactivex.SingleObserver<T> {
        public final io.reactivex.internal.disposables.SequentialDisposable n;
        public final io.reactivex.SingleObserver<? super T> t;

        public final class OnError implements java.lang.Runnable {
            public final java.lang.Throwable n;

            public OnError(java.lang.Throwable th) {
                this.n = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.reactivex.internal.operators.single.SingleDelay.Delay.this.t.onError(this.n);
            }
        }

        public final class OnSuccess implements java.lang.Runnable {
            public final T n;

            public OnSuccess(T t) {
                this.n = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                io.reactivex.internal.operators.single.SingleDelay.Delay.this.t.onSuccess(this.n);
            }
        }

        public Delay(io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable, io.reactivex.SingleObserver<? super T> singleObserver) {
            this.n = sequentialDisposable;
            this.t = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = this.n;
            io.reactivex.Scheduler scheduler = io.reactivex.internal.operators.single.SingleDelay.this.v;
            io.reactivex.internal.operators.single.SingleDelay.Delay.OnError onError = new io.reactivex.internal.operators.single.SingleDelay.Delay.OnError(th);
            io.reactivex.internal.operators.single.SingleDelay singleDelay = io.reactivex.internal.operators.single.SingleDelay.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(onError, singleDelay.w ? singleDelay.t : 0L, singleDelay.u));
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.replace(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = this.n;
            io.reactivex.Scheduler scheduler = io.reactivex.internal.operators.single.SingleDelay.this.v;
            io.reactivex.internal.operators.single.SingleDelay.Delay.OnSuccess onSuccess = new io.reactivex.internal.operators.single.SingleDelay.Delay.OnSuccess(t);
            io.reactivex.internal.operators.single.SingleDelay singleDelay = io.reactivex.internal.operators.single.SingleDelay.this;
            sequentialDisposable.replace(scheduler.scheduleDirect(onSuccess, singleDelay.t, singleDelay.u));
        }
    }

    public SingleDelay(io.reactivex.SingleSource<? extends T> singleSource, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler, boolean z) {
        this.n = singleSource;
        this.t = j;
        this.u = timeUnit;
        this.v = scheduler;
        this.w = z;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = new io.reactivex.internal.disposables.SequentialDisposable();
        singleObserver.onSubscribe(sequentialDisposable);
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleDelay.Delay(sequentialDisposable, singleObserver));
    }
}
