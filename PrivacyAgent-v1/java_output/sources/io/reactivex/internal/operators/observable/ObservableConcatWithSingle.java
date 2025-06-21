package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableConcatWithSingle<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.SingleSource<? extends T> n;

    public static final class ConcatWithObserver<T> extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.Observer<T>, io.reactivex.SingleObserver<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -1953724749712440952L;
        final io.reactivex.Observer<? super T> downstream;
        boolean inSingle;
        io.reactivex.SingleSource<? extends T> other;

        public ConcatWithObserver(io.reactivex.Observer<? super T> observer, io.reactivex.SingleSource<? extends T> singleSource) {
            this.downstream = observer;
            this.other = singleSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.inSingle = true;
            io.reactivex.internal.disposables.DisposableHelper.replace(this, null);
            io.reactivex.SingleSource<? extends T> singleSource = this.other;
            this.other = null;
            singleSource.subscribe(this);
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (!io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable) || this.inSingle) {
                return;
            }
            this.downstream.onSubscribe(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }
    }

    public ObservableConcatWithSingle(io.reactivex.Observable<T> observable, io.reactivex.SingleSource<? extends T> singleSource) {
        super(observable);
        this.n = singleSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableConcatWithSingle.ConcatWithObserver(observer, this.n));
    }
}
