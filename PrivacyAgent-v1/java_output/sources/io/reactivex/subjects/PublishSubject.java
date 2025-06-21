package io.reactivex.subjects;

/* loaded from: classes14.dex */
public final class PublishSubject<T> extends io.reactivex.subjects.Subject<T> {
    public static final io.reactivex.subjects.PublishSubject.PublishDisposable[] u = new io.reactivex.subjects.PublishSubject.PublishDisposable[0];
    public static final io.reactivex.subjects.PublishSubject.PublishDisposable[] v = new io.reactivex.subjects.PublishSubject.PublishDisposable[0];
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.PublishSubject.PublishDisposable<T>[]> n = new java.util.concurrent.atomic.AtomicReference<>(v);
    public java.lang.Throwable t;

    public static final class PublishDisposable<T> extends java.util.concurrent.atomic.AtomicBoolean implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 3562861878281475070L;
        final io.reactivex.Observer<? super T> downstream;
        final io.reactivex.subjects.PublishSubject<T> parent;

        public PublishDisposable(io.reactivex.Observer<? super T> observer, io.reactivex.subjects.PublishSubject<T> publishSubject) {
            this.downstream = observer;
            this.parent = publishSubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.e(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        public void onError(java.lang.Throwable th) {
            if (get()) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.downstream.onError(th);
            }
        }

        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }
    }

    @io.reactivex.annotations.CheckReturnValue
    @io.reactivex.annotations.NonNull
    public static <T> io.reactivex.subjects.PublishSubject<T> create() {
        return new io.reactivex.subjects.PublishSubject<>();
    }

    public boolean d(io.reactivex.subjects.PublishSubject.PublishDisposable<T> publishDisposable) {
        io.reactivex.subjects.PublishSubject.PublishDisposable<T>[] publishDisposableArr;
        io.reactivex.subjects.PublishSubject.PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.n.get();
            if (publishDisposableArr == u) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new io.reactivex.subjects.PublishSubject.PublishDisposable[length + 1];
            java.lang.System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!defpackage.xv0.a(this.n, publishDisposableArr, publishDisposableArr2));
        return true;
    }

    public void e(io.reactivex.subjects.PublishSubject.PublishDisposable<T> publishDisposable) {
        io.reactivex.subjects.PublishSubject.PublishDisposable<T>[] publishDisposableArr;
        io.reactivex.subjects.PublishSubject.PublishDisposable[] publishDisposableArr2;
        do {
            publishDisposableArr = this.n.get();
            if (publishDisposableArr == u || publishDisposableArr == v) {
                return;
            }
            int length = publishDisposableArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (publishDisposableArr[i] == publishDisposable) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = v;
            } else {
                io.reactivex.subjects.PublishSubject.PublishDisposable[] publishDisposableArr3 = new io.reactivex.subjects.PublishSubject.PublishDisposable[length - 1];
                java.lang.System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                java.lang.System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!defpackage.xv0.a(this.n, publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.subjects.Subject
    @io.reactivex.annotations.Nullable
    public java.lang.Throwable getThrowable() {
        if (this.n.get() == u) {
            return this.t;
        }
        return null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.n.get() == u && this.t == null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.n.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.n.get() == u && this.t != null;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        io.reactivex.subjects.PublishSubject.PublishDisposable<T>[] publishDisposableArr = this.n.get();
        io.reactivex.subjects.PublishSubject.PublishDisposable<T>[] publishDisposableArr2 = u;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (io.reactivex.subjects.PublishSubject.PublishDisposable<T> publishDisposable : this.n.getAndSet(publishDisposableArr2)) {
            publishDisposable.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        io.reactivex.subjects.PublishSubject.PublishDisposable<T>[] publishDisposableArr = this.n.get();
        io.reactivex.subjects.PublishSubject.PublishDisposable<T>[] publishDisposableArr2 = u;
        if (publishDisposableArr == publishDisposableArr2) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
            return;
        }
        this.t = th;
        for (io.reactivex.subjects.PublishSubject.PublishDisposable<T> publishDisposable : this.n.getAndSet(publishDisposableArr2)) {
            publishDisposable.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (io.reactivex.subjects.PublishSubject.PublishDisposable<T> publishDisposable : this.n.get()) {
            publishDisposable.onNext(t);
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        if (this.n.get() == u) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.subjects.PublishSubject.PublishDisposable<T> publishDisposable = new io.reactivex.subjects.PublishSubject.PublishDisposable<>(observer, this);
        observer.onSubscribe(publishDisposable);
        if (d(publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                e(publishDisposable);
            }
        } else {
            java.lang.Throwable th = this.t;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        }
    }
}
