package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableZip<T, R> extends io.reactivex.Observable<R> {
    public final io.reactivex.ObservableSource<? extends T>[] n;
    public final java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> t;
    public final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> u;
    public final int v;
    public final boolean w;

    public static final class ZipCoordinator<T, R> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final io.reactivex.Observer<? super R> downstream;
        final io.reactivex.internal.operators.observable.ObservableZip.ZipObserver<T, R>[] observers;
        final T[] row;
        final io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> zipper;

        public ZipCoordinator(io.reactivex.Observer<? super R> observer, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i, boolean z) {
            this.downstream = observer;
            this.zipper = function;
            this.observers = new io.reactivex.internal.operators.observable.ObservableZip.ZipObserver[i];
            this.row = (T[]) new java.lang.Object[i];
            this.delayError = z;
        }

        public void cancel() {
            clear();
            cancelSources();
        }

        public void cancelSources() {
            for (io.reactivex.internal.operators.observable.ObservableZip.ZipObserver<T, R> zipObserver : this.observers) {
                zipObserver.a();
            }
        }

        public boolean checkTerminated(boolean z, boolean z2, io.reactivex.Observer<? super R> observer, boolean z3, io.reactivex.internal.operators.observable.ObservableZip.ZipObserver<?, ?> zipObserver) {
            if (this.cancelled) {
                cancel();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                java.lang.Throwable th = zipObserver.v;
                this.cancelled = true;
                cancel();
                if (th != null) {
                    observer.onError(th);
                } else {
                    observer.onComplete();
                }
                return true;
            }
            java.lang.Throwable th2 = zipObserver.v;
            if (th2 != null) {
                this.cancelled = true;
                cancel();
                observer.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.cancelled = true;
            cancel();
            observer.onComplete();
            return true;
        }

        public void clear() {
            for (io.reactivex.internal.operators.observable.ObservableZip.ZipObserver<T, R> zipObserver : this.observers) {
                zipObserver.t.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void drain() {
            java.lang.Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.operators.observable.ObservableZip.ZipObserver<T, R>[] zipObserverArr = this.observers;
            io.reactivex.Observer<? super R> observer = this.downstream;
            T[] tArr = this.row;
            boolean z = this.delayError;
            int i = 1;
            while (true) {
                int i2 = 0;
                int i3 = 0;
                for (io.reactivex.internal.operators.observable.ObservableZip.ZipObserver<T, R> zipObserver : zipObserverArr) {
                    if (tArr[i3] == null) {
                        boolean z2 = zipObserver.u;
                        T poll = zipObserver.t.poll();
                        boolean z3 = poll == null;
                        if (checkTerminated(z2, z3, observer, z, zipObserver)) {
                            return;
                        }
                        if (z3) {
                            i2++;
                        } else {
                            tArr[i3] = poll;
                        }
                    } else if (zipObserver.u && !z && (th = zipObserver.v) != null) {
                        this.cancelled = true;
                        cancel();
                        observer.onError(th);
                        return;
                    }
                    i3++;
                }
                if (i2 != 0) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    try {
                        observer.onNext((java.lang.Object) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                        java.util.Arrays.fill(tArr, (java.lang.Object) null);
                    } catch (java.lang.Throwable th2) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                        cancel();
                        observer.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(io.reactivex.ObservableSource<? extends T>[] observableSourceArr, int i) {
            io.reactivex.internal.operators.observable.ObservableZip.ZipObserver<T, R>[] zipObserverArr = this.observers;
            int length = zipObserverArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                zipObserverArr[i2] = new io.reactivex.internal.operators.observable.ObservableZip.ZipObserver<>(this, i);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i3 = 0; i3 < length && !this.cancelled; i3++) {
                observableSourceArr[i3].subscribe(zipObserverArr[i3]);
            }
        }
    }

    public static final class ZipObserver<T, R> implements io.reactivex.Observer<T> {
        public final io.reactivex.internal.operators.observable.ObservableZip.ZipCoordinator<T, R> n;
        public final io.reactivex.internal.queue.SpscLinkedArrayQueue<T> t;
        public volatile boolean u;
        public java.lang.Throwable v;
        public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> w = new java.util.concurrent.atomic.AtomicReference<>();

        public ZipObserver(io.reactivex.internal.operators.observable.ObservableZip.ZipCoordinator<T, R> zipCoordinator, int i) {
            this.n = zipCoordinator;
            this.t = new io.reactivex.internal.queue.SpscLinkedArrayQueue<>(i);
        }

        public void a() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.w);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.u = true;
            this.n.drain();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.v = th;
            this.u = true;
            this.n.drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.t.offer(t);
            this.n.drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.w, disposable);
        }
    }

    public ObservableZip(io.reactivex.ObservableSource<? extends T>[] observableSourceArr, java.lang.Iterable<? extends io.reactivex.ObservableSource<? extends T>> iterable, io.reactivex.functions.Function<? super java.lang.Object[], ? extends R> function, int i, boolean z) {
        this.n = observableSourceArr;
        this.t = iterable;
        this.u = function;
        this.v = i;
        this.w = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        int length;
        io.reactivex.ObservableSource<? extends T>[] observableSourceArr = this.n;
        if (observableSourceArr == null) {
            observableSourceArr = new io.reactivex.ObservableSource[8];
            length = 0;
            for (io.reactivex.ObservableSource<? extends T> observableSource : this.t) {
                if (length == observableSourceArr.length) {
                    io.reactivex.ObservableSource<? extends T>[] observableSourceArr2 = new io.reactivex.ObservableSource[(length >> 2) + length];
                    java.lang.System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[length] = observableSource;
                length++;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            io.reactivex.internal.disposables.EmptyDisposable.complete(observer);
        } else {
            new io.reactivex.internal.operators.observable.ObservableZip.ZipCoordinator(observer, this.u, length, this.w).subscribe(observableSourceArr, this.v);
        }
    }
}
