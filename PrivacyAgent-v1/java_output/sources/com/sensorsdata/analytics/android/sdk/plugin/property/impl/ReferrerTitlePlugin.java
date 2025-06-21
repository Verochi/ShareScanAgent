package com.sensorsdata.analytics.android.sdk.plugin.property.impl;

/* loaded from: classes19.dex */
public class ReferrerTitlePlugin extends com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin {
    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public boolean isMatchedWithFilter(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter) {
        return sAPropertyFilter.getType().isTrack() && "Android".equals(sAPropertyFilter.getEventJson("lib").optString("$lib"));
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher) {
        java.lang.String str = (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_GET_REFERRER_SCREEN_TITLE, new java.lang.Object[0]);
        if (str != null) {
            try {
                if (sAPropertiesFetcher.getProperties().has("$referrer_title")) {
                    return;
                }
                sAPropertiesFetcher.getProperties().put("$referrer_title", str);
            } catch (org.json.JSONException e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }
}
