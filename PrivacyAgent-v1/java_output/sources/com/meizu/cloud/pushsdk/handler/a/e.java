package com.meizu.cloud.pushsdk.handler.a;

/* loaded from: classes23.dex */
public class e extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.handler.MessageV3> {
    public e(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 8;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || messageV3 == null || android.text.TextUtils.isEmpty(messageV3.getThroughMessage())) {
            return;
        }
        c().b(d(), messageV3.getThroughMessage());
        c().a(d(), messageV3.getThroughMessage(), com.meizu.cloud.pushsdk.handler.a.c.d.a().a(messageV3.getTaskId()).b(messageV3.getSeqId()).c(messageV3.getPushTimestamp()).d(messageV3.getDeviceId()).a().b());
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start ThroughMessageHandler match");
        if (!a(1, g(intent))) {
            return false;
        }
        if (com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            if ("message".equals(k(intent))) {
                return true;
            }
            if (android.text.TextUtils.isEmpty(k(intent))) {
                java.lang.String stringExtra = intent.getStringExtra("message");
                if (!android.text.TextUtils.isEmpty(stringExtra) && !a(stringExtra)) {
                    return true;
                }
            }
        }
        return com.meizu.cloud.pushsdk.constants.PushConstants.C2DM_INTENT.equals(intent.getAction());
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        if (messageV3 == null || android.text.TextUtils.isEmpty(messageV3.getDeviceId()) || android.text.TextUtils.isEmpty(messageV3.getTaskId())) {
            return;
        }
        java.lang.String b = b(messageV3.getThroughMessage());
        if (android.text.TextUtils.isEmpty(b)) {
            com.meizu.cloud.pushsdk.util.d.c(d(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
        } else {
            com.meizu.cloud.pushsdk.util.d.c(d(), b, messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.handler.MessageV3 c(android.content.Intent intent) {
        com.meizu.cloud.pushsdk.handler.MessageV3 messageV3 = new com.meizu.cloud.pushsdk.handler.MessageV3();
        if (com.meizu.cloud.pushsdk.constants.PushConstants.C2DM_INTENT.equals(intent.getAction())) {
            c().a(d(), intent);
            return null;
        }
        messageV3.setThroughMessage(intent.getStringExtra("message"));
        messageV3.setTaskId(e(intent));
        messageV3.setDeviceId(d(intent));
        messageV3.setSeqId(f(intent));
        messageV3.setPushTimestamp(h(intent));
        messageV3.setUploadDataPackageName(g(intent));
        return messageV3;
    }
}
