package io.reactivex.internal.operators.flowable;

/* loaded from: classes10.dex */
public final class FlowableRefCount<T> extends io.reactivex.Flowable<T> {
    public final io.reactivex.flowables.ConnectableFlowable<T> t;
    public final int u;
    public final long v;
    public final java.util.concurrent.TimeUnit w;
    public final io.reactivex.Scheduler x;
    public io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection y;

    public static final class RefConnection extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements java.lang.Runnable, io.reactivex.functions.Consumer<io.reactivex.disposables.Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final io.reactivex.internal.operators.flowable.FlowableRefCount<?> parent;
        long subscriberCount;
        io.reactivex.disposables.Disposable timer;

        public RefConnection(io.reactivex.internal.operators.flowable.FlowableRefCount<?> flowableRefCount) {
            this.parent = flowableRefCount;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(io.reactivex.disposables.Disposable disposable) throws java.lang.Exception {
            io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((io.reactivex.internal.disposables.ResettableConnectable) this.parent.t).resetIf(disposable);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.i(this);
        }
    }

    public static final class RefCountSubscriber<T> extends java.util.concurrent.atomic.AtomicBoolean implements io.reactivex.FlowableSubscriber<T>, org.reactivestreams.Subscription {
        private static final long serialVersionUID = -7419642935409022375L;
        final io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection connection;
        final org.reactivestreams.Subscriber<? super T> downstream;
        final io.reactivex.internal.operators.flowable.FlowableRefCount<T> parent;
        org.reactivestreams.Subscription upstream;

        public RefCountSubscriber(org.reactivestreams.Subscriber<? super T> subscriber, io.reactivex.internal.operators.flowable.FlowableRefCount<T> flowableRefCount, io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection refConnection) {
            this.downstream = subscriber;
            this.parent = flowableRefCount;
            this.connection = refConnection;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            if (compareAndSet(false, true)) {
                this.parent.e(this.connection);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.h(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(java.lang.Throwable th) {
            if (!compareAndSet(false, true)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.parent.h(this.connection);
                this.downstream.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(org.reactivestreams.Subscription subscription) {
            if (io.reactivex.internal.subscriptions.SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
            this.upstream.request(j);
        }
    }

    public FlowableRefCount(io.reactivex.flowables.ConnectableFlowable<T> connectableFlowable) {
        this(connectableFlowable, 1, 0L, java.util.concurrent.TimeUnit.NANOSECONDS, null);
    }

    public FlowableRefCount(io.reactivex.flowables.ConnectableFlowable<T> connectableFlowable, int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        this.t = connectableFlowable;
        this.u = i;
        this.v = j;
        this.w = timeUnit;
        this.x = scheduler;
    }

    public void e(io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection refConnection) {
        synchronized (this) {
            io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection refConnection2 = this.y;
            if (refConnection2 != null && refConnection2 == refConnection) {
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0 && refConnection.connected) {
                    if (this.v == 0) {
                        i(refConnection);
                        return;
                    }
                    io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = new io.reactivex.internal.disposables.SequentialDisposable();
                    refConnection.timer = sequentialDisposable;
                    sequentialDisposable.replace(this.x.scheduleDirect(refConnection, this.v, this.w));
                }
            }
        }
    }

    public void f(io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection refConnection) {
        io.reactivex.disposables.Disposable disposable = refConnection.timer;
        if (disposable != null) {
            disposable.dispose();
            refConnection.timer = null;
        }
    }

    public void g(io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection refConnection) {
        io.reactivex.flowables.ConnectableFlowable<T> connectableFlowable = this.t;
        if (connectableFlowable instanceof io.reactivex.disposables.Disposable) {
            ((io.reactivex.disposables.Disposable) connectableFlowable).dispose();
        } else if (connectableFlowable instanceof io.reactivex.internal.disposables.ResettableConnectable) {
            ((io.reactivex.internal.disposables.ResettableConnectable) connectableFlowable).resetIf(refConnection.get());
        }
    }

    public void h(io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection refConnection) {
        synchronized (this) {
            if (this.t instanceof io.reactivex.internal.operators.flowable.FlowablePublishClassic) {
                io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection refConnection2 = this.y;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.y = null;
                    f(refConnection);
                }
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0) {
                    g(refConnection);
                }
            } else {
                io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection refConnection3 = this.y;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    f(refConnection);
                    long j2 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j2;
                    if (j2 == 0) {
                        this.y = null;
                        g(refConnection);
                    }
                }
            }
        }
    }

    public void i(io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.y) {
                this.y = null;
                io.reactivex.disposables.Disposable disposable = refConnection.get();
                io.reactivex.internal.disposables.DisposableHelper.dispose(refConnection);
                io.reactivex.flowables.ConnectableFlowable<T> connectableFlowable = this.t;
                if (connectableFlowable instanceof io.reactivex.disposables.Disposable) {
                    ((io.reactivex.disposables.Disposable) connectableFlowable).dispose();
                } else if (connectableFlowable instanceof io.reactivex.internal.disposables.ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((io.reactivex.internal.disposables.ResettableConnectable) connectableFlowable).resetIf(disposable);
                    }
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(org.reactivestreams.Subscriber<? super T> subscriber) {
        io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection refConnection;
        boolean z;
        io.reactivex.disposables.Disposable disposable;
        synchronized (this) {
            refConnection = this.y;
            if (refConnection == null) {
                refConnection = new io.reactivex.internal.operators.flowable.FlowableRefCount.RefConnection(this);
                this.y = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && (disposable = refConnection.timer) != null) {
                disposable.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            if (refConnection.connected || j2 != this.u) {
                z = false;
            } else {
                z = true;
                refConnection.connected = true;
            }
        }
        this.t.subscribe((io.reactivex.FlowableSubscriber) new io.reactivex.internal.operators.flowable.FlowableRefCount.RefCountSubscriber(subscriber, this, refConnection));
        if (z) {
            this.t.connect(refConnection);
        }
    }
}
