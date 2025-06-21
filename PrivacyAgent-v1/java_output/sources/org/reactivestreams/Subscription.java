package org.reactivestreams;

/* loaded from: classes26.dex */
public interface Subscription {
    void cancel();

    void request(long j);
}
