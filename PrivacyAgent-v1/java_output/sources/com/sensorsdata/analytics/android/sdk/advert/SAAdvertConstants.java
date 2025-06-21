package com.sensorsdata.analytics.android.sdk.advert;

/* loaded from: classes19.dex */
public interface SAAdvertConstants {
    public static final java.lang.String TAG = "SA.Advert";

    public interface EventName {
        public static final java.lang.String APP_INTERACT = "$AppInteract";
        public static final java.lang.String DEEPLINK_LAUNCH = "$AppDeeplinkLaunch";
        public static final java.lang.String DEFERRED_DEEPLINK_JUMP = "$AdAppDeferredDeepLinkJump";
        public static final java.lang.String DYNAMIC_SLINK_CREATE = "$AdDynamicSlinkCreate";
        public static final java.lang.String MATCH_RESULT = "$AppDeeplinkMatchedResult";
    }

    public interface Properties {
        public static final java.lang.String CHANNEL_INFO = "$ad_deeplink_channel_info";
        public static final java.lang.String DEEPLINK_OPTIONS = "$deeplink_options";
        public static final java.lang.String DEEPLINK_URL = "$deeplink_url";
        public static final java.lang.String DEVICE_INFO = "$ad_device_info";
        public static final java.lang.String DYNAMIC_SLINK_CHANNEL_NAME = "$ad_dynamic_slink_channel_name";
        public static final java.lang.String DYNAMIC_SLINK_CHANNEL_TYPE = "$ad_dynamic_slink_channel_type";
        public static final java.lang.String DYNAMIC_SLINK_DATA = "$ad_dynamic_slink_data";
        public static final java.lang.String DYNAMIC_SLINK_MSG = "$ad_dynamic_slink_msg";
        public static final java.lang.String DYNAMIC_SLINK_SHORT_URL = "$ad_dynamic_slink_short_url";
        public static final java.lang.String DYNAMIC_SLINK_SOURCE = "$ad_dynamic_slink_source";
        public static final java.lang.String DYNAMIC_SLINK_STATUS = "$ad_dynamic_slink_status";
        public static final java.lang.String MATCH_FAIL_REASON = "$deeplink_match_fail_reason";
        public static final java.lang.String MATCH_TYPE = "$ad_app_match_type";
        public static final java.lang.String SLINK_CUSTOM_PARAMS = "$sat_slink_custom_params";
        public static final java.lang.String SLINK_ID = "$ad_slink_id";
        public static final java.lang.String SLINK_TEMPLATE_ID = "$ad_slink_template_id";
        public static final java.lang.String SLINK_TYPE = "$ad_slink_type";
    }
}
