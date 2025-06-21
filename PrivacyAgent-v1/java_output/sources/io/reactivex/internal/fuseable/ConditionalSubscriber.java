package io.reactivex.internal.fuseable;

/* loaded from: classes9.dex */
public interface ConditionalSubscriber<T> extends io.reactivex.FlowableSubscriber<T> {
    boolean tryOnNext(T t);
}
