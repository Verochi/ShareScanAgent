package com.meizu.cloud.pushsdk.handler.a.d;

/* loaded from: classes23.dex */
public class e extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.handler.a.c.c> {
    public e(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 32768;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(com.meizu.cloud.pushsdk.handler.a.c.c cVar) {
        int c = cVar.c();
        if (c == -2) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_ACCESS_DENY");
            com.meizu.cloud.pushsdk.util.d.f(d(), cVar.a().getUploadDataPackageName(), cVar.a().getDeviceId(), cVar.a().getTaskId(), cVar.a().getSeqId(), cVar.a().getPushTimestamp(), cVar.a().getDelayedReportMillis());
            return;
        }
        if (c == -1) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_INBOX");
            com.meizu.cloud.pushsdk.util.d.c(d(), cVar.a().getUploadDataPackageName(), cVar.a().getDeviceId(), cVar.a().getTaskId(), cVar.a().getSeqId(), cVar.a().getPushTimestamp(), cVar.a().getDelayedReportMillis());
        } else if (c == 0) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_NORMAL");
            com.meizu.cloud.pushsdk.util.d.d(d(), cVar.a().getUploadDataPackageName(), cVar.a().getDeviceId(), cVar.a().getTaskId(), cVar.a().getSeqId(), cVar.a().getPushTimestamp(), cVar.a().getDelayedReportMillis());
        } else {
            if (c != 1) {
                return;
            }
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "notification STATE_NOTIFICATION_SHOW_FLOAT");
            com.meizu.cloud.pushsdk.util.d.e(d(), cVar.a().getUploadDataPackageName(), cVar.a().getDeviceId(), cVar.a().getTaskId(), cVar.a().getSeqId(), cVar.a().getPushTimestamp(), cVar.a().getDelayedReportMillis());
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.handler.a.c.c cVar, com.meizu.cloud.pushsdk.notification.c cVar2) {
        com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "store notification id " + cVar.b());
        com.meizu.cloud.pushsdk.notification.c.b.b(d(), cVar.a().getUploadDataPackageName(), cVar.b());
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start NotificationStateMessageHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_STATE.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.handler.a.c.c c(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_SHOW_PACKAGE_NAME);
        java.lang.String stringExtra2 = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_TASK_ID);
        java.lang.String stringExtra3 = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_SEQ_ID);
        java.lang.String stringExtra4 = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_DEVICE_ID);
        java.lang.String stringExtra5 = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.NOTIFICATION_EXTRA_PUSH_TIMESTAMP);
        java.lang.String stringExtra6 = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_NOTIFICATION_STATE_MESSAGE);
        boolean booleanExtra = intent.getBooleanExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_WHITE_LIST, false);
        long longExtra = intent.getLongExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_DELAYED_REPORT_MILLIS, 0L);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "current taskId " + stringExtra2 + " seqId " + stringExtra3 + " deviceId " + stringExtra4 + " packageName " + stringExtra);
        com.meizu.cloud.pushsdk.handler.a.c.c cVar = new com.meizu.cloud.pushsdk.handler.a.c.c(com.meizu.cloud.pushsdk.handler.MessageV3.parse(d().getPackageName(), stringExtra, stringExtra5, stringExtra4, stringExtra2, stringExtra3, stringExtra6, booleanExtra, longExtra));
        java.lang.String stringExtra7 = intent.getStringExtra("flyme:notification_pkg");
        int intExtra = intent.getIntExtra("flyme:notification_id", 0);
        int intExtra2 = intent.getIntExtra("flyme:notification_state", 0);
        cVar.a(intExtra);
        cVar.a(stringExtra7);
        cVar.b(intExtra2);
        return cVar;
    }
}
