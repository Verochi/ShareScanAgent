package com.sensorsdata.analytics.android.sdk.core.event.imp;

/* loaded from: classes19.dex */
class TrackEventAssemble extends com.sensorsdata.analytics.android.sdk.core.event.imp.BaseEventAssemble {
    private static final java.lang.String TAG = "SA.TrackEventAssemble";
    private final com.sensorsdata.analytics.android.sdk.core.SAContextManager mContextManager;

    public TrackEventAssemble(com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        super(sAContextManager);
        this.mContextManager = sAContextManager;
    }

    private void appendDefaultProperty(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) {
        try {
            trackEvent.setTime(inputData.getTime());
            trackEvent.setEventName(inputData.getEventName());
            trackEvent.setType(inputData.getEventType().getEventType());
            trackEvent.setTrackId(new java.security.SecureRandom().nextInt());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void appendEventDuration(com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) {
        try {
            java.lang.String eventName = trackEvent.getEventName();
            if (android.text.TextUtils.isEmpty(eventName)) {
                return;
            }
            com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer eventTimer = com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.getInstance().getEventTimer(eventName);
            if (eventTimer != null) {
                float duration = eventTimer.duration();
                if (duration > 0.0f) {
                    trackEvent.getProperties().put("event_duration", java.lang.Float.valueOf(duration));
                }
            }
            if (!eventName.endsWith("_SATimer") || eventName.length() <= 45) {
                return;
            }
            java.lang.String substring = eventName.substring(0, eventName.length() - 45);
            trackEvent.setEventName(substring);
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "trigger event name = " + substring);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    private void appendLibProperty(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) throws org.json.JSONException {
        com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventTypeFromEventName;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject properties = trackEvent.getProperties();
        java.lang.String str = null;
        if (properties != null) {
            if (eventType.isTrack()) {
                java.lang.String optString = trackEvent.getProperties().optString("$lib_method", "code");
                jSONObject.put("$lib_method", optString);
                properties.put("$lib_method", optString);
            } else {
                jSONObject.put("$lib_method", "code");
            }
            if (properties.has("$lib_detail")) {
                str = properties.optString("$lib_detail");
                properties.remove("$lib_detail");
            }
        } else {
            jSONObject.put("$lib_method", "code");
            if (eventType.isTrack()) {
                properties = new org.json.JSONObject();
                properties.put("$lib_method", "code");
            }
        }
        jSONObject.put("$lib", "Android");
        jSONObject.put("$lib_version", this.mContextManager.getSensorsDataAPI().getSDKVersion());
        jSONObject.put("$app_version", com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getAppVersionName(this.mContextManager.getContext()));
        org.json.JSONObject jSONObject2 = com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getSuperPropertiesPst().get();
        if (jSONObject2 != null && jSONObject2.has("$app_version")) {
            jSONObject.put("$app_version", jSONObject2.get("$app_version"));
        }
        if (this.mContextManager.getSensorsDataAPI().isAutoTrackEnabled() && properties != null && isAutoTrackType(trackEvent.getEventName()) && (autoTrackEventTypeFromEventName = autoTrackEventTypeFromEventName(trackEvent.getEventName())) != null && !this.mContextManager.getSensorsDataAPI().isAutoTrackEventTypeIgnored(autoTrackEventTypeFromEventName) && trackEvent.getProperties().has("$screen_name")) {
            java.lang.String string = properties.getString("$screen_name");
            if (!android.text.TextUtils.isEmpty(string)) {
                java.lang.String[] split = string.split("\\|");
                if (split.length > 0) {
                    str = java.lang.String.format("%s##%s##%s##%s", split[0], "", "", "");
                }
            }
        }
        if (android.text.TextUtils.isEmpty(str)) {
            java.lang.StackTraceElement[] stackTrace = new java.lang.Exception().getStackTrace();
            if (stackTrace.length > 1) {
                java.lang.StackTraceElement stackTraceElement = stackTrace[0];
                str = java.lang.String.format("%s##%s##%s##%s", stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), java.lang.Integer.valueOf(stackTraceElement.getLineNumber()));
            }
        }
        jSONObject.put("$lib_detail", str);
        trackEvent.setLib(jSONObject);
        trackEvent.setProperties(properties);
    }

    private void appendPluginProperties(com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, org.json.JSONObject jSONObject, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) throws org.json.JSONException {
        com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter sAPropertyFilter = new com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter();
        sAPropertyFilter.setEvent(trackEvent.getEventName());
        sAPropertyFilter.setTime(trackEvent.getTime());
        sAPropertyFilter.setEventJson("lib", trackEvent.getLib());
        if (trackEvent.getIdentities() != null) {
            sAPropertyFilter.setEventJson("identities", new org.json.JSONObject(trackEvent.getIdentities().toString()));
        }
        sAPropertyFilter.setProperties(trackEvent.getProperties());
        sAPropertyFilter.setType(eventType);
        com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin propertyPlugin = this.mContextManager.getPluginManager().getPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.impl.InternalCustomPropertyPlugin.class.getName());
        if (propertyPlugin instanceof com.sensorsdata.analytics.android.sdk.plugin.property.impl.InternalCustomPropertyPlugin) {
            ((com.sensorsdata.analytics.android.sdk.plugin.property.impl.InternalCustomPropertyPlugin) propertyPlugin).saveCustom(jSONObject);
        }
        com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher propertiesHandler = this.mContextManager.getPluginManager().propertiesHandler(sAPropertyFilter);
        if (propertiesHandler != null) {
            trackEvent.setProperties(propertiesHandler.getProperties());
            trackEvent.setLib(propertiesHandler.getEventJson("lib"));
        }
    }

    private void appendUserIDs(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData, com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent) throws org.json.JSONException {
        java.lang.String distinctId = this.mContextManager.getUserIdentityAPI().getDistinctId();
        java.lang.String loginId = this.mContextManager.getUserIdentityAPI().getLoginId();
        java.lang.String anonymousId = this.mContextManager.getUserIdentityAPI().getAnonymousId();
        try {
            if ("$PlanPopupDisplay".equals(trackEvent.getEventName())) {
                if (trackEvent.getProperties().has("$sf_internal_anonymous_id")) {
                    anonymousId = trackEvent.getProperties().optString("$sf_internal_anonymous_id");
                    trackEvent.getProperties().remove("$sf_internal_anonymous_id");
                    inputData.getProperties().remove("$sf_internal_anonymous_id");
                }
                if (trackEvent.getProperties().has("$sf_internal_login_id")) {
                    loginId = trackEvent.getProperties().optString("$sf_internal_login_id");
                    trackEvent.getProperties().remove("$sf_internal_login_id");
                    inputData.getProperties().remove("$sf_internal_login_id");
                }
                distinctId = !android.text.TextUtils.isEmpty(loginId) ? loginId : anonymousId;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType = inputData.getEventType();
        org.json.JSONObject identities = this.mContextManager.getUserIdentityAPI().getIdentities(eventType);
        com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType2 = com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_UNBIND;
        if (!eventType2.getEventType().equals(trackEvent.getType())) {
            if (identities != null) {
                if (android.text.TextUtils.isEmpty(anonymousId)) {
                    anonymousId = identities.optString(com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANONYMOUS_ID);
                } else {
                    identities.put(com.sensorsdata.analytics.android.sdk.useridentity.Identities.ANONYMOUS_ID, anonymousId);
                }
                if (android.text.TextUtils.isEmpty(loginId)) {
                    loginId = identities.optString(this.mContextManager.getUserIdentityAPI().getIdentitiesInstance().getLoginIDKey());
                } else {
                    identities.put(this.mContextManager.getUserIdentityAPI().getIdentitiesInstance().getLoginIDKey(), loginId);
                }
            }
            if (!android.text.TextUtils.isEmpty(loginId)) {
                trackEvent.setLoginId(loginId);
            }
            trackEvent.setAnonymousId(anonymousId);
        }
        trackEvent.setDistinctId(distinctId);
        trackEvent.setIdentities(identities);
        if (eventType == com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK || eventType == com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_BIND || eventType == eventType2) {
            trackEvent.getProperties().put("$is_first_day", this.mContextManager.isFirstDay(trackEvent.getTime()));
        } else if (eventType == com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP) {
            trackEvent.setOriginalId(trackEvent.getAnonymousId());
        }
    }

    public static com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventTypeFromEventName(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
        }
        return null;
    }

    public static boolean isAutoTrackType(java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str)) {
            str.hashCode();
            switch (str) {
                case "$AppViewScreen":
                case "$AppEnd":
                case "$AppClick":
                case "$AppStart":
                    return true;
            }
        }
        return false;
    }

