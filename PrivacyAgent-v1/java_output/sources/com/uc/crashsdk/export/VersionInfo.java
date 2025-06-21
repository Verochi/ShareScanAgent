package com.uc.crashsdk.export;

/* loaded from: classes19.dex */
public class VersionInfo {
    public java.lang.String mBuildId;
    public java.lang.String mSubVersion;
    public java.lang.String mVersion;

    public VersionInfo() {
        this.mVersion = null;
        this.mSubVersion = null;
        this.mBuildId = null;
    }

    public VersionInfo(com.uc.crashsdk.export.VersionInfo versionInfo) {
        this.mVersion = null;
        this.mSubVersion = null;
        this.mBuildId = null;
        this.mVersion = versionInfo.mVersion;
        this.mSubVersion = versionInfo.mSubVersion;
        this.mBuildId = versionInfo.mBuildId;
    }
}
