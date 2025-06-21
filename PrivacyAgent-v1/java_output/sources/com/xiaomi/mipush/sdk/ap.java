package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
class ap extends android.os.Handler {
    final /* synthetic */ com.xiaomi.mipush.sdk.ao a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(com.xiaomi.mipush.sdk.ao aoVar, android.os.Looper looper) {
        super(looper);
        this.a = aoVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(android.os.Message message) {
        android.content.Context context;
        android.content.Context context2;
        android.content.Context context3;
        android.content.Context context4;
        com.xiaomi.mipush.sdk.ao aoVar;
        android.content.Context context5;
        java.util.HashMap<java.lang.String, java.lang.String> m145a;
        android.content.Context context6;
        android.content.Context context7;
        android.content.Context context8;
        android.content.Context context9;
        android.content.Context context10;
        android.content.Context context11;
        android.content.Context context12;
        com.xiaomi.mipush.sdk.ao aoVar2;
        android.content.Context context13;
        android.content.Context context14;
        if (message.what != 19) {
            return;
        }
        java.lang.String str = (java.lang.String) message.obj;
        int i = message.arg1;
        synchronized (com.xiaomi.mipush.sdk.af.class) {
            context = this.a.f28a;
            if (com.xiaomi.mipush.sdk.af.a(context).m106a(str)) {
                context2 = this.a.f28a;
                if (com.xiaomi.mipush.sdk.af.a(context2).a(str) < 10) {
                    com.xiaomi.mipush.sdk.au auVar = com.xiaomi.mipush.sdk.au.DISABLE_PUSH;
                    if (auVar.ordinal() == i) {
                        context14 = this.a.f28a;
                        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context14).a(auVar))) {
                            aoVar2 = this.a;
                            aoVar2.a(str, auVar, true, (java.util.HashMap<java.lang.String, java.lang.String>) null);
                            context13 = this.a.f28a;
                            com.xiaomi.mipush.sdk.af.a(context13).b(str);
                        }
                    }
                    auVar = com.xiaomi.mipush.sdk.au.ENABLE_PUSH;
                    if (auVar.ordinal() == i) {
                        context12 = this.a.f28a;
                        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context12).a(auVar))) {
                            aoVar2 = this.a;
                            aoVar2.a(str, auVar, true, (java.util.HashMap<java.lang.String, java.lang.String>) null);
                            context13 = this.a.f28a;
                            com.xiaomi.mipush.sdk.af.a(context13).b(str);
                        }
                    }
                    com.xiaomi.mipush.sdk.au auVar2 = com.xiaomi.mipush.sdk.au.UPLOAD_HUAWEI_TOKEN;
                    if (auVar2.ordinal() == i) {
                        context10 = this.a.f28a;
                        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context10).a(auVar2))) {
                            aoVar = this.a;
                            context11 = aoVar.f28a;
                            m145a = com.xiaomi.mipush.sdk.i.m145a(context11, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_HUAWEI);
                            aoVar.a(str, auVar2, false, (java.util.HashMap<java.lang.String, java.lang.String>) m145a);
                            context13 = this.a.f28a;
                            com.xiaomi.mipush.sdk.af.a(context13).b(str);
                        }
                    }
                    auVar2 = com.xiaomi.mipush.sdk.au.UPLOAD_FCM_TOKEN;
                    if (auVar2.ordinal() == i) {
                        context8 = this.a.f28a;
                        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context8).a(auVar2))) {
                            aoVar = this.a;
                            context9 = aoVar.f28a;
                            m145a = com.xiaomi.mipush.sdk.i.m145a(context9, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FCM);
                            aoVar.a(str, auVar2, false, (java.util.HashMap<java.lang.String, java.lang.String>) m145a);
                            context13 = this.a.f28a;
                            com.xiaomi.mipush.sdk.af.a(context13).b(str);
                        }
                    }
                    auVar2 = com.xiaomi.mipush.sdk.au.UPLOAD_COS_TOKEN;
                    if (auVar2.ordinal() == i) {
                        context6 = this.a.f28a;
                        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context6).a(auVar2))) {
                            aoVar = this.a;
                            context7 = aoVar.f28a;
                            m145a = com.xiaomi.mipush.sdk.i.m145a(context7, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_COS);
                            aoVar.a(str, auVar2, false, (java.util.HashMap<java.lang.String, java.lang.String>) m145a);
                            context13 = this.a.f28a;
                            com.xiaomi.mipush.sdk.af.a(context13).b(str);
                        }
                    }
                    auVar2 = com.xiaomi.mipush.sdk.au.UPLOAD_FTOS_TOKEN;
                    if (auVar2.ordinal() == i) {
                        context4 = this.a.f28a;
                        if ("syncing".equals(com.xiaomi.mipush.sdk.af.a(context4).a(auVar2))) {
                            aoVar = this.a;
                            context5 = aoVar.f28a;
                            m145a = com.xiaomi.mipush.sdk.i.m145a(context5, com.xiaomi.mipush.sdk.e.ASSEMBLE_PUSH_FTOS);
                            aoVar.a(str, auVar2, false, (java.util.HashMap<java.lang.String, java.lang.String>) m145a);
                        }
                    }
                    context13 = this.a.f28a;
                    com.xiaomi.mipush.sdk.af.a(context13).b(str);
                } else {
                    context3 = this.a.f28a;
                    com.xiaomi.mipush.sdk.af.a(context3).c(str);
                }
            }
        }
    }
}
