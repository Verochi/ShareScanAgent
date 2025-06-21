package com.google.common.eventbus;

@com.google.common.annotations.Beta
/* loaded from: classes22.dex */
public class AsyncEventBus extends com.google.common.eventbus.EventBus {
    public AsyncEventBus(java.lang.String str, java.util.concurrent.Executor executor) {
        super(str, executor, com.google.common.eventbus.Dispatcher.b(), com.google.common.eventbus.EventBus.LoggingHandler.a);
    }

    public AsyncEventBus(java.util.concurrent.Executor executor) {
        super("default", executor, com.google.common.eventbus.Dispatcher.b(), com.google.common.eventbus.EventBus.LoggingHandler.a);
    }

    public AsyncEventBus(java.util.concurrent.Executor executor, com.google.common.eventbus.SubscriberExceptionHandler subscriberExceptionHandler) {
        super("default", executor, com.google.common.eventbus.Dispatcher.b(), subscriberExceptionHandler);
    }
}
