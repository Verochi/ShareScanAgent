package io.reactivex.internal.disposables;

/* loaded from: classes9.dex */
public enum DisposableHelper implements io.reactivex.disposables.Disposable {
    DISPOSED;

    public static boolean dispose(java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference) {
        io.reactivex.disposables.Disposable andSet;
        io.reactivex.disposables.Disposable disposable = atomicReference.get();
        io.reactivex.internal.disposables.DisposableHelper disposableHelper = DISPOSED;
        if (disposable == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean isDisposed(io.reactivex.disposables.Disposable disposable) {
        return disposable == DISPOSED;
    }

    public static boolean replace(java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference, io.reactivex.disposables.Disposable disposable) {
        io.reactivex.disposables.Disposable disposable2;
        do {
            disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable == null) {
                    return false;
                }
                disposable.dispose();
                return false;
            }
        } while (!defpackage.xv0.a(atomicReference, disposable2, disposable));
        return true;
    }

    public static void reportDisposableSet() {
        io.reactivex.plugins.RxJavaPlugins.onError(new io.reactivex.exceptions.ProtocolViolationException("Disposable already set!"));
    }

    public static boolean set(java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference, io.reactivex.disposables.Disposable disposable) {
        io.reactivex.disposables.Disposable disposable2;
        do {
            disposable2 = atomicReference.get();
            if (disposable2 == DISPOSED) {
                if (disposable == null) {
                    return false;
                }
                disposable.dispose();
                return false;
            }
        } while (!defpackage.xv0.a(atomicReference, disposable2, disposable));
        if (disposable2 == null) {
            return true;
        }
        disposable2.dispose();
        return true;
    }

    public static boolean setOnce(java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference, io.reactivex.disposables.Disposable disposable) {
        io.reactivex.internal.functions.ObjectHelper.requireNonNull(disposable, "d is null");
        if (defpackage.xv0.a(atomicReference, null, disposable)) {
            return true;
        }
        disposable.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        reportDisposableSet();
        return false;
    }

    public static boolean trySet(java.util.concurrent.atomic.AtomicReference<io.reactivex.disposables.Disposable> atomicReference, io.reactivex.disposables.Disposable disposable) {
        if (defpackage.xv0.a(atomicReference, null, disposable)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        disposable.dispose();
        return false;
    }

    public static boolean validate(io.reactivex.disposables.Disposable disposable, io.reactivex.disposables.Disposable disposable2) {
        if (disposable2 == null) {
            io.reactivex.plugins.RxJavaPlugins.onError(new java.lang.NullPointerException("next is null"));
            return false;
        }
        if (disposable == null) {
            return true;
        }
        disposable2.dispose();
        reportDisposableSet();
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }
}
