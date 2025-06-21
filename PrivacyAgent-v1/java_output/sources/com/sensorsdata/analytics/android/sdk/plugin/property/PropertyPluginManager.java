package com.sensorsdata.analytics.android.sdk.plugin.property;

/* loaded from: classes19.dex */
public final class PropertyPluginManager {
    private static final java.lang.String TAG = "SA.SAPropertyPluginManager";
    private java.util.List<com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin> mPluginsList = new java.util.ArrayList();
    private final java.util.Map<java.lang.String, com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin> mPluginMap = java.util.Collections.synchronizedMap(new java.util.LinkedHashMap());

    /* renamed from: com.sensorsdata.analytics.android.sdk.plugin.property.PropertyPluginManager$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        public int compare(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin, com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin2) {
            return sAPropertyPlugin.priority().getPriority() >= sAPropertyPlugin2.priority().getPriority() ? 0 : -1;
        }
    }

    public PropertyPluginManager(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        registerDefaultProperty(sensorsDataAPI, sAContextManager);
    }

    private void registerDefaultProperty(com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        registerPropertyPlugin(new com.sensorsdata.analytics.android.sdk.plugin.property.impl.SAPresetPropertyPlugin(sAContextManager));
        registerPropertyPlugin(new com.sensorsdata.analytics.android.sdk.plugin.property.impl.SASuperPropertyPlugin(sensorsDataAPI));
        registerPropertyPlugin(new com.sensorsdata.analytics.android.sdk.plugin.property.impl.ReferrerTitlePlugin());
        registerPropertyPlugin(new com.sensorsdata.analytics.android.sdk.plugin.property.impl.RealTimePropertyPlugin(sAContextManager));
        java.util.List propertyPlugins = sAContextManager.getInternalConfigs().saConfigOptions.getPropertyPlugins();
        if (propertyPlugins != null) {
            java.util.Iterator it = propertyPlugins.iterator();
            while (it.hasNext()) {
                registerPropertyPlugin((com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin) it.next());
            }
        }
        registerPropertyPlugin(new com.sensorsdata.analytics.android.sdk.plugin.property.impl.InternalCustomPropertyPlugin());
    }

    private void sortedPlugin() {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.mPluginMap.values());
        this.mPluginsList = arrayList;
        java.util.Collections.sort(arrayList, new com.sensorsdata.analytics.android.sdk.plugin.property.PropertyPluginManager.AnonymousClass1());
    }

    public com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin getPropertyPlugin(java.lang.String str) {
        return this.mPluginMap.get(str);
    }

    public synchronized com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher propertiesHandler(com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter) {
        try {
            if (this.mPluginsList.size() == 0) {
                return null;
            }
            com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher sAPropertiesFetcher = new com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher();
            sAPropertiesFetcher.setProperties(sAPropertyFilter.getProperties());
            sAPropertiesFetcher.setEventJson("lib", sAPropertyFilter.getEventJson("lib"));
            for (com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin : this.mPluginsList) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeJSONObject(sAPropertiesFetcher.getProperties(), jSONObject);
                sAPropertyFilter.setProperties(jSONObject);
                if (sAPropertyPlugin.isMatchedWithFilter(sAPropertyFilter)) {
                    sAPropertyPlugin.properties(sAPropertiesFetcher);
                }
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SAPropertiesFetcher: %s", sAPropertiesFetcher);
            return sAPropertiesFetcher;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("Event [%s] error is happened when matching property-plugins", sAPropertyFilter.getEvent()), e);
            return null;
        }
    }

    public synchronized void registerPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin) {
        if (sAPropertyPlugin == null) {
            return;
        }
        try {
            java.lang.String name = sAPropertyPlugin.getName();
            if (this.mPluginMap.containsKey(name)) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, name + " has exist!");
            } else {
                this.mPluginMap.put(name, sAPropertyPlugin);
                sortedPlugin();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "register property plugin exception! ", e);
        }
    }

    public synchronized void unregisterPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin) {
        if (sAPropertyPlugin == null) {
            return;
        }
        this.mPluginMap.remove(sAPropertyPlugin.getName());
        sortedPlugin();
    }
}
