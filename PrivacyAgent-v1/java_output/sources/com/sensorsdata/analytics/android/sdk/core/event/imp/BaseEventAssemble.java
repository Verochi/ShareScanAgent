package com.sensorsdata.analytics.android.sdk.core.event.imp;

/* loaded from: classes19.dex */
public abstract class BaseEventAssemble implements com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.IAssembleData {
    private static final java.lang.String TAG = "SA.BaseEventAssemble";
    protected com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions mInternalConfigs;

    public BaseEventAssemble(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        this.mInternalConfigs = sAContextManager.getInternalConfigs();
    }

    private boolean isEnterDb(java.lang.String str, org.json.JSONObject jSONObject) {
        boolean z = true;
        if (this.mInternalConfigs.sensorsDataTrackEventCallBack != null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SDK have set trackEvent callBack");
            try {
                z = this.mInternalConfigs.sensorsDataTrackEventCallBack.onTrackEvent(str, jSONObject);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            if (z) {
                try {
                    java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        java.lang.String next = keys.next();
                        java.lang.Object opt = jSONObject.opt(next);
                        if (opt instanceof java.util.Date) {
                            jSONObject.put(next, com.sensorsdata.analytics.android.sdk.util.TimeUtils.formatDate((java.util.Date) opt, com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE));
                        } else {
                            jSONObject.put(next, opt);
                        }
                    }
                } catch (java.lang.Exception e2) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                }
            }
        }
        return z;
    }

    public void appendPluginVersion(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) {
        if (eventType.isTrack()) {
            com.sensorsdata.analytics.android.sdk.core.business.SAPluginVersion.appendPluginVersion(trackEvent.getProperties());
        }
    }

    public void appendSessionId(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) {
        if (eventType.isTrack()) {
            try {
                com.sensorsdata.analytics.android.sdk.core.business.session.SessionRelatedManager.getInstance().handleEventOfSession(trackEvent.getEventName(), trackEvent.getProperties(), trackEvent.getTime());
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public boolean handleEventCallback(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) {
        if (!eventType.isTrack() || isEnterDb(trackEvent.getEventName(), trackEvent.getProperties())) {
            return true;
        }
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, trackEvent.getEventName() + " event can not enter database");
        return false;
    }

    public void handleEventListener(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent, com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        try {
            if (sAContextManager.getEventListenerList() != null && eventType.isTrack()) {
                java.util.Iterator<com.sensorsdata.analytics.android.sdk.listener.SAEventListener> it = sAContextManager.getEventListenerList().iterator();
                while (it.hasNext()) {
                    it.next().trackEvent(trackEvent.toJSONObject());
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        try {
            if (eventType.isTrack()) {
                com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance().callTrack(trackEvent.toJSONObject());
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public void handlePropertyProtocols(com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) throws org.json.JSONException {
        if (trackEvent.getProperties().has("$project")) {
            if (this instanceof com.sensorsdata.analytics.android.sdk.core.event.imp.H5TrackAssemble) {
                trackEvent.getExtras().put("project", trackEvent.getProperties().optString("$project"));
            } else {
                trackEvent.setProject(trackEvent.getProperties().optString("$project"));
            }
            trackEvent.getProperties().remove("$project");
        }
        if (trackEvent.getProperties().has("$token")) {
            if (this instanceof com.sensorsdata.analytics.android.sdk.core.event.imp.H5TrackAssemble) {
                trackEvent.getExtras().put("token", trackEvent.getProperties().optString("$token"));
            } else {
                trackEvent.setToken(trackEvent.getProperties().optString("$token"));
            }
            trackEvent.getProperties().remove("$token");
        }
        if (trackEvent.getProperties().has("$time")) {
            try {
                if (this instanceof com.sensorsdata.analytics.android.sdk.core.event.imp.H5TrackAssemble) {
                    long j = trackEvent.getProperties().getLong("$time");
                    if (com.sensorsdata.analytics.android.sdk.util.TimeUtils.isDateValid(j)) {
                        trackEvent.getExtras().put("time", j);
                    }
                } else {
                    java.lang.Object opt = trackEvent.getProperties().opt("$time");
                    if ((opt instanceof java.util.Date) && com.sensorsdata.analytics.android.sdk.util.TimeUtils.isDateValid((java.util.Date) opt)) {
                        trackEvent.setTime(((java.util.Date) opt).getTime());
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            trackEvent.getProperties().remove("$time");
        }
    }

    public void overrideDeviceId(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent, com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        try {
            if (eventType.isTrack() && trackEvent != null) {
                com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin propertyPlugin = sAContextManager.getPluginManager().getPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.impl.SAPresetPropertyPlugin.class.getName());
                if (propertyPlugin instanceof com.sensorsdata.analytics.android.sdk.plugin.property.impl.SAPresetPropertyPlugin) {
                    org.json.JSONObject presetProperties = ((com.sensorsdata.analytics.android.sdk.plugin.property.impl.SAPresetPropertyPlugin) propertyPlugin).getPresetProperties();
                    trackEvent.getProperties().remove("$device_id");
                    trackEvent.getProperties().remove("$anonymization_id");
                    if (this.mInternalConfigs.saConfigOptions.isDisableDeviceId()) {
                        if (presetProperties.has("$anonymization_id")) {
                            trackEvent.getProperties().put("$anonymization_id", presetProperties.optString("$anonymization_id"));
                        }
                    } else if (presetProperties.has("$device_id")) {
                        trackEvent.getProperties().put("$device_id", presetProperties.optString("$device_id"));
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
