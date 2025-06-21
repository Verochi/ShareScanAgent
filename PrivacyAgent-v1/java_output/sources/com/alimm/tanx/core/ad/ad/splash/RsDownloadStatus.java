package com.alimm.tanx.core.ad.ad.splash;

/* loaded from: classes.dex */
public class RsDownloadStatus implements com.alimm.tanx.core.utils.NotConfused {
    public static final int RS_STATUS_DELETED_EXPIRED = 3;
    public static final int RS_STATUS_DELETED_FULL = 4;
    public static final int RS_STATUS_DOWNLOADED = 2;
    public static final int RS_STATUS_DOWNLOAD_ERROR = 1;
    public static final int RS_STATUS_INIT = 0;
    public static final int RS_STATUS_UNKNOWN = -1;
    private final java.lang.String mFileName;
    private int mStatus;

    public RsDownloadStatus(@androidx.annotation.NonNull java.lang.String str, int i) {
        this.mFileName = str;
        this.mStatus = i;
    }

    public java.lang.String getFileName() {
        return this.mFileName;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public java.lang.String toString() {
        return "{RsDownloadStatus: name = " + this.mFileName + ",mStatus = " + this.mStatus + com.alipay.sdk.m.u.i.d;
    }
}
