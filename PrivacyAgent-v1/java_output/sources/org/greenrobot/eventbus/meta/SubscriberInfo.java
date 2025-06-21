package org.greenrobot.eventbus.meta;

/* loaded from: classes26.dex */
public interface SubscriberInfo {
    java.lang.Class<?> getSubscriberClass();

    org.greenrobot.eventbus.SubscriberMethod[] getSubscriberMethods();

    org.greenrobot.eventbus.meta.SubscriberInfo getSuperSubscriberInfo();

    boolean shouldCheckSuperclass();
}
