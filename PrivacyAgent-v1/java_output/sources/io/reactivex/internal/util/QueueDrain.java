package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public interface QueueDrain<T, U> {
    boolean accept(org.reactivestreams.Subscriber<? super U> subscriber, T t);

    boolean cancelled();

    boolean done();

    boolean enter();

    java.lang.Throwable error();

    int leave(int i);

    long produced(long j);

    long requested();
}
