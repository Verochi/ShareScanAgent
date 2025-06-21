package com.sensorsdata.sf.core.data;

/* loaded from: classes19.dex */
class SFDbParams {
    static final java.lang.String DATABASE_NAME = "sensorsfocus";
    static final int DATABASE_VERSION = 1;
    static final java.lang.String DISTINCT_ID = "distinct_id";
    static final java.lang.String INSERT_ACTION = "insert_action";
    static final java.lang.String LOCAL_PLAN = "local_plan";
    static final java.lang.String MIGRATION_DATA = "migration_data";
    static final java.lang.String REMOTE_PLAN = "remote_plan";
    static final java.lang.String SP_NAME = "com.sensorsdata.sf.cache";
    static final java.lang.String SP_PARAMETER_GET = "sp_parameter_get";
    static final java.lang.String SP_PARAMETER_SET = "sp_parameter_set";
    static final java.lang.String TABLE_PLAN = "plans";
    static final java.lang.String TABLE_USER = "users";
    static final java.lang.String UPDATE_TIME = "update_time";
    static final java.lang.String USER_ID = "user_id";
    private static com.sensorsdata.sf.core.data.SFDbParams instance;
    private final android.net.Uri mPlanUri;
    private final android.net.Uri mSPUri;
    private final android.net.Uri mUserUri;

    public SFDbParams(java.lang.String str) {
        this.mPlanUri = android.net.Uri.parse("content://" + str + ".SensorsFocusContentProvider/" + TABLE_PLAN);
        this.mUserUri = android.net.Uri.parse("content://" + str + ".SensorsFocusContentProvider/" + TABLE_USER);
        this.mSPUri = android.net.Uri.parse("content://" + str + ".SensorsFocusContentProvider/" + SP_NAME);
    }

    public static com.sensorsdata.sf.core.data.SFDbParams getInstance(java.lang.String str) {
        if (instance == null) {
            instance = new com.sensorsdata.sf.core.data.SFDbParams(str);
        }
        return instance;
    }

    public android.net.Uri getPlanUri() {
        return this.mPlanUri;
    }

    public android.net.Uri getSPUri() {
        return this.mSPUri;
    }

    public android.net.Uri getUserUri() {
        return this.mUserUri;
    }
}
