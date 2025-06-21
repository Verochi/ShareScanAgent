package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDebounce<T, U> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<U>> n;

    public static final class DebounceObserver<T, U> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<U>> t;
        public io.reactivex.disposables.Disposable u;
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> v = new java.util.concurrent.atomic.AtomicReference<>();
        public volatile long w;
        public boolean x;

        public static final class DebounceInnerObserver<T, U> extends io.reactivex.observers.DisposableObserver<U> {
            public final io.reactivex.internal.operators.observable.ObservableDebounce.DebounceObserver<T, U> t;
            public final long u;
            public final T v;
            public boolean w;
            public final java.util.concurrent.atomic.AtomicBoolean x = new java.util.concurrent.atomic.AtomicBoolean();

            public DebounceInnerObserver(io.reactivex.internal.operators.observable.ObservableDebounce.DebounceObserver<T, U> debounceObserver, long j, T t) {
                this.t = debounceObserver;
                this.u = j;
                this.v = t;
            }

            public void a() {
                if (this.x.compareAndSet(false, true)) {
                    this.t.a(this.u, this.v);
                }
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                if (this.w) {
                    return;
                }
                this.w = true;
                a();
            }

            @Override // io.reactivex.Observer
            public void onError(java.lang.Throwable th) {
                if (this.w) {
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                } else {
                    this.w = true;
                    this.t.onError(th);
                }
            }

            @Override // io.reactivex.Observer
            public void onNext(U u) {
                if (this.w) {
                    return;
                }
                this.w = true;
                dispose();
                a();
            }
        }

        public DebounceObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<U>> function) {
            this.n = observer;
            this.t = function;
        }

        public void a(long j, T t) {
            if (j == this.w) {
                this.n.onNext(t);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.dispose();
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.v);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.x) {
                return;
            }
            this.x = true;
            io.reactivex.disposables.Disposable disposable = this.v.get();
            if (disposable != io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                io.reactivex.internal.operators.observable.ObservableDebounce.DebounceObserver.DebounceInnerObserver debounceInnerObserver = (io.reactivex.internal.operators.observable.ObservableDebounce.DebounceObserver.DebounceInnerObserver) disposable;
                if (debounceInnerObserver != null) {
                    debounceInnerObserver.a();
                }
                io.reactivex.internal.disposables.DisposableHelper.dispose(this.v);
                this.n.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.v);
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.x) {
                return;
            }
            long j = this.w + 1;
            this.w = j;
            io.reactivex.disposables.Disposable disposable = this.v.get();
            if (disposable != null) {
                disposable.dispose();
            }
            try {
                io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The ObservableSource supplied is null");
                io.reactivex.internal.operators.observable.ObservableDebounce.DebounceObserver.DebounceInnerObserver debounceInnerObserver = new io.reactivex.internal.operators.observable.ObservableDebounce.DebounceObserver.DebounceInnerObserver(this, j, t);
                if (defpackage.xv0.a(this.v, disposable, debounceInnerObserver)) {
                    observableSource.subscribe(debounceInnerObserver);
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                dispose();
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableDebounce(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.ObservableSource<U>> function) {
        super(observableSource);
        this.n = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableDebounce.DebounceObserver(new io.reactivex.observers.SerializedObserver(observer), this.n));
    }
}
