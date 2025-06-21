package io.reactivex.observers;

/* loaded from: classes13.dex */
public abstract class ResourceMaybeObserver<T> implements io.reactivex.MaybeObserver<T>, io.reactivex.disposables.Disposable {
    public final java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> n = new java.util.concurrent.atomic.AtomicReference<>();
    public final io.reactivex.internal.disposables.ListCompositeDisposable t = new io.reactivex.internal.disposables.ListCompositeDisposable();

    public final void add(@io.reactivex.annotations.NonNull io.reactivex.disposables.Disposable disposable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "resource is null");
        this.t.add(disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (io.reactivex.internal.disposables.DisposableHelper.dispose(this.n)) {
            this.t.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return io.reactivex.internal.disposables.DisposableHelper.isDisposed(this.n.get());
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
