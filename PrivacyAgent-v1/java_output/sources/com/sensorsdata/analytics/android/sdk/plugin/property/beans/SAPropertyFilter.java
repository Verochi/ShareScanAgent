package com.sensorsdata.analytics.android.sdk.plugin.property.beans;

/* loaded from: classes19.dex */
public class SAPropertyFilter {
    public static final java.lang.String IDENTITIES = "identities";
    public static final java.lang.String LIB = "lib";
    public static final java.lang.String PROPERTIES = "properties";
    private java.lang.String event;
    private final java.util.Map<java.lang.String, org.json.JSONObject> eventJson = new java.util.HashMap();
    long time;
    private com.sensorsdata.analytics.android.sdk.internal.beans.EventType type;

    public java.lang.String getEvent() {
        return this.event;
    }

    public org.json.JSONObject getEventJson(java.lang.String str) {
        return this.eventJson.get(str);
    }

    public org.json.JSONObject getProperties() {
        return this.eventJson.get("properties");
    }

    public long getTime() {
        return this.time;
    }

    public com.sensorsdata.analytics.android.sdk.internal.beans.EventType getType() {
        return this.type;
    }

    public void setEvent(java.lang.String str) {
        this.event = str;
    }

    public void setEventJson(java.lang.String str, org.json.JSONObject jSONObject) {
        this.eventJson.put(str, jSONObject);
    }

    public void setProperties(org.json.JSONObject jSONObject) {
        this.eventJson.put("properties", jSONObject);
    }

    public void setTime(long j) {
        this.time = j;
    }

    public void setType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType) {
        this.type = eventType;
    }

    public java.lang.String toString() {
        return "SAPropertyFilter{event='" + this.event + "', type=" + this.type + ", time=" + this.time + ", eventJson=" + this.eventJson + '}';
    }
}
