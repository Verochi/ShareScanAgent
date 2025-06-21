package com.sijla.f;

/* loaded from: classes19.dex */
final class b extends android.os.Handler {
    private /* synthetic */ com.sijla.f.a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(com.sijla.f.a aVar, android.os.Looper looper) {
        super(looper);
        this.a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
        } else {
            this.a.a();
        }
    }
}
