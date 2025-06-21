package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class BlockingObservableMostRecent<T> implements java.lang.Iterable<T> {
    public final io.reactivex.ObservableSource<T> n;
    public final T t;

    public static final class MostRecentObserver<T> extends io.reactivex.observers.DefaultObserver<T> {
        public volatile java.lang.Object t;

        public final class Iterator implements java.util.Iterator<T> {
            public java.lang.Object n;

            public Iterator() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.n = io.reactivex.internal.operators.observable.BlockingObservableMostRecent.MostRecentObserver.this.t;
                return !io.reactivex.internal.util.NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.n == null) {
                        this.n = io.reactivex.internal.operators.observable.BlockingObservableMostRecent.MostRecentObserver.this.t;
                    }
                    if (io.reactivex.internal.util.NotificationLite.isComplete(this.n)) {
                        throw new java.util.NoSuchElementException();
                    }
                    if (io.reactivex.internal.util.NotificationLite.isError(this.n)) {
                        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(io.reactivex.internal.util.NotificationLite.getError(this.n));
                    }
                    return (T) io.reactivex.internal.util.NotificationLite.getValue(this.n);
                } finally {
                    this.n = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new java.lang.UnsupportedOperationException("Read only iterator");
            }
        }

        public MostRecentObserver(T t) {
            this.t = io.reactivex.internal.util.NotificationLite.next(t);
        }

        public io.reactivex.internal.operators.observable.BlockingObservableMostRecent.MostRecentObserver<T>.Iterator a() {
            return new io.reactivex.internal.operators.observable.BlockingObservableMostRecent.MostRecentObserver.Iterator();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.t = io.reactivex.internal.util.NotificationLite.complete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.util.NotificationLite.error(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.t = io.reactivex.internal.util.NotificationLite.next(t);
        }
    }

    public BlockingObservableMostRecent(io.reactivex.ObservableSource<T> observableSource, T t) {
        this.n = observableSource;
        this.t = t;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        io.reactivex.internal.operators.observable.BlockingObservableMostRecent.MostRecentObserver mostRecentObserver = new io.reactivex.internal.operators.observable.BlockingObservableMostRecent.MostRecentObserver(this.t);
        this.n.subscribe(mostRecentObserver);
        return mostRecentObserver.a();
    }
}
