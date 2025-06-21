package com.meizu.cloud.pushsdk.handler.a.b;

/* loaded from: classes23.dex */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<com.meizu.cloud.pushsdk.handler.a.c.g> {
    public a(android.content.Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 65536;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(com.meizu.cloud.pushsdk.handler.a.c.g gVar) {
        com.meizu.cloud.pushsdk.util.d.b(d(), d().getPackageName(), gVar.d().b().d(), gVar.d().b().a(), gVar.d().b().e(), gVar.d().b().b());
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(com.meizu.cloud.pushsdk.handler.a.c.g gVar, com.meizu.cloud.pushsdk.notification.c cVar) {
        java.lang.String str;
        java.lang.String message;
        java.lang.String str2;
        com.meizu.cloud.pushinternal.DebugLogger.flush();
        java.lang.String a = gVar.d().b().a();
        java.lang.String d = gVar.d().b().d();
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            str = com.meizu.cloud.pushsdk.util.MzSystemUtils.getDocumentsPath(d()) + "/pushSdktmp/" + a + "_" + d + ".zip";
        } else {
            str = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdktmp/" + a + "_" + d + ".zip";
        }
        java.io.File file = null;
        try {
            new com.meizu.cloud.pushsdk.handler.a.b.b(str).a(gVar.c());
            java.io.File file2 = new java.io.File(str);
            message = null;
            file = file2;
        } catch (java.lang.Exception e) {
            message = e.getMessage();
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "zip error message " + message);
        }
        if (file != null && file.length() / 1024 > gVar.a()) {
            message = "the upload file exceeds the max size";
        } else if (gVar.b() && !com.meizu.cloud.pushsdk.util.a.b(d())) {
            message = "current network not allowed upload log file";
        }
        com.meizu.cloud.pushsdk.c.a.c<java.lang.String> a2 = com.meizu.cloud.pushsdk.platform.a.b.a(d()).a(gVar.d().b().a(), gVar.d().b().d(), message, file);
        if (a2 != null && a2.b()) {
            if (file != null) {
                file.delete();
            }
            com.meizu.cloud.pushinternal.DebugLogger.e("AbstractMessageHandler", "upload success " + a2.a());
            return;
        }
        if (a2 != null) {
            str2 = "upload error code " + a2.c() + a2.a();
        } else {
            str2 = "upload error";
        }
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", str2);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(android.content.Intent intent) {
        int i;
        com.meizu.cloud.pushinternal.DebugLogger.i("AbstractMessageHandler", "start LogUploadMessageHandler match");
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        if (!android.text.TextUtils.isEmpty(stringExtra)) {
            com.meizu.cloud.pushsdk.handler.a.c.b a = com.meizu.cloud.pushsdk.handler.a.c.b.a(stringExtra);
            if (a.a() != null) {
                i = a.a().a();
                return com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && "2".equals(java.lang.String.valueOf(i));
            }
        }
        i = 0;
        if (com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            return false;
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public com.meizu.cloud.pushsdk.handler.a.c.g c(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        java.lang.String stringExtra2 = intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new com.meizu.cloud.pushsdk.handler.a.c.g(intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_PRIVATE_MESSAGE), stringExtra, intent.getStringExtra(com.meizu.cloud.pushsdk.constants.PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}
