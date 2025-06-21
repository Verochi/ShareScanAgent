package com.meizu.cloud.pushsdk.handler.a;

/* loaded from: classes23.dex */
public class f extends com.meizu.cloud.pushsdk.handler.a.a<java.lang.Boolean> {
    public f(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 32;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(java.lang.Boolean bool, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() != null) {
            c().a(d(), bool.booleanValue());
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start UnRegisterMessageHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_UNREGISTER_ACTION.equals(intent.getAction()) || (com.meizu.cloud.pushsdk.constants.PushConstants.REQUEST_UNREGISTER_INTENT.equals(intent.getAction()) && android.text.TextUtils.isEmpty(intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_UNREGISTERED)));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public java.lang.Boolean c(android.content.Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_IS_UNREGISTER_SUCCESS, false);
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_REGISTRATION_ERROR);
        java.lang.String stringExtra2 = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_UNREGISTERED);
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "processUnRegisterCallback 5.0:" + booleanExtra + " 4.0:" + stringExtra + " 3.0:" + stringExtra2);
        if (!android.text.TextUtils.isEmpty(stringExtra) && !booleanExtra && android.text.TextUtils.isEmpty(stringExtra2)) {
            return java.lang.Boolean.FALSE;
        }
        com.meizu.cloud.pushsdk.util.b.g(d(), "", d().getPackageName());
        return java.lang.Boolean.TRUE;
    }
}
