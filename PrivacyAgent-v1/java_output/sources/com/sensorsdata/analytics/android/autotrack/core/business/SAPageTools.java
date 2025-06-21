package com.sensorsdata.analytics.android.autotrack.core.business;

/* loaded from: classes19.dex */
public class SAPageTools {
    private static java.lang.String mCurrentScreenUrl;
    private static java.lang.String mCurrentTitle;
    private static java.lang.String mLastScreenUrl;
    private static java.lang.String mReferrerTitle;
    private static org.json.JSONObject sCurrentScreenTrackProperties;
    private static org.json.JSONObject sLastTrackProperties;
    private static java.lang.String sReferrer;
    private static long sReferrerTitleTime;
    private static long sReferrerUrlTime;
    private static long sTrackPropertiesTime;

    public static java.lang.String getCurrentScreenUrl() {
        return mCurrentScreenUrl;
    }

    public static java.lang.String getCurrentTitle() {
        return mCurrentTitle;
    }

    public static java.lang.String getLastScreenUrl() {
        return mLastScreenUrl;
    }

    public static org.json.JSONObject getLastTrackProperties() {
        return sLastTrackProperties;
    }

    public static java.lang.String getReferrer() {
        return sReferrer;
    }

    public static java.lang.String getReferrerTitle() {
        return mReferrerTitle;
    }

    public static java.lang.String getScreenUrl(java.lang.Object obj) {
        java.lang.String str = null;
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) {
                str = ((com.sensorsdata.analytics.android.sdk.ScreenAutoTracker) obj).getScreenUrl();
            } else {
                com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackAppViewScreenUrl sensorsDataAutoTrackAppViewScreenUrl = (com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackAppViewScreenUrl) obj.getClass().getAnnotation(com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackAppViewScreenUrl.class);
                if (sensorsDataAutoTrackAppViewScreenUrl != null) {
                    str = sensorsDataAutoTrackAppViewScreenUrl.url();
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return str == null ? obj.getClass().getCanonicalName() : str;
    }

    public static void setCurrentScreenTrackProperties(org.json.JSONObject jSONObject) {
        if (java.lang.System.currentTimeMillis() - sTrackPropertiesTime >= 400) {
            sLastTrackProperties = sCurrentScreenTrackProperties;
            sTrackPropertiesTime = java.lang.System.currentTimeMillis();
        }
        sCurrentScreenTrackProperties = jSONObject;
    }

    public static void setCurrentScreenUrl(java.lang.String str) {
        if (java.lang.System.currentTimeMillis() - sReferrerUrlTime >= 400) {
            sReferrer = mCurrentScreenUrl;
            sReferrerUrlTime = java.lang.System.currentTimeMillis();
        }
        mLastScreenUrl = mCurrentScreenUrl;
        mCurrentScreenUrl = str;
    }

    public static void setCurrentTitle(java.lang.String str) {
        if (java.lang.System.currentTimeMillis() - sReferrerTitleTime >= 400) {
            mReferrerTitle = mCurrentTitle;
            sReferrerTitleTime = java.lang.System.currentTimeMillis();
        }
        mCurrentTitle = str;
    }

    public static void setLastScreenUrl(java.lang.String str) {
        mLastScreenUrl = str;
    }
}
