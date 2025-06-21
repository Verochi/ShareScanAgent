package com.sensorsdata.analytics.android.sdk.data.adapter;

/* loaded from: classes19.dex */
public class DbAdapter {
    private static com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter instance;
    private final com.sensorsdata.analytics.android.sdk.data.adapter.DbParams mDbParams;
    private com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation mPersistentOperation;
    private com.sensorsdata.analytics.android.sdk.data.adapter.DataOperation mTrackEventOperation;

    private DbAdapter(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mDbParams = com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance(sAContextManager.getContext().getPackageName());
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = sAContextManager.getInternalConfigs().saConfigOptions;
        if (sAConfigOptions.isEnableEncrypt()) {
            this.mTrackEventOperation = new com.sensorsdata.analytics.android.sdk.data.adapter.EncryptDataOperation(sAContextManager.getContext().getApplicationContext());
        } else if (sAConfigOptions.isTransportEncrypt()) {
            this.mTrackEventOperation = new com.sensorsdata.analytics.android.sdk.data.adapter.TransportEncryption(sAContextManager.getContext().getApplicationContext());
        } else {
            this.mTrackEventOperation = new com.sensorsdata.analytics.android.sdk.data.adapter.EventDataOperation(sAContextManager.getContext().getApplicationContext());
        }
        this.mPersistentOperation = new com.sensorsdata.analytics.android.sdk.data.adapter.PersistentDataOperation(sAContextManager.getContext().getApplicationContext());
    }

    public static java.lang.String decodeIdentities(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return com.sensorsdata.analytics.android.sdk.util.Base64Coder.decodeString(str.substring(str.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1));
    }

    public static com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter getInstance() {
        com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter dbAdapter = instance;
        if (dbAdapter != null) {
            return dbAdapter;
        }
        throw new java.lang.IllegalStateException("The static method getInstance(SAContextManager saContextManager) should be called before calling getInstance()");
    }

    public static com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter getInstance(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        if (instance == null) {
            instance = new com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter(sAContextManager);
        }
        return instance;
    }

    public void addChannelEvent(java.lang.String str) {
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME, str);
            this.mTrackEventOperation.insertData(this.mDbParams.getChannelPersistentUri(), contentValues);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public int addJSON(org.json.JSONObject jSONObject) {
        int insertData = this.mTrackEventOperation.insertData(this.mDbParams.getEventUri(), jSONObject);
        return insertData == 0 ? this.mTrackEventOperation.queryDataCount(this.mDbParams.getEventUri(), 2) : insertData;
    }

    public int cleanupEvents(org.json.JSONArray jSONArray, boolean z) {
        this.mTrackEventOperation.deleteData(this.mDbParams.getEventUri(), jSONArray);
        return this.mTrackEventOperation.queryDataCount(this.mDbParams.getEventUri(), z ? 1 : 0);
    }

    public void commitActivityCount(int i) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getActivityStartCountUri(), new org.json.JSONObject().put("value", i));
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void commitAppExitData(java.lang.String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getAppExitDataUri(), new org.json.JSONObject().put("value", str));
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void commitAppStartTime(long j) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getAppStartTimeUri(), new org.json.JSONObject().put("value", j));
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void commitIdentities(java.lang.String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getUserIdentities(), new org.json.JSONObject().put("value", "Base64:" + com.sensorsdata.analytics.android.sdk.util.Base64Coder.encodeString(str)));
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void commitLoginId(java.lang.String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getLoginIdUri(), new org.json.JSONObject().put("value", str));
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void commitLoginIdKey(java.lang.String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getLoginIdKeyUri(), new org.json.JSONObject().put("value", str));
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void commitPushID(java.lang.String str, java.lang.String str2) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getPushIdUri(), new org.json.JSONObject().put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY, str).put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_VALUE, str2));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void commitRemoteConfig(java.lang.String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getRemoteConfigUri(), new org.json.JSONObject().put("value", str));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void commitSessionIntervalTime(int i) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getSessionTimeUri(), new org.json.JSONObject().put("value", i));
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void commitSubProcessFlushState(boolean z) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getSubProcessUri(), new org.json.JSONObject().put("value", z));
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void deleteAllEvents() {
        this.mTrackEventOperation.deleteData(this.mDbParams.getEventUri(), "DB_DELETE_ALL");
    }

    public java.lang.String[] generateDataString(java.lang.String str, int i, boolean z) {
        try {
            return this.mTrackEventOperation.queryData(this.mDbParams.getEventUri(), z, i);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public int getActivityCount() {
        java.lang.String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getActivityStartCountUri(), 1);
        if (queryData == null || queryData.length <= 0) {
            return 0;
        }
        return java.lang.Integer.parseInt(queryData[0]);
    }

    public java.lang.String getAppExitData() {
        try {
            java.lang.String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getAppExitDataUri(), 1);
            return (queryData == null || queryData.length <= 0) ? "" : queryData[0];
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public long getAppStartTime() {
        try {
            java.lang.String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getAppStartTimeUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return 0L;
            }
            return java.lang.Long.parseLong(queryData[0]);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return 0L;
        }
    }

    public java.lang.String getIdentities() {
        try {
            java.lang.String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getUserIdentities(), 1);
            if (queryData == null || queryData.length <= 0) {
                return null;
            }
            return decodeIdentities(queryData[0]);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    public java.lang.String getLoginId() {
        try {
            java.lang.String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getLoginIdUri(), 1);
            return (queryData == null || queryData.length <= 0) ? "" : queryData[0];
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public java.lang.String getLoginIdKey() {
        try {
            java.lang.String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getLoginIdKeyUri(), 1);
            return (queryData == null || queryData.length <= 0) ? "" : queryData[0];
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public java.lang.String getPushId(java.lang.String str) {
        try {
            java.lang.String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getPushIdUri().buildUpon().appendQueryParameter(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY, str).build(), 1);
            return (queryData == null || queryData.length <= 0) ? "" : queryData[0];
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public java.lang.String getRemoteConfig() {
        try {
            java.lang.String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getRemoteConfigUri(), 1);
            return (queryData == null || queryData.length <= 0) ? "" : queryData[0];
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public java.lang.String getRemoteConfigFromLocal() {
        try {
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentRemoteSDKConfig remoteSDKConfig = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getRemoteSDKConfig();
            return remoteSDKConfig == null ? "" : remoteSDKConfig.get();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    public int getSessionIntervalTime() {
        try {
            java.lang.String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getSessionTimeUri(), 1);
            if (queryData != null && queryData.length > 0) {
                return java.lang.Integer.parseInt(queryData[0]);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return 0;
    }

    public boolean isFirstChannelEvent(java.lang.String[] strArr) {
        try {
            return this.mTrackEventOperation.queryDataCount(this.mDbParams.getChannelPersistentUri(), null, "event_name = ? or event_name = ? ", strArr, null) <= 0;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    public boolean isSubProcessFlushing() {
        try {
            java.lang.String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getSubProcessUri(), 1);
            if (queryData != null && queryData.length > 0) {
                return java.lang.Integer.parseInt(queryData[0]) == 1;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return true;
    }

    public void removePushId(java.lang.String str) {
        this.mPersistentOperation.deleteData(this.mDbParams.getPushIdUri(), str);
    }
}
