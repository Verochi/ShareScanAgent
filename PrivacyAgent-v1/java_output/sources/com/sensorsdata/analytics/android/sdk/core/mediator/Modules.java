package com.sensorsdata.analytics.android.sdk.core.mediator;

/* loaded from: classes19.dex */
public interface Modules {

    public interface Advert {
        public static final java.lang.String METHOD_COMMIT_REQUEST_DEFERRED_DEEPLINK = "commitRequestDeferredDeeplink";
        public static final java.lang.String METHOD_ENABLE_DEEPLINK_INSTALL_SOURCE = "enableDeepLinkInstallSource";
        public static final java.lang.String METHOD_GET_LATEST_UTM_PROPERTIES = "getLatestUtmProperties";
        public static final java.lang.String METHOD_HANDLER_SCAN_URI = "handlerScanUri";
        public static final java.lang.String METHOD_MERGE_CHANNEL_EVENT_PROPERTIES = "mergeChannelEventProperties";
        public static final java.lang.String METHOD_REMOVE_DEEPLINK_INFO = "removeDeepLinkInfo";
        public static final java.lang.String METHOD_REQUEST_DEFERRED_DEEPLINK = "requestDeferredDeepLink";
        public static final java.lang.String METHOD_SEND_EVENT_SAT = "sendEvent";
        public static final java.lang.String METHOD_SET_DEEPLINK_CALLBACK = "setDeepLinkCallback";
        public static final java.lang.String METHOD_SET_DEEPLINK_COMPLETION = "setDeepLinkCompletion";
        public static final java.lang.String METHOD_TRACK_CHANNEL_EVENT = "trackChannelEvent";
        public static final java.lang.String METHOD_TRACK_DEEPLINK_LAUNCH = "trackDeepLinkLaunch";
        public static final java.lang.String METHOD_TRACK_INSTALLATION = "trackInstallation";
        public static final java.lang.String MODULE_NAME = "sensors_analytics_module_advertisement";
    }

    public interface AutoTrack {
        public static final java.lang.String METHOD_CLEAR_LAST_SCREENURL = "clearLastScreenUrl";
        public static final java.lang.String METHOD_CLEAR_REFERRER_WHEN_APPEND = "clearReferrerWhenAppEnd";
        public static final java.lang.String METHOD_DISABLE_AUTO_TRACK = "disableAutoTrack";
        public static final java.lang.String METHOD_ENABLE_AUTOTRACK_FRAGMENT = "enableAutoTrackFragment";
        public static final java.lang.String METHOD_ENABLE_AUTOTRACK_FRAGMENTS = "enableAutoTrackFragments";
        public static final java.lang.String METHOD_ENABLE_AUTO_TRACK = "enableAutoTrack";
        public static final java.lang.String METHOD_GET_IGNORED_VIEW_TYPE_LIST = "getIgnoredViewTypeList";
        public static final java.lang.String METHOD_GET_LAST_SCREENURL = "getLastScreenUrl";
        public static final java.lang.String METHOD_GET_LAST_SCREEN_TRACK_PROPERTIES = "getLastScreenTrackProperties";
        public static final java.lang.String METHOD_GET_REFERRER_SCREEN_TITLE = "getReferrerScreenTitle";
        public static final java.lang.String METHOD_IGNORE_AUTOTRACK_ACTIVITIES = "ignoreAutoTrackActivities";
        public static final java.lang.String METHOD_IGNORE_AUTOTRACK_ACTIVITY = "ignoreAutoTrackActivity";
        public static final java.lang.String METHOD_IGNORE_AUTOTRACK_FRAGMENT = "ignoreAutoTrackFragment";
        public static final java.lang.String METHOD_IGNORE_AUTOTRACK_FRAGMENTS = "ignoreAutoTrackFragments";
        public static final java.lang.String METHOD_IGNORE_VIEW = "ignoreView";
        public static final java.lang.String METHOD_IGNORE_VIEW_TYPE = "ignoreViewType";
        public static final java.lang.String METHOD_IS_ACTIVITY_AUTOTRACK_APPCLICK_IGNORED = "isActivityAutoTrackAppClickIgnored";
        public static final java.lang.String METHOD_IS_ACTIVITY_AUTOTRACK_APPVIEWSCREEN_IGNORED = "isActivityAutoTrackAppViewScreenIgnored";
        public static final java.lang.String METHOD_IS_AUTOTRACK_ENABLED = "isAutoTrackEnabled";
        public static final java.lang.String METHOD_IS_AUTOTRACK_EVENT_TYPE_IGNORED = "isAutoTrackEventTypeIgnored";
        public static final java.lang.String METHOD_IS_FRAGMENT_AUTOTRACK_APPVIEWSCREEN = "isFragmentAutoTrackAppViewScreen";
        public static final java.lang.String METHOD_IS_TRACK_FRAGMENT_APPVIEWSCREEN_ENABLED = "isTrackFragmentAppViewScreenEnabled";
        public static final java.lang.String METHOD_RESUME_AUTOTRACK_ACTIVITIES = "resumeAutoTrackActivities";
        public static final java.lang.String METHOD_RESUME_AUTOTRACK_ACTIVITY = "resumeAutoTrackActivity";
        public static final java.lang.String METHOD_RESUME_IGNORED_AUTOTRACK_FRAGMENT = "resumeIgnoredAutoTrackFragment";
        public static final java.lang.String METHOD_RESUME_IGNORED_AUTOTRACK_FRAGMENTS = "resumeIgnoredAutoTrackFragments";
        public static final java.lang.String METHOD_SET_VIEW_ACTIVITY = "setViewActivity";
        public static final java.lang.String METHOD_SET_VIEW_FRAGMENT_NAME = "setViewFragmentName";
        public static final java.lang.String METHOD_SET_VIEW_ID = "setViewID";
        public static final java.lang.String METHOD_SET_VIEW_PROPERTIES = "setViewProperties";
        public static final java.lang.String METHOD_TRACK_FRAGMENT_APPVIEWSCREEN = "trackFragmentAppViewScreen";
        public static final java.lang.String METHOD_TRACK_VIEW_APPCLICK = "trackViewAppClick";
        public static final java.lang.String METHOD_TRACK_VIEW_SCREEN = "trackViewScreen";
        public static final java.lang.String MODULE_NAME = "sensors_analytics_module_autotrack";
    }

