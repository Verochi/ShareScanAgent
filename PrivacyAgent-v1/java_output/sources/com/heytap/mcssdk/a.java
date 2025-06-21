package com.heytap.mcssdk;

/* loaded from: classes22.dex */
interface a {
    @java.lang.Deprecated
    void clearNotificationType();

    @java.lang.Deprecated
    void clearNotificationType(org.json.JSONObject jSONObject);

    void clearNotifications();

    void clearNotifications(org.json.JSONObject jSONObject);

    void disableAppNotificationSwitch(com.heytap.msp.push.callback.ISetAppNotificationCallBackService iSetAppNotificationCallBackService);

    void enableAppNotificationSwitch(com.heytap.msp.push.callback.ISetAppNotificationCallBackService iSetAppNotificationCallBackService);

    void getAppNotificationSwitch(com.heytap.msp.push.callback.IGetAppNotificationCallBackService iGetAppNotificationCallBackService);

    void getNotificationStatus();

    void getNotificationStatus(org.json.JSONObject jSONObject);

    void getRegister();

    void getRegister(org.json.JSONObject jSONObject);

    java.lang.String getRegisterID();

    void openNotificationSettings();

    void openNotificationSettings(org.json.JSONObject jSONObject);

    void pausePush();

    void pausePush(org.json.JSONObject jSONObject);

    void register(android.content.Context context, java.lang.String str, java.lang.String str2, com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService);

    void register(android.content.Context context, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService);

    void requestNotificationPermission();

    void resumePush();

    void resumePush(org.json.JSONObject jSONObject);

    @java.lang.Deprecated
    void setNotificationType(int i);

    @java.lang.Deprecated
    void setNotificationType(int i, org.json.JSONObject jSONObject);

    void setPushTime(java.util.List<java.lang.Integer> list, int i, int i2, int i3, int i4);

    void setPushTime(java.util.List<java.lang.Integer> list, int i, int i2, int i3, int i4, org.json.JSONObject jSONObject);

    void setRegisterID(java.lang.String str);

    void unRegister();

    void unRegister(org.json.JSONObject jSONObject);
}
