package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

/* loaded from: classes19.dex */
public class H5UserIdentityStrategy {
    private final com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI userIdentityAPI;

    public H5UserIdentityStrategy(com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI userIdentityAPI) {
        this.userIdentityAPI = userIdentityAPI;
    }

    private void specialIDProcess(org.json.JSONObject jSONObject) {
        jSONObject.remove(com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANDROID_ID);
        jSONObject.remove(com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANONYMOUS_ID);
        jSONObject.remove(com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANDROID_UUID);
    }

    public boolean processH5UserIdentity(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityAPI commonUserIdentityAPI;
        try {
            java.lang.String optString = jSONObject.optString("identities");
            org.json.JSONObject jSONObject2 = !android.text.TextUtils.isEmpty(optString) ? new org.json.JSONObject(optString) : new org.json.JSONObject();
            if (com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP == eventType) {
                specialIDProcess(jSONObject2);
                commonUserIdentityAPI = new com.sensorsdata.analytics.android.sdk.useridentity.h5identity.SignUpH5UserIdentityAPI(this.userIdentityAPI, eventType);
            } else if (com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_BIND == eventType) {
                specialIDProcess(jSONObject2);
                commonUserIdentityAPI = new com.sensorsdata.analytics.android.sdk.useridentity.h5identity.BindIDH5UserIdentityAPI(this.userIdentityAPI);
            } else if (com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_UNBIND == eventType) {
                commonUserIdentityAPI = new com.sensorsdata.analytics.android.sdk.useridentity.h5identity.UnbindIDH5UserIdentityAPI(this.userIdentityAPI);
            } else {
                specialIDProcess(jSONObject2);
                commonUserIdentityAPI = new com.sensorsdata.analytics.android.sdk.useridentity.h5identity.CommonUserIdentityAPI(this.userIdentityAPI);
            }
            return commonUserIdentityAPI.process(jSONObject2, jSONObject);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }
}
