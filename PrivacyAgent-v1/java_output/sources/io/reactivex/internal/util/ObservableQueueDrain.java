package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public interface ObservableQueueDrain<T, U> {
    void accept(io.reactivex.Observer<? super U> observer, T t);

    boolean cancelled();

    boolean done();

    boolean enter();

    java.lang.Throwable error();

    int leave(int i);
}
