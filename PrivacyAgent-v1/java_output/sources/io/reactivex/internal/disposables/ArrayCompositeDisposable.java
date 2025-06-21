package io.reactivex.internal.disposables;

/* loaded from: classes9.dex */
public final class ArrayCompositeDisposable extends java.util.concurrent.atomic.AtomicReferenceArray<io.reactivex.disposables.Disposable> implements io.reactivex.disposables.Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i) {
        super(i);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        io.reactivex.disposables.Disposable andSet;
        if (get(0) != io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                io.reactivex.disposables.Disposable disposable = get(i);
                io.reactivex.internal.disposables.DisposableHelper disposableHelper = io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
                if (disposable != disposableHelper && (andSet = getAndSet(i, disposableHelper)) != disposableHelper && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get(0) == io.reactivex.internal.disposables.DisposableHelper.DISPOSED;
    }

    public io.reactivex.disposables.Disposable replaceResource(int i, io.reactivex.disposables.Disposable disposable) {
        io.reactivex.disposables.Disposable disposable2;
        do {
            disposable2 = get(i);
            if (disposable2 == io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                disposable.dispose();
                return null;
            }
        } while (!compareAndSet(i, disposable2, disposable));
        return disposable2;
    }

    public boolean setResource(int i, io.reactivex.disposables.Disposable disposable) {
        io.reactivex.disposables.Disposable disposable2;
        do {
            disposable2 = get(i);
            if (disposable2 == io.reactivex.internal.disposables.DisposableHelper.DISPOSED) {
                disposable.dispose();
                return false;
            }
        } while (!compareAndSet(i, disposable2, disposable));
        if (disposable2 == null) {
            return true;
        }
        disposable2.dispose();
        return true;
    }
}
