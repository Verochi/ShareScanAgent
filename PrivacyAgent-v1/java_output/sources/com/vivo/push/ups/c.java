package com.vivo.push.ups;

/* loaded from: classes19.dex */
final class c implements com.vivo.push.IPushActionListener {
    final /* synthetic */ com.vivo.push.ups.UPSTurnCallback a;
    final /* synthetic */ com.vivo.push.ups.VUpsManager b;

    public c(com.vivo.push.ups.VUpsManager vUpsManager, com.vivo.push.ups.UPSTurnCallback uPSTurnCallback) {
        this.b = vUpsManager;
        this.a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.a.onResult(new com.vivo.push.ups.CodeResult(i));
    }
}
