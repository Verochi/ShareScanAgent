package com.aliyun.player.nativeclass;

/* loaded from: classes.dex */
public class JniListPlayerBase {
    private long mNativeContext = 0;

    static {
        com.aliyun.utils.f.f();
    }

    public JniListPlayerBase(android.content.Context context, long j, long j2) {
        if (com.aliyun.utils.f.b()) {
            nConstruct(j, j2);
        }
    }

    public static void loadClass() {
    }

    public int GetMultiBitratesMode() {
        if (com.aliyun.utils.f.b()) {
            return nGetMultiBiratesMode();
        }
        return 0;
    }

    public void SetMultiBitratesMode(int i) {
        if (com.aliyun.utils.f.b()) {
            nSetMultiBitratesMode(i);
        }
    }

    public void clear() {
        if (com.aliyun.utils.f.b()) {
            nClear();
        }
    }

    public void enablePreloadStrategy(int i, boolean z) {
        if (com.aliyun.utils.f.b()) {
            nEnablePreloadStrategy(i, z);
        }
    }

    public java.lang.String getCurrentUid() {
        return !com.aliyun.utils.f.b() ? "" : nGetCurrentUid();
    }

    public int getMaxPreloadMemorySizeMB() {
        if (com.aliyun.utils.f.b()) {
            return nGetMaxPreloadMemorySizeMB();
        }
        return 0;
    }

    public long getNativeListContext() {
        return this.mNativeContext;
    }

    public native void nClear();

    public native void nConstruct(long j, long j2);

    public native void nEnablePreloadStrategy(int i, boolean z);

    public native java.lang.String nGetCurrentUid();

    public native int nGetMaxPreloadMemorySizeMB();

    public native int nGetMultiBiratesMode();

    public native void nRelease();

    public native void nRemoveSource(java.lang.String str);

    public native void nSetMaxPreloadMemorySizeMB(int i);

    public native void nSetMultiBitratesMode(int i);

    public native void nSetPreloadCount(int i);

    public native void nSetPreloadCount(int i, int i2);

    public native void nSetPreloadScene(int i);

    public native void nSetPreloadStrategyParam(int i, java.lang.String str);

    public native void nStop();

    public native void nUpdatePreloadConfig(java.lang.Object obj);

    public native void nUpdatePreloadConfig(java.lang.String str, java.lang.Object obj);

    public void release() {
        if (com.aliyun.utils.f.b()) {
            nRelease();
        }
    }

    public void removeSource(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nRemoveSource(str);
        }
    }

    public void setMaxPreloadMemorySizeMB(int i) {
        if (com.aliyun.utils.f.b()) {
            nSetMaxPreloadMemorySizeMB(i);
        }
    }

    public void setNativeListContext(long j) {
        this.mNativeContext = j;
    }

    public void setPreloadCount(int i) {
        if (com.aliyun.utils.f.b()) {
            nSetPreloadCount(i);
        }
    }

    public void setPreloadCount(int i, int i2) {
        if (com.aliyun.utils.f.b()) {
            nSetPreloadCount(i, i2);
        }
    }

    public void setPreloadScene(int i) {
        if (com.aliyun.utils.f.b()) {
            nSetPreloadScene(i);
        }
    }

    public void setPreloadStrategyParam(int i, java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nSetPreloadStrategyParam(i, str);
        }
    }

    public void stop() {
        if (com.aliyun.utils.f.b()) {
            nStop();
        }
    }

    public void updatePreloadConfig(com.aliyun.player.nativeclass.PreloadConfig preloadConfig) {
        if (com.aliyun.utils.f.b()) {
            nUpdatePreloadConfig(preloadConfig);
        }
    }

    public void updatePreloadConfig(java.lang.String str, com.aliyun.player.nativeclass.PreloadConfig preloadConfig) {
        if (com.aliyun.utils.f.b()) {
            nUpdatePreloadConfig(str, preloadConfig);
        }
    }
}
