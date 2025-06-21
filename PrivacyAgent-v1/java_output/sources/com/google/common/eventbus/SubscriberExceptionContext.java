package com.google.common.eventbus;

/* loaded from: classes22.dex */
public class SubscriberExceptionContext {
    public final com.google.common.eventbus.EventBus a;
    public final java.lang.Object b;
    public final java.lang.Object c;
    public final java.lang.reflect.Method d;

    public SubscriberExceptionContext(com.google.common.eventbus.EventBus eventBus, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Method method) {
        this.a = (com.google.common.eventbus.EventBus) com.google.common.base.Preconditions.checkNotNull(eventBus);
        this.b = com.google.common.base.Preconditions.checkNotNull(obj);
        this.c = com.google.common.base.Preconditions.checkNotNull(obj2);
        this.d = (java.lang.reflect.Method) com.google.common.base.Preconditions.checkNotNull(method);
    }

    public java.lang.Object getEvent() {
        return this.b;
    }

    public com.google.common.eventbus.EventBus getEventBus() {
        return this.a;
    }

    public java.lang.Object getSubscriber() {
        return this.c;
    }

    public java.lang.reflect.Method getSubscriberMethod() {
        return this.d;
    }
}
