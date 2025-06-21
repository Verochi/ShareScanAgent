package io.reactivex.internal.operators.mixed;

/* loaded from: classes11.dex */
public final class ObservableConcatMapCompletable<T> extends io.reactivex.Completable {
    public final io.reactivex.Observable<T> n;
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> t;
    public final io.reactivex.internal.util.ErrorMode u;
    public final int v;

    public static final class ConcatMapCompletableObserver<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final io.reactivex.CompletableObserver downstream;
        final io.reactivex.internal.util.ErrorMode errorMode;
        final io.reactivex.internal.util.AtomicThrowable errors = new io.reactivex.internal.util.AtomicThrowable();
        final io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable.ConcatMapCompletableObserver.ConcatMapInnerObserver inner = new io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable.ConcatMapCompletableObserver.ConcatMapInnerObserver(this);
        final io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> mapper;
        final int prefetch;
        io.reactivex.internal.fuseable.SimpleQueue<T> queue;
        io.reactivex.disposables.Disposable upstream;

        public static final class ConcatMapInnerObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            final io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable.ConcatMapCompletableObserver<?> parent;

            public ConcatMapInnerObserver(io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable.ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            public void dispose() {
                io.reactivex.internal.disposables.DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(java.lang.Throwable th) {
                this.parent.innerError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapCompletableObserver(io.reactivex.CompletableObserver completableObserver, io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, io.reactivex.internal.util.ErrorMode errorMode, int i) {
            this.downstream = completableObserver;
            this.mapper = function;
            this.errorMode = errorMode;
            this.prefetch = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void drain() {
            io.reactivex.CompletableSource completableSource;
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.util.AtomicThrowable atomicThrowable = this.errors;
            io.reactivex.internal.util.ErrorMode errorMode = this.errorMode;
            while (!this.disposed) {
                if (!this.active) {
                    if (errorMode == io.reactivex.internal.util.ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                        this.disposed = true;
                        this.queue.clear();
                        this.downstream.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    try {
                        T poll = this.queue.poll();
                        if (poll != null) {
                            completableSource = (io.reactivex.CompletableSource) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                            z = false;
                        } else {
                            completableSource = null;
                            z = true;
                        }
                        if (z2 && z) {
                            this.disposed = true;
                            java.lang.Throwable terminate = atomicThrowable.terminate();
                            if (terminate != null) {
                                this.downstream.onError(terminate);
                                return;
                            } else {
                                this.downstream.onComplete();
                                return;
                            }
                        }
                        if (!z) {
                            this.active = true;
                            completableSource.subscribe(this.inner);
                        }
                    } catch (java.lang.Throwable th) {
                        io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                        this.disposed = true;
                        this.queue.clear();
                        this.upstream.dispose();
                        atomicThrowable.addThrowable(th);
                        this.downstream.onError(atomicThrowable.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        public void innerComplete() {
            this.active = false;
            drain();
        }

        public void innerError(java.lang.Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (this.errorMode != io.reactivex.internal.util.ErrorMode.IMMEDIATE) {
                this.active = false;
                drain();
                return;
            }
            this.disposed = true;
            this.upstream.dispose();
            java.lang.Throwable terminate = this.errors.terminate();
            if (terminate != io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                this.downstream.onError(terminate);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (this.errorMode != io.reactivex.internal.util.ErrorMode.IMMEDIATE) {
                this.done = true;
                drain();
                return;
            }
            this.disposed = true;
            this.inner.dispose();
            java.lang.Throwable terminate = this.errors.terminate();
            if (terminate != io.reactivex.internal.util.ExceptionHelper.TERMINATED) {
                this.downstream.onError(terminate);
            }
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (t != null) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof io.reactivex.internal.fuseable.QueueDisposable) {
                    io.reactivex.internal.fuseable.QueueDisposable queueDisposable = (io.reactivex.internal.fuseable.QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.queue = queueDisposable;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.SpscLinkedArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapCompletable(io.reactivex.Observable<T> observable, io.reactivex.functions.Function<? super T, ? extends io.reactivex.CompletableSource> function, io.reactivex.internal.util.ErrorMode errorMode, int i) {
        this.n = observable;
        this.t = function;
        this.u = errorMode;
        this.v = i;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(io.reactivex.CompletableObserver completableObserver) {
        if (io.reactivex.internal.operators.mixed.ScalarXMapZHelper.a(this.n, this.t, completableObserver)) {
            return;
        }
        this.n.subscribe(new io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable.ConcatMapCompletableObserver(completableObserver, this.t, this.u, this.v));
    }
}
