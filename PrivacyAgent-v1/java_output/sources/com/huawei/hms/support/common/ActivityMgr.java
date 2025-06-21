package com.huawei.hms.support.common;

/* loaded from: classes22.dex */
public final class ActivityMgr implements android.app.Application.ActivityLifecycleCallbacks {
    public static final com.huawei.hms.support.common.ActivityMgr INST = new com.huawei.hms.support.common.ActivityMgr();
    public java.lang.ref.WeakReference<android.app.Activity> a;

    public static java.lang.String a(java.lang.Object obj) {
        if (obj == null) {
            return com.igexin.push.core.b.m;
        }
        return obj.getClass().getName() + '@' + java.lang.Integer.toHexString(obj.hashCode());
    }

    public android.app.Activity getCurrentActivity() {
        if (this.a == null) {
            com.huawei.hms.support.log.HMSLog.i("ActivityMgr", "mCurrentActivity is " + this.a);
            return null;
        }
        com.huawei.hms.support.log.HMSLog.i("ActivityMgr", "mCurrentActivity.get() is " + this.a.get());
        return this.a.get();
    }

    public void init(android.app.Application application) {
        com.huawei.hms.support.log.HMSLog.d("ActivityMgr", "init");
        if (application == null) {
            com.huawei.hms.support.log.HMSLog.w("ActivityMgr", "init failed for app is null");
            return;
        }
        com.huawei.hms.support.common.ActivityMgr activityMgr = INST;
        application.unregisterActivityLifecycleCallbacks(activityMgr);
        application.registerActivityLifecycleCallbacks(activityMgr);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        com.huawei.hms.support.log.HMSLog.d("ActivityMgr", "onCreated:" + a(activity));
        this.a = new java.lang.ref.WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        com.huawei.hms.support.log.HMSLog.d("ActivityMgr", "onResumed:" + a(activity));
        this.a = new java.lang.ref.WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        com.huawei.hms.support.log.HMSLog.d("ActivityMgr", "onStarted:" + a(activity));
        this.a = new java.lang.ref.WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
    }
}
