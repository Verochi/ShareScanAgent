package com.aliyun.player;

/* loaded from: classes.dex */
public interface AliPlayer extends com.aliyun.player.UrlPlayer {

    public interface OnVerifyTimeExpireCallback {
        com.aliyun.player.AliPlayer.Status onVerifyAuth(com.aliyun.player.source.VidAuth vidAuth);

        com.aliyun.player.AliPlayer.Status onVerifySts(com.aliyun.player.source.StsInfo stsInfo);
    }

    public enum Status {
        Valid,
        Invalid,
        Pending
    }

    void invokeComponent(java.lang.String str);

    void setDataSource(com.aliyun.player.source.LiveSts liveSts);

    void setDataSource(com.aliyun.player.source.VidAuth vidAuth);

    void setDataSource(com.aliyun.player.source.VidMps vidMps);

    void setDataSource(com.aliyun.player.source.VidSts vidSts);

    void setOnVerifyTimeExpireCallback(com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback);

    void updateStsInfo(com.aliyun.player.source.StsInfo stsInfo);

    void updateVidAuth(com.aliyun.player.source.VidAuth vidAuth);
}
