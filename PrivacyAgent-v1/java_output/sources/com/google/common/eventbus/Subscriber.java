package com.google.common.eventbus;

/* loaded from: classes22.dex */
class Subscriber {

    @com.google.j2objc.annotations.Weak
    public com.google.common.eventbus.EventBus a;

    @com.google.common.annotations.VisibleForTesting
    public final java.lang.Object b;
    public final java.lang.reflect.Method c;
    public final java.util.concurrent.Executor d;

    /* renamed from: com.google.common.eventbus.Subscriber$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.lang.Object n;

        public AnonymousClass1(java.lang.Object obj) {
            this.n = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.google.common.eventbus.Subscriber.this.f(this.n);
            } catch (java.lang.reflect.InvocationTargetException e) {
                com.google.common.eventbus.Subscriber.this.a.b(e.getCause(), com.google.common.eventbus.Subscriber.this.c(this.n));
            }
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static final class SynchronizedSubscriber extends com.google.common.eventbus.Subscriber {
        public SynchronizedSubscriber(com.google.common.eventbus.EventBus eventBus, java.lang.Object obj, java.lang.reflect.Method method) {
            super(eventBus, obj, method, null);
        }

        public /* synthetic */ SynchronizedSubscriber(com.google.common.eventbus.EventBus eventBus, java.lang.Object obj, java.lang.reflect.Method method, com.google.common.eventbus.Subscriber.AnonymousClass1 anonymousClass1) {
            this(eventBus, obj, method);
        }

        @Override // com.google.common.eventbus.Subscriber
        public void f(java.lang.Object obj) throws java.lang.reflect.InvocationTargetException {
            synchronized (this) {
                super.f(obj);
            }
        }
    }

    public Subscriber(com.google.common.eventbus.EventBus eventBus, java.lang.Object obj, java.lang.reflect.Method method) {
        this.a = eventBus;
        this.b = com.google.common.base.Preconditions.checkNotNull(obj);
        this.c = method;
        method.setAccessible(true);
        this.d = eventBus.a();
    }

    public /* synthetic */ Subscriber(com.google.common.eventbus.EventBus eventBus, java.lang.Object obj, java.lang.reflect.Method method, com.google.common.eventbus.Subscriber.AnonymousClass1 anonymousClass1) {
        this(eventBus, obj, method);
    }

    public static com.google.common.eventbus.Subscriber d(com.google.common.eventbus.EventBus eventBus, java.lang.Object obj, java.lang.reflect.Method method) {
        return g(method) ? new com.google.common.eventbus.Subscriber(eventBus, obj, method) : new com.google.common.eventbus.Subscriber.SynchronizedSubscriber(eventBus, obj, method, null);
    }

    public static boolean g(java.lang.reflect.Method method) {
        return method.getAnnotation(com.google.common.eventbus.AllowConcurrentEvents.class) != null;
    }

    public final com.google.common.eventbus.SubscriberExceptionContext c(java.lang.Object obj) {
        return new com.google.common.eventbus.SubscriberExceptionContext(this.a, obj, this.b, this.c);
    }

    public final void e(java.lang.Object obj) {
        this.d.execute(new com.google.common.eventbus.Subscriber.AnonymousClass1(obj));
    }

    public final boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof com.google.common.eventbus.Subscriber)) {
            return false;
        }
        com.google.common.eventbus.Subscriber subscriber = (com.google.common.eventbus.Subscriber) obj;
        return this.b == subscriber.b && this.c.equals(subscriber.c);
    }

    @com.google.common.annotations.VisibleForTesting
    public void f(java.lang.Object obj) throws java.lang.reflect.InvocationTargetException {
        try {
            this.c.invoke(this.b, com.google.common.base.Preconditions.checkNotNull(obj));
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.Error("Method became inaccessible: " + obj, e);
        } catch (java.lang.IllegalArgumentException e2) {
            throw new java.lang.Error("Method rejected target/argument: " + obj, e2);
        } catch (java.lang.reflect.InvocationTargetException e3) {
            if (!(e3.getCause() instanceof java.lang.Error)) {
                throw e3;
            }
            throw ((java.lang.Error) e3.getCause());
        }
    }

    public final int hashCode() {
        return ((this.c.hashCode() + 31) * 31) + java.lang.System.identityHashCode(this.b);
    }
}
