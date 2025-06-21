package io.reactivex.subscribers;

/* loaded from: classes14.dex */
public final class SerializedSubscriber<T> implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
    public final org.reactivestreams.Subscriber<? super T> n;
    public final boolean t;
    public org.reactivestreams.Subscription u;
    public boolean v;
    public io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> w;
    public volatile boolean x;

    public SerializedSubscriber(org.reactivestreams.Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    public SerializedSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, boolean z) {
        this.n = subscriber;
        this.t = z;
    }

    public void a() {
        io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.w;
                if (appendOnlyLinkedArrayList == null) {
                    this.v = false;
                    return;
                }
                this.w = null;
            }
        } while (!appendOnlyLinkedArrayList.accept(this.n));
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.u.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.x) {
            return;
        }
        synchronized (this) {
            if (this.x) {
                return;
            }
            if (!this.v) {
                this.x = true;
                this.v = true;
                this.n.onComplete();
            } else {
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.w;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                    this.w = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(io.reactivex.internal.util.NotificationLite.complete());
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(java.lang.Throwable th) {
        if (this.x) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.x) {
                if (this.v) {
                    this.x = true;
                    io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.w;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                        this.w = appendOnlyLinkedArrayList;
                    }
                    java.lang.Object error = io.reactivex.internal.util.NotificationLite.error(th);
                    if (this.t) {
                        appendOnlyLinkedArrayList.add(error);
                    } else {
                        appendOnlyLinkedArrayList.setFirst(error);
                    }
                    return;
                }
                this.x = true;
                this.v = true;
                z = false;
            }
            if (z) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.n.onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onNext(T t) {
        if (this.x) {
            return;
        }
        if (t == null) {
            this.u.cancel();
            onError(new java.lang.NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.x) {
                return;
            }
            if (!this.v) {
                this.v = true;
                this.n.onNext(t);
                a();
            } else {
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.w;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                    this.w = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(io.reactivex.internal.util.NotificationLite.next(t));
            }
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void onSubscribe(org.reactivestreams.Subscription subscription) {
        if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.u, subscription)) {
            this.u = subscription;
            this.n.onSubscribe(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
        this.u.request(j);
    }
}
