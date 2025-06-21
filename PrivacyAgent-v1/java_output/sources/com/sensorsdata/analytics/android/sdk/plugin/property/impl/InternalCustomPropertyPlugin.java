package com.sensorsdata.analytics.android.sdk.plugin.property.impl;

/* loaded from: classes19.dex */
public class InternalCustomPropertyPlugin extends com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin {
    private org.json.JSONObject mCustomProperties = new org.json.JSONObject();

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public boolean isMatchedWithFilter(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter) {
        return "Android".equals(sAPropertyFilter.getEventJson("lib").optString("$lib"));
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher) {
        org.json.JSONObject jSONObject = this.mCustomProperties;
        if (jSONObject != null) {
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(jSONObject, sAPropertiesFetcher.getProperties());
            this.mCustomProperties = null;
        }
    }

    public void saveCustom(org.json.JSONObject jSONObject) {
        this.mCustomProperties = jSONObject;
        if (jSONObject != null) {
            jSONObject.remove("$device_id");
            this.mCustomProperties.remove("$anonymization_id");
        }
    }
}
