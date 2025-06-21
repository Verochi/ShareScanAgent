package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface NEADVI extends com.qq.e.comm.pi.LADI {
    void destroy();

    void preloadVideo();

    void render();

    void reportAdNegative();

    void setAdListener(com.qq.e.comm.adevent.ADListener aDListener);

    void setAdSize(com.qq.e.ads.nativ.ADSize aDSize);
}
