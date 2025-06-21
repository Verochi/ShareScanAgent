package com.huawei.hms.activity.internal;

/* loaded from: classes22.dex */
public class ForegroundBusResponseMgr {
    private static final com.huawei.hms.activity.internal.ForegroundBusResponseMgr INSTANCE = new com.huawei.hms.activity.internal.ForegroundBusResponseMgr();
    private final java.util.Map<java.lang.String, com.huawei.hms.activity.internal.BusResponseCallback> callbackMap = new java.util.HashMap();

    public static com.huawei.hms.activity.internal.ForegroundBusResponseMgr getInstance() {
        return INSTANCE;
    }

    public com.huawei.hms.activity.internal.BusResponseCallback get(java.lang.String str) {
        com.huawei.hms.activity.internal.BusResponseCallback busResponseCallback;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.callbackMap) {
            busResponseCallback = this.callbackMap.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(java.lang.String str, com.huawei.hms.activity.internal.BusResponseCallback busResponseCallback) {
        if (android.text.TextUtils.isEmpty(str) || busResponseCallback == null) {
            return;
        }
        synchronized (this.callbackMap) {
            if (!this.callbackMap.containsKey(str)) {
                this.callbackMap.put(str, busResponseCallback);
            }
        }
    }

    public void unRegisterObserver(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.callbackMap) {
            this.callbackMap.remove(str);
        }
    }
}
