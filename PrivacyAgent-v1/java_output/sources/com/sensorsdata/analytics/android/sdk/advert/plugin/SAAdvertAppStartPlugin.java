package com.sensorsdata.analytics.android.sdk.advert.plugin;

/* loaded from: classes19.dex */
public class SAAdvertAppStartPlugin extends com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin {
    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public boolean isMatchedWithFilter(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter) {
        return "$AppStart".equals(sAPropertyFilter.getEvent());
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.sensorsdata.analytics.android.sdk.advert.deeplink.DeepLinkManager.mergeCacheProperties(jSONObject);
        if (jSONObject.length() > 0) {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                try {
                    sAPropertiesFetcher.getProperties().put(next, jSONObject.opt(next));
                } catch (org.json.JSONException e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
            }
        }
    }
}
