package com.bytedance.sdk.openadsdk.api.vw;

/* loaded from: classes22.dex */
public class yl extends com.bytedance.sdk.openadsdk.api.wg implements com.ss.android.download.api.download.DownloadStatusChangeListener {
    public yl(com.bykv.vk.openvk.api.proto.EventListener eventListener) {
        this.vw = eventListener;
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo, int i) {
        vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE, vw() ? null : com.bykv.vw.vw.vw.vw.vw.vw().vw(com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new com.bytedance.sdk.openadsdk.api.vw.v(downloadShortInfo)).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i).wg()).wg());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo) {
        vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_FAILED, vw() ? null : com.bykv.vw.vw.vw.vw.vw.vw().vw(com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new com.bytedance.sdk.openadsdk.api.vw.v(downloadShortInfo)).wg()).wg());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo) {
        vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_FINISHED, vw() ? null : com.bykv.vw.vw.vw.vw.vw.vw().vw(com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new com.bytedance.sdk.openadsdk.api.vw.v(downloadShortInfo)).wg()).wg());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo, int i) {
        vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_PAUSED, vw() ? null : com.bykv.vw.vw.vw.vw.vw.vw().vw(com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new com.bytedance.sdk.openadsdk.api.vw.v(downloadShortInfo)).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i).wg()).wg());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(@androidx.annotation.NonNull com.ss.android.download.api.download.DownloadModel downloadModel, @androidx.annotation.Nullable com.ss.android.download.api.download.DownloadController downloadController) {
        vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_START, vw() ? null : com.bykv.vw.vw.vw.vw.vw.vw().vw(com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_MODEL, new com.bytedance.sdk.openadsdk.api.vw.t(downloadModel)).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new com.bytedance.sdk.openadsdk.api.vw.vw(downloadController)).wg()).wg());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onIdle() {
        vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_IDLE);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo) {
        vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_INSTALLED, vw() ? null : com.bykv.vw.vw.vw.vw.vw.vw().vw(com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new com.bytedance.sdk.openadsdk.api.vw.v(downloadShortInfo)).wg()).wg());
    }
}
