package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunObject {
    protected long mNativeHandle = 0;

    public long getNativeHandle() {
        return this.mNativeHandle;
    }

    public boolean isNativeRelease() {
        return this.mNativeHandle == 0;
    }

    public void releaseNativeHandle() {
        this.mNativeHandle = 0L;
    }

    public void setNativeHandle(long j) {
        this.mNativeHandle = j;
    }
}
