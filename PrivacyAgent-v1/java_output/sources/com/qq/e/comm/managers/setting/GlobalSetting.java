package com.qq.e.comm.managers.setting;

/* loaded from: classes19.dex */
public final class GlobalSetting {
    public static final java.lang.String ADMOB_SDK_WRAPPER = "ADMOB";
    public static final java.lang.String AGREE_PRIVACY_KEY = "agree_privacy";
    public static final java.lang.String AGREE_READ_AAID = "allow_read_aaid";
    public static final java.lang.String APPLOVIN_SDK_WRAPPER = "APPLOVIN";
    public static final java.lang.String BD_SDK_WRAPPER = "BD";
    public static final java.lang.String CCPA = "ccpa";
    public static final java.lang.String CONV_OPTIMIZE_KEY = "conv_opt_info";
    public static final java.lang.String COPPA = "coppa";
    public static final java.lang.String CUSTOM_INFO_KEY = "custom_info";
    public static final java.lang.String DARK_MODE_KEY = "dark_mode_info";
    public static final java.lang.String FACEBOOK_SDK_WRAPPER = "FACEBOOK";
    public static final java.lang.String GDPR = "gdpr";
    public static final java.lang.String KS_SDK_WRAPPER = "KS";
    public static final java.lang.String NATIVE_EXPRESS_AD = "4";
    public static final java.lang.String NATIVE_UNIFIED_AD = "6";
    public static final java.lang.String OVERSEA_PRIVACY_INFO = "oversea_privacy_info";
    public static final java.lang.String PAG_SDK_WRAPPER = "PAG";
    public static final java.lang.String REWARD_VIDEO_AD = "5";
    public static final java.lang.String SPLASH_AD = "3";
    public static final java.lang.String TT_SDK_WRAPPER = "TT";
    public static final java.lang.String UNIFIED_BANNER_AD = "7";
    public static final java.lang.String UNIFIED_INTERSTITIAL_FS_AD = "9";
    public static final java.lang.String UNIFIED_INTERSTITIAL_HS_AD = "8";
    private static volatile java.lang.Integer a = null;
    private static volatile boolean b = false;
    private static volatile boolean c = true;
    private static volatile java.lang.Integer d;
    private static volatile java.lang.Boolean e;
    private static volatile java.lang.Boolean f;
    private static volatile java.lang.Boolean g;
    private static volatile java.util.Map<java.lang.String, java.lang.String> h = new java.util.HashMap();
    private static volatile java.util.Map<java.lang.String, java.lang.String> i = new java.util.HashMap();
    private static final java.util.Map<java.lang.String, java.lang.String> j = new java.util.HashMap();
    private static final org.json.JSONObject k = new org.json.JSONObject();
    private static volatile java.lang.String l = null;
    private static volatile java.lang.String m = null;
    private static volatile java.lang.String n = null;
    private static volatile java.lang.String o = null;
    private static volatile java.lang.String p = null;

    public static java.lang.Boolean getAgreeReadAndroidId() {
        return g;
    }

    public static java.lang.Boolean getAgreeReadDeviceId() {
        return f;
    }

    public static java.lang.Integer getChannel() {
        return a;
    }

    public static java.lang.String getCustomADActivityClassName() {
        return l;
    }

    public static java.lang.String getCustomLandscapeActivityClassName() {
        return o;
    }

    public static java.lang.String getCustomPortraitActivityClassName() {
        return m;
    }

    public static java.lang.String getCustomRewardvideoLandscapeActivityClassName() {
        return p;
    }

    public static java.lang.String getCustomRewardvideoPortraitActivityClassName() {
        return n;
    }

    public static java.util.Map<java.lang.String, java.lang.String> getExtraUserData() {
        return java.util.Collections.unmodifiableMap(h);
    }

    public static java.lang.Integer getPersonalizedState() {
        return d;
    }

    public static java.util.Map<java.lang.String, java.lang.String> getPreloadAdapterMaps() {
        return j;
    }

    public static org.json.JSONObject getSettings() {
        return k;
    }

