package com.vivo.push;

/* loaded from: classes19.dex */
final class i implements com.vivo.push.IPushActionListener {
    final /* synthetic */ com.vivo.push.e a;

    public i(com.vivo.push.e eVar) {
        this.a = eVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        com.vivo.push.util.b bVar;
        com.vivo.push.util.b bVar2;
        if (i != 0) {
            this.a.k = null;
            bVar = this.a.j;
            bVar.b("APP_TOKEN");
        } else {
            this.a.k = "";
            bVar2 = this.a.j;
            bVar2.a("APP_TOKEN", "");
            this.a.m();
            this.a.j.b("APP_TAGS");
        }
    }
}
