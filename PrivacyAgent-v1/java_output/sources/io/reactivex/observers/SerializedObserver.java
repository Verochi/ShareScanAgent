package io.reactivex.observers;

/* loaded from: classes13.dex */
public final class SerializedObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
    public final io.reactivex.Observer<? super T> n;
    public final boolean t;
    public io.reactivex.disposables.Disposable u;
    public boolean v;
    public io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> w;
    public volatile boolean x;

    public SerializedObserver(@io.reactivex.annotations.NonNull io.reactivex.Observer<? super T> observer) {
        this(observer, false);
    }

    public SerializedObserver(@io.reactivex.annotations.NonNull io.reactivex.Observer<? super T> observer, boolean z) {
        this.n = observer;
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

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.u.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.u.isDisposed();
    }

    @Override // io.reactivex.Observer
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

    @Override // io.reactivex.Observer
    public void onError(@io.reactivex.annotations.NonNull java.lang.Throwable th) {
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

    @Override // io.reactivex.Observer
    public void onNext(@io.reactivex.annotations.NonNull T t) {
        if (this.x) {
            return;
        }
        if (t == null) {
            this.u.dispose();
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

    @Override // io.reactivex.Observer
    public void onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable disposable) {
        if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
            this.u = disposable;
            this.n.onSubscribe(this);
        }
    }
}
