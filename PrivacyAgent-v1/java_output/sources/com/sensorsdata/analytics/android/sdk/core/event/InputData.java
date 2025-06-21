package com.sensorsdata.analytics.android.sdk.core.event;

/* loaded from: classes19.dex */
public class InputData {
    protected java.lang.String mEventName;
    protected com.sensorsdata.analytics.android.sdk.internal.beans.EventType mEventType;
    protected java.lang.String mExtras;
    private java.lang.String mItemId;
    private java.lang.String mItemType;
    protected org.json.JSONObject mProperties;
    protected long mTime;

    public java.lang.String getEventName() {
        return this.mEventName;
    }

    public com.sensorsdata.analytics.android.sdk.internal.beans.EventType getEventType() {
        com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType = this.mEventType;
        return eventType == null ? com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK : eventType;
    }

    public java.lang.String getExtras() {
        return this.mExtras;
    }

    public java.lang.String getItemId() {
        return this.mItemId;
    }

    public java.lang.String getItemType() {
        return this.mItemType;
    }

    public org.json.JSONObject getProperties() {
        return this.mProperties;
    }

    public long getTime() {
        return this.mTime;
    }

    public com.sensorsdata.analytics.android.sdk.core.event.InputData setEventName(java.lang.String str) {
        this.mEventName = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.core.event.InputData setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType) {
        this.mEventType = eventType;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.core.event.InputData setExtras(java.lang.String str) {
        this.mExtras = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.core.event.InputData setItemId(java.lang.String str) {
        this.mItemId = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.core.event.InputData setItemType(java.lang.String str) {
        this.mItemType = str;
        return this;
    }

    public com.sensorsdata.analytics.android.sdk.core.event.InputData setProperties(org.json.JSONObject jSONObject) {
        this.mProperties = jSONObject;
        return this;
    }

    public void setTime(long j) {
        this.mTime = j;
    }
}
