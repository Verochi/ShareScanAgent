package com.sensorsdata.analytics.android.autotrack.core.plugins;

/* loaded from: classes19.dex */
public class AutoTrackEventPlugin extends com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin {
    private java.lang.String mEventName;

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public boolean isMatchedWithFilter(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter) {
        this.mEventName = sAPropertyFilter.getEvent();
        return "$AppStart".equals(sAPropertyFilter.getEvent()) || "$AppEnd".equals(sAPropertyFilter.getEvent());
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher) {
        try {
            org.json.JSONObject properties = sAPropertiesFetcher.getProperties();
            org.json.JSONObject eventJson = sAPropertiesFetcher.getEventJson("lib");
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if ("$AppEnd".equals(this.mEventName)) {
                long optLong = properties.optLong("event_time");
                if (optLong > 2000) {
                    currentTimeMillis = optLong;
                }
                java.lang.String optString = properties.optString("$lib_version");
                if (android.text.TextUtils.isEmpty(optString)) {
                    properties.remove("$lib_version");
                } else {
                    eventJson.put("$lib_version", optString);
                }
                java.lang.String optString2 = properties.optString("$app_version");
                if (android.text.TextUtils.isEmpty(optString2)) {
                    properties.remove("$app_version");
                } else {
                    eventJson.put("$app_version", optString2);
                }
                properties.remove("event_time");
            } else if ("$AppStart".equals(this.mEventName)) {
                long optLong2 = properties.optLong("event_time");
                if (optLong2 > 0) {
                    currentTimeMillis = optLong2;
                }
                properties.remove("event_time");
            }
            properties.put("$time", new java.util.Date(currentTimeMillis));
            sAPropertiesFetcher.setProperties(properties);
            sAPropertiesFetcher.setEventJson("lib", eventJson);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