    private boolean isEventIgnore(java.lang.String str, com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType, com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager) {
        if (!eventType.isTrack()) {
            return false;
        }
        com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertEventName(str);
        return (android.text.TextUtils.isEmpty(str) || sAContextManager.getRemoteManager() == null || !sAContextManager.getRemoteManager().ignoreEvent(str)) ? false : true;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.event.EventProcessor.IAssembleData
    public com.sensorsdata.analytics.android.sdk.core.event.Event assembleData(com.sensorsdata.analytics.android.sdk.core.event.InputData inputData) {
        try {
            com.sensorsdata.analytics.android.sdk.internal.beans.EventType eventType = inputData.getEventType();
            org.json.JSONObject cloneJsonObject = com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(inputData.getProperties());
            if (cloneJsonObject == null) {
                cloneJsonObject = new org.json.JSONObject();
            }
            if (isEventIgnore(inputData.getEventName(), eventType, this.mContextManager)) {
                return null;
            }
            com.sensorsdata.analytics.android.sdk.core.event.TrackEvent trackEvent = new com.sensorsdata.analytics.android.sdk.core.event.TrackEvent();
            trackEvent.setProperties(cloneJsonObject);
            appendDefaultProperty(inputData, trackEvent);
            appendEventDuration(trackEvent);
            appendLibProperty(eventType, trackEvent);
            appendUserIDs(inputData, trackEvent);
            appendSessionId(eventType, trackEvent);
            appendPluginProperties(eventType, inputData.getProperties(), trackEvent);
            handlePropertyProtocols(trackEvent);
            if (!handleEventCallback(eventType, trackEvent)) {
                return null;
            }
            appendPluginVersion(eventType, trackEvent);
            overrideDeviceId(eventType, trackEvent, this.mContextManager);
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyTypes(trackEvent.getProperties());
            handleEventListener(eventType, trackEvent, this.mContextManager);
            if (com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "track event:\n" + com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(trackEvent.toJSONObject().toString()));
            }
            return trackEvent;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }
}
