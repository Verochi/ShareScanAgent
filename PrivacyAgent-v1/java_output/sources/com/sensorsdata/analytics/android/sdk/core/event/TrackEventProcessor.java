package com.sensorsdata.analytics.android.sdk.core.event;

/* loaded from: classes19.dex */
public class TrackEventProcessor extends com.sensorsdata.analytics.android.sdk.core.event.EventProcessor {
    public TrackEventProcessor(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        super(sAContextManager);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.event.EventProcessor
    public void trackEvent(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        process(inputData);
    }
}
