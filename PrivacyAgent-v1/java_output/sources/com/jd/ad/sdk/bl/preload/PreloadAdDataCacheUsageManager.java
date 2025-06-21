package com.jd.ad.sdk.bl.preload;

/* loaded from: classes23.dex */
public class PreloadAdDataCacheUsageManager implements android.os.Handler.Callback {
    public android.os.Handler jad_an = new android.os.Handler(android.os.Looper.getMainLooper(), this);
    public int jad_bo;
    public com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback jad_cp;

    public interface UseCacheCounterFinishCallback {
        void onUseCacheCounterFinish();
    }

    public PreloadAdDataCacheUsageManager() {
        this.jad_bo = 3;
        this.jad_bo = com.jd.ad.sdk.jad_kx.jad_er.jad_an.jad_an.jad_cp();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@androidx.annotation.NonNull android.os.Message message) {
        com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback useCacheCounterFinishCallback = this.jad_cp;
        if (useCacheCounterFinishCallback != null) {
            useCacheCounterFinishCallback.onUseCacheCounterFinish();
        }
        android.os.Handler handler = this.jad_an;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.jad_an = null;
        }
        setCounterFinishCallback(null);
        return true;
    }

    public void setCounterFinishCallback(com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback useCacheCounterFinishCallback) {
        this.jad_cp = useCacheCounterFinishCallback;
    }

    public void startPreloadAdDataCacheUsageTimeCounter() {
        android.os.Handler handler = this.jad_an;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, this.jad_bo * 1000);
        }
    }
}
