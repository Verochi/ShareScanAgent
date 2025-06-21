package com.alimm.tanx.core.request;

/* loaded from: classes.dex */
public class C extends com.alimm.tanx.core.ad.bean.BaseBean {
    private static final java.lang.String AD = "/japi";
    private static volatile java.lang.String BASE_CONFIG = "https://sdk-config.tanx.com";
    private static final java.lang.String BASE_DEBUG_CONFIG_URL = "https://pre-sdk-config.alibaba-inc.com";
    private static final java.lang.String BASE_DEBUG_CONFIG_URL_HTTP = "http://pre-sdk-config.alibaba-inc.com";
    private static final java.lang.String BASE_DEBUG_QUERY_HISTORY_REWARD_URL = "https://videoproxy.tanx.com";
    private static final java.lang.String BASE_DEBUG_QUERY_HISTORY_REWARD_URL_HTTP = "http://videoproxy.tanx.com";
    private static final java.lang.String BASE_DEBUG_URL = "https://videoproxy.tanx.com";
    private static final java.lang.String BASE_DEBUG_URL_HTTP = "http://videoproxy.tanx.com";
    private static volatile java.lang.String BASE_ORANGE_URL = "https://et.tanx.com";
    private static final java.lang.String BASE_RELEASE_CONFIG_URL = "https://sdk-config.tanx.com";
    private static final java.lang.String BASE_RELEASE_CONFIG_URL_HTTP = "http://sdk-config.tanx.com";
    private static final java.lang.String BASE_RELEASE_QUERY_HISTORY_REWARD_URL = " https://task.tanx.com";
    private static final java.lang.String BASE_RELEASE_QUERY_HISTORY_REWARD_URL_HTTP = " http://task.tanx.com";
    private static final java.lang.String BASE_RELEASE_URL = "https://opehs.tanx.com";
    private static final java.lang.String BASE_RELEASE_URL_HTTP = "http://opehs.tanx.com";
    private static final java.lang.String BASE_RELEASE_UT_URL = "https://et.tanx.com";
    private static final java.lang.String BASE_RELEASE_UT_URL_HTTP = "http://et.tanx.com";
    private static volatile java.lang.String BASE_REWARD = " https://task.tanx.com";
    private static volatile java.lang.String BASE_URL = "https://opehs.tanx.com";
    private static volatile java.lang.String BASE_UT_URL = "https://et.tanx.com";
    private static final java.lang.String CONFIG = "/requestConfigV2";
    private static final java.lang.String REWARD = "/task_reward";
    private static final java.lang.String REWARD_DEBUG_TEMP = "/tanx_task";
    private static final java.lang.String UT = "/tsbpm";

    public static java.lang.String getAdUrl() {
        return BASE_URL + AD + "?id=" + com.alimm.tanx.core.utils.MD5Utils.getMD5String(com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey());
    }

    public static java.lang.String getConfigUrl() {
        return BASE_CONFIG + CONFIG;
    }

    public static java.lang.String getOrangeUrl() {
        return BASE_ORANGE_URL + "/tsc?os=android";
    }

    public static java.lang.String getRewardUrl() {
        return BASE_REWARD + REWARD + "?id=" + com.alimm.tanx.core.utils.MD5Utils.getMD5String(com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey());
    }

    public static java.lang.String getUtUrl() {
        return BASE_UT_URL + UT + "?id=" + com.alimm.tanx.core.utils.MD5Utils.getMD5String(com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey());
    }

    public static void setDebug() {
        BASE_URL = "https://videoproxy.tanx.com";
        BASE_UT_URL = "https://videoproxy.tanx.com";
        BASE_ORANGE_URL = "https://videoproxy.tanx.com";
        BASE_REWARD = "https://videoproxy.tanx.com/tanx_task";
        BASE_CONFIG = BASE_DEBUG_CONFIG_URL;
    }

    public static void setDebugHttp() {
        BASE_URL = "http://videoproxy.tanx.com";
        BASE_UT_URL = "http://videoproxy.tanx.com";
        BASE_ORANGE_URL = "http://videoproxy.tanx.com";
        BASE_REWARD = "http://videoproxy.tanx.com/tanx_task";
        BASE_CONFIG = BASE_DEBUG_CONFIG_URL_HTTP;
    }

    public static void setRelease() {
        BASE_URL = BASE_RELEASE_URL;
        BASE_UT_URL = BASE_RELEASE_UT_URL;
        BASE_ORANGE_URL = BASE_RELEASE_UT_URL;
        BASE_REWARD = BASE_RELEASE_QUERY_HISTORY_REWARD_URL;
        BASE_CONFIG = BASE_RELEASE_CONFIG_URL;
    }

    public static void setReleaseHttp() {
        java.lang.Boolean bool;
        try {
            bool = java.lang.Boolean.valueOf(com.alimm.tanx.core.TanxCoreSdk.getConfig().isDebugMode());
        } catch (java.lang.Exception unused) {
            bool = null;
        }
        if (bool == null || bool.booleanValue()) {
            BASE_URL = BASE_RELEASE_URL_HTTP;
            BASE_UT_URL = BASE_RELEASE_UT_URL_HTTP;
            BASE_ORANGE_URL = BASE_RELEASE_UT_URL_HTTP;
            BASE_REWARD = BASE_RELEASE_QUERY_HISTORY_REWARD_URL_HTTP;
            BASE_CONFIG = BASE_RELEASE_CONFIG_URL_HTTP;
        }
    }
}
