package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableDematerialize<T, R> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, R> {
    public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.Notification<R>> n;

    public static final class DematerializeObserver<T, R> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        public final io.reactivex.Observer<? super R> n;
        public final io.reactivex.functions.Function<? super T, ? extends io.reactivex.Notification<R>> t;
        public boolean u;
        public io.reactivex.disposables.Disposable v;

        public DematerializeObserver(io.reactivex.Observer<? super R> observer, io.reactivex.functions.Function<? super T, ? extends io.reactivex.Notification<R>> function) {
            this.n = observer;
            this.t = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.v.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.v.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.u) {
                return;
            }
            this.u = true;
            this.n.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            if (this.u) {
                io.reactivex.plugins.RxJavaPlugins.onError(th);
            } else {
                this.u = true;
                this.n.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.u) {
                if (t instanceof io.reactivex.Notification) {
                    io.reactivex.Notification notification = (io.reactivex.Notification) t;
                    if (notification.isOnError()) {
                        io.reactivex.plugins.RxJavaPlugins.onError(notification.getError());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                io.reactivex.Notification notification2 = (io.reactivex.Notification) io.reactivex.internal.functions.ObjectHelper.requireNonNull(this.t.apply(t), "The selector returned a null Notification");
                if (notification2.isOnError()) {
                    this.v.dispose();
                    onError(notification2.getError());
                } else if (!notification2.isOnComplete()) {
                    this.n.onNext((java.lang.Object) notification2.getValue());
                } else {
                    this.v.dispose();
                    onComplete();
                }
            } catch (java.lang.Throwable th) {
                io.reactivex.exceptions.Exceptions.throwIfFatal(th);
                this.v.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.v, disposable)) {
                this.v = disposable;
                this.n.onSubscribe(this);
            }
        }
    }

    public ObservableDematerialize(io.reactivex.ObservableSource<T> observableSource, io.reactivex.functions.Function<? super T, ? extends io.reactivex.Notification<R>> function) {
        super(observableSource);
        this.n = function;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super R> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableDematerialize.DematerializeObserver(observer, this.n));
    }
}
