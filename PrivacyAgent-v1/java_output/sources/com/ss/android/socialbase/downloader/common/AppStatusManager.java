package com.ss.android.socialbase.downloader.common;

/* loaded from: classes19.dex */
public class AppStatusManager {
    private static final int STATUS_BACKGROUND = 0;
    private static final int STATUS_FOREGROUND = 1;
    private static final int STATUS_UNKNOWN = -1;
    private static final java.lang.String TAG = "AppStatusManager";
    private volatile boolean isActivityOnPause;
    private volatile int mAppStatus;
    private final java.util.List<com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener> mAppStatusChangeListeners;
    private android.app.Application mApplication;
    private final android.app.Application.ActivityLifecycleCallbacks mCallbacks;
    private com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller mInnerAppStatusChangeCaller;
    private java.lang.ref.WeakReference<android.app.Activity> mTopActivity;
    private int mTopActivityHashCode;

    /* renamed from: com.ss.android.socialbase.downloader.common.AppStatusManager$1, reason: invalid class name */
    public class AnonymousClass1 implements android.app.Application.ActivityLifecycleCallbacks {
        public AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            com.ss.android.socialbase.downloader.common.AppStatusManager.this.isActivityOnPause = true;
            if (com.ss.android.socialbase.downloader.common.AppStatusManager.this.mTopActivityHashCode != 0 || activity == null) {
                return;
            }
            com.ss.android.socialbase.downloader.common.AppStatusManager.this.mTopActivityHashCode = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
            int i = com.ss.android.socialbase.downloader.common.AppStatusManager.this.mTopActivityHashCode;
            com.ss.android.socialbase.downloader.common.AppStatusManager.this.isActivityOnPause = false;
            com.ss.android.socialbase.downloader.common.AppStatusManager.this.mTopActivityHashCode = activity != null ? activity.hashCode() : i;
            if (i == 0) {
                com.ss.android.socialbase.downloader.common.AppStatusManager.this.dispatchAppForeground();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
            com.ss.android.socialbase.downloader.common.AppStatusManager.this.mTopActivity = new java.lang.ref.WeakReference(activity);
            int i = com.ss.android.socialbase.downloader.common.AppStatusManager.this.mTopActivityHashCode;
            com.ss.android.socialbase.downloader.common.AppStatusManager.this.mTopActivityHashCode = activity != null ? activity.hashCode() : i;
            com.ss.android.socialbase.downloader.common.AppStatusManager.this.isActivityOnPause = false;
            if (i == 0) {
                com.ss.android.socialbase.downloader.common.AppStatusManager.this.dispatchAppForeground();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
            if (activity != null && activity.hashCode() == com.ss.android.socialbase.downloader.common.AppStatusManager.this.mTopActivityHashCode) {
                com.ss.android.socialbase.downloader.common.AppStatusManager.this.mTopActivityHashCode = 0;
                com.ss.android.socialbase.downloader.common.AppStatusManager.this.dispatchAppBackground();
            }
            com.ss.android.socialbase.downloader.common.AppStatusManager.this.isActivityOnPause = false;
        }
    }

    public interface AppStatusChangeListener {
        @androidx.annotation.MainThread
        void onAppBackground();

        @androidx.annotation.MainThread
        void onAppForeground();
    }

    public static class Holder {
        private static final com.ss.android.socialbase.downloader.common.AppStatusManager INSTANCE = new com.ss.android.socialbase.downloader.common.AppStatusManager(null);

        private Holder() {
        }
    }

    public interface InnerAppStatusChangeCaller {
        boolean isAppInBackground();
    }

    private AppStatusManager() {
        this.mAppStatusChangeListeners = new java.util.ArrayList();
        this.mAppStatus = -1;
        this.isActivityOnPause = false;
        this.mCallbacks = new com.ss.android.socialbase.downloader.common.AppStatusManager.AnonymousClass1();
    }

    public /* synthetic */ AppStatusManager(com.ss.android.socialbase.downloader.common.AppStatusManager.AnonymousClass1 anonymousClass1) {
        this();
    }

    private boolean checkAppForeground() {
        try {
            android.app.Application application = this.mApplication;
            if (application == null) {
                return false;
            }
            application.getSystemService("activity");
            return android.text.TextUtils.equals(application.getPackageName(), com.ss.android.socialbase.downloader.utils.DownloadUtils.getCurProcessName(application));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private java.lang.Object[] collectAppSwitchListeners() {
        java.lang.Object[] array;
        synchronized (this.mAppStatusChangeListeners) {
            array = this.mAppStatusChangeListeners.size() > 0 ? this.mAppStatusChangeListeners.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAppBackground() {
        this.mAppStatus = 0;
        java.lang.Object[] collectAppSwitchListeners = collectAppSwitchListeners();
        if (collectAppSwitchListeners != null) {
            for (java.lang.Object obj : collectAppSwitchListeners) {
                ((com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener) obj).onAppBackground();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchAppForeground() {
        this.mAppStatus = 1;
        java.lang.Object[] collectAppSwitchListeners = collectAppSwitchListeners();
        if (collectAppSwitchListeners != null) {
            for (java.lang.Object obj : collectAppSwitchListeners) {
                ((com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener) obj).onAppForeground();
            }
        }
    }

    public static com.ss.android.socialbase.downloader.common.AppStatusManager getInstance() {
        return com.ss.android.socialbase.downloader.common.AppStatusManager.Holder.INSTANCE;
    }

    public android.app.Activity getTopActivity() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.mTopActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void init(android.content.Context context) {
        if (this.mApplication == null && (context instanceof android.app.Application)) {
            synchronized (this) {
                if (this.mApplication == null) {
                    android.app.Application application = (android.app.Application) context;
                    this.mApplication = application;
                    application.registerActivityLifecycleCallbacks(this.mCallbacks);
                }
            }
        }
    }

    public boolean isAppFocus() {
        return isAppForeground() && !this.isActivityOnPause;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    public boolean isAppForeground() {
        int i = this.mAppStatus;
        int i2 = i;
        if (i == -1) {
            ?? checkAppForeground = checkAppForeground();
            this.mAppStatus = checkAppForeground;
            i2 = checkAppForeground;
        }
        return i2 == 1;
    }

    public void registerAppSwitchListener(com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener appStatusChangeListener) {
        if (appStatusChangeListener == null) {
            return;
        }
        synchronized (this.mAppStatusChangeListeners) {
            if (!this.mAppStatusChangeListeners.contains(appStatusChangeListener)) {
                this.mAppStatusChangeListeners.add(appStatusChangeListener);
            }
        }
    }

    public void setInnerAppStatusChangeCaller(com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller innerAppStatusChangeCaller) {
        this.mInnerAppStatusChangeCaller = innerAppStatusChangeCaller;
    }

    public void unregisterAppSwitchListener(com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener appStatusChangeListener) {
        synchronized (this.mAppStatusChangeListeners) {
            this.mAppStatusChangeListeners.remove(appStatusChangeListener);
        }
    }
}
