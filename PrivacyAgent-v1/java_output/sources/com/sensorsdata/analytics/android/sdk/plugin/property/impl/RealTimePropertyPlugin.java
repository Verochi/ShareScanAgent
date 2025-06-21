package com.sensorsdata.analytics.android.sdk.plugin.property.impl;

/* loaded from: classes19.dex */
public class RealTimePropertyPlugin extends com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin {
    android.content.Context mContext;
    com.sensorsdata.analytics.android.sdk.core.SAContextManager mContextManager;

    public RealTimePropertyPlugin(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mContext = sAContextManager.getContext();
        this.mContextManager = sAContextManager;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public boolean isMatchedWithFilter(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter) {
        return sAPropertyFilter.getType().isTrack() && "Android".equals(sAPropertyFilter.getEventJson("lib").optString("$lib"));
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher) {
        try {
            java.lang.String networkType = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.networkType(this.mContext);
            sAPropertiesFetcher.getProperties().put("$wifi", "WIFI".equals(networkType));
            sAPropertiesFetcher.getProperties().put("$network_type", networkType);
            com.sensorsdata.analytics.android.sdk.SensorsDataGPSLocation sensorsDataGPSLocation = this.mContextManager.getInternalConfigs().gpsLocation;
            if (sensorsDataGPSLocation != null) {
                sensorsDataGPSLocation.toJSON(sAPropertiesFetcher.getProperties());
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        try {
            java.lang.String screenOrientation = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getScreenOrientation();
            if (android.text.TextUtils.isEmpty(screenOrientation)) {
                return;
            }
            sAPropertiesFetcher.getProperties().put("$screen_orientation", screenOrientation);
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }
}
