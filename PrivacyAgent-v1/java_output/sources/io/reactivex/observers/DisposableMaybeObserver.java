package io.reactivex.observers;

/* loaded from: classes13.dex */
public abstract class DisposableMaybeObserver<T> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> n = new java.util.concurrent.atomic.AtomicReference<>();

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        io.reactivex.internal.disposables.DisposableHelper.dispose(this.n);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.n.get() == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
    }

    public void onStart() {
    }

    @Override // io.reactivex.MaybeObserver
    public final void onSubscribe(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable disposable) {
        if (io.reactivex.internal.util.EndConsumerHelper.setOnce(this.n, disposable, getClass())) {
            onStart();
        }
    }
}
