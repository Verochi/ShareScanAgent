package com.meizu.cloud.pushsdk.handler.a.e;

/* loaded from: classes23.dex */
public class b extends com.meizu.cloud.pushsdk.handler.a.a<java.lang.String> {
    public b(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 16384;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(java.lang.String str, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || str == null) {
            return;
        }
        c().c(d(), str);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start ReceiveNotifyMessageHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_RESPONSE_NOTIFICATION_MESSAGE.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public java.lang.String c(android.content.Intent intent) {
        return intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_RESPONSE_NOTIFICATION_MESSAGE);
    }
}