    public interface Encrypt {
        public static final java.lang.String METHOD_DECRYPT_AES = "decryptAES";
        public static final java.lang.String METHOD_ENCRYPT_AES = "encryptAES";
        public static final java.lang.String METHOD_ENCRYPT_EVENT_DATA = "encryptEventData";
        public static final java.lang.String METHOD_ENCRYPT_EVENT_DATA_WITH_KEY = "encryptEventDataWithKey";
        public static final java.lang.String METHOD_LOAD_EVENT = "loadEvent";
        public static final java.lang.String METHOD_LOAD_SECRET_KEY = "loadSecretKey";
        public static final java.lang.String METHOD_STORE_EVENT = "storeEvent";
        public static final java.lang.String METHOD_STORE_SECRET_KEY = "storeSecretKey";
        public static final java.lang.String METHOD_VERIFY_SECRET_KEY = "verifySecretKey";
        public static final java.lang.String METHOD_VERIFY_SUPPORT_TRANSPORT = "supportTransportEncrypt";
        public static final java.lang.String MODULE_NAME = "sensors_analytics_module_encrypt";
    }

    public interface Exposure {
        public static final java.lang.String METHOD_ADD_EXPOSURE_VIEW = "addExposureView";
        public static final java.lang.String METHOD_REMOVE_EXPOSURE_VIEW = "removeExposureView";
        public static final java.lang.String METHOD_SET_EXPOSURE_IDENTIFIER = "setExposureIdentifier";
        public static final java.lang.String METHOD_UPDATE_EXPOSURE_PROPERTIES = "updateExposureProperties";
        public static final java.lang.String MODULE_NAME = "sensors_analytics_module_exposure";
    }

    public interface Push {
        public static final java.lang.String MODULE_NAME = "sensors_analytics_module_push";
    }

    public interface Visual {
        public static final java.lang.String METHOD_ADD_VISUAL_JAVASCRIPTINTERFACE = "addVisualJavascriptInterface";
        public static final java.lang.String METHOD_FLUTTER_GET_APPVISUAL_CONFIG = "flutterGetAppVisualConfig";
        public static final java.lang.String METHOD_GET_VISUAL_STATE = "getVisualState";
        public static final java.lang.String METHOD_H5_GET_APPVISUAL_CONFIG = "h5GetAppVisualConfig";
        public static final java.lang.String METHOD_MERGE_VISUAL_PROPERTIES = "mergeVisualProperties";
        public static final java.lang.String METHOD_REQUEST_VISUAL_CONFIG = "requestVisualConfig";
        public static final java.lang.String METHOD_RESUME_HEATMAP_SERVICE = "resumeHeatMapService";
        public static final java.lang.String METHOD_RESUME_VISUAL_SERVICE = "resumeVisualService";
        public static final java.lang.String METHOD_SEND_VISUALIZED_MESSAGE = "sendVisualizedMessage";
        public static final java.lang.String METHOD_SHOW_OPEN_HEATMAP_DIALOG = "showOpenHeatMapDialog";
        public static final java.lang.String METHOD_SHOW_OPEN_VISUALIZED_AUTOTRACK_DIALOG = "showOpenVisualizedAutoTrackDialog";
        public static final java.lang.String METHOD_SHOW_PAIRING_CODE_INPUTDIALOG = "showPairingCodeInputDialog";
        public static final java.lang.String METHOD_STOP_HEATMAP_SERVICE = "stopHeatMapService";
        public static final java.lang.String METHOD_STOP_VISUAL_SERVICE = "stopVisualService";
        public static final java.lang.String MODULE_NAME = "sensors_analytics_module_visual";
    }

    public interface WebView {
        public static final java.lang.String METHOD_SHOWUP_WEBVIEW = "showUpWebView";
        public static final java.lang.String METHOD_SHOWUP_X5WEBVIEW = "showUpX5WebView";
        public static final java.lang.String MODULE_NAME = "sensors_analytics_module_webview";
    }
}
