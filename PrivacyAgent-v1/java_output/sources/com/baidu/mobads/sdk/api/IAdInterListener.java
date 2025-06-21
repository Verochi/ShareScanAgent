package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface IAdInterListener {

    public interface AdClickActionInt {
        public static final int ACTION_TYPE_APO = 512;
        public static final int ACTION_TYPE_DL = 2;
        public static final int ACTION_TYPE_LP = 1;
    }

    public interface AdCommandType {
        public static final java.lang.String AD_CLICK = "onAdClick";
        public static final java.lang.String AD_IMPRESSION = "onAdImpression";
        public static final java.lang.String AD_SCHEMA = "bdsdk";
        public static final java.lang.String CHANGE_ACTIVITY = "onChangeActivity";
        public static final java.lang.String HANDLE_EVENT = "onHandleEvent";
        public static final java.lang.String NOVEL_EVENT = "onNovelEvent";
    }

    public interface AdCreativeType {
        public static final int AD_CREATIVE_IMAGE = 2;
        public static final int AD_CREATIVE_RICHMEDIA = 16;
        public static final int AD_CREATIVE_TEXT = 1;
        public static final int AD_CREATIVE_VIDEO = 8;
    }

    public interface AdProdType {
        public static final java.lang.String PRODUCT_BANNER = "banner";
        public static final java.lang.String PRODUCT_CONTENT = "content";
        public static final java.lang.String PRODUCT_CPU = "cpu";
        public static final java.lang.String PRODUCT_FEEDS = "feed";
        public static final java.lang.String PRODUCT_FULLSCREENVIDEO = "fvideo";
        public static final java.lang.String PRODUCT_INSITE = "insite";
        public static final java.lang.String PRODUCT_INTERSTITIAL = "int";
        public static final java.lang.String PRODUCT_JSSDK = "jssdk";
        public static final java.lang.String PRODUCT_PORTRAITVIDEO = "pvideo";
        public static final java.lang.String PRODUCT_PREROLL = "preroll";
        public static final java.lang.String PRODUCT_REWARDVIDEO = "rvideo";
        public static final java.lang.String PRODUCT_SONES = "sones";
        public static final java.lang.String PRODUCT_SPLASH = "rsplash";
        public static final java.lang.String PRODUCT_SUG = "sug";
        public static final java.lang.String PRODUCT_VIDEO = "video";
    }

    public interface AdReqParam {
        public static final java.lang.String AD_COUNT = "n";
        public static final java.lang.String AD_TIME_OUT = "timeout";
        public static final java.lang.String AD_TYPE = "at";
        public static final java.lang.String AP = "ap";
        public static final java.lang.String APID = "apid";
        public static final java.lang.String APPID = "appid";
        public static final java.lang.String FET = "fet";
        public static final java.lang.String HEIGHT = "h";
        public static final java.lang.String MIME_TYPE = "mimetype";
        public static final java.lang.String MPT = "mpt";
        public static final java.lang.String PROD = "prod";
        public static final java.lang.String WIDTH = "w";
    }

    void addEventListener(java.lang.String str, com.baidu.mobads.sdk.api.IOAdEventListener iOAdEventListener);

    void createProdHandler(org.json.JSONObject jSONObject);

    void destroyAd();

    android.view.View getAdContainerView();

    boolean isAdReady();

    void loadAd(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2);

    void onAdTaskProcess(android.view.View view, java.lang.String str);

    void onAdTaskProcess(java.lang.String str);

    void onAdTaskProcess(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map);

    void onAttachedToWindow();

    void onDetachedFromWindow();

    boolean onKeyDown(int i, android.view.KeyEvent keyEvent);

    void onWindowFocusChanged(boolean z);

    void onWindowVisibilityChanged(int i);

    void removeAllListeners();

    void setAdContainer(android.widget.RelativeLayout relativeLayout);

    void showAd();
}
