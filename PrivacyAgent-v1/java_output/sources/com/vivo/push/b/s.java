package com.vivo.push.b;

/* loaded from: classes19.dex */
public class s extends com.vivo.push.o {
    private java.lang.String a;
    private int b;

    public s(int i) {
        super(i);
        this.a = null;
        this.b = 0;
    }

    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        aVar.a(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId, this.a);
        aVar.a("status_msg_code", this.b);
    }

    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        this.a = aVar.a(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.reqId);
        this.b = aVar.b("status_msg_code", this.b);
    }

    public final java.lang.String g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    @Override // com.vivo.push.o
    public java.lang.String toString() {
        return "OnReceiveCommand";
    }
}
