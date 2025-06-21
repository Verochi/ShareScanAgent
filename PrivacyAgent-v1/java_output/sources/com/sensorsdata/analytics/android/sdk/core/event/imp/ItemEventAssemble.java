package com.sensorsdata.analytics.android.sdk.core.event.imp;

/* loaded from: classes19.dex */
class ItemEventAssemble extends com.sensorsdata.analytics.android.sdk.core.event.imp.BaseEventAssemble {
    private static final java.lang.String TAG = "SA.ItemEventAssemble";

    public ItemEventAssemble(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        super(sAContextManager);
    }

    private void appendDefaultProperty(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) {
        if (com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyKey(inputData.getItemType())) {
            trackEvent.setItemType(inputData.getItemType());
        }
        trackEvent.setItemId(inputData.getItemId());
        trackEvent.setType(inputData.getEventType().getEventType());
        trackEvent.setTime(inputData.getTime());
        try {
            trackEvent.setProperties(com.sensorsdata.analytics.android.sdk.util.TimeUtils.formatDate(com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(inputData.getProperties())));
        } catch (com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void appendLibProperty(com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) throws org.json.JSONException {
        com.sensorsdata.analytics.android.sdk.SensorsDataAPI sharedInstance = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("$lib", "Android");
        jSONObject.put("$lib_version", sharedInstance.getSDKVersion());
        jSONObject.put("$lib_method", "code");
        jSONObject.put("$app_version", com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getAppVersionName(sharedInstance.getSAContextManager().getContext()));
        org.json.JSONObject jSONObject2 = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getSuperPropertiesPst().get();
        if (jSONObject2 != null && jSONObject2.has("$app_version")) {
            jSONObject.put("$app_version", jSONObject2.get("$app_version"));
        }
        java.lang.StackTraceElement[] stackTrace = new java.lang.Exception().getStackTrace();
        if (stackTrace.length > 1) {
            java.lang.StackTraceElement stackTraceElement = stackTrace[0];
            java.lang.String format = java.lang.String.format("%s##%s##%s##%s", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), java.lang.Integer.valueOf(stackTraceElement.getLineNumber()));
            if (!android.text.TextUtils.isEmpty(format)) {
                jSONObject.put("$lib_detail", format);
            }
        }
        trackEvent.setLib(jSONObject);
    }

    private boolean isEventIgnore(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        try {
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyTypes(inputData.getProperties());
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertItemId(inputData.getItemId());
            return false;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return true;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.IAssembleData
    public com.sensorsdata.analytics.android.sdk.core.event.Event assembleData(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        try {
            if (isEventIgnore(inputData)) {
                return null;
            }
            com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent = new com.sensorsdata.analytics.android.sdk.core.event.TrackEvent();
            appendDefaultProperty(inputData, trackEvent);
            appendLibProperty(trackEvent);
            handlePropertyProtocols(trackEvent);
            if (com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "track item event:\n" + com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(trackEvent.toJSONObject().toString()));
            }
            return trackEvent;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }
}
