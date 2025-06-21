package com.sensorsdata.analytics.android.sdk.core.business.exposure;

/* loaded from: classes19.dex */
public interface SAExposureListener {
    void didExposure(android.view.View view, com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData);

    boolean shouldExposure(android.view.View view, com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData);
}
