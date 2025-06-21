package org.greenrobot.eventbus.meta;

/* loaded from: classes26.dex */
public class SimpleSubscriberInfo extends org.greenrobot.eventbus.meta.AbstractSubscriberInfo {
    public final org.greenrobot.eventbus.meta.SubscriberMethodInfo[] d;

    public SimpleSubscriberInfo(java.lang.Class cls, boolean z, org.greenrobot.eventbus.meta.SubscriberMethodInfo[] subscriberMethodInfoArr) {
        super(cls, null, z);
        this.d = subscriberMethodInfoArr;
    }

    @Override // org.greenrobot.eventbus.meta.SubscriberInfo
    public synchronized org.greenrobot.eventbus.SubscriberMethod[] getSubscriberMethods() {
        org.greenrobot.eventbus.SubscriberMethod[] subscriberMethodArr;
        int length = this.d.length;
        subscriberMethodArr = new org.greenrobot.eventbus.SubscriberMethod[length];
        for (int i = 0; i < length; i++) {
            org.greenrobot.eventbus.meta.SubscriberMethodInfo subscriberMethodInfo = this.d[i];
            subscriberMethodArr[i] = createSubscriberMethod(subscriberMethodInfo.a, subscriberMethodInfo.c, subscriberMethodInfo.b, subscriberMethodInfo.d, subscriberMethodInfo.e);
        }
        return subscriberMethodArr;
    }
}
