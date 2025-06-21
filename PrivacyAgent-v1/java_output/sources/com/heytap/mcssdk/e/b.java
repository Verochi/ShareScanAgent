package com.heytap.mcssdk.e;

/* loaded from: classes22.dex */
public class b implements com.heytap.mcssdk.e.c {
    private static final int a = 1;

    /* renamed from: com.heytap.mcssdk.e.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.heytap.msp.push.mode.DataMessage a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ com.heytap.msp.push.callback.IDataMessageCallBackService c;

        public AnonymousClass1(com.heytap.msp.push.mode.DataMessage dataMessage, android.content.Context context, com.heytap.msp.push.callback.IDataMessageCallBackService iDataMessageCallBackService) {
            this.a = dataMessage;
            this.b = context;
            this.c = iDataMessageCallBackService;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getMsgCommand() == 1) {
                com.heytap.mcssdk.e.b.this.a(this.b, this.a);
            } else {
                this.c.processMessage(this.b, this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.content.Context context, com.heytap.msp.push.mode.DataMessage dataMessage) {
        if (context == null) {
            com.heytap.mcssdk.utils.d.b(com.anythink.expressad.foundation.g.b.b.a);
            return;
        }
        com.heytap.mcssdk.utils.d.b("Receive revokeMessage  extra : " + dataMessage.getStatisticsExtra() + "notifyId :" + dataMessage.getNotifyID() + "messageId : " + dataMessage.getTaskID());
        ((android.app.NotificationManager) context.getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION)).cancel(dataMessage.getNotifyID());
        b(context, dataMessage);
    }

    private void b(android.content.Context context, com.heytap.msp.push.mode.DataMessage dataMessage) {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(dataMessage);
        hashMap.put(dataMessage.getEventId(), arrayList);
        com.heytap.msp.push.statis.StatisticUtils.statisticEvent(context, hashMap);
    }

    @Override // com.heytap.mcssdk.e.c
    public void a(android.content.Context context, com.heytap.msp.push.mode.BaseMode baseMode, com.heytap.msp.push.callback.IDataMessageCallBackService iDataMessageCallBackService) {
        if (baseMode != null && baseMode.getType() == 4103) {
            com.heytap.msp.push.mode.DataMessage dataMessage = (com.heytap.msp.push.mode.DataMessage) baseMode;
            if (iDataMessageCallBackService != null) {
                com.heytap.mcssdk.utils.f.b(new com.heytap.mcssdk.e.b.AnonymousClass1(dataMessage, context, iDataMessageCallBackService));
            }
        }
    }
}
