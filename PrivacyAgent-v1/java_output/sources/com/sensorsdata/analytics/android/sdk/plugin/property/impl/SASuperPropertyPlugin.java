package com.sensorsdata.analytics.android.sdk.plugin.property.impl;

/* loaded from: classes19.dex */
public class SASuperPropertyPlugin extends com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin {
    private final com.sensorsdata.analytics.android.sdk.SensorsDataAPI mSensorsDataAPI;

    public SASuperPropertyPlugin(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI) {
        this.mSensorsDataAPI = sensorsDataAPI;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher) {
        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeSuperJSONObject(this.mSensorsDataAPI.getDynamicProperty(), this.mSensorsDataAPI.getSuperProperties()), sAPropertiesFetcher.getProperties());
    }
}
