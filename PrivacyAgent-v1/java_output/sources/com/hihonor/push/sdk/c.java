package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class c implements java.lang.Runnable {
    public android.content.Context a;

    public c(android.content.Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            java.lang.String pushToken = com.hihonor.push.sdk.HonorInstanceId.getInstance(this.a).getPushToken();
            com.hihonor.push.sdk.common.logger.Logger.i("AutoInitRunnable", "Push init succeed");
            if (android.text.TextUtils.isEmpty(pushToken)) {
                return;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, com.hihonor.push.sdk.common.data.DownMsgType.RECEIVE_TOKEN);
            bundle.putString(com.hihonor.push.sdk.common.constants.PushApiKeys.PUSH_TOKEN, pushToken);
            new com.hihonor.push.sdk.m().a(this.a, bundle);
        } catch (java.lang.Exception e) {
            com.hihonor.push.sdk.common.logger.Logger.e("AutoInitRunnable", "Push init failed. " + e.getMessage());
        }
    }
}
