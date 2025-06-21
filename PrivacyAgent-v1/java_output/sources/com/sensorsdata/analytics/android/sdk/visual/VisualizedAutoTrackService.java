package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
public class VisualizedAutoTrackService {
    private static final java.lang.String TAG = "SA.VisualizedAutoTrackService";
    private static com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService instance;
    private static com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackViewCrawler mVTrack;
    private boolean mDebugModeEnabled = false;
    private java.lang.String mLastDebugInfo;
    private com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper mVisualDebugHelper;
    private com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesLog mVisualPropertiesLog;

    private VisualizedAutoTrackService() {
    }

    public static com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService getInstance() {
        if (instance == null) {
            instance = new com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService();
        }
        return instance;
    }

    public java.lang.String getDebugInfo() {
        try {
            com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper visualDebugHelper = this.mVisualDebugHelper;
            if (visualDebugHelper == null) {
                return null;
            }
            java.lang.String debugInfo = visualDebugHelper.getDebugInfo();
            this.mLastDebugInfo = debugInfo;
            if (android.text.TextUtils.isEmpty(debugInfo)) {
                return null;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "visual debug info: " + this.mLastDebugInfo);
            return this.mLastDebugInfo;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public java.lang.String getLastDebugInfo() {
        try {
            if (android.text.TextUtils.isEmpty(this.mLastDebugInfo)) {
                return null;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "last debug info: " + this.mLastDebugInfo);
            return this.mLastDebugInfo;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public java.lang.String getVisualLogInfo() {
        try {
            com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesLog visualPropertiesLog = this.mVisualPropertiesLog;
            if (visualPropertiesLog == null) {
                return null;
            }
            java.lang.String visualPropertiesLog2 = visualPropertiesLog.getVisualPropertiesLog();
            if (android.text.TextUtils.isEmpty(visualPropertiesLog2)) {
                return null;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "visual log info: " + visualPropertiesLog2);
            return visualPropertiesLog2;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public boolean isServiceRunning() {
        com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackViewCrawler visualizedAutoTrackViewCrawler = mVTrack;
        if (visualizedAutoTrackViewCrawler != null) {
            return visualizedAutoTrackViewCrawler.isServiceRunning();
        }
        return false;
    }

    public void resume() {
        try {
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackViewCrawler visualizedAutoTrackViewCrawler = mVTrack;
            if (visualizedAutoTrackViewCrawler != null) {
                visualizedAutoTrackViewCrawler.startUpdates();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void setDebugModeEnabled(boolean z) {
        try {
            if (this.mDebugModeEnabled != z) {
                if (z) {
                    this.mVisualPropertiesLog = new com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesLog();
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().registerCollectLogListener(this.mVisualPropertiesLog);
                } else {
                    this.mVisualPropertiesLog = null;
                    com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager.getInstance().unRegisterCollectLogListener();
                }
            }
            this.mDebugModeEnabled = z;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void start(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        try {
            android.os.Bundle bundle = activity.getApplicationContext().getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128).metaData;
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            java.lang.String string = bundle.getString("com.sensorsdata.analytics.android.ResourcePackageName");
            if (string == null) {
                string = activity.getPackageName();
            }
            java.lang.String str3 = string;
            if (this.mVisualDebugHelper == null) {
                this.mVisualDebugHelper = new com.sensorsdata.analytics.android.sdk.visual.VisualDebugHelper();
            }
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackViewCrawler visualizedAutoTrackViewCrawler = new com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackViewCrawler(activity, str3, str, str2, this.mVisualDebugHelper);
            mVTrack = visualizedAutoTrackViewCrawler;
            visualizedAutoTrackViewCrawler.startUpdates();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void stop() {
        try {
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackViewCrawler visualizedAutoTrackViewCrawler = mVTrack;
            if (visualizedAutoTrackViewCrawler != null) {
                visualizedAutoTrackViewCrawler.stopUpdates(false);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
