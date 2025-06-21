package com.sensorsdata.analytics.android.sdk.advert.utils;

/* loaded from: classes19.dex */
public class ChannelUtils {
    private static final java.lang.String SHARED_PREF_CORRECT_TRACK_INSTALLATION = "sensorsdata.correct.track.installation";
    private static final java.lang.String SHARED_PREF_UTM = "sensorsdata.utm";
    private static final java.lang.String UTM_CAMPAIGN_KEY = "SENSORS_ANALYTICS_UTM_CAMPAIGN";
    private static final java.lang.String UTM_CONTENT_KEY = "SENSORS_ANALYTICS_UTM_CONTENT";
    private static final java.lang.String UTM_MEDIUM_KEY = "SENSORS_ANALYTICS_UTM_MEDIUM";
    private static final java.lang.String UTM_SOURCE_KEY = "SENSORS_ANALYTICS_UTM_SOURCE";
    private static final java.lang.String UTM_TERM_KEY = "SENSORS_ANALYTICS_UTM_TERM";
    private static java.util.HashSet<java.lang.String> sChannelSourceKeySet = new java.util.HashSet<>();
    private static final java.util.HashMap<java.lang.String, java.lang.String> UTM_MAP = new com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.AnonymousClass1();
    private static final java.util.List<java.lang.String> mDeepLinkBlackList = new com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.AnonymousClass2();
    private static final java.util.HashMap<java.lang.String, java.lang.String> UTM_LINK_MAP = new com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.AnonymousClass3();
    private static final java.util.Map<java.lang.String, java.lang.String> LATEST_UTM_MAP = new com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.AnonymousClass4();
    private static java.util.Map<java.lang.String, java.lang.String> sUtmProperties = new java.util.HashMap();
    private static java.util.Map<java.lang.String, java.lang.String> sLatestUtmProperties = new java.util.HashMap();

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.util.HashMap<java.lang.String, java.lang.String> {
        public AnonymousClass1() {
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_SOURCE_KEY, "$utm_source");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_MEDIUM_KEY, "$utm_medium");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_TERM_KEY, "$utm_term");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_CONTENT_KEY, "$utm_content");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_CAMPAIGN_KEY, "$utm_campaign");
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils$2, reason: invalid class name */
    public static class AnonymousClass2 extends java.util.ArrayList {
        public AnonymousClass2() {
            add("io.dcloud.PandoraEntryActivity");
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils$3, reason: invalid class name */
    public static class AnonymousClass3 extends java.util.HashMap<java.lang.String, java.lang.String> {
        public AnonymousClass3() {
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_SOURCE_KEY, "utm_source");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_MEDIUM_KEY, "utm_medium");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_TERM_KEY, "utm_term");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_CONTENT_KEY, "utm_content");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_CAMPAIGN_KEY, "utm_campaign");
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils$4, reason: invalid class name */
    public static class AnonymousClass4 extends java.util.HashMap<java.lang.String, java.lang.String> {
        public AnonymousClass4() {
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_SOURCE_KEY, "$latest_utm_source");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_MEDIUM_KEY, "$latest_utm_medium");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_TERM_KEY, "$latest_utm_term");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_CONTENT_KEY, "$latest_utm_content");
            put(com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils.UTM_CAMPAIGN_KEY, "$latest_utm_campaign");
        }
    }

    public static boolean checkDeviceInfo(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String[] split = str.split("##");
        java.util.HashMap hashMap = new java.util.HashMap();
        if (split.length == 0) {
            return false;
        }
        for (java.lang.String str2 : split) {
            java.lang.String[] split2 = str2.trim().split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        if (hashMap.isEmpty()) {
            return false;
        }
        return (hashMap.containsKey("oaid") && android.text.TextUtils.equals((java.lang.CharSequence) hashMap.get("oaid"), com.sensorsdata.analytics.android.sdk.advert.oaid.SAOaidHelper.getOpenAdIdentifier(context))) || (hashMap.containsKey("android_id") && android.text.TextUtils.equals((java.lang.CharSequence) hashMap.get("android_id"), com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.getIdentifier(context)));
    }

    public static org.json.JSONObject checkOrSetChannelCallbackEvent(java.lang.String str, org.json.JSONObject jSONObject, android.content.Context context) {
        if (jSONObject == null) {
            jSONObject = new org.json.JSONObject();
        }
        try {
            jSONObject.put("$is_channel_callback_event", isFirstChannelEvent(str));
            if (context != null && !hasUtmProperties(jSONObject)) {
                mergeUtmByMetaData(context, jSONObject);
            }
            jSONObject.put("$channel_device_info", "1");
        } catch (org.json.JSONException e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
        return jSONObject;
    }

    public static void clearLocalUtm() {
        try {
            com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setString(SHARED_PREF_UTM, "");
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void clearMemoryUtm() {
        sUtmProperties.clear();
        sLatestUtmProperties.clear();
    }

    public static void clearUtm() {
        clearMemoryUtm();
        clearLocalUtm();
    }

    public static void commitRequestDeferredDeeplink(boolean z) {
        com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setBool(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REQUEST_DEFERRER_DEEPLINK, z);
    }

    private static java.lang.String getApplicationMetaData(android.content.Context context, java.lang.String str) {
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128);
            java.lang.String string = applicationInfo.metaData.getString(str);
            int i = string == null ? applicationInfo.metaData.getInt(str, -1) : -1;
            return i != -1 ? java.lang.String.valueOf(i) : string;
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String getDeviceInfo(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return java.lang.String.format("android_id=%s##imei=%s##imei_old=%s##imei_slot1=%s##imei_slot2=%s##imei_meid=%s##mac=%s##oaid=%s##oaid_reflection=%s", str, "", "", "", "", "", "", str2, str3);
    }

    public static org.json.JSONObject getLatestUtmProperties() {
        return sLatestUtmProperties.size() > 0 ? new org.json.JSONObject(sLatestUtmProperties) : new org.json.JSONObject();
    }

    public static org.json.JSONObject getUtmProperties() {
        return sUtmProperties.size() > 0 ? new org.json.JSONObject(sUtmProperties) : new org.json.JSONObject();
    }

    public static boolean hasLinkUtmProperties(java.util.Set<java.lang.String> set) {
        if (set != null && !set.isEmpty()) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : UTM_LINK_MAP.entrySet()) {
                if (entry != null && set.contains(entry.getValue())) {
                    return true;
                }
            }
            java.util.Iterator<java.lang.String> it = sChannelSourceKeySet.iterator();
            while (it.hasNext()) {
                java.lang.String next = it.next();
                if (!android.text.TextUtils.isEmpty(next) && sChannelSourceKeySet.contains(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasUtmByMetaData(android.content.Context context) {
        if (context == null) {
            return false;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : UTM_MAP.entrySet()) {
            if (entry != null && !android.text.TextUtils.isEmpty(getApplicationMetaData(context, entry.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasUtmProperties(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : UTM_MAP.entrySet()) {
            if (entry != null && jSONObject.has(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCorrectTrackInstallation() {
        try {
            return com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().getBool(SHARED_PREF_CORRECT_TRACK_INSTALLATION, false);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    public static boolean isDeepLinkBlackList(android.app.Activity activity) {
        if (activity == null) {
            return false;
        }
        java.util.Iterator<java.lang.String> it = mDeepLinkBlackList.iterator();
        while (it.hasNext()) {
            try {
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
            if (java.lang.Class.forName(it.next()).isAssignableFrom(activity.getClass())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExistRequestDeferredDeeplink() {
        return com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().isExists(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REQUEST_DEFERRER_DEEPLINK);
    }

    public static boolean isFirstChannelEvent(java.lang.String str) {
        java.lang.String str2 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getStorePlugins() == null || com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions().getStorePlugins().isEmpty() ? str : (java.lang.String) com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance().invokeModuleFunction(com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.MODULE_NAME, com.sensorsdata.analytics.android.sdk.core.mediator.Modules.Encrypt.METHOD_ENCRYPT_AES, str);
        boolean isFirstChannelEvent = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().isFirstChannelEvent(new java.lang.String[]{str2, str});
        if (isFirstChannelEvent) {
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance().addChannelEvent(str2);
        }
        return isFirstChannelEvent;
    }

    public static boolean isGetDeviceInfo(java.lang.String str, java.lang.String str2) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                if (android.text.TextUtils.isEmpty(str2)) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    public static boolean isRequestDeferredDeeplink() {
        return com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().getBool(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REQUEST_DEFERRER_DEEPLINK, true);
    }

    public static boolean isTrackInstallation() {
        try {
            return com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().isExists(SHARED_PREF_CORRECT_TRACK_INSTALLATION);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            return false;
        }
    }

    public static void loadUtmByLocal() {
        try {
            sLatestUtmProperties.clear();
            java.lang.String string = com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().getString(SHARED_PREF_UTM, "");
            if (android.text.TextUtils.isEmpty(string)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(string);
            java.util.Iterator<java.util.Map.Entry<java.lang.String, java.lang.String>> it = LATEST_UTM_MAP.entrySet().iterator();
            while (it.hasNext()) {
                java.lang.String value = it.next().getValue();
                if (jSONObject.has(value)) {
                    sLatestUtmProperties.put(value, jSONObject.optString(value));
                }
            }
            java.util.Iterator<java.lang.String> it2 = sChannelSourceKeySet.iterator();
            while (it2.hasNext()) {
                java.lang.String str = "_latest_" + it2.next();
                if (jSONObject.has(str)) {
                    sLatestUtmProperties.put(str, jSONObject.optString(str));
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void mergeUtmByMetaData(android.content.Context context, org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : UTM_MAP.entrySet()) {
            if (entry != null) {
                java.lang.String applicationMetaData = getApplicationMetaData(context, entry.getKey());
                if (!android.text.TextUtils.isEmpty(applicationMetaData)) {
                    jSONObject.put(entry.getValue(), applicationMetaData);
                }
            }
        }
    }

    public static void parseParams(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : UTM_LINK_MAP.entrySet()) {
            java.lang.String str = map.get(entry.getValue());
            if (!android.text.TextUtils.isEmpty(str)) {
                sUtmProperties.put(UTM_MAP.get(entry.getKey()), str);
                sLatestUtmProperties.put(LATEST_UTM_MAP.get(entry.getKey()), str);
            }
        }
        java.util.Iterator<java.lang.String> it = sChannelSourceKeySet.iterator();
        while (it.hasNext()) {
            java.lang.String next = it.next();
            try {
                if (com.sensorsdata.analytics.android.sdk.util.SADataHelper.assertPropertyKey(next)) {
                    java.lang.String str2 = map.get(next);
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        sUtmProperties.put(next, str2);
                        sLatestUtmProperties.put("_latest_" + next, str2);
                    }
                }
            } catch (java.lang.Exception e) {
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            }
        }
    }

    public static void removeDeepLinkInfo(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                if (next.startsWith("$latest") || next.startsWith("_latest")) {
                    keys.remove();
                }
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void saveCorrectTrackInstallation(boolean z) {
        try {
            com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setBool(SHARED_PREF_CORRECT_TRACK_INSTALLATION, z);
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void saveDeepLinkInfo() {
        try {
            if (sLatestUtmProperties.size() > 0) {
                com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager.getInstance().setString(SHARED_PREF_UTM, sLatestUtmProperties.toString());
            } else {
                clearLocalUtm();
            }
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }

    public static void setSourceChannelKeys(java.lang.String... strArr) {
        sChannelSourceKeySet.clear();
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        for (java.lang.String str : strArr) {
            if (!android.text.TextUtils.isEmpty(str)) {
                sChannelSourceKeySet.add(str);
            }
        }
    }
}
