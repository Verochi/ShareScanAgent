package com.vivo.push.ups;

/* loaded from: classes19.dex */
final class b implements com.vivo.push.IPushActionListener {
    final /* synthetic */ com.vivo.push.ups.UPSRegisterCallback a;
    final /* synthetic */ com.vivo.push.ups.VUpsManager b;

    public b(com.vivo.push.ups.VUpsManager vUpsManager, com.vivo.push.ups.UPSRegisterCallback uPSRegisterCallback) {
        this.b = vUpsManager;
        this.a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.a.onResult(new com.vivo.push.ups.TokenResult(i, ""));
    }
}
