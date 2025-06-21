package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservablePublishSelector<T, R> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, R> {
    public final io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> n;

    public static final class SourceObserver<T, R> implements io.reactivex.Observer<T> {
        public final io.reactivex.subjects.PublishSubject<T> n;
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> t;

        public SourceObserver(io.reactivex.subjects.PublishSubject<T> publishSubject, java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference) {
            this.n = publishSubject;
            this.t = atomicReference;
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
            this.n.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.t, disposable);
        }
    }

    public static final class TargetObserver<T, R> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<R>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 854110278590336484L;
        final io.reactivex.Observer<? super R> downstream;
        io.reactivex.disposables.Disposable upstream;

        public TargetObserver(io.reactivex.Observer<? super R> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservablePublishSelector(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super io.reactivex.Observable<T>, ? extends io.reactivex.ObservableSource<R>> function) {
        super(observableSource);
        this.n = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        io.reactivex.subjects.PublishSubject create = io.reactivex.subjects.PublishSubject.create();
        try {
            io.reactivex.ObservableSource observableSource = (io.reactivex.ObservableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(create), "The selector returned a null ObservableSource");
            io.reactivex.internal.operators.observable.ObservablePublishSelector.TargetObserver targetObserver = new io.reactivex.internal.operators.observable.ObservablePublishSelector.TargetObserver(observer);
            observableSource.subscribe(targetObserver);
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservablePublishSelector.SourceObserver(create, targetObserver));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
        }
    }
}
