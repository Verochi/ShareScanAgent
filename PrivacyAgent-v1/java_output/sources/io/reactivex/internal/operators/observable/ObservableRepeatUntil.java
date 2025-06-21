package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableRepeatUntil<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.BooleanSupplier n;

    public static final class RepeatUntilObserver<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final io.reactivex.Observer<? super T> downstream;
        final io.reactivex.ObservableSource<? extends T> source;
        final io.reactivex.functions.BooleanSupplier stop;
        final io.reactivex.internal.disposables.SequentialDisposable upstream;

        public RepeatUntilObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.BooleanSupplier booleanSupplier, io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable, io.reactivex.ObservableSource<? extends T> observableSource) {
            this.downstream = observer;
            this.upstream = sequentialDisposable;
            this.source = observableSource;
            this.stop = booleanSupplier;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.downstream.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }
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
            this.upstream.replace(disposable);
        }

        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                do {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }
    }

    public ObservableRepeatUntil(io.reactivex.Observable<T> observable, io.reactivex.functions.BooleanSupplier booleanSupplier) {
        super(observable);
        this.n = booleanSupplier;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = new io.reactivex.internal.disposables.SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new io.reactivex.internal.operators.observable.ObservableRepeatUntil.RepeatUntilObserver(observer, this.n, sequentialDisposable, this.source).subscribeNext();
    }
}
