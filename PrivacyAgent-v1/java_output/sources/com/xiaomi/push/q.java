package com.xiaomi.push;

/* loaded from: classes19.dex */
final class q extends android.os.Handler {
    final /* synthetic */ com.xiaomi.push.p a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(com.xiaomi.push.p pVar, android.os.Looper looper) {
        super(looper);
        this.a = pVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        com.xiaomi.push.p.b bVar = (com.xiaomi.push.p.b) message.obj;
        int i = message.what;
        if (i != 0 && i == 1) {
            bVar.b();
        }
        super.handleMessage(message);
    }
}
