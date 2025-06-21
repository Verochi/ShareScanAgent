package io.reactivex.processors;

/* loaded from: classes13.dex */
final class SerializedProcessor<T> extends io.reactivex.processors.FlowableProcessor<T> {
    public final io.reactivex.processors.FlowableProcessor<T> t;
    public boolean u;
    public io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> v;
    public volatile boolean w;

    public SerializedProcessor(io.reactivex.processors.FlowableProcessor<T> flowableProcessor) {
        this.t = flowableProcessor;
    }

    public void e() {
        io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.v;
                if (appendOnlyLinkedArrayList == null) {
                    this.u = false;
                    return;
                }
                this.v = null;
            }
            appendOnlyLinkedArrayList.accept(this.t);
        }
    }

    @Override // io.reactivex.processors.FlowableProcessor
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        return this.t.getThrowable();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasComplete() {
        return this.t.hasComplete();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasSubscribers() {
        return this.t.hasSubscribers();
    }

    @Override // io.reactivex.processors.FlowableProcessor
    public boolean hasThrowable() {
        return this.t.hasThrowable();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.w) {
            return;
        }
        synchronized (this) {
            if (this.w) {
                return;
            }
            this.w = true;
            if (!this.u) {
                this.u = true;
                this.t.onComplete();
                return;
            }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.v;
            if (appendOnlyLinkedArrayList == null) {
                appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                this.v = appendOnlyLinkedArrayList;
            }
            appendOnlyLinkedArrayList.add(io.reactivex.internal.util.NotificationLite.complete());
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        if (this.w) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.w) {
                this.w = true;
                if (this.u) {
                    io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.v;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                        this.v = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.setFirst(io.reactivex.internal.util.NotificationLite.error(th));
                    return;
                }
                this.u = true;
                z = false;
            }
            if (z) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.t.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.w) {
            return;
        }
        synchronized (this) {
            if (this.w) {
                return;
            }
            if (!this.u) {
                this.u = true;
                this.t.onNext(t);
                e();
            } else {
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.v;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                    this.v = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(io.reactivex.internal.util.NotificationLite.next(t));
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        boolean z = true;
        if (!this.w) {
            synchronized (this) {
                if (!this.w) {
                    if (this.u) {
                        io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.v;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                            this.v = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(io.reactivex.internal.util.NotificationLite.subscription(subscription));
                        return;
                    }
                    this.u = true;
                    z = false;
                }
            }
        }
        if (z) {
            subscription.cancel();
        } else {
            this.t.onSubscribe(subscription);
            e();
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        this.t.subscribe(subscriber);
    }
}
