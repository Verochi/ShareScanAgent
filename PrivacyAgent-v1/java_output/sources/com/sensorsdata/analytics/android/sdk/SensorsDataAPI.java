package com.sensorsdata.analytics.android.sdk;

/* loaded from: classes19.dex */
public class SensorsDataAPI extends com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI {
    public static java.lang.String ANDROID_PLUGIN_VERSION = "4.0.3";
    static final java.lang.String MIN_PLUGIN_VERSION = "3.5.2";
    static final java.lang.String VERSION = "6.8.0";
    public static final int VTRACK_SUPPORTED_MIN_API = 16;

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$coordinate;
        final /* synthetic */ double val$latitude;
        final /* synthetic */ double val$longitude;

        public AnonymousClass1(double d, double d2, java.lang.String str) {
            this.val$latitude = d;
            this.val$longitude = d2;
            this.val$coordinate = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions internalConfigOptions = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mInternalConfigs;
                if (internalConfigOptions.gpsLocation == null) {
                    internalConfigOptions.gpsLocation = new com.sensorsdata.analytics.android.sdk.SensorsDataGPSLocation();
                }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mInternalConfigs.gpsLocation.setLatitude((long) (this.val$latitude * java.lang.Math.pow(10.0d, 6.0d)));
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mInternalConfigs.gpsLocation.setLongitude((long) (this.val$longitude * java.lang.Math.pow(10.0d, 6.0d)));
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mInternalConfigs.gpsLocation.setCoordinate(com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyValue(this.val$coordinate));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$cloneProperties;
        final /* synthetic */ java.lang.String val$eventName;

        public AnonymousClass10(java.lang.String str, org.json.JSONObject jSONObject) {
            this.val$eventName = str;
            this.val$cloneProperties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                org.json.JSONObject jSONObject = (org.json.JSONObject) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_MERGE_CHANNEL_EVENT_PROPERTIES, this.val$eventName, this.val$cloneProperties);
                if (jSONObject == null) {
                    jSONObject = this.val$cloneProperties;
                }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName(this.val$eventName).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setProperties(jSONObject));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$eventName;
        final /* synthetic */ long val$startTime;
        final /* synthetic */ java.util.concurrent.TimeUnit val$timeUnit;

        public AnonymousClass11(java.lang.String str, java.util.concurrent.TimeUnit timeUnit, long j) {
            this.val$eventName = str;
            this.val$timeUnit = timeUnit;
            this.val$startTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertEventName(this.val$eventName);
                com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.getInstance().addEventTimer(this.val$eventName, new com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimer(this.val$timeUnit, this.val$startTime));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$12, reason: invalid class name */
    public class AnonymousClass12 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$eventName;

        public AnonymousClass12(java.lang.String str) {
            this.val$eventName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertEventName(this.val$eventName);
                com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.getInstance().removeTimer(this.val$eventName);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$13, reason: invalid class name */
    public class AnonymousClass13 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$eventName;
        final /* synthetic */ long val$startTime;

        public AnonymousClass13(java.lang.String str, long j) {
            this.val$eventName = str;
            this.val$startTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.getInstance().updateTimerState(this.val$eventName, this.val$startTime, true);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$14, reason: invalid class name */
    public class AnonymousClass14 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$eventName;
        final /* synthetic */ long val$startTime;

        public AnonymousClass14(java.lang.String str, long j) {
            this.val$eventName = str;
            this.val$startTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.getInstance().updateTimerState(this.val$eventName, this.val$startTime, false);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$15, reason: invalid class name */
    public class AnonymousClass15 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$cloneProperties;
        final /* synthetic */ long val$endTime;
        final /* synthetic */ java.lang.String val$eventName;

        public AnonymousClass15(java.lang.String str, long j, org.json.JSONObject jSONObject) {
            this.val$eventName = str;
            this.val$endTime = j;
            this.val$cloneProperties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$eventName != null) {
                com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.getInstance().updateEndTime(this.val$eventName, this.val$endTime);
            }
            try {
                org.json.JSONObject jSONObject = (org.json.JSONObject) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_MERGE_CHANNEL_EVENT_PROPERTIES, this.val$eventName, this.val$cloneProperties);
                if (jSONObject == null) {
                    jSONObject = this.val$cloneProperties;
                }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName(this.val$eventName).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK).setProperties(jSONObject));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$16, reason: invalid class name */
    public class AnonymousClass16 implements java.lang.Runnable {
        public AnonymousClass16() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.core.business.timer.EventTimerManager.getInstance().clearTimers();
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$17, reason: invalid class name */
    public class AnonymousClass17 implements java.lang.Runnable {
        public AnonymousClass17() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getAnalyticsMessages().flush();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$18, reason: invalid class name */
    public class AnonymousClass18 implements java.lang.Runnable {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin val$plugin;

        public AnonymousClass18(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin) {
            this.val$plugin = sAPropertyPlugin;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getPluginManager().registerPropertyPlugin(this.val$plugin);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$19, reason: invalid class name */
    public class AnonymousClass19 implements java.lang.Runnable {
        final /* synthetic */ com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin val$plugin;

        public AnonymousClass19(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin) {
            this.val$plugin = sAPropertyPlugin;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getPluginManager().unregisterPropertyPlugin(this.val$plugin);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mInternalConfigs.gpsLocation = null;
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$20, reason: invalid class name */
    public class AnonymousClass20 implements java.lang.Runnable {
        public AnonymousClass20() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getAnalyticsMessages().deleteAll();
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$21, reason: invalid class name */
    public class AnonymousClass21 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$cloneSuperProperties;

        public AnonymousClass21(org.json.JSONObject jSONObject) {
            this.val$cloneSuperProperties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.val$cloneSuperProperties == null) {
                    return;
                }
                com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getSuperPropertiesPst().commit(com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeSuperJSONObject(this.val$cloneSuperProperties, com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getSuperPropertiesPst().get())));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$22, reason: invalid class name */
    public class AnonymousClass22 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$superPropertyName;

        public AnonymousClass22(java.lang.String str) {
            this.val$superPropertyName = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                org.json.JSONObject cloneJsonObject = com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getSuperPropertiesPst().get());
                cloneJsonObject.remove(this.val$superPropertyName);
                com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getSuperPropertiesPst().commit(cloneJsonObject);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$23, reason: invalid class name */
    public class AnonymousClass23 implements java.lang.Runnable {
        public AnonymousClass23() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getSuperPropertiesPst().commit(new org.json.JSONObject());
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$24, reason: invalid class name */
    public class AnonymousClass24 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$cloneProperties;

        public AnonymousClass24(org.json.JSONObject jSONObject) {
            this.val$cloneProperties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_SET).setProperties(this.val$cloneProperties));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$25, reason: invalid class name */
    public class AnonymousClass25 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$property;
        final /* synthetic */ java.lang.Object val$value;

        public AnonymousClass25(java.lang.String str, java.lang.Object obj) {
            this.val$property = str;
            this.val$value = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_SET).setProperties(new org.json.JSONObject().put(this.val$property, this.val$value)));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$26, reason: invalid class name */
    public class AnonymousClass26 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$cloneProperties;

        public AnonymousClass26(org.json.JSONObject jSONObject) {
            this.val$cloneProperties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_SET_ONCE).setProperties(this.val$cloneProperties));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$27, reason: invalid class name */
    public class AnonymousClass27 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$property;
        final /* synthetic */ java.lang.Object val$value;

        public AnonymousClass27(java.lang.String str, java.lang.Object obj) {
            this.val$property = str;
            this.val$value = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_SET_ONCE).setProperties(new org.json.JSONObject().put(this.val$property, this.val$value)));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$28, reason: invalid class name */
    public class AnonymousClass28 implements java.lang.Runnable {
        final /* synthetic */ java.util.Map val$properties;

        public AnonymousClass28(java.util.Map map) {
            this.val$properties = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_INCREMENT).setProperties(new org.json.JSONObject(this.val$properties)));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$29, reason: invalid class name */
    public class AnonymousClass29 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$property;
        final /* synthetic */ java.lang.Number val$value;

        public AnonymousClass29(java.lang.String str, java.lang.Number number) {
            this.val$property = str;
            this.val$value = number;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_INCREMENT).setProperties(new org.json.JSONObject().put(this.val$property, this.val$value)));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().resetAnonymousId();
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$30, reason: invalid class name */
    public class AnonymousClass30 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$property;
        final /* synthetic */ java.lang.String val$value;

        public AnonymousClass30(java.lang.String str, java.lang.String str2) {
            this.val$value = str;
            this.val$property = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                jSONArray.put(this.val$value);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(this.val$property, jSONArray);
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_APPEND).setProperties(jSONObject));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$31, reason: invalid class name */
    public class AnonymousClass31 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$property;
        final /* synthetic */ java.util.Set val$values;

        public AnonymousClass31(java.util.Set set, java.lang.String str) {
            this.val$values = set;
            this.val$property = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray();
                java.util.Iterator it = this.val$values.iterator();
                while (it.hasNext()) {
                    jSONArray.put((java.lang.String) it.next());
                }
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(this.val$property, jSONArray);
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_APPEND).setProperties(jSONObject));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$32, reason: invalid class name */
    public class AnonymousClass32 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$property;

        public AnonymousClass32(java.lang.String str) {
            this.val$property = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_UNSET).setProperties(new org.json.JSONObject().put(this.val$property, true)));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$33, reason: invalid class name */
    public class AnonymousClass33 implements java.lang.Runnable {
        public AnonymousClass33() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.PROFILE_DELETE));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$34, reason: invalid class name */
    public class AnonymousClass34 implements java.lang.Runnable {
        final /* synthetic */ android.net.Uri val$serverURI;
        final /* synthetic */ java.lang.String val$serverUrl;

