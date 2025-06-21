package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDebounceTimed<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final long n;
    public final java.util.concurrent.TimeUnit t;
    public final io.reactivex.Scheduler u;

    public static final class DebounceEmitter<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements java.lang.Runnable, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final java.util.concurrent.atomic.AtomicBoolean once = new java.util.concurrent.atomic.AtomicBoolean();
        final io.reactivex.internal.operators.observable.ObservableDebounceTimed.DebounceTimedObserver<T> parent;
        final T value;

        public DebounceEmitter(T t, long j, io.reactivex.internal.operators.observable.ObservableDebounceTimed.DebounceTimedObserver<T> debounceTimedObserver) {
            this.value = t;
            this.idx = j;
            this.parent = debounceTimedObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }

        public void setResource(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
        }
    }

    public static final class DebounceTimedObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public final long t;
        public final java.util.concurrent.TimeUnit u;
        public final io.reactivex.Scheduler.Worker v;
        public io.reactivex.disposables.Disposable w;
        public io.reactivex.disposables.Disposable x;
        public volatile long y;
        public boolean z;

        public DebounceTimedObserver(io.reactivex.Observer<? super T> observer, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler.Worker worker) {
            this.n = observer;
            this.t = j;
            this.u = timeUnit;
            this.v = worker;
        }

        public void a(long j, T t, io.reactivex.internal.operators.observable.ObservableDebounceTimed.DebounceEmitter<T> debounceEmitter) {
            if (j == this.y) {
                this.n.onNext(t);
                debounceEmitter.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.w.dispose();
            this.v.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.z) {
                return;
            }
            this.z = true;
            io.reactivex.disposables.Disposable disposable = this.x;
            if (disposable != null) {
                disposable.dispose();
            }
            io.reactivex.internal.operators.observable.ObservableDebounceTimed.DebounceEmitter debounceEmitter = (io.reactivex.internal.operators.observable.ObservableDebounceTimed.DebounceEmitter) disposable;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.n.onComplete();
            this.v.dispose();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.z) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            io.reactivex.disposables.Disposable disposable = this.x;
            if (disposable != null) {
                disposable.dispose();
            }
            this.z = true;
            this.n.onError(th);
            this.v.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.z) {
                return;
            }
            long j = this.y + 1;
            this.y = j;
            io.reactivex.disposables.Disposable disposable = this.x;
            if (disposable != null) {
                disposable.dispose();
            }
            io.reactivex.internal.operators.observable.ObservableDebounceTimed.DebounceEmitter debounceEmitter = new io.reactivex.internal.operators.observable.ObservableDebounceTimed.DebounceEmitter(t, j, this);
            this.x = debounceEmitter;
            debounceEmitter.setResource(this.v.schedule(debounceEmitter, this.t, this.u));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.w, disposable)) {
                this.w = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(io.reactivex.ObservableSource<T> observableSource, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        super(observableSource);
        this.n = j;
        this.t = timeUnit;
        this.u = scheduler;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableDebounceTimed.DebounceTimedObserver(new io.reactivex.observers.SerializedObserver(observer), this.n, this.t, this.u.createWorker()));
    }
}
