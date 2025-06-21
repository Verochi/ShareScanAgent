package com.bytedance.sdk.openadsdk.t.vw.vw;

/* loaded from: classes22.dex */
public class yl implements com.bytedance.sdk.openadsdk.DownloadStatusController {
    private final com.bykv.vk.openvk.api.proto.Bridge vw;

    public yl(com.bykv.vk.openvk.api.proto.Bridge bridge) {
        this.vw = bridge == null ? com.bykv.vw.vw.vw.vw.wg.wg : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        this.vw.call(222102, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        this.vw.call(222101, com.bykv.vw.vw.vw.vw.wg.vw(0).wg(), java.lang.Void.class);
    }
}
