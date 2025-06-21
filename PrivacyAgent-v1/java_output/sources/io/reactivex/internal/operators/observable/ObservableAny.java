package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableAny<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, java.lang.Boolean> {
    public final io.reactivex.functions.Predicate<? super T> n;

    public static final class AnyObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super java.lang.Boolean> n;
        public final io.reactivex.functions.Predicate<? super T> t;
        public io.reactivex.disposables.Disposable u;
        public boolean v;

        public AnyObserver(io.reactivex.Observer<? super java.lang.Boolean> observer, io.reactivex.functions.Predicate<? super T> predicate) {
            this.n = observer;
            this.t = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.u.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.v) {
                return;
            }
            this.v = true;
            this.n.onNext(java.lang.Boolean.FALSE);
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.v) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.v = true;
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.v) {
                return;
            }
            try {
                if (this.t.test(t)) {
                    this.v = true;
                    this.u.dispose();
                    this.n.onNext(java.lang.Boolean.TRUE);
                    this.n.onComplete();
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.u.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableAny(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Predicate<? super T> predicate) {
        super(observableSource);
        this.n = predicate;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super java.lang.Boolean> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableAny.AnyObserver(observer, this.n));
    }
}
