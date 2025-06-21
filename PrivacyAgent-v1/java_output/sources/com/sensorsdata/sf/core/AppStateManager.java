package com.sensorsdata.sf.core;

/* loaded from: classes19.dex */
public class AppStateManager implements android.app.Application.ActivityLifecycleCallbacks {
    private int mActivityCount;
    private android.app.ActivityManager mActivityManager;
    private volatile boolean mAppInForeground;
    private java.lang.ref.WeakReference<android.app.Activity> mCurrentActivity;
    private java.lang.String mPackageName;
    private boolean mResumeFromBackground;
    private final java.lang.String TAG = "AppStateManager";
    private java.util.List<com.sensorsdata.sf.core.AppStateManager.AppStateChangedListener> mAppStateChangedListener = new java.util.ArrayList();
    private final java.util.Set<java.lang.Integer> mActivityHashCodeSet = new java.util.HashSet();

    public interface AppStateChangedListener {
        void onEnterBackground();

        void onEnterForeground(boolean z);
    }

    public AppStateManager(android.content.Context context) {
        this.mPackageName = "";
        this.mActivityManager = null;
        try {
            this.mActivityManager = (android.app.ActivityManager) context.getSystemService("activity");
            this.mPackageName = context.getApplicationContext().getPackageName();
        } catch (java.lang.Exception e) {
            com.sensorsdata.sf.core.utils.SFLog.printStackTrace(e);
        }
    }

    private boolean isDialogActivity(android.app.Activity activity) {
        return activity instanceof com.sensorsdata.sf.ui.view.DialogActivity;
    }

    public void addActivity(android.app.Activity activity) {
        if (activity != null) {
            this.mActivityHashCodeSet.add(java.lang.Integer.valueOf(activity.hashCode()));
        }
    }

    public void addAppStateChangedListener(com.sensorsdata.sf.core.AppStateManager.AppStateChangedListener appStateChangedListener) {
        if (appStateChangedListener == null || this.mAppStateChangedListener.contains(appStateChangedListener)) {
            return;
        }
        this.mAppStateChangedListener.add(appStateChangedListener);
    }

    public java.lang.ref.WeakReference<android.app.Activity> getWeakCurrentActivity() {
        return this.mCurrentActivity;
    }

    public boolean hasActivity(android.app.Activity activity) {
        if (activity != null) {
            return this.mActivityHashCodeSet.contains(java.lang.Integer.valueOf(activity.hashCode()));
        }
        return false;
    }

    public boolean isAppFinishing() {
        android.content.ComponentName componentName;
        android.content.ComponentName componentName2;
        android.content.ComponentName componentName3;
        android.app.ActivityManager activityManager = this.mActivityManager;
        if (activityManager == null || activityManager.getRunningTasks(1) == null) {
            com.sensorsdata.sf.core.utils.SFLog.d("AppStateManager", "am is null or task is null");
            return true;
        }
        android.app.ActivityManager.RunningTaskInfo runningTaskInfo = this.mActivityManager.getRunningTasks(1).get(0);
        if (runningTaskInfo == null) {
            com.sensorsdata.sf.core.utils.SFLog.d("AppStateManager", "failed to get RunningTaskInfo");
            return true;
        }
        componentName = runningTaskInfo.topActivity;
        if (componentName == null) {
            com.sensorsdata.sf.core.utils.SFLog.d("AppStateManager", "failed to get topActivity");
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("mPackageName = ");
        sb.append(this.mPackageName);
        sb.append("--topActivity--");
        componentName2 = runningTaskInfo.topActivity;
        sb.append(componentName2.getPackageName());
        com.sensorsdata.sf.core.utils.SFLog.d("AppStateManager", sb.toString());
        java.lang.String str = this.mPackageName;
        componentName3 = runningTaskInfo.topActivity;
        return !str.equals(componentName3.getPackageName());
    }

    public boolean isAppInForeground() {
        return this.mAppInForeground;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        if (isDialogActivity(activity)) {
            return;
        }
        this.mCurrentActivity = new java.lang.ref.WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        java.util.Set<java.lang.Integer> splashActivity;
        if (!isDialogActivity(activity)) {
            this.mCurrentActivity = new java.lang.ref.WeakReference<>(activity);
        }
        com.sensorsdata.sf.core.SFConfigOptions sFConfigOptions = com.sensorsdata.sf.core.SFContextManger.getInstance().getSFConfigOptions();
        if (sFConfigOptions.isEnablePopup() || (splashActivity = sFConfigOptions.getSplashActivity()) == null || splashActivity.contains(java.lang.Integer.valueOf(activity.getClass().getName().hashCode()))) {
            return;
        }
        com.sensorsdata.sf.core.SensorsFocusAPI.sharedInstance().enablePopup();
        com.sensorsdata.sf.core.utils.SFLog.d("AppStateManager", "automatic running popup");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        if (isDialogActivity(activity) || hasActivity(activity)) {
            return;
        }
        addActivity(activity);
        this.mActivityCount++;
        if (!this.mAppInForeground) {
            this.mAppInForeground = true;
            java.util.Iterator<com.sensorsdata.sf.core.AppStateManager.AppStateChangedListener> it = this.mAppStateChangedListener.iterator();
            while (it.hasNext()) {
                it.next().onEnterForeground(this.mResumeFromBackground);
            }
            com.sensorsdata.sf.core.utils.SFLog.d("AppStateManager", "App enter foreground");
        }
        if (this.mResumeFromBackground) {
            return;
        }
        this.mResumeFromBackground = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        if (isDialogActivity(activity) || !hasActivity(activity)) {
            return;
        }
        removeActivity(activity);
        int i = this.mActivityCount - 1;
        this.mActivityCount = i;
        if (i <= 0) {
            this.mAppInForeground = false;
            java.util.Iterator<com.sensorsdata.sf.core.AppStateManager.AppStateChangedListener> it = this.mAppStateChangedListener.iterator();
            while (it.hasNext()) {
                it.next().onEnterBackground();
            }
            com.sensorsdata.sf.core.utils.SFLog.d("AppStateManager", "App enter background");
        }
    }

    public void removeActivity(android.app.Activity activity) {
        if (activity != null) {
            this.mActivityHashCodeSet.remove(java.lang.Integer.valueOf(activity.hashCode()));
        }
    }
}
