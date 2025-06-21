package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservablePublish<T> extends io.reactivex.observables.ConnectableObservable<T> implements io.reactivex.internal.fuseable.HasUpstreamObservableSource<T>, io.reactivex.internal.operators.observable.ObservablePublishClassic<T> {
    public final io.reactivex.ObservableSource<T> n;
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T>> t;
    public final io.reactivex.ObservableSource<T> u;

    public static final class InnerDisposable<T> extends java.util.concurrent.atomic.AtomicReference<java.lang.Object> implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -1100270633763673112L;
        final io.reactivex.Observer<? super T> child;

        public InnerDisposable(io.reactivex.Observer<? super T> observer) {
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            java.lang.Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver) andSet).b(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() == this;
        }

        public void setParent(io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T> publishObserver) {
            if (compareAndSet(null, publishObserver)) {
                return;
            }
            publishObserver.b(this);
        }
    }

    public static final class PublishObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public static final io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[] w = new io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[0];
        public static final io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[] x = new io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[0];
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T>> n;
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> v = new java.util.concurrent.atomic.AtomicReference<>();
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T>[]> t = new java.util.concurrent.atomic.AtomicReference<>(w);
        public final java.util.concurrent.atomic.AtomicBoolean u = new java.util.concurrent.atomic.AtomicBoolean();

        public PublishObserver(java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T>> atomicReference) {
            this.n = atomicReference;
        }

        public boolean a(io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T> innerDisposable) {
            io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T>[] innerDisposableArr;
            io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.t.get();
                if (innerDisposableArr == x) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[length + 1];
                java.lang.System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!defpackage.xv0.a(this.t, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void b(io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T> innerDisposable) {
            io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T>[] innerDisposableArr;
            io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.t.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (innerDisposableArr[i].equals(innerDisposable)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = w;
                } else {
                    io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[] innerDisposableArr3 = new io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable[length - 1];
                    java.lang.System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    java.lang.System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!defpackage.xv0.a(this.t, innerDisposableArr, innerDisposableArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T>[]> atomicReference = this.t;
            io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T>[] innerDisposableArr = x;
            if (atomicReference.getAndSet(innerDisposableArr) != innerDisposableArr) {
                defpackage.xv0.a(this.n, this, null);
                io.reactivex.internal.disposables.DisposableHelper.dispose(this.v);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.get() == x;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            defpackage.xv0.a(this.n, this, null);
            for (io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T> innerDisposable : this.t.getAndSet(x)) {
                innerDisposable.child.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            defpackage.xv0.a(this.n, this, null);
            io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T>[] andSet = this.t.getAndSet(x);
            if (andSet.length == 0) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            for (io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T> innerDisposable : andSet) {
                innerDisposable.child.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            for (io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable<T> innerDisposable : this.t.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.v, disposable);
        }
    }

    public static final class PublishSource<T> implements io.reactivex.ObservableSource<T> {
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T>> n;

        public PublishSource(java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T>> atomicReference) {
            this.n = atomicReference;
        }

        @Override // io.reactivex.ObservableSource
        public void subscribe(io.reactivex.Observer<? super T> observer) {
            io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable innerDisposable = new io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T> publishObserver = this.n.get();
                if (publishObserver == null || publishObserver.isDisposed()) {
                    io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T> publishObserver2 = new io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<>(this.n);
                    if (defpackage.xv0.a(this.n, publishObserver, publishObserver2)) {
                        publishObserver = publishObserver2;
                    } else {
                        continue;
                    }
                }
                if (publishObserver.a(innerDisposable)) {
                    innerDisposable.setParent(publishObserver);
                    return;
                }
            }
        }
    }

    public ObservablePublish(io.reactivex.ObservableSource<T> observableSource, io.reactivex.ObservableSource<T> observableSource2, java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T>> atomicReference) {
        this.u = observableSource;
        this.n = observableSource2;
        this.t = atomicReference;
    }

    public static <T> io.reactivex.observables.ConnectableObservable<T> create(io.reactivex.ObservableSource<T> observableSource) {
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        return io.reactivex.plugins.RxJavaPlugins.onAssembly((io.reactivex.observables.ConnectableObservable) new io.reactivex.internal.operators.observable.ObservablePublish(new io.reactivex.internal.operators.observable.ObservablePublish.PublishSource(atomicReference), observableSource, atomicReference));
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void connect(io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T> publishObserver;
        while (true) {
            publishObserver = this.t.get();
            if (publishObserver != null && !publishObserver.isDisposed()) {
                break;
            }
            io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<T> publishObserver2 = new io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver<>(this.t);
            if (defpackage.xv0.a(this.t, publishObserver, publishObserver2)) {
                publishObserver = publishObserver2;
                break;
            }
        }
        boolean z = false;
        if (!publishObserver.u.get() && publishObserver.u.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(publishObserver);
            if (z) {
                this.n.subscribe(publishObserver);
            }
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.operators.observable.ObservablePublishClassic
    public io.reactivex.ObservableSource<T> publishSource() {
        return this.n;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamObservableSource
    public io.reactivex.ObservableSource<T> source() {
        return this.n;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.u.subscribe(observer);
    }
}
