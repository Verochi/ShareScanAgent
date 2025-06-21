package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class t extends android.os.Handler {
    public java.lang.ref.WeakReference<com.huawei.hms.push.t.a> a;

    public interface a {
        void handleMessage(android.os.Message message);
    }

    public t(com.huawei.hms.push.t.a aVar) {
        this.a = new java.lang.ref.WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        super.handleMessage(message);
        com.huawei.hms.push.t.a aVar = this.a.get();
        if (aVar != null) {
            aVar.handleMessage(message);
        }
    }
}
