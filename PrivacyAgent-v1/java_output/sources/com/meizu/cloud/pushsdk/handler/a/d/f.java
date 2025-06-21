package com.meizu.cloud.pushsdk.handler.a.d;

/* loaded from: classes23.dex */
public class f extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.handler.a.c.h> {
    public f(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 262144;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(com.meizu.cloud.pushsdk.handler.a.c.h hVar) {
        com.meizu.cloud.pushsdk.util.d.b(d(), hVar.c(), hVar.a().b().d(), hVar.a().b().a(), hVar.a().b().e(), hVar.a().b().b());
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.handler.a.c.h hVar, com.meizu.cloud.pushsdk.notification.c cVar) {
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) d().getSystemService(com.huawei.hms.push.constant.RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null) {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "start cancel notification id " + hVar.b());
            notificationManager.cancel(hVar.b());
            com.meizu.cloud.pushsdk.handler.a.a.a b = com.meizu.cloud.pushsdk.b.a(d()).b();
            if (b != null) {
                b.a(hVar.b());
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        int i;
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start WithDrawMessageHandler match");
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        if (!android.text.TextUtils.isEmpty(stringExtra)) {
            com.meizu.cloud.pushsdk.handler.a.c.b a = com.meizu.cloud.pushsdk.handler.a.c.b.a(stringExtra);
            if (a.a() != null) {
                i = a.a().a();
                return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && "4".equals(java.lang.String.valueOf(i));
            }
        }
        i = 0;
        if (com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            return false;
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.handler.a.c.h c(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        java.lang.String stringExtra2 = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new com.meizu.cloud.pushsdk.handler.a.c.h(intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE), g(intent), stringExtra, intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}
