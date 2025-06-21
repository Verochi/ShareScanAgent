package io.reactivex.internal.operators.single;

/* loaded from: classes13.dex */
public final class SingleEquals<T> extends io.reactivex.Single<java.lang.Boolean> {
    public final io.reactivex.SingleSource<? extends T> n;
    public final io.reactivex.SingleSource<? extends T> t;

    public static class InnerObserver<T> implements io.reactivex.SingleObserver<T> {
        public final int n;
        public final io.reactivex.disposables.CompositeDisposable t;
        public final java.lang.Object[] u;
        public final io.reactivex.SingleObserver<? super java.lang.Boolean> v;
        public final java.util.concurrent.atomic.AtomicInteger w;

        public InnerObserver(int i, io.reactivex.disposables.CompositeDisposable compositeDisposable, java.lang.Object[] objArr, io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver, java.util.concurrent.atomic.AtomicInteger atomicInteger) {
            this.n = i;
            this.t = compositeDisposable;
            this.u = objArr;
            this.v = singleObserver;
            this.w = atomicInteger;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(java.lang.Throwable th) {
            int i;
            do {
                i = this.w.get();
                if (i >= 2) {
                    io.reactivex.plugins.RxJavaPlugins.onError(th);
                    return;
                }
            } while (!this.w.compareAndSet(i, 2));
            this.t.dispose();
            this.v.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(io.reactivex.disposables.Disposable disposable) {
            this.t.add(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.u[this.n] = t;
            if (this.w.incrementAndGet() == 2) {
                io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver = this.v;
                java.lang.Object[] objArr = this.u;
                singleObserver.onSuccess(java.lang.Boolean.valueOf(io.reactivex.internal.functions.ObjectHelper.equals(objArr[0], objArr[1])));
            }
        }
    }

    public SingleEquals(io.reactivex.SingleSource<? extends T> singleSource, io.reactivex.SingleSource<? extends T> singleSource2) {
        this.n = singleSource;
        this.t = singleSource2;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(io.reactivex.SingleObserver<? super java.lang.Boolean> singleObserver) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger();
        java.lang.Object[] objArr = {null, null};
        io.reactivex.disposables.CompositeDisposable compositeDisposable = new io.reactivex.disposables.CompositeDisposable();
        singleObserver.onSubscribe(compositeDisposable);
        this.n.subscribe(new io.reactivex.internal.operators.single.SingleEquals.InnerObserver(0, compositeDisposable, objArr, singleObserver, atomicInteger));
        this.t.subscribe(new io.reactivex.internal.operators.single.SingleEquals.InnerObserver(1, compositeDisposable, objArr, singleObserver, atomicInteger));
    }
}
