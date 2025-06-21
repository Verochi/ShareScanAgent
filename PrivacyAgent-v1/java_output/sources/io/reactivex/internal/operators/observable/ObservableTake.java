package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableTake<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final long n;

    public static final class TakeObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public boolean t;
        public io.reactivex.disposables.Disposable u;
        public long v;

        public TakeObserver(io.reactivex.Observer<? super T> observer, long j) {
            this.n = observer;
            this.v = j;
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
            if (this.t) {
                return;
            }
            this.t = true;
            this.u.dispose();
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.t) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
                return;
            }
            this.t = true;
            this.u.dispose();
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.t) {
                return;
            }
            long j = this.v;
            long j2 = j - 1;
            this.v = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.n.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.u, disposable)) {
                this.u = disposable;
                if (this.v != 0) {
                    this.n.onSubscribe(this);
                    return;
                }
                this.t = true;
                disposable.dispose();
                io.reactivex.internal.disposables.EmptyDisposable.complete(this.n);
            }
        }
    }

    public ObservableTake(io.reactivex.ObservableSource<T> observableSource, long j) {
        super(observableSource);
        this.n = j;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableTake.TakeObserver(observer, this.n));
    }
}
