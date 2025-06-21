package com.meizu.cloud.pushsdk.handler.a.e;

/* loaded from: classes23.dex */
public class c extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.platform.message.RegisterStatus> {

    /* renamed from: com.meizu.cloud.pushsdk.handler.a.e.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.meizu.cloud.pushsdk.handler.a.e.c.this.e();
        }
    }

    public c(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        java.lang.String mzPushServicePackageName = com.meizu.cloud.pushsdk.util.MzSystemUtils.getMzPushServicePackageName(d());
        if (com.meizu.cloud.pushsdk.util.b.l(d(), mzPushServicePackageName)) {
            com.meizu.cloud.pushsdk.util.b.c(d(), mzPushServicePackageName, false);
            if (android.text.TextUtils.isEmpty(com.meizu.cloud.pushsdk.util.b.k(d(), mzPushServicePackageName))) {
                java.lang.String b = b();
                if (android.text.TextUtils.isEmpty(b)) {
                    return;
                }
                com.meizu.cloud.pushsdk.util.b.k(d(), mzPushServicePackageName, b);
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 512;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void c(com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus) {
        com.meizu.cloud.pushsdk.b.c.a.a().execute(new com.meizu.cloud.pushsdk.handler.a.e.c.AnonymousClass1());
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.platform.message.RegisterStatus registerStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || registerStatus == null) {
            return;
        }
        c().a(d(), registerStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start RegisterStatusHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_REGISTER_STATUS.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.RegisterStatus c(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_MESSAGE_VALUE);
        com.meizu.cloud.pushsdk.platform.message.RegisterStatus a = !android.text.TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.a(stringExtra) : (com.meizu.cloud.pushsdk.platform.message.RegisterStatus) intent.getSerializableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_REGISTER_STATUS);
        if (!android.text.TextUtils.isEmpty(a.getPushId())) {
            com.meizu.cloud.pushsdk.util.b.g(d(), a.getPushId(), d().getPackageName());
            com.meizu.cloud.pushsdk.util.b.a(d(), (int) ((java.lang.System.currentTimeMillis() / 1000) + a.getExpireTime()), d().getPackageName());
        }
        return a;
    }
}
