package com.sensorsdata.analytics.android.sdk.plugin.property.beans;

/* loaded from: classes19.dex */
public class SAPropertiesFetcher {
    private final java.util.Map<java.lang.String, org.json.JSONObject> eventJson = new java.util.HashMap();

    public org.json.JSONObject getEventJson(java.lang.String str) {
        return this.eventJson.get(str);
    }

    public org.json.JSONObject getProperties() {
        return this.eventJson.get("properties");
    }

    public void setEventJson(java.lang.String str, org.json.JSONObject jSONObject) {
        this.eventJson.put(str, jSONObject);
    }

    public void setProperties(org.json.JSONObject jSONObject) {
        this.eventJson.put("properties", jSONObject);
    }

    public java.lang.String toString() {
        return "SAPropertiesFetcher{eventJson=" + this.eventJson + '}';
    }
}
