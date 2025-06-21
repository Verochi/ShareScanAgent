package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ao {
    private static org.json.JSONObject a;

    public static org.json.JSONObject a(android.content.Context context, int i, org.json.JSONArray jSONArray, java.lang.String str) {
        org.json.JSONObject jSONObject = null;
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                java.lang.String zid = com.umeng.commonsdk.utils.UMUtils.getZid(context);
                if (android.text.TextUtils.isEmpty(zid)) {
                    return jSONObject2;
                }
                jSONObject2.put("atoken", zid);
                java.lang.String deviceToken = com.umeng.commonsdk.utils.UMUtils.getDeviceToken(context);
                if (!android.text.TextUtils.isEmpty(deviceToken)) {
                    jSONObject2.put(com.huawei.hms.push.constant.RemoteMessageConst.DEVICE_TOKEN, deviceToken);
                }
                jSONObject2.put("model", android.os.Build.MODEL);
                jSONObject2.put("os", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
                jSONObject2.put("os_version", android.os.Build.VERSION.RELEASE);
                jSONObject2.put(com.umeng.ccg.a.r, str);
                jSONObject2.put("sdk", jSONArray);
                jSONObject2.put("e", i);
                return jSONObject2;
            } catch (java.lang.Throwable unused) {
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public static org.json.JSONObject a(android.content.Context context, java.lang.String str) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2 = null;
        try {
            com.umeng.analytics.pro.an anVar = new com.umeng.analytics.pro.an();
            java.lang.String uMId = com.umeng.commonsdk.utils.UMUtils.getUMId(context);
            if (android.text.TextUtils.isEmpty(uMId)) {
                return null;
            }
            anVar.a(uMId);
            java.lang.String appkey = com.umeng.commonsdk.utils.UMUtils.getAppkey(context);
            if (android.text.TextUtils.isEmpty(appkey)) {
                return null;
            }
            anVar.b(appkey);
            anVar.c(com.umeng.commonsdk.utils.UMUtils.getAppVersionName(context));
            anVar.d("9.7.5");
            anVar.e(com.umeng.commonsdk.utils.UMUtils.getChannel(context));
            anVar.f(android.os.Build.VERSION.SDK_INT + "");
            anVar.g(android.os.Build.BRAND);
            anVar.h(android.os.Build.MODEL);
            java.lang.String[] localeInfo = com.umeng.commonsdk.statistics.common.DeviceConfig.getLocaleInfo(context);
            anVar.i(localeInfo[1]);
            anVar.j(localeInfo[0]);
            int[] resolutionArray = com.umeng.commonsdk.statistics.common.DeviceConfig.getResolutionArray(context);
            anVar.b(java.lang.Integer.valueOf(resolutionArray[1]));
            anVar.a(java.lang.Integer.valueOf(resolutionArray[0]));
            anVar.k(com.umeng.analytics.pro.as.a(context, "install_datetime", ""));
            try {
                jSONObject = new org.json.JSONObject();
            } catch (org.json.JSONException e) {
                e = e;
            }
            try {
                jSONObject.put(com.umeng.analytics.pro.an.a, anVar.a());
                jSONObject.put(com.umeng.analytics.pro.an.c, anVar.c());
                jSONObject.put(com.umeng.analytics.pro.an.b, anVar.b());
                jSONObject.put(com.umeng.analytics.pro.an.d, anVar.d());
                jSONObject.put(com.umeng.analytics.pro.an.e, anVar.e());
                jSONObject.put(com.umeng.analytics.pro.an.f, anVar.f());
                jSONObject.put(com.umeng.analytics.pro.an.g, anVar.g());
                jSONObject.put(com.umeng.analytics.pro.an.h, anVar.h());
                jSONObject.put(com.umeng.analytics.pro.an.k, anVar.k());
                jSONObject.put(com.umeng.analytics.pro.an.j, anVar.j());
                jSONObject.put(com.umeng.analytics.pro.an.l, anVar.l());
                jSONObject.put(com.umeng.analytics.pro.an.i, anVar.i());
                jSONObject.put(com.umeng.analytics.pro.an.m, anVar.m());
                jSONObject.put(com.umeng.analytics.pro.bo.al, com.umeng.commonsdk.utils.UMUtils.getZid(context));
                jSONObject.put("platform", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
                jSONObject.put("optional", new org.json.JSONObject(com.umeng.analytics.pro.as.a()));
                java.lang.String[] split = str.split("@");
                if (split.length == 4) {
                    try {
                        long parseLong = java.lang.Long.parseLong(split[0]);
                        java.lang.String str2 = split[1];
                        jSONObject.put(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_1, parseLong);
                        jSONObject.put(com.umeng.umcrash.custommapping.UAPMCustomMapping.STRING_PARAM_2, str2);
                    } catch (java.lang.Throwable unused) {
                    }
                }
                try {
                    java.lang.String str3 = android.os.Build.BRAND;
                    java.lang.String a2 = com.umeng.analytics.pro.at.a(str3);
                    java.lang.String b = com.umeng.analytics.pro.at.b(str3);
                    if (android.text.TextUtils.isEmpty(a2) || android.text.TextUtils.isEmpty(b)) {
                        jSONObject.put(com.umeng.analytics.pro.an.n, "Android");
                        jSONObject.put(com.umeng.analytics.pro.an.o, android.os.Build.VERSION.RELEASE);
                    } else {
                        jSONObject.put(com.umeng.analytics.pro.an.n, a2);
                        jSONObject.put(com.umeng.analytics.pro.an.o, b);
                    }
                } catch (java.lang.Throwable unused2) {
                }
                return jSONObject;
            } catch (org.json.JSONException e2) {
                e = e2;
                jSONObject2 = jSONObject;
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + e.getMessage());
                return jSONObject2;
            } catch (java.lang.Throwable th) {
                th = th;
                jSONObject2 = jSONObject;
                com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "[getCloudConfigParam] error " + th.getMessage());
                return jSONObject2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static org.json.JSONObject a(android.content.Context context, org.json.JSONArray jSONArray, java.lang.String str) {
        org.json.JSONObject jSONObject = a;
        if (jSONObject != null && jSONObject.length() > 0) {
            return a;
        }
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("os", "Android");
            jSONObject2.put("dm", android.os.Build.MODEL);
            jSONObject2.put("av", com.umeng.commonsdk.statistics.common.DeviceConfig.getAppVersionName(context));
            jSONObject2.put(com.umeng.analytics.pro.bo.g, com.umeng.commonsdk.utils.UMUtils.getUMId(context));
            jSONObject2.put("ov", android.os.Build.VERSION.RELEASE);
            jSONObject2.put("chn", com.umeng.commonsdk.utils.UMUtils.getChannel(context));
            jSONObject2.put(com.umeng.analytics.pro.bo.al, com.umeng.commonsdk.utils.UMUtils.getZid(context));
            jSONObject2.put("sv", "9.7.5");
            jSONObject2.put("ak", com.umeng.commonsdk.utils.UMUtils.getAppkey(context));
            java.lang.String idfa = com.umeng.commonsdk.statistics.common.DeviceConfig.getIdfa(context);
            if (!android.text.TextUtils.isEmpty(idfa)) {
                jSONObject2.put("tk_idfa", idfa);
            }
            jSONObject2.put("db", android.os.Build.BRAND);
            jSONObject2.put("tk_aid", com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(context));
            java.lang.String oaid = com.umeng.commonsdk.statistics.common.DeviceConfig.getOaid(context);
            if (!android.text.TextUtils.isEmpty(oaid)) {
                jSONObject2.put("tk_oaid", oaid);
            }
            java.lang.String imeiNew = com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(context);
            if (!android.text.TextUtils.isEmpty(imeiNew)) {
                jSONObject2.put("tk_imei", imeiNew);
            }
            jSONObject2.put("boa", android.os.Build.BOARD);
            jSONObject2.put("mant", android.os.Build.TIME);
            java.lang.String[] localeInfo = com.umeng.commonsdk.statistics.common.DeviceConfig.getLocaleInfo(context);
            jSONObject2.put(com.anythink.expressad.d.a.b.dx, localeInfo[0]);
            jSONObject2.put("lang", localeInfo[1]);
            jSONObject2.put(com.anythink.expressad.foundation.g.a.V, com.umeng.commonsdk.statistics.common.DeviceConfig.getTimeZone(context));
            jSONObject2.put("pkg", com.umeng.commonsdk.statistics.common.DeviceConfig.getPackageName(context));
            jSONObject2.put("disn", com.umeng.commonsdk.statistics.common.DeviceConfig.getAppName(context));
            java.lang.String[] networkAccessMode = com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(context);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                jSONObject2.put(com.anythink.expressad.d.a.b.da, com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                jSONObject2.put(com.anythink.expressad.d.a.b.da, "2G/3G");
            } else {
                jSONObject2.put(com.anythink.expressad.d.a.b.da, "unknown");
            }
            if (!"".equals(networkAccessMode[1])) {
                jSONObject2.put("ast", networkAccessMode[1]);
            }
            jSONObject2.put("nt", com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkType(context));
            java.lang.String deviceToken = com.umeng.commonsdk.utils.UMUtils.getDeviceToken(context);
            if (!android.text.TextUtils.isEmpty(deviceToken)) {
                jSONObject2.put(com.umeng.analytics.pro.bo.a, deviceToken);
            }
            int[] resolutionArray = com.umeng.commonsdk.statistics.common.DeviceConfig.getResolutionArray(context);
            if (resolutionArray != null) {
                jSONObject2.put("rl", resolutionArray[1] + "*" + resolutionArray[0]);
            }
            jSONObject2.put("car", com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkOperatorName(context));
            jSONObject2.put(com.umeng.analytics.pro.bo.b, "9.7.5");
            if (com.umeng.commonsdk.statistics.common.DeviceConfig.isHarmony(context)) {
                jSONObject2.put("oos", "harmony");
            } else {
                jSONObject2.put("oos", "Android");
            }
            jSONObject2.put(com.umeng.ccg.a.r, str);
            jSONObject2.put("sdk", jSONArray);
            a = jSONObject2;
        } catch (java.lang.Throwable unused) {
        }
        return a;
    }

    public static org.json.JSONObject a(android.content.Context context, org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObject2 = null;
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            jSONArray.put(jSONObject);
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            try {
                jSONObject3.put("ekv", jSONArray);
                return jSONObject3;
            } catch (java.lang.Throwable unused) {
                jSONObject2 = jSONObject3;
                return jSONObject2;
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    public static org.json.JSONObject a(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        try {
            jSONObject3.put("header", jSONObject);
            jSONObject3.put("analytics", jSONObject2);
        } catch (java.lang.Throwable unused) {
        }
        return jSONObject3;
    }
}