    public static boolean isAgreePrivacyStrategy() {
        return e == null || e.booleanValue();
    }

    public static boolean isAgreeReadAndroidId() {
        if (g == null) {
            return true;
        }
        return g.booleanValue();
    }

    public static boolean isAgreeReadDeviceId() {
        if (f == null) {
            return true;
        }
        return f.booleanValue();
    }

    public static boolean isEnableMediationTool() {
        return b;
    }

    public static boolean isEnableVideoDownloadingCache() {
        return c;
    }

    public static void setAgreePrivacyStrategy(boolean z) {
        if (e == null) {
            e = java.lang.Boolean.valueOf(z);
        }
    }

    @java.lang.Deprecated
    public static void setAgreeReadAndroidId(boolean z) {
        g = java.lang.Boolean.valueOf(z);
    }

    @java.lang.Deprecated
    public static void setAgreeReadDeviceId(boolean z) {
        f = java.lang.Boolean.valueOf(z);
    }

    public static void setAgreeReadPrivacyInfo(java.util.Map<java.lang.String, java.lang.Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            k.putOpt(AGREE_PRIVACY_KEY, new org.json.JSONObject(map));
        } catch (java.lang.Exception e2) {
            com.qq.e.comm.util.GDTLogger.e("setAgreeReadPrivacyInfo错误：" + e2.toString());
        }
    }

    public static void setChannel(int i2) {
        if (a == null) {
            a = java.lang.Integer.valueOf(i2);
        }
    }

    public static void setConvOptimizeInfo(java.util.Map<java.lang.String, java.lang.Boolean> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        try {
            k.putOpt(CONV_OPTIMIZE_KEY, new org.json.JSONObject(map));
        } catch (java.lang.Exception e2) {
            com.qq.e.comm.util.GDTLogger.e("setConvOptimizeInfo错误：" + e2.toString());
        }
    }

    public static void setCustomADActivityClassName(java.lang.String str) {
        l = str;
    }

    public static void setCustomInfo(java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            k.putOpt(CUSTOM_INFO_KEY, new org.json.JSONObject(map));
        } catch (java.lang.Exception e2) {
            com.qq.e.comm.util.GDTLogger.e("setCustomInfo：" + e2);
        }
    }

    public static void setCustomLandscapeActivityClassName(java.lang.String str) {
        o = str;
    }

    public static void setCustomPortraitActivityClassName(java.lang.String str) {
        m = str;
    }

    public static void setCustomRewardvideoLandscapeActivityClassName(java.lang.String str) {
        p = str;
    }

    public static void setCustomRewardvideoPortraitActivityClassName(java.lang.String str) {
        n = str;
    }

    public static void setEnableCollectAppInstallStatus(boolean z) {
        try {
            k.putOpt("ecais", java.lang.Boolean.valueOf(z));
        } catch (org.json.JSONException unused) {
        }
    }

    public static void setEnableMediationTool(boolean z) {
        b = z;
    }

    public static void setEnableVideoDownloadingCache(boolean z) {
        c = z;
    }

    public static void setExtraUserData(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (android.text.TextUtils.isEmpty(entry.getKey()) || android.text.TextUtils.isEmpty(entry.getValue())) {
                com.qq.e.comm.util.GDTLogger.e("参数key和value不能为空！");
                return;
            }
        }
        h = map;
    }

    public static void setMediaExtData(java.util.Map<java.lang.String, java.lang.String> map, boolean z) {
        if (map == null) {
            return;
        }
        if (z) {
            i = new java.util.HashMap();
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (!android.text.TextUtils.isEmpty(entry.getKey()) && !android.text.TextUtils.isEmpty(entry.getValue())) {
                i.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            k.putOpt("media_ext", new org.json.JSONObject(i));
        } catch (org.json.JSONException unused) {
            com.qq.e.comm.util.GDTLogger.e("setMediaExtData失败，请检查");
        }
    }

    public static void setPersonalizedState(int i2) {
        d = java.lang.Integer.valueOf(i2);
    }

    public static void setPreloadAdapters(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return;
        }
        j.putAll(map);
    }
}
