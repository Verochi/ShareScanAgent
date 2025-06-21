package com.sensorsdata.analytics.android.sdk.exposure;

/* loaded from: classes19.dex */
public class ExposedTransform implements com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks {
    private boolean isResumedLayoutChanged;
    private java.lang.ref.WeakReference<android.app.Activity> mActivityWeakReference;
    private final com.sensorsdata.analytics.android.sdk.exposure.AppPageChange mAppPageChange;
    private final com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack mCallBack;
    private final java.lang.String TAG = "SA.ExposedTransform";
    private volatile boolean isMonitor = false;
    private volatile int windowCount = -1;

    /* renamed from: com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform.LayoutCallBack {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack val$callBack;

        public AnonymousClass1(com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack callBack) {
            this.val$callBack = callBack;
        }

        @Override // com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform.LayoutCallBack
        public void viewLayoutChange() {
            android.app.Activity activity;
            if (com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform.this.mActivityWeakReference == null || (activity = (android.app.Activity) com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform.this.mActivityWeakReference.get()) == null || !com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform.this.isViewChanged(activity)) {
                return;
            }
            com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform.this.isResumedLayoutChanged = false;
            this.val$callBack.viewLayoutChange(activity);
        }
    }

    public interface LayoutCallBack {
        void viewLayoutChange();
    }

    public ExposedTransform(com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack callBack) {
        this.mCallBack = callBack;
        this.mAppPageChange = new com.sensorsdata.analytics.android.sdk.exposure.AppPageChange(new com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform.AnonymousClass1(callBack));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isViewChanged(android.app.Activity activity) {
        try {
            java.util.Collection<com.sensorsdata.analytics.android.sdk.exposure.ExposureView> exposureViews = this.mCallBack.getExposureViews(activity);
            if (exposureViews != null && !exposureViews.isEmpty()) {
                boolean z = false;
                for (com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView : exposureViews) {
                    try {
                        android.view.View view = exposureView.getView();
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        int i = com.sensorsdata.analytics.android.sdk.exposure.R.id.sensors_analytics_tag_view_exposure_key;
                        java.lang.String str = (java.lang.String) view.getTag(i);
                        java.lang.String str2 = iArr[0] + "," + iArr[1] + "," + com.sensorsdata.analytics.android.sdk.util.visual.ViewUtil.viewVisibilityInParents(view);
                        if (!str2.equals(str) || this.isResumedLayoutChanged) {
                            com.sensorsdata.analytics.android.sdk.SALog.i("SA.ExposedTransform", str + ", newSize = " + str2 + ",view = " + view);
                            try {
                                exposureView.setViewLayoutChange(true);
                                z = true;
                            } catch (java.lang.Exception e) {
                                e = e;
                                z = true;
                                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                            }
                        }
                        view.setTag(i, str2);
                    } catch (java.lang.Exception e2) {
                        e = e2;
                    }
                }
                return z;
            }
            return false;
        } catch (java.lang.Exception e3) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
            return true;
        }
    }

    private android.view.View[] processViews() {
        try {
            com.sensorsdata.analytics.android.sdk.util.WindowHelper.init();
            android.view.View[] sortedWindowViews = com.sensorsdata.analytics.android.sdk.util.WindowHelper.getSortedWindowViews();
            if (sortedWindowViews.length > 0) {
                this.windowCount = sortedWindowViews.length;
            } else {
                this.windowCount = 0;
            }
            return sortedWindowViews;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    private void viewRemoveTreeObserver(android.view.View view) {
        android.view.ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.removeGlobalOnLayoutListener(this.mAppPageChange);
        viewTreeObserver.removeOnWindowFocusChangeListener(this.mAppPageChange);
        viewTreeObserver.removeOnScrollChangedListener(this.mAppPageChange);
        viewTreeObserver.removeOnGlobalFocusChangeListener(this.mAppPageChange);
    }

    private void viewTreeObserver(android.view.View view) {
        android.view.ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(this.mAppPageChange);
        viewTreeObserver.addOnWindowFocusChangeListener(this.mAppPageChange);
        viewTreeObserver.addOnScrollChangedListener(this.mAppPageChange);
        viewTreeObserver.addOnGlobalFocusChangeListener(this.mAppPageChange);
    }

    private void viewsAddTreeObserver(android.app.Activity activity) {
        com.sensorsdata.analytics.android.sdk.SALog.i("SA.ExposedTransform", "viewsAddTreeObserver:" + this.isMonitor);
        if (this.isMonitor || this.mCallBack.getExposureViewSize(activity) <= 0) {
            return;
        }
        processViews();
        android.view.View[] sortedWindowViews = com.sensorsdata.analytics.android.sdk.util.WindowHelper.getSortedWindowViews();
        android.view.View decorView = activity.getWindow().getDecorView();
        if (sortedWindowViews == null || sortedWindowViews.length <= 0) {
            viewTreeObserver(activity.getWindow().getDecorView());
        } else {
            boolean z = true;
            for (android.view.View view : sortedWindowViews) {
                if (decorView == view) {
                    z = false;
                }
                viewTreeObserver(view);
            }
            if (z) {
                viewTreeObserver(decorView);
            }
        }
        this.isMonitor = true;
    }

    private void viewsRemoveTreeObserver(android.app.Activity activity, android.view.View[] viewArr) {
        com.sensorsdata.analytics.android.sdk.SALog.i("SA.ExposedTransform", "viewsRemoveTreeObserver:" + this.isMonitor);
        if (this.isMonitor) {
            this.isMonitor = false;
            if (viewArr == null) {
                viewArr = com.sensorsdata.analytics.android.sdk.util.WindowHelper.getSortedWindowViews();
            }
            if (viewArr == null || viewArr.length <= 0) {
                viewRemoveTreeObserver(activity.getWindow().getDecorView());
                return;
            }
            for (android.view.View view : viewArr) {
                viewRemoveTreeObserver(view);
            }
        }
    }

    public synchronized void observerWindow(android.app.Activity activity) {
        int i = this.windowCount;
        android.view.View[] processViews = processViews();
        com.sensorsdata.analytics.android.sdk.SALog.i("SA.ExposedTransform", "originWindowCount:" + i + ",windowCount:" + this.windowCount);
        if (i != this.windowCount) {
            viewsRemoveTreeObserver(activity, processViews);
            onActivityResumed(activity);
        } else {
            if (!this.isMonitor) {
                onActivityResumed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        this.mActivityWeakReference = new java.lang.ref.WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        com.sensorsdata.analytics.android.sdk.SALog.i("SA.ExposedTransform", "onActivityPaused");
        synchronized (this) {
            viewsRemoveTreeObserver(activity, null);
            this.mCallBack.onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        this.mActivityWeakReference = new java.lang.ref.WeakReference<>(activity);
        this.isResumedLayoutChanged = true;
        com.sensorsdata.analytics.android.sdk.SALog.i("SA.ExposedTransform", "onActivityResumed:" + activity);
        synchronized (this) {
            viewsAddTreeObserver(activity);
            this.mCallBack.onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
    }

    @Override // com.sensorsdata.analytics.android.sdk.monitor.SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks
    public void onNewIntent(android.content.Intent intent) {
    }
}
