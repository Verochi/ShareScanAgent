package com.aliyun.svideosdk.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIClipManager {
    void deleteAllPart();

    void deleteLastPart();

    @java.lang.Deprecated
    void deletePart();

    void deletePart(int i);

    int getDuration();

    long getDuration(java.util.concurrent.TimeUnit timeUnit);

    int getMaxDuration();

    int getMinDuration();

    int getPartCount();

    java.util.List<java.lang.String> getVideoPathList();

    void setMaxDuration(int i);

    void setMinDuration(int i);
}
