package io.reactivex.internal.operators.observable;

/* loaded from: classes13.dex */
public final class ObservableFromArray<T> extends io.reactivex.Observable<T> {
    public final T[] n;

    public static final class FromArrayDisposable<T> extends io.reactivex.internal.observers.BasicQueueDisposable<T> {
        public final io.reactivex.Observer<? super T> n;
        public final T[] t;
        public int u;
        public boolean v;
        public volatile boolean w;

        public FromArrayDisposable(io.reactivex.Observer<? super T> observer, T[] tArr) {
            this.n = observer;
            this.t = tArr;
        }

        public void a() {
            T[] tArr = this.t;
            int length = tArr.length;
            for (int i = 0; i < length && !isDisposed(); i++) {
                T t = tArr[i];
                if (t == null) {
                    this.n.onError(new java.lang.NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                this.n.onNext(t);
            }
            if (isDisposed()) {
                return;
            }
            this.n.onComplete();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.u = this.t.length;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.w = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.w;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.u == this.t.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @io.reactivex.annotations.Nullable
        public T poll() {
            int i = this.u;
            T[] tArr = this.t;
            if (i == tArr.length) {
                return null;
            }
            this.u = i + 1;
            return (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(tArr[i], "The array element is null");
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.v = true;
            return 1;
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.n = tArr;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(io.reactivex.Observer<? super T> observer) {
        io.reactivex.internal.operators.observable.ObservableFromArray.FromArrayDisposable fromArrayDisposable = new io.reactivex.internal.operators.observable.ObservableFromArray.FromArrayDisposable(observer, this.n);
        observer.onSubscribe(fromArrayDisposable);
        if (fromArrayDisposable.v) {
            return;
        }
        fromArrayDisposable.a();
    }
}
