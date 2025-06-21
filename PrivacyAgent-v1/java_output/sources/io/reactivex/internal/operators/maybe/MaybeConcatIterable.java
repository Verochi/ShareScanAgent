package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeConcatIterable<T> extends io.reactivex.Flowable<T> {
    public final java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> t;

    public static final class ConcatMaybeObserver<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.MaybeObserver<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        long produced;
        final java.util.Iterator<? extends io.reactivex.MaybeSource<? extends T>> sources;
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final io.reactivex.internal.disposables.SequentialDisposable disposables = new io.reactivex.internal.disposables.SequentialDisposable();
        final java.util.concurrent.atomic.AtomicReference<java.lang.Object> current = new java.util.concurrent.atomic.AtomicReference<>(io.reactivex.internal.util.NotificationLite.COMPLETE);

        public ConcatMaybeObserver(org.reactivestreams.Subscriber<? super T> subscriber, java.util.Iterator<? extends io.reactivex.MaybeSource<? extends T>> it) {
            this.downstream = subscriber;
            this.sources = it;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.disposables.dispose();
        }

        public void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> atomicReference = this.current;
            org.reactivestreams.Subscriber<? super T> subscriber = this.downstream;
            io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = this.disposables;
            while (!sequentialDisposable.isDisposed()) {
                java.lang.Object obj = atomicReference.get();
                if (obj != null) {
                    boolean z = true;
                    if (obj != io.reactivex.internal.util.NotificationLite.COMPLETE) {
                        long j = this.produced;
                        if (j != this.requested.get()) {
                            this.produced = j + 1;
                            atomicReference.lazySet(null);
                            subscriber.onNext(obj);
                        } else {
                            z = false;
                        }
                    } else {
                        atomicReference.lazySet(null);
                    }
                    if (z && !sequentialDisposable.isDisposed()) {
                        try {
                            if (this.sources.hasNext()) {
                                try {
                                    ((io.reactivex.MaybeSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.sources.next(), "The source Iterator returned a null MaybeSource")).subscribe(this);
                                } catch (java.lang.Throwable th) {
                                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                                    subscriber.onError(th);
                                    return;
                                }
                            } else {
                                subscriber.onComplete();
                            }
                        } catch (java.lang.Throwable th2) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.current.lazySet(io.reactivex.internal.util.NotificationLite.COMPLETE);
            drain();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.disposables.replace(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.current.lazySet(t);
            drain();
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.BackpressureHelper.add(this.requested, j);
                drain();
            }
        }
    }

    public MaybeConcatIterable(java.lang.Iterable<? extends io.reactivex.MaybeSource<? extends T>> iterable) {
        this.t = iterable;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        try {
            io.reactivex.internal.operators.maybe.MaybeConcatIterable.ConcatMaybeObserver concatMaybeObserver = new io.reactivex.internal.operators.maybe.MaybeConcatIterable.ConcatMaybeObserver(subscriber, (java.util.Iterator) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.iterator(), "The sources Iterable returned a null Iterator"));
            subscriber.onSubscribe(concatMaybeObserver);
            concatMaybeObserver.drain();
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.subscriptions.EmptySubscription.error(th, subscriber);
        }
    }
}
