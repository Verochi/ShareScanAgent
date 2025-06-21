package io.reactivex.internal.operators.maybe;

/* loaded from: classes11.dex */
public final class MaybePeek<T> extends io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream<T, T> {
    public final io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> n;
    public final io.reactivex.functions.Consumer<? super T> t;
    public final io.reactivex.functions.Consumer<? super java.lang.Throwable> u;
    public final io.reactivex.functions.Action v;
    public final io.reactivex.functions.Action w;
    public final io.reactivex.functions.Action x;

    public static final class MaybePeekObserver<T> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.MaybeObserver<? super T> n;
        public final io.reactivex.internal.operators.maybe.MaybePeek<T> t;
        public io.reactivex.disposables.Disposable u;

        public MaybePeekObserver(io.reactivex.MaybeObserver<? super T> maybeObserver, io.reactivex.internal.operators.maybe.MaybePeek<T> maybePeek) {
            this.n = maybeObserver;
            this.t = maybePeek;
        }

        public void a() {
            try {
                this.t.w.run();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
        }

        public void b(java.lang.Throwable th) {
            try {
                this.t.u.accept(th);
            } catch (java.lang.Throwable th2) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th2);
                th = new io.reactivex.exceptions.CompositeException(th, th2);
            }
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            this.n.onError(th);
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            try {
                this.t.x.run();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
            this.u.dispose();
            this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.isDisposed();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            io.reactivex.disposables.Disposable disposable = this.u;
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                return;
            }
            try {
                this.t.v.run();
                this.u = disposableHelper;
                this.n.onComplete();
                a();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                b(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(java.lang.Throwable th) {
            if (this.u == io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                b(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                try {
                    this.t.n.accept(disposable);
                    this.u = disposable;
                    this.n.onSubscribe(this);
                } catch (java.lang.Throwable th) {
                    io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                    disposable.dispose();
                    this.u = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
                    io.reactivex.internal.disposables.EmptyDisposable.error(th, this.n);
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            io.reactivex.disposables.Disposable disposable = this.u;
            io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                return;
            }
            try {
                this.t.t.accept(t);
                this.u = disposableHelper;
                this.n.onSuccess(t);
                a();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                b(th);
            }
        }
    }

    public MaybePeek(io.reactivex.MaybeSource<T> maybeSource, io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer, io.reactivex.functions.Consumer<? super T> consumer2, io.reactivex.functions.Consumer<? super java.lang.Throwable> consumer3, io.reactivex.functions.Action action, io.reactivex.functions.Action action2, io.reactivex.functions.Action action3) {
        super(maybeSource);
        this.n = consumer;
        this.t = consumer2;
        this.u = consumer3;
        this.v = action;
        this.w = action2;
        this.x = action3;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(io.reactivex.MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe(new io.reactivex.internal.operators.maybe.MaybePeek.MaybePeekObserver(maybeObserver, this));
    }
}
