package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableMaterialize<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, io.reactivex.Notification<T>> {

    public static final class MaterializeObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super io.reactivex.Notification<T>> n;
        public io.reactivex.disposables.Disposable t;

        public MaterializeObserver(io.reactivex.Observer<? super io.reactivex.Notification<T>> observer) {
            this.n = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.t.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.n.onNext(io.reactivex.Notification.createOnComplete());
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.n.onNext(io.reactivex.Notification.createOnError(th));
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.n.onNext(io.reactivex.Notification.createOnNext(t));
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableMaterialize(io.reactivex.ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super io.reactivex.Notification<T>> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableMaterialize.MaterializeObserver(observer));
    }
}
