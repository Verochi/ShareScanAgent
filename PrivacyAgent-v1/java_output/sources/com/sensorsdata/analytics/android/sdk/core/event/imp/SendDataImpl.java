package com.sensorsdata.analytics.android.sdk.core.event.imp;

/* loaded from: classes19.dex */
public class SendDataImpl implements com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.ISendData {
    private final android.content.Context mContext;
    private final com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions mInternalConfigs;

    public SendDataImpl(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mInternalConfigs = sAContextManager.getInternalConfigs();
        this.mContext = sAContextManager.getContext();
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.ISendData
    public void sendData(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData, int i) {
        boolean z;
        try {
            if (com.sensorsdata.analytics.android.sdk.core.business.instantevent.InstantEventUtils.isInstantEvent(inputData)) {
                com.sensorsdata.analytics.android.sdk.AnalyticsMessages.getInstance(this.mContext.getApplicationContext()).flushInstanceEvent();
                return;
            }
            com.sensorsdata.analytics.android.sdk.AnalyticsMessages analyticsMessages = com.sensorsdata.analytics.android.sdk.AnalyticsMessages.getInstance(this.mContext.getApplicationContext());
            if (i >= 0 && i <= this.mInternalConfigs.saConfigOptions.getFlushBulkSize() && !this.mInternalConfigs.debugMode.isDebugMode() && inputData.getEventType() != com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP) {
                z = false;
                analyticsMessages.flushEventMessage(z);
            }
            z = true;
            analyticsMessages.flushEventMessage(z);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
