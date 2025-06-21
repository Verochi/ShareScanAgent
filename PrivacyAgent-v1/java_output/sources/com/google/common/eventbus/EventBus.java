package com.google.common.eventbus;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public class EventBus {
    public static final java.util.logging.Logger f = java.util.logging.Logger.getLogger(com.google.common.eventbus.EventBus.class.getName());
    public final java.lang.String a;
    public final java.util.concurrent.Executor b;
    public final com.google.common.eventbus.SubscriberExceptionHandler c;
    public final com.google.common.eventbus.SubscriberRegistry d;
    public final com.google.common.eventbus.Dispatcher e;

    public static final class LoggingHandler implements com.google.common.eventbus.SubscriberExceptionHandler {
        public static final com.google.common.eventbus.EventBus.LoggingHandler a = new com.google.common.eventbus.EventBus.LoggingHandler();

        public static java.util.logging.Logger a(com.google.common.eventbus.SubscriberExceptionContext subscriberExceptionContext) {
            return java.util.logging.Logger.getLogger(com.google.common.eventbus.EventBus.class.getName() + "." + subscriberExceptionContext.getEventBus().identifier());
        }

        public static java.lang.String b(com.google.common.eventbus.SubscriberExceptionContext subscriberExceptionContext) {
            java.lang.reflect.Method subscriberMethod = subscriberExceptionContext.getSubscriberMethod();
            return "Exception thrown by subscriber method " + subscriberMethod.getName() + '(' + subscriberMethod.getParameterTypes()[0].getName() + ") on subscriber " + subscriberExceptionContext.getSubscriber() + " when dispatching event: " + subscriberExceptionContext.getEvent();
        }

        @Override // com.google.common.eventbus.SubscriberExceptionHandler
        public void handleException(java.lang.Throwable th, com.google.common.eventbus.SubscriberExceptionContext subscriberExceptionContext) {
            java.util.logging.Logger a2 = a(subscriberExceptionContext);
            java.util.logging.Level level = java.util.logging.Level.SEVERE;
            if (a2.isLoggable(level)) {
                a2.log(level, b(subscriberExceptionContext), th);
            }
        }
    }

    public EventBus() {
        this("default");
    }

    public EventBus(com.google.common.eventbus.SubscriberExceptionHandler subscriberExceptionHandler) {
        this("default", com.google.common.util.concurrent.MoreExecutors.directExecutor(), com.google.common.eventbus.Dispatcher.c(), subscriberExceptionHandler);
    }

    public EventBus(java.lang.String str) {
        this(str, com.google.common.util.concurrent.MoreExecutors.directExecutor(), com.google.common.eventbus.Dispatcher.c(), com.google.common.eventbus.EventBus.LoggingHandler.a);
    }

    public EventBus(java.lang.String str, java.util.concurrent.Executor executor, com.google.common.eventbus.Dispatcher dispatcher, com.google.common.eventbus.SubscriberExceptionHandler subscriberExceptionHandler) {
        this.d = new com.google.common.eventbus.SubscriberRegistry(this);
        this.a = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
        this.b = (java.util.concurrent.Executor) com.google.common.base.Preconditions.checkNotNull(executor);
        this.e = (com.google.common.eventbus.Dispatcher) com.google.common.base.Preconditions.checkNotNull(dispatcher);
        this.c = (com.google.common.eventbus.SubscriberExceptionHandler) com.google.common.base.Preconditions.checkNotNull(subscriberExceptionHandler);
    }

    public final java.util.concurrent.Executor a() {
        return this.b;
    }

    public void b(java.lang.Throwable th, com.google.common.eventbus.SubscriberExceptionContext subscriberExceptionContext) {
        com.google.common.base.Preconditions.checkNotNull(th);
        com.google.common.base.Preconditions.checkNotNull(subscriberExceptionContext);
        try {
            this.c.handleException(th, subscriberExceptionContext);
        } catch (java.lang.Throwable th2) {
            f.log(java.util.logging.Level.SEVERE, java.lang.String.format(java.util.Locale.ROOT, "Exception %s thrown while handling exception: %s", th2, th), th2);
        }
    }

    public final java.lang.String identifier() {
        return this.a;
    }

    public void post(java.lang.Object obj) {
        java.util.Iterator<com.google.common.eventbus.Subscriber> f2 = this.d.f(obj);
        if (f2.hasNext()) {
            this.e.a(obj, f2);
        } else {
            if (obj instanceof com.google.common.eventbus.DeadEvent) {
                return;
            }
            post(new com.google.common.eventbus.DeadEvent(this, obj));
        }
    }

    public void register(java.lang.Object obj) {
        this.d.g(obj);
    }

    public java.lang.String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this).addValue(this.a).toString();
    }

    public void unregister(java.lang.Object obj) {
        this.d.h(obj);
    }
}
