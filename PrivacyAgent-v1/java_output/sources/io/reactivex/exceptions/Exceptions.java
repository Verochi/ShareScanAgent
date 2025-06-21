package io.reactivex.exceptions;

/* loaded from: classes9.dex */
public final class Exceptions {
    public Exceptions() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    @io.reactivex.annotations.NonNull
    public static java.lang.RuntimeException propagate(@io.reactivex.annotations.NonNull java.lang.Throwable th) {
        throw io.reactivex.internal.util.ExceptionHelper.wrapOrThrow(th);
    }

    public static void throwIfFatal(@io.reactivex.annotations.NonNull java.lang.Throwable th) {
        if (th instanceof java.lang.VirtualMachineError) {
            throw ((java.lang.VirtualMachineError) th);
        }
        if (th instanceof java.lang.ThreadDeath) {
            throw ((java.lang.ThreadDeath) th);
        }
        if (th instanceof java.lang.LinkageError) {
            throw ((java.lang.LinkageError) th);
        }
    }
}
