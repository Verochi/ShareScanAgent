package com.aliyun.player.nativeclass;

/* loaded from: classes.dex */
public class JniUrlListPlayer extends com.aliyun.player.nativeclass.JniListPlayerBase {
    private static final java.lang.String TAG = "JniUrlListPlayer";

    static {
        com.aliyun.utils.f.f();
    }

    public JniUrlListPlayer(android.content.Context context, long j, long j2) {
        super(context, j, j2);
    }

    public static void loadClass() {
    }

    public void addUrl(java.lang.String str, java.lang.String str2) {
        if (com.aliyun.utils.f.b()) {
            nAddUrl(str, str2);
        }
    }

    public void addUrl(java.lang.String str, java.lang.String str2, com.aliyun.player.nativeclass.PreloadConfig preloadConfig) {
        if (com.aliyun.utils.f.b()) {
            nAddUrl(str, str2, preloadConfig);
        }
    }

    public long getCurrentPlayerIndex() {
        if (com.aliyun.utils.f.b()) {
            return nGetCurrentPlayerIndex();
        }
        return 0L;
    }

    public long getPreRenderPlayerIndex() {
        if (com.aliyun.utils.f.b()) {
            return nGetPreRenderPlayerIndex();
        }
        return 0L;
    }

    public boolean moveTo(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            return nMoveTo(str);
        }
        return false;
    }

    public boolean moveToNext(boolean z) {
        if (com.aliyun.utils.f.b()) {
            return nMoveToNext(z);
        }
        return false;
    }

    public boolean moveToPrev() {
        if (com.aliyun.utils.f.b()) {
            return nMoveToPrev();
        }
        return false;
    }

    public native void nAddUrl(java.lang.String str, java.lang.String str2);

    public native void nAddUrl(java.lang.String str, java.lang.String str2, java.lang.Object obj);

    public native long nGetCurrentPlayerIndex();

    public native long nGetPreRenderPlayerIndex();

    public native boolean nMoveTo(java.lang.String str);

    public native boolean nMoveToNext(boolean z);

    public native boolean nMoveToPrev();
}
