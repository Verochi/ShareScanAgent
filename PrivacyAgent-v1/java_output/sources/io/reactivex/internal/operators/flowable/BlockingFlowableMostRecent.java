package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class BlockingFlowableMostRecent<T> implements java.lang.Iterable<T> {
    public final io.reactivex.Flowable<T> n;
    public final T t;

    public static final class MostRecentSubscriber<T> extends io.reactivex.subscribers.DefaultSubscriber<T> {
        public volatile java.lang.Object t;

        public final class Iterator implements java.util.Iterator<T> {
            public java.lang.Object n;

            public Iterator() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.n = io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent.MostRecentSubscriber.this.t;
                return !io.reactivex.internal.util.NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.n == null) {
                        this.n = io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent.MostRecentSubscriber.this.t;
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

        public MostRecentSubscriber(T t) {
            this.t = io.reactivex.internal.util.NotificationLite.next(t);
        }

        public io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent.MostRecentSubscriber<T>.Iterator a() {
            return new io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent.MostRecentSubscriber.Iterator();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.t = io.reactivex.internal.util.NotificationLite.complete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            this.t = io.reactivex.internal.util.NotificationLite.error(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.t = io.reactivex.internal.util.NotificationLite.next(t);
        }
    }

    public BlockingFlowableMostRecent(io.reactivex.Flowable<T> flowable, T t) {
        this.n = flowable;
        this.t = t;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent.MostRecentSubscriber mostRecentSubscriber = new io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent.MostRecentSubscriber(this.t);
        this.n.subscribe((io.reactivex.FlowableSubscriber) mostRecentSubscriber);
        return mostRecentSubscriber.a();
    }
}
