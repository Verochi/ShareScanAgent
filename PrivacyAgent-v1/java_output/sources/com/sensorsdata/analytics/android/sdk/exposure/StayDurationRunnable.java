package com.sensorsdata.analytics.android.sdk.exposure;

/* loaded from: classes19.dex */
public class StayDurationRunnable implements java.lang.Runnable {
    private static final java.lang.String TAG = "SA.StayDurationRunnable";
    private final com.sensorsdata.analytics.android.sdk.exposure.ExposureView mExposureView;

    /* renamed from: com.sensorsdata.analytics.android.sdk.exposure.StayDurationRunnable$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.Callable<java.lang.Boolean> {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureListener val$exposureListener;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.exposure.ExposureView val$mExposureView;

        public AnonymousClass1(com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureListener sAExposureListener, com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView) {
            this.val$exposureListener = sAExposureListener;
            this.val$mExposureView = exposureView;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public java.lang.Boolean call() {
            return java.lang.Boolean.valueOf(this.val$exposureListener.shouldExposure(this.val$mExposureView.getView(), this.val$mExposureView.getExposureData()));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.exposure.StayDurationRunnable$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureListener val$exposureListener;
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.exposure.ExposureView val$mExposureView;

        public AnonymousClass2(com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureListener sAExposureListener, com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView) {
            this.val$exposureListener = sAExposureListener;
            this.val$mExposureView = exposureView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$exposureListener.didExposure(this.val$mExposureView.getView(), this.val$mExposureView.getExposureData());
        }
    }

    public StayDurationRunnable(com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView) {
        this.mExposureView = exposureView;
    }

    private void didExposure(com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView) {
        try {
            com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureListener exposureListener = exposureView.getExposureData().getExposureListener();
            if (exposureListener == null || com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance().getUiThreadHandler() == null) {
                return;
            }
            com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance().getUiThreadHandler().post(new com.sensorsdata.analytics.android.sdk.exposure.StayDurationRunnable.AnonymousClass2(exposureListener, exposureView));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private boolean shouldExposure(com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView) {
        try {
            com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureListener exposureListener = exposureView.getExposureData().getExposureListener();
            if (exposureListener == null) {
                return true;
            }
            java.util.concurrent.FutureTask futureTask = new java.util.concurrent.FutureTask(new com.sensorsdata.analytics.android.sdk.exposure.StayDurationRunnable.AnonymousClass1(exposureListener, exposureView));
            com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance().getUiThreadHandler().post(futureTask);
            if (((java.lang.Boolean) futureTask.get(3000L, java.util.concurrent.TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Exposure fail, shouldExposure is false");
            return false;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (shouldExposure(this.mExposureView)) {
            org.json.JSONObject properties = this.mExposureView.getExposureData().getProperties();
            org.json.JSONObject jSONObject = properties == null ? new org.json.JSONObject() : new org.json.JSONObject(properties.toString());
            android.view.View view = this.mExposureView.getView();
            if (view == null) {
                return;
            }
            android.app.Activity activityOfView = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(view.getContext(), view);
            if (activityOfView != null) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "activity is not null.");
                org.json.JSONObject screenNameAndTitle = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getScreenNameAndTitle(view);
                if (screenNameAndTitle == null || android.text.TextUtils.isEmpty(screenNameAndTitle.toString())) {
                    screenNameAndTitle = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.buildTitleAndScreenName(activityOfView);
                }
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(screenNameAndTitle, jSONObject);
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "StayDurationRunnable:" + this.mExposureView);
            com.sensorsdata.analytics.android.sdk.util.visual.ViewNode viewNode = com.sensorsdata.analytics.android.sdk.util.visual.ViewTreeStatusObservable.getInstance().getViewNode(view);
            if (viewNode != null) {
                if (!android.text.TextUtils.isEmpty(viewNode.getViewPath())) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.ELEMENT_PATH, viewNode.getViewPath());
                }
                if (!android.text.TextUtils.isEmpty(viewNode.getViewPosition())) {
                    jSONObject.put(com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants.ELEMENT_POSITION, viewNode.getViewPosition());
                }
            }
            java.lang.String viewContent = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewContent(view);
            if (!android.text.TextUtils.isEmpty(viewContent)) {
                jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_CONTENT, viewContent);
            }
            jSONObject.put(com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants.ELEMENT_TYPE, com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getViewType(view));
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().track(this.mExposureView.getExposureData().getEvent(), jSONObject);
            didExposure(this.mExposureView);
            this.mExposureView.setLastVisible(true);
            this.mExposureView.setExposed(true);
            this.mExposureView.setActivityChange(false);
        }
    }
}
