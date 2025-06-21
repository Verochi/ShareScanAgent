package com.vivo.push;

/* loaded from: classes19.dex */
final class c implements android.os.Handler.Callback {
    final /* synthetic */ com.vivo.push.b a;

    public c(com.vivo.push.b bVar) {
        this.a = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
    
        if (r5.get() == 2) goto L15;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean handleMessage(android.os.Message message) {
        java.util.concurrent.atomic.AtomicInteger atomicInteger;
        java.util.concurrent.atomic.AtomicInteger atomicInteger2;
        if (message == null) {
            com.vivo.push.util.p.a("AidlManager", "handleMessage error : msg is null");
            return false;
        }
        int i = message.what;
        if (i == 1) {
            com.vivo.push.util.p.a("AidlManager", "In connect, bind core service time out");
            atomicInteger = this.a.f;
        } else if (i != 2) {
            com.vivo.push.util.p.b("AidlManager", "unknow msg what [" + message.what + "]");
        } else {
            atomicInteger2 = this.a.f;
            if (atomicInteger2.get() == 4) {
                this.a.f();
            }
            this.a.a(1);
        }
        return true;
    }
}