        public AnonymousClass34(android.net.Uri uri, java.lang.String str) {
            this.val$serverURI = uri;
            this.val$serverUrl = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.lang.String host = this.val$serverURI.getHost();
            if (android.text.TextUtils.isEmpty(host) || !host.contains("_")) {
                return;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "Server url " + this.val$serverUrl + " contains '_' is not recommend，see details: https://en.wikipedia.org/wiki/Hostname");
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$35, reason: invalid class name */
    public class AnonymousClass35 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$pushId;
        final /* synthetic */ java.lang.String val$pushTypeKey;

        public AnonymousClass35(java.lang.String str, java.lang.String str2) {
            this.val$pushTypeKey = str;
            this.val$pushId = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyKey(this.val$pushTypeKey)) {
                    java.lang.String str = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.getDistinctId() + this.val$pushId;
                    if (android.text.TextUtils.equals(com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getPushId("distinctId_" + this.val$pushTypeKey), str)) {
                        return;
                    }
                    com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.profileSet(this.val$pushTypeKey, this.val$pushId);
                    com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitPushID("distinctId_" + this.val$pushTypeKey, str);
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$36, reason: invalid class name */
    public class AnonymousClass36 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$pushTypeKey;

        public AnonymousClass36(java.lang.String str) {
            this.val$pushTypeKey = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyKey(this.val$pushTypeKey)) {
                    java.lang.String distinctId = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.getDistinctId();
                    java.lang.String str = "distinctId_" + this.val$pushTypeKey;
                    java.lang.String pushId = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().getPushId(str);
                    if (android.text.TextUtils.isEmpty(pushId) || !pushId.startsWith(distinctId)) {
                        return;
                    }
                    com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.profileUnset(this.val$pushTypeKey);
                    com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().removePushId(str);
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$37, reason: invalid class name */
    public class AnonymousClass37 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$cloneProperties;
        final /* synthetic */ java.lang.String val$itemId;
        final /* synthetic */ java.lang.String val$itemType;

        public AnonymousClass37(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
            this.val$itemId = str;
            this.val$itemType = str2;
            this.val$cloneProperties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setItemId(this.val$itemId).setItemType(this.val$itemType).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.ITEM_SET).setProperties(this.val$cloneProperties));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$38, reason: invalid class name */
    public class AnonymousClass38 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$itemId;
        final /* synthetic */ java.lang.String val$itemType;

        public AnonymousClass38(java.lang.String str, java.lang.String str2) {
            this.val$itemId = str;
            this.val$itemType = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setItemId(this.val$itemId).setItemType(this.val$itemType).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.ITEM_DELETE));
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$distinctId;

        public AnonymousClass4(java.lang.String str) {
            this.val$distinctId = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().identify(this.val$distinctId);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ org.json.JSONObject val$cloneProperties;
        final /* synthetic */ java.lang.String val$loginIDKey;
        final /* synthetic */ java.lang.String val$loginId;

        public AnonymousClass5(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
            this.val$loginIDKey = str;
            this.val$loginId = str2;
            this.val$cloneProperties = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().loginWithKeyBack(this.val$loginIDKey, this.val$loginId)) {
                    com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName("$SignUp").setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_SIGNUP).setProperties(this.val$cloneProperties));
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().logout();
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$key;
        final /* synthetic */ java.lang.String val$value;

        public AnonymousClass7(java.lang.String str, java.lang.String str2) {
            this.val$key = str;
            this.val$value = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().bindBack(this.val$key, this.val$value)) {
                    com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName(com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI.BIND_ID).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_BIND));
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$key;
        final /* synthetic */ java.lang.String val$value;

