package com.sensorsdata.analytics.android.sdk.plugin.property;

/* loaded from: classes19.dex */
public class SAPropertyPluginPriority {
    private final long priority;
    public static com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority LOW = new com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority(250);
    public static com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority DEFAULT = new com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority(500);
    public static com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority HIGH = new com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority(750);
    protected static com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority SUPER = new com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPluginPriority(1431656640);

    public SAPropertyPluginPriority(long j) {
        this.priority = j;
    }

    public long getPriority() {
        return this.priority;
    }
}
