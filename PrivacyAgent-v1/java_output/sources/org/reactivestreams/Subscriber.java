package org.reactivestreams;

/* loaded from: classes26.dex */
public interface Subscriber<T> {
    void onComplete();

    void onError(java.lang.Throwable th);

    void onNext(T t);

    void onSubscribe(org.reactivestreams.Subscription subscription);
}
