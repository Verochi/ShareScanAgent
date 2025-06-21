package com.sensorsdata.analytics.android.sdk.advert.plugin;

/* loaded from: classes19.dex */
public class LatestUtmPlugin extends com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin {
    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public boolean isMatchedWithFilter(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter) {
        return (!sAPropertyFilter.getType().isTrack() || "$AppEnd".equals(sAPropertyFilter.getEvent()) || com.sensorsdata.analytics.android.sdk.advert.SAAdvertConstants.EventName.DEEPLINK_LAUNCH.equals(sAPropertyFilter.getEvent())) ? false : true;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher) {
        com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.getLatestUtmProperties(), sAPropertiesFetcher.getProperties());
    }
}
