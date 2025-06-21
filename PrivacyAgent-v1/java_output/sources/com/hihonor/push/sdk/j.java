package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class j implements com.hihonor.push.sdk.h {
    public final java.util.concurrent.atomic.AtomicInteger a = new java.util.concurrent.atomic.AtomicInteger(1);
    public final android.content.Context b;
    public volatile com.hihonor.push.framework.aidl.IPushInvoke c;
    public final com.hihonor.push.sdk.h.a d;
    public com.hihonor.push.sdk.l e;

    public j(android.content.Context context, com.hihonor.push.sdk.h.a aVar) {
        this.b = context;
        this.d = aVar;
    }

    public final void a(int i) {
        com.hihonor.push.sdk.common.logger.Logger.i("PushConnectionClient", "notifyFailed result: ".concat(java.lang.String.valueOf(i)));
        com.hihonor.push.sdk.h.a aVar = this.d;
        if (aVar != null) {
            com.hihonor.push.sdk.g.a aVar2 = (com.hihonor.push.sdk.g.a) aVar;
            if (android.os.Looper.myLooper() == com.hihonor.push.sdk.g.this.a.getLooper()) {
                aVar2.a(com.hihonor.push.sdk.common.data.ErrorEnum.fromCode(i));
            } else {
                com.hihonor.push.sdk.g.this.a.post(new com.hihonor.push.sdk.f(aVar2, i));
            }
        }
    }

    public boolean a() {
        return this.a.get() == 3 || this.a.get() == 4;
    }
}
