package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class bs extends android.os.Handler {
    final /* synthetic */ com.xiaomi.push.service.c a;

    public bs(com.xiaomi.push.service.c cVar) {
        this.a = cVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        java.lang.String str;
        super.handleMessage(message);
        if (message != null) {
            try {
                int i = message.what;
                if (i == 17) {
                    java.lang.Object obj = message.obj;
                    if (obj != null) {
                        this.a.onStart((android.content.Intent) obj, 1);
                    }
                } else if (i == 18) {
                    android.os.Message obtain = android.os.Message.obtain((android.os.Handler) null, 0);
                    obtain.what = 18;
                    android.os.Bundle bundle = new android.os.Bundle();
                    str = this.a.k;
                    bundle.putString("xmsf_region", str);
                    obtain.setData(bundle);
                    message.replyTo.send(obtain);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }
}
