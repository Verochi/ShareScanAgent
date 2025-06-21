package com.meizu.cloud.pushsdk.c.e;

/* loaded from: classes23.dex */
public class d extends android.os.Handler {
    private final java.lang.ref.WeakReference<com.meizu.cloud.pushsdk.c.d.a> a;

    public d(com.meizu.cloud.pushsdk.c.d.a aVar) {
        super(android.os.Looper.getMainLooper());
        this.a = new java.lang.ref.WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        com.meizu.cloud.pushsdk.c.d.a aVar = this.a.get();
        if (message.what != 1) {
            super.handleMessage(message);
        } else if (aVar != null) {
            com.meizu.cloud.pushsdk.c.f.a aVar2 = (com.meizu.cloud.pushsdk.c.f.a) message.obj;
            aVar.a(aVar2.a, aVar2.b);
        }
    }
}
