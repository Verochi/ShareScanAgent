package com.sensorsdata.analytics.android.sdk.core.event.imp;

/* loaded from: classes19.dex */
public class StoreDataImpl implements com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.IStoreData {
    private static final java.lang.String TAG = "SA.StoreDataImpl";
    private final com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter mDbAdapter = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance();

    @Override // com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.IStoreData
    public int storeData(com.sensorsdata.analytics.android.sdk.core.event.Event event) {
        if (event == null) {
            return 0;
        }
        org.json.JSONObject jSONObject = event.toJSONObject();
        int addJSON = this.mDbAdapter.addJSON(jSONObject);
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_SEND_EVENT_SAT, jSONObject);
        if (addJSON < 0) {
            java.lang.String str = "Failed to enqueue the event: " + jSONObject;
            if (com.sensorsdata.analytics.android.sdk.SALog.isDebug()) {
                throw new com.sensorsdata.analytics.android.sdk.exceptions.DebugModeException(str);
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, str);
        }
        return addJSON;
    }
}
