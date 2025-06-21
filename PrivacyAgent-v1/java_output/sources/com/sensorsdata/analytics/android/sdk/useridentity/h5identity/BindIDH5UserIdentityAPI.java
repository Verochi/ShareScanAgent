package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

/* loaded from: classes19.dex */
public class BindIDH5UserIdentityAPI extends com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityAPI {
    private final com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI mUserIdentityApi;

    public BindIDH5UserIdentityAPI(com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI userIdentityAPI) {
        this.mUserIdentityApi = userIdentityAPI;
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityAPI
    public boolean updateIdentities() {
        try {
            org.json.JSONObject jSONObject = this.mIdentityJson;
            if (jSONObject != null) {
                jSONObject.remove(com.sensorsdata.analytics.android.sdk.useridentity.Identities.COOKIE_ID);
                this.mUserIdentityApi.getIdentitiesInstance().mergeIdentities(jSONObject);
            }
            mergeIdentities(this.mUserIdentityApi.getIdentitiesInstance().getIdentities(com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.DEFAULT));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return super.updateIdentities();
    }
}
