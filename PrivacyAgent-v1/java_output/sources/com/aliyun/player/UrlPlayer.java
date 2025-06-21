package com.aliyun.player;

/* loaded from: classes.dex */
public interface UrlPlayer extends com.aliyun.player.IPlayer {
    void enableDowngrade(com.aliyun.player.source.UrlSource urlSource, com.aliyun.player.nativeclass.PlayerConfig playerConfig);

    void setDataSource(com.aliyun.player.source.BitStreamSource bitStreamSource);

    void setDataSource(com.aliyun.player.source.UrlSource urlSource);
}
