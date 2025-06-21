package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
public final class NoSubscriberEvent {
    public final org.greenrobot.eventbus.EventBus eventBus;
    public final java.lang.Object originalEvent;

    public NoSubscriberEvent(org.greenrobot.eventbus.EventBus eventBus, java.lang.Object obj) {
        this.eventBus = eventBus;
        this.originalEvent = obj;
    }
}
