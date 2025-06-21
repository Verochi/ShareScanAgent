package com.bytedance.sdk.openadsdk.api.plugin;

/* loaded from: classes22.dex */
final class t {
    private static final java.util.List<android.util.Pair<java.lang.String, org.json.JSONObject>> t = new java.util.concurrent.CopyOnWriteArrayList();
    static final java.util.Map<java.lang.String, java.lang.String> vw = new java.util.HashMap();
    private static android.content.SharedPreferences wg;

    /* renamed from: com.bytedance.sdk.openadsdk.api.plugin.t$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ org.json.JSONObject wg;

        public AnonymousClass1(java.lang.String str, org.json.JSONObject jSONObject) {
            this.vw = str;
            this.wg = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(com.bytedance.sdk.openadsdk.api.plugin.t.kz(this.vw, this.wg));
            com.bytedance.sdk.openadsdk.api.plugin.t.wg(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static org.json.JSONObject kz(java.lang.String str, org.json.JSONObject jSONObject) {
        java.lang.String str2 = "6.2.1.9";
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            jSONObject.put("os_api", android.os.Build.VERSION.SDK_INT);
            jSONObject.put("support_abi", java.util.Arrays.toString(android.os.Build.SUPPORTED_ABIS));
            jSONObject2.put("ad_sdk_version", "6.2.1.9");
            java.lang.String vw2 = com.bytedance.sdk.openadsdk.api.plugin.yl.vw("com.byted.pangle");
            if (!android.text.TextUtils.isEmpty(vw2)) {
                str2 = vw2;
            }
            jSONObject2.put(com.bytedance.sdk.openadsdk.api.plugin.PluginConstants.KEY_PLUGIN_VERSION, str2);
            jSONObject2.put("timestamp", java.lang.System.currentTimeMillis() / 1000);
            jSONObject2.put("is_plugin", true);
            java.util.Map<java.lang.String, java.lang.String> map = vw;
            jSONObject.put("appid", map.get("appid"));
            jSONObject2.put("event_extra", jSONObject.toString());
            jSONObject2.put("type", str);
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put("model", android.os.Build.MODEL);
            jSONObject3.put("vendor", android.os.Build.MANUFACTURER);
            jSONObject3.put("imei", map.get("imei"));
            jSONObject3.put("oaid", map.get("oaid"));
            jSONObject2.put("device_info", jSONObject3);
        } catch (org.json.JSONException unused) {
        }
        return jSONObject2;
    }

    private static void v(java.lang.String str, org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.TTAdManager adManager = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager();
        if (adManager == null) {
            yl(str, jSONObject);
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 1);
        bundle.putString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.KEY_CHANNEL_EVENT_NAME, str);
        bundle.putString("event_extra", jSONObject.toString());
        adManager.getExtra(android.os.Bundle.class, bundle);
    }

    public static void vw() {
        java.util.List<android.util.Pair<java.lang.String, org.json.JSONObject>> list = t;
        if (list.size() <= 0) {
            return;
        }
        try {
            for (android.util.Pair<java.lang.String, org.json.JSONObject> pair : list) {
                if (pair != null) {
                    v((java.lang.String) pair.first, (org.json.JSONObject) pair.second);
                }
            }
            t.clear();
        } catch (java.lang.Exception unused) {
        }
    }

    public static void vw(int i, java.lang.String str, long j) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("duration", java.lang.Long.valueOf(j));
            jSONObject.putOpt("code", java.lang.Integer.valueOf(i));
            jSONObject.putOpt("message", str);
            jSONObject.putOpt("load_record", com.bytedance.sdk.openadsdk.api.plugin.wg.vw());
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        yl("plugin_load_failed", jSONObject);
    }

    public static void vw(com.bytedance.sdk.openadsdk.AdConfig adConfig) {
        if (adConfig == null) {
            return;
        }
        java.util.Map<java.lang.String, java.lang.String> map = vw;
        map.put("appid", adConfig.getAppId());
        int pluginUpdateConfig = adConfig.getPluginUpdateConfig();
        map.put("plugin_update_conf", pluginUpdateConfig != 0 ? java.lang.String.valueOf(pluginUpdateConfig) : "2");
        com.bytedance.sdk.openadsdk.TTCustomController customController = adConfig.getCustomController();
        if (customController != null) {
            try {
                map.put("oaid", customController.getDevOaid());
                map.put("imei", customController.getDevImei());
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void vw(java.lang.String str, org.json.JSONObject jSONObject) {
        v("zeus_".concat(java.lang.String.valueOf(str)), jSONObject);
    }

    public static void wg(java.lang.String str, org.json.JSONObject jSONObject) {
        t.add(new android.util.Pair<>(str, jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wg(java.util.List<org.json.JSONObject> list) {
        if (list == null) {
            return;
        }
        if (wg == null) {
            wg = com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext().getSharedPreferences("tt_sdk_settings_other", 0);
        }
        java.lang.String format = java.lang.String.format("https://%s%s", wg.getString("url_stats", "api-access.pangolin-sdk-toutiao.com"), "/api/ad/union/sdk/stats/batch/");
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.util.List<android.util.Pair<java.lang.String, org.json.JSONObject>> list2 = t;
            if (list2.size() > 0) {
                for (android.util.Pair<java.lang.String, org.json.JSONObject> pair : list2) {
                    list.add(kz((java.lang.String) pair.first, (org.json.JSONObject) pair.second));
                }
                t.clear();
            }
            jSONObject.put("stats_list", new org.json.JSONArray((java.util.Collection) list));
        } catch (java.lang.Exception unused) {
        }
        com.bytedance.sdk.openadsdk.api.plugin.wg.t.vw().vw(true, format, com.bytedance.sdk.openadsdk.api.plugin.t.wg.vw(jSONObject).toString().getBytes());
    }

    private static void yl(java.lang.String str, org.json.JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.yl.vw.vw().wg(new com.bytedance.sdk.openadsdk.api.plugin.t.AnonymousClass1(str, jSONObject));
    }
}
