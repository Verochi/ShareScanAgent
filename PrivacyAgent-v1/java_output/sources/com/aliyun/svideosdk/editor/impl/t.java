package com.aliyun.svideosdk.editor.impl;

/* loaded from: classes12.dex */
public class t implements com.aliyun.svideosdk.editor.AliyunIPlayerController {
    private com.aliyun.svideosdk.editor.AliyunIEditor a;

    public t(com.aliyun.svideosdk.editor.AliyunIEditor aliyunIEditor) {
        this.a = aliyunIEditor;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public long getCurrentPlayPosition() {
        return java.util.concurrent.TimeUnit.MICROSECONDS.toMillis(this.a.getCurrentPlayPosition());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public long getCurrentStreamPosition() {
        return java.util.concurrent.TimeUnit.MICROSECONDS.toMillis(this.a.getCurrentStreamPosition());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public long getDuration() {
        return java.util.concurrent.TimeUnit.MICROSECONDS.toMillis(this.a.getDuration());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public long getStreamDuration() {
        return java.util.concurrent.TimeUnit.MICROSECONDS.toMillis(this.a.getStreamDuration());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public boolean isMute() {
        return this.a.isAudioSilence();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public boolean isPaused() {
        return this.a.isPaused();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public boolean isPlaying() {
        return this.a.isPlaying();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int pause() {
        return this.a.pause();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int play() {
        return this.a.play();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int replay() {
        return this.a.replay();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int resume() {
        return this.a.resume();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int seek(long j, java.util.concurrent.TimeUnit timeUnit) {
        return this.a.seek(j, timeUnit);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public void setMute(boolean z) {
        this.a.setAudioSilence(z);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int setVolume(int i) {
        return this.a.setVolume(i);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPlayerController
    public int stop() {
        return this.a.stop();
    }
}
