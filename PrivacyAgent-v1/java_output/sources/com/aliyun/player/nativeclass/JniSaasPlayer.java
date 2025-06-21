package com.aliyun.player.nativeclass;

/* loaded from: classes.dex */
public class JniSaasPlayer extends com.aliyun.player.nativeclass.JniUrlPlayer {
    private static final java.lang.String TAG = "JniSaasPlayer";
    private com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback mOnVerifyTimeExpireCallback;

    static {
        com.aliyun.utils.f.f();
    }

    public JniSaasPlayer(android.content.Context context) {
        super(context);
        this.mOnVerifyTimeExpireCallback = null;
    }

    public static void loadClass() {
    }

    private native void nSetDataSource(com.aliyun.player.source.LiveSts liveSts);

    private native void nSetDataSource(com.aliyun.player.source.VidAuth vidAuth);

    private native void nSetDataSource(com.aliyun.player.source.VidMps vidMps);

    private native void nSetDataSource(com.aliyun.player.source.VidSts vidSts);

    private native void nUpdateStsInfo(com.aliyun.player.source.StsInfo stsInfo);

    private native void nUpdateVidAuth(com.aliyun.player.source.VidAuth vidAuth);

    public int onVerifyAuthCallback(java.lang.Object obj) {
        com.aliyun.player.source.VidAuth vidAuth = (com.aliyun.player.source.VidAuth) obj;
        com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback = this.mOnVerifyTimeExpireCallback;
        return (onVerifyTimeExpireCallback != null ? onVerifyTimeExpireCallback.onVerifyAuth(vidAuth) : com.aliyun.player.AliPlayer.Status.Invalid).ordinal();
    }

    public int onVerifyStsCallback(java.lang.Object obj) {
        com.aliyun.player.source.StsInfo stsInfo = (com.aliyun.player.source.StsInfo) obj;
        com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback = this.mOnVerifyTimeExpireCallback;
        return (onVerifyTimeExpireCallback != null ? onVerifyTimeExpireCallback.onVerifySts(stsInfo) : com.aliyun.player.AliPlayer.Status.Invalid).ordinal();
    }

    public void setDataSource(com.aliyun.player.source.LiveSts liveSts) {
        if (com.aliyun.utils.f.b()) {
            nSetDataSource(liveSts);
        }
    }

    public void setDataSource(com.aliyun.player.source.VidAuth vidAuth) {
        if (com.aliyun.utils.f.b()) {
            nSetDataSource(vidAuth);
        }
    }

    public void setDataSource(com.aliyun.player.source.VidMps vidMps) {
        if (com.aliyun.utils.f.b()) {
            nSetDataSource(vidMps);
        }
    }

    public void setDataSource(com.aliyun.player.source.VidSts vidSts) {
        if (com.aliyun.utils.f.b()) {
            nSetDataSource(vidSts);
        }
    }

    public void setOnVerifyTimeExpireCallback(com.aliyun.player.AliPlayer.OnVerifyTimeExpireCallback onVerifyTimeExpireCallback) {
        this.mOnVerifyTimeExpireCallback = onVerifyTimeExpireCallback;
    }

    public void updateStsInfo(com.aliyun.player.source.StsInfo stsInfo) {
        if (com.aliyun.utils.f.b()) {
            nUpdateStsInfo(stsInfo);
        }
    }

    public void updateVidAuth(com.aliyun.player.source.VidAuth vidAuth) {
        if (com.aliyun.utils.f.b()) {
            nUpdateVidAuth(vidAuth);
        }
    }
}
