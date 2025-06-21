package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

/* loaded from: classes19.dex */
public abstract class H5UserIdentityAPI {
    protected org.json.JSONObject mEventObject;
    protected org.json.JSONObject mIdentityJson;

    public void init(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        this.mIdentityJson = jSONObject;
        this.mEventObject = jSONObject2;
    }

    public void mergeIdentities(org.json.JSONObject jSONObject) throws org.json.JSONException {
        org.json.JSONObject jSONObject2;
        if (jSONObject != null && (jSONObject2 = this.mIdentityJson) != null) {
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject, jSONObject2);
        }
        if (this.mIdentityJson == null && jSONObject != null) {
            this.mIdentityJson = new org.json.JSONObject(jSONObject.toString());
        }
        this.mEventObject.put("identities", this.mIdentityJson);
    }

    public boolean process(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        init(jSONObject, jSONObject2);
        return updateIdentities();
    }

    public boolean updateIdentities() {
        return true;
    }
}
