package com.sensorsdata.analytics.android.sdk.data.adapter;

/* loaded from: classes19.dex */
public class DbParams {
    public static final java.lang.String APP_EXIT_DATA = "app_exit_data";
    public static final java.lang.String APP_START_DATA = "app_start_data";
    public static final java.lang.String DATABASE_NAME = "sensorsdata";
    public static final int DATABASE_VERSION = 6;
    static final java.lang.String DB_DELETE_ALL = "DB_DELETE_ALL";
    public static final int DB_OUT_OF_MEMORY_ERROR = -2;
    static final int DB_UPDATE_ERROR = -1;
    public static final java.lang.String GZIP_DATA_ENCRYPT = "9";
    public static final java.lang.String GZIP_DATA_EVENT = "1";
    public static final java.lang.String GZIP_TRANSPORT_ENCRYPT = "13";
    public static final java.lang.String KEY_CHANNEL_EVENT_NAME = "event_name";
    public static final java.lang.String KEY_CHANNEL_RESULT = "result";
    public static final java.lang.String KEY_CREATED_AT = "created_at";
    public static final java.lang.String KEY_DATA = "data";
    public static final java.lang.String KEY_IS_INSTANT_EVENT = "is_instant_event";
    public static final java.lang.String PUSH_ID_KEY = "push_key";
    public static final java.lang.String PUSH_ID_VALUE = "push_value";
    public static final java.lang.String REMOVE_SP_KEY = "remove_key";
    public static final java.lang.String TABLE_ACTIVITY_START_COUNT = "activity_started_count";
    public static final java.lang.String TABLE_APP_START_TIME = "app_start_time";
    public static final java.lang.String TABLE_CHANNEL_PERSISTENT = "t_channel";
    public static final java.lang.String TABLE_DATA_DISABLE_SDK = "disable_SDK";
    public static final java.lang.String TABLE_DATA_ENABLE_SDK = "enable_SDK";
    public static final java.lang.String TABLE_EVENTS = "events";
    public static final java.lang.String TABLE_FIRST_PROCESS_START = "first_process_start";
    public static final java.lang.String TABLE_SESSION_INTERVAL_TIME = "session_interval_time";
    static final java.lang.String VALUE = "value";
    private static com.sensorsdata.analytics.android.sdk.data.adapter.DbParams instance;
    private final android.net.Uri mActivityStartCountUri;
    private final android.net.Uri mAppExitDataUri;
    private final android.net.Uri mAppStartTimeUri;
    private final android.net.Uri mChannelPersistentUri;
    private final android.net.Uri mDisableSDKUri;
    private final android.net.Uri mEnableSDKUri;
    private final android.net.Uri mLoginIdKeyUri;
    private final android.net.Uri mLoginIdUri;
    private final android.net.Uri mPushIdUri;
    private final android.net.Uri mRemoteConfigUri;
    private final android.net.Uri mSessionTimeUri;
    private final android.net.Uri mSubProcessUri;
    private final android.net.Uri mUri;
    private final android.net.Uri mUserIdentities;

    public interface PersistentName {
        public static final java.lang.String APP_END_DATA = "app_end_data";
        public static final java.lang.String DISTINCT_ID = "events_distinct_id";
        public static final java.lang.String FIRST_DAY = "first_day";
        public static final java.lang.String FIRST_INSTALL = "first_track_installation";
        public static final java.lang.String FIRST_INSTALL_CALLBACK = "first_track_installation_with_callback";
        public static final java.lang.String FIRST_START = "first_start";
        public static final java.lang.String LOGIN_ID = "events_login_id";
        public static final java.lang.String PERSISTENT_DAY_DATE = "daily_date";
        public static final java.lang.String PERSISTENT_LOGIN_ID_KEY = "login_id_key";
        public static final java.lang.String PERSISTENT_USER_ID = "user_ids";
        public static final java.lang.String REMOTE_CONFIG = "sensorsdata_sdk_configuration";
        public static final java.lang.String REQUEST_DEFERRER_DEEPLINK = "request_deferrer_deeplink";
        public static final java.lang.String SUB_PROCESS_FLUSH_DATA = "sub_process_flush_data";
        public static final java.lang.String SUPER_PROPERTIES = "super_properties";
        public static final java.lang.String VISUAL_PROPERTIES = "visual_properties";
    }

    private DbParams(java.lang.String str) {
        this.mUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/events");
        this.mActivityStartCountUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_ACTIVITY_START_COUNT);
        this.mAppStartTimeUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_APP_START_TIME);
        this.mAppExitDataUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + APP_EXIT_DATA);
        this.mSessionTimeUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_SESSION_INTERVAL_TIME);
        this.mLoginIdUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.LOGIN_ID);
        this.mLoginIdKeyUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY);
        this.mChannelPersistentUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_CHANNEL_PERSISTENT);
        this.mSubProcessUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA);
        this.mEnableSDKUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_DATA_ENABLE_SDK);
        this.mDisableSDKUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + TABLE_DATA_DISABLE_SDK);
        this.mRemoteConfigUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REMOTE_CONFIG);
        this.mUserIdentities = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_USER_ID);
        this.mPushIdUri = android.net.Uri.parse("content://" + str + ".SensorsDataContentProvider/" + PUSH_ID_KEY);
    }

    public static com.sensorsdata.analytics.android.sdk.data.adapter.DbParams getInstance() {
        com.sensorsdata.analytics.android.sdk.data.adapter.DbParams dbParams = instance;
        if (dbParams != null) {
            return dbParams;
        }
        throw new java.lang.IllegalStateException("The static method getInstance(String packageName) should be called before calling getInstance()");
    }

    public static com.sensorsdata.analytics.android.sdk.data.adapter.DbParams getInstance(java.lang.String str) {
        if (instance == null) {
            instance = new com.sensorsdata.analytics.android.sdk.data.adapter.DbParams(str);
        }
        return instance;
    }

    public android.net.Uri getActivityStartCountUri() {
        return this.mActivityStartCountUri;
    }

    public android.net.Uri getAppExitDataUri() {
        return this.mAppExitDataUri;
    }

    public android.net.Uri getAppStartTimeUri() {
        return this.mAppStartTimeUri;
    }

    public android.net.Uri getChannelPersistentUri() {
        return this.mChannelPersistentUri;
    }

    public android.net.Uri getDisableSDKUri() {
        return this.mDisableSDKUri;
    }

    public android.net.Uri getEnableSDKUri() {
        return this.mEnableSDKUri;
    }

    public android.net.Uri getEventUri() {
        return this.mUri;
    }

    public android.net.Uri getLoginIdKeyUri() {
        return this.mLoginIdKeyUri;
    }

    public android.net.Uri getLoginIdUri() {
        return this.mLoginIdUri;
    }

    public android.net.Uri getPushIdUri() {
        return this.mPushIdUri;
    }

    public android.net.Uri getRemoteConfigUri() {
        return this.mRemoteConfigUri;
    }

    public android.net.Uri getSessionTimeUri() {
        return this.mSessionTimeUri;
    }

    public android.net.Uri getSubProcessUri() {
        return this.mSubProcessUri;
    }

    public android.net.Uri getUserIdentities() {
        return this.mUserIdentities;
    }
}
