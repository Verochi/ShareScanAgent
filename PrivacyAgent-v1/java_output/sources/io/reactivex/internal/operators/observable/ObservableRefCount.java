package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableRefCount<T> extends io.reactivex.Observable<T> {
    public final io.reactivex.observables.ConnectableObservable<T> n;
    public final int t;
    public final long u;
    public final java.util.concurrent.TimeUnit v;
    public final io.reactivex.Scheduler w;
    public io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection x;

    public static final class RefConnection extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements java.lang.Runnable, io.reactivex.functions.Consumer<io.reactivex.disposables.Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final io.reactivex.internal.operators.observable.ObservableRefCount<?> parent;
        long subscriberCount;
        io.reactivex.disposables.Disposable timer;

        public RefConnection(io.reactivex.internal.operators.observable.ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(io.reactivex.disposables.Disposable disposable) throws java.lang.Exception {
            io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((io.reactivex.internal.disposables.ResettableConnectable) this.parent.n).resetIf(disposable);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.h(this);
        }
    }

    public static final class RefCountObserver<T> extends java.util.concurrent.atomic.AtomicBoolean implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -7419642935409022375L;
        final io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection connection;
        final io.reactivex.Observer<? super T> downstream;
        final io.reactivex.internal.operators.observable.ObservableRefCount<T> parent;
        io.reactivex.disposables.Disposable upstream;

        public RefCountObserver(io.reactivex.Observer<? super T> observer, io.reactivex.internal.operators.observable.ObservableRefCount<T> observableRefCount, io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection refConnection) {
            this.downstream = observer;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.d(this.connection);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.g(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (!compareAndSet(false, true)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.parent.g(this.connection);
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(io.reactivex.observables.ConnectableObservable<T> connectableObservable) {
        this(connectableObservable, 1, 0L, java.util.concurrent.TimeUnit.NANOSECONDS, null);
    }

    public ObservableRefCount(io.reactivex.observables.ConnectableObservable<T> connectableObservable, int i, long j, java.util.concurrent.TimeUnit timeUnit, io.reactivex.Scheduler scheduler) {
        this.n = connectableObservable;
        this.t = i;
        this.u = j;
        this.v = timeUnit;
        this.w = scheduler;
    }

    public void d(io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection refConnection) {
        synchronized (this) {
            io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection refConnection2 = this.x;
            if (refConnection2 != null && refConnection2 == refConnection) {
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0 && refConnection.connected) {
                    if (this.u == 0) {
                        h(refConnection);
                        return;
                    }
                    io.reactivex.internal.disposables.SequentialDisposable sequentialDisposable = new io.reactivex.internal.disposables.SequentialDisposable();
                    refConnection.timer = sequentialDisposable;
                    sequentialDisposable.replace(this.w.scheduleDirect(refConnection, this.u, this.v));
                }
            }
        }
    }

    public void e(io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection refConnection) {
        io.reactivex.disposables.Disposable disposable = refConnection.timer;
        if (disposable != null) {
            disposable.dispose();
            refConnection.timer = null;
        }
    }

    public void f(io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection refConnection) {
        io.reactivex.observables.ConnectableObservable<T> connectableObservable = this.n;
        if (connectableObservable instanceof io.reactivex.disposables.Disposable) {
            ((io.reactivex.disposables.Disposable) connectableObservable).dispose();
        } else if (connectableObservable instanceof io.reactivex.internal.disposables.ResettableConnectable) {
            ((io.reactivex.internal.disposables.ResettableConnectable) connectableObservable).resetIf(refConnection.get());
        }
    }

    public void g(io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection refConnection) {
        synchronized (this) {
            if (this.n instanceof io.reactivex.internal.operators.observable.ObservablePublishClassic) {
                io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection refConnection2 = this.x;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.x = null;
                    e(refConnection);
                }
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0) {
                    f(refConnection);
                }
            } else {
                io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection refConnection3 = this.x;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    e(refConnection);
                    long j2 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j2;
                    if (j2 == 0) {
                        this.x = null;
                        f(refConnection);
                    }
                }
            }
        }
    }

    public void h(io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.x) {
                this.x = null;
                io.reactivex.disposables.Disposable disposable = refConnection.get();
                io.reactivex.internal.disposables.DisposableHelper.dispose(refConnection);
                io.reactivex.observables.ConnectableObservable<T> connectableObservable = this.n;
                if (connectableObservable instanceof io.reactivex.disposables.Disposable) {
                    ((io.reactivex.disposables.Disposable) connectableObservable).dispose();
                } else if (connectableObservable instanceof io.reactivex.internal.disposables.ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((io.reactivex.internal.disposables.ResettableConnectable) connectableObservable).resetIf(disposable);
                    }
                }
            }
        }
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection refConnection;
        boolean z;
        io.reactivex.disposables.Disposable disposable;
        synchronized (this) {
            refConnection = this.x;
            if (refConnection == null) {
                refConnection = new io.reactivex.internal.operators.observable.ObservableRefCount.RefConnection(this);
                this.x = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && (disposable = refConnection.timer) != null) {
                disposable.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            if (refConnection.connected || j2 != this.t) {
                z = false;
            } else {
                z = true;
                refConnection.connected = true;
            }
        }
        this.n.subscribe(new io.reactivex.internal.operators.observable.ObservableRefCount.RefCountObserver(observer, this, refConnection));
        if (z) {
            this.n.connect(refConnection);
        }
    }
}
