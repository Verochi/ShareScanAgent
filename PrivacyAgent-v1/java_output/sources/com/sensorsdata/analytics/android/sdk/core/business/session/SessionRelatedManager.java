package com.sensorsdata.analytics.android.sdk.core.business.session;

/* loaded from: classes19.dex */
public class SessionRelatedManager {
    private static volatile com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager mSessionRelatedManager;
    private long mLastEventTime;
    private java.lang.String mSessionID;
    private long mStartTime;
    private final java.lang.String SHARED_PREF_SESSION_CUTDATA = "sensorsdata.session.cutdata";
    public final java.lang.String EVENT_SESSION_ID = "$event_session_id";
    private final java.lang.String KEY_SESSION_ID = "sessionID";
    private final java.lang.String KEY_START_TIME = com.umeng.analytics.AnalyticsConfig.RTD_START_TIME;
    private final java.lang.String KEY_LAST_EVENT_TIME = "lastEventTime";
    private long SESSION_LAST_INTERVAL_TIME = 300000;
    private final long SESSION_START_INTERVAL_TIME = com.heytap.mcssdk.constant.a.g;

    private SessionRelatedManager() {
        try {
            setSessionLastIntervalTime(com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getEventSessionTimeout());
            if (com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isEnableSession()) {
                readSessionData();
            } else {
                deleteSessionData();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private synchronized void createSessionData(long j, boolean z) {
        this.mSessionID = java.util.UUID.randomUUID().toString();
        if (z) {
            this.mStartTime = j;
        }
        this.mLastEventTime = java.lang.Math.max(j, this.mLastEventTime);
        com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setString("sensorsdata.session.cutdata", getSessionDataPack());
    }

    private void deleteSessionData() {
        this.mSessionID = null;
        this.mStartTime = -1L;
        this.mLastEventTime = -1L;
        com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().remove("sensorsdata.session.cutdata");
    }

    public static com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager getInstance() {
        if (mSessionRelatedManager == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager.class) {
                if (mSessionRelatedManager == null) {
                    mSessionRelatedManager = new com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager();
                }
            }
        }
        return mSessionRelatedManager;
    }

    private java.lang.String getSessionDataPack() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("sessionID", this.mSessionID);
            jSONObject.put(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, this.mStartTime);
            jSONObject.put("lastEventTime", this.mLastEventTime);
            return jSONObject.toString();
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    private synchronized void handleSessionState(long j) {
        if (j <= 0) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(this.mSessionID) && j - this.mLastEventTime <= this.SESSION_LAST_INTERVAL_TIME && j - this.mStartTime <= com.heytap.mcssdk.constant.a.g) {
            updateSessionLastTime(j);
        }
        createSessionData(j, true);
    }

    private void readSessionData() {
        java.lang.String string = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().getString("sensorsdata.session.cutdata", "");
        if (android.text.TextUtils.isEmpty(string)) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(string);
            if (jSONObject.has("sessionID")) {
                this.mSessionID = jSONObject.optString("sessionID");
            }
            if (jSONObject.has(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME)) {
                this.mStartTime = jSONObject.optLong(com.umeng.analytics.AnalyticsConfig.RTD_START_TIME);
            }
            if (jSONObject.has("lastEventTime")) {
                this.mLastEventTime = jSONObject.optLong("lastEventTime");
            }
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void setSessionLastIntervalTime(int i) {
        if (i > 0) {
            this.SESSION_LAST_INTERVAL_TIME = i * 1000;
        }
    }

    private void updateSessionLastTime(long j) {
        this.mLastEventTime = j;
        com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setString("sensorsdata.session.cutdata", getSessionDataPack());
    }

    public java.lang.String getSessionID() {
        return this.mSessionID;
    }

    public void handleEventOfSession(java.lang.String str, org.json.JSONObject jSONObject, long j) {
        if (com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isEnableSession()) {
            try {
                if (!"$AppEnd".equals(str)) {
                    handleSessionState(j);
                    jSONObject.put("$event_session_id", this.mSessionID);
                } else if (j > this.mLastEventTime) {
                    this.mLastEventTime = j;
                }
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public void refreshSessionByTimer(long j) {
        if (j - this.mLastEventTime > this.SESSION_LAST_INTERVAL_TIME) {
            createSessionData(j, android.text.TextUtils.isEmpty(this.mSessionID));
        }
    }
}
