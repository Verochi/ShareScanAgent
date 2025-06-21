package org.greenrobot.eventbus;

/* loaded from: classes26.dex */
public class EventBusBuilder {
    public static final java.util.concurrent.ExecutorService n = java.util.concurrent.Executors.newCachedThreadPool();
    public boolean e;
    public boolean g;
    public boolean h;
    public java.util.List<java.lang.Class<?>> j;
    public java.util.List<org.greenrobot.eventbus.meta.SubscriberInfoIndex> k;
    public org.greenrobot.eventbus.Logger l;
    public org.greenrobot.eventbus.MainThreadSupport m;
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean f = true;
    public java.util.concurrent.ExecutorService i = n;

    public static java.lang.Object a() {
        try {
            return android.os.Looper.getMainLooper();
        } catch (java.lang.RuntimeException unused) {
            return null;
        }
    }

    public org.greenrobot.eventbus.EventBusBuilder addIndex(org.greenrobot.eventbus.meta.SubscriberInfoIndex subscriberInfoIndex) {
        if (this.k == null) {
            this.k = new java.util.ArrayList();
        }
        this.k.add(subscriberInfoIndex);
        return this;
    }

    public org.greenrobot.eventbus.Logger b() {
        org.greenrobot.eventbus.Logger logger = this.l;
        return logger != null ? logger : org.greenrobot.eventbus.Logger.Default.get();
    }

    public org.greenrobot.eventbus.EventBus build() {
        return new org.greenrobot.eventbus.EventBus(this);
    }

    public org.greenrobot.eventbus.MainThreadSupport c() {
        java.lang.Object a;
        org.greenrobot.eventbus.MainThreadSupport mainThreadSupport = this.m;
        if (mainThreadSupport != null) {
            return mainThreadSupport;
        }
        if (!org.greenrobot.eventbus.android.AndroidLogger.isAndroidLogAvailable() || (a = a()) == null) {
            return null;
        }
        return new org.greenrobot.eventbus.MainThreadSupport.AndroidHandlerMainThreadSupport((android.os.Looper) a);
    }

    public org.greenrobot.eventbus.EventBusBuilder eventInheritance(boolean z) {
        this.f = z;
        return this;
    }

    public org.greenrobot.eventbus.EventBusBuilder executorService(java.util.concurrent.ExecutorService executorService) {
        this.i = executorService;
        return this;
    }

    public org.greenrobot.eventbus.EventBusBuilder ignoreGeneratedIndex(boolean z) {
        this.g = z;
        return this;
    }

    public org.greenrobot.eventbus.EventBus installDefaultEventBus() {
        org.greenrobot.eventbus.EventBus eventBus;
        synchronized (org.greenrobot.eventbus.EventBus.class) {
            if (org.greenrobot.eventbus.EventBus.f506s != null) {
                throw new org.greenrobot.eventbus.EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
            org.greenrobot.eventbus.EventBus.f506s = build();
            eventBus = org.greenrobot.eventbus.EventBus.f506s;
        }
        return eventBus;
    }

    public org.greenrobot.eventbus.EventBusBuilder logNoSubscriberMessages(boolean z) {
        this.b = z;
        return this;
    }

    public org.greenrobot.eventbus.EventBusBuilder logSubscriberExceptions(boolean z) {
        this.a = z;
        return this;
    }

    public org.greenrobot.eventbus.EventBusBuilder logger(org.greenrobot.eventbus.Logger logger) {
        this.l = logger;
        return this;
    }

    public org.greenrobot.eventbus.EventBusBuilder sendNoSubscriberEvent(boolean z) {
        this.d = z;
        return this;
    }

    public org.greenrobot.eventbus.EventBusBuilder sendSubscriberExceptionEvent(boolean z) {
        this.c = z;
        return this;
    }

    public org.greenrobot.eventbus.EventBusBuilder skipMethodVerificationFor(java.lang.Class<?> cls) {
        if (this.j == null) {
            this.j = new java.util.ArrayList();
        }
        this.j.add(cls);
        return this;
    }

    public org.greenrobot.eventbus.EventBusBuilder strictMethodVerification(boolean z) {
        this.h = z;
        return this;
    }

    public org.greenrobot.eventbus.EventBusBuilder throwSubscriberException(boolean z) {
        this.e = z;
        return this;
    }
}
