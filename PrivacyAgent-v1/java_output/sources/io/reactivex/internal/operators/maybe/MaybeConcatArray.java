package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeConcatArray<T> extends io.reactivex.Flowable<T> {
    public final io.reactivex.MaybeSource<? extends T>[] t;

    public static final class ConcatMaybeObserver<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.MaybeObserver<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = 3520831347801429610L;
        final org.reactivestreams.Subscriber<? super T> downstream;
        int index;
        long produced;
        final io.reactivex.MaybeSource<? extends T>[] sources;
        final java.util.concurrent.atomic.AtomicLong requested = new java.util.concurrent.atomic.AtomicLong();
        final io.reactivex.internal.disposables.SequentialDisposable disposables = new io.reactivex.internal.disposables.SequentialDisposable();
        final java.util.concurrent.atomic.AtomicReference<java.lang.Object> current = new java.util.concurrent.atomic.AtomicReference<>(io.reactivex.internal.util.NotificationLite.COMPLETE);

        public ConcatMaybeObserver(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.MaybeSource<? extends T>[] maybeSourceArr) {
            this.downstream = subscriber;
            this.sources = maybeSourceArr;
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
                        int i = this.index;
                        io.reactivex.MaybeSource<? extends T>[] maybeSourceArr = this.sources;
                        if (i == maybeSourceArr.length) {
                            subscriber.onComplete();
                            return;
                        } else {
                            this.index = i + 1;
                            maybeSourceArr[i].subscribe(this);
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

    public MaybeConcatArray(io.reactivex.MaybeSource<? extends T>[] maybeSourceArr) {
        this.t = maybeSourceArr;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.maybe.MaybeConcatArray.ConcatMaybeObserver concatMaybeObserver = new io.reactivex.internal.operators.maybe.MaybeConcatArray.ConcatMaybeObserver(subscriber, this.t);
        subscriber.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.drain();
    }
}
