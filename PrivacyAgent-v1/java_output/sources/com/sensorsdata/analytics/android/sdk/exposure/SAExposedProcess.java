package com.sensorsdata.analytics.android.sdk.exposure;

/* loaded from: classes19.dex */
public class SAExposedProcess {
    private static final long DELAY_TIME = 500;
    private static final java.lang.String TAG = "SA.SAExposedProcess";
    private boolean isActivityChange;
    private com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack mCallBack;
    private java.util.WeakHashMap<android.app.Activity, com.sensorsdata.analytics.android.sdk.exposure.ExposedPage> mExposedPageWeakHashMap;
    private com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform mExposedTransform;
    private final com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig mExposureConfig;
    private com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.ExposureRunnable mExposureRunnable;
    private android.os.Handler mHandler;
    private java.lang.String mLastActivityUrl = "";
    private java.util.WeakHashMap<com.sensorsdata.analytics.android.sdk.exposure.ExposureView, com.sensorsdata.analytics.android.sdk.exposure.StayDurationRunnable> mStayDurationRunnableWeakHashMap;

    /* renamed from: com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack {
        public AnonymousClass1() {
        }

        @Override // com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack
        public int getExposureViewSize(android.app.Activity activity) {
            com.sensorsdata.analytics.android.sdk.exposure.ExposedPage exposedPage;
            try {
                if (com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposedPageWeakHashMap == null || (exposedPage = (com.sensorsdata.analytics.android.sdk.exposure.ExposedPage) com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposedPageWeakHashMap.get(activity)) == null) {
                    return 0;
                }
                return exposedPage.getExposureViewSize();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return 0;
            }
        }

        @Override // com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack
        public java.util.Collection<com.sensorsdata.analytics.android.sdk.exposure.ExposureView> getExposureViews(android.app.Activity activity) {
            com.sensorsdata.analytics.android.sdk.exposure.ExposedPage exposedPage;
            try {
                if (com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposedPageWeakHashMap == null || (exposedPage = (com.sensorsdata.analytics.android.sdk.exposure.ExposedPage) com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposedPageWeakHashMap.get(activity)) == null) {
                    return null;
                }
                return exposedPage.getExposureViews();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                return null;
            }
        }

        @Override // com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack
        public void onActivityPaused(android.app.Activity activity) {
            try {
                if (com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposedPageWeakHashMap == null) {
                    return;
                }
                com.sensorsdata.analytics.android.sdk.exposure.ExposedPage exposedPage = (com.sensorsdata.analytics.android.sdk.exposure.ExposedPage) com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposedPageWeakHashMap.get(activity);
                if (exposedPage != null) {
                    exposedPage.invisibleElement();
                }
                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.removeStayDurationRunnable();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }

        @Override // com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack
        public void onActivityResumed(android.app.Activity activity) {
            com.sensorsdata.analytics.android.sdk.exposure.ExposedPage exposedPage;
            try {
                java.lang.String canonicalName = activity.getClass().getCanonicalName();
                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess sAExposedProcess = com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this;
                sAExposedProcess.isActivityChange = !sAExposedProcess.mLastActivityUrl.equals(canonicalName);
                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mLastActivityUrl = canonicalName;
                if (com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.isActivityChange && (exposedPage = (com.sensorsdata.analytics.android.sdk.exposure.ExposedPage) com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposedPageWeakHashMap.get(activity)) != null) {
                    for (com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView : exposedPage.getExposureViews()) {
                        if (exposureView != null) {
                            exposureView.setActivityChange(true);
                        }
                    }
                }
                viewLayoutChange(activity);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }

        @Override // com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.CallBack
        public void viewLayoutChange(android.app.Activity activity) {
            if (com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposureRunnable != null) {
                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mHandler.removeCallbacks(com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposureRunnable);
            }
            com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.removeStayDurationRunnable();
            com.sensorsdata.analytics.android.sdk.exposure.ExposedPage exposedPage = (com.sensorsdata.analytics.android.sdk.exposure.ExposedPage) com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposedPageWeakHashMap.get(activity);
            if (exposedPage != null) {
                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess sAExposedProcess = com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this;
                sAExposedProcess.mExposureRunnable = sAExposedProcess.new ExposureRunnable(exposedPage, null);
                if (com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposureConfig == null) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.TAG, "delayTime->500ms");
                    com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mHandler.postDelayed(com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposureRunnable, 500L);
                    return;
                }
                com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.TAG, "delayTime:" + com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposureConfig.getDelayTime());
                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mHandler.postDelayed(com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposureRunnable, com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mExposureConfig.getDelayTime());
            }
        }
    }

    public interface CallBack {
        int getExposureViewSize(android.app.Activity activity);

        java.util.Collection<com.sensorsdata.analytics.android.sdk.exposure.ExposureView> getExposureViews(android.app.Activity activity);

        void onActivityPaused(android.app.Activity activity);

        void onActivityResumed(android.app.Activity activity);

        void viewLayoutChange(android.app.Activity activity);
    }

    public class ExposureRunnable implements java.lang.Runnable {
        private final com.sensorsdata.analytics.android.sdk.exposure.ExposedPage mExposedPage;
        private final android.view.View mView;

        public ExposureRunnable(com.sensorsdata.analytics.android.sdk.exposure.ExposedPage exposedPage, android.view.View view) {
            this.mExposedPage = exposedPage;
            this.mView = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                for (com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView : this.mExposedPage.getExposureViewList(this.mView)) {
                    if (exposureView.getView() != null && exposureView.isViewLayoutChange()) {
                        synchronized (com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.class) {
                            com.sensorsdata.analytics.android.sdk.exposure.StayDurationRunnable stayDurationRunnable = (com.sensorsdata.analytics.android.sdk.exposure.StayDurationRunnable) com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mStayDurationRunnableWeakHashMap.get(exposureView);
                            if (stayDurationRunnable != null) {
                                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mHandler.removeCallbacks(stayDurationRunnable);
                                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mStayDurationRunnableWeakHashMap.remove(exposureView);
                            }
                            com.sensorsdata.analytics.android.sdk.SALog.i(com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.TAG, "ExposureRunnable->exposureView:" + exposureView);
                            com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData exposureData = exposureView.getExposureData();
                            if (exposureData != null) {
                                long stayDuration = (long) (exposureData.getExposureConfig().getStayDuration() * 1000.0d);
                                com.sensorsdata.analytics.android.sdk.exposure.StayDurationRunnable stayDurationRunnable2 = new com.sensorsdata.analytics.android.sdk.exposure.StayDurationRunnable(exposureView);
                                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mStayDurationRunnableWeakHashMap.put(exposureView, stayDurationRunnable2);
                                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.this.mHandler.postDelayed(stayDurationRunnable2, stayDuration);
                                exposureView.setViewLayoutChange(false);
                            }
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public SAExposedProcess(com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig sAExposureConfig) {
        this.mExposureConfig = sAExposureConfig;
    }

    private android.app.Activity exposureProcess(android.view.View view, com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData, boolean z) throws java.lang.Exception {
        com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView = null;
        if (view == null || sAExposureData == null) {
            return null;
        }
        android.app.Activity activityOfView = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(view.getContext(), view);
        if (activityOfView == null) {
            activityOfView = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
        }
        if (activityOfView == null) {
            return null;
        }
        init();
        com.sensorsdata.analytics.android.sdk.exposure.ExposedPage exposedPage = this.mExposedPageWeakHashMap.get(activityOfView);
        if (exposedPage == null) {
            exposedPage = new com.sensorsdata.analytics.android.sdk.exposure.ExposedPage();
            this.mExposedPageWeakHashMap.put(activityOfView, exposedPage);
        }
        if (z && sAExposureData.getExposureConfig() == null) {
            sAExposureData.setExposureConfig(this.mExposureConfig);
        }
        java.lang.String identifier = sAExposureData.getIdentifier();
        if (!android.text.TextUtils.isEmpty(identifier)) {
            com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView2 = exposedPage.getExposureView(identifier);
            com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView3 = exposedPage.getExposureView(view);
            if (exposureView3 != null && exposureView3.getExposureData() != null && exposureView3.getExposureData().getIdentifier() != null && !exposureView3.getExposureData().getIdentifier().equals(sAExposureData.getIdentifier())) {
                exposureView3.setLastVisible(false);
            }
            if (exposureView2 != null) {
                exposureView = exposureView2.m95clone();
                exposureView.setView(view);
                if (z) {
                    exposureView.setExposureData(sAExposureData);
                }
            }
        } else if (exposedPage.getExposureView(view) != null) {
            exposureView = exposedPage.getExposureView(view);
            exposureView.setExposureData(sAExposureData);
        }
        if (exposureView == null) {
            exposureView = new com.sensorsdata.analytics.android.sdk.exposure.ExposureView(sAExposureData, false, false, view);
        }
        if (z) {
            exposureView.setAddExposureView(true);
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "addExposureView:" + exposureView);
        exposedPage.addExposureView(view, exposureView);
        exposedPage.addExposureView(sAExposureData.getIdentifier(), exposureView);
        return activityOfView;
    }

    private synchronized void init() {
        try {
            if (this.mExposedPageWeakHashMap == null) {
                this.mExposedPageWeakHashMap = new java.util.WeakHashMap<>();
                this.mStayDurationRunnableWeakHashMap = new java.util.WeakHashMap<>();
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("SA.Exposured");
                handlerThread.start();
                this.mHandler = new android.os.Handler(handlerThread.getLooper());
                com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.AnonymousClass1 anonymousClass1 = new com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.AnonymousClass1();
                this.mCallBack = anonymousClass1;
                this.mExposedTransform = new com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform(anonymousClass1);
                com.sensorsdata.analytics.android.sdk.monitor.SensorsDataLifecycleMonitorManager.getInstance().addActivityLifeCallback(this.mExposedTransform);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeStayDurationRunnable() {
        synchronized (com.sensorsdata.analytics.android.sdk.exposure.SAExposedProcess.class) {
            java.util.WeakHashMap<com.sensorsdata.analytics.android.sdk.exposure.ExposureView, com.sensorsdata.analytics.android.sdk.exposure.StayDurationRunnable> weakHashMap = this.mStayDurationRunnableWeakHashMap;
            if (weakHashMap == null) {
                return;
            }
            java.util.Iterator<com.sensorsdata.analytics.android.sdk.exposure.ExposureView> it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                com.sensorsdata.analytics.android.sdk.exposure.ExposureView next = it.next();
                if (next != null && next.isViewLayoutChange()) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "remove ExposureView = " + next);
                    this.mHandler.removeCallbacks(this.mStayDurationRunnableWeakHashMap.get(next));
                    it.remove();
                }
            }
        }
    }

    private boolean verifyExposureData(com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData) {
        if (sAExposureData == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SAExposureData is null");
            return false;
        }
        if (android.text.TextUtils.isEmpty(sAExposureData.getEvent())) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "EventName is empty or null");
            return false;
        }
        com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig exposureConfig = sAExposureData.getExposureConfig();
        if (exposureConfig == null) {
            com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig sAExposureConfig = this.mExposureConfig;
            if (sAExposureConfig != null && (sAExposureConfig.getAreaRate() > 1.0f || this.mExposureConfig.getAreaRate() < 0.0f)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Global SAExposureConfig areaRate must be 0~1");
                sAExposureData.setExposureConfig(new com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureConfig(0.0f, this.mExposureConfig.getStayDuration(), this.mExposureConfig.isRepeated()));
            }
        } else if (exposureConfig.getAreaRate() > 1.0f || exposureConfig.getAreaRate() < 0.0f) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SAExposureConfig areaRate must be 0~1");
            exposureConfig.setAreaRate(0.0f);
            return true;
        }
        return true;
    }

    public void addExposureView(android.view.View view, com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData) {
        android.app.Activity exposureProcess;
        try {
            if (verifyExposureData(sAExposureData) && (exposureProcess = exposureProcess(view, sAExposureData, true)) != null) {
                this.mCallBack.viewLayoutChange(exposureProcess);
                com.sensorsdata.analytics.android.sdk.exposure.ExposedTransform exposedTransform = this.mExposedTransform;
                if (exposedTransform != null) {
                    exposedTransform.observerWindow(exposureProcess);
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void removeExposureView(android.view.View view, java.lang.String str) {
        if (view == null) {
            return;
        }
        android.app.Activity activityOfView = com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(view.getContext(), view);
        if (activityOfView == null) {
            activityOfView = com.sensorsdata.analytics.android.sdk.util.AppStateTools.getInstance().getForegroundActivity();
        }
        if (activityOfView == null) {
            return;
        }
        java.util.WeakHashMap<android.app.Activity, com.sensorsdata.analytics.android.sdk.exposure.ExposedPage> weakHashMap = this.mExposedPageWeakHashMap;
        com.sensorsdata.analytics.android.sdk.exposure.ExposedPage exposedPage = weakHashMap != null ? weakHashMap.get(activityOfView) : null;
        if (exposedPage != null) {
            exposedPage.removeExposureView(view, str);
        }
    }

    public void setExposureIdentifier(android.view.View view, java.lang.String str) {
        try {
            exposureProcess(view, new com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData(null, null, str, null), false);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public synchronized void updateExposureView(android.view.View view, org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.exposure.ExposureView exposureView;
        if (view == null) {
            return;
        }
        com.sensorsdata.analytics.android.sdk.exposure.ExposedPage exposedPage = this.mExposedPageWeakHashMap.get(com.sensorsdata.analytics.android.sdk.util.SAViewUtils.getActivityOfView(view.getContext(), view));
        if (exposedPage != null && (exposureView = exposedPage.getExposureView(view)) != null && exposureView.getExposureData() != null) {
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject, exposureView.getExposureData().getProperties());
        }
    }
}
