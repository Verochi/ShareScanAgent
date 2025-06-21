package com.alimm.tanx.core.ad.monitor;

/* loaded from: classes.dex */
public interface ITanxExposureCallback {
    void exposure();

    void exposureTime(long j);

    void onMonitor(java.util.Map<java.lang.String, java.lang.Object> map);
}
