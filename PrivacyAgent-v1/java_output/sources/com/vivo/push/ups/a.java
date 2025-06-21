package com.vivo.push.ups;

/* loaded from: classes19.dex */
final class a implements com.vivo.push.IPushActionListener {
    final /* synthetic */ com.vivo.push.ups.UPSRegisterCallback a;
    final /* synthetic */ android.content.Context b;
    final /* synthetic */ com.vivo.push.ups.VUpsManager c;

    public a(com.vivo.push.ups.VUpsManager vUpsManager, com.vivo.push.ups.UPSRegisterCallback uPSRegisterCallback, android.content.Context context) {
        this.c = vUpsManager;
        this.a = uPSRegisterCallback;
        this.b = context;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.a.onResult(new com.vivo.push.ups.TokenResult(i, com.vivo.push.PushClient.getInstance(this.b).getRegId()));
    }
}
