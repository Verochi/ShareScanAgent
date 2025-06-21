package com.qq.e.ads.nativ;

/* loaded from: classes19.dex */
public interface CustomizeVideo {
    java.lang.String getVideoUrl();

    void reportVideoCompleted();

    void reportVideoError(long j, int i, int i2);

    void reportVideoPause(long j);

    void reportVideoPreload();

    void reportVideoResume(long j);

    void reportVideoStart();
}
