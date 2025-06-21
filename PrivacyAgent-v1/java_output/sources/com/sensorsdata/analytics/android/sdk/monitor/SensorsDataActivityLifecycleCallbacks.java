package com.sensorsdata.analytics.android.sdk.monitor;

@android.annotation.TargetApi(14)
/* loaded from: classes19.dex */
public class SensorsDataActivityLifecycleCallbacks implements android.app.Application.ActivityLifecycleCallbacks {
    private final java.util.concurrent.CopyOnWriteArraySet<com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks> mActivityCallbacks = new java.util.concurrent.CopyOnWriteArraySet<>();

    public interface SAActivityLifecycleCallbacks extends android.app.Application.ActivityLifecycleCallbacks {
        void onNewIntent(android.content.Intent intent);
    }

    public void addActivityLifecycleCallbacks(com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks sAActivityLifecycleCallbacks) {
        if (sAActivityLifecycleCallbacks != null) {
            this.mActivityCallbacks.add(sAActivityLifecycleCallbacks);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
        while (it.hasNext()) {
            try {
                it.next().onActivityCreated(activity, bundle);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
        while (it.hasNext()) {
            try {
                it.next().onActivityDestroyed(activity);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
        while (it.hasNext()) {
            try {
                it.next().onActivityPaused(activity);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
        while (it.hasNext()) {
            try {
                it.next().onActivityResumed(activity);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
        while (it.hasNext()) {
            try {
                it.next().onActivitySaveInstanceState(activity, bundle);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
        while (it.hasNext()) {
            try {
                it.next().onActivityStarted(activity);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        java.util.Iterator<com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks> it = this.mActivityCallbacks.iterator();
        while (it.hasNext()) {
            try {
                it.next().onActivityStopped(activity);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public void removeActivityLifecycleCallbacks(com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks sAActivityLifecycleCallbacks) {
        if (sAActivityLifecycleCallbacks != null) {
            this.mActivityCallbacks.remove(sAActivityLifecycleCallbacks);
        }
    }
}
