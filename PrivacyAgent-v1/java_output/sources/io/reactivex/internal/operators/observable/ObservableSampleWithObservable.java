package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableSampleWithObservable<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.ObservableSource<?> n;
    public final boolean t;

    public static final class SampleMainEmitLast<T> extends io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final java.util.concurrent.atomic.AtomicInteger wip;

        public SampleMainEmitLast(io.reactivex.Observer<? super T> observer, io.reactivex.ObservableSource<?> observableSource) {
            super(observer, observableSource);
            this.wip = new java.util.concurrent.atomic.AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void completion() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                emit();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void run() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z = this.done;
                    emit();
                    if (z) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(io.reactivex.Observer<? super T> observer, io.reactivex.ObservableSource<?> observableSource) {
            super(observer, observableSource);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void completion() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void run() {
            emit();
        }
    }

    public static abstract class SampleMainObserver<T> extends java.util.concurrent.atomic.AtomicReference<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -3517602651313910099L;
        final io.reactivex.Observer<? super T> downstream;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> other = new java.util.concurrent.atomic.AtomicReference<>();
        final io.reactivex.ObservableSource<?> sampler;
        io.reactivex.disposables.Disposable upstream;

        public SampleMainObserver(io.reactivex.Observer<? super T> observer, io.reactivex.ObservableSource<?> observableSource) {
            this.downstream = observer;
            this.sampler = observableSource;
        }

        public void complete() {
            this.upstream.dispose();
            completion();
        }

        public abstract void completion();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        public void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        public void error(java.lang.Throwable th) {
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.other.get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.other);
            completion();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.other);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
                if (this.other.get() == null) {
                    this.sampler.subscribe(new io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SamplerObserver(this));
                }
            }
        }

        public abstract void run();

        public boolean setOther(io.reactivex.disposables.Disposable disposable) {
            return io.reactivex.internal.disposables.DisposableHelper.setOnce(this.other, disposable);
        }
    }

    public static final class SamplerObserver<T> implements io.reactivex.Observer<java.lang.Object> {
        public final io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver<T> n;

        public SamplerObserver(io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver<T> sampleMainObserver) {
            this.n = sampleMainObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.n.complete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.n.error(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(java.lang.Object obj) {
            this.n.run();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.n.setOther(disposable);
        }
    }

    public ObservableSampleWithObservable(io.reactivex.ObservableSource<T> observableSource, io.reactivex.ObservableSource<?> observableSource2, boolean z) {
        super(observableSource);
        this.n = observableSource2;
        this.t = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.observers.SerializedObserver serializedObserver = new io.reactivex.observers.SerializedObserver(observer);
        if (this.t) {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainEmitLast(serializedObserver, this.n));
        } else {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainNoLast(serializedObserver, this.n));
        }
    }
}
