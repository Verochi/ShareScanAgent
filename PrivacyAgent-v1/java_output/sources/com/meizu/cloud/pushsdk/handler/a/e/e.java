package com.meizu.cloud.pushsdk.handler.a.e;

/* loaded from: classes23.dex */
public class e extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.platform.message.SubTagsStatus> {
    public e(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 2048;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.platform.message.SubTagsStatus subTagsStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || subTagsStatus == null) {
            return;
        }
        c().a(d(), subTagsStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start SubScribeTagsStatusHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.platform.message.SubTagsStatus c(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_MESSAGE_VALUE);
        return !android.text.TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.e(stringExtra) : (com.meizu.cloud.pushsdk.platform.message.SubTagsStatus) intent.getSerializableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS);
    }
}
