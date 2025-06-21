package com.bytedance.sdk.openadsdk.api.vw;

/* loaded from: classes22.dex */
public class kz extends com.bytedance.sdk.openadsdk.api.wg implements com.ss.android.download.api.config.IDownloadButtonClickListener {
    public kz(com.bykv.vk.openvk.api.proto.EventListener eventListener) {
        this.vw = eventListener;
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleComplianceDialog(boolean z) {
        vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG, vw() ? null : com.bykv.vw.vw.vw.vw.vw.vw().vw(com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG_SHOULD_SHOW, z).wg()).wg());
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleMarketFailedComplianceDialog() {
        vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_HANDLE_MARKET_FAILED_COMPLIANCE_DIALOG);
    }
}
