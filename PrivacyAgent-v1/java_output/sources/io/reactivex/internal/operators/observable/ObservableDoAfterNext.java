package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDoAfterNext<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.Consumer<? super T> n;

    public static final class DoAfterObserver<T> extends io.reactivex.internal.observers.BasicFuseableObserver<T, T> {
        public final io.reactivex.functions.Consumer<? super T> n;

        public DoAfterObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.Consumer<? super T> consumer) {
            super(observer);
            this.n = consumer;
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.downstream.onNext(t);
            if (this.sourceMode == 0) {
                try {
                    this.n.accept(t);
                } catch (java.lang.Throwable th) {
                    fail(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() throws java.lang.Exception {
            T poll = this.qd.poll();
            if (poll != null) {
                this.n.accept(poll);
            }
            return poll;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return transitiveBoundaryFusion(i);
        }
    }

    public ObservableDoAfterNext(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Consumer<? super T> consumer) {
        super(observableSource);
        this.n = consumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableDoAfterNext.DoAfterObserver(observer, this.n));
    }
}
