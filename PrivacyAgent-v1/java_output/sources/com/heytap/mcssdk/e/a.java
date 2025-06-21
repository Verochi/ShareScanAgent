package com.heytap.mcssdk.e;

/* loaded from: classes22.dex */
public class a implements com.heytap.mcssdk.e.c {

    /* renamed from: com.heytap.mcssdk.e.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.heytap.mcssdk.c.b a;

        public AnonymousClass1(com.heytap.mcssdk.c.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.heytap.mcssdk.e.a.this.a(this.a, com.heytap.mcssdk.PushService.getInstance());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.heytap.mcssdk.c.b bVar, com.heytap.mcssdk.PushService pushService) {
        int i;
        java.lang.String str;
        if (bVar == null) {
            str = "message is null , please check param of parseCommandMessage(2)";
        } else if (pushService == null) {
            str = "pushService is null , please check param of parseCommandMessage(2)";
        } else {
            if (pushService.getPushCallback() != null) {
                int e = bVar.e();
                if (e == 12287) {
                    com.heytap.msp.push.callback.ICallBackResultService pushCallback = pushService.getPushCallback();
                    if (pushCallback != null) {
                        pushCallback.onError(bVar.g(), bVar.f());
                        return;
                    }
                    return;
                }
                if (e == 12298) {
                    pushService.getPushCallback().onSetPushTime(bVar.g(), bVar.f());
                    return;
                }
                if (e == 12306) {
                    pushService.getPushCallback().onGetPushStatus(bVar.g(), com.heytap.mcssdk.utils.Utils.parseInt(bVar.f()));
                    return;
                }
                if (e == 12309) {
                    pushService.getPushCallback().onGetNotificationStatus(bVar.g(), com.heytap.mcssdk.utils.Utils.parseInt(bVar.f()));
                    return;
                }
                if (e == 12289) {
                    if (bVar.g() == 0) {
                        pushService.setRegisterID(bVar.f());
                    }
                    pushService.getPushCallback().onRegister(bVar.g(), bVar.f());
                    return;
                }
                if (e == 12290) {
                    pushService.getPushCallback().onUnRegister(bVar.g());
                    return;
                }
                switch (e) {
                    case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                    case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                        com.heytap.msp.push.callback.ISetAppNotificationCallBackService pushSetAppNotificationCallBack = pushService.getPushSetAppNotificationCallBack();
                        if (pushSetAppNotificationCallBack != null) {
                            pushSetAppNotificationCallBack.onSetAppNotificationSwitch(bVar.g());
                            break;
                        }
                        break;
                    case com.heytap.mcssdk.constant.MessageConstant.CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                        try {
                            i = java.lang.Integer.parseInt(bVar.f());
                        } catch (java.lang.Exception unused) {
                            i = 0;
                        }
                        com.heytap.msp.push.callback.IGetAppNotificationCallBackService pushGetAppNotificationCallBack = pushService.getPushGetAppNotificationCallBack();
                        if (pushGetAppNotificationCallBack != null) {
                            pushGetAppNotificationCallBack.onGetAppNotificationSwitch(bVar.g(), i);
                            break;
                        }
                        break;
                }
            }
            str = "pushService.getPushCallback() is null , please check param of parseCommandMessage(2)";
        }
        com.heytap.mcssdk.utils.d.e(str);
    }

    @Override // com.heytap.mcssdk.e.c
    public void a(android.content.Context context, com.heytap.msp.push.mode.BaseMode baseMode, com.heytap.msp.push.callback.IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4105) {
            com.heytap.mcssdk.c.b bVar = (com.heytap.mcssdk.c.b) baseMode;
            com.heytap.mcssdk.utils.d.b("mcssdk-CallBackResultProcessor:" + bVar.toString());
            com.heytap.mcssdk.utils.f.b(new com.heytap.mcssdk.e.a.AnonymousClass1(bVar));
        }
    }
}
