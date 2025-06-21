package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

/* loaded from: classes19.dex */
public class UnbindIDH5UserIdentityAPI extends com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityAPI {
    private final com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI mUserIdentityApi;

    public UnbindIDH5UserIdentityAPI(com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI userIdentityAPI) {
        this.mUserIdentityApi = userIdentityAPI;
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityAPI
    public boolean updateIdentities() {
        try {
            java.util.Iterator<java.lang.String> keys = this.mIdentityJson.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                this.mUserIdentityApi.getIdentitiesInstance().remove(next, this.mIdentityJson.optString(next));
            }
            this.mEventObject.put("identities", this.mIdentityJson);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return super.updateIdentities();
    }
}
