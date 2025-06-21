package io.reactivex.android;

/* loaded from: classes9.dex */
public abstract class MainThreadDisposable implements io.reactivex.disposables.Disposable {
    public final java.util.concurrent.atomic.AtomicBoolean n = new java.util.concurrent.atomic.AtomicBoolean();

    /* renamed from: io.reactivex.android.MainThreadDisposable$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            io.reactivex.android.MainThreadDisposable.this.onDispose();
        }
    }

    public static void verifyMainThread() {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            return;
        }
        throw new java.lang.IllegalStateException("Expected to be called on the main thread but was " + java.lang.Thread.currentThread().getName());
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.n.compareAndSet(false, true)) {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                onDispose();
            } else {
                io.reactivex.android.schedulers.AndroidSchedulers.mainThread().scheduleDirect(new io.reactivex.android.MainThreadDisposable.AnonymousClass1());
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.n.get();
    }

    public abstract void onDispose();
}
