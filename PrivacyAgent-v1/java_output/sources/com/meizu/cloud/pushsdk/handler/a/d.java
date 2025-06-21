package com.meizu.cloud.pushsdk.handler.a;

/* loaded from: classes23.dex */
public class d extends com.meizu.cloud.pushsdk.handler.a.a<java.lang.String> {
    public d(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 16;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(java.lang.String str, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() != null) {
            c().a(d(), str);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start RegisterMessageHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_REGISTER_ACTION.equals(intent.getAction()) || (com.meizu.cloud.pushsdk.constants.PushConstants.REGISTRATION_CALLBACK_INTENT.equals(intent.getAction()) && !android.text.TextUtils.isEmpty(intent.getStringExtra("registration_id")));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public java.lang.String c(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra("registration_id");
        com.meizu.cloud.pushsdk.util.b.g(d(), stringExtra, d().getPackageName());
        com.meizu.cloud.pushsdk.util.b.a(d(), 0, d().getPackageName());
        return stringExtra;
    }
}
