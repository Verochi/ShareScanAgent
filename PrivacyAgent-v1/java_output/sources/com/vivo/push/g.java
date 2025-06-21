package com.vivo.push;

/* loaded from: classes19.dex */
final class g implements com.vivo.push.IPushActionListener {
    final /* synthetic */ com.vivo.push.e.a a;
    final /* synthetic */ com.vivo.push.e b;

    public g(com.vivo.push.e eVar, com.vivo.push.e.a aVar) {
        this.b = eVar;
        this.a = aVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.b bVar;
        if (i != 0) {
            this.b.k = null;
            bVar = this.b.j;
            bVar.b("APP_TOKEN");
        } else {
            java.lang.Object[] b = this.a.b();
            if (b == null || b.length == 0) {
                com.vivo.push.util.p.a("PushClientManager", "bind app result is null");
            } else {
                this.b.a((java.lang.String) this.a.b()[0]);
            }
        }
    }
}
