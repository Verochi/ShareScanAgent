package io.reactivex.exceptions;

/* loaded from: classes9.dex */
public final class UndeliverableException extends java.lang.IllegalStateException {
    private static final long serialVersionUID = 1644750035281290266L;

    public UndeliverableException(java.lang.Throwable th) {
        super("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | " + th, th);
    }
}
