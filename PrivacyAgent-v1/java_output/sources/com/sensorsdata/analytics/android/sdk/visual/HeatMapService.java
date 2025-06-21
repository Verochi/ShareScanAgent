package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
public class HeatMapService {
    private static com.sensorsdata.analytics.android.sdk.visual.HeatMapService instance;
    private static com.sensorsdata.analytics.android.sdk.visual.HeatMapViewCrawler mVTrack;

    private HeatMapService() {
    }

    public static com.sensorsdata.analytics.android.sdk.visual.HeatMapService getInstance() {
        if (instance == null) {
            instance = new com.sensorsdata.analytics.android.sdk.visual.HeatMapService();
        }
        return instance;
    }

    public boolean isServiceRunning() {
        com.sensorsdata.analytics.android.sdk.visual.HeatMapViewCrawler heatMapViewCrawler = mVTrack;
        if (heatMapViewCrawler != null) {
            return heatMapViewCrawler.isServiceRunning();
        }
        return false;
    }

    public void resume() {
        try {
            com.sensorsdata.analytics.android.sdk.visual.HeatMapViewCrawler heatMapViewCrawler = mVTrack;
            if (heatMapViewCrawler != null) {
                heatMapViewCrawler.startUpdates();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void start(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i("HeatMapService", "HeatMapService service");
            android.os.Bundle bundle = activity.getApplicationContext().getPackageManager().getApplicationInfo(activity.getApplicationContext().getPackageName(), 128).metaData;
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            java.lang.String string = bundle.getString("com.sensorsdata.analytics.android.ResourcePackageName");
            if (string == null) {
                string = activity.getPackageName();
            }
            com.sensorsdata.analytics.android.sdk.visual.HeatMapViewCrawler heatMapViewCrawler = new com.sensorsdata.analytics.android.sdk.visual.HeatMapViewCrawler(activity, string, str, str2);
            mVTrack = heatMapViewCrawler;
            heatMapViewCrawler.startUpdates();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void stop() {
        try {
            com.sensorsdata.analytics.android.sdk.visual.HeatMapViewCrawler heatMapViewCrawler = mVTrack;
            if (heatMapViewCrawler != null) {
                heatMapViewCrawler.stopUpdates(false);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
