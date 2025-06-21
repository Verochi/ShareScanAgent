package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableGenerate<T, S> extends io.reactivex.Observable<T> {
    public final java.util.concurrent.Callable<S> n;
    public final io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> t;
    public final io.reactivex.functions.Consumer<? super S> u;

    public static final class GeneratorDisposable<T, S> implements io.reactivex.Emitter<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public final io.reactivex.functions.BiFunction<S, ? super io.reactivex.Emitter<T>, S> t;
        public final io.reactivex.functions.Consumer<? super S> u;
        public S v;
        public volatile boolean w;
        public boolean x;
        public boolean y;

        public GeneratorDisposable(io.reactivex.Observer<? super T> observer, io.reactivex.functions.BiFunction<S, ? super io.reactivex.Emitter<T>, S> biFunction, io.reactivex.functions.Consumer<? super S> consumer, S s2) {
            this.n = observer;
            this.t = biFunction;
            this.u = consumer;
            this.v = s2;
        }

        public final void a(S s2) {
            try {
                this.u.accept(s2);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        public void b() {
            S s2 = this.v;
            if (this.w) {
                this.v = null;
                a(s2);
                return;
            }
            io.reactivex.functions.BiFunction<S, ? super io.reactivex.Emitter<T>, S> biFunction = this.t;
            while (!this.w) {
                this.y = false;
                try {
                    s2 = biFunction.apply(s2, this);
                    if (this.x) {
                        this.w = true;
                        this.v = null;
                        a(s2);
                        return;
                    }
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    this.v = null;
                    this.w = true;
                    onError(th);
                    a(s2);
                    return;
                }
            }
            this.v = null;
            a(s2);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.w = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w;
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.x) {
                return;
            }
            this.x = true;
            this.n.onComplete();
        }

        @Override // io.reactivex.Emitter
        public void onError(java.lang.Throwable th) {
            if (this.x) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            if (th == null) {
                th = new java.lang.NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.x = true;
            this.n.onError(th);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t) {
            if (this.x) {
                return;
            }
            if (this.y) {
                onError(new java.lang.IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new java.lang.NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.y = true;
                this.n.onNext(t);
            }
        }
    }

    public ObservableGenerate(java.util.concurrent.Callable<S> callable, io.reactivex.functions.BiFunction<S, io.reactivex.Emitter<T>, S> biFunction, io.reactivex.functions.Consumer<? super S> consumer) {
        this.n = callable;
        this.t = biFunction;
        this.u = consumer;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        try {
            io.reactivex.internal.operators.observable.ObservableGenerate.GeneratorDisposable generatorDisposable = new io.reactivex.internal.operators.observable.ObservableGenerate.GeneratorDisposable(observer, this.t, this.u, this.n.call());
            observer.onSubscribe(generatorDisposable);
            generatorDisposable.b();
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            io.reactivex.internal.disposables.EmptyDisposable.error(th, observer);
        }
    }
}
