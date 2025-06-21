package com.aliyun.svideosdk.editor;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIPlayerController {
    long getCurrentPlayPosition();

    long getCurrentStreamPosition();

    long getDuration();

    long getStreamDuration();

    boolean isMute();

    boolean isPaused();

    boolean isPlaying();

    int pause();

    int play();

    int replay();

    int resume();

    int seek(long j, java.util.concurrent.TimeUnit timeUnit);

    void setMute(boolean z);

    int setVolume(int i);

    int stop();
}
