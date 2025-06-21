package com.alimm.tanx.core.view.player.ui;

/* loaded from: classes.dex */
public interface ITanxPlayerView {
    void attach();

    long currentPosition();

    long duration();

    int getCurrentPosition();

    int getDuration();

    com.alimm.tanx.core.view.player.core.PlayerState getState();

    boolean isPlaying();

    void mute();

    void pause();

    void prepare();

    void release();

    void replay();

    void reset();

    void resumeVolume();

    void seekTo(long j);

    void setCover(java.lang.String str);

    void setDataSource(android.net.Uri uri);

    void setDataSource(android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map);

    void setDataSource(java.lang.String str);

    void setTanxPlayer(com.alimm.tanx.core.view.player.core.ITanxPlayer iTanxPlayer);

    void setVideoScaleMode(com.alimm.tanx.core.view.player.VideoScaleMode videoScaleMode);

    void setVolume(int i);

    void start();

    void stop();

    int videoHeight();

    int videoWidth();
}
