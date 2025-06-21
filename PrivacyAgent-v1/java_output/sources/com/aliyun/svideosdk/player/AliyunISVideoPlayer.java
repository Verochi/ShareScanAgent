package com.aliyun.svideosdk.player;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunISVideoPlayer {
    int draw(long j);

    long getCurrentPosition();

    int init(android.content.Context context);

    int pause();

    int play();

    void release();

    int resume();

    int seek(long j);

    int setDisplay(android.view.Surface surface);

    int setDisplaySize(int i, int i2);

    void setPlayerCallback(com.aliyun.svideosdk.player.PlayerCallback playerCallback);

    int setSource(java.lang.String str);

    int stop();
}
