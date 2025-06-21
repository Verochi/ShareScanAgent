package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
class VisualizedAutoTrackViewCrawler extends com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler {
    private com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper mVisualDebugHelper;

    public VisualizedAutoTrackViewCrawler(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper visualDebugHelper) {
        super(activity, str, str2, str3, com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler.TYPE_VISUAL);
        this.mVisualDebugHelper = visualDebugHelper;
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler, com.sensorsdata.analytics.android.sdk.visual.VTrack
    public void startUpdates() {
        try {
            super.startUpdates();
            com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper visualDebugHelper = this.mVisualDebugHelper;
            if (visualDebugHelper != null) {
                visualDebugHelper.stopMonitor();
                this.mVisualDebugHelper.startMonitor();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.visual.AbstractViewCrawler, com.sensorsdata.analytics.android.sdk.visual.VTrack
    public void stopUpdates(boolean z) {
        try {
            super.stopUpdates(z);
            com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper visualDebugHelper = this.mVisualDebugHelper;
            if (visualDebugHelper != null) {
                visualDebugHelper.stopMonitor();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
