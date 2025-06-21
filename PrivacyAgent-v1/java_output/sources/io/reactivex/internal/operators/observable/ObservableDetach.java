package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDetach<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {

    public static final class DetachObserver<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public io.reactivex.Observer<? super T> n;
        public io.reactivex.disposables.Disposable t;

        public DetachObserver(io.reactivex.Observer<? super T> observer) {
            this.n = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.disposables.Disposable disposable = this.t;
            this.t = io.reactivex.internal.util.EmptyComponent.INSTANCE;
            this.n = io.reactivex.internal.util.EmptyComponent.asObserver();
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            io.reactivex.Observer<? super T> observer = this.n;
            this.t = io.reactivex.internal.util.EmptyComponent.INSTANCE;
            this.n = io.reactivex.internal.util.EmptyComponent.asObserver();
            observer.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.Observer<? super T> observer = this.n;
            this.t = io.reactivex.internal.util.EmptyComponent.INSTANCE;
            this.n = io.reactivex.internal.util.EmptyComponent.asObserver();
            observer.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.n.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableDetach(io.reactivex.ObservableSource<T> observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableDetach.DetachObserver(observer));
    }
}
