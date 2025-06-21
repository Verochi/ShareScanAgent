package com.vivo.push.b;

/* loaded from: classes19.dex */
public final class i extends com.vivo.push.b.s {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;

    public i(int i) {
        super(i);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("app_id", this.a);
        aVar.a(com.tencent.connect.common.Constants.PARAM_CLIENT_ID, this.b);
        aVar.a("client_token", this.c);
    }

    public final java.lang.String d() {
        return this.a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.a = aVar.a("app_id");
        this.b = aVar.a(com.tencent.connect.common.Constants.PARAM_CLIENT_ID);
        this.c = aVar.a("client_token");
    }

    public final java.lang.String e() {
        return this.c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.o
    public final java.lang.String toString() {
        return "OnBindCommand";
    }
}
