package com.aliyun.player;

/* loaded from: classes.dex */
public interface UrlListPlayer extends com.aliyun.player.IListPlayer, com.aliyun.player.UrlPlayer {
    void addUrl(java.lang.String str, java.lang.String str2);

    void addUrl(java.lang.String str, java.lang.String str2, com.aliyun.player.nativeclass.PreloadConfig preloadConfig);

    com.aliyun.player.IPlayer getPreRenderPlayer();

    boolean moveTo(java.lang.String str);

    boolean moveToNext();

    boolean moveToNextWithPrerendered();

    boolean moveToPrev();

    void updatePreloadConfig(com.aliyun.player.nativeclass.PreloadConfig preloadConfig);

    void updatePreloadConfig(java.lang.String str, com.aliyun.player.nativeclass.PreloadConfig preloadConfig);
}
