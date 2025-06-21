package com.igexin.sdk;

/* loaded from: classes23.dex */
public class HonorPushMessageService extends com.hihonor.push.sdk.HonorMessageService {
    public static final java.lang.String TAG = "Assist_Honor";

    @Override // com.hihonor.push.sdk.HonorMessageService
    public void onMessageReceived(com.hihonor.push.sdk.bean.DataMessage dataMessage) {
        if (dataMessage == null) {
            return;
        }
        try {
            if (android.text.TextUtils.isEmpty(dataMessage.getContent())) {
                return;
            }
            com.igexin.assist.MessageBean messageBean = new com.igexin.assist.MessageBean(getApplicationContext(), "payload", dataMessage.getContent());
            messageBean.setMessageSource(com.igexin.assist.sdk.AssistPushConsts.HONOR_PREFIX);
            com.igexin.assist.action.MessageManger.getInstance().addMessage(messageBean);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.hihonor.push.sdk.HonorMessageService
    public void onNewToken(java.lang.String str) {
        try {
            "onNewToken :".concat(java.lang.String.valueOf(str));
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(getApplicationContext(), "token", com.igexin.assist.sdk.AssistPushConsts.HONOR_PREFIX.concat(java.lang.String.valueOf(str))));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
