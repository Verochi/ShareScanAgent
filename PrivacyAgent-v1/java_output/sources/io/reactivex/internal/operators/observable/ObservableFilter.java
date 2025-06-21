package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableFilter<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.Predicate<? super T> n;

    public static final class FilterObserver<T> extends io.reactivex.internal.observers.BasicFuseableObserver<T, T> {
        public final io.reactivex.functions.Predicate<? super T> n;

        public FilterObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.Predicate<? super T> predicate) {
            super(observer);
            this.n = predicate;
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.sourceMode != 0) {
                this.downstream.onNext(null);
                return;
            }
            try {
                if (this.n.test(t)) {
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
            } while (!this.n.test(poll));
            return poll;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public ObservableFilter(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Predicate<? super T> predicate) {
        super(observableSource);
        this.n = predicate;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableFilter.FilterObserver(observer, this.n));
    }
}
