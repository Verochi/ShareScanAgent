package com.meizu.cloud.pushsdk.handler.a.e;

/* loaded from: classes23.dex */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus> {
    public a(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 256;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus pushSwitchStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || pushSwitchStatus == null) {
            return;
        }
        c().a(d(), pushSwitchStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start PushSwitchStatusHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus c(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_MESSAGE_VALUE);
        com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus c = !android.text.TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.c(stringExtra) : (com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus) intent.getSerializableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS);
        if (com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(c.getCode())) {
            java.lang.String g = g(intent);
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "PushSwitchStatusHandler update local " + g + " switch status " + c);
            com.meizu.cloud.pushsdk.util.b.a(d(), g, c.isSwitchNotificationMessage());
            com.meizu.cloud.pushsdk.util.b.b(d(), g, c.isSwitchThroughMessage());
        }
        return c;
    }
}
