package com.anythink.expressad.playercommon;

/* loaded from: classes12.dex */
public interface VideoPlayerStatusListener {
    void onBufferingEnd();

    void onBufferingStart(java.lang.String str);

    void onPlayCompleted();

    void onPlayError(java.lang.String str);

    void onPlayProgress(int i, int i2);

    void onPlayProgressMS(int i, int i2);

    void onPlaySetDataSourceError(java.lang.String str);

    void onPlayStarted(int i);

    void onVideoDownloadResume();
}
