package com.efs.sdk.base.core.config.remote;

/* loaded from: classes22.dex */
public class RemoteConfig {
    public static final double FULL_RATE = 100.0d;
    java.lang.String a;
    public int mConfigVersion = -1;
    java.lang.String b = "https://";
    java.lang.String c = "errnewlog.umeng.com";
    long d = 480;
    private java.lang.Boolean e = null;
    public java.util.Map<java.lang.String, java.lang.Double> mUploadSampleRateMap = new java.util.HashMap();
    public java.util.Map<java.lang.String, java.lang.String> mSDKConfigMap = new java.util.HashMap();
    public java.util.Map<java.lang.String, java.lang.Object> mStrategyMap = new java.util.HashMap();

    private RemoteConfig() {
    }

    public static com.efs.sdk.base.core.config.remote.RemoteConfig a() {
        com.efs.sdk.base.core.config.remote.RemoteConfig remoteConfig = new com.efs.sdk.base.core.config.remote.RemoteConfig();
        if (com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isIntl()) {
            remoteConfig.c = "errnewlogos.umeng.com";
        } else {
            remoteConfig.c = "errnewlog.umeng.com";
        }
        return remoteConfig;
    }

    public final void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.a = str;
            java.lang.String str2 = new java.lang.String(com.efs.sdk.base.core.util.secure.a.a(com.efs.sdk.base.core.util.secure.EncodeUtil.base64Decode(str.getBytes()), com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().getSecret().getBytes()));
            java.lang.String[] split = str2.split("\\|");
            if (split.length <= 1) {
                return;
            }
            java.lang.String str3 = split[1];
            try {
                org.json.JSONArray jSONArray = new org.json.JSONArray(str2.substring(split[0].length() + split[1].length() + 2));
                this.mStrategyMap.put("rate", java.lang.Integer.valueOf(java.lang.Integer.parseInt(str3)));
                this.mStrategyMap.put("stra", jSONArray);
            } catch (org.json.JSONException e) {
                throw new java.lang.RuntimeException(e);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(@androidx.annotation.NonNull java.util.Map<java.lang.String, java.lang.String> map) {
        double d;
        if (map.containsKey("gate_way")) {
            java.lang.String str = map.get("gate_way");
            if (!android.text.TextUtils.isEmpty(str)) {
                this.c = str;
            }
        }
        if (map.containsKey("gate_way_https")) {
            java.lang.String str2 = map.get("gate_way_https");
            if (!android.text.TextUtils.isEmpty(str2)) {
                this.b = java.lang.Boolean.parseBoolean(str2) ? "https://" : "http://";
            }
        }
        try {
            if (map.containsKey("updateInteval")) {
                java.lang.String str3 = map.get("updateInteval");
                if (!android.text.TextUtils.isEmpty(str3)) {
                    this.d = java.lang.Long.parseLong(str3);
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            if (key.startsWith("data_sampling_rate_") || key.startsWith("file_sampling_rate_")) {
                java.lang.String replace = key.replace("data_sampling_rate_", "").replace("file_sampling_rate_", "");
                try {
                    d = java.lang.Double.parseDouble(entry.getValue());
                } catch (java.lang.Throwable unused) {
                    d = 100.0d;
                }
                hashMap.put(replace, java.lang.Double.valueOf(d));
            }
        }
        this.mUploadSampleRateMap = hashMap;
        this.mSDKConfigMap = map;
    }
}
