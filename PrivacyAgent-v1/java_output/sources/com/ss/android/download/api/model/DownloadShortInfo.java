package com.ss.android.download.api.model;

/* loaded from: classes19.dex */
public class DownloadShortInfo {
    public java.lang.String fileName;
    public boolean onlyWifi;
    public long id = -1;
    public int status = -1;
    public long totalBytes = -1;
    public long currentBytes = -1;
    public int failStatus = 0;

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.ss.android.download.api.model.DownloadShortInfo) || obj == null) {
            return super.equals(obj);
        }
        com.ss.android.download.api.model.DownloadShortInfo downloadShortInfo = (com.ss.android.download.api.model.DownloadShortInfo) obj;
        return ((this.id > downloadShortInfo.id ? 1 : (this.id == downloadShortInfo.id ? 0 : -1)) == 0) && (this.status == downloadShortInfo.status) && ((this.totalBytes > downloadShortInfo.totalBytes ? 1 : (this.totalBytes == downloadShortInfo.totalBytes ? 0 : -1)) == 0) && ((android.text.TextUtils.isEmpty(this.fileName) && android.text.TextUtils.isEmpty(downloadShortInfo.fileName)) || (!android.text.TextUtils.isEmpty(this.fileName) && !android.text.TextUtils.isEmpty(downloadShortInfo.fileName) && this.fileName.equals(downloadShortInfo.fileName)));
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Long.valueOf(this.id), java.lang.Integer.valueOf(this.status), java.lang.Long.valueOf(this.totalBytes), this.fileName});
    }

    public void updateFromNewDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.id = downloadInfo.getId();
        this.status = downloadInfo.getStatus();
        this.currentBytes = downloadInfo.getCurBytes();
        this.totalBytes = downloadInfo.getTotalBytes();
        this.fileName = downloadInfo.getTargetFilePath();
        com.ss.android.socialbase.downloader.exception.BaseException failedException = downloadInfo.getFailedException();
        if (failedException != null) {
            this.failStatus = failedException.getErrorCode();
        } else {
            this.failStatus = 0;
        }
        this.onlyWifi = downloadInfo.isOnlyWifi();
    }
}
