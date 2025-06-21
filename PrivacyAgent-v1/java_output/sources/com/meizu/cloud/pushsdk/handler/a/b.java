package com.meizu.cloud.pushsdk.handler.a;

/* loaded from: classes23.dex */
public class b extends com.meizu.cloud.pushsdk.handler.a.c {
    public b(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (cVar != null) {
            cVar.b(messageV3);
            c().b(d(), com.meizu.cloud.pushsdk.handler.MzPushMessage.fromMessageV3(messageV3));
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start MessageV2Handler match");
        return a(0, g(intent)) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_SHOW.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d */
    public void b(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.b(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp(), messageV3.getDelayedReportMillis());
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: e */
    public void c(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.a(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp(), messageV3.getDelayedReportMillis());
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.c, com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l */
    public com.meizu.cloud.pushsdk.handler.MessageV3 c(android.content.Intent intent) {
        com.meizu.cloud.pushsdk.notification.MPushMessage mPushMessage = (com.meizu.cloud.pushsdk.notification.MPushMessage) intent.getSerializableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
        return com.meizu.cloud.pushsdk.handler.MessageV3.parse(g(intent), d(intent), mPushMessage.getTaskId(), mPushMessage);
    }
}
