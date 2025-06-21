package com.bytedance.sdk.openadsdk.downloadnew.core;

/* loaded from: classes22.dex */
public interface BaseConstants {

    @java.lang.Deprecated
    public static final int ACTION_TYPE_BUTTON = 2;

    @java.lang.Deprecated
    public static final int ACTION_TYPE_ITEM = 1;
    public static final java.lang.String CATEGORY_UMENG = "umeng";
    public static final java.lang.String DOWNLOAD_DIR = "ByteDownload";
    public static final java.lang.String EVENT_LABEL_AD_EXTRA_DATA = "ad_extra_data";
    public static final java.lang.String EVENT_LABEL_EXTRA = "extra";
    public static final java.lang.String EVENT_LABEL_IS_AD_EVENT = "is_ad_event";
    public static final java.lang.String EVENT_LABEL_LOG_EXTRA = "log_extra";
    public static final int EVENT_SOURCE_SDK_INSIDE = 2;
    public static final int EVENT_SOURCE_USER = 1;
    public static final java.lang.String KLLK_PROMOTION_COLOROS_PKG_INFO = "com.coloros.browser";
    public static final java.lang.String KLLK_PROMOTION_HEYTAP_PKG_INFO = "com.heytap.browser";
    public static final java.lang.String KLLK_PROMOTION_NORMAL_PKG_INFO = "com.android.browser";
    public static final java.lang.String MARKET_PREFIX = "market://details?id=";
    public static final java.lang.String MARKET_PREFIX_SAMSUNG = "samsungapps://productDetail/";
    public static final java.lang.String MARKET_SCHEME_HW_HONOR = "hiapplink";
    public static final java.lang.String MARKET_SCHEME_SAMSUNG = "samsungapps";
    public static final java.lang.String SCHEME_HTTPS = "https";
    public static final java.lang.String SCHEME_MARKET = "market";
    public static final java.lang.String START_ONLY_FOR_ANDROID = "start_only_for_android";
    public static final java.lang.String VIVO_MARKET_NEED_COMMENT = "need_comment";
    public static final java.lang.String VIVO_V2_REQUIRED_MARKET_VERSION = "8.7.2.0";

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ActionType {
        public static final int BTN = 2;
        public static final int ITEM = 1;
    }

    public interface Time {
        public static final int DAY = 86400000;
        public static final int HOUR = 3600000;
        public static final int MINUTE = 60000;
        public static final int SECOND = 1000;
        public static final int WEEK = 604800000;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ToastScene {
        public static final int JUMP_MARKET_SUCCESS = 8;
        public static final int JUMP_OPPO_BROWSER_SUCCESS = 12;
        public static final int LP_APP_INFO_ERROR = 6;
        public static final int MONITOR_ERROR = 7;
        public static final int NETWORK_NOT_AVAILABLE = 5;
        public static final int NO_STORAGE_PERMISSION = 1;
        public static final int OPEN_APP_FAILED = 4;
        public static final int OPEN_WEB_NULL = 10;
        public static final int ORDER_DOWNLOAD_FAILED = 9;
        public static final int ORDER_DOWNLOAD_NOT_UNIFORM = 11;
        public static final int PACKAGE_NAME_ERROR = 3;
        public static final int START_DOWNLOAD = 2;
    }
}
