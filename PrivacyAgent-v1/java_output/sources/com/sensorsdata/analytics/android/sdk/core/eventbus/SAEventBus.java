package com.sensorsdata.analytics.android.sdk.core.eventbus;

/* loaded from: classes19.dex */
public class SAEventBus {
    private static com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBus sSAEventBus;
    private final java.util.Map<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription>> mSubscriberMap = new java.util.concurrent.ConcurrentHashMap();

    private boolean checkType(com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription subscription, java.lang.Object obj) {
        try {
            subscription.getClass().getDeclaredMethod("notify", obj.getClass());
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBus getInstance() {
        if (sSAEventBus == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBus.class) {
                if (sSAEventBus == null) {
                    sSAEventBus = new com.sensorsdata.analytics.android.sdk.core.eventbus.SAEventBus();
                }
            }
        }
        return sSAEventBus;
    }

    public void clear() {
        this.mSubscriberMap.clear();
    }

    public void post(java.lang.String str, java.lang.Object obj) {
        if (this.mSubscriberMap.containsKey(str)) {
            java.util.Iterator<com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription> it = this.mSubscriberMap.get(str).iterator();
            while (it.hasNext()) {
                com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription next = it.next();
                if (checkType(next, obj)) {
                    next.notify(obj);
                }
            }
        }
    }

    public void register(java.lang.String str, com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription subscription) {
        if (subscription == null) {
            return;
        }
        subscription.eventTag = str;
        if (this.mSubscriberMap.containsKey(str)) {
            this.mSubscriberMap.get(str).add(subscription);
            return;
        }
        java.util.concurrent.CopyOnWriteArrayList<com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription> copyOnWriteArrayList = new java.util.concurrent.CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(subscription);
        this.mSubscriberMap.put(str, copyOnWriteArrayList);
    }

    public void unRegister(com.sensorsdata.analytics.android.sdk.core.eventbus.Subscription subscription) {
        if (subscription != null && this.mSubscriberMap.containsKey(subscription.eventTag)) {
            this.mSubscriberMap.get(subscription.eventTag).remove(subscription);
        }
    }
}
