package org.reactivestreams;

/* loaded from: classes26.dex */
public interface Publisher<T> {
    void subscribe(org.reactivestreams.Subscriber<? super T> subscriber);
}
