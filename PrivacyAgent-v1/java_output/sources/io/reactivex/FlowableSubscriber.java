package io.reactivex;

/* loaded from: classes9.dex */
public interface FlowableSubscriber<T> extends org.reactivestreams.Subscriber<T> {
    @Override // org.reactivestreams.Subscriber
    void onSubscribe(@io.reactivex.annotations.NonNull org.reactivestreams.Subscription subscription);
}
