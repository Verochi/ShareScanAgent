package com.heytap.msp.push.mode;

/* loaded from: classes22.dex */
public class MessageStat {
    private static final java.lang.String APP_PACKAGE = "appPackage";
    private static final java.lang.String DATA_EXTRA = "data_extra";
    private static final java.lang.String EVENT_ID = "eventID";
    private static final java.lang.String EVENT_TIME = "eventTime";
    private static final java.lang.String GLOBAL_ID = "globalID";
    private static final java.lang.String MESSAGE_TYPE = "messageType";
    private static final java.lang.String PROPERTY = "property";
    private static final java.lang.String STATISTICS_EXTRA = "statistics_extra";
    private static final java.lang.String TASK_ID = "taskID";
    private java.lang.String mAppPackage;
    private java.lang.String mDataExtra;
    private java.lang.String mEventId;
    private long mEventTime;
    private java.lang.String mGlobalId;
    private java.lang.String mProperty;
    private java.lang.String mStatisticsExtra;
    private java.lang.String mTaskID;
    private int mType;

    public MessageStat() {
        this.mType = 4096;
        this.mEventTime = java.lang.System.currentTimeMillis();
    }

    public MessageStat(int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(i, str, null, null, str2, str3);
    }

    public MessageStat(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this(i, str, str2, str3, str4, str5, "", "");
    }

    public MessageStat(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        this.mType = 4096;
        this.mEventTime = java.lang.System.currentTimeMillis();
        setType(i);
        setAppPackage(str);
        setGlobalId(str2);
        setTaskID(str3);
        setEventId(str4);
        setProperty(str5);
        setStatisticsExtra(str6);
        setDataExtra(str7);
    }

    public MessageStat(java.lang.String str, java.lang.String str2) {
        this(4096, str, null, null, str2, "");
    }

    public MessageStat(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this(4096, str, null, null, str2, str3);
    }

    public static com.heytap.msp.push.mode.MessageStat parse(java.lang.String str) {
        com.heytap.msp.push.mode.MessageStat messageStat = new com.heytap.msp.push.mode.MessageStat();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            messageStat.setType(jSONObject.optInt(MESSAGE_TYPE, 0));
            messageStat.setAppPackage(jSONObject.optString("appPackage"));
            messageStat.setEventId(jSONObject.optString(EVENT_ID));
            messageStat.setGlobalId(jSONObject.optString("globalID", ""));
            messageStat.setTaskID(jSONObject.optString("taskID", ""));
            messageStat.setProperty(jSONObject.optString("property", ""));
            messageStat.setEventTime(jSONObject.optLong(EVENT_TIME, java.lang.System.currentTimeMillis()));
            messageStat.setStatisticsExtra(jSONObject.optString("statistics_extra"));
            messageStat.setDataExtra(jSONObject.optString("data_extra"));
            return messageStat;
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.e(e.getLocalizedMessage());
            return null;
        }
    }

    public java.lang.String getAppPackage() {
        return this.mAppPackage;
    }

    public java.lang.String getDataExtra() {
        return this.mDataExtra;
    }

    public java.lang.String getEventId() {
        return this.mEventId;
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public java.lang.String getGlobalId() {
        return this.mGlobalId;
    }

    public java.lang.String getProperty() {
        return this.mProperty;
    }

    public java.lang.String getStatisticsExtra() {
        return this.mStatisticsExtra;
    }

    public java.lang.String getTaskID() {
        return this.mTaskID;
    }

    public int getType() {
        return this.mType;
    }

    public void setAppPackage(java.lang.String str) {
        this.mAppPackage = str;
    }

    public void setDataExtra(java.lang.String str) {
        this.mDataExtra = str;
    }

    public void setEventId(java.lang.String str) {
        this.mEventId = str;
    }

    public void setEventTime(long j) {
        this.mEventTime = j;
    }

    public void setGlobalId(java.lang.String str) {
        this.mGlobalId = str;
    }

    public void setProperty(java.lang.String str) {
        this.mProperty = str;
    }

    public void setStatisticsExtra(java.lang.String str) {
        this.mStatisticsExtra = str;
    }

    public void setTaskID(int i) {
        this.mTaskID = i + "";
    }

    public void setTaskID(java.lang.String str) {
        this.mTaskID = str;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public java.lang.String toJsonObject() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(MESSAGE_TYPE, java.lang.Integer.valueOf(this.mType));
            jSONObject.putOpt(EVENT_ID, this.mEventId);
            jSONObject.putOpt("appPackage", this.mAppPackage);
            jSONObject.putOpt(EVENT_TIME, java.lang.Long.valueOf(this.mEventTime));
            if (!android.text.TextUtils.isEmpty(this.mGlobalId)) {
                jSONObject.putOpt("globalID", this.mGlobalId);
            }
            if (!android.text.TextUtils.isEmpty(this.mTaskID)) {
                jSONObject.putOpt("taskID", this.mTaskID);
            }
            if (!android.text.TextUtils.isEmpty(this.mProperty)) {
                jSONObject.putOpt("property", this.mProperty);
            }
            if (!android.text.TextUtils.isEmpty(this.mStatisticsExtra)) {
                jSONObject.putOpt("statistics_extra", this.mStatisticsExtra);
            }
            if (!android.text.TextUtils.isEmpty(this.mDataExtra)) {
                jSONObject.putOpt("data_extra", this.mDataExtra);
            }
        } catch (java.lang.Exception e) {
            com.heytap.mcssdk.utils.d.e(e.getLocalizedMessage());
        }
        return jSONObject.toString();
    }
}
