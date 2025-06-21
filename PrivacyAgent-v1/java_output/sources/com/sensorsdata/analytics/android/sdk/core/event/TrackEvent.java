package com.sensorsdata.analytics.android.sdk.core.event;

/* loaded from: classes19.dex */
public class TrackEvent extends com.sensorsdata.analytics.android.sdk.core.event.Event {
    private java.lang.String mAnonymousId;
    private java.lang.String mDistinctId;
    private java.lang.String mEventName;
    private org.json.JSONObject mIdentities;
    private java.lang.String mItemId;
    private java.lang.String mItemType;
    private java.lang.String mLoginId;
    private java.lang.String mOriginalId;

    public java.lang.String getAnonymousId() {
        return this.mAnonymousId;
    }

    public java.lang.String getDistinctId() {
        return this.mDistinctId;
    }

    public java.lang.String getEventName() {
        return this.mEventName;
    }

    public org.json.JSONObject getIdentities() {
        return this.mIdentities;
    }

    public java.lang.String getItemId() {
        return this.mItemId;
    }

    public java.lang.String getItemType() {
        return this.mItemType;
    }

    public java.lang.String getLoginId() {
        return this.mLoginId;
    }

    public java.lang.String getOriginalId() {
        return this.mOriginalId;
    }

    public void setAnonymousId(java.lang.String str) {
        this.mAnonymousId = str;
    }

    public void setDistinctId(java.lang.String str) {
        this.mDistinctId = str;
    }

    public void setEventName(java.lang.String str) {
        this.mEventName = str;
    }

    public void setIdentities(org.json.JSONObject jSONObject) {
        this.mIdentities = jSONObject;
    }

    public void setItemId(java.lang.String str) {
        this.mItemId = str;
    }

    public void setItemType(java.lang.String str) {
        this.mItemType = str;
    }

    public void setLoginId(java.lang.String str) {
        this.mLoginId = str;
    }

    public void setOriginalId(java.lang.String str) {
        this.mOriginalId = str;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.event.Event
    public org.json.JSONObject toJSONObject() {
        try {
            if (getExtras() != null) {
                return getExtras();
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (getTrackId() != 0) {
                jSONObject.put("_track_id", getTrackId());
            }
            jSONObject.put("time", getTime());
            jSONObject.put("type", getType());
            jSONObject.put("distinct_id", getDistinctId());
            jSONObject.put("anonymous_id", getAnonymousId());
            if (getIdentities() != null && getIdentities().length() > 0) {
                jSONObject.put("identities", getIdentities());
            }
            if (!android.text.TextUtils.isEmpty(getProject())) {
                jSONObject.put("project", getProject());
            }
            if (!android.text.TextUtils.isEmpty(getToken())) {
                jSONObject.put("token", getToken());
            }
            if (!android.text.TextUtils.isEmpty(getEventName())) {
                jSONObject.put("event", getEventName());
            }
            if (!android.text.TextUtils.isEmpty(getOriginalId())) {
                jSONObject.put("original_id", getOriginalId());
            }
            if (!android.text.TextUtils.isEmpty(getLoginId())) {
                jSONObject.put("login_id", getLoginId());
            }
            if (!android.text.TextUtils.isEmpty(getItemType())) {
                jSONObject.put("item_type", getItemType());
            }
            if (!android.text.TextUtils.isEmpty(getItemId())) {
                jSONObject.put("item_id", getItemId());
            }
            jSONObject.put("lib", getLib());
            jSONObject.put("properties", getProperties());
            return jSONObject;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }
}
