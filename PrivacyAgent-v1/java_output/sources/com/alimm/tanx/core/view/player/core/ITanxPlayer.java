package com.alimm.tanx.core.view.player.core;

/* loaded from: classes.dex */
public interface ITanxPlayer {
    com.alimm.tanx.core.view.player.core.ITanxPlayer create();

    int getBufferPercent();

    long getCurrentPosition();

    long getDuration();

    com.alimm.tanx.core.view.player.core.PlayerState getState();

    java.lang.String getUrl();

    int getVideoHeight();

    int getVideoWidth();

    float getVolume();

    boolean isPlayWhenReady();

    boolean isPlaying();

    void pause();

    void prepare();

    void prepareAsync();

    void release();

    void reset();

    void seekTo(long j);

    void setDataSource(android.content.Context context, android.net.Uri uri);

    void setDataSource(android.content.Context context, android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map);

    void setDataSource(android.content.Context context, java.lang.String str);

    void setDisplay(android.view.SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setOnVideoBufferingStateChangeListener(com.alimm.tanx.core.view.player.core.OnVideoBufferingListener onVideoBufferingListener);

    void setOnVideoErrorListener(com.alimm.tanx.core.view.player.core.OnVideoErrorListener onVideoErrorListener);

    void setOnVideoSizeChangeListener(com.alimm.tanx.core.view.player.core.OnVideoSizeChangeListener onVideoSizeChangeListener);

    void setOnVideoStateChangeListener(com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener onVideoStateChangeListener);

    void setPlayWhenReady(boolean z);

    void setSurface(android.view.Surface surface);

    void setVolume(float f);

    void start();

    void stop();
}
