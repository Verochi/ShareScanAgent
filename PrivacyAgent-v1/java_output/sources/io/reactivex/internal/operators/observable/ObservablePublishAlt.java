package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservablePublishAlt<T> extends io.reactivex.observables.ConnectableObservable<T> implements io.reactivex.internal.fuseable.HasUpstreamObservableSource<T>, io.reactivex.internal.disposables.ResettableConnectable {
    public final io.reactivex.ObservableSource<T> n;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<T>> t = new java.util.concurrent.atomic.AtomicReference<>();

    public static final class InnerDisposable<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<T>> implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 7463222674719692880L;
        final io.reactivex.Observer<? super T> downstream;

        public InnerDisposable(io.reactivex.Observer<? super T> observer, io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<T> publishConnection) {
            this.downstream = observer;
            lazySet(publishConnection);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == null;
        }
    }

    public static final class PublishConnection<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable<T>[]> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        static final io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable[] EMPTY = new io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable[0];
        static final io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable[] TERMINATED = new io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable[0];
        private static final long serialVersionUID = -3251430252873581268L;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<T>> current;
        java.lang.Throwable error;
        final java.util.concurrent.atomic.AtomicBoolean connect = new java.util.concurrent.atomic.AtomicBoolean();
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> upstream = new java.util.concurrent.atomic.AtomicReference<>();

        public PublishConnection(java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<T>> atomicReference) {
            this.current = atomicReference;
            lazySet(EMPTY);
        }

        public boolean add(io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable<T> innerDisposable) {
            io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable<T>[] innerDisposableArr;
            io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable[length + 1];
                java.lang.System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            getAndSet(TERMINATED);
            defpackage.xv0.a(this.current, this, null);
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.upstream);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == TERMINATED;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.upstream.lazySet(io.reactivex.internal.disposables.DisposableHelper.DISPOSED);
            for (io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable<T> innerDisposable : getAndSet(TERMINATED)) {
                innerDisposable.downstream.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.error = th;
            this.upstream.lazySet(io.reactivex.internal.disposables.DisposableHelper.DISPOSED);
            for (io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable<T> innerDisposable : getAndSet(TERMINATED)) {
                innerDisposable.downstream.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            for (io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable<T> innerDisposable : get()) {
                innerDisposable.downstream.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.upstream, disposable);
        }

        public void remove(io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable<T> innerDisposable) {
            io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable<T>[] innerDisposableArr;
            io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerDisposableArr[i] == innerDisposable) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                innerDisposableArr2 = EMPTY;
                if (length != 1) {
                    innerDisposableArr2 = new io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable[length - 1];
                    java.lang.System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i);
                    java.lang.System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr2, i, (length - i) - 1);
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }
    }

    public ObservablePublishAlt(io.reactivex.ObservableSource<T> observableSource) {
        this.n = observableSource;
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.t.get();
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<T> publishConnection2 = new io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<>(this.t);
            if (defpackage.xv0.a(this.t, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        boolean z = false;
        if (!publishConnection.connect.get() && publishConnection.connect.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(publishConnection);
            if (z) {
                this.n.subscribe(publishConnection);
            }
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public void resetIf(io.reactivex.disposables.Disposable disposable) {
        defpackage.xv0.a(this.t, (io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection) disposable, null);
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public io.reactivex.ObservableSource<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.t.get();
            if (publishConnection != null) {
                break;
            }
            io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<T> publishConnection2 = new io.reactivex.internal.operators.observable.ObservablePublishAlt.PublishConnection<>(this.t);
            if (defpackage.xv0.a(this.t, publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable<T> innerDisposable = new io.reactivex.internal.operators.observable.ObservablePublishAlt.InnerDisposable<>(observer, publishConnection);
        observer.onSubscribe(innerDisposable);
        if (publishConnection.add(innerDisposable)) {
            if (innerDisposable.isDisposed()) {
                publishConnection.remove(innerDisposable);
            }
        } else {
            java.lang.Throwable th = publishConnection.error;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        }
    }
}
