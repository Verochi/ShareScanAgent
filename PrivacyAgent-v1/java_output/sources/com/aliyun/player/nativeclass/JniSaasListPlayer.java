package com.aliyun.player.nativeclass;

/* loaded from: classes.dex */
public class JniSaasListPlayer extends com.aliyun.player.nativeclass.JniUrlListPlayer {
    private static final java.lang.String TAG = "JniSaasListPlayer";

    static {
        com.aliyun.utils.f.f();
    }

    public JniSaasListPlayer(android.content.Context context, long j, long j2) {
        super(context, j, j2);
    }

    public static void loadClass() {
    }

    public void addVid(java.lang.String str, java.lang.String str2) {
        if (com.aliyun.utils.f.b()) {
            nAddVid(str, str2);
        }
    }

    public boolean moveTo(java.lang.String str, com.aliyun.player.source.PlayAuthInfo playAuthInfo) {
        if (com.aliyun.utils.f.b()) {
            return nMoveToWithPlayAuth(str, playAuthInfo);
        }
        return false;
    }

    public boolean moveTo(java.lang.String str, com.aliyun.player.source.StsInfo stsInfo) {
        if (com.aliyun.utils.f.b()) {
            return nMoveToWithSts(str, stsInfo);
        }
        return false;
    }

    public boolean moveToNext(com.aliyun.player.source.PlayAuthInfo playAuthInfo, boolean z) {
        if (com.aliyun.utils.f.b()) {
            return nMoveToNextWithPlayAuth(playAuthInfo, z);
        }
        return false;
    }

    public boolean moveToNext(com.aliyun.player.source.StsInfo stsInfo, boolean z) {
        if (com.aliyun.utils.f.b()) {
            return nMoveToNextWithSts(stsInfo, z);
        }
        return false;
    }

    public boolean moveToPrev(com.aliyun.player.source.PlayAuthInfo playAuthInfo) {
        if (com.aliyun.utils.f.b()) {
            return nMoveToPrevWithPlayAuth(playAuthInfo);
        }
        return false;
    }

    public boolean moveToPrev(com.aliyun.player.source.StsInfo stsInfo) {
        if (com.aliyun.utils.f.b()) {
            return nMoveToPrevWithSts(stsInfo);
        }
        return false;
    }

    public native void nAddVid(java.lang.String str, java.lang.String str2);

    public native boolean nMoveToNextWithPlayAuth(com.aliyun.player.source.PlayAuthInfo playAuthInfo, boolean z);

    public native boolean nMoveToNextWithSts(com.aliyun.player.source.StsInfo stsInfo, boolean z);

    public native boolean nMoveToPrevWithPlayAuth(com.aliyun.player.source.PlayAuthInfo playAuthInfo);

    public native boolean nMoveToPrevWithSts(com.aliyun.player.source.StsInfo stsInfo);

    public native boolean nMoveToWithPlayAuth(java.lang.String str, com.aliyun.player.source.PlayAuthInfo playAuthInfo);

    public native boolean nMoveToWithSts(java.lang.String str, com.aliyun.player.source.StsInfo stsInfo);

    public native void nSetDefinition(java.lang.String str);

    public void setDefinition(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nSetDefinition(str);
        }
    }
}
