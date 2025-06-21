package io.reactivex.internal.disposables;

/* loaded from: classes9.dex */
public final class SequentialDisposable extends java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> implements io.reactivex.disposables.Disposable {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    public SequentialDisposable(io.reactivex.disposables.Disposable disposable) {
        lazySet(disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        io.reactivex.internal.disposables.DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return io.reactivex.internal.disposables.DisposableHelper.isDisposed(get());
    }

    public boolean replace(io.reactivex.disposables.Disposable disposable) {
        return io.reactivex.internal.disposables.DisposableHelper.replace(this, disposable);
    }

    public boolean update(io.reactivex.disposables.Disposable disposable) {
        return io.reactivex.internal.disposables.DisposableHelper.set(this, disposable);
    }
}
