package com.huawei.hms.availableupdate;

/* loaded from: classes22.dex */
public class a {
    public static final com.huawei.hms.availableupdate.a b = new com.huawei.hms.availableupdate.a();
    public java.lang.ref.WeakReference<android.app.Activity> a;

    public final android.app.Activity a() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public boolean a(android.app.Activity activity) {
        com.huawei.hms.support.log.HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        android.app.Activity a = a();
        if (a == null || a.isFinishing()) {
            this.a = new java.lang.ref.WeakReference<>(activity);
            return true;
        }
        activity.finish();
        com.huawei.hms.support.log.HMSLog.i("UpdateAdapterMgr", "finish one");
        return false;
    }

    public void b(android.app.Activity activity) {
        com.huawei.hms.support.log.HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        android.app.Activity a = a();
        if (activity == null || !activity.equals(a)) {
            return;
        }
        com.huawei.hms.support.log.HMSLog.i("UpdateAdapterMgr", "reset");
        this.a = null;
    }
}
