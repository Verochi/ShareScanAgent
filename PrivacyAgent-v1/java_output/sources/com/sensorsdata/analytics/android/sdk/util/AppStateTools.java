package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class AppStateTools implements com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks {
    private static final java.lang.String TAG = "AppStateTools";
    private int mActivityCount;
    private final java.util.List<com.sensorsdata.analytics.android.sdk.util.AppStateTools.AppState> mAppStateList;
    private java.lang.String mCurrentFragmentName;
    private int mCurrentRootWindowsHashCode;
    private java.lang.ref.WeakReference<android.app.Activity> mForeGroundActivity;

    public interface AppState {
        void onBackground();

        void onForeground();
    }

    public static class SingleHolder {
        private static final com.sensorsdata.analytics.android.sdk.util.AppStateTools mSingleInstance = new com.sensorsdata.analytics.android.sdk.util.AppStateTools(null);

        private SingleHolder() {
        }
    }

    private AppStateTools() {
        this.mForeGroundActivity = new java.lang.ref.WeakReference<>(null);
        this.mCurrentFragmentName = null;
        this.mCurrentRootWindowsHashCode = -1;
        this.mActivityCount = 0;
        this.mAppStateList = new java.util.ArrayList();
    }

    public /* synthetic */ AppStateTools(com.sensorsdata.analytics.android.sdk.util.AppStateTools.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.sensorsdata.analytics.android.sdk.util.AppStateTools getInstance() {
        return com.sensorsdata.analytics.android.sdk.util.AppStateTools.SingleHolder.mSingleInstance;
    }

    private void setForegroundActivity(android.app.Activity activity) {
        this.mForeGroundActivity = new java.lang.ref.WeakReference<>(activity);
    }

    public void addAppStateListener(com.sensorsdata.analytics.android.sdk.util.AppStateTools.AppState appState) {
        this.mAppStateList.add(appState);
    }

    public void delayInit(android.content.Context context) {
        try {
            if (context instanceof android.app.Activity) {
                onActivityStarted((android.app.Activity) context);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public int getCurrentRootWindowsHashCode() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference;
        android.app.Activity activity;
        android.view.Window window;
        if (this.mCurrentRootWindowsHashCode == -1 && (weakReference = this.mForeGroundActivity) != null && weakReference.get() != null && (activity = this.mForeGroundActivity.get()) != null && (window = activity.getWindow()) != null && window.isActive()) {
            this.mCurrentRootWindowsHashCode = window.getDecorView().hashCode();
        }
        return this.mCurrentRootWindowsHashCode;
    }

    public android.app.Activity getForegroundActivity() {
        return this.mForeGroundActivity.get();
    }

    public java.lang.String getFragmentScreenName() {
        return this.mCurrentFragmentName;
    }

    public boolean isAppOnForeground() {
        return this.mActivityCount != 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        try {
            setForegroundActivity(activity);
            if (!activity.isChild()) {
                this.mCurrentRootWindowsHashCode = -1;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        try {
            if (com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.isSchemeActivity(activity)) {
                return;
            }
            com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.handleSchemeUrl(activity, activity.getIntent());
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        if (activity.isChild()) {
            return;
        }
        this.mCurrentRootWindowsHashCode = -1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        setForegroundActivity(activity);
        android.view.View view = null;
        try {
            android.view.Window window = activity.getWindow();
            if (window != null) {
                view = window.getDecorView();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (activity.isChild() || view == null) {
            return;
        }
        this.mCurrentRootWindowsHashCode = view.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        int i = this.mActivityCount;
        this.mActivityCount = i + 1;
        if (i == 0) {
            java.util.Iterator<com.sensorsdata.analytics.android.sdk.util.AppStateTools.AppState> it = this.mAppStateList.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onForeground();
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        int i = this.mActivityCount - 1;
        this.mActivityCount = i;
        if (i == 0) {
            java.util.Iterator<com.sensorsdata.analytics.android.sdk.util.AppStateTools.AppState> it = this.mAppStateList.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onBackground();
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks
    public void onNewIntent(android.content.Intent intent) {
    }

    public void setFragmentScreenName(java.lang.Object obj, java.lang.String str) {
        try {
            if (obj.getClass().getMethod("getParentFragment", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0]) == null) {
                this.mCurrentFragmentName = str;
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "setFragmentScreenName | " + str + " is not nested fragment and set");
            } else {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "setFragmentScreenName | " + str + " is nested fragment and ignored");
            }
        } catch (java.lang.Exception unused) {
        }
    }
}
