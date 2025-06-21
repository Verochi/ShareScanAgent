package io.reactivex.exceptions;

/* loaded from: classes9.dex */
public final class OnErrorNotImplementedException extends java.lang.RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(java.lang.String str, @io.reactivex.annotations.NonNull java.lang.Throwable th) {
        super(str, th == null ? new java.lang.NullPointerException() : th);
    }

    public OnErrorNotImplementedException(@io.reactivex.annotations.NonNull java.lang.Throwable th) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + th, th);
    }
}
