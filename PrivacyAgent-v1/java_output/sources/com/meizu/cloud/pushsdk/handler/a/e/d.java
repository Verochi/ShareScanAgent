package com.meizu.cloud.pushsdk.handler.a.e;

/* loaded from: classes23.dex */
public class d extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.platform.message.SubAliasStatus> {
    public d(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    private void c(java.lang.String str) {
        com.meizu.cloud.pushsdk.util.b.h(d(), d().getPackageName(), str);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 4096;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.platform.message.SubAliasStatus subAliasStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || subAliasStatus == null) {
            return;
        }
        c().a(d(), subAliasStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start SubScribeAliasStatusHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.SubAliasStatus c(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_MESSAGE_VALUE);
        com.meizu.cloud.pushsdk.platform.message.SubAliasStatus d = !android.text.TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.d(stringExtra) : (com.meizu.cloud.pushsdk.platform.message.SubAliasStatus) intent.getSerializableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS);
        if (com.meizu.cloud.pushsdk.platform.message.BasicPushStatus.SUCCESS_CODE.equals(d.getCode())) {
            c(d.getAlias());
        }
        return d;
    }
}
