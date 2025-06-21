package io.reactivex.observers;

/* loaded from: classes13.dex */
public abstract class DefaultObserver<T> implements io.reactivex.Observer<T> {
    public io.reactivex.disposables.Disposable n;

    public final void cancel() {
        io.reactivex.disposables.Disposable disposable = this.n;
        this.n = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
        disposable.dispose();
    }

    public void onStart() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable disposable) {
        if (io.reactivex.internal.util.EndConsumerHelper.validate(this.n, disposable, getClass())) {
            this.n = disposable;
            onStart();
        }
    }
}
