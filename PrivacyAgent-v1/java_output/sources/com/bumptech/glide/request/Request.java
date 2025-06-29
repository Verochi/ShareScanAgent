package com.bumptech.glide.request;

/* loaded from: classes.dex */
public interface Request {
    void begin();

    void clear();

    boolean isAnyResourceSet();

    boolean isCleared();

    boolean isComplete();

    boolean isEquivalentTo(com.bumptech.glide.request.Request request);

    boolean isRunning();

    void pause();
}
