package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDoOnEach<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.functions.Consumer<? super T> n;
    public final io.reactivex.functions.Consumer<? super java.lang.Throwable> t;
    public final io.reactivex.functions.Action u;
    public final io.reactivex.functions.Action v;

    public static final class DoOnEachObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public final io.reactivex.functions.Consumer<? super T> t;
        public final io.reactivex.functions.Consumer<? super java.lang.Throwable> u;
        public final io.reactivex.functions.Action v;
        public final io.reactivex.functions.Action w;
        public io.reactivex.disposables.Disposable x;
        public boolean y;

        public DoOnEachObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Action action2) {
            this.n = observer;
            this.t = consumer;
            this.u = consumer2;
            this.v = action;
            this.w = action2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.x.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.x.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.y) {
                return;
            }
            try {
                this.v.run();
                this.y = true;
                this.n.onComplete();
                try {
                    this.w.run();
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                }
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.y) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.y = true;
            try {
                this.u.accept(th);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                th = new io.reactivex.exceptions.CompositeException(th, th2);
            }
            this.n.onError(th);
            try {
                this.w.run();
            } catch (java.lang.Throwable th3) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th3);
                io.reactivex.plugins.RxJavaPlugins.onError(th3);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.y) {
                return;
            }
            try {
                this.t.accept(t);
                this.n.onNext(t);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.x.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.x, disposable)) {
                this.x = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableDoOnEach(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Consumer<? super T> consumer, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer2, io.reactivex.functions.Action action, io.reactivex.functions.Action action2) {
        super(observableSource);
        this.n = consumer;
        this.t = consumer2;
        this.u = action;
        this.v = action2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableDoOnEach.DoOnEachObserver(observer, this.n, this.t, this.u, this.v));
    }
}
