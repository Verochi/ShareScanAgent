package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableTakeLastOne<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {

    public static final class TakeLastOneObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super T> n;
        public io.reactivex.disposables.Disposable t;
        public T u;

        public TakeLastOneObserver(io.reactivex.Observer<? super T> observer) {
            this.n = observer;
        }

        public void a() {
            T t = this.u;
            if (t != null) {
                this.u = null;
                this.n.onNext(t);
            }
            this.n.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.u = null;
            this.t.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.u = null;
            this.n.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.u = t;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLastOne(io.reactivex.ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableTakeLastOne.TakeLastOneObserver(observer));
    }
}
