package com.sensorsdata.analytics.android.sdk.core.event;

/* loaded from: classes19.dex */
public abstract class Event {
    protected org.json.JSONObject mExtras;
    private org.json.JSONObject mLib;
    private java.lang.String mProject;
    private org.json.JSONObject mProperties;
    private long mTime;
    private java.lang.String mToken;
    private long mTrackId;
    private java.lang.String mType;

    public org.json.JSONObject getExtras() {
        return this.mExtras;
    }

    public org.json.JSONObject getLib() {
        return this.mLib;
    }

    public java.lang.String getProject() {
        return this.mProject;
    }

    public org.json.JSONObject getProperties() {
        return this.mProperties;
    }

    public long getTime() {
        long j = this.mTime;
        return j == 0 ? java.lang.System.currentTimeMillis() : j;
    }

    public java.lang.String getToken() {
        return this.mToken;
    }

    public long getTrackId() {
        return this.mTrackId;
    }

    public java.lang.String getType() {
        return this.mType;
    }

    public void setExtras(org.json.JSONObject jSONObject) {
        this.mExtras = jSONObject;
    }

    public void setLib(org.json.JSONObject jSONObject) {
        this.mLib = jSONObject;
    }

    public void setProject(java.lang.String str) {
        this.mProject = str;
    }

    public void setProperties(org.json.JSONObject jSONObject) {
        this.mProperties = jSONObject;
    }

    public void setTime(long j) {
        if (j > 0) {
            this.mTime = j;
        } else {
            this.mTime = java.lang.System.currentTimeMillis();
        }
    }

    public void setToken(java.lang.String str) {
        this.mToken = str;
    }

    public void setTrackId(long j) {
        this.mTrackId = j;
    }

    public void setType(java.lang.String str) {
        this.mType = str;
    }

    public abstract org.json.JSONObject toJSONObject();
}
