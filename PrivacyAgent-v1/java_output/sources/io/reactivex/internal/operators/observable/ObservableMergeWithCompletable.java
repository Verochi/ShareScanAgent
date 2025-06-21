package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableMergeWithCompletable<T> extends io.reactivex.internal.operators.observable.AbstractObservableWithUpstream<T, T> {
    public final io.reactivex.CompletableSource n;

    public static final class MergeWithObserver<T> extends java.util.concurrent.atomic.AtomicInteger implements io.reactivex.Observer<T>, io.reactivex.disposables.Disposable {
        private static final long serialVersionUID = -4592979584110982903L;
        final io.reactivex.Observer<? super T> downstream;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> mainDisposable = new java.util.concurrent.atomic.AtomicReference<>();
        final io.reactivex.internal.operators.observable.ObservableMergeWithCompletable.MergeWithObserver.OtherObserver otherObserver = new io.reactivex.internal.operators.observable.ObservableMergeWithCompletable.MergeWithObserver.OtherObserver(this);
        final io.reactivex.internal.util.AtomicThrowable error = new io.reactivex.internal.util.AtomicThrowable();

        public static final class OtherObserver extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;
            final io.reactivex.internal.operators.observable.ObservableMergeWithCompletable.MergeWithObserver<?> parent;

            public OtherObserver(io.reactivex.internal.operators.observable.ObservableMergeWithCompletable.MergeWithObserver<?> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(java.lang.Throwable th) {
                this.parent.otherError(th);
            }

            @Override // io.reactivex.CompletableObserver
            public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
                io.reactivex.internal.disposables.DisposableHelper.setOnce(this, disposable);
            }
        }

        public MergeWithObserver(io.reactivex.Observer<? super T> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.mainDisposable);
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            io.reactivex.internal.util.HalfSerializer.onNext(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            io.reactivex.internal.disposables.DisposableHelper.setOnce(this.mainDisposable, disposable);
        }

        public void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                io.reactivex.internal.util.HalfSerializer.onComplete(this.downstream, this, this.error);
            }
        }

        public void otherError(java.lang.Throwable th) {
            io.reactivex.internal.disposables.DisposableHelper.dispose(this.mainDisposable);
            io.reactivex.internal.util.HalfSerializer.onError(this.downstream, th, this, this.error);
        }
    }

    public ObservableMergeWithCompletable(io.reactivex.Observable<T> observable, io.reactivex.CompletableSource completableSource) {
        super(observable);
        this.n = completableSource;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservableMergeWithCompletable.MergeWithObserver mergeWithObserver = new io.reactivex.internal.operators.observable.ObservableMergeWithCompletable.MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.n.subscribe(mergeWithObserver.otherObserver);
    }
}
