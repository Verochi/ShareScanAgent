package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTAdManager {

    public interface OnExitInstallListener {
        void onExitInstall();
    }

    com.bytedance.sdk.openadsdk.TTAdNative createAdNative(android.content.Context context);

    java.lang.String getBiddingToken(com.bytedance.sdk.openadsdk.AdSlot adSlot);

    java.lang.String getBiddingToken(com.bytedance.sdk.openadsdk.AdSlot adSlot, boolean z, int i);

    <T> T getExtra(java.lang.Class<T> cls, android.os.Bundle bundle);

    java.lang.String getPluginVersion();

    java.lang.String getSDKVersion();

    int getThemeStatus();

    void register(java.lang.Object obj);

    void requestPermissionIfNecessary(android.content.Context context);

    void setThemeStatus(int i);

    boolean tryShowInstallDialogWhenExit(android.app.Activity activity, com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener exitInstallListener);

    void unregister(java.lang.Object obj);
}
