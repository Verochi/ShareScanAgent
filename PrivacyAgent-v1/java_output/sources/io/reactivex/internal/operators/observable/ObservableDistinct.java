package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDistinct<T, K> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super T, K> n;
    public final java.util.concurrent.Callable<? extends java.util.Collection<? super K>> t;

    public static final class DistinctObserver<T, K> extends io.reactivex.internal.observers.BasicFuseableObserver<T, T> {
        public final java.util.Collection<? super K> n;
        public final io.reactivex.functions.Function<? super T, K> t;

        public DistinctObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.Function<? super T, K> function, java.util.Collection<? super K> collection) {
            super(observer);
            this.t = function;
            this.n = collection;
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.n.clear();
            super.clear();
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.n.clear();
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.done) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.n.clear();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(null);
                return;
            }
            try {
                if (this.n.add(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The keySelector returned a null key"))) {
                    this.downstream.onNext(t);
                }
            } catch (java.lang.Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            T poll;
            do {
                poll = this.qd.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.n.add((java.lang.Object) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(poll), "The keySelector returned a null key")));
            return poll;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public ObservableDistinct(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super T, K> function, java.util.concurrent.Callable<? extends java.util.Collection<? super K>> callable) {
        super(observableSource);
        this.n = function;
        this.t = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        try {
            this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableDistinct.DistinctObserver(observer, this.n, (java.util.Collection) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
        }
    }
}
