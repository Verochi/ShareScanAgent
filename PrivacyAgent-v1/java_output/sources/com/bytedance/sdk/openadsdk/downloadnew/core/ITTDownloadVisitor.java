package com.bytedance.sdk.openadsdk.downloadnew.core;

/* loaded from: classes22.dex */
public interface ITTDownloadVisitor {
    public static final int TYPE_TT_DOWNLOAD_VISITOR = 1;

    void checkAutoControl(org.json.JSONObject jSONObject, java.lang.String str);

    void clearAllData(java.lang.String str);

    void execute(int i, java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback iTTHttpCallback);

    void executeLogUpload(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel tTDownloadEventModel, boolean z);

    boolean getAppIsBackground();

    org.json.JSONObject getDownloadSettings();

    com.bytedance.sdk.openadsdk.TTDownloadEventLogger getTTDownloadEventLogger();

    boolean hasPermission(android.content.Context context, java.lang.String str);

    java.lang.String initPath(boolean z);

    boolean isOpenSdkEvent(java.lang.String str);

    void postBody(java.lang.String str, byte[] bArr, java.lang.String str2, com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback iTTHttpCallback);

    void requestPermission(android.app.Activity activity, java.lang.String[] strArr, com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback iTTPermissionCallback);

    void showDialogByDelegate(java.lang.ref.WeakReference<android.content.Context> weakReference, boolean z, com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder dialogBuilder);

    android.app.AlertDialog showDialogBySelf(android.app.Activity activity, boolean z, com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder dialogBuilder);
}
