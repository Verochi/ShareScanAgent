package com.heytap.msp.push;

/* loaded from: classes22.dex */
public class HeytapPushManager {
    public static void clearNotificationType() {
        clearNotificationType(null);
    }

    public static void clearNotificationType(org.json.JSONObject jSONObject) {
        com.heytap.mcssdk.PushService.getInstance().clearNotificationType(jSONObject);
    }

    public static void clearNotifications() {
        clearNotifications(null);
    }

    public static void clearNotifications(org.json.JSONObject jSONObject) {
        com.heytap.mcssdk.PushService.getInstance().clearNotifications(jSONObject);
    }

    public static void disableAppNotificationSwitch(com.heytap.msp.push.callback.ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        com.heytap.mcssdk.PushService.getInstance().disableAppNotificationSwitch(iSetAppNotificationCallBackService);
    }

    public static void enableAppNotificationSwitch(com.heytap.msp.push.callback.ISetAppNotificationCallBackService iSetAppNotificationCallBackService) {
        com.heytap.mcssdk.PushService.getInstance().enableAppNotificationSwitch(iSetAppNotificationCallBackService);
    }

    public static void getAppNotificationSwitch(com.heytap.msp.push.callback.IGetAppNotificationCallBackService iGetAppNotificationCallBackService) {
        com.heytap.mcssdk.PushService.getInstance().getAppNotificationSwitch(iGetAppNotificationCallBackService);
    }

    public static java.lang.String getMcsPackageName(android.content.Context context) {
        return com.heytap.mcssdk.PushService.getInstance().getMcsPackageName(context);
    }

    public static void getNotificationStatus() {
        getNotificationStatus(null);
    }

    public static void getNotificationStatus(org.json.JSONObject jSONObject) {
        com.heytap.mcssdk.PushService.getInstance().getNotificationStatus(jSONObject);
    }

    public static com.heytap.msp.push.callback.ICallBackResultService getPushCallback() {
        return com.heytap.mcssdk.PushService.getInstance().getPushCallback();
    }

    public static void getPushStatus() {
        com.heytap.mcssdk.PushService.getInstance().getPushStatus();
    }

    public static int getPushVersionCode() {
        return com.heytap.mcssdk.PushService.getInstance().getPushVersionCode();
    }

    public static java.lang.String getPushVersionName() {
        return com.heytap.mcssdk.PushService.getInstance().getPushVersionName();
    }

    public static java.lang.String getReceiveSdkAction(android.content.Context context) {
        return com.heytap.mcssdk.PushService.getInstance().getReceiveSdkAction(context);
    }

    public static void getRegister() {
        getRegister(null);
    }

    public static void getRegister(org.json.JSONObject jSONObject) {
        com.heytap.mcssdk.PushService.getInstance().getRegister(jSONObject);
    }

    public static java.lang.String getRegisterID() {
        return com.heytap.mcssdk.PushService.getInstance().getRegisterID();
    }

    public static int getSDKVersionCode() {
        return com.heytap.mcssdk.PushService.getSDKVersionCode();
    }

    public static java.lang.String getSDKVersionName() {
        return com.heytap.mcssdk.PushService.getSDKVersionName();
    }

    public static void init(android.content.Context context, boolean z) {
        com.heytap.mcssdk.PushService.getInstance().init(context, z);
    }

    public static boolean isSupportPush(android.content.Context context) {
        return com.heytap.mcssdk.PushService.getInstance().isSupportPushByClient(context);
    }

    public static void openNotificationSettings() {
        openNotificationSettings(null);
    }

    public static void openNotificationSettings(org.json.JSONObject jSONObject) {
        com.heytap.mcssdk.PushService.getInstance().openNotificationSettings(jSONObject);
    }

    public static void pausePush() {
        pausePush(null);
    }

    public static void pausePush(org.json.JSONObject jSONObject) {
        com.heytap.mcssdk.PushService.getInstance().pausePush(jSONObject);
    }

    public static void register(android.content.Context context, java.lang.String str, java.lang.String str2, com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService) {
        register(context, str, str2, null, iCallBackResultService);
    }

    public static void register(android.content.Context context, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService) {
        com.heytap.mcssdk.PushService.getInstance().register(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void requestNotificationPermission() {
        com.heytap.mcssdk.PushService.getInstance().requestNotificationPermission();
    }

    public static void resumePush() {
        resumePush(null);
    }

    public static void resumePush(org.json.JSONObject jSONObject) {
        com.heytap.mcssdk.PushService.getInstance().resumePush(jSONObject);
    }

    public static void setAppKeySecret(java.lang.String str, java.lang.String str2) {
        com.heytap.mcssdk.PushService.getInstance().setAppKeySecret(str, str2);
    }

    public static void setNotificationType(int i) {
        setNotificationType(i, null);
    }

    public static void setNotificationType(int i, org.json.JSONObject jSONObject) {
        com.heytap.mcssdk.PushService.getInstance().setNotificationType(i, jSONObject);
    }

    public static void setPushCallback(com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService) {
        com.heytap.mcssdk.PushService.getInstance().setPushCallback(iCallBackResultService);
    }

    public static void setPushTime(java.util.List<java.lang.Integer> list, int i, int i2, int i3, int i4) {
        setPushTime(list, i, i2, i3, i4, null);
    }

    public static void setPushTime(java.util.List<java.lang.Integer> list, int i, int i2, int i3, int i4, org.json.JSONObject jSONObject) {
        com.heytap.mcssdk.PushService.getInstance().setPushTime(list, i, i2, i3, i4, jSONObject);
    }

    public static void setRegisterID(java.lang.String str) {
        com.heytap.mcssdk.PushService.getInstance().setRegisterID(str);
    }

    public static void statisticEvent(android.content.Context context, java.lang.String str, com.heytap.msp.push.mode.DataMessage dataMessage) {
        com.heytap.msp.push.statis.StatisticUtils.statisticEvent(context, str, dataMessage);
    }

    @java.lang.Deprecated
    public static void statisticMessage(android.content.Context context, com.heytap.msp.push.mode.MessageStat messageStat) {
        com.heytap.mcssdk.utils.StatUtil.statisticMessage(context, messageStat);
    }

    @java.lang.Deprecated
    public static void statisticMessage(android.content.Context context, java.util.List<com.heytap.msp.push.mode.MessageStat> list) {
        com.heytap.mcssdk.utils.StatUtil.statisticMessage(context, list);
    }

    public static void unRegister() {
        unRegister(null);
    }

    public static void unRegister(android.content.Context context, java.lang.String str, java.lang.String str2, org.json.JSONObject jSONObject, com.heytap.msp.push.callback.ICallBackResultService iCallBackResultService) {
        com.heytap.mcssdk.PushService.getInstance().unRegister(context, str, str2, jSONObject, iCallBackResultService);
    }

    public static void unRegister(org.json.JSONObject jSONObject) {
        com.heytap.mcssdk.PushService.getInstance().unRegister(jSONObject);
    }
}
