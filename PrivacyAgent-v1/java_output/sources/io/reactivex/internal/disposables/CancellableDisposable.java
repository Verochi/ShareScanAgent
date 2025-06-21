package io.reactivex.internal.disposables;

/* loaded from: classes9.dex */
public final class CancellableDisposable extends java.util.concurrent.atomic.AtomicReference<io.reactivex.functions.Cancellable> implements io.reactivex.disposables.Disposable {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(io.reactivex.functions.Cancellable cancellable) {
        super(cancellable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        io.reactivex.functions.Cancellable andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (java.lang.Exception e) {
            io.reactivex.exceptions.Exceptions.throwIfFatal(e);
            io.reactivex.plugins.RxJavaPlugins.onError(e);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get() == null;
    }
}
