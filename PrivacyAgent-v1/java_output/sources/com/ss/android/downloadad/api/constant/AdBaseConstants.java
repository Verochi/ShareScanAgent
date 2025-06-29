package com.ss.android.downloadad.api.constant;

/* loaded from: classes19.dex */
public interface AdBaseConstants extends com.ss.android.download.api.constant.BaseConstants {
    public static final long DEFAULT_DELAY_TIMESTAMP = 86400000;

    @java.lang.Deprecated
    public static final int DOWNLOAD_AFTER_JUMP = 1;

    @java.lang.Deprecated
    public static final int DOWNLOAD_IMMEDIATELY = 0;

    @java.lang.Deprecated
    public static final int DOWNLOAD_OPEN_MARKET_WITH_BUTTON_AND_ITEM_CLICK = 3;

    @java.lang.Deprecated
    public static final int DOWNLOAD_OPEN_MARKET_WITH_BUTTON_CLICK = 2;

    @java.lang.Deprecated
    public static final int DOWNLOAD_SCENE_DETAIL = 1;

    @java.lang.Deprecated
    public static final int DOWNLOAD_SCENE_NORMAL = 0;

    @java.lang.Deprecated
    public static final int ENABLE_DEEP_LINK_ONLY = 2;

    @java.lang.Deprecated
    public static final int ENABLE_NORMAL_AND_DEEP_LINK = 1;

    @java.lang.Deprecated
    public static final int ENABLE_NORMAL_LINK_ONLY = 0;
    public static final java.lang.String HTTP_DOMAIN_AD = "https://i.snssdk.com/";
    public static final java.lang.String HTTP_PATH_QUERY_SCHEME_LIST = "api/ad/v1/scheme/query/";
    public static final java.lang.String HTTP_PATH_REPORT_SCHEME_LIST = "api/ad/v1/scheme/report/";
    public static final java.lang.String MIME_APK = "application/vnd.android.package-archive";
    public static final int MIUI_DEEPLINK_PANGOLIN_CALLSCENE = 50;
    public static final int RECOMMEND_EVENT_EXTRA_VALUE = 3;
    public static final int STATUS_DOWNLOAD_FINISH = 2;
    public static final int STATUS_START_DOWNLOAD = 1;

    @java.lang.Deprecated
    public static final int TYPE_GAME = 2;

    @java.lang.Deprecated
    public static final int TYPE_RECOMMEND_DOWNLOAD_MODEL = 1;

    public @interface DownloadConfigureName {
        public static final java.lang.String PANGOLIN = "pangolin";
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DownloadMode {
        public static final int DOWNLOAD = 0;
        public static final int DOWNLOAD_AND_JUMP = 1;
        public static final int OPEN_MARKET_WITH_CLICK_ALL = 3;
        public static final int OPEN_MARKET_WITH_CLICK_BTN = 2;
        public static final int OPEN_WEB = 4;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DownloadScene {
        public static final int DETAIL = 1;
        public static final int NORMAL = 0;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DownloadStoreCode {
        public static final int MARKET_TYPE_HUAWEI = 3;
        public static final int MARKET_TYPE_OPPO = 1;
        public static final int MARKET_TYPE_VIVO = 2;
        public static final int MARKET_TYPE_XIAOMI = 4;
    }

    public @interface FunnelType {
        public static final int APP_LINK = 4;
        public static final int DOWNLOAD = 1;
        public static final int MARKET = 2;
        public static final int QUICK_APP = 3;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface LinkMode {
        public static final int ENABLE_AUTO_OPEN = 1;
        public static final int ENABLE_AUTO_OPEN2 = 2;
        public static final int NORMAL_AND_DEEP = 0;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface MiuiNewMarketResult {
        public static final int REAL_OPEN_MARKET_SUCCESS = 0;
        public static final int ROLL_BACK_DOWNLOAD = 1;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ModelType {
        public static final int AD = 0;
        public static final int BROWSER = 3;
        public static final int GAME = 2;
        public static final int RECOMMEND_AD = 1;
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface OpenAppScene {
        public static final int APP_LINK = 0;
        public static final int INSTALLER = 1;
        public static final int MARKET = 2;
        public static final int QUICK_APP = 3;
    }
}
