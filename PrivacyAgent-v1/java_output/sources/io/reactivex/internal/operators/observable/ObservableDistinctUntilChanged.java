package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDistinctUntilChanged<T, K> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.Function<? super T, K> n;
    public final io.reactivex.functions.BiPredicate<? super K, ? super K> t;

    public static final class DistinctUntilChangedObserver<T, K> extends io.reactivex.internal.observers.BasicFuseableObserver<T, T> {
        public final io.reactivex.functions.Function<? super T, K> n;
        public final io.reactivex.functions.BiPredicate<? super K, ? super K> t;
        public K u;
        public boolean v;

        public DistinctUntilChangedObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.Function<? super T, K> function, io.reactivex.functions.BiPredicate<? super K, ? super K> biPredicate) {
            super(observer);
            this.n = function;
            this.t = biPredicate;
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 0) {
                this.downstream.onNext(t);
                return;
            }
            try {
                K apply = this.n.apply(t);
                if (this.v) {
                    boolean test = this.t.test(this.u, apply);
                    this.u = apply;
                    if (test) {
                        return;
                    }
                } else {
                    this.v = true;
                    this.u = apply;
                }
                this.downstream.onNext(t);
            } catch (java.lang.Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            while (true) {
                T poll = this.qd.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.n.apply(poll);
                if (!this.v) {
                    this.v = true;
                    this.u = apply;
                    return poll;
                }
                if (!this.t.test(this.u, apply)) {
                    this.u = apply;
                    return poll;
                }
                this.u = apply;
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public ObservableDistinctUntilChanged(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super T, K> function, io.reactivex.functions.BiPredicate<? super K, ? super K> biPredicate) {
        super(observableSource);
        this.n = function;
        this.t = biPredicate;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged.DistinctUntilChangedObserver(observer, this.n, this.t));
    }
}
