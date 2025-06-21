package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
public final class SubscriberExceptionEvent {
    public final java.lang.Object causingEvent;
    public final java.lang.Object causingSubscriber;
    public final org.greenrobot.eventbus.EventBus eventBus;
    public final java.lang.Throwable throwable;

    public SubscriberExceptionEvent(org.greenrobot.eventbus.EventBus eventBus, java.lang.Throwable th, java.lang.Object obj, java.lang.Object obj2) {
        this.eventBus = eventBus;
        this.throwable = th;
        this.causingEvent = obj;
        this.causingSubscriber = obj2;
    }
}
