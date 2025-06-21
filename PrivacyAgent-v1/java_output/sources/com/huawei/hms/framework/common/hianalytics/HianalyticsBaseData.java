package com.huawei.hms.framework.common.hianalytics;

/* loaded from: classes22.dex */
public abstract class HianalyticsBaseData {
    public static final java.lang.String EVENT_ID = "url_request";
    public static final java.lang.String SDK_NAME = "sdk_name";
    public static final java.lang.String SDK_TYPE = "sdk_type";
    public static final java.lang.String SDK_VERSION = "sdk_version";
    private static final java.lang.String TAG = "HianalyticsBaseData";
    private java.util.LinkedHashMap<java.lang.String, java.lang.String> data;

    public HianalyticsBaseData() {
        java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap = new java.util.LinkedHashMap<>();
        this.data = linkedHashMap;
        linkedHashMap.put("sdk_type", "UxPP");
        this.data.put(SDK_NAME, "networkkit");
    }

    public java.util.LinkedHashMap<java.lang.String, java.lang.String> get() {
        return this.data;
    }

    public com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData put(java.lang.String str, long j) {
        if (str == null) {
            com.huawei.hms.framework.common.Logger.v(TAG, "key = null : value = " + j);
        } else {
            this.data.put(str, "" + j);
        }
        return this;
    }

    public com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData put(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            com.huawei.hms.framework.common.Logger.v(TAG, "key = " + str + " : value = " + str2);
        } else {
            this.data.put(str, str2);
        }
        return this;
    }

    public com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData put(java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            com.huawei.hms.framework.common.Logger.v(TAG, "data is null");
        } else {
            this.data.putAll(linkedHashMap);
        }
        return this;
    }

    public com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData putIfNotDefault(java.lang.String str, long j, long j2) {
        return j == j2 ? this : put(str, j);
    }

    public java.lang.String toString() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : get().entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (org.json.JSONException e) {
            com.huawei.hms.framework.common.Logger.w(TAG, "catch JSONException", e);
        }
        return jSONObject.toString();
    }
}
