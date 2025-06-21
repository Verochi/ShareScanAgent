package com.bytedance.sdk.openadsdk.api.vw;

/* loaded from: classes22.dex */
public class v implements com.bykv.vk.openvk.api.proto.Bridge {
    private com.ss.android.download.api.model.DownloadShortInfo vw;

    public v(com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo) {
        this.vw = downloadShortInfo;
    }

    public boolean bt() {
        com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo = this.vw;
        if (downloadShortInfo != null) {
            return downloadShortInfo.onlyWifi;
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, com.bykv.vk.openvk.api.proto.ValueSet valueSet, java.lang.Class<T> cls) {
        switch (i) {
            case com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS /* 223700 */:
                return (T) java.lang.Boolean.valueOf(equals(valueSet.objectValue(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS_PARAMETER, java.lang.Object.class)));
            case com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_SHORT_HASH_CODE /* 223701 */:
                hashCode();
                return null;
            default:
                return null;
        }
    }

    public boolean equals(java.lang.Object obj) {
        com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo = this.vw;
        if (downloadShortInfo != null) {
            return downloadShortInfo.equals(obj);
        }
        return false;
    }

    public int hashCode() {
        com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo = this.vw;
        if (downloadShortInfo != null) {
            return downloadShortInfo.hashCode();
        }
        return 0;
    }

    public int kz() {
        com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo = this.vw;
        if (downloadShortInfo != null) {
            return downloadShortInfo.failStatus;
        }
        return 0;
    }

    public long t() {
        com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo = this.vw;
        if (downloadShortInfo != null) {
            return downloadShortInfo.totalBytes;
        }
        return -1L;
    }

    public long v() {
        com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo = this.vw;
        if (downloadShortInfo != null) {
            return downloadShortInfo.currentBytes;
        }
        return -1L;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public com.bykv.vk.openvk.api.proto.ValueSet values() {
        return com.bykv.vw.vw.vw.vw.wg.vw().vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ID, vw()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_STATUS, wg()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES, t()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES, v()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME, yl()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FAIL_STATUS, kz()).vw(com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ONLY_WIFI, bt()).wg();
    }

    public long vw() {
        com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo = this.vw;
        if (downloadShortInfo != null) {
            return downloadShortInfo.id;
        }
        return -1L;
    }

    public int wg() {
        com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo = this.vw;
        if (downloadShortInfo != null) {
            return downloadShortInfo.status;
        }
        return -1;
    }

    public java.lang.String yl() {
        com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo = this.vw;
        return downloadShortInfo != null ? downloadShortInfo.fileName : "";
    }
}
