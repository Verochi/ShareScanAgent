package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableRetryWhen<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super io.reactivex.Observable<java.lang.Throwable>, ? extends io.reactivex.ObservableSource<?>> n;

    public static final class RepeatWhenObserver<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final io.reactivex.Observer<? super T> downstream;
        final io.reactivex.subjects.Subject<java.lang.Throwable> signaller;
        final io.reactivex.ObservableSource<T> source;
        final java.util.concurrent.atomic.AtomicInteger wip = new java.util.concurrent.atomic.AtomicInteger();
        final io.reactivex.internal.util.AtomicThrowable error = new io.reactivex.internal.util.AtomicThrowable();
        final io.reactivex.internal.operators.observable.ObservableRetryWhen.RepeatWhenObserver<T>.InnerRepeatObserver inner = new io.reactivex.internal.operators.observable.ObservableRetryWhen.RepeatWhenObserver.InnerRepeatObserver();
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> upstream = new java.util.concurrent.atomic.AtomicReference<>();

        public final class InnerRepeatObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<java.lang.Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            public InnerRepeatObserver() {
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                io.reactivex.internal.operators.observable.ObservableRetryWhen.RepeatWhenObserver.this.innerComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(java.lang.Throwable th) {
                io.reactivex.internal.operators.observable.ObservableRetryWhen.RepeatWhenObserver.this.innerError(th);
            }

            @Override // io.reactivex.Observer
            public void onNext(java.lang.Object obj) {
                io.reactivex.internal.operators.observable.ObservableRetryWhen.RepeatWhenObserver.this.innerNext();
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
            }
        }

        public RepeatWhenObserver(io.reactivex.Observer<? super T> observer, io.reactivex.subjects.Subject<java.lang.Throwable> subject, io.reactivex.ObservableSource<T> observableSource) {
            this.downstream = observer;
            this.signaller = subject;
            this.source = observableSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.inner);
        }

        public void innerComplete() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        public void innerError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        public void innerNext() {
            subscribeNext();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.inner);
            io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            io.reactivex.internal.util.HalfSerializer.onNext(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.replace(this.upstream, disposable);
        }

        public void subscribeNext() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRetryWhen(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super io.reactivex.Observable<java.lang.Throwable>, ? extends io.reactivex.ObservableSource<?>> function) {
        super(observableSource);
        this.n = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.subjects.Subject<T> serialized = io.reactivex.subjects.PublishSubject.create().toSerialized();
        try {
            io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(serialized), "The handler returned a null ObservableSource");
            io.reactivex.internal.operators.observable.ObservableRetryWhen.RepeatWhenObserver repeatWhenObserver = new io.reactivex.internal.operators.observable.ObservableRetryWhen.RepeatWhenObserver(observer, serialized, this.source);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.inner);
            repeatWhenObserver.subscribeNext();
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
        }
    }
}
