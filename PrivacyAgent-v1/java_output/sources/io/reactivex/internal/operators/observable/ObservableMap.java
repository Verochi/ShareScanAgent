package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableMap<T, U> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, U> {
    public final io.reactivex.functions.Function<? super T, ? extends U> n;

    public static final class MapObserver<T, U> extends io.reactivex.internal.observers.BasicFuseableObserver<T, U> {
        public final io.reactivex.functions.Function<? super T, ? extends U> n;

        public MapObserver(io.reactivex.Observer<? super U> observer, io.reactivex.functions.Function<? super T, ? extends U> function) {
            super(observer);
            this.n = function;
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
                this.downstream.onNext(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(t), "The mapper function returned a null value."));
            } catch (java.lang.Throwable th) {
                fail(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public U poll() throws java.lang.Exception {
            T poll = this.qd.poll();
            if (poll != null) {
                return (U) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.n.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public ObservableMap(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super T, ? extends U> function) {
        super(observableSource);
        this.n = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super U> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableMap.MapObserver(observer, this.n));
    }
}
