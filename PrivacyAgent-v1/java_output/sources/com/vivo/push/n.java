package com.vivo.push;

/* loaded from: classes19.dex */
final class n extends android.os.Handler {
    public n(android.os.Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        java.lang.Object obj = message.obj;
        if (obj instanceof com.vivo.push.l) {
            com.vivo.push.l lVar = (com.vivo.push.l) obj;
            com.vivo.push.util.p.c("PushClientThread", "PushClientThread-handleMessage, task = ".concat(java.lang.String.valueOf(lVar)));
            lVar.run();
        }
    }
}
