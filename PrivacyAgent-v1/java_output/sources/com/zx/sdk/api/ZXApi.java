package com.zx.sdk.api;

/* loaded from: classes19.dex */
public interface ZXApi {
    void addZXIDChangedListener(com.zx.sdk.api.ZXIDChangedListener zXIDChangedListener);

    void allowPermissionDialog(boolean z);

    void checkPermission(android.app.Activity activity, com.zx.sdk.api.PermissionCallback permissionCallback);

    void getAuthToken(com.zx.sdk.api.Callback callback);

    void getOpenID(com.zx.sdk.api.Callback callback, android.content.Context context);

    void getSAID(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.zx.sdk.api.SAIDCallback sAIDCallback);

    void getTag(com.zx.sdk.api.Callback callback);

    java.lang.String getVersion();

    void getZXID(com.zx.sdk.api.ZXIDListener zXIDListener);

    void init(android.content.Context context);

    java.lang.String invoke(java.lang.String str, java.lang.String str2);

    boolean isAllowPermissionDialog();

    boolean isEnable();

    void setDebug(boolean z);

    void setEnable(boolean z);
}
