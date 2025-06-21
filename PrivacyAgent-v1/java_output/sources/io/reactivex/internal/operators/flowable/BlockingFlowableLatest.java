package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class BlockingFlowableLatest<T> implements java.lang.Iterable<T> {
    public final org.reactivestreams.Publisher<? extends T> n;

    public static final class LatestSubscriberIterator<T> extends io.reactivex.subscribers.DisposableSubscriber<io.reactivex.Notification<T>> implements java.util.Iterator<T> {
        public final java.util.concurrent.Semaphore t = new java.util.concurrent.Semaphore(0);
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.Notification<T>> u = new java.util.concurrent.atomic.AtomicReference<>();
        public io.reactivex.Notification<T> v;

        @Override // org.reactivestreams.Subscriber
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(io.reactivex.Notification<T> notification) {
            if (this.u.getAndSet(notification) == null) {
                this.t.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            io.reactivex.Notification<T> notification = this.v;
            if (notification != null && notification.isOnError()) {
                throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(this.v.getError());
            }
            io.reactivex.Notification<T> notification2 = this.v;
            if ((notification2 == null || notification2.isOnNext()) && this.v == null) {
                try {
                    io.reactivex.internal.util.BlockingHelper.verifyNonBlocking();
                    this.t.acquire();
                    io.reactivex.Notification<T> andSet = this.u.getAndSet(null);
                    this.v = andSet;
                    if (andSet.isOnError()) {
                        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(andSet.getError());
                    }
                } catch (java.lang.InterruptedException e) {
                    dispose();
                    this.v = io.reactivex.Notification.createOnError(e);
                    throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(e);
                }
            }
            return this.v.isOnNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext() || !this.v.isOnNext()) {
                throw new java.util.NoSuchElementException();
            }
            T value = this.v.getValue();
            this.v = null;
            return value;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException("Read-only iterator.");
        }
    }

    public BlockingFlowableLatest(org.reactivestreams.Publisher<? extends T> publisher) {
        this.n = publisher;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        io.reactivex.internal.operators.flowable.BlockingFlowableLatest.LatestSubscriberIterator latestSubscriberIterator = new io.reactivex.internal.operators.flowable.BlockingFlowableLatest.LatestSubscriberIterator();
        io.reactivex.Flowable.fromPublisher(this.n).materialize().subscribe((io.reactivex.FlowableSubscriber<? super io.reactivex.Notification<T>>) latestSubscriberIterator);
        return latestSubscriberIterator;
    }
}
