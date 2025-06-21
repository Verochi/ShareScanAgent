package com.sensorsdata.analytics.android.sdk.core.eventbus;

/* loaded from: classes19.dex */
public abstract class Subscription<T> {
    java.lang.String eventTag;

    public abstract void notify(T t);
}
