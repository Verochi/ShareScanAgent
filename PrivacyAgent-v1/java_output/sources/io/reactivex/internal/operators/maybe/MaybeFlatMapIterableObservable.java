package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybeFlatMapIterableObservable<T, R> extends io.reactivex.Observable<R> {
    public final io.reactivex.MaybeSource<T> n;
    public final io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> t;

    public static final class FlatMapIterableObserver<T, R> extends io.reactivex.internal.observers.BasicQueueDisposable<R> implements io.reactivex.MaybeObserver<T> {
        public final io.reactivex.Observer<? super R> n;
        public final io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> t;
        public io.reactivex.disposables.Disposable u;
        public volatile java.util.Iterator<? extends R> v;
        public volatile boolean w;
        public boolean x;

        public FlatMapIterableObserver(io.reactivex.Observer<? super R> observer, io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> function) {
            this.n = observer;
            this.t = function;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.v = null;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.w = true;
            this.u.dispose();
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.v == null;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            io.reactivex.Observer<? super R> observer = this.n;
            try {
                java.util.Iterator<? extends R> it = this.t.apply(t).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                    return;
                }
                this.v = it;
                if (this.x) {
                    observer.onNext(null);
                    observer.onComplete();
                    return;
                }
                while (!this.w) {
                    try {
                        observer.onNext(it.next());
                        if (this.w) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                observer.onComplete();
                                return;
                            }
                        } catch (java.lang.Throwable th) {
                            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                            observer.onError(th);
                            return;
                        }
                    } catch (java.lang.Throwable th2) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                        observer.onError(th2);
                        return;
                    }
                }
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                observer.onError(th3);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public R poll() throws java.lang.Exception {
            java.util.Iterator<? extends R> it = this.v;
            if (it == null) {
                return null;
            }
            R r = (R) io.reactivex.internal.functions.ObjectHelper.requireNonNull(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.v = null;
            }
            return r;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.x = true;
            return 2;
        }
    }

    public MaybeFlatMapIterableObservable(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.Function<? super T, ? extends java.lang.Iterable<? extends R>> function) {
        this.n = maybeSource;
        this.t = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        this.n.subscribe(new io.reactivex.internal.operators.maybe.MaybeFlatMapIterableObservable.FlatMapIterableObserver(observer, this.t));
    }
}