        public AnonymousClass8(java.lang.String str, java.lang.String str2) {
            this.val$key = str;
            this.val$value = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().unbindBack(this.val$key, this.val$value)) {
                    com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.trackEvent(new com.sensorsdata.analytics.android.sdk.core.event.InputData().setEventName(com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI.UNBIND_ID).setEventType(com.sensorsdata.analytics.android.sdk.internal.beans.EventType.TRACK_ID_UNBIND));
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.SensorsDataAPI$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$anonymousId;

        public AnonymousClass9(java.lang.String str) {
            this.val$anonymousId = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.this.mSAContextManager.getUserIdentityAPI().resetAnonymousIdentity(this.val$anonymousId);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public enum AutoTrackEventType {
        APP_START(1),
        APP_END(2),
        APP_CLICK(4),
        APP_VIEW_SCREEN(8);

        public final int eventValue;

        AutoTrackEventType(int i) {
            this.eventValue = i;
        }

        public static java.lang.String autoTrackEventName(int i) {
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "" : "$AppViewScreen" : "$AppClick" : "$AppEnd" : "$AppStart";
        }

        public int getEventValue() {
            return this.eventValue;
        }
    }

    public enum DebugMode {
        DEBUG_OFF(false, false),
        DEBUG_ONLY(true, false),
        DEBUG_AND_TRACK(true, true);

        private final boolean debugMode;
        private final boolean debugWriteData;

        DebugMode(boolean z, boolean z2) {
            this.debugMode = z;
            this.debugWriteData = z2;
        }

        public boolean isDebugMode() {
            return this.debugMode;
        }

        public boolean isDebugWriteData() {
            return this.debugWriteData;
        }
    }

    public final class NetworkType {
        public static final int TYPE_2G = 1;
        public static final int TYPE_3G = 2;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 16;
        public static final int TYPE_ALL = 255;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_WIFI = 8;

        public NetworkType() {
        }
    }

    public SensorsDataAPI() {
    }

    public SensorsDataAPI(android.content.Context context, com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode) {
        super(context, sAConfigOptions, debugMode);
    }

    public static void disableSDK() {
        com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "call static function disableSDK");
        try {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI sDKInstance = getSDKInstance();
            if (!(sDKInstance instanceof com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation) && com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions() != null) {
                com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State state = com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.DISABLE_SDK;
                if (!state.isObserverCalled) {
                    sDKInstance.track("$AppDataTrackingClose");
                    sDKInstance.flush();
                }
                sDKInstance.unregisterNetworkListener(sDKInstance.getSAContextManager().getContext());
                sDKInstance.clearTrackTimer();
                com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().setModuleState(false);
                com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitAppStartTime(0L);
                com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().disableSDK(true);
                com.sensorsdata.analytics.android.sdk.SALog.setDisableSDK(true);
                if (!state.isObserverCalled) {
                    sDKInstance.getSAContextManager().getContext().getContentResolver().notifyChange(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getDisableSDKUri(), null);
                }
                state.isObserverCalled = false;
                state.isDid = true;
                com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.ENABLE_SDK.isDid = false;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void enableSDK() {
        com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "call static function enableSDK");
        try {
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI sDKInstance = getSDKInstance();
            if (!(sDKInstance instanceof com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation) && com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions() != null) {
                com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().disableSDK(false);
                com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().setModuleState(true);
                try {
                    com.sensorsdata.analytics.android.sdk.SALog.setDisableSDK(false);
                    sDKInstance.enableLog(com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled());
                    com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "enableSDK, enable log");
                    if (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getFirstDayPst().get() == null) {
                        com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getFirstDayPst().commit(com.sensorsdata.analytics.android.sdk.util.TimeUtils.formatTime(java.lang.System.currentTimeMillis(), "yyyy-MM-dd"));
                    }
                    sDKInstance.mSAContextManager.getRemoteManager().pullSDKConfigFromServer();
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                }
                com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State state = com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.ENABLE_SDK;
                if (!state.isObserverCalled) {
                    sDKInstance.getSAContextManager().getContext().getContentResolver().notifyChange(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.getInstance().getEnableSDKUri(), null);
                }
                state.isObserverCalled = false;
                state.isDid = true;
                com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.DISABLE_SDK.isDid = false;
            }
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    private static synchronized com.sensorsdata.analytics.android.sdk.SensorsDataAPI getInstance(android.content.Context context, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode, com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions) {
        synchronized (com.sensorsdata.analytics.android.sdk.SensorsDataAPI.class) {
            if (context == null) {
                return new com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation();
            }
            android.content.Context applicationContext = context.getApplicationContext();
            java.util.Map<android.content.Context, com.sensorsdata.analytics.android.sdk.SensorsDataAPI> map = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.sInstanceMap;
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI = map.get(applicationContext);
            if (sensorsDataAPI == null) {
                sensorsDataAPI = new com.sensorsdata.analytics.android.sdk.SensorsDataAPI(context, sAConfigOptions, debugMode);
                map.put(applicationContext, sensorsDataAPI);
            }
            return sensorsDataAPI;
        }
    }

    private static com.sensorsdata.analytics.android.sdk.SensorsDataAPI getSDKInstance() {
        java.util.Map<android.content.Context, com.sensorsdata.analytics.android.sdk.SensorsDataAPI> map = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.sInstanceMap;
        if (map.size() > 0) {
            java.util.Iterator<com.sensorsdata.analytics.android.sdk.SensorsDataAPI> it = map.values().iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        return new com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation();
    }

    public static com.sensorsdata.analytics.android.sdk.SensorsDataAPI sharedInstance() {
        try {
            return com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.isSDKDisabled() ? new com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation() : getSDKInstance();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return new com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation();
        }
    }

    public static com.sensorsdata.analytics.android.sdk.SensorsDataAPI sharedInstance(android.content.Context context) {
        try {
            if (!com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.isSDKDisabled() && context != null) {
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.sInstanceMap.get(context.getApplicationContext());
                if (sensorsDataAPI != null) {
                    return sensorsDataAPI;
                }
                com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
                return new com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation();
            }
            return new com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return new com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation();
        }
    }

    public static void startWithConfigOptions(android.content.Context context, com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions) {
        try {
            if (context == null || sAConfigOptions == null) {
                throw new java.lang.NullPointerException("Context、SAConfigOptions can not be null");
            }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI sensorsDataAPI = getInstance(context, com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_OFF, sAConfigOptions);
            if (sensorsDataAPI.mSDKConfigInit) {
                return;
            }
            sensorsDataAPI.applySAConfigOptions();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ void addEventListener(com.sensorsdata.analytics.android.sdk.listener.SAEventListener sAEventListener) {
        super.addEventListener(sAEventListener);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.exposure.SAExposureAPIProtocol
    public void addExposureView(android.view.View view, com.sensorsdata.analytics.android.sdk.core.business.exposure.SAExposureData sAExposureData) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.METHOD_ADD_EXPOSURE_VIEW, view, sAExposureData);
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ void addFunctionListener(com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener sAFunctionListener) {
        super.addFunctionListener(sAFunctionListener);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void addHeatMapActivities(java.util.List<java.lang.Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                for (java.lang.Class<?> cls : list) {
                    if (cls != null) {
                        int hashCode = cls.hashCode();
                        if (!this.mHeatMapActivities.contains(java.lang.Integer.valueOf(hashCode))) {
                            this.mHeatMapActivities.add(java.lang.Integer.valueOf(hashCode));
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void addHeatMapActivity(java.lang.Class<?> cls) {
        if (cls == null) {
            return;
        }
        try {
            this.mHeatMapActivities.add(java.lang.Integer.valueOf(cls.hashCode()));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ void addSAJSListener(com.sensorsdata.analytics.android.sdk.listener.SAJSListener sAJSListener) {
        super.addSAJSListener(sAJSListener);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void addVisualizedAutoTrackActivities(java.util.List<java.lang.Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                for (java.lang.Class<?> cls : list) {
                    if (cls != null) {
                        int hashCode = cls.hashCode();
                        if (!this.mVisualizedAutoTrackActivities.contains(java.lang.Integer.valueOf(hashCode))) {
                            this.mVisualizedAutoTrackActivities.add(java.lang.Integer.valueOf(hashCode));
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void addVisualizedAutoTrackActivity(java.lang.Class<?> cls) {
        if (cls == null) {
            return;
        }
        try {
            this.mVisualizedAutoTrackActivities.add(java.lang.Integer.valueOf(cls.hashCode()));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void bind(java.lang.String str, java.lang.String str2) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass7(str, str2));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void clearGPSLocation() {
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass2());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void clearLastScreenUrl() {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_CLEAR_LAST_SCREENURL, new java.lang.Object[0]);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void clearReferrerWhenAppEnd() {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_CLEAR_REFERRER_WHEN_APPEND, new java.lang.Object[0]);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void clearSuperProperties() {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass23());
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void clearTrackTimer() {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass16());
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void deleteAll() {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass20());
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void disableAutoTrack(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_DISABLE_AUTO_TRACK, autoTrackEventType);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void disableAutoTrack(java.util.List<com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType> list) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_DISABLE_AUTO_TRACK, list);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void enableAutoTrack(java.util.List<com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType> list) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_ENABLE_AUTO_TRACK, list);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void enableAutoTrackFragment(java.lang.Class<?> cls) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_ENABLE_AUTOTRACK_FRAGMENT, cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void enableAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_ENABLE_AUTOTRACK_FRAGMENTS, list);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void enableDeepLinkInstallSource(boolean z) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_ENABLE_DEEPLINK_INSTALL_SOURCE, java.lang.Boolean.valueOf(z));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void enableLog(boolean z) {
        com.sensorsdata.analytics.android.sdk.SALog.setEnableLog(z);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void enableNetworkRequest(boolean z) {
        this.mInternalConfigs.isNetworkRequestEnable = z;
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void enableRemoteConfig(boolean z) {
        try {
            com.sensorsdata.analytics.android.sdk.core.SAContextManager sAContextManager = this.mSAContextManager;
            if (sAContextManager != null) {
                this.mInternalConfigs.isRemoteConfigEnabled = z;
                if (sAContextManager.getRemoteManager() != null) {
                    this.mSAContextManager.getRemoteManager().pullSDKConfigFromServer();
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void enableTrackScreenOrientation(boolean z) {
        try {
            if (z) {
                if (this.mSAContextManager.getOrientationDetector() == null) {
                    this.mSAContextManager.setOrientationDetector(new com.sensorsdata.analytics.android.sdk.SensorsDataScreenOrientationDetector(this.mInternalConfigs.context, 3));
                }
                this.mSAContextManager.getOrientationDetector().enable();
                this.mSAContextManager.getOrientationDetector().setState(true);
                return;
            }
            if (this.mSAContextManager.getOrientationDetector() != null) {
                this.mSAContextManager.getOrientationDetector().disable();
                this.mSAContextManager.getOrientationDetector().setState(false);
                this.mSAContextManager.setOrientationDetector(null);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void flush() {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass17());
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void flushScheduled() {
        try {
            this.mSAContextManager.getAnalyticsMessages().flushScheduled();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void flushSync() {
        flush();
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public java.lang.String getAnonymousId() {
        try {
            return this.mSAContextManager.getUserIdentityAPI().getAnonymousId();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public java.lang.String getCookie(boolean z) {
        try {
            return z ? java.net.URLDecoder.decode(this.mInternalConfigs.cookie, "UTF-8") : this.mInternalConfigs.cookie;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode getDebugMode() {
        return super.getDebugMode();
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public java.lang.String getDistinctId() {
        try {
            return this.mSAContextManager.getUserIdentityAPI().getDistinctId();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ org.json.JSONObject getDynamicProperty() {
        return super.getDynamicProperty();
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public int getFlushBulkSize() {
        return com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions.mFlushBulkSize;
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public int getFlushInterval() {
        return com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions.mFlushInterval;
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public org.json.JSONObject getIdentities() {
        try {
            org.json.JSONObject identities = this.mSAContextManager.getUserIdentityAPI().getIdentities();
            if (identities != null) {
                return new org.json.JSONObject(identities.toString());
            }
            return null;
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public java.util.List<java.lang.Class<?>> getIgnoredViewTypeList() {
        try {
            return (java.util.List) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_GET_IGNORED_VIEW_TYPE_LIST, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public org.json.JSONObject getLastScreenTrackProperties() {
        return (org.json.JSONObject) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_GET_LAST_SCREEN_TRACK_PROPERTIES, new java.lang.Object[0]);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public java.lang.String getLastScreenUrl() {
        return (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_GET_LAST_SCREENURL, new java.lang.Object[0]);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public java.lang.String getLoginId() {
        try {
            return this.mSAContextManager.getUserIdentityAPI().getLoginId();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public long getMaxCacheSize() {
        return com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions.mMaxCacheSize;
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public org.json.JSONObject getPresetProperties() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin propertyPlugin = this.mSAContextManager.getPluginManager().getPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.impl.SAPresetPropertyPlugin.class.getName());
            if (propertyPlugin instanceof com.sensorsdata.analytics.android.sdk.plugin.property.impl.SAPresetPropertyPlugin) {
                jSONObject = ((com.sensorsdata.analytics.android.sdk.plugin.property.impl.SAPresetPropertyPlugin) propertyPlugin).getPresetProperties();
            }
            jSONObject.put("$is_first_day", getSAContextManager().isFirstDay(java.lang.System.currentTimeMillis()));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return jSONObject;
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ com.sensorsdata.analytics.android.sdk.core.SAContextManager getSAContextManager() {
        return super.getSAContextManager();
    }

    public java.lang.String getSDKVersion() {
        return "6.8.0";
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public java.lang.String getScreenOrientation() {
        try {
            if (this.mSAContextManager.getOrientationDetector() != null) {
                return this.mSAContextManager.getOrientationDetector().getOrientation();
            }
            return null;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public java.lang.String getServerUrl() {
        return this.mServerUrl;
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public int getSessionIntervalTime() {
        return this.mInternalConfigs.sessionTime;
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public org.json.JSONObject getSuperProperties() {
        org.json.JSONObject jSONObject;
        synchronized (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties.class) {
            try {
                try {
                    jSONObject = new org.json.JSONObject(com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.getInstance().getSuperPropertiesPst().get()).toString());
                } catch (java.lang.Exception e) {
                    com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    return new org.json.JSONObject();
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void identify(java.lang.String str) {
        try {
            com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertDistinctId(str);
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass4(str));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreAutoTrackActivities(java.util.List<java.lang.Class<?>> list) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_ACTIVITIES, list);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreAutoTrackActivity(java.lang.Class<?> cls) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_ACTIVITY, cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void ignoreAutoTrackFragment(java.lang.Class<?> cls) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_FRAGMENT, cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void ignoreAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_AUTOTRACK_FRAGMENTS, list);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreView(android.view.View view) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_VIEW, view);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreView(android.view.View view, boolean z) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_VIEW, view, java.lang.Boolean.valueOf(z));
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void ignoreViewType(java.lang.Class<?> cls) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IGNORE_VIEW_TYPE, cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isActivityAutoTrackAppClickIgnored(java.lang.Class<?> cls) {
        java.lang.Boolean bool = (java.lang.Boolean) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_ACTIVITY_AUTOTRACK_APPCLICK_IGNORED, cls);
        return bool != null && bool.booleanValue();
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isActivityAutoTrackAppViewScreenIgnored(java.lang.Class<?> cls) {
        java.lang.Boolean bool = (java.lang.Boolean) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_ACTIVITY_AUTOTRACK_APPVIEWSCREEN_IGNORED, cls);
        return bool != null && bool.booleanValue();
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isAutoTrackEnabled() {
        java.lang.Boolean bool;
        try {
            if (com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.isSDKDisabled() || (bool = (java.lang.Boolean) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_AUTOTRACK_ENABLED, new java.lang.Object[0])) == null) {
                return false;
            }
            return bool.booleanValue();
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isAutoTrackEventTypeIgnored(int i) {
        java.lang.Boolean bool = (java.lang.Boolean) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_AUTOTRACK_EVENT_TYPE_IGNORED, java.lang.Integer.valueOf(i));
        return bool != null && bool.booleanValue();
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public boolean isAutoTrackEventTypeIgnored(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType autoTrackEventType) {
        java.lang.Boolean bool = (java.lang.Boolean) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_AUTOTRACK_EVENT_TYPE_IGNORED, autoTrackEventType);
        return bool != null && bool.booleanValue();
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isDebugMode() {
        return this.mInternalConfigs.debugMode.isDebugMode();
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ boolean isDisableDefaultRemoteConfig() {
        return super.isDisableDefaultRemoteConfig();
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public boolean isFragmentAutoTrackAppViewScreen(java.lang.Class<?> cls) {
        java.lang.Boolean bool = (java.lang.Boolean) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_FRAGMENT_AUTOTRACK_APPVIEWSCREEN, cls);
        return bool != null && bool.booleanValue();
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isHeatMapActivity(java.lang.Class<?> cls) {
        if (cls == null) {
            return false;
        }
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (this.mHeatMapActivities.size() == 0) {
            return true;
        }
        return this.mHeatMapActivities.contains(java.lang.Integer.valueOf(cls.hashCode()));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isHeatMapEnabled() {
        return com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions.mHeatMapEnabled;
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isNetworkRequestEnable() {
        return this.mInternalConfigs.isNetworkRequestEnable;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public boolean isTrackFragmentAppViewScreenEnabled() {
        java.lang.Boolean bool = (java.lang.Boolean) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_IS_TRACK_FRAGMENT_APPVIEWSCREEN_ENABLED, new java.lang.Object[0]);
        return bool != null && bool.booleanValue();
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isVisualizedAutoTrackActivity(java.lang.Class<?> cls) {
        if (cls == null) {
            return false;
        }
        try {
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        if (this.mVisualizedAutoTrackActivities.size() == 0) {
            return true;
        }
        return this.mVisualizedAutoTrackActivities.contains(java.lang.Integer.valueOf(cls.hashCode()));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public boolean isVisualizedAutoTrackEnabled() {
        com.sensorsdata.analytics.android.sdk.SAConfigOptions sAConfigOptions = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions;
        return sAConfigOptions.mVisualizedEnabled || sAConfigOptions.mVisualizedPropertiesEnabled;
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void itemDelete(java.lang.String str, java.lang.String str2) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass38(str2, str));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void itemSet(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass37(str2, str, com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void login(java.lang.String str) {
        login(str, null);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void login(java.lang.String str, org.json.JSONObject jSONObject) {
        loginWithKey(com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey.LOGIN_ID_KEY_DEFAULT, str, jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void loginWithKey(java.lang.String str, java.lang.String str2) {
        loginWithKey(str, str2, null);
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void loginWithKey(java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject) {
        try {
            com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.LOGIN.isDid = true;
            com.sensorsdata.analytics.android.sdk.core.rpc.SensorsDataContentObserver.State.LOGOUT.isDid = false;
            synchronized (this.mLoginIdLock) {
                org.json.JSONObject cloneJsonObject = com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject);
                if (!com.sensorsdata.analytics.android.sdk.useridentity.LoginIDAndKey.isInValidLogin(str, str2, this.mSAContextManager.getUserIdentityAPI().getIdentitiesInstance().getLoginIDKey(), this.mSAContextManager.getUserIdentityAPI().getIdentitiesInstance().getLoginId(), getAnonymousId())) {
                    this.mSAContextManager.getUserIdentityAPI().updateLoginId(str, str2);
                }
                this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass5(str, str2, cloneJsonObject));
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void logout() {
        synchronized (this.mLoginIdLock) {
            this.mSAContextManager.getUserIdentityAPI().updateLoginId(null, null);
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass6());
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileAppend(java.lang.String str, java.lang.String str2) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass30(str2, str));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileAppend(java.lang.String str, java.util.Set<java.lang.String> set) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass31(set, str));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileDelete() {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass33());
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileIncrement(java.lang.String str, java.lang.Number number) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass29(str, number));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileIncrement(java.util.Map<java.lang.String, ? extends java.lang.Number> map) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass28(map));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profilePushId(java.lang.String str, java.lang.String str2) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass35(str, str2));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileSet(java.lang.String str, java.lang.Object obj) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass25(str, obj));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileSet(org.json.JSONObject jSONObject) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass24(com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileSetOnce(java.lang.String str, java.lang.Object obj) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass27(str, obj));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileSetOnce(org.json.JSONObject jSONObject) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass26(com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileUnset(java.lang.String str) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass32(str));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void profileUnsetPushId(java.lang.String str) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass36(str));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void registerDynamicSuperProperties(com.sensorsdata.analytics.android.sdk.SensorsDataDynamicSuperProperties sensorsDataDynamicSuperProperties) {
        this.mDynamicSuperPropertiesCallBack = sensorsDataDynamicSuperProperties;
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void registerLimitKeys(java.util.Map<java.lang.String, java.lang.String> map) {
        com.sensorsdata.analytics.android.sdk.core.business.SAPropertyManager.getInstance().registerLimitKeys(map);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void registerPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin) {
        if (sAPropertyPlugin != null) {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass18(sAPropertyPlugin));
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void registerSuperProperties(org.json.JSONObject jSONObject) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass21(com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ void removeEventListener(com.sensorsdata.analytics.android.sdk.listener.SAEventListener sAEventListener) {
        super.removeEventListener(sAEventListener);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.exposure.SAExposureAPIProtocol
    public void removeExposureView(android.view.View view) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.METHOD_REMOVE_EXPOSURE_VIEW, view);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.exposure.SAExposureAPIProtocol
    public void removeExposureView(android.view.View view, java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.METHOD_REMOVE_EXPOSURE_VIEW, view, str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ void removeFunctionListener(com.sensorsdata.analytics.android.sdk.listener.SAFunctionListener sAFunctionListener) {
        super.removeFunctionListener(sAFunctionListener);
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ void removeSAJSListener(com.sensorsdata.analytics.android.sdk.listener.SAJSListener sAJSListener) {
        super.removeSAJSListener(sAJSListener);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void removeTimer(java.lang.String str) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass12(str));
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void requestDeferredDeepLink(org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_REQUEST_DEFERRED_DEEPLINK, jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void resetAnonymousId() {
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass3());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void resetAnonymousIdentity(java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.TrackTaskManager trackTaskManager = this.mTrackTaskManager;
        if (trackTaskManager != null) {
            trackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass9(str));
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void resumeAutoTrackActivities(java.util.List<java.lang.Class<?>> list) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_RESUME_AUTOTRACK_ACTIVITIES, list);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void resumeAutoTrackActivity(java.lang.Class<?> cls) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_RESUME_AUTOTRACK_ACTIVITY, cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void resumeIgnoredAutoTrackFragment(java.lang.Class<?> cls) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_RESUME_IGNORED_AUTOTRACK_FRAGMENT, cls);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void resumeIgnoredAutoTrackFragments(java.util.List<java.lang.Class<?>> list) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_RESUME_IGNORED_AUTOTRACK_FRAGMENTS, list);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void resumeTrackScreenOrientation() {
        try {
            if (this.mSAContextManager.getOrientationDetector() != null) {
                this.mSAContextManager.getOrientationDetector().enable();
                this.mSAContextManager.getOrientationDetector().setState(true);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setCookie(java.lang.String str, boolean z) {
        try {
            if (z) {
                this.mInternalConfigs.cookie = java.net.URLEncoder.encode(str, "UTF-8");
            } else {
                this.mInternalConfigs.cookie = str;
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI
    public /* bridge */ /* synthetic */ void setDebugMode(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode debugMode) {
        super.setDebugMode(debugMode);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    @java.lang.Deprecated
    public void setDeepLinkCallback(com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeepLinkCallback sensorsDataDeepLinkCallback) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_SET_DEEPLINK_CALLBACK, sensorsDataDeepLinkCallback);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void setDeepLinkCompletion(com.sensorsdata.analytics.android.sdk.deeplink.SensorsDataDeferredDeepLinkCallback sensorsDataDeferredDeepLinkCallback) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_SET_DEEPLINK_COMPLETION, sensorsDataDeferredDeepLinkCallback);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.exposure.SAExposureAPIProtocol
    public void setExposureIdentifier(android.view.View view, java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.METHOD_SET_EXPOSURE_IDENTIFIER, view, str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setFlushBulkSize(int i) {
        if (i < 0) {
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "The value of flushBulkSize is invalid");
        }
        com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions.setFlushBulkSize(i);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setFlushInterval(int i) {
        com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions.setFlushInterval(i);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setFlushNetworkPolicy(int i) {
        com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions.setNetworkTypePolicy(i);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setGPSLocation(double d, double d2) {
        setGPSLocation(d, d2, null);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setGPSLocation(double d, double d2, java.lang.String str) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass1(d, d2, str));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setMaxCacheSize(long j) {
        com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions.setMaxCacheSize(j);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setServerUrl(java.lang.String str) {
        setServerUrl(str, false);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setServerUrl(java.lang.String str, boolean z) {
        if (z) {
            try {
                if (this.mSAContextManager.getRemoteManager() != null) {
                    try {
                        this.mSAContextManager.getRemoteManager().requestRemoteConfig(com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, false);
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                    }
                }
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                return;
            }
        }
        if (!android.text.TextUtils.equals(str, this.mOriginServerUrl)) {
            try {
                com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Visual.METHOD_REQUEST_VISUAL_CONFIG, new java.lang.Object[0]);
            } catch (java.lang.Exception e3) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
            }
        }
        this.mOriginServerUrl = str;
        if (android.text.TextUtils.isEmpty(str)) {
            this.mServerUrl = str;
            com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions.mServerUrl = str;
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "Server url is null or empty.");
            return;
        }
        android.net.Uri parse = android.net.Uri.parse(str);
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass34(parse, str));
        if (this.mInternalConfigs.debugMode != com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_OFF) {
            java.lang.String path = parse.getPath();
            if (android.text.TextUtils.isEmpty(path)) {
                return;
            }
            int lastIndexOf = path.lastIndexOf(47);
            if (lastIndexOf != -1) {
                this.mServerUrl = parse.buildUpon().path(path.substring(0, lastIndexOf) + "/debug").build().toString();
            }
        } else {
            this.mServerUrl = str;
        }
        com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.mSAConfigOptions.mServerUrl = this.mServerUrl;
        com.sensorsdata.analytics.android.sdk.monitor.TrackMonitor.getInstance().callSetServerUrl();
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setSessionIntervalTime(int i) {
        if (com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance() == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "The static method sharedInstance(context, serverURL, debugMode) should be called before calling sharedInstance()");
            return;
        }
        if (i < 10000 || i > 300000) {
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "SessionIntervalTime:" + i + " is invalid, session interval time is between 10s and 300s.");
            return;
        }
        com.sensorsdata.analytics.android.sdk.internal.beans.InternalConfigOptions internalConfigOptions = this.mInternalConfigs;
        if (i != internalConfigOptions.sessionTime) {
            internalConfigOptions.sessionTime = i;
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().commitSessionIntervalTime(i);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void setTrackEventCallBack(com.sensorsdata.analytics.android.sdk.SensorsDataTrackEventCallBack sensorsDataTrackEventCallBack) {
        this.mInternalConfigs.sensorsDataTrackEventCallBack = sensorsDataTrackEventCallBack;
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewActivity(android.view.View view, android.app.Activity activity) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_SET_VIEW_ACTIVITY, view, activity);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewFragmentName(android.view.View view, java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_SET_VIEW_FRAGMENT_NAME, view, str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewID(android.app.Dialog dialog, java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_SET_VIEW_ID, dialog, str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewID(android.view.View view, java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_SET_VIEW_ID, view, str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewID(java.lang.Object obj, java.lang.String str) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_SET_VIEW_ID, obj, str);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void setViewProperties(android.view.View view, org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_SET_VIEW_PROPERTIES, view, jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    @java.lang.Deprecated
    public void showUpWebView(android.webkit.WebView webView, org.json.JSONObject jSONObject, boolean z, boolean z2) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.WebView.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.WebView.METHOD_SHOWUP_WEBVIEW, webView, jSONObject, java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void showUpWebView(android.webkit.WebView webView, boolean z) {
        showUpWebView(webView, z, (org.json.JSONObject) null);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    @java.lang.Deprecated
    public void showUpWebView(android.webkit.WebView webView, boolean z, org.json.JSONObject jSONObject) {
        showUpWebView(webView, jSONObject, z, false);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void showUpWebView(android.webkit.WebView webView, boolean z, boolean z2) {
        showUpWebView(webView, null, z, z2);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void showUpX5WebView(java.lang.Object obj) {
        showUpX5WebView(obj, false);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    @java.lang.Deprecated
    public void showUpX5WebView(java.lang.Object obj, org.json.JSONObject jSONObject, boolean z, boolean z2) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.WebView.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.WebView.METHOD_SHOWUP_X5WEBVIEW, obj, jSONObject, java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void showUpX5WebView(java.lang.Object obj, boolean z) {
        showUpX5WebView(obj, null, true, z);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void startTrackThread() {
        com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread trackTaskManagerThread = this.mTrackTaskManagerThread;
        if (trackTaskManagerThread == null || trackTaskManagerThread.isStopped()) {
            this.mTrackTaskManagerThread = new com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread();
            new java.lang.Thread(this.mTrackTaskManagerThread).start();
            com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "Data collection thread has been started");
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void stopTrackScreenOrientation() {
        try {
            if (this.mSAContextManager.getOrientationDetector() != null) {
                this.mSAContextManager.getOrientationDetector().disable();
                this.mSAContextManager.getOrientationDetector().setState(false);
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void stopTrackThread() {
        com.sensorsdata.analytics.android.sdk.core.tasks.TrackTaskManagerThread trackTaskManagerThread = this.mTrackTaskManagerThread;
        if (trackTaskManagerThread == null || trackTaskManagerThread.isStopped()) {
            return;
        }
        this.mTrackTaskManagerThread.stop();
        com.sensorsdata.analytics.android.sdk.SALog.i("SA.SensorsDataAPI", "Data collection thread has been stopped");
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void track(java.lang.String str) {
        track(str, null);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void track(java.lang.String str, org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject cloneJsonObject = com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject);
            com.sensorsdata.analytics.android.sdk.util.JSONUtils.mergeDistinctProperty(com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(getDynamicProperty()), cloneJsonObject);
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass10(str, cloneJsonObject));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackAppInstall() {
        trackAppInstall(null, false);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackAppInstall(org.json.JSONObject jSONObject) {
        trackAppInstall(jSONObject, false);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackAppInstall(org.json.JSONObject jSONObject, boolean z) {
        trackInstallation("$AppInstall", jSONObject, z);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackChannelEvent(java.lang.String str) {
        trackChannelEvent(str, null);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackChannelEvent(java.lang.String str, org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_TRACK_CHANNEL_EVENT, str, jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackDeepLinkLaunch(java.lang.String str) {
        trackDeepLinkLaunch(str, null);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI, com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackDeepLinkLaunch(java.lang.String str, java.lang.String str2) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_TRACK_DEEPLINK_LAUNCH, str, str2);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.IFragmentAPI
    public void trackFragmentAppViewScreen() {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_TRACK_FRAGMENT_APPVIEWSCREEN, new java.lang.Object[0]);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackInstallation(java.lang.String str) {
        trackInstallation(str, null, false);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackInstallation(java.lang.String str, org.json.JSONObject jSONObject) {
        trackInstallation(str, jSONObject, false);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.advert.SAAdvertAPIProtocol
    public void trackInstallation(java.lang.String str, org.json.JSONObject jSONObject, boolean z) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Advert.METHOD_TRACK_INSTALLATION, str, jSONObject, java.lang.Boolean.valueOf(z));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    @java.lang.Deprecated
    public void trackTimer(java.lang.String str, java.util.concurrent.TimeUnit timeUnit) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass11(str, timeUnit, android.os.SystemClock.elapsedRealtime()));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void trackTimerEnd(java.lang.String str) {
        trackTimerEnd(str, null);
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void trackTimerEnd(java.lang.String str, org.json.JSONObject jSONObject) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass15(str, elapsedRealtime, com.sensorsdata.analytics.android.sdk.util.JSONUtils.cloneJsonObject(jSONObject)));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void trackTimerPause(java.lang.String str) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass13(str, android.os.SystemClock.elapsedRealtime()));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void trackTimerResume(java.lang.String str) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass14(str, android.os.SystemClock.elapsedRealtime()));
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public java.lang.String trackTimerStart(java.lang.String str) {
        try {
            java.lang.String format = java.lang.String.format("%s_%s_%s", str, java.util.UUID.randomUUID().toString().replace(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "_"), "SATimer");
            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
            trackTimer(format, timeUnit);
            trackTimer(str, timeUnit);
            return format;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return "";
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewAppClick(android.view.View view) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_TRACK_VIEW_APPCLICK, view);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewAppClick(android.view.View view, org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_TRACK_VIEW_APPCLICK, view, jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewScreen(android.app.Activity activity) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_TRACK_VIEW_SCREEN, activity);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    public void trackViewScreen(java.lang.Object obj) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_TRACK_VIEW_SCREEN, obj);
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.autotrack.AutoTrackProtocol
    @java.lang.Deprecated
    public void trackViewScreen(java.lang.String str, org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.AutoTrack.METHOD_TRACK_VIEW_SCREEN, str, jSONObject);
    }

    @Override // com.sensorsdata.analytics.android.sdk.useridentity.IUserIdentityAPI
    public void unbind(java.lang.String str, java.lang.String str2) {
        try {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass8(str, str2));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void unregisterPropertyPlugin(com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin sAPropertyPlugin) {
        if (sAPropertyPlugin != null) {
            this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass19(sAPropertyPlugin));
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.ISensorsDataAPI
    public void unregisterSuperProperty(java.lang.String str) {
        this.mTrackTaskManager.addTrackEventTask(new com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AnonymousClass22(str));
    }

    @Override // com.sensorsdata.analytics.android.sdk.core.mediator.exposure.SAExposureAPIProtocol
    public void updateExposureProperties(android.view.View view, org.json.JSONObject jSONObject) {
        com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Exposure.METHOD_UPDATE_EXPOSURE_PROPERTIES, view, jSONObject);
    }
}
