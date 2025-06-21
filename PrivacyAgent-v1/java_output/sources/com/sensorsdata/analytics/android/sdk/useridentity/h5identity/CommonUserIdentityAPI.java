package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

/* loaded from: classes19.dex */
public class CommonUserIdentityAPI extends com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityAPI {
    com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI mUserIdentityAPI;

    public CommonUserIdentityAPI(com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI userIdentityAPI) {
        this.mUserIdentityAPI = userIdentityAPI;
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityAPI
    public boolean updateIdentities() {
        try {
            mergeIdentities(this.mUserIdentityAPI.getIdentitiesInstance().getIdentities(com.sensorsdata.analytics.android.sdk.useridentity.Identities.State.DEFAULT));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        this.mUserIdentityAPI.trackH5Notify(this.mEventObject);
        return true;
    }
}
