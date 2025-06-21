package com.sensorsdata.analytics.android.sdk.useridentity;

/* loaded from: classes19.dex */
public interface IUserIdentityAPI {
    public static final java.lang.String BIND_ID = "$BindID";
    public static final java.lang.String UNBIND_ID = "$UnbindID";

    void bind(java.lang.String str, java.lang.String str2) throws com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;

    @java.lang.Deprecated
    java.lang.String getAnonymousId();

    java.lang.String getDistinctId();

    org.json.JSONObject getIdentities();

    java.lang.String getLoginId();

    @java.lang.Deprecated
    void identify(java.lang.String str);

    void login(java.lang.String str);

    void login(java.lang.String str, org.json.JSONObject jSONObject);

    @java.lang.Deprecated
    void loginWithKey(java.lang.String str, java.lang.String str2);

    @java.lang.Deprecated
    void loginWithKey(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject);

    void logout();

    @java.lang.Deprecated
    void resetAnonymousId();

    void resetAnonymousIdentity(java.lang.String str);

    void unbind(java.lang.String str, java.lang.String str2) throws com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
}
