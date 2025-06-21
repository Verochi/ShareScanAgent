package com.meizu.cloud.pushsdk.handler.a.e;

/* loaded from: classes23.dex */
public class f extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus> {
    public f(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 1024;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus unRegisterStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || unRegisterStatus == null) {
            return;
        }
        c().a(d(), unRegisterStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start UnRegisterStatusHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_UNREGISTER_STATUS.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus c(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_MESSAGE_VALUE);
        com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus b = !android.text.TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.b(stringExtra) : (com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus) intent.getSerializableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_UNREGISTER_STATUS);
        if (b.isUnRegisterSuccess()) {
            com.meizu.cloud.pushsdk.util.b.g(d(), "", d().getPackageName());
        }
        return b;
    }
}
