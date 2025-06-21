package com.sensorsdata.analytics.android.sdk.core.event.imp;

/* loaded from: classes19.dex */
public class AssembleDataImpl implements com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.IAssembleData {
    private final com.sensorsdata.analytics.android.sdk.core.event.imp.H5TrackAssemble mH5EventAssemble;
    private final com.sensorsdata.analytics.android.sdk.core.event.imp.ItemEventAssemble mItemEventAssemble;
    private final com.sensorsdata.analytics.android.sdk.core.event.imp.TrackEventAssemble mTrackEventAssemble;

    public AssembleDataImpl(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mTrackEventAssemble = new com.sensorsdata.analytics.android.sdk.core.event.imp.TrackEventAssemble(sAContextManager);
        this.mItemEventAssemble = new com.sensorsdata.analytics.android.sdk.core.event.imp.ItemEventAssemble(sAContextManager);
        this.mH5EventAssemble = new com.sensorsdata.analytics.android.sdk.core.event.imp.H5TrackAssemble(sAContextManager);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.IAssembleData
    public com.sensorsdata.analytics.android.sdk.core.event.Event assembleData(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        return !android.text.TextUtils.isEmpty(inputData.getExtras()) ? this.mH5EventAssemble.assembleData(inputData) : (inputData.getEventType() == com.sensorsdata.analytics.android.sdk.internal.beans.EventType.ITEM_DELETE || inputData.getEventType() == com.sensorsdata.analytics.android.sdk.internal.beans.EventType.ITEM_SET) ? this.mItemEventAssemble.assembleData(inputData) : this.mTrackEventAssemble.assembleData(inputData);
    }
}
