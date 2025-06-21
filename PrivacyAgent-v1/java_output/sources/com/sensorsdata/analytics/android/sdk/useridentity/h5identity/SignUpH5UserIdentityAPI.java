package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

/* loaded from: classes19.dex */
public class SignUpH5UserIdentityAPI extends com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityAPI {
    private final com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType;
    private final com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI mUserIdentityApi;

    public SignUpH5UserIdentityAPI(com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI userIdentityAPI, com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType) {
        this.mUserIdentityApi = userIdentityAPI;
        this.eventType = eventType;
    }

    private boolean traversalSearch(java.lang.String str) {
        java.util.Iterator<java.lang.String> keys = this.mIdentityJson.keys();
        java.lang.String str2 = "";
        int i = 0;
        while (keys.hasNext()) {
            java.lang.String next = keys.next();
            if (!android.text.TextUtils.isEmpty(next)) {
                java.lang.String optString = this.mIdentityJson.optString(next);
                if (!android.text.TextUtils.isEmpty(optString) && optString.equals(str)) {
                    i++;
                    str2 = next;
                }
            }
        }
        if (i == 1) {
            return this.mUserIdentityApi.loginWithKeyBack(str2, str);
        }
        return false;
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.h5identity.H5UserIdentityAPI
    public boolean updateIdentities() {
        try {
            if (android.text.TextUtils.isEmpty(this.mEventObject.optString("identities"))) {
                if (!this.mUserIdentityApi.loginWithKeyBack(com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, this.mEventObject.optString("distinct_id"))) {
                    return false;
                }
            } else if (this.mIdentityJson.has(this.mUserIdentityApi.getIdentitiesInstance().getLoginIDKey())) {
                java.lang.String optString = this.mIdentityJson.optString(this.mUserIdentityApi.getIdentitiesInstance().getLoginIDKey());
                com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI userIdentityAPI = this.mUserIdentityApi;
                if (!userIdentityAPI.loginWithKeyBack(userIdentityAPI.getIdentitiesInstance().getLoginIDKey(), optString)) {
                    return false;
                }
            } else {
                java.lang.String optString2 = this.mEventObject.optString("login_id");
                if (!android.text.TextUtils.isEmpty(optString2)) {
                    java.lang.String[] split = optString2.split("\\+");
                    if (split.length == 2) {
                        java.lang.String str = split[0];
                        java.lang.String str2 = split[1];
                        java.lang.String optString3 = this.mIdentityJson.optString(str);
                        if (this.mIdentityJson.has(str) && !android.text.TextUtils.isEmpty(optString3) && optString3.equals(str2) && !this.mUserIdentityApi.loginWithKeyBack(str, str2)) {
                            return false;
                        }
                    } else if (!traversalSearch(optString2)) {
                        return false;
                    }
                }
            }
            java.lang.String loginId = this.mUserIdentityApi.getIdentitiesInstance().getLoginId();
            if (android.text.TextUtils.isEmpty(loginId)) {
                this.mEventObject.put("login_id", loginId);
            }
            mergeIdentities(this.mUserIdentityApi.getIdentities(this.eventType));
            return true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }
}
