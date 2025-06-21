package com.ss.android.download.api.download;

@java.lang.Deprecated
/* loaded from: classes19.dex */
public class wg implements com.ss.android.download.api.download.DownloadController {
    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAH() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAM() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableNewActivity() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableShowComplianceDialog() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDowloadChunkCount() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDownloadMode() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public java.lang.Object getExtraClickOperation() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public org.json.JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public java.lang.Object getExtraObject() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getInterceptFlag() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getLinkMode() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAddToDownloadManage() {
        return false;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return false;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableBackDialog() {
        return false;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setDownloadMode(int i) {
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableNewActivity(boolean z) {
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableShowComplianceDialog(boolean z) {
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setLinkMode(int i) {
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean shouldUseNewWebView() {
        return false;
    }
}
