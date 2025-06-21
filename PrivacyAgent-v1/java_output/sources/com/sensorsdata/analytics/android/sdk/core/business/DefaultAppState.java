package com.sensorsdata.analytics.android.sdk.core.business;

/* loaded from: classes19.dex */
public class DefaultAppState implements com.sensorsdata.analytics.android.sdk.util.AppStateTools.AppState {
    private final com.sensorsdata.analytics.android.sdk.SensorsDataAPI mSensorsDataInstance;
    private boolean resumeFromBackground = false;
    private boolean mIsResumeScreenOrientation = false;

    public DefaultAppState(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI) {
        this.mSensorsDataInstance = sensorsDataAPI;
    }

    @Override // com.sensorsdata.analytics.android.sdk.util.AppStateTools.AppState
    public void onBackground() {
        try {
            if (this.mSensorsDataInstance.getSAContextManager().getOrientationDetector() == null || !this.mSensorsDataInstance.getSAContextManager().getOrientationDetector().isEnableState()) {
                this.mIsResumeScreenOrientation = false;
            } else {
                this.mSensorsDataInstance.stopTrackScreenOrientation();
                this.mIsResumeScreenOrientation = true;
            }
            this.mSensorsDataInstance.getSAContextManager().getRemoteManager().resetPullSDKConfigTimer();
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_STOP_HEATMAP_SERVICE, new java.lang.Object[0]);
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_STOP_VISUAL_SERVICE, new java.lang.Object[0]);
            com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.getInstance().appEnterBackground();
            this.mSensorsDataInstance.clearLastScreenUrl();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.util.AppStateTools.AppState
    public void onForeground() {
        try {
            com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.getInstance().appBecomeActive();
            if (this.resumeFromBackground) {
                this.mSensorsDataInstance.getSAContextManager().getRemoteManager().applySDKConfigFromCache();
                if (this.mIsResumeScreenOrientation) {
                    this.mSensorsDataInstance.resumeTrackScreenOrientation();
                }
                try {
                    com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_RESUME_HEATMAP_SERVICE, new java.lang.Object[0]);
                    com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_RESUME_VISUAL_SERVICE, new java.lang.Object[0]);
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
            this.mSensorsDataInstance.getSAContextManager().getRemoteManager().pullSDKConfigFromServer();
            this.resumeFromBackground = true;
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }
}
