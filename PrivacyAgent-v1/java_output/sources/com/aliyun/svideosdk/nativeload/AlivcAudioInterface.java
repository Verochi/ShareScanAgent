package com.aliyun.svideosdk.nativeload;

/* loaded from: classes12.dex */
public interface AlivcAudioInterface {
    void flush();

    int getPlayState();

    int getPlaybackHeadPosition();

    void pause();

    void play();

    void release();

    int setStereoVolume(float f, float f2);

    void stop();

    int write(byte[] bArr, int i, int i2);
}
