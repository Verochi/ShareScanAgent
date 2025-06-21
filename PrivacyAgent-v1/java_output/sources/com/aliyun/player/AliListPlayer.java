package com.aliyun.player;

/* loaded from: classes.dex */
public interface AliListPlayer extends com.aliyun.player.UrlListPlayer, com.aliyun.player.AliPlayer {
    void addVid(java.lang.String str, java.lang.String str2);

    boolean moveTo(java.lang.String str, com.aliyun.player.source.PlayAuthInfo playAuthInfo);

    boolean moveTo(java.lang.String str, com.aliyun.player.source.StsInfo stsInfo);

    boolean moveToNext(com.aliyun.player.source.PlayAuthInfo playAuthInfo);

    boolean moveToNext(com.aliyun.player.source.StsInfo stsInfo);

    boolean moveToNextWithPrerendered(com.aliyun.player.source.PlayAuthInfo playAuthInfo);

    boolean moveToNextWithPrerendered(com.aliyun.player.source.StsInfo stsInfo);

    boolean moveToPrev(com.aliyun.player.source.PlayAuthInfo playAuthInfo);

    boolean moveToPrev(com.aliyun.player.source.StsInfo stsInfo);

    void setDefinition(java.lang.String str);
}
