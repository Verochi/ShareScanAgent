package com.heytap.mcssdk;

/* loaded from: classes22.dex */
public class b {

    /* renamed from: com.heytap.mcssdk.b$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ android.content.Intent b;
        final /* synthetic */ com.heytap.msp.push.callback.IDataMessageCallBackService c;

        public AnonymousClass1(android.content.Context context, android.content.Intent intent, com.heytap.msp.push.callback.IDataMessageCallBackService iDataMessageCallBackService) {
            this.a = context;
            this.b = intent;
            this.c = iDataMessageCallBackService;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.List<com.heytap.msp.push.mode.BaseMode> a = com.heytap.mcssdk.d.c.a(this.a, this.b);
            if (a == null) {
                return;
            }
            for (com.heytap.msp.push.mode.BaseMode baseMode : a) {
                if (baseMode != null) {
                    for (com.heytap.mcssdk.e.c cVar : com.heytap.mcssdk.PushService.getInstance().getProcessors()) {
                        if (cVar != null) {
                            cVar.a(this.a, baseMode, this.c);
                        }
                    }
                }
            }
        }
    }

    public static void a(android.content.Context context, android.content.Intent intent, com.heytap.msp.push.callback.IDataMessageCallBackService iDataMessageCallBackService) {
        if (context == null) {
            com.heytap.mcssdk.utils.d.e("context is null , please check param of parseIntent()");
            return;
        }
        if (intent == null) {
            com.heytap.mcssdk.utils.d.e("intent is null , please check param of parseIntent()");
            return;
        }
        if (iDataMessageCallBackService == null) {
            com.heytap.mcssdk.utils.d.e("callback is null , please check param of parseIntent()");
        } else if (com.heytap.mcssdk.utils.Utils.isSupportPushByClient(context)) {
            com.heytap.mcssdk.utils.f.a(new com.heytap.mcssdk.b.AnonymousClass1(context, intent, iDataMessageCallBackService));
        } else {
            com.heytap.mcssdk.utils.d.e("push is null ,please check system has push");
        }
    }
}
