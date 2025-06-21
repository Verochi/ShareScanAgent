package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public abstract class HonorMessageService extends android.app.Service {
    public static final /* synthetic */ int b = 0;
    public final android.os.Messenger a = new android.os.Messenger(new com.hihonor.push.sdk.HonorMessageService.AnonymousClass1(android.os.Looper.getMainLooper()));

    /* renamed from: com.hihonor.push.sdk.HonorMessageService$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            com.hihonor.push.sdk.common.logger.Logger.i("HonorMessageService", "handle message start.");
            android.os.Bundle data = message.getData();
            if (data != null) {
                android.content.Intent intent = new android.content.Intent();
                intent.putExtras(data);
                com.hihonor.push.sdk.HonorMessageService honorMessageService = com.hihonor.push.sdk.HonorMessageService.this;
                int i = com.hihonor.push.sdk.HonorMessageService.b;
                honorMessageService.getClass();
                try {
                    java.lang.String stringExtra = intent.getStringExtra(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE);
                    if (android.text.TextUtils.equals(stringExtra, com.hihonor.push.sdk.common.data.DownMsgType.RECEIVE_TOKEN)) {
                        java.lang.String stringExtra2 = intent.getStringExtra(com.hihonor.push.sdk.common.constants.PushApiKeys.PUSH_TOKEN);
                        com.hihonor.push.sdk.common.logger.Logger.d("HonorMessageService", "handle message new token: ".concat(java.lang.String.valueOf(stringExtra2)));
                        if (!android.text.TextUtils.equals(stringExtra2, com.hihonor.push.sdk.utils.HonorIdUtils.getPushToken(honorMessageService.getApplicationContext()))) {
                            com.hihonor.push.sdk.utils.HonorIdUtils.setPushToken(honorMessageService.getApplicationContext(), stringExtra2);
                        }
                        honorMessageService.onNewToken(stringExtra2);
                    } else if (android.text.TextUtils.equals(stringExtra, com.hihonor.push.sdk.common.data.DownMsgType.RECEIVE_PUSH_MESSAGE)) {
                        com.hihonor.push.sdk.bean.DataMessage dataMessage = new com.hihonor.push.sdk.bean.DataMessage();
                        dataMessage.setMsgId(intent.getLongExtra(com.hihonor.push.sdk.common.constants.PushApiKeys.MSG_ID, 0L));
                        dataMessage.setContent(intent.getStringExtra(com.hihonor.push.sdk.common.constants.PushApiKeys.MSG_CONTENT));
                        com.hihonor.push.sdk.common.logger.Logger.d("HonorMessageService", "handle message a push msg ".concat(java.lang.String.valueOf(dataMessage)));
                        honorMessageService.onMessageReceived(dataMessage);
                    }
                } catch (java.lang.Exception e) {
                    com.hihonor.push.sdk.common.logger.Logger.e("handleMessage", e);
                }
            }
            super.handleMessage(message);
            com.hihonor.push.sdk.common.logger.Logger.i("HonorMessageService", "handle message end.");
        }
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.a.getBinder();
    }

    public void onMessageReceived(com.hihonor.push.sdk.bean.DataMessage dataMessage) {
    }

    public void onNewToken(java.lang.String str) {
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onServiceStartCommand(this, intent, i, i2);
        super.onStartCommand(intent, i, i2);
        com.hihonor.push.sdk.common.logger.Logger.i("HonorMessageService", "handle message onStartCommand.");
        if (intent == null) {
            return 2;
        }
        try {
            if (!android.text.TextUtils.equals(intent.getStringExtra(com.hihonor.push.sdk.common.constants.PushApiKeys.EVENT_TYPE), com.hihonor.push.sdk.common.data.DownMsgType.RECEIVE_TOKEN)) {
                com.hihonor.push.sdk.bean.DataMessage parseRemoteDataMessage = com.hihonor.push.sdk.utils.MsgParser.parseRemoteDataMessage(intent);
                if (parseRemoteDataMessage == null) {
                    return 2;
                }
                onMessageReceived(parseRemoteDataMessage);
                return 2;
            }
            java.lang.String stringExtra = intent.getStringExtra(com.hihonor.push.sdk.common.constants.PushApiKeys.PUSH_TOKEN);
            com.hihonor.push.sdk.common.logger.Logger.d("HonorMessageService", "handle message new token: ".concat(java.lang.String.valueOf(stringExtra)));
            if (!android.text.TextUtils.equals(stringExtra, com.hihonor.push.sdk.utils.HonorIdUtils.getPushToken(getApplicationContext()))) {
                com.hihonor.push.sdk.utils.HonorIdUtils.setPushToken(getApplicationContext(), stringExtra);
            }
            onNewToken(stringExtra);
            return 2;
        } catch (java.lang.Exception e) {
            com.hihonor.push.sdk.common.logger.Logger.e("onStartCommand", e);
            return 2;
        }
    }
}
