package org.greenrobot.eventbus.meta;

/* loaded from: classes26.dex */
public abstract class AbstractSubscriberInfo implements org.greenrobot.eventbus.meta.SubscriberInfo {
    public final java.lang.Class a;
    public final java.lang.Class<? extends org.greenrobot.eventbus.meta.SubscriberInfo> b;
    public final boolean c;

    public AbstractSubscriberInfo(java.lang.Class cls, java.lang.Class<? extends org.greenrobot.eventbus.meta.SubscriberInfo> cls2, boolean z) {
        this.a = cls;
        this.b = cls2;
        this.c = z;
    }

    public org.greenrobot.eventbus.SubscriberMethod createSubscriberMethod(java.lang.String str, java.lang.Class<?> cls) {
        return createSubscriberMethod(str, cls, org.greenrobot.eventbus.ThreadMode.POSTING, 0, false);
    }

    public org.greenrobot.eventbus.SubscriberMethod createSubscriberMethod(java.lang.String str, java.lang.Class<?> cls, org.greenrobot.eventbus.ThreadMode threadMode) {
        return createSubscriberMethod(str, cls, threadMode, 0, false);
    }

    public org.greenrobot.eventbus.SubscriberMethod createSubscriberMethod(java.lang.String str, java.lang.Class<?> cls, org.greenrobot.eventbus.ThreadMode threadMode, int i, boolean z) {
        try {
            return new org.greenrobot.eventbus.SubscriberMethod(this.a.getDeclaredMethod(str, cls), cls, threadMode, i, z);
        } catch (java.lang.NoSuchMethodException e) {
            throw new org.greenrobot.eventbus.EventBusException("Could not find subscriber method in " + this.a + ". Maybe a missing ProGuard rule?", e);
        }
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public java.lang.Class getSubscriberClass() {
        return this.a;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public org.greenrobot.eventbus.meta.SubscriberInfo getSuperSubscriberInfo() {
        java.lang.Class<? extends org.greenrobot.eventbus.meta.SubscriberInfo> cls = this.b;
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.lang.InstantiationException e2) {
            throw new java.lang.RuntimeException(e2);
        }
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public boolean shouldCheckSuperclass() {
        return this.c;
    }
}
