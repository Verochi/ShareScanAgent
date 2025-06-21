package io.reactivex.internal.operators.completable;

/* loaded from: classes9.dex */
public final class CompletableToObservable<T> extends io.reactivex.Observable<T> {
    public final io.reactivex.CompletableSource n;

    public static final class ObserverCompletableObserver extends io.reactivex.internal.observers.BasicQueueDisposable<java.lang.Void> implements io.reactivex.CompletableObserver {
        public final io.reactivex.Observer<?> n;
        public io.reactivex.disposables.Disposable t;

        public ObserverCompletableObserver(io.reactivex.Observer<?> observer) {
            this.n = observer;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.lang.Void poll() throws java.lang.Exception {
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.t.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.t.isDisposed();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.n.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(java.lang.Throwable th) {
            this.n.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            if (io.reactivex.internal.disposables.DisposableHelper.validate(this.t, disposable)) {
                this.t = disposable;
                this.n.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            return i & 2;
        }
    }

    public CompletableToObservable(io.reactivex.CompletableSource completableSource) {
        this.n = completableSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        this.n.subscribe(new io.reactivex.internal.operators.completable.CompletableToObservable.ObserverCompletableObserver(observer));
    }
}
