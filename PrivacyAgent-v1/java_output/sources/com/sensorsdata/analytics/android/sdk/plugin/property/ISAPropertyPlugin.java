package com.sensorsdata.analytics.android.sdk.plugin.property;

/* loaded from: classes19.dex */
public interface ISAPropertyPlugin {
    java.lang.String getName();

    boolean isMatchedWithFilter(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter);

    com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority priority();

    void properties(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher);
}
