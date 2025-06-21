package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class PushReceiver extends android.content.BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    public static class PushThread implements java.lang.Runnable {
        public android.content.Context a;
        public android.content.Intent b;

        public PushThread(android.content.Context context, android.content.Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.hihonor.push.sdk.bean.DataMessage parseRemoteDataMessage;
            android.content.Context context = this.a;
            android.content.Intent intent = this.b;
            int i = com.hihonor.push.sdk.PushReceiver.a;
            try {
                android.os.Bundle bundle = new android.os.Bundle();
                java.lang.String stringExtra = intent.getStringExtra(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE);
                if (android.text.TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                bundle.putString(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE, stringExtra);
                if (android.text.TextUtils.equals(stringExtra, com.hihonor.push.sdk.common.data.DownMsgType.RECEIVE_TOKEN)) {
                    bundle.putString(com.hihonor.push.sdk.common.constants.PushApiKeys.PUSH_TOKEN, intent.getStringExtra(com.hihonor.push.sdk.common.constants.PushApiKeys.PUSH_TOKEN));
                    new com.hihonor.push.sdk.m().a(context, bundle);
                } else {
                    if (!android.text.TextUtils.equals(stringExtra, com.hihonor.push.sdk.common.data.DownMsgType.RECEIVE_PUSH_MESSAGE) || (parseRemoteDataMessage = com.hihonor.push.sdk.utils.MsgParser.parseRemoteDataMessage(intent)) == null) {
                        return;
                    }
                    bundle.putLong(com.hihonor.push.sdk.common.constants.PushApiKeys.MSG_ID, parseRemoteDataMessage.getMsgId());
                    bundle.putString(com.hihonor.push.sdk.common.constants.PushApiKeys.MSG_CONTENT, parseRemoteDataMessage.getContent());
                    new com.hihonor.push.sdk.m().a(context, bundle);
                }
            } catch (java.lang.Exception e) {
                com.hihonor.push.sdk.common.logger.Logger.e("handle push receiver error . error : ".concat(java.lang.String.valueOf(e)));
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        com.hihonor.push.sdk.common.logger.Logger.i("onReceive");
        if (intent == null || context == null) {
            return;
        }
        com.hihonor.push.sdk.common.logger.Logger.d("push receive broadcast message, intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
        try {
            java.lang.String action = intent.getAction();
            if (com.hihonor.push.sdk.common.constants.PushReceiverConstants.ACTION_PUSH_REGISTRATION.equals(action)) {
                com.hihonor.push.sdk.common.logger.Logger.i("PushReceiver", "handlePushTokenEvent");
                try {
                    if (intent.hasExtra(com.hihonor.push.sdk.common.constants.PushApiKeys.PUSH_TOKEN)) {
                        java.util.concurrent.Executors.newCachedThreadPool().submit(new com.hihonor.push.sdk.PushReceiver.PushThread(context, intent));
                        return;
                    } else {
                        com.hihonor.push.sdk.common.logger.Logger.i("PushReceiver", "handlePushTokenEvent has no msg");
                        return;
                    }
                } catch (java.lang.Exception e) {
                    com.hihonor.push.sdk.common.logger.Logger.e("PushReceiver", "handlePushTokenEvent Exception ".concat(java.lang.String.valueOf(e)));
                    return;
                }
            }
            if (!com.hihonor.push.sdk.common.constants.PushReceiverConstants.ACTION_PUSH_RECEIVE_MESSAGE.equals(action)) {
                com.hihonor.push.sdk.common.logger.Logger.e("message can't be recognised:" + intent.toUri(0));
                return;
            }
            com.hihonor.push.sdk.common.logger.Logger.i("PushReceiver", "start handle data message");
            try {
                if (intent.hasExtra(com.hihonor.push.sdk.common.constants.PushApiKeys.MSG_CONTENT)) {
                    java.util.concurrent.Executors.newCachedThreadPool().submit(new com.hihonor.push.sdk.PushReceiver.PushThread(context, intent));
                    return;
                } else {
                    com.hihonor.push.sdk.common.logger.Logger.e("handle msg error , receiver has no msg");
                    return;
                }
            } catch (java.lang.Exception e2) {
                com.hihonor.push.sdk.common.logger.Logger.e("handle msg error , ".concat(java.lang.String.valueOf(e2)));
                return;
            }
        } catch (java.lang.Exception e3) {
            com.hihonor.push.sdk.common.logger.Logger.e("intent has some error. error : ".concat(java.lang.String.valueOf(e3)));
        }
        com.hihonor.push.sdk.common.logger.Logger.e("intent has some error. error : ".concat(java.lang.String.valueOf(e3)));
    }
}
