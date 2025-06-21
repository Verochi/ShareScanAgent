package com.igexin.sdk;

/* loaded from: classes23.dex */
public class HmsPushMessageService extends com.huawei.hms.push.HmsMessageService {
    public static final java.lang.String TAG = "Assist_HW";

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(com.huawei.hms.push.RemoteMessage remoteMessage) {
        if (remoteMessage == null) {
            return;
        }
        try {
            if (android.text.TextUtils.isEmpty(remoteMessage.getData())) {
                return;
            }
            com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(getApplicationContext(), "payload", remoteMessage.getData());
            messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.HW_PREFIX);
            com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(java.lang.String str) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onNewToken :");
            sb.append(str);
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(getApplicationContext(), "token", com.igexin.assist.sdk.AssistPushConsts.HW_PREFIX + str));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(java.lang.String str, android.os.Bundle bundle) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onNewTokenAndBundle :");
            sb.append(str);
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(getApplicationContext(), "token", com.igexin.assist.sdk.AssistPushConsts.HW_PREFIX + str));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
