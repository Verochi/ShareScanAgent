package io.reactivex.observers;

/* loaded from: classes13.dex */
public class TestObserver<T> extends io.reactivex.observers.BaseTestConsumer<T, io.reactivex.observers.TestObserver<T>> implements io.reactivex.Observer<T>, io.reactivex.MaybeObserver<T>, io.reactivex.SingleObserver<T>, io.reactivex.CompletableObserver {
    public final io.reactivex.Observer<? super T> n;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> t;
    public io.reactivex.internal.fuseable.QueueDisposable<T> u;

    public enum EmptyObserver implements io.reactivex.Observer<java.lang.Object> {
        INSTANCE;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onNext(java.lang.Object obj) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        }
    }

    public TestObserver() {
        this(io.reactivex.observers.TestObserver.EmptyObserver.INSTANCE);
    }

    public TestObserver(io.reactivex.Observer<? super T> observer) {
        this.t = new java.util.concurrent.atomic.AtomicReference<>();
        this.n = observer;
    }

    public static <T> io.reactivex.observers.TestObserver<T> create() {
        return new io.reactivex.observers.TestObserver<>();
    }

    public static <T> io.reactivex.observers.TestObserver<T> create(io.reactivex.Observer<? super T> observer) {
        return new io.reactivex.observers.TestObserver<>(observer);
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final io.reactivex.observers.TestObserver<T> assertNotSubscribed() {
        if (this.t.get() != null) {
            throw fail("Subscribed!");
        }
        if (this.errors.isEmpty()) {
            return this;
        }
        throw fail("Not subscribed but errors found");
    }

    public final io.reactivex.observers.TestObserver<T> assertOf(io.reactivex.functions.Consumer<? super io.reactivex.observers.TestObserver<T>> consumer) {
        try {
            consumer.accept(this);
            return this;
        } catch (java.lang.Throwable th) {
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.observers.BaseTestConsumer
    public final io.reactivex.observers.TestObserver<T> assertSubscribed() {
        if (this.t.get() != null) {
            return this;
        }
        throw fail("Not subscribed!");
    }

    public final void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        io.reactivex.internal.disposables.DisposableHelper.dispose(this.t);
    }

    public final boolean hasSubscription() {
        return this.t.get() != null;
    }

    public final boolean isCancelled() {
        return isDisposed();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.t.get());
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.t.get() == null) {
                this.errors.add(new java.lang.IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = java.lang.Thread.currentThread();
            this.completions++;
            this.n.onComplete();
        } finally {
            this.done.countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.t.get() == null) {
                this.errors.add(new java.lang.IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = java.lang.Thread.currentThread();
            if (th == null) {
                this.errors.add(new java.lang.NullPointerException("onError received a null Throwable"));
            } else {
                this.errors.add(th);
            }
            this.n.onError(th);
        } finally {
            this.done.countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.t.get() == null) {
                this.errors.add(new java.lang.IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = java.lang.Thread.currentThread();
        if (this.establishedFusionMode != 2) {
            this.values.add(t);
            if (t == null) {
                this.errors.add(new java.lang.NullPointerException("onNext received a null value"));
            }
            this.n.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.u.poll();
                if (poll == null) {
                    return;
                } else {
                    this.values.add(poll);
                }
            } catch (java.lang.Throwable th) {
                this.errors.add(th);
                this.u.dispose();
                return;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        this.lastThread = java.lang.Thread.currentThread();
        if (disposable == null) {
            this.errors.add(new java.lang.NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!defpackage.xv0.a(this.t, null, disposable)) {
            disposable.dispose();
            if (this.t.get() != io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                this.errors.add(new java.lang.IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
                return;
            }
            return;
        }
        int i = this.initialFusionMode;
        if (i != 0 && (disposable instanceof io.reactivex.internal.fuseable.QueueDisposable)) {
            io.reactivex.internal.fuseable.QueueDisposable<T> queueDisposable = (io.reactivex.internal.fuseable.QueueDisposable) disposable;
            this.u = queueDisposable;
            int requestFusion = queueDisposable.requestFusion(i);
            this.establishedFusionMode = requestFusion;
            if (requestFusion == 1) {
                this.checkSubscriptionOnce = true;
                this.lastThread = java.lang.Thread.currentThread();
                while (true) {
                    try {
                        T poll = this.u.poll();
                        if (poll == null) {
                            this.completions++;
                            this.t.lazySet(io.reactivex.internal.disposables.DisposableHelper.DISPOSED);
                            return;
                        }
                        this.values.add(poll);
                    } catch (java.lang.Throwable th) {
                        this.errors.add(th);
                        return;
                    }
                }
            }
        }
        this.n.onSubscribe(disposable);
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }
}
