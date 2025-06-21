package com.igexin.sdk;

/* loaded from: classes23.dex */
public class VivoPushMessageReceiver extends com.vivo.push.sdk.OpenClientPushMessageReceiver {
    public static final java.lang.String TAG = "Assist_VV";

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(android.content.Context context, java.lang.String str) {
        try {
            "onReceiveRegId :".concat(java.lang.String.valueOf(str));
            if (context == null || android.text.TextUtils.isEmpty(str)) {
                return;
            }
            com.igexin.assist.action.MessageManger.getInstance().addMessage(new com.igexin.assist.MessageBean(context, "token", com.igexin.assist.sdk.AssistPushConsts.VIVO_PREFIX.concat(java.lang.String.valueOf(str))));
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
