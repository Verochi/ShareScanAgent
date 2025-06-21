package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableElementAt<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final long n;
    public final T t;
    public final boolean u;

    public static final class ElementAtObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public final long t;
        public final T u;
        public final boolean v;
        public io.reactivex.disposables.Disposable w;
        public long x;
        public boolean y;

        public ElementAtObserver(io.reactivex.Observer<? super T> observer, long j, T t, boolean z) {
            this.n = observer;
            this.t = j;
            this.u = t;
            this.v = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.y) {
                return;
            }
            this.y = true;
            T t = this.u;
            if (t == null && this.v) {
                this.n.onError(new java.util.NoSuchElementException());
                return;
            }
            if (t != null) {
                this.n.onNext(t);
            }
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.y) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.y = true;
                this.n.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.y) {
                return;
            }
            long j = this.x;
            if (j != this.t) {
                this.x = j + 1;
                return;
            }
            this.y = true;
            this.w.dispose();
            this.n.onNext(t);
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.w, disposable)) {
                this.w = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(io.reactivex.ObservableSource<T> observableSource, long j, T t, boolean z) {
        super(observableSource);
        this.n = j;
        this.t = t;
        this.u = z;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableElementAt.ElementAtObserver(observer, this.n, this.t, this.u));
    }
}
