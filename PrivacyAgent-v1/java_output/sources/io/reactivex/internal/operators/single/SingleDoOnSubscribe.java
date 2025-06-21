package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleDoOnSubscribe<T> extends io.reactivex.Single<T> {
    public final io.reactivex.SingleSource<T> n;
    public final io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> t;

    public static final class DoOnSubscribeSingleObserver<T> implements io.reactivex.SingleObserver<T> {
        public final io.reactivex.SingleObserver<? super T> n;
        public final io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> t;
        public boolean u;

        public DoOnSubscribeSingleObserver(io.reactivex.SingleObserver<? super T> singleObserver, io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
            this.n = singleObserver;
            this.t = consumer;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            try {
                this.t.accept(disposable);
                this.n.onSubscribe(disposable);
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.u = true;
                disposable.dispose();
                io.reactivex.internal.disposables.EmptyDisposable.error(th, this.n);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            if (this.u) {
                return;
            }
            this.n.onSuccess(t);
        }
    }

    public SingleDoOnSubscribe(io.reactivex.SingleSource<T> singleSource, io.reactivex.functions.Consumer<? super io.reactivex.disposables.Disposable> consumer) {
        this.n = singleSource;
        this.t = consumer;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super T> singleObserver) {
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleDoOnSubscribe.DoOnSubscribeSingleObserver(singleObserver, this.t));
    }
}
