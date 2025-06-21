package com.sensorsdata.analytics.android.sdk.plugin.property;

/* loaded from: classes19.dex */
public abstract class SAPropertyPlugin implements com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin {
    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public java.lang.String getName() {
        return getClass().getName();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public boolean isMatchedWithFilter(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter) {
        return sAPropertyFilter.getType().isTrack();
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority priority() {
        return com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority.DEFAULT;
    }

    @Override // com.sensorsdata.analytics.android.sdk.plugin.property.ISAPropertyPlugin
    public abstract void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher);
}
