package com.sensorsdata.analytics.android.sdk.core.event;

/* loaded from: classes19.dex */
public abstract class EventProcessor {
    com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.IAssembleData mAssembleData;
    com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.ISendData mSendData;
    com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.IStoreData mStoreData = new com.sensorsdata.analytics.android.sdk.core.event.imp.StoreDataImpl();

    public interface IAssembleData {
        com.sensorsdata.analytics.android.sdk.core.event.Event assembleData(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData);
    }

    public interface ISendData {
        void sendData(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData, int i);
    }

    public interface IStoreData {
        int storeData(com.sensorsdata.analytics.android.sdk.core.event.Event event);
    }

    public EventProcessor(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mAssembleData = new com.sensorsdata.analytics.android.sdk.core.event.imp.AssembleDataImpl(sAContextManager);
        this.mSendData = new com.sensorsdata.analytics.android.sdk.core.event.imp.SendDataImpl(sAContextManager);
    }

    public com.sensorsdata.analytics.android.sdk.core.event.Event assembleData(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        return this.mAssembleData.assembleData(inputData);
    }

    public synchronized void process(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        try {
            sendData(inputData, storeData(assembleData(inputData)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public void sendData(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData, int i) {
        this.mSendData.sendData(inputData, i);
    }

    public int storeData(com.sensorsdata.analytics.android.sdk.core.event.Event event) {
        return this.mStoreData.storeData(event);
    }

    public abstract void trackEvent(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData);
}
