package com.meizu.cloud.pushsdk.handler.a.d;

/* loaded from: classes23.dex */
public class d extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.handler.MessageV3> {
    private android.content.Context a;

    public d(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
        this.a = context;
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 128;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (messageV3 == null) {
            return;
        }
        if (c() == null) {
            c().c(d(), com.meizu.cloud.pushsdk.handler.MzPushMessage.fromMessageV3(messageV3));
        }
        c(messageV3);
        a(this.a, messageV3);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start NotificationDeleteMessageHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_NOTIFICATION_DELETE.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.a(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.handler.MessageV3 c(android.content.Intent intent) {
        return (com.meizu.cloud.pushsdk.handler.MessageV3) intent.getParcelableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
    }
}
