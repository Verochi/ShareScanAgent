package io.reactivex.subjects;

/* loaded from: classes14.dex */
final class SerializedSubject<T> extends io.reactivex.subjects.Subject<T> implements io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate<java.lang.Object> {
    public final io.reactivex.subjects.Subject<T> n;
    public boolean t;
    public io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> u;
    public volatile boolean v;

    public SerializedSubject(io.reactivex.subjects.Subject<T> subject) {
        this.n = subject;
    }

    public void d() {
        io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.u;
                if (appendOnlyLinkedArrayList == null) {
                    this.t = false;
                    return;
                }
                this.u = null;
            }
            appendOnlyLinkedArrayList.forEachWhile(this);
        }
    }

    @Override // io.reactivex.subjects.Subject
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        return this.n.getThrowable();
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.n.hasComplete();
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.n.hasObservers();
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.n.hasThrowable();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.v) {
            return;
        }
        synchronized (this) {
            if (this.v) {
                return;
            }
            this.v = true;
            if (!this.t) {
                this.t = true;
                this.n.onComplete();
                return;
            }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.u;
            if (appendOnlyLinkedArrayList == null) {
                appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                this.u = appendOnlyLinkedArrayList;
            }
            appendOnlyLinkedArrayList.add(io.reactivex.internal.util.NotificationLite.complete());
        }
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        if (this.v) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.v) {
                this.v = true;
                if (this.t) {
                    io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.u;
                    if (appendOnlyLinkedArrayList == null) {
                        appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                        this.u = appendOnlyLinkedArrayList;
                    }
                    appendOnlyLinkedArrayList.setFirst(io.reactivex.internal.util.NotificationLite.error(th));
                    return;
                }
                this.t = true;
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
    public void onNext(T t) {
        if (this.v) {
            return;
        }
        synchronized (this) {
            if (this.v) {
                return;
            }
            if (!this.t) {
                this.t = true;
                this.n.onNext(t);
                d();
            } else {
                io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.u;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                    this.u = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(io.reactivex.internal.util.NotificationLite.next(t));
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        boolean z = true;
        if (!this.v) {
            synchronized (this) {
                if (!this.v) {
                    if (this.t) {
                        io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> appendOnlyLinkedArrayList = this.u;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new io.reactivex.internal.util.AppendOnlyLinkedArrayList<>(4);
                            this.u = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(io.reactivex.internal.util.NotificationLite.disposable(disposable));
                        return;
                    }
                    this.t = true;
                    z = false;
                }
            }
        }
        if (z) {
            disposable.dispose();
        } else {
            this.n.onSubscribe(disposable);
            d();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.n.subscribe(observer);
    }

    @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
    public boolean test(java.lang.Object obj) {
        return io.reactivex.internal.util.NotificationLite.acceptFull(obj, this.n);
    }
}
