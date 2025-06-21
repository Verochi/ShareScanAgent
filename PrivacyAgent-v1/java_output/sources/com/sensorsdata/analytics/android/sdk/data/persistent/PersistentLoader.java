package com.sensorsdata.analytics.android.sdk.data.persistent;

/* loaded from: classes19.dex */
public class PersistentLoader {
    private static volatile com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader INSTANCE;
    private final android.content.Context mContext;
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppEndData mAppEndDataPst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppEndData) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.APP_END_DATA);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppExitData mAppExitDataPst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppExitData) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_EXIT_DATA);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoginId mLoginIdPst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoginId) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.LOGIN_ID);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentRemoteSDKConfig mRemoteSDKConfig = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentRemoteSDKConfig) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REMOTE_CONFIG);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.UserIdentityPersistent mUserIdsPst = (com.sensorsdata.analytics.android.sdk.data.persistent.UserIdentityPersistent) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_USER_ID);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.LoginIdKeyPersistent mLoginIdKeyPst = (com.sensorsdata.analytics.android.sdk.data.persistent.LoginIdKeyPersistent) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId mAnonymousIdPst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.DISTINCT_ID);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart mFirstStartPst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.FIRST_START);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstDay mFirstDayPst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstDay) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.FIRST_DAY);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties mSuperPropertiesPst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUPER_PROPERTIES);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentVisualConfig mVisualConfigPst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentVisualConfig) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.VISUAL_PROPERTIES);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallation mFirstInstallationPst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallation) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.FIRST_INSTALL);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallationWithCallback mFirstInstallationWithCallbackPst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallationWithCallback) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.FIRST_INSTALL_CALLBACK);
    private final com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDailyDate mDayDatePst = (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDailyDate) loadPersistent(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_DAY_DATE);

    private PersistentLoader(android.content.Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader getInstance() {
        return INSTANCE;
    }

    private com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity<?> loadPersistent(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
        }
        return null;
    }

    public static void preInit(android.content.Context context) {
        if (INSTANCE == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader.class) {
                if (INSTANCE == null) {
                    INSTANCE = new com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader(context);
                }
            }
        }
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDistinctId getAnonymousIdPst() {
        return this.mAnonymousIdPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppEndData getAppEndDataPst() {
        return this.mAppEndDataPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentAppExitData getAppExitDataPst() {
        return this.mAppExitDataPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentDailyDate getDayDatePst() {
        return this.mDayDatePst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstDay getFirstDayPst() {
        return this.mFirstDayPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallation getFirstInstallationPst() {
        return this.mFirstInstallationPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstTrackInstallationWithCallback getFirstInstallationWithCallbackPst() {
        return this.mFirstInstallationWithCallbackPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentFirstStart getFirstStartPst() {
        return this.mFirstStartPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.LoginIdKeyPersistent getLoginIdKeyPst() {
        return this.mLoginIdKeyPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoginId getLoginIdPst() {
        return this.mLoginIdPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentRemoteSDKConfig getRemoteSDKConfig() {
        return this.mRemoteSDKConfig;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentSuperProperties getSuperPropertiesPst() {
        return this.mSuperPropertiesPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.UserIdentityPersistent getUserIdsPst() {
        return this.mUserIdsPst;
    }

    public com.sensorsdata.analytics.android.sdk.data.persistent.PersistentVisualConfig getVisualConfigPst() {
        return this.mVisualConfigPst;
    }
}
