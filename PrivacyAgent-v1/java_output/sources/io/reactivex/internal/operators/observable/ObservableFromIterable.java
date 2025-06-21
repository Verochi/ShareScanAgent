package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableFromIterable<T> extends io.reactivex.Observable<T> {
    public final java.lang.Iterable<? extends T> n;

    public static final class FromIterableDisposable<T> extends io.reactivex.internal.observers.BasicQueueDisposable<T> {
        public final io.reactivex.Observer<? super T> n;
        public final java.util.Iterator<? extends T> t;
        public volatile boolean u;
        public boolean v;
        public boolean w;
        public boolean x;

        public FromIterableDisposable(io.reactivex.Observer<? super T> observer, java.util.Iterator<? extends T> it) {
            this.n = observer;
            this.t = it;
        }

        public void a() {
            while (!isDisposed()) {
                try {
                    this.n.onNext(io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.t.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.n.onComplete();
                            return;
                        }
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        this.n.onError(th);
                        return;
                    }
                } catch (java.lang.Throwable th2) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                    this.n.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.w = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.w;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() {
            if (this.w) {
                return null;
            }
            if (!this.x) {
                this.x = true;
            } else if (!this.t.hasNext()) {
                this.w = true;
                return null;
            }
            return (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.next(), "The iterator returned a null value");
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.v = true;
            return 1;
        }
    }

    public ObservableFromIterable(java.lang.Iterable<? extends T> iterable) {
        this.n = iterable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        try {
            java.util.Iterator<? extends T> it = this.n.iterator();
            try {
                if (!it.hasNext()) {
                    io.reactivex.internal.disposables.EmptyDisposable.complete(observer);
                    return;
                }
                io.reactivex.internal.operators.observable.ObservableFromIterable.FromIterableDisposable fromIterableDisposable = new io.reactivex.internal.operators.observable.ObservableFromIterable.FromIterableDisposable(observer, it);
                observer.onSubscribe(fromIterableDisposable);
                if (fromIterableDisposable.v) {
                    return;
                }
                fromIterableDisposable.a();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
            }
        } catch (java.lang.Throwable th2) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
            io.reactivex.internal.disposables.EmptyDisposable.error(th2, observer);
        }
    }
}
