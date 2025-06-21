package com.sensorsdata.analytics.android.sdk.aop.push;

/* loaded from: classes19.dex */
public class PushAutoTrackHelper {
    private static final java.lang.String TAG = "SA.PushAutoTrackHelper";
    private static long lastPushClickTime;

    private static java.lang.String getSFData(java.lang.String str) {
        try {
            return new org.json.JSONObject(str).optString("sf_data");
        } catch (java.lang.Exception unused) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "get sf_data failed");
            return null;
        }
    }

    private static void hookIntent(android.content.Intent intent) {
        if (isTrackPushEnabled()) {
            try {
                com.sensorsdata.analytics.android.sdk.push.core.PushProcess.getInstance().hookIntent(intent);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "hookIntent");
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void hookIntentGetActivity(android.content.Context context, int i, android.content.Intent intent, int i2) {
        hookIntent(intent);
    }

    public static void hookIntentGetActivityBundle(android.content.Context context, int i, android.content.Intent intent, int i2, android.os.Bundle bundle) {
        hookIntent(intent);
    }

    public static void hookIntentGetBroadcast(android.content.Context context, int i, android.content.Intent intent, int i2) {
        hookIntent(intent);
    }

    public static void hookIntentGetForegroundService(android.content.Context context, int i, android.content.Intent intent, int i2) {
        hookIntent(intent);
    }

    public static void hookIntentGetService(android.content.Context context, int i, android.content.Intent intent, int i2) {
        hookIntent(intent);
    }

    private static void hookPendingIntent(android.content.Intent intent, android.app.PendingIntent pendingIntent) {
        if (isTrackPushEnabled()) {
            try {
                com.sensorsdata.analytics.android.sdk.push.core.PushProcess.getInstance().hookPendingIntent(intent, pendingIntent);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "hookPendingIntent");
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void hookPendingIntentGetActivity(android.app.PendingIntent pendingIntent, android.content.Context context, int i, android.content.Intent intent, int i2) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookPendingIntentGetActivityBundle(android.app.PendingIntent pendingIntent, android.content.Context context, int i, android.content.Intent intent, int i2, android.os.Bundle bundle) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookPendingIntentGetBroadcast(android.app.PendingIntent pendingIntent, android.content.Context context, int i, android.content.Intent intent, int i2) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookPendingIntentGetForegroundService(android.app.PendingIntent pendingIntent, android.content.Context context, int i, android.content.Intent intent, int i2) {
        hookPendingIntent(intent, pendingIntent);
    }

    public static void hookPendingIntentGetService(android.app.PendingIntent pendingIntent, android.content.Context context, int i, android.content.Intent intent, int i2) {
        hookPendingIntent(intent, pendingIntent);
    }

    private static boolean isRepeatEvent() {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "currentTime: " + elapsedRealtime + ",lastPushClickTime: " + lastPushClickTime);
        if (elapsedRealtime - lastPushClickTime <= 2000) {
            return true;
        }
        lastPushClickTime = elapsedRealtime;
        return false;
    }

    private static boolean isTrackPushEnabled() {
        try {
            if (!(com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance() instanceof com.sensorsdata.analytics.android.sdk.SensorsDataAPIEmptyImplementation) && com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions() != null && com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().isEnableTrackPush()) {
                return true;
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "SDK or push disabled.");
            return false;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    public static void onBroadcastReceiver(android.content.BroadcastReceiver broadcastReceiver, android.content.Context context, android.content.Intent intent) {
        onBroadcastServiceIntent(intent);
    }

    private static void onBroadcastServiceIntent(android.content.Intent intent) {
        if (isTrackPushEnabled()) {
            try {
                com.sensorsdata.analytics.android.sdk.push.core.PushProcess.getInstance().onNotificationClick(null, intent);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onBroadcastServiceIntent");
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void onGeTuiNotificationClicked(java.lang.Object obj) {
        if (obj == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "gtNotificationMessage is null");
            return;
        }
        if (isTrackPushEnabled()) {
            try {
                java.lang.String str = (java.lang.String) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(obj, "getMessageId", new java.lang.Object[0]);
                java.lang.String str2 = (java.lang.String) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(obj, "getTitle", new java.lang.Object[0]);
                java.lang.String str3 = (java.lang.String) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(obj, "getContent", new java.lang.Object[0]);
                if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
                    return;
                }
                com.sensorsdata.analytics.android.sdk.push.core.PushProcess.getInstance().trackGTClickDelayed(str, str2, str3);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void onGeTuiReceiveMessageData(java.lang.Object obj) {
        if (obj == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "gtNotificationMessage is null");
            return;
        }
        if (isTrackPushEnabled()) {
            try {
                byte[] bArr = (byte[]) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(obj, "getPayload", new java.lang.Object[0]);
                java.lang.String str = (java.lang.String) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(obj, "getMessageId", new java.lang.Object[0]);
                if (bArr == null || android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                com.sensorsdata.analytics.android.sdk.push.core.PushProcess.getInstance().trackReceiveMessageData(new java.lang.String(bArr), str);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void onNewIntent(java.lang.Object obj, android.content.Intent intent) {
        if (isTrackPushEnabled()) {
            try {
                if (obj instanceof android.app.Activity) {
                    com.sensorsdata.analytics.android.sdk.push.core.PushProcess.getInstance().onNotificationClick((android.app.Activity) obj, intent);
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onNewIntent");
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void onNotify(android.app.NotificationManager notificationManager, int i, android.app.Notification notification) {
        if (isTrackPushEnabled()) {
            try {
                onNotify(notificationManager, null, i, notification);
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void onNotify(android.app.NotificationManager notificationManager, java.lang.String str, int i, android.app.Notification notification) {
        if (isTrackPushEnabled()) {
            try {
                com.sensorsdata.analytics.android.sdk.push.core.PushProcess.getInstance().onNotify(str, i, notification);
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onNotify");
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void onServiceStart(android.app.Service service, android.content.Intent intent, int i) {
        onBroadcastServiceIntent(intent);
    }

    public static void onServiceStartCommand(android.app.Service service, android.content.Intent intent, int i, int i2) {
        onBroadcastServiceIntent(intent);
    }

    public static void onUMengActivityMessage(android.content.Intent intent) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject optJSONObject;
        if (intent == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "intent is null");
            return;
        }
        if (isTrackPushEnabled()) {
            try {
                java.lang.String stringExtra = intent.getStringExtra("body");
                if (android.text.TextUtils.isEmpty(stringExtra) || (optJSONObject = (jSONObject = new org.json.JSONObject(stringExtra)).optJSONObject("body")) == null) {
                    return;
                }
                java.lang.String optString = jSONObject.optString("extra");
                java.lang.String optString2 = optJSONObject.optString("title");
                java.lang.String optString3 = optJSONObject.optString("text");
                trackNotificationOpenedEvent(getSFData(optString), optString2, optString3, "UMeng", intent.getStringExtra("message_source"));
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("onUMengActivityMessage is called, title is %s, content is %s, extras is %s", optString2, optString3, optString));
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void onUMengNotificationClick(java.lang.Object obj) {
        if (obj == null) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "UMessage is null");
            return;
        }
        if (isTrackPushEnabled()) {
            try {
                org.json.JSONObject jSONObject = (org.json.JSONObject) com.sensorsdata.analytics.android.sdk.util.ReflectUtil.callMethod(obj, "getRaw", new java.lang.Object[0]);
                if (jSONObject == null) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "onUMengNotificationClick:raw is null");
                    return;
                }
                org.json.JSONObject optJSONObject = jSONObject.optJSONObject("body");
                if (optJSONObject != null) {
                    java.lang.String optString = jSONObject.optString("extra");
                    java.lang.String optString2 = optJSONObject.optString("title");
                    java.lang.String optString3 = optJSONObject.optString("text");
                    trackNotificationOpenedEvent(getSFData(optString), optString2, optString3, "UMeng", null);
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("onUMengNotificationClick is called, title is %s, content is %s, extras is %s", optString2, optString3, optString));
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void trackGeTuiNotificationClicked(java.lang.String str, java.lang.String str2, java.lang.String str3, long j) {
        trackNotificationOpenedEvent(str3, str, str2, "GeTui", null, j);
    }

    public static void trackJPushAppOpenNotification(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (isTrackPushEnabled()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("trackJPushAppOpenNotification is called, title is %s, content is %s, extras is %s, appPushChannel is %s, appPushServiceName is %s", str2, str3, str, str4, "JPush"));
            trackNotificationOpenedEvent(getSFData(str), str2, str3, "JPush", str4);
        }
    }

    public static void trackJPushOpenActivity(android.content.Intent intent) {
        if (intent != null && isTrackPushEnabled()) {
            org.json.JSONObject jSONObject = null;
            java.lang.String uri = intent.getData() != null ? intent.getData().toString() : null;
            if (android.text.TextUtils.isEmpty(uri) && intent.getExtras() != null) {
                uri = intent.getExtras().getString("JMessageExtra");
            }
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "trackJPushOpenActivity is called, Intent data is " + uri);
            try {
                if (android.text.TextUtils.isEmpty(uri)) {
                    return;
                }
                try {
                    jSONObject = new org.json.JSONObject(uri);
                } catch (java.lang.Exception unused) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Failed to construct JSON");
                }
                if (jSONObject != null) {
                    java.lang.String optString = jSONObject.optString("n_title");
                    java.lang.String optString2 = jSONObject.optString("n_content");
                    java.lang.String optString3 = jSONObject.optString("n_extras");
                    java.lang.String jPushSDKName = com.sensorsdata.analytics.android.sdk.push.utils.PushUtils.getJPushSDKName((byte) jSONObject.optInt("rom_type"));
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("trackJPushOpenActivity is called, title is %s, content is %s, extras is %s, appPushChannel is %s", optString, optString2, optString3, jPushSDKName));
                    if (!android.text.TextUtils.isEmpty(optString) && !android.text.TextUtils.isEmpty(optString2) && !android.text.TextUtils.isEmpty(jPushSDKName)) {
                        trackNotificationOpenedEvent(getSFData(optString3), optString, optString2, "JPush", jPushSDKName);
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void trackMeizuAppOpenNotification(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject optJSONObject;
        if (isTrackPushEnabled()) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("trackMeizuAppOpenNotification is called, title is %s, content is %s, extras is %s, appPushChannel is %s, appPushServiceName is %s", str2, str3, str, "Meizu", str4));
            try {
                try {
                    try {
                        jSONObject = new org.json.JSONObject(str);
                    } catch (java.lang.Exception e) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
                        return;
                    }
                } catch (java.lang.Exception unused) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Failed to construct JSON");
                    jSONObject = null;
                }
                if (jSONObject != null && jSONObject.has("JMessageExtra")) {
                    org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("JMessageExtra");
                    if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("m_content")) != null) {
                        str = optJSONObject.optString("n_extras");
                    }
                    str4 = "JPush";
                }
            } catch (java.lang.Exception e2) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
            }
            trackNotificationOpenedEvent(getSFData(str), str2, str3, str4, "Meizu");
        }
    }

    public static void trackNotificationOpenedEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        trackNotificationOpenedEvent(str, str2, str3, str4, str5, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void trackNotificationOpenedEvent(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, long j) {
        org.json.JSONObject jSONObject;
        try {
            if (isRepeatEvent()) {
                com.sensorsdata.analytics.android.sdk.SALog.i(TAG, java.lang.String.format("$AppPushClick Repeat trigger, title is %s, content is %s, extras is %s, appPushChannel is %s, appPushServiceName is %s", str2, str3, str, str5, str4));
                return;
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("$app_push_msg_title", str2);
            jSONObject2.put("$app_push_msg_content", str3);
            jSONObject2.put("$app_push_service_name", str4);
            if (!android.text.TextUtils.isEmpty(str5)) {
                jSONObject2.put("$app_push_channel", str5.toUpperCase());
            }
            try {
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "sfData is " + str);
                    jSONObject = new org.json.JSONObject(str);
                } catch (java.lang.Exception unused) {
                    com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "Failed to construct JSON");
                }
                if (jSONObject != null && jSONObject.has("sf_plan_id")) {
                    jSONObject2.put("$sf_msg_title", str2);
                    jSONObject2.put("$sf_msg_content", str3);
                    jSONObject2.put("$sf_msg_id", jSONObject.opt("sf_msg_id"));
                    jSONObject2.put("$sf_plan_id", jSONObject.opt("sf_plan_id"));
                    jSONObject2.put("$sf_audience_id", jSONObject.opt("sf_audience_id"));
                    jSONObject2.put("$sf_link_url", jSONObject.opt("sf_link_url"));
                    jSONObject2.put("$sf_plan_strategy_id", jSONObject.opt("sf_plan_strategy_id"));
                    jSONObject2.put("$sf_plan_type", jSONObject.opt("sf_plan_type"));
                    jSONObject2.put("$sf_strategy_unit_id", jSONObject.opt("sf_strategy_unit_id"));
                    jSONObject2.put("$sf_enter_plan_time", jSONObject.opt("sf_enter_plan_time"));
                    jSONObject2.put("$sf_channel_id", jSONObject.opt("sf_channel_id"));
                    jSONObject2.put("$sf_channel_category", jSONObject.opt("sf_channel_category"));
                    jSONObject2.put("$sf_channel_service_name", jSONObject.opt("sf_channel_service_name"));
                }
                if (j > 0) {
                    try {
                        jSONObject2.put("$time", new java.util.Date(j));
                    } catch (java.lang.Exception e2) {
                        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
                    }
                }
                com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().track("$AppPushClick", jSONObject2);
            }
            jSONObject = null;
            if (jSONObject != null) {
                jSONObject2.put("$sf_msg_title", str2);
                jSONObject2.put("$sf_msg_content", str3);
                jSONObject2.put("$sf_msg_id", jSONObject.opt("sf_msg_id"));
                jSONObject2.put("$sf_plan_id", jSONObject.opt("sf_plan_id"));
                jSONObject2.put("$sf_audience_id", jSONObject.opt("sf_audience_id"));
                jSONObject2.put("$sf_link_url", jSONObject.opt("sf_link_url"));
                jSONObject2.put("$sf_plan_strategy_id", jSONObject.opt("sf_plan_strategy_id"));
                jSONObject2.put("$sf_plan_type", jSONObject.opt("sf_plan_type"));
                jSONObject2.put("$sf_strategy_unit_id", jSONObject.opt("sf_strategy_unit_id"));
                jSONObject2.put("$sf_enter_plan_time", jSONObject.opt("sf_enter_plan_time"));
                jSONObject2.put("$sf_channel_id", jSONObject.opt("sf_channel_id"));
                jSONObject2.put("$sf_channel_category", jSONObject.opt("sf_channel_category"));
                jSONObject2.put("$sf_channel_service_name", jSONObject.opt("sf_channel_service_name"));
            }
            if (j > 0) {
            }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().track("$AppPushClick", jSONObject2);
        } catch (java.lang.Exception e3) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e3);
        }
    }
}
