package com.bytedance.pangle.download;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public class PluginDownloadBean {
    public java.util.List<java.lang.String> mBackupUrlList;
    public int mFlag;
    public long mFollowId;
    public java.lang.String mMd5;
    public java.lang.String mPackageName;
    public java.lang.String mUrl;
    public int mVersionCode;
    public int mApiVersionMin = 0;
    public int mApiVersionMax = Integer.MAX_VALUE;

    public boolean isRevert() {
        return this.mFlag == 3;
    }

    public boolean isUnInstall() {
        return this.mFlag == 1;
    }
}
