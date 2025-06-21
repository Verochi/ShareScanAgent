package com.sensorsdata.analytics.android.sdk.core.event.imp;

/* loaded from: classes19.dex */
class H5TrackAssemble extends com.sensorsdata.analytics.android.sdk.core.event.imp.BaseEventAssemble {
    private static final java.lang.String TAG = "SA.H5TrackAssemble";

    public H5TrackAssemble(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        super(sAContextManager);
    }

    private void appendDefaultProperty(com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) {
        try {
            trackEvent.getExtras().put("_hybrid_h5", true);
            if (!trackEvent.getExtras().has("time")) {
                trackEvent.getExtras().put("time", java.lang.System.currentTimeMillis());
            }
            trackEvent.getExtras().put("_track_id", new java.security.SecureRandom().nextInt());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void appendNativeProperty(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent, com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) throws org.json.JSONException {
        org.json.JSONObject optJSONObject = trackEvent.getExtras().optJSONObject("lib");
        if (optJSONObject != null) {
            optJSONObject.put("$app_version", com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getAppVersionName(sAContextManager.getContext()));
            org.json.JSONObject jSONObject = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getSuperPropertiesPst().get();
            if (jSONObject != null && jSONObject.has("$app_version")) {
                optJSONObject.put("$app_version", jSONObject.get("$app_version"));
            }
            trackEvent.setLib(optJSONObject);
        }
        if (eventType.isTrack()) {
            trackEvent.getProperties().put("$is_first_day", sAContextManager.isFirstDay(trackEvent.getExtras().optLong("time")));
        }
    }

    private void appendPropertyPlugin(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent, com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI) {
        com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter = new com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter();
        sAPropertyFilter.setEvent(trackEvent.getEventName());
        sAPropertyFilter.setEventJson("lib", trackEvent.getExtras().optJSONObject("lib"));
        sAPropertyFilter.setProperties(trackEvent.getProperties());
        sAPropertyFilter.setType(eventType);
        com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher propertiesHandler = sensorsDataAPI.getSAContextManager().getPluginManager().propertiesHandler(sAPropertyFilter);
        if (propertiesHandler != null) {
            trackEvent.setProperties(propertiesHandler.getProperties());
            trackEvent.setLib(propertiesHandler.getEventJson("lib"));
        }
    }

    private void checkIDConsistent(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent, com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI) {
        try {
            org.json.JSONObject optJSONObject = trackEvent.getExtras().optJSONObject("identities");
            if (optJSONObject != null) {
                if (com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_UNBIND.getEventType().equals(eventType.getEventType())) {
                    trackEvent.getExtras().remove("anonymous_id");
                    return;
                }
                java.lang.String anonymousId = sensorsDataAPI.getAnonymousId();
                if (android.text.TextUtils.isEmpty(anonymousId)) {
                    trackEvent.getExtras().put("anonymous_id", optJSONObject.optString(com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANONYMOUS_ID));
                } else {
                    optJSONObject.put(com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANONYMOUS_ID, anonymousId);
                    trackEvent.getExtras().put("anonymous_id", anonymousId);
                }
                java.lang.String loginId = sensorsDataAPI.getLoginId();
                if (android.text.TextUtils.isEmpty(loginId)) {
                    loginId = optJSONObject.optString(sensorsDataAPI.getSAContextManager().getUserIdentityAPI().getIdentitiesInstance().getLoginIDKey());
                } else {
                    optJSONObject.put(sensorsDataAPI.getSAContextManager().getUserIdentityAPI().getIdentitiesInstance().getLoginIDKey(), loginId);
                }
                if (eventType != com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP && !android.text.TextUtils.isEmpty(sensorsDataAPI.getLoginId())) {
                    trackEvent.getExtras().put("login_id", loginId);
                }
                trackEvent.getExtras().put("identities", optJSONObject);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void overrideH5Ids(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent, com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI) throws org.json.JSONException {
        if (eventType == com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP) {
            trackEvent.getExtras().put("original_id", sensorsDataAPI.getAnonymousId());
        } else if (android.text.TextUtils.isEmpty(sensorsDataAPI.getLoginId())) {
            trackEvent.getExtras().put("distinct_id", sensorsDataAPI.getAnonymousId());
        } else {
            trackEvent.getExtras().put("distinct_id", sensorsDataAPI.getLoginId());
        }
    }

    private void removeH5Property(com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) {
        if (trackEvent.getExtras().has("_nocache")) {
            trackEvent.getExtras().remove("_nocache");
        }
        if (trackEvent.getExtras().has("server_url")) {
            trackEvent.getExtras().remove("server_url");
        }
        if (trackEvent.getExtras().has("_flush_time")) {
            trackEvent.getExtras().remove("_flush_time");
        }
    }

    private boolean updateIdentities(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent, com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        try {
            if (com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_UNBIND.getEventType().equals(eventType.getEventType())) {
                return true;
            }
            return sAContextManager.getUserIdentityAPI().mergeH5Identities(eventType, trackEvent.getExtras());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.IAssembleData
    public com.sensorsdata.analytics.android.sdk.core.event.Event assembleData(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (android.text.TextUtils.isEmpty(inputData.getExtras())) {
            return null;
        }
        com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent = new com.sensorsdata.analytics.android.sdk.core.event.TrackEvent();
        trackEvent.setExtras(new org.json.JSONObject(inputData.getExtras()));
        java.lang.String optString = trackEvent.getExtras().optString("event");
        com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertEventName(optString);
        trackEvent.setEventName(optString);
        org.json.JSONObject optJSONObject = trackEvent.getExtras().optJSONObject("properties");
        com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyTypes(optJSONObject);
        if (optJSONObject == null) {
            optJSONObject = new org.json.JSONObject();
        }
        trackEvent.setProperties(optJSONObject);
        com.sensorsdata.analytics.android.sdk.internal.beans.EventType valueOf = com.sensorsdata.analytics.android.sdk.internal.beans.EventType.valueOf(trackEvent.getExtras().getString("type").toUpperCase(java.util.Locale.getDefault()));
        com.sensorsdata.analytics.android.sdk.SensorsDataAPI sharedInstance = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance();
        com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager = sharedInstance.getSAContextManager();
        appendDefaultProperty(trackEvent);
        overrideH5Ids(valueOf, trackEvent, sharedInstance);
        appendNativeProperty(valueOf, trackEvent, sAContextManager);
        appendPropertyPlugin(valueOf, trackEvent, sharedInstance);
        appendSessionId(valueOf, trackEvent);
        handlePropertyProtocols(trackEvent);
        if (!handleEventCallback(valueOf, trackEvent)) {
            return null;
        }
        appendPluginVersion(valueOf, trackEvent);
        removeH5Property(trackEvent);
        overrideDeviceId(valueOf, trackEvent, sAContextManager);
        if (updateIdentities(valueOf, trackEvent, sharedInstance, sAContextManager)) {
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyTypes(trackEvent.getProperties());
            trackEvent.getExtras().put("properties", trackEvent.getProperties());
            trackEvent.getExtras().put("lib", trackEvent.getLib());
            checkIDConsistent(valueOf, trackEvent, sharedInstance);
            if (com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "track event from H5:\n" + com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(trackEvent.getExtras().toString()));
            }
            return trackEvent;
        }
        return null;
    }
}
