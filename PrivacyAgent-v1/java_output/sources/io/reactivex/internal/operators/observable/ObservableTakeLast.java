package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableTakeLast<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final int n;

    public static final class TakeLastObserver<T> extends java.util.ArrayDeque<T> implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = 7240042530241604978L;
        volatile boolean cancelled;
        final int count;
        final io.reactivex.Observer<? super T> downstream;
        io.reactivex.disposables.Disposable upstream;

        public TakeLastObserver(io.reactivex.Observer<? super T> observer, int i) {
            this.downstream = observer;
            this.count = i;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            io.reactivex.Observer<? super T> observer = this.downstream;
            while (!this.cancelled) {
                T poll = poll();
                if (poll == null) {
                    if (this.cancelled) {
                        return;
                    }
                    observer.onComplete();
                    return;
                }
                observer.onNext(poll);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.count == size()) {
                poll();
            }
            offer(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLast(io.reactivex.ObservableSource<T> observableSource, int i) {
        super(observableSource);
        this.n = i;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.source.subscribe(new io.reactivex.internal.operators.observable.ObservableTakeLast.TakeLastObserver(observer, this.n));
    }
}
