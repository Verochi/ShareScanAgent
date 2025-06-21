package com.heytap.msp.push.service;

/* loaded from: classes22.dex */
public class DataMessageCallbackService extends android.app.Service implements com.heytap.msp.push.callback.IDataMessageCallBackService {
    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(android.content.Intent intent, int i, int i2) {
        com.heytap.mcssdk.PushService.getInstance().innerInit(getApplicationContext());
        com.heytap.mcssdk.b.a(getApplicationContext(), intent, this);
        return 2;
    }

    @Override // com.heytap.msp.push.callback.IDataMessageCallBackService
    public void processMessage(android.content.Context context, com.heytap.msp.push.mode.DataMessage dataMessage) {
        com.heytap.mcssdk.utils.d.b("Receive DataMessageCallbackService:messageTitle: " + dataMessage.getTitle() + " ------content:" + dataMessage.getContent() + "------describe:" + dataMessage.getDescription());
    }
}
