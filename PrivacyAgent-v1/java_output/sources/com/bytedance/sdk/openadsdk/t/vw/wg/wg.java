package com.bytedance.sdk.openadsdk.t.vw.wg;

/* loaded from: classes22.dex */
public class wg implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.bykv.vk.openvk.api.proto.ValueSet vw = com.bykv.vw.vw.vw.vw.wg.vw;
    private final com.bytedance.sdk.openadsdk.TTAppDownloadListener wg;

    public wg(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener) {
        this.wg = tTAppDownloadListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009b, code lost:
    
        return null;
     */
    @Override // com.bykv.vk.openvk.api.proto.Caller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener = this.wg;
        if (tTAppDownloadListener != null) {
            switch (i) {
                case 221101:
                    tTAppDownloadListener.onIdle();
                    break;
                case 221102:
                    this.wg.onDownloadActive(valueSet.longValue(0), valueSet.longValue(1), (java.lang.String) valueSet.objectValue(2, java.lang.String.class), (java.lang.String) valueSet.objectValue(3, java.lang.String.class));
                    break;
                case 221103:
                    this.wg.onDownloadPaused(valueSet.longValue(0), valueSet.longValue(1), (java.lang.String) valueSet.objectValue(2, java.lang.String.class), (java.lang.String) valueSet.objectValue(3, java.lang.String.class));
                    break;
                case 221104:
                    this.wg.onDownloadFailed(valueSet.longValue(0), valueSet.longValue(1), (java.lang.String) valueSet.objectValue(2, java.lang.String.class), (java.lang.String) valueSet.objectValue(3, java.lang.String.class));
                    break;
                case 221105:
                    this.wg.onDownloadFinished(valueSet.longValue(0), (java.lang.String) valueSet.objectValue(1, java.lang.String.class), (java.lang.String) valueSet.objectValue(2, java.lang.String.class));
                    break;
                case 221106:
                    this.wg.onInstalled((java.lang.String) valueSet.objectValue(0, java.lang.String.class), (java.lang.String) valueSet.objectValue(1, java.lang.String.class));
                    break;
            }
        } else {
            return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return this.vw;
    }
}
