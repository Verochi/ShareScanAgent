package com.jd.ad.sdk.bl.exposuremonitor;

/* loaded from: classes23.dex */
public interface JADExposureListener {
    void onDelayExposure(long j, java.lang.String str, int i);

    void onExposure(java.lang.String str);

    void onFinishExposure();

    void onPreExposure(java.lang.String str);
}
