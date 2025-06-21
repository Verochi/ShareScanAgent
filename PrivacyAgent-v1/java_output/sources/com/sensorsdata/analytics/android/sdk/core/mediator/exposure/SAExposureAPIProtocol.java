package com.sensorsdata.analytics.android.sdk.core.mediator.exposure;

/* loaded from: classes19.dex */
public interface SAExposureAPIProtocol {
    void addExposureView(android.view.View view, com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData);

    void removeExposureView(android.view.View view);

    void removeExposureView(android.view.View view, java.lang.String str);

    void setExposureIdentifier(android.view.View view, java.lang.String str);

    void updateExposureProperties(android.view.View view, org.json.JSONObject jSONObject);
}
