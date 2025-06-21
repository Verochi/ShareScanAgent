package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class BlockingObservableLatest<T> implements java.lang.Iterable<T> {
    public final io.reactivex.ObservableSource<T> n;

    public static final class BlockingObservableLatestIterator<T> extends io.reactivex.observers.DisposableObserver<io.reactivex.Notification<T>> implements java.util.Iterator<T> {
        public io.reactivex.Notification<T> t;
        public final java.util.concurrent.Semaphore u = new java.util.concurrent.Semaphore(0);
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.Notification<T>> v = new java.util.concurrent.atomic.AtomicReference<>();

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(io.reactivex.Notification<T> notification) {
            if (this.v.getAndSet(notification) == null) {
                this.u.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            io.reactivex.Notification<T> notification = this.t;
            if (notification != null && notification.isOnError()) {
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(this.t.getError());
            }
            if (this.t == null) {
                try {
                    io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                    this.u.acquire();
                    io.reactivex.Notification<T> andSet = this.v.getAndSet(null);
                    this.t = andSet;
                    if (andSet.isOnError()) {
                        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(andSet.getError());
                    }
                } catch (java.lang.InterruptedException e) {
                    dispose();
                    this.t = io.reactivex.Notification.createOnError(e);
                    throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
                }
            }
            return this.t.isOnNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T value = this.t.getValue();
            this.t = null;
            return value;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingObservableLatest(io.reactivex.ObservableSource<T> observableSource) {
        this.n = observableSource;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        io.reactivex.internal.operators.observable.BlockingObservableLatest.BlockingObservableLatestIterator blockingObservableLatestIterator = new io.reactivex.internal.operators.observable.BlockingObservableLatest.BlockingObservableLatestIterator();
        io.reactivex.Observable.wrap(this.n).materialize().subscribe(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }
}
