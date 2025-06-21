package com.ss.android.download.api.download;

/* loaded from: classes19.dex */
public interface DownloadController {
    boolean enableAH();

    boolean enableAM();

    boolean enableNewActivity();

    boolean enableShowComplianceDialog();

    @java.lang.Deprecated
    int getDowloadChunkCount();

    int getDownloadMode();

    java.lang.Object getExtraClickOperation();

    org.json.JSONObject getExtraJson();

    java.lang.Object getExtraObject();

    int getInterceptFlag();

    int getLinkMode();

    boolean isAddToDownloadManage();

    boolean isAutoDownloadOnCardShow();

    boolean isEnableBackDialog();

    @java.lang.Deprecated
    boolean isEnableMultipleDownload();

    void setDownloadMode(int i);

    void setEnableNewActivity(boolean z);

    void setEnableShowComplianceDialog(boolean z);

    void setLinkMode(int i);

    boolean shouldUseNewWebView();
}
