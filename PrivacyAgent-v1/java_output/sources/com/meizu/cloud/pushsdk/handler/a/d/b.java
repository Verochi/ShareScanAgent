package com.meizu.cloud.pushsdk.handler.a.d;

/* loaded from: classes23.dex */
public class b extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.handler.MessageV3> {
    private android.content.Context a;

    public b(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
        this.a = context;
    }

    private android.content.Intent b(android.content.Context context, com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        android.content.Intent intent;
        java.lang.String uriPackageName = messageV3.getUriPackageName();
        if (android.text.TextUtils.isEmpty(uriPackageName)) {
            uriPackageName = messageV3.getUploadDataPackageName();
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "openClassName is " + uriPackageName);
        if (messageV3.getClickType() == 0) {
            intent = context.getPackageManager().getLaunchIntentForPackage(uriPackageName);
            if (intent != null && messageV3.getParamsMap() != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : messageV3.getParamsMap().entrySet()) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", " launcher activity key " + entry.getKey() + " value " + entry.getValue());
                    if (!android.text.TextUtils.isEmpty(entry.getKey()) && !android.text.TextUtils.isEmpty(entry.getValue())) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                }
            }
        } else if (1 == messageV3.getClickType()) {
            intent = new android.content.Intent();
            if (messageV3.getParamsMap() != null) {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : messageV3.getParamsMap().entrySet()) {
                    com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", " key " + entry2.getKey() + " value " + entry2.getValue());
                    if (!android.text.TextUtils.isEmpty(entry2.getKey()) && !android.text.TextUtils.isEmpty(entry2.getValue())) {
                        intent.putExtra(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            intent.setClassName(uriPackageName, messageV3.getActivity());
            com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", intent.toUri(1));
        } else if (2 == messageV3.getClickType()) {
            android.content.Intent intent2 = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(messageV3.getWebUrl()));
            java.lang.String uriPackageName2 = messageV3.getUriPackageName();
            if (!android.text.TextUtils.isEmpty(uriPackageName2)) {
                intent2.setPackage(uriPackageName2);
                com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "set uri package " + uriPackageName2);
            }
            intent = intent2;
        } else {
            if (3 == messageV3.getClickType()) {
                com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "CLICK_TYPE_SELF_DEFINE_ACTION");
            }
            intent = null;
        }
        if (intent != null) {
            intent.putExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PLATFORM_EXTRA, com.meizu.cloud.pushsdk.handler.a.c.d.a().a(messageV3.getTaskId()).a().b());
        }
        return intent;
    }

    private com.meizu.cloud.pushsdk.handler.MessageV3 c(java.lang.String str) {
        return com.meizu.cloud.pushsdk.handler.d.a(str);
    }

    private void e(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.b.a(d(), messageV3.getPackageName(), 0);
        android.content.Intent b = b(d(), messageV3);
        if (b != null) {
            b.addFlags(268435456);
            try {
                d().startActivity(b);
            } catch (java.lang.Exception e) {
                com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "Click message StartActivity error " + e.getMessage());
            }
        }
    }

    private com.meizu.cloud.pushsdk.handler.MessageV3 m(android.content.Intent intent) {
        com.meizu.cloud.pushsdk.notification.MPushMessage mPushMessage;
        java.lang.String g;
        java.lang.String d;
        java.lang.String taskId;
        try {
            try {
                com.meizu.cloud.pushsdk.handler.MessageV3 messageV3 = (com.meizu.cloud.pushsdk.handler.MessageV3) intent.getParcelableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
                if (messageV3 != null) {
                    return messageV3;
                }
            } catch (java.lang.Exception unused) {
                com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "cannot get messageV3");
            }
            return com.meizu.cloud.pushsdk.handler.MessageV3.parse(g, d, taskId, mPushMessage);
        } finally {
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "parse MessageV2 to MessageV3");
            mPushMessage = (com.meizu.cloud.pushsdk.notification.MPushMessage) intent.getSerializableExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE);
            com.meizu.cloud.pushsdk.handler.MessageV3.parse(g(intent), d(intent), mPushMessage.getTaskId(), mPushMessage);
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 64;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (messageV3 == null) {
            return;
        }
        e(messageV3);
        if (!android.text.TextUtils.isEmpty(messageV3.getTitle()) && !android.text.TextUtils.isEmpty(messageV3.getContent()) && c() != null) {
            c().a(d(), com.meizu.cloud.pushsdk.handler.MzPushMessage.fromMessageV3(messageV3));
        }
        b(messageV3);
        a(this.a, messageV3);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start NotificationClickMessageHandler match");
        return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3, java.lang.String str) {
        return a(messageV3, str);
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(com.meizu.cloud.pushsdk.handler.MessageV3 messageV3) {
        com.meizu.cloud.pushsdk.util.d.d(d(), messageV3.getUploadDataPackageName(), android.text.TextUtils.isEmpty(messageV3.getDeviceId()) ? d((android.content.Intent) null) : messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp());
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.handler.MessageV3 c(android.content.Intent intent) {
        com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "parse message V3");
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_MESSAGE_VALUE);
        return !android.text.TextUtils.isEmpty(stringExtra) ? c(stringExtra) : m(intent);
    }
}
