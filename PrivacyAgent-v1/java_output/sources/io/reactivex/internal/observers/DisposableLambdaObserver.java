package io.reactivex.internal.observers;

/* loaded from: classes9.dex */
public final class DisposableLambdaObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
    public final io.reactivex.Observer<? super T> n;
    public final io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> t;
    public final io.reactivex.functions.Action u;
    public io.reactivex.disposables.Disposable v;

    public DisposableLambdaObserver(io.reactivex.Observer<? super T> observer, io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer, io.reactivex.functions.Action action) {
        this.n = observer;
        this.t = consumer;
        this.u = action;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        io.reactivex.disposables.Disposable disposable = this.v;
        io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.v = disposableHelper;
            try {
                this.u.run();
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            }
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.v.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        io.reactivex.disposables.Disposable disposable = this.v;
        io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.v = disposableHelper;
            this.n.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(java.lang.Throwable th) {
        io.reactivex.disposables.Disposable disposable = this.v;
        io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        if (disposable == disposableHelper) {
            io.reactivex.plugins.RxJavaPlugins.onError(th);
        } else {
            this.v = disposableHelper;
            this.n.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t) {
        this.n.onNext(t);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
        try {
            this.t.accept(disposable);
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.v, disposable)) {
                this.v = disposable;
                this.n.onSubscribe(this);
            }
        } catch (java.lang.Throwable th) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(th);
            disposable.dispose();
            this.v = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
            io.reactivex.internal.disposables.EmptyDisposable.error(th, this.n);
        }
    }
}
