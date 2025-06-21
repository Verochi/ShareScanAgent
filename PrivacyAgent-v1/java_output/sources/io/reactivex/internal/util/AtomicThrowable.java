package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class AtomicThrowable extends java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(java.lang.Throwable th) {
        return io.reactivex.internal.util.ExceptionHelper.addThrowable(this, th);
    }

    public boolean isTerminated() {
        return get() == io.reactivex.internal.util.ExceptionHelper.TERMINATED;
    }

    public java.lang.Throwable terminate() {
        return io.reactivex.internal.util.ExceptionHelper.terminate(this);
    }
}
